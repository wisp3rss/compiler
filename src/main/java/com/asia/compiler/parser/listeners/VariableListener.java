package com.asia.compiler.parser.listeners;

import static com.asia.compiler.common.utils.Instructions.ADD;
import static com.asia.compiler.common.utils.Instructions.ASSIGN;
import static com.asia.compiler.common.utils.Instructions.DECLARE;
import static com.asia.compiler.common.utils.Instructions.DIV;
import static com.asia.compiler.common.utils.Instructions.MOD;
import static com.asia.compiler.common.utils.Instructions.MUL;
import static com.asia.compiler.common.utils.Instructions.SUB;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.utils.Instructions;
import com.asia.compiler.common.utils.MathArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.Assign_varContext;
import com.asia.compiler.parser.gen.langParser.Def_varContext;
import com.asia.compiler.parser.gen.langParser.Numeric_valueContext;
import com.asia.compiler.parser.gen.langParser.ValueContext;
import com.asia.compiler.parser.utils.CancellationExceptionFactory;
import com.asia.compiler.parser.visitors.MathArgsVisitor;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VariableListener extends langBaseListener {

    private List<IntermediateObject> intermediateObjectList;
    private Map<String, Type> variableTypesMap;

    @Override
    public void exitAssign_var(Assign_varContext ctx) {
        String varName = ctx.NAME().getText();

        if (!variableTypesMap.containsKey(varName)) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Variable " + varName + " undefined.");
            return;
        }

        if (ctx.operation().init_var() != null) {
            assignInitVar(ctx);
        } else if (ctx.operation().math_module() != null) {
            handleAssignMath(ctx, varName, variableTypesMap.get(varName));
        }
    }

    private void assignInitVar(Assign_varContext ctx) {
        ValueContext valueContext = getInitVar_value(ctx);

        if (valueContext.NAME() != null) {
            handleAssignVariable(ctx);
        } else if (getNumeric_valueContext(ctx) != null) {
            assignNumericValue(ctx);
        } else if (valueContext.STRING() != null) {
            handleAssignConstant(ctx, Type.STRING);
        } else if (valueContext.TRUE() != null) {
            handleAssignConstant(ctx, Type.BOOL);
        } else if (valueContext.FALSE() != null) {
            handleAssignConstant(ctx, Type.BOOL);
        }
    }

    private void assignNumericValue(Assign_varContext ctx) {
        if (getNumeric_valueContext(ctx).INT() != null) {
            handleAssignConstant(ctx, Type.INT);
        } else if (getNumeric_valueContext(ctx).FLOAT() != null) {
            handleAssignConstant(ctx, Type.FLOAT);
        }
    }

    private ValueContext getInitVar_value(Assign_varContext ctx) {
        return ctx.operation().init_var().value();
    }

    private Numeric_valueContext getNumeric_valueContext(Assign_varContext ctx) {
        return getInitVar_value(ctx).numeric_value();
    }

    @Override
    public void exitDef_var(Def_varContext ctx) {
        Type t = null;
        if (ctx.define().DEF_INT() != null) {
            t = Type.INT;
        } else if (ctx.define().DEF_FLOAT() != null) {
            t = Type.FLOAT;
        } else if (ctx.define().DEF_STRING() != null) {
            t = Type.STRING;
        } else if (ctx.define().DEF_BOOL() != null) {
            t = Type.BOOL;
        }

        if (variableTypesMap.containsKey(ctx.NAME().getText()) || null == t) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Variable " + ctx.NAME().getText() + "  already defined.");
        }

        variableTypesMap.put(ctx.NAME().getText(), t);
        intermediateObjectList.add(new IntermediateObject<>(DECLARE, t, ctx.NAME().getText(), "", 0, null, null));
    }

    private void handleAssignConstant(Assign_varContext ctx, Type t) {
        String varName = ctx.NAME().getText();
        if (!variableTypesMap.get(varName).equals(t)) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Variable " + varName + "  incompatible.");
            return;
        }

        String value = "";

        if (getNumeric_valueContext(ctx) != null) {
            if (getNumeric_valueContext(ctx).INT() != null) {
                value = getNumeric_valueContext(ctx).INT().getText();
            } else if (getNumeric_valueContext(ctx).FLOAT() != null) {
                value = getNumeric_valueContext(ctx).FLOAT().getText();
            }
        } else if (getInitVar_value(ctx).STRING() != null) {
            value = getInitVar_value(ctx).STRING().getText();
        } else if (getInitVar_value(ctx).TRUE() != null) {
            value = getInitVar_value(ctx).TRUE().getText();
        } else if (getInitVar_value(ctx).FALSE() != null) {
            value = getInitVar_value(ctx).FALSE().getText();
        }

        intermediateObjectList.add(new IntermediateObject<>(
            ASSIGN,
            t,
            varName,
            "",
            value,
            null,
            null)
        );
    }

    private void handleAssignVariable(Assign_varContext ctx) {
        String leftVar = ctx.NAME().getText();
        String rightVar = getInitVar_value(ctx).NAME().getText();

        /* Check if left variable exist */
        if (variableTypesMap.get(leftVar) == null) {
            CancellationExceptionFactory.throwCancellationException(ctx, leftVar + " is undefined");
            return;
        }
        /* Check if right variable exist */
        if (variableTypesMap.get(rightVar) == null) {
            CancellationExceptionFactory.throwCancellationException(ctx, rightVar + " is undefined");
            return;
        }
        /* Check types */
        if (!variableTypesMap.get(leftVar).equals(variableTypesMap.get(rightVar))) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Incompatible types between " + leftVar + " and " + rightVar);
            return;
        }

        intermediateObjectList.add(new IntermediateObject<>(
            ASSIGN,
            variableTypesMap.get(leftVar),
            leftVar,
            rightVar,
            0,
            MathArgType.NULL,
            new Tuple2<>(null, null)
        ));
    }

    private void handleAssignMath(Assign_varContext ctx, String varName, Type type) {

        MathArgsVisitor mathArgsVisitor = MathArgsVisitor.of(variableTypesMap);

        Tuple3<Object, Object, MathArgType> arguments = mathArgsVisitor.visitMathArgs(ctx.operation().math_module(), type);

        switch (ctx.operation().math_module().op.getText()) {
            case "+":
                createMathIntermediateObject(arguments, ADD, varName, type);
                break;
            case "-":
                createMathIntermediateObject(arguments, SUB, varName, type);
                break;
            case "*":
                createMathIntermediateObject(arguments, MUL, varName, type);
                break;
            case "/":
                createMathIntermediateObject(arguments, DIV, varName, type);
                break;
            case "%":
                createMathIntermediateObject(arguments, MOD, varName, type);
                break;
        }
    }

    private void createMathIntermediateObject(Tuple3<Object, Object, MathArgType> arguments, Instructions instruction, String varName, Type type) {
        intermediateObjectList.add(new IntermediateObject<>(
            instruction,
            type,
            varName,
            "",
            0,
            arguments._3(),
            new Tuple2<>(arguments._1(), arguments._2())
        ));
    }
}
