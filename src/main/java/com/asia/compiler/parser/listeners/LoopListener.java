package com.asia.compiler.parser.listeners;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.LabelStack;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser;
import com.asia.compiler.parser.gen.langParser.ConditionContext;
import com.asia.compiler.parser.gen.langParser.Do_while_loopContext;
import com.asia.compiler.parser.gen.langParser.For_loopContext;
import io.vavr.Tuple2;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.asia.compiler.common.utils.Instructions.DO_WHILE;
import static com.asia.compiler.common.utils.Instructions.END_DO_WHILE;
import static com.asia.compiler.common.utils.Instructions.END_FOR;
import static com.asia.compiler.common.utils.Instructions.END_WHILE;
import static com.asia.compiler.common.utils.Instructions.FOR;
import static com.asia.compiler.common.utils.Instructions.FOR_OP;
import static com.asia.compiler.common.utils.Instructions.FOR_BODY;
import static com.asia.compiler.common.utils.Instructions.FOR_COND;

@AllArgsConstructor
public class LoopListener extends langBaseListener {

    private List<IntermediateObject> intermediateObjectList;
    private VariableMap variableMap;
    private LabelStack labelStack;
    private VariableListener variableListener;
    private ConditionListener conditionListener;

    @Override
    public void enterWhile_loop(langParser.While_loopContext ctx) {
        labelStack.incrementNumber("WHILE");
        variableMap.incrementLevel();
        labelStack.getLabelStack().push("while_" + labelStack.getWhileNumber());
    }

    @Override
    public void exitWhile_loop(langParser.While_loopContext ctx) {
        String label = labelStack.getLabelStack().pop();
        intermediateObjectList.add(new IntermediateObject<>(END_WHILE, Type.LOOP, label, ("end_" + label), 0, ArgType.NULL, new Tuple2<>(null, null)));
        variableMap.decrementLevel();
        labelStack.getLastClosedIf().add(label);
    }

    @Override
    public void enterDo_while_loop(Do_while_loopContext ctx) {
        labelStack.incrementNumber("DOWHILE");
        labelStack.incrementNumber("WHILE");
        variableMap.incrementLevel();
        labelStack.getLabelStack().push("dowhile_" + labelStack.getDoWhileNumber());
        String label = labelStack.getLabelStack().peek();
        intermediateObjectList.add(new IntermediateObject<>(DO_WHILE, Type.LOOP, label, ("end_" + label), 0, ArgType.NULL, new Tuple2<>(null, null)));
    }

    @Override
    public void exitDo_while_loop(Do_while_loopContext ctx) {
        String label = labelStack.getLabelStack().pop();
        intermediateObjectList.add(new IntermediateObject<>(END_DO_WHILE, Type.LOOP, label, ("end_" + label), 0, ArgType.NULL, new Tuple2<>(null, null)));
        variableMap.decrementLevel();
        labelStack.getLastClosedIf().add(label);
    }

    @Override
    public void enterFor_loop(For_loopContext ctx) {
        labelStack.incrementNumber("FOR");
        variableMap.incrementLevel();
        labelStack.getLabelStack().push("for_" + labelStack.getForNumber());
        String label = labelStack.getLabelStack().peek();
        intermediateObjectList.add(new IntermediateObject<>(FOR, Type.LOOP, label, ("end_" + label), 0, ArgType.NULL, new Tuple2<>(null, null)));
    }

    @Override
    public void exitFor_loop(For_loopContext ctx) {
        String label = labelStack.getLabelStack().pop();
        intermediateObjectList.add(new IntermediateObject<>(
            END_FOR, Type.LOOP, (label + "_operation"), ("end_" + label), 0, ArgType.NULL, new Tuple2<>(null, null)));
        variableMap.decrementLevel();
        labelStack.getLastClosedIf().add(label);
    }
}
