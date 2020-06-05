package com.asia.compiler.parser.listeners;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.LabelStack;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser;
import io.vavr.Tuple2;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.asia.compiler.common.utils.Instructions.END_WHILE;

@AllArgsConstructor
public class LoopListener extends langBaseListener {

    private List<IntermediateObject> intermediateObjectList;
    private VariableMap variableMap;
    private LabelStack labelStack;

    @Override
    public void enterWhile_loop(langParser.While_loopContext ctx) {
        labelStack.incrementNumber("WHILE");
        variableMap.incrementLevel();
        labelStack.getLabelStack().push("while_" + labelStack.getIfNumber());
    }

    @Override
    public void exitWhile_loop(langParser.While_loopContext ctx) {
        String label = labelStack.getLabelStack().pop();
        intermediateObjectList.add(new IntermediateObject<>(END_WHILE, Type.LOOP, label, ("end_" + label), 0, ArgType.NULL, new Tuple2<>(null, null)));
        variableMap.decrementLevel();
        labelStack.getLastClosedIf().add(label);
    }
}
