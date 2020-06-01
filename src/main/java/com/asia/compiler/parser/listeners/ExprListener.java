package com.asia.compiler.parser.listeners;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.utils.MathArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser;
import io.vavr.Tuple2;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

import static com.asia.compiler.common.utils.Instructions.TRUE;

@AllArgsConstructor
public class ExprListener extends langBaseListener {
    private List<IntermediateObject> intermediateObjectList;
    private Map<String, Type> variableTypesMap;

//    expr
//    : NOT expr
//    | expr op=(MULT | DIV | MOD) expr
//    | expr op=(PLUS | MINUS) expr
//    | expr op=(EQ|NEQ) expr
//    | expr AND expr
//    | expr OR expr
//    | TRUE
//    | FALSE;
    @Override
    public void exitExpr(langParser.ExprContext ctx){
        Type t = null;
//        Type expr = variableTypesMap.get(ctx.expr().getText());
////        Type statementBlock = variableTypesMap.get(ctx.statement_block().getText());
////
////        if (expr != null){
////            intermediateObjectList.add(new IntermediateObject<>(WHILE, expr, ctx.expr().getText(), "", 0, MathArgType.NULL, new Tuple2<>(null, null)));
////        } else {
////            ctx.exception = new RecognitionException("Statement " + ctx.expr().getText() + " missing", null, null, ctx);
////            throw new ParseCancellationException("Statement " + ctx.expr().getText() + " not found.");
////        }
        String trueExpr = ctx.TRUE().getSymbol().toString();

        if (trueExpr != null){
            intermediateObjectList.add(new IntermediateObject<>(TRUE, t, ctx.TRUE().getText(), "", 0, MathArgType.NULL, new Tuple2<>(null, null)));
        }
    }
}
