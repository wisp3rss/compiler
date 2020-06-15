package com.asia.compiler.parser.listeners;

import static com.asia.compiler.common.utils.Instructions.END_IF_ELSE;
import static com.asia.compiler.common.utils.Instructions.FOR_COND;
import static com.asia.compiler.common.utils.Instructions.FOR_OP;

import com.asia.compiler.common.model.ClassManager;
import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.IntermediateObjectsData;
import com.asia.compiler.common.model.LabelStack;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser;
import com.asia.compiler.parser.gen.langParser.ConditionContext;
import com.asia.compiler.parser.gen.langParser.For_loopContext;
import com.asia.compiler.parser.gen.langParser.If_beginContext;
import com.asia.compiler.parser.visitors.ConditionVisitor;
import io.vavr.Tuple2;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConditionListener extends langBaseListener {

    private final VariableMap variableMap;
    private final LabelStack labelStack;
    private final IntermediateObjectsData data;
    private final ClassManager classManager;

    private List<IntermediateObject> getIntermediateObjList() {
        return classManager.getIsInFunction() ? data.getFunctionIntermediateObjectList() : data.getIntermediateObjectList();
    }

    @Override
    public void enterIf_begin(If_beginContext ctx) {
        labelStack.incrementNumber("IF");
        variableMap.incrementLevel();
        labelStack.getLabelStack().push("if_" + labelStack.getIfNumber());
        labelStack.changeElseExist("if_" + labelStack.getIfNumber(), false);
    }

    @Override
    public void enterCondition(ConditionContext ctx) {
        if (ctx.parent instanceof For_loopContext && ((For_loopContext) ctx.parent).FOR() != null) {
            String label = labelStack.getLabelStack().peek();
            getIntermediateObjList().add(new IntermediateObject<>(
                FOR_COND, Type.NULL, (label + "_cond"), "", 0, ArgType.NULL, new Tuple2<>(null, null)));
        }
    }

    @Override
    public void exitCondition(ConditionContext ctx) {
        ConditionVisitor conditionVisitor = ConditionVisitor.of(variableMap, labelStack);
        String label = labelStack.getLabelStack().peek();

        if (ctx.parent instanceof For_loopContext && ((For_loopContext) ctx.parent).FOR() != null) {
            List<IntermediateObject> localIntermediateObjectList = conditionVisitor.visitConditionNode(ctx, (label + "_body"), ("end_" + label));
            getIntermediateObjList().addAll(localIntermediateObjectList);
            getIntermediateObjList().add(new IntermediateObject<>(
                FOR_OP, Type.NULL, (label + "_body"), (label + "_operation"), 0, ArgType.NULL, new Tuple2<>(null, null)));
        } else {
            List<IntermediateObject> localIntermediateObjectList = conditionVisitor.visitConditionNode(ctx, label, ("end_" + label));
            getIntermediateObjList().addAll(localIntermediateObjectList);
        }

    }

    @Override
    public void exitIf_begin(If_beginContext ctx) {
        String label = labelStack.getLabelStack().pop();
        getIntermediateObjList().add(new IntermediateObject<>(END_IF_ELSE, Type.NULL, label, ("end_" + label), 0, ArgType.NULL, new Tuple2<>(null, null)));
        variableMap.decrementLevel();
        labelStack.getLastClosedIf().add(label);
    }

    @Override
    public void enterElse_statement(langParser.Else_statementContext ctx) {
        labelStack.incrementNumber("ELSE");
        labelStack.getLabelStack().push("else_" + labelStack.getElseNumber());
        labelStack.changeElseExist(
            labelStack.getLastClosedIf().get(labelStack.getLastClosedIf().size() - 1),
            true
        );

    }

    @Override
    public void exitElse_statement(langParser.Else_statementContext ctx) {
        String label = labelStack.getLabelStack().pop();
        getIntermediateObjList().add(new IntermediateObject<>(END_IF_ELSE, Type.NULL, label, ("end_" + label), 0, ArgType.NULL, new Tuple2<>(null, null)));
        variableMap.decrementLevel();
    }
}
