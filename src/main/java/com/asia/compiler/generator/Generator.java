package com.asia.compiler.generator;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.utils.MathArgType;
import com.asia.compiler.common.utils.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "instance")
public class Generator {

    static String header_text = "";
    static int reg = 1;
    String result = "";

    public String generate(List<IntermediateObject> intermediateObjectList) {

        result += "declare i32 @printf(i8*, ...)\n";
        result += "declare i32 @__isoc99_scanf(i8*, ...)\n";
        result += "@strp = constant [4 x i8] c\"%d\\0A\\00\"\n";
        result += "@strs = constant [3 x i8] c\"%d\\00\"\n";
        result += "%String = type { i8*, i32, i32, i32 }\n";

        result += header_text;
        result += "define i32 @main() nounwind{\n";

        intermediateObjectList.forEach(o -> {
                switch (o.getInstructions()) {
                    case PRINT:
                        result += generatePrint(o);
                        break;
                    case READ:
                        result += generateRead(o);
                        break;
                    case DECLARE:
                        result += generateDefine(o);
                        break;
                    case ASSIGN:
                        result += generateAssign(o);
                        break;
                    case ADD:
                        result += generateAdd(o);
                        break;
                    case SUB:
                        result += generateSub(o);
                        break;
                    case MUL:
                        result += generateMul(o);
                        break;
                    case DIV:
                        result += generateDiv(o);
                        break;
                    case MOD:
                        result += generateMod(o);
                        break;

                }
            }
        );
        result += "ret i32 0 }\n";
        return result;
    }

    private String generatePrint(IntermediateObject obj) {
        String main_text = "%" + reg + " = load " + obj.getType().getValue() + ", " + obj.getType().getValue() + "* %" + obj.getV1() + "\n";
        reg++;
        main_text +=
            "%" + reg + " = call " + obj.getType().getValue() + " (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, " + obj.getType()
                .getValue() + " 0, " + obj.getType().getValue() + " 0), " + obj.getType().getValue() + " %" + (reg - 1) + ")\n";
        reg++;
        return main_text;
    }

    private String generateRead(IntermediateObject obj) {
        String main_text =
            "%" + reg + " = call " + obj.getType().getValue() + " (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, " + obj
                .getType().getValue() + " 0, " + obj.getType().getValue() + " 0), " + obj.getType().getValue() + "* %" + obj.getV1() + ")\n";
        reg++;
        return main_text;
    }

    private String generateDefine(IntermediateObject obj) {
        String main_text = "%" + obj.getV1() + " = alloca " + obj.getType().getValue() + "\n";
        return main_text;
    }

