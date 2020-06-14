package com.asia.compiler.parser.listeners;

import static com.asia.compiler.common.utils.Instructions.PRINT;
import static com.asia.compiler.common.utils.Instructions.READ;

import com.asia.compiler.common.model.ClassManager;
import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.IntermediateObjectsData;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.PrintContext;
import com.asia.compiler.parser.gen.langParser.ReadContext;
import io.vavr.Tuple2;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;

@AllArgsConstructor
public class IOListener extends langBaseListener {

    private VariableMap variableMap;
    private IntermediateObjectsData data;
    private ClassManager classManager;

    private List<IntermediateObject> getIntermediateObjList() {
        return classManager.getIsInFunction() ? data.getFunctionIntermediateObjectList() : data.getIntermediateObjectList();
    }

    @Override
    public void exitRead(ReadContext ctx) {
        Type t = variableMap.getVariableTypesMap().get(ctx.NAME().getText());
        if (t != null) {
            getIntermediateObjList().add(new IntermediateObject<>(READ, t, ctx.NAME().getText(), "", 0, ArgType.NULL, new Tuple2<>(null, null)));
        } else {
            ctx.exception = new RecognitionException("Variable " + ctx.NAME().getText() + " not found.", null, null, ctx);
            throw new ParseCancellationException("Variable " + ctx.NAME().getText() + " not found.");
        }
    }

    @Override
    public void exitPrint(PrintContext ctx) {
        Type t = variableMap.getVariableTypesMap().get(ctx.NAME().getText());
        if (t != null) {
            getIntermediateObjList().add(new IntermediateObject<>(PRINT, t, ctx.NAME().getText(), "", 0, ArgType.NULL, new Tuple2<>(null, null)));
        } else {
            ctx.exception = new RecognitionException("Variable " + ctx.NAME().getText() + " not found.", null, null, ctx);
            throw new ParseCancellationException("Variable " + ctx.NAME().getText() + " not found.");
        }
    }
}
