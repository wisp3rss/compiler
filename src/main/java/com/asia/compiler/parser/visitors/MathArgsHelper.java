package com.asia.compiler.parser.visitors;

import static com.asia.compiler.common.utils.Instructions.ADD;
import static com.asia.compiler.common.utils.Instructions.DIV;
import static com.asia.compiler.common.utils.Instructions.MOD;
import static com.asia.compiler.common.utils.Instructions.MUL;
import static com.asia.compiler.common.utils.Instructions.SUB;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.Instructions;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langParser.Assign_varContext;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MathArgsHelper {

    private VariableMap variableMap;
    private List<IntermediateObject> intermediateObjectList;

    private void createMathIntermediateObject(Tuple3<String, String, ArgType> arguments, Instructions instruction, String varName, Type type) {
        intermediateObjectList.add(new IntermediateObject<>(
            instruction,
            type,
            varName,
            "",
            0,
            arguments._3(),
            new Tuple2<>(arguments._1(), arguments._2())
        ));
    }

    public void handleAssignMath(Assign_varContext ctx, String varName, Type type) {

        MathArgsVisitor mathArgsVisitor = MathArgsVisitor.of(variableMap);

        Tuple3<String, String, ArgType> arguments = mathArgsVisitor.visitMathArgs(ctx.operation().math_module(), type);

        switch (ctx.operation().math_module().op.getText()) {
            case "+":
                createMathIntermediateObject(arguments, ADD, varName, type);
                break;
            case "-":
                createMathIntermediateObject(arguments, SUB, varName, type);
                break;
            case "*":
                createMathIntermediateObject(arguments, MUL, varName, type);
                break;
            case "/":
                createMathIntermediateObject(arguments, DIV, varName, type);
                break;
            case "%":
                createMathIntermediateObject(arguments, MOD, varName, type);
                break;
        }
    }
}
