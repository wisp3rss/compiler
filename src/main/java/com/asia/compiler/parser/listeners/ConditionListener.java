package com.asia.compiler.parser.listeners;

import static com.asia.compiler.common.utils.Instructions.END;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.LabelStack;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser;
import com.asia.compiler.parser.gen.langParser.ConditionContext;
import com.asia.compiler.parser.gen.langParser.If_beginContext;
import com.asia.compiler.parser.visitors.ConditionVisitor;
import io.vavr.Tuple2;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConditionListener extends langBaseListener {

    private List<IntermediateObject> intermediateObjectList;
    private VariableMap variableMap;
    private LabelStack labelStack;

    @Override
    public void enterIf_begin(If_beginContext ctx) {
        labelStack.incrementNumber("IF");
        variableMap.incrementLevel();
        labelStack.getLabelStack().push("if_" + labelStack.getIfNumber());
        labelStack.changeElseExist("if_" + labelStack.getIfNumber(), false);
    }

    @Override
    public void exitCondition(ConditionContext ctx) {
        ConditionVisitor conditionVisitor = ConditionVisitor.of(variableMap);
        String label = labelStack.getLabelStack().peek();
        List<IntermediateObject> localIntermediateObjectList = conditionVisitor.visitConditionNode(ctx, label, ("end_" + label));
        intermediateObjectList.addAll(localIntermediateObjectList);
    }

    @Override
    public void exitIf_begin(If_beginContext ctx) {
        String label = labelStack.getLabelStack().pop();
        intermediateObjectList.add(new IntermediateObject<>(END, Type.LOOP, label, ("end_" + label), 0, ArgType.NULL, new Tuple2<>(null, null)));
        variableMap.decrementLevel();
        labelStack.getLastClosedIf().add(label);
    }

    @Override
    public void enterElse_statement(langParser.Else_statementContext ctx) {
        labelStack.incrementNumber("ELSE");
        labelStack.getLabelStack().push("else_" + labelStack.getIfNumber());
        labelStack.changeElseExist(
                labelStack.getLastClosedIf().get(labelStack.getLastClosedIf().size()-1),
                true
        );

    }

    @Override
    public void exitElse_statement(langParser.Else_statementContext ctx) {
        String label = labelStack.getLabelStack().pop();
        intermediateObjectList.add(new IntermediateObject<>(END, Type.LOOP, label, ("end_" + label), 0, ArgType.NULL, new Tuple2<>(null, null)));
        variableMap.decrementLevel();
//        labelStack.decrementNumber("ELSE");
    }
}
