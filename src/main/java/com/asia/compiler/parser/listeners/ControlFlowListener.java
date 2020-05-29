package com.asia.compiler.parser.listeners;
import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.utils.MathArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.If_statementContext;
import com.asia.compiler.parser.gen.langParser.While_statementContext;
import io.vavr.Tuple2;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import java.util.List;
import java.util.Map;

import static com.asia.compiler.common.utils.Instructions.WHILE;

@AllArgsConstructor
public class ControlFlowListener extends langBaseListener {

    private List<IntermediateObject> intermediateObjectList;
    private Map<String, Type> variableTypesMap;

    @Override
    public void exitWhile_statement(While_statementContext ctx) {
        Type expr = variableTypesMap.get(ctx.expr().getText());
        Type block = variableTypesMap.get(ctx.statement_block().getText());
        if (expr != null){
            intermediateObjectList.add(new IntermediateObject<>(WHILE, expr, ctx.expr().getText(), "", 0, MathArgType.NULL, new Tuple2<>(null, null)));
        } else {
            ctx.exception = new RecognitionException("Statement " + ctx.expr().getText() + " missing", null, null, ctx);
            throw new ParseCancellationException("Statement " + ctx.expr().getText() + " not found.");
        }

        if (block != null){
            intermediateObjectList.add(new IntermediateObject<>(WHILE, block, ctx.statement_block().getText(), "", 0, MathArgType.NULL, new Tuple2<>(null, null)));
        } else {
            ctx.exception = new RecognitionException("Statement " + ctx.statement_block().getText() + " missing", null, null, ctx);
            throw new ParseCancellationException("Statement " + ctx.statement_block().getText() + " not found.");
        }
    }

    @Override
    public void exitIf_statement(If_statementContext ctx) {
    }
}
