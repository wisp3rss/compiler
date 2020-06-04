package com.asia.compiler.parser.visitors;

import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.MathArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langParser.Math_moduleContext;
import com.asia.compiler.parser.gen.langParser.Math_varContext;
import com.asia.compiler.parser.utils.CancellationExceptionFactory;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class MathArgsVisitor {

    private VariableMap variableMap;

    public Tuple3<Object, Object, MathArgType> visitMathArgs(Math_moduleContext ctx, Type type) {
        Tuple2<Object, Boolean> left = visitValueNode(ctx.math_var(0), type);
        Tuple2<Object, Boolean> right = visitValueNode(ctx.math_var(1), type);

        MathArgType argType = getArgType(left._2(), right._2());

        return Tuple.of(left._1(), right._1(), argType);
    }

    private MathArgType getArgType(Boolean left, Boolean right) {
        if (left && right)
            return MathArgType.VAR_VAR;
        if (left && !right)
            return MathArgType.VAR_NUM;
        if (!left && right)
            return MathArgType.NUM_VAR;

        return MathArgType.NUM_NUM;
    }

    private Tuple2<Object, Boolean> visitValueNode(Math_varContext ctx, Type type) {

        if (ctx.NAME() != null) {
            return visitVariableNode(ctx, type);
        } else if (ctx.numeric_value().INT() != null) {
            return visitIntNode(ctx, type);
        } else if (ctx.numeric_value().FLOAT() != null) {
            return visitFloatNode(ctx, type);
        }

        return Tuple.of(null, false);
    }

    private Tuple2<Object, Boolean> visitVariableNode(Math_varContext ctx, Type type) {
        String variable = ctx.NAME().getText();

        if (variableMap.getVariableTypesMap().containsKey(variable)) {
            if (!variableMap.getVariableTypesMap().get(variable).equals(type)) {
                CancellationExceptionFactory.throwCancellationException(ctx, "Cannot cast " + variable + " with type " + variableMap.getVariableTypesMap().get(variable)
                    + " with type " + type.getValue());
            } else {
                return Tuple.of(variable, true);
            }
        } else {
            CancellationExceptionFactory.throwCancellationException(ctx, "Variable " + variable + " is undefined");
        }

        return Tuple.of(null, null);
    }

    private Tuple2<Object, Boolean> visitIntNode(Math_varContext ctx, Type type) {
        /* Incompatible types, return error */
        if (!type.equals(Type.INT)) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Cannot cast INT to " + type.toString());
            return Tuple.of(null, false);
        }

        return Tuple.of(ctx.numeric_value().INT().getText(), false);
    }

    private Tuple2<Object, Boolean> visitFloatNode(Math_varContext ctx, Type type) {
        /* Incompatible types, return error */
        if (!type.equals(Type.FLOAT)) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Cannot cast FLOAT to " + type.toString());
            return Tuple.of(null, false);
        }

        return Tuple.of(ctx.numeric_value().FLOAT().getText(), false);
    }
}
