package com.asia.compiler.parser.listeners;

import static com.asia.compiler.common.utils.Instructions.PRINT;
import static com.asia.compiler.common.utils.Instructions.READ;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.utils.MathArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.PrintContext;
import com.asia.compiler.parser.gen.langParser.ReadContext;
import io.vavr.Tuple2;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;

@AllArgsConstructor
public class IOListener extends langBaseListener {

    private List<IntermediateObject> intermediateObjectList;
    private Map<String, Type> variableTypesMap;

    @Override
    public void exitRead(ReadContext ctx) {
        Type t = variableTypesMap.get(ctx.NAME().getText());
        if (t != null) {
            intermediateObjectList.add(new IntermediateObject<>(READ, t, ctx.NAME().getText(), "", 0, MathArgType.NULL, new Tuple2<>(null, null)));
        } else {
            ctx.exception = new RecognitionException("Variable " + ctx.NAME().getText() + " not found.", null, null, ctx);
            throw new ParseCancellationException("Variable " + ctx.NAME().getText() + " not found.");
        }
    }

    @Override
    public void exitPrint(PrintContext ctx) {
        Type t = variableTypesMap.get(ctx.NAME().getText());
        if (t != null) {
            intermediateObjectList.add(new IntermediateObject<>(PRINT, t, ctx.NAME().getText(), "", 0, MathArgType.NULL, new Tuple2<>(null, null)));
        } else {
            ctx.exception = new RecognitionException("Variable " + ctx.NAME().getText() + " not found.", null, null, ctx);
            throw new ParseCancellationException("Variable " + ctx.NAME().getText() + " not found.");
        }
    }
}
