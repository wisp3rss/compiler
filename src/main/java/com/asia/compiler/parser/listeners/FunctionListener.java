package com.asia.compiler.parser.listeners;

import static com.asia.compiler.common.utils.Instructions.FUNC_RETURN;
import static com.asia.compiler.common.utils.Type.BOOL;
import static com.asia.compiler.common.utils.Type.FLOAT;
import static com.asia.compiler.common.utils.Type.INT;
import static com.asia.compiler.common.utils.Type.NULL;
import static com.asia.compiler.common.utils.Type.STRING;

import com.asia.compiler.common.model.ClassManager;
import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.IntermediateObjectsData;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.Call_class_fieldContext;
import com.asia.compiler.parser.gen.langParser.Call_structContext;
import com.asia.compiler.parser.gen.langParser.Def_funcContext;
import com.asia.compiler.parser.gen.langParser.Numeric_valueContext;
import com.asia.compiler.parser.gen.langParser.ValueContext;
import com.asia.compiler.parser.utils.CancellationExceptionFactory;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FunctionListener extends langBaseListener {

    @NonNull
    private IntermediateObjectsData data;
    @NonNull
    private ClassManager classManager;
    private int beginFunctionIndex = 0;
    @NonNull
    private VariableMap variableMap;

    @Override
    public void enterDef_func(Def_funcContext ctx) {
        variableMap.incrementLevel();
        classManager.setIsInFunction(true);
        beginFunctionIndex = data.getFunctionIntermediateObjectList().size();
    }

    @Override
    public void exitDef_func(Def_funcContext ctx) {
        Type funcType = classManager.getType(ctx.define());
//        new IntermediateObject<>(FUNC_RETURN, funcType, ctx.NAME().getText(), funcType.getValue(), 0, ArgType.NULL, new Tuple2<>(null, null))

//        data.getFunctionIntermediateObjectList()

        Tuple2<String, Type> returnVal = getReturnValueType(ctx.ret().value(), ctx);
        if(funcType == returnVal._2) {
            data.getFunctionIntermediateObjectList().add(
                new IntermediateObject<>(FUNC_RETURN, funcType, returnVal._1, returnVal._2.getValue(), 0, ArgType.NULL,
                    new Tuple2<>(null, null)));
        } else {
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Incompatible type of return value:" + ctx.NAME().getText() + ". Expected type: " + funcType.getValue());
            return;
        }

        classManager.setIsInFunction(false);
        variableMap.decrementLevel();
    }

    private Tuple2<String, Type> getReturnValueType(ValueContext ctx, Def_funcContext def_funcContext) {
        if (ctx.NAME() != null) {
            return handleGetVarType(ctx, def_funcContext);
        } else if (ctx.TRUE() != null || ctx.FALSE() != null) {
            return Tuple.of(ctx.TRUE().getText(), BOOL);
        } else if (ctx.numeric_value() != null){
            return handleGetNumType(ctx.numeric_value());
        } else if (ctx.STRING() != null){
            return Tuple.of(ctx.STRING().getText(), STRING);
        } else if (ctx.call_struct() != null){
            return handleGetStructType(ctx.call_struct(), def_funcContext);
        } else if (ctx.call_class_field() != null){
            return handleGetClassType(ctx.call_class_field(), def_funcContext);
        }
        return Tuple.of("",NULL);
    }

    private Tuple2<String, Type> handleGetVarType(ValueContext ctx, Def_funcContext def_funcContext){

        if (variableMap.getVariableTypesMap().containsKey(ctx.NAME().getText())) {
            Type type = variableMap.getVariableTypesMap().get(ctx.NAME().getText());
            return Tuple.of(ctx.NAME().getText(), type);
        } else if (variableMap.getVariableTypesMap().containsKey(ctx.NAME().getText())){
        //(def_funcContext.def_args().stream().map(o -> o.NAME().getText()).noneMatch(o -> o.equals(ctx.NAME().getText()))){
            Type type = variableMap.getVariableTypesMap().get(ctx.NAME().getText());
            return Tuple.of(ctx.NAME().getText(), type);
        } else {
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Undeclared return value:" + ctx.NAME().getText());
            return Tuple.of("",NULL);
        }
    }

    private Tuple2<String, Type> handleGetNumType(Numeric_valueContext ctx){
        if(ctx.INT() != null){
            return Tuple.of(ctx.INT().getText(), INT);
        } else if (ctx.FLOAT() != null) {
            return Tuple.of(ctx.FLOAT().getText(), FLOAT);
        } else {
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Incompatible type of return numeric value.");
            return Tuple.of("", NULL);
        }
    }

    private Tuple2<String, Type> handleGetStructType(Call_structContext ctx, Def_funcContext funcName){

        if(!variableMap.getVariableTypesMap().containsKey(ctx.NAME(0).getText())){
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Undeclared struct:" + ctx.NAME(0).getText() + "in class \"" + funcName + "\".");
            return Tuple.of("", NULL);
        }

        if (variableMap.getVariableTypesMap().containsKey(ctx.NAME(1).getText())) {
            Type type = variableMap.getVariableTypesMap().get(ctx.NAME(1).getText());
            return Tuple.of(ctx.NAME(0).getText() + "." + ctx.NAME(1).getText(),type);
        } else {
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Incompatible type of return value:" + ctx.NAME(0).getText() + "." + ctx.NAME(1).getText() + ", Expected type: " + classManager.getType(funcName.define()).getValue());
            return Tuple.of("", NULL);
        }
    }

    private Tuple2<String, Type> handleGetClassType(Call_class_fieldContext ctx, Def_funcContext funcName){

        if(!variableMap.getVariableTypesMap().containsKey(ctx.NAME(0).getText())){
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Undeclared class:" + ctx.NAME(0).getText() + "in class \"" + funcName + "\".");
            return Tuple.of("", NULL);
        }

        if (variableMap.getVariableTypesMap().containsKey(ctx.NAME(1).getText())) {
            Type type = variableMap.getVariableTypesMap().get(ctx.NAME(1).getText());
            return Tuple.of(ctx.NAME(0).getText() + "." + ctx.NAME(1).getText(),type);
        } else {
            CancellationExceptionFactory
                .throwCancellationException(ctx, "Incompatible type of return value:" + ctx.NAME(0).getText() + "." + ctx.NAME(1).getText() + ", Expected type: " + classManager.getType(funcName.define()).getValue());
            return Tuple.of("", NULL);
        }
    }

}
