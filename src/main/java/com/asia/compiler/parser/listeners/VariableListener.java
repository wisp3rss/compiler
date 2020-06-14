package com.asia.compiler.parser.listeners;

import static com.asia.compiler.common.utils.Instructions.ASSIGN;
import static com.asia.compiler.common.utils.Instructions.DECLARE;
import static com.asia.compiler.common.utils.Instructions.FOR_BODY;

import com.asia.compiler.common.model.ClassManager;
import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.IntermediateObjectsData;
import com.asia.compiler.common.model.LabelStack;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.Assign_varContext;
import com.asia.compiler.parser.gen.langParser.Def_varContext;
import com.asia.compiler.parser.gen.langParser.For_loopContext;
import com.asia.compiler.parser.gen.langParser.For_loop_assignContext;
import com.asia.compiler.parser.gen.langParser.Numeric_valueContext;
import com.asia.compiler.parser.gen.langParser.ValueContext;
import com.asia.compiler.parser.utils.CancellationExceptionFactory;
import com.asia.compiler.parser.visitors.MathArgsHelper;
import io.vavr.Tuple2;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VariableListener extends langBaseListener {

    private VariableMap variableMap;
    private LabelStack labelStack;
    private IntermediateObjectsData data;
    private ClassManager classManager;

    private List<IntermediateObject> getIntermediateObjList() {
        return classManager.getIsInFunction() ? data.getFunctionIntermediateObjectList() : data.getIntermediateObjectList();
    }

    @Override
    public void exitAssign_var(Assign_varContext ctx) {
        String varName = ctx.for_loop_assign().NAME().getText();

        if (!variableMap.getVariableTypesMap().containsKey(varName)) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Variable " + varName + " undefined.");
            return;
        }

        if (ctx.for_loop_assign().operation().init_var() != null) {
            assignInitVar(ctx.for_loop_assign());
        } else if (ctx.for_loop_assign().operation().math_module() != null) {
            MathArgsHelper mathArgsHelper = new MathArgsHelper(variableMap, getIntermediateObjList());
            mathArgsHelper.handleAssignMath(ctx.for_loop_assign(), varName, variableMap.getVariableTypesMap().get(varName));
        }
    }

    @Override
    public void exitFor_loop_assign(For_loop_assignContext ctx) {
        String varName = ctx.NAME().getText();

        if (!variableMap.getVariableTypesMap().containsKey(varName)) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Variable " + varName + " undefined.");
            return;
        }

        if (ctx.operation().init_var() != null) {
            assignInitVar(ctx);
        } else if (ctx.operation().math_module() != null) {
            MathArgsHelper mathArgsHelper = new MathArgsHelper(variableMap, getIntermediateObjList());
            mathArgsHelper.handleAssignMath(ctx, varName, variableMap.getVariableTypesMap().get(varName));
        }

        if(ctx.parent instanceof For_loopContext && ((For_loopContext) ctx.parent).FOR() != null){
            For_loopContext parent = (For_loopContext) ctx.parent;
            if(parent.for_loop_assign().indexOf(ctx) == 1){
                String label = labelStack.getLabelStack().peek();
                getIntermediateObjList().add(new IntermediateObject<>(
                    FOR_BODY, Type.NULL, (label + "_cond"), (label + "_body"), 0, ArgType.NULL, new Tuple2<>(null, null)));
            }
        }
    }

    private void assignInitVar(For_loop_assignContext ctx) {
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

    private void assignNumericValue(For_loop_assignContext ctx) {
        if (getNumeric_valueContext(ctx).INT() != null) {
            handleAssignConstant(ctx, Type.INT);
        } else if (getNumeric_valueContext(ctx).FLOAT() != null) {
            handleAssignConstant(ctx, Type.FLOAT);
        }
    }

    private ValueContext getInitVar_value(For_loop_assignContext ctx) {
        return ctx.operation().init_var().value();
    }

    private Numeric_valueContext getNumeric_valueContext(For_loop_assignContext ctx) {
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

        String name = ctx.NAME().getText();

        if (variableMap.getVariableTypesMap().containsKey(name) || null == t) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Variable " + name + " already defined.");
        }

        variableMap.addVariable(ctx.NAME().getText(), t);
        getIntermediateObjList().add(new IntermediateObject<>(DECLARE, t, ctx.NAME().getText(), "", 0, null, null));
    }

    private void handleAssignConstant(For_loop_assignContext ctx, Type t) {
        String varName = ctx.NAME().getText();
        if (!variableMap.getVariableTypesMap().get(varName).equals(t)) {
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

        getIntermediateObjList().add(new IntermediateObject<>(
            ASSIGN,
            t,
            varName,
            "",
            value,
            null,
            null)
        );
    }

    private void handleAssignVariable(For_loop_assignContext ctx) {
        String leftVar = ctx.NAME().getText();
        String rightVar = getInitVar_value(ctx).NAME().getText();

        /* Check if left variable exist */
        if (variableMap.getVariableTypesMap().get(leftVar) == null) {
            CancellationExceptionFactory.throwCancellationException(ctx, leftVar + " is undefined");
            return;
        }
        /* Check if right variable exist */
        if (variableMap.getVariableTypesMap().get(rightVar) == null) {
            CancellationExceptionFactory.throwCancellationException(ctx, rightVar + " is undefined");
            return;
        }
        /* Check types */
        if (!variableMap.getVariableTypesMap().get(leftVar).equals(variableMap.getVariableTypesMap().get(rightVar))) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Incompatible types between " + leftVar + " and " + rightVar);
            return;
        }

        getIntermediateObjList().add(new IntermediateObject<>(
            ASSIGN,
            variableMap.getVariableTypesMap().get(leftVar),
            leftVar,
            rightVar,
            0,
            ArgType.NULL,
            new Tuple2<>(null, null)
        ));
    }

}
