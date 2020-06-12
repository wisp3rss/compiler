package com.asia.compiler.parser.visitors;

import static com.asia.compiler.common.utils.Instructions.CONDITION_EXTENDED;
import static com.asia.compiler.common.utils.Instructions.CONDITION_SIMPLE;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langParser.ConditionContext;
import com.asia.compiler.parser.utils.CancellationExceptionFactory;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class ConditionVisitor {

    private VariableMap variableMap;

    public List<IntermediateObject> visitConditionNode(ConditionContext ctx, String label, String endLabel) {
        List<IntermediateObject> localIntermediateObjectList = new ArrayList<>();

        if (ctx.bool() != null) {
            if (ctx.bool().TRUE() != null) {
                int trueVal = ctx.NOT() != null ? 0: 1;
                localIntermediateObjectList
                    .add(new IntermediateObject<>(CONDITION_SIMPLE, Type.BOOL, label, endLabel, trueVal, ArgType.NULL, new Tuple2<>(null, null)));
            } else if (ctx.bool().FALSE() != null) {
                int falseVal = ctx.NOT() != null ? 1: 0;
                localIntermediateObjectList
                    .add(new IntermediateObject<>(CONDITION_SIMPLE, Type.BOOL, label, endLabel, falseVal, ArgType.NULL, new Tuple2<>(null, null)));
            }

        } else {

            Tuple3<String, Type, Integer> left = visitNode(ctx, 0);
            Tuple3<String, Type, Integer> right = visitNode(ctx, 1);

            if (!left._2.equals(right._2)) {
                CancellationExceptionFactory.throwCancellationException(ctx, "Variable incompatible.");
                return Collections.emptyList();
            }

            Tuple2<String, String> arguments = Tuple.of(left._1, right._1);
            ArgType argType = getArgType(left._3, right._3);
            localIntermediateObjectList.add(handleCondition(ctx, arguments, left._2, label, endLabel, argType));

        }
        return localIntermediateObjectList;
    }

    private Tuple3<String, Type, Integer> visitNode(ConditionContext ctx, int index) {

        if (ctx.value(index) != null) {
            return visitValueNode(ctx, index);
        } else if (ctx.math_module(index) != null) {
            //return visitMathModule(ctx);
        }

        return Tuple.of(null, null, null);
    }

    private Tuple3<String, Type, Integer> visitValueNode(ConditionContext ctx, int index) {

        if (ctx.value(index).NAME() != null) {
                return visitVariableNode(ctx, index);
            } else if (ctx.value(index).STRING() != null) {
                return visitStringNode(ctx, index);
            } else if (ctx.value(index).TRUE() != null || ctx.value(index).FALSE() != null) {
                return visitBoolNode(ctx, index);
            } else if (ctx.value(index).numeric_value() != null) {
                return visitNumericValueNode(ctx, index);
        }

        return Tuple.of(null, null, null);
    }

    //TODO match_module handler
//    private Tuple2<String, Type> visitMathModule(Assign_varContext ctx, int index) {
//        String varName =  "";
//        MathArgsHelper mathArgsHelper = new MathArgsHelper(variableMap, intermediateObjectList);
//        mathArgsHelper.handleAssignMath(ctx, varName, variableMap.getVariableTypesMap().get(varName));
//
//        return Tuple.of(null, null);
//    }

    private Tuple3<String, Type, Integer> visitNumericValueNode(ConditionContext ctx, int index) {

        if (ctx.value(index).numeric_value().INT() != null) {
            return visitIntNode(ctx, index);
        } else if (ctx.value(index).numeric_value().FLOAT() != null) {
            return visitFloatNode(ctx, index);
        }

        return Tuple.of(null, null, null);
    }

    private Tuple3<String, Type, Integer> visitFloatNode(ConditionContext ctx, int index) {
        String variable = ctx.value(index).numeric_value().FLOAT().getText();
        return Tuple.of(variable, Type.FLOAT, 0);
    }

    private Tuple3<String, Type, Integer> visitIntNode(ConditionContext ctx, int index) {
        String variable = ctx.value(index).numeric_value().INT().getText();
        return Tuple.of(variable, Type.INT, 0);
    }

    private Tuple3<String, Type, Integer> visitBoolNode(ConditionContext ctx, int index) {

        if (ctx.value(index).TRUE() != null) {
            return visitTrueNode(ctx, index);
        } else if (ctx.value(index).FALSE() != null) {
            return visitFalseNode(ctx, index);
        }

        return Tuple.of(null, null, null);
    }

    private Tuple3<String, Type, Integer> visitFalseNode(ConditionContext ctx, int index) {
        String variable = ctx.value(index).FALSE().getText();
        return Tuple.of(variable, Type.BOOL, 3);
    }

    private Tuple3<String, Type, Integer> visitTrueNode(ConditionContext ctx, int index) {
        String variable = ctx.value(index).TRUE().getText();
        return Tuple.of(variable, Type.BOOL, 3);
    }

    private Tuple3<String, Type, Integer> visitStringNode(ConditionContext ctx, int index) {
        String variable = ctx.value(index).STRING().getText();
        return Tuple.of(variable, Type.STRING, 2);
    }

    private Tuple3<String, Type, Integer> visitVariableNode(ConditionContext ctx, int index) {

        String variable = ctx.value(index).NAME().getText();

        if (variableMap.getVariableTypesMap().containsKey(variable)) {
            Type type = variableMap.getVariableTypesMap().get(variable);
            return Tuple.of(variable, type, 1);
        } else {
            CancellationExceptionFactory.throwCancellationException(ctx, "Variable " + variable + " is undefined");
        }

        return Tuple.of(null, null, null);
    }

    private IntermediateObject createConditionIntermediateObject(Tuple2<String, String> arguments, Type type, String value, String label, String endLabel,
        ArgType argType) {
        return new IntermediateObject<>(
            CONDITION_EXTENDED,
            type,
            label,
            endLabel,
            value,
            argType,
            new Tuple2<>(arguments._1(), arguments._2())
        );
    }

    private IntermediateObject handleCondition(ConditionContext ctx, Tuple2<String, String> arguments, Type type, String label, String endLabel,
        ArgType argType) {
        return createConditionIntermediateObject(arguments, type, ctx.comp.getText(), label, endLabel, argType);
    }

    private ArgType getArgType(int left, int right) {

            /*
                0 - num
                1 - var
                2 - string
                3 - bool
             */

        if (left == 1 && right == 0) {
            return ArgType.VAR_NUM;
        }
        if (left == 0 && right == 1) {
            return ArgType.NUM_VAR;
        }
        if (left == 1 && right == 1) {
            return ArgType.VAR_VAR;
        }
        if (left == 2 && right == 2) {
            return ArgType.STR_STR;
        }
        if (left == 3 && right == 3) {
            return ArgType.BUL_BUL;
        }

        return ArgType.NUM_NUM;
    }

}
