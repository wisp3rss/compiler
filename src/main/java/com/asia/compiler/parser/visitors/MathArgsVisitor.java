package com.asia.compiler.parser.visitors;

import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langParser.Math_moduleContext;
import com.asia.compiler.parser.gen.langParser.Math_varContext;
import com.asia.compiler.parser.utils.CancellationExceptionFactory;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import io.vavr.Tuple4;
import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class MathArgsVisitor {

    private final VariableMap variableMap;

    public Tuple3<String, String, ArgType> visitMathArgs(Math_moduleContext ctx, Type type) {
        Tuple2<String, Boolean> left = visitValueNode(ctx.math_var(0), type);
        Tuple2<String, Boolean> right = visitValueNode(ctx.math_var(1), type);

        ArgType argType = getArgType(left._2(), right._2());

        return Tuple.of(left._1(), right._1(), argType);
    }

    public Tuple4<String, String, ArgType, Type> visitMathArgs(Math_moduleContext ctx) {
        Type typeL = getType(ctx.math_var(0));
        Type typeR = getType(ctx.math_var(1));

        if (typeL == typeR) {
            Tuple2<String, Boolean> left = visitValueNode(ctx.math_var(0), typeL);
            Tuple2<String, Boolean> right = visitValueNode(ctx.math_var(1), typeR);

            ArgType argType = getArgType(left._2(), right._2());

            return Tuple.of(left._1(), right._1(), argType, typeL);
        }

        return Tuple.of(null, null, null, null);
    }

    private Type getType(Math_varContext math_var) {
        if (math_var.NAME() != null) {
            return variableMap.getVariableTypesMap().get(math_var.NAME().getText());
        } else if (math_var.numeric_value().INT() != null) {
            return Type.INT;
        } else if (math_var.numeric_value().FLOAT() != null) {
            return Type.FLOAT;
        }
        return Type.NULL;
    }

    private ArgType getArgType(Boolean left, Boolean right) {
        if (left && right) {
            return ArgType.VAR_VAR;
        }
        if (left && !right) {
            return ArgType.VAR_NUM;
        }
        if (!left && right) {
            return ArgType.NUM_VAR;
        }

        return ArgType.NUM_NUM;
    }

    private Tuple2<String, Boolean> visitValueNode(Math_varContext ctx, Type type) {

        if (ctx.NAME() != null) {
            return visitVariableNode(ctx, type);
        } else if (ctx.numeric_value().INT() != null) {
            return visitIntNode(ctx, type);
        } else if (ctx.numeric_value().FLOAT() != null) {
            return visitFloatNode(ctx, type);
        }

        return Tuple.of(null, false);
    }

    private Tuple2<String, Boolean> visitVariableNode(Math_varContext ctx, Type type) {
        String variable = ctx.NAME().getText();

        if (variableMap.getVariableTypesMap().containsKey(variable)) {
            if (!variableMap.getVariableTypesMap().get(variable).equals(type)) {
                CancellationExceptionFactory
                    .throwCancellationException(ctx, "Cannot cast " + variable + " with type " + variableMap.getVariableTypesMap().get(variable)
                        + " with type " + type.getValue());
            } else {
                return Tuple.of(variable, true);
            }
        } else {
            CancellationExceptionFactory.throwCancellationException(ctx, "Variable " + variable + " is undefined");
        }

        return Tuple.of(null, null);
    }

    private Tuple2<String, Boolean> visitIntNode(Math_varContext ctx, Type type) {
        /* Incompatible types, return error */
        if (!type.equals(Type.INT)) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Cannot cast INT to " + type.toString());
            return Tuple.of(null, false);
        }

        return Tuple.of(ctx.numeric_value().INT().getText(), false);
    }

    private Tuple2<String, Boolean> visitFloatNode(Math_varContext ctx, Type type) {
        /* Incompatible types, return error */
        if (!type.equals(Type.FLOAT)) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Cannot cast FLOAT to " + type.toString());
            return Tuple.of(null, false);
        }

        return Tuple.of(ctx.numeric_value().FLOAT().getText(), false);
    }
}