    private String generateMathOperationResult(IntermediateObject obj, String operation) {
        String main_text = "";
        Map<String, Integer> varRegistry = new HashMap<>();

        if(obj.getMathArgType().equals(MathArgType.VAR_VAR)){
            main_text += "%" + reg + " = load " + obj.getType().getValue() + ", " + obj.getType().getValue() + "* %" + obj.getMathArgs()._1() + "\n";
            varRegistry.put(obj.getMathArgs()._1().toString(), reg);
            reg++;

            main_text += "%" + reg + " = load " + obj.getType().getValue() + ", " + obj.getType().getValue() + "* %" + obj.getMathArgs()._2() + "\n";
            varRegistry.put(obj.getMathArgs()._2().toString(), reg);
            reg++;

            main_text += "%" + reg + " = "
                + operation + " " + obj.getType().getValue()
                + " %" + varRegistry.get(obj.getMathArgs()._1().toString())
                + ", %" + varRegistry.get(obj.getMathArgs()._2().toString()) + "\n";
            reg++;
            main_text += "store "+ obj.getType().getValue() + " "+ reg +", "+ obj.getType().getValue() + "* %"+ obj.getV1() +"\n";
        }
        else if(obj.getMathArgType().equals(MathArgType.NUM_NUM)){
            main_text += "%" + reg + " = " + operation + " " + obj.getType().getValue() + " " + obj.getMathArgs()._1() + ", " + obj.getMathArgs()._2() + "\n";
            reg++;
            main_text += "store "+ obj.getType().getValue() + " "+ reg +", "+ obj.getType().getValue() + "* %"+ obj.getV1() +"\n";
        }

        else if(obj.getMathArgType().equals(MathArgType.NUM_VAR)){
            main_text += "%" + reg + " = load " + obj.getType().getValue() + ", " + obj.getType().getValue() + "* %" + obj.getMathArgs()._2() + "\n";
            varRegistry.put(obj.getMathArgs()._2().toString(), reg);
            reg++;
            main_text += "%" + reg + " = "
                + operation + " " + obj.getType().getValue()
                + " " + obj.getMathArgs()._1()
                + ", %" + varRegistry.get(obj.getMathArgs()._2().toString()) + "\n";
            main_text += "store "+ obj.getType().getValue() + " "+ reg +", "+ obj.getType().getValue() + "* %"+ obj.getV1() +"\n";
            reg++;
            main_text += "store "+ obj.getType().getValue() + " "+ reg +", "+ obj.getType().getValue() + "* %"+ obj.getV1() +"\n";

        }
        else if(obj.getMathArgType().equals(MathArgType.VAR_NUM)){
            main_text += "%" + reg + " = load " + obj.getType().getValue() + ", " + obj.getType().getValue() + "* %" + obj.getMathArgs()._1() + "\n";
            varRegistry.put(obj.getMathArgs()._1().toString(), reg);
            reg++;
            main_text += "%" + reg + " = "
                + operation + " " + obj.getType().getValue()
                + " %" + varRegistry.get(obj.getMathArgs()._1().toString())
                + ", " + obj.getMathArgs()._2() + "\n";
            reg++;
            main_text += "store "+ obj.getType().getValue() + " "+ reg +", "+ obj.getType().getValue() + "* %"+ obj.getV1() +"\n";
        }
        return main_text;
    }

    private String generateAdd(IntermediateObject obj) {
        if (obj.getType().equals(Type.INT)) {
            return generateMathOperationResult(obj, "add");
        } else if (obj.getType().equals(Type.FLOAT)) {
            return generateMathOperationResult(obj, "fadd");
        }
        return "";
    }

    private String generateSub(IntermediateObject obj) {
        if (obj.getType().equals(Type.INT)) {
            return generateMathOperationResult(obj, "sub");
        } else if (obj.getType().equals(Type.FLOAT)) {
            return generateMathOperationResult(obj, "fsub");
        }
        return "";
    }

    private String generateMul(IntermediateObject obj) {
        if (obj.getType().equals(Type.INT)) {
            return generateMathOperationResult(obj, "mul");
        } else if (obj.getType().equals(Type.FLOAT)) {
            return generateMathOperationResult(obj, "fmul");
        }
        return "";
    }

    private String generateDiv(IntermediateObject obj) {
        if (obj.getType().equals(Type.INT)) {
            return generateMathOperationResult(obj, "sdiv");
        } else if (obj.getType().equals(Type.FLOAT)) {
            return generateMathOperationResult(obj, "fdiv");
        }
        return "";
    }

    private String generateMod(IntermediateObject obj) {
        String main_text = "";
        if (obj.getType().equals(Type.INT)) {
            main_text += generateMathOperationResult(obj, "sub");
        } else if (obj.getType().equals(Type.FLOAT)) {
            main_text += generateMathOperationResult(obj, "fsub");
        }
        main_text += "store "+ obj.getType().getValue() + " "+ obj.getVal() +", "+ obj.getType().getValue() + "* %"+ obj.getV1() +"\n";
        return main_text;
    }

    private String generateAssign(IntermediateObject obj) {

        String main_text = "store "+ obj.getType().getValue() + " "+ obj.getVal() +", "+ obj.getType().getValue() + "* %"+ obj.getV1() +"\n";
        return main_text;
    }
}
