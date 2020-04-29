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
        Type t;
        String varName = ctx.NAME().getText();

        if (!variableTypesMap.containsKey(varName)) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Variable " + varName + " undefined.");
            return;
        }

        if (ctx.operation().init_var() != null) {
            if (ctx.operation().init_var().value().NAME() != null) {
                handleAssignVariable(ctx);
            } else if (ctx.operation().init_var().value().numeric_value().INT() != null) {
                handleAssignConstant(ctx, Type.INT);
            } else if (ctx.operation().init_var().value().numeric_value().FLOAT() != null) {
                handleAssignConstant(ctx, Type.FLOAT);
            } else if (ctx.operation().init_var().value().STRING() != null) {
                handleAssignConstant(ctx, Type.STRING);
            }
        } else if (ctx.operation().math_module() != null) {
            handleAssignMath(ctx, varName, variableTypesMap.get(varName));
        }
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

        if (ctx.operation().init_var().value().numeric_value() != null) {
            if (ctx.operation().init_var().value().numeric_value().INT() != null)
                value = ctx.operation().init_var().value().numeric_value().INT().getText();
            else if (ctx.operation().init_var().value().numeric_value().FLOAT() != null)
                value = ctx.operation().init_var().value().numeric_value().FLOAT().getText();
        } else if (ctx.operation().init_var().value().STRING() != null) {
            value = ctx.operation().init_var().value().STRING().getText();
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
        String rightVar = ctx.operation().init_var().value().NAME().getText();

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
