package com.asia.compiler.parser.listeners;

import static com.asia.compiler.common.utils.Instructions.DECLARE;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.Assign_varContext;
import com.asia.compiler.parser.gen.langParser.Def_varContext;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class VariableListener extends langBaseListener {

    private List<IntermediateObject> intermediateObjectList;
    private Map<String, Type> variableTypesMap;

    @Override
    public void exitAssign_var(Assign_varContext ctx) {

    }

    @Override
    public void exitDef_var(Def_varContext ctx) {
        Type t = null;
        if (ctx.define().DEF_INT() != null) {
            t = Type.INT;
        } else if (ctx.define().DEF_FLOAT() != null) {
            t = Type.FLOAT;
        }

        if (variableTypesMap.containsValue(ctx.NAME().getText()) || null == t) {
            ctx.exception = new RecognitionException("Variable " + ctx.NAME().getText() + " already defined.", null, null, ctx);
            throw new ParseCancellationException("Variable " + ctx.NAME().getText() + " already defined.");
        } else {
            variableTypesMap.put(ctx.NAME().getText(), t);
        }

        intermediateObjectList.add(new IntermediateObject<>(DECLARE, t, ctx.NAME().getText(), "", 0));
    }
}
