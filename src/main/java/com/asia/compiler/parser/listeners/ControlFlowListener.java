package com.asia.compiler.parser.listeners;
import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.utils.MathArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser;
import com.asia.compiler.parser.utils.Value;
import io.vavr.Tuple2;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.*;

import static com.asia.compiler.common.utils.Instructions.*;

@AllArgsConstructor
public class ControlFlowListener extends langBaseListener {

    private List<IntermediateObject> intermediateObjectList;
    private Map<String, Type> variableTypesMap;
    private Stack<Value> stack;
    private HashSet<String> functions;
    private String function;
    //    repeat_statement: REPEAT repeatitions block ENDREPEAT;

    @Override
    public void exitRepeatitions(langParser.RepeatitionsContext ctx) {
        String iters = ctx.getText();
        intermediateObjectList.add(new IntermediateObject<>(REPEAT, null, iters, "", null, MathArgType.NULL, new Tuple2<>(null, null)));

    }

    @Override
    public void exitBlock(langParser.BlockContext ctx){
        if( ctx.getParent() instanceof langParser.Repeat_statementContext ){
            intermediateObjectList.add(new IntermediateObject<>(ENDREPEAT, null, "", "", null, MathArgType.NULL, new Tuple2<>(null, null)));
        }
    }

    @Override
    public void exitExpr(langParser.ExprContext ctx){
        if (ctx.INT() != null){
            stack.push( new Value(ctx.INT().getText(), Type.INT));
        }
        if (ctx.FLOAT() != null) {
            stack.push( new Value(ctx.FLOAT().getText(), Type.FLOAT));
        }
//        if (ctx.MULT() != null){
//            Value v1 = stack.pop();
//            Value v2 = stack.pop();
//            if( v1.type == v2.type ) {
//                if( v1.type == Type.INT ){
//                    LLVMGenerator.mult_i32(v1.name, v2.name);
//                    stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT) );
//                }else if (v1.type == Type.FLOAT ){
//
//                }
//            }
//            intermediateObjectList.add(new IntermediateObject<>(
//                    MUL,
//                    type,
//                    varName,
//                    "",
//                    0,
//                    arguments._3(),
//                    new Tuple2<>(arguments._1(), arguments._2())
//            ));
//        }
//        if (ctx.DIV() != null){
//
//        }
//        if (ctx.MINUS() != null){
//
//        }
//        if (ctx.PLUS() != null){
//
//        }
    }

    @Override
    public void exitEqual(langParser.EqualContext ctx) {
        Type NAME = variableTypesMap.get(ctx.NAME().getText());
        Value v = stack.pop();
        if (NAME != null){
            intermediateObjectList.add(new IntermediateObject<>(EQUAL, NAME, ctx.NAME().getText(), v.name, v.type, MathArgType.NULL, new Tuple2<>(null, null)));
        } else {
            ctx.exception = new RecognitionException("Variable " + ctx.NAME().getText() + " not found.", null, null, ctx);
            throw new ParseCancellationException("Variable " + ctx.NAME().getText() + " not found.");
        }
    }

    @Override
    public void enterBlockif(langParser.BlockifContext ctx){
        intermediateObjectList.add(new IntermediateObject<>(IF, null, "", "", null, MathArgType.NULL, new Tuple2<>(null, null)));
    }

    @Override
    public void exitBlockif(langParser.BlockifContext ctx){
        intermediateObjectList.add(new IntermediateObject<>(ENDIF, null, "", "", null, MathArgType.NULL, new Tuple2<>(null, null)));
    }

    //funkcje
    @Override
    public void exitFparam(langParser.FparamContext ctx){
        Type NAME = variableTypesMap.get(ctx.NAME().getText());
        String ID = ctx.NAME().getText();
        functions.add(ID);
        function = ID;
        if (NAME != null){
            intermediateObjectList.add(new IntermediateObject<>(FUNCTION, NAME, ID, "", null, MathArgType.NULL, new Tuple2<>(null, null)));
        } else{
            ctx.exception = new RecognitionException("Variable " + ctx.NAME().getText() + " not found.", null, null, ctx);
            throw new ParseCancellationException("Variable " + ctx.NAME().getText() + " not found.");
        }
    }

//    @Override
//    public void enterFblock(langParser.FblockContext ctx){
//        global=false;
//    }

    @Override
    public void exitFblock(langParser.FblockContext ctx) {
        Type NAME = variableTypesMap.get(function);
        if (NAME != null){
            intermediateObjectList.add(new IntermediateObject<>(FBLOCK, NAME, function, "", null, MathArgType.NULL, new Tuple2<>(null, null)));
            variableTypesMap = new HashMap<String, Type>();
            //global ==true;
        }
    }

}
