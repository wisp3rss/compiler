package com.asia.compiler.parser.listeners;

import static com.asia.compiler.common.utils.Instructions.CALL_FUNC;
import static com.asia.compiler.common.utils.Instructions.FUNC_BEGIN;
import static com.asia.compiler.common.utils.Instructions.FUNC_RETURN;
import static com.asia.compiler.common.utils.Type.BOOL;
import static com.asia.compiler.common.utils.Type.FLOAT;
import static com.asia.compiler.common.utils.Type.INT;
import static com.asia.compiler.common.utils.Type.NULL;
import static com.asia.compiler.common.utils.Type.STRING;

import com.asia.compiler.common.model.ClassManager;
import com.asia.compiler.common.model.Field;
import com.asia.compiler.common.model.Function;
import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.IntermediateObjectsData;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.Call_class_fieldContext;
import com.asia.compiler.parser.gen.langParser.Call_class_funcContext;
import com.asia.compiler.parser.gen.langParser.Call_funcContext;
import com.asia.compiler.parser.gen.langParser.Call_structContext;
import com.asia.compiler.parser.gen.langParser.Def_argsContext;
import com.asia.compiler.parser.gen.langParser.Def_funcContext;
import com.asia.compiler.parser.gen.langParser.Numeric_valueContext;
import com.asia.compiler.parser.gen.langParser.ValueContext;
import com.asia.compiler.parser.utils.CancellationExceptionFactory;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FunctionListener extends langBaseListener {

    @NonNull
    private final IntermediateObjectsData data;
    @NonNull
    private final ClassManager classManager;
    private int beginFunctionIndex = 0;
    @NonNull
    private final VariableMap variableMap;

    private List<IntermediateObject> getIntermediateObjList() {
        return classManager.getIsInFunction() ? data.getFunctionIntermediateObjectList() : data.getIntermediateObjectList();
    }

    @Override
    public void exitDef_args(Def_argsContext ctx) {
//        Map<String, List<Function>> classMap = classManager.getClassMap().get(classManager.getCurrentDefClass());
//        String type = ctx.getParent().getChild(1).getChild(0).getText();
//        String funcName = ctx.getParent().getChild(2).getText();

        List<Type> argTypes = ctx.def_arg().stream().map(o -> classManager.getType(o.define())).collect(Collectors.toList());
        List<String> argsName = ctx.def_arg().stream().map(o -> o.NAME().getText()).collect(Collectors.toList());

        IntStream.iterate(0, i -> i + 1).limit(argTypes.size()).forEach(i -> variableMap.addVariable(argsName.get(i), argTypes.get(i)));
    }

    @Override
    public void enterDef_func(Def_funcContext ctx) {
        variableMap.incrementLevel();
        classManager.setIsInFunction(true);
        beginFunctionIndex = data.getFunctionIntermediateObjectList().size();
    }

    @Override
    public void exitDef_func(Def_funcContext ctx) {
        Type funcType = classManager.getType(ctx.define());

        List<Type> types = ctx.def_args().def_arg().stream().map(a -> classManager.getType(a.define())).collect(Collectors.toList());

        getIntermediateObjList().add(beginFunctionIndex, new IntermediateObject(FUNC_BEGIN, funcType, ctx.NAME().getText(), "", types, ArgType.NULL,
            new Tuple2<>(null, null)));

        Tuple2<String, Type> returnVal = getValueType(ctx.ret().value(), ctx.NAME().getText());
        if (funcType == returnVal._2) {
            getIntermediateObjList().add(
                new IntermediateObject<>(FUNC_RETURN, funcType, returnVal._1, returnVal._2.getValue(), 0, ArgType.NULL,
                    new Tuple2<>(null, null)));
        } else {
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Incompatible type of return value:" + ctx.NAME().getText() + ". Expected type: " + funcType.getStringValue());
            return;
        }

        classManager.setIsInFunction(false);
        variableMap.decrementLevel();
    }

    private Tuple2<String, Type> getValueType(ValueContext ctx, String funcName) {
        if (ctx.NAME() != null) {
            return handleGetVarType(ctx);
        } else if (ctx.TRUE() != null || ctx.FALSE() != null) {
            return Tuple.of(ctx.TRUE().getText(), BOOL);
        } else if (ctx.numeric_value() != null) {
            return handleGetNumType(ctx.numeric_value());
        } else if (ctx.STRING() != null) {
            return Tuple.of(ctx.STRING().getText(), STRING);
        } else if (ctx.call_struct() != null) {
            return handleGetStructType(ctx.call_struct(), funcName);
        } else if (ctx.call_class_field() != null) {
            return handleGetClassType(ctx.call_class_field(), funcName);
        }
        return Tuple.of("", NULL);
    }

    private Tuple2<String, Type> handleGetVarType(ValueContext ctx) {

        if (variableMap.getVariableTypesMap().containsKey(ctx.NAME().getText())) {
            Type type = variableMap.getVariableTypesMap().get(ctx.NAME().getText());
            return Tuple.of(ctx.NAME().getText(), type);
        } else if (variableMap.getVariableTypesMap().containsKey(ctx.NAME().getText())) {
            Type type = variableMap.getVariableTypesMap().get(ctx.NAME().getText());
            return Tuple.of(ctx.NAME().getText(), type);
        } else {
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Undeclared return value:" + ctx.NAME().getText());
            return Tuple.of("", NULL);
        }
    }

    private Tuple2<String, Type> handleGetNumType(Numeric_valueContext ctx) {
        if (ctx.INT() != null) {
            return Tuple.of(ctx.INT().getText(), INT);
        } else if (ctx.FLOAT() != null) {
            return Tuple.of(ctx.FLOAT().getText(), FLOAT);
        } else {
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Incompatible type of return numeric value.");
            return Tuple.of("", NULL);
        }
    }

    private Tuple2<String, Type> handleGetStructType(Call_structContext ctx, String funcName) {

        if (!classManager.getStructMap().containsKey(ctx.NAME(0).getText())) {
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Undefined struct:" + ctx.NAME(0).getText() + "in class \"" + funcName + "\".");
            return Tuple.of("", NULL);
        }

        return classManager.getStructMap().get(ctx.NAME(0).getText())
            .stream()
            .map(Field::getName)
            .filter(n -> n.equals(ctx.NAME(1).getText()))
            .findFirst()
            .map(n -> Tuple.of(n, variableMap.getVariableTypesMap().get(n)))
            .map(tuple -> Tuple.of(ctx.NAME(0).getText() + "." + tuple._1(), tuple._2()))
            .orElseGet(() -> {
                CancellationExceptionFactory
                    .throwCancellationException(ctx,
                        "Incompatible type of value:" + ctx.NAME(0).getText() + "." + ctx.NAME(1).getText() + ", Expected type: " + classManager.getStructMap()
                            .get(ctx.NAME(0).getText()).toString());
                return Tuple.of("", NULL);
            });
    }

    private Tuple2<String, Type> handleGetClassType(Call_class_fieldContext ctx, String funcName) {

        if (!classManager.getStructMap().containsKey(ctx.NAME(0).getText())) {
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Undefined class:" + ctx.NAME(0).getText() + "in class \"" + funcName + "\".");
            return Tuple.of("", NULL);
        }

        return classManager.getStructMap().get(ctx.NAME(0).getText())
            .stream()
            .map(Field::getName)
            .filter(n -> n.equals(ctx.NAME(1).getText()))
            .findFirst()
            .map(n -> Tuple.of(n, variableMap.getVariableTypesMap().get(n)))
            .map(tuple -> Tuple.of(ctx.NAME(0).getText() + "." + tuple._1(), tuple._2()))
            .orElseGet(() -> {
                CancellationExceptionFactory
                    .throwCancellationException(ctx,
                        "Incompatible type of value:" + ctx.NAME(0).getText() + "." + ctx.NAME(1).getText() + ", Expected type: " + classManager.getStructMap()
                            .get(ctx.NAME(0).getText()).toString());
                return Tuple.of("", NULL);
            });
    }

    @Override
    public void exitCall_func(Call_funcContext ctx) {
        String funcName = ctx.NAME().getText();
        List<Tuple2<String, Type>> args = ctx.args().value().stream().map(v -> getValueType(v, funcName)).collect(Collectors.toList());
        List<Type> typeList = args.stream().map(Tuple2::_2).collect(Collectors.toList());

        Function function = Function.empty();

        if (ctx.getParent() instanceof Call_class_funcContext) {
            //TODO call func z kropką
        } else {
            /*call bez kropki*/
            List<Function> functionList = Optional.ofNullable(classManager.getClassMap().get(classManager.getCurrentDefClass()).get(funcName))
                .orElseGet(() -> {
                    CancellationExceptionFactory
                        .throwCancellationException(ctx, "Function " + funcName + " is undefined.");
                    return Collections.emptyList();
                });
            Optional<Function> optionalFunction = functionList.stream()
                .filter(f -> f.getArgsType().size() == typeList.size())
                .filter(f -> IntStream
                    .iterate(0, i -> i + 1)
                    .limit(typeList.size())
                    .filter(i -> f.getArgsType().get(i).getStringValue().equals(typeList.get(i).getStringValue()))
                    .count() == typeList.size()
                ).findFirst();

            function = optionalFunction.orElseGet(() -> {
                CancellationExceptionFactory
                    .throwCancellationException(ctx, "Function " + funcName + typeList + " is undefined.");
                return Function.empty();
            });
        }

        Type retType = function.getFuncType();

        getIntermediateObjList().add(
            new IntermediateObject<>(CALL_FUNC, retType, funcName, "", args, ArgType.NULL,
                new Tuple2<>(null, null)));
    }

}
