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
    String declarations = "";

    public String generate(List<IntermediateObject> intermediateObjectList) {

        result += "declare i32 @printf(i8*, ...)\n";
        result += "declare i32 @scanf(i8*, ...)\n";
        result += "declare i8* @__strcpy_chk(i8*, i8*, i64) #1\n";
        result += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n";
        result += "@strpd = constant [4 x i8] c\"%f\\0A\\00\"\n";
        result += "@strs = constant [3 x i8] c\"%d\\00\"\n";
        result += "@.strdouble = private unnamed_addr constant [4 x i8] c\"%lf\\00\"\n";
        result += "@.stringScan = private unnamed_addr constant [3 x i8] c\"%s\\00\"\n";
        result += "@.stringPrint = private unnamed_addr constant [4 x i8] c\"%s\\0A\\00\"\n";
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
        return declarations + result;
    }

    private String generatePrint(IntermediateObject obj) {
        String main_text = "%" + reg + " = load " + obj.getType().getValue() + ", " + obj.getType().getValue() + "* %" + obj.getV1() + "\n";
        reg++;

        if (obj.getType().equals(Type.INT)) {
            main_text +=
                "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), " + obj.getType().getValue()
                    + " %" + (reg - 1) + ")\n";
            reg++;

        } else if (obj.getType().equals(Type.FLOAT)) {
            main_text +=
                "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), " + obj.getType().getValue()
                    + " %" + (reg - 1) + ")\n";
            reg++;
        } else if (obj.getType().equals(Type.STRING)) {
            main_text +=
                "%" + reg + " = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_" + obj.getV1() + ", i64 0, i64 0\n";
            reg++;

            main_text +=
                "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.stringPrint, i64 0, i64 0), i8* %" + (reg - 1)
                    + ")\n";
            reg++;
        }

        return main_text;
    }

    private String generateRead(IntermediateObject obj) {
        String main_text = "";
        if (obj.getType().equals(Type.INT)) {
            main_text =
                "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i64 0, i64 0), " + obj.getType().getValue()
                    + "* %" + obj.getV1() + ")\n";

        } else if (obj.getType().equals(Type.FLOAT)) {
            main_text = "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strdouble, i64 0, i64 0), " + obj.getType()
                .getValue() + "* %" + obj.getV1() + ")\n";

        } else if (obj.getType().equals(Type.STRING)) {
            main_text += "%" + reg + "  = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_" + obj.getV1() + ", i64 0, i64 0\n";
            reg++;
            main_text +=
                "%" + reg + "  = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.stringScan, i64 0, i64 0), i8* %" + (reg - 1)
                    + ")\n";
        }
        reg++;
        return main_text;
    }

    private String generateDefine(IntermediateObject obj) {
        String main_text = "";
        main_text += "%" + obj.getV1() + " = alloca " + obj.getType().getValue() + "\n";
        if (obj.getType().equals(Type.STRING)) {
            main_text += "%tmp_" + obj.getV1() + " = alloca [256 x i8]\n";
            main_text += "store i32 0, i32* %" + obj.getV1() + "\n";
        }
        return main_text;
    }

    private String generateMathOperationResult(IntermediateObject obj, String operation) {
        String main_text = "";
        Map<String, Integer> varRegistry = new HashMap<>();

        if (obj.getMathArgType().equals(MathArgType.VAR_VAR)) {
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
            main_text += "store " + obj.getType().getValue() + " %" + (reg - 1) + ", " + obj.getType().getValue() + "* %" + obj.getV1() + "\n";
        } else if (obj.getMathArgType().equals(MathArgType.NUM_NUM)) {
            main_text += "%" + reg + " = " + operation + " " + obj.getType().getValue() + " " + obj.getMathArgs()._1() + ", " + obj.getMathArgs()._2() + "\n";
            reg++;
            main_text += "store " + obj.getType().getValue() + " %" + (reg - 1) + ", " + obj.getType().getValue() + "* %" + obj.getV1() + "\n";
        } else if (obj.getMathArgType().equals(MathArgType.NUM_VAR)) {
            main_text += "%" + reg + " = load " + obj.getType().getValue() + ", " + obj.getType().getValue() + "* %" + obj.getMathArgs()._2() + "\n";
            varRegistry.put(obj.getMathArgs()._2().toString(), reg);
            reg++;
            main_text += "%" + reg + " = "
                + operation + " " + obj.getType().getValue()
                + " " + obj.getMathArgs()._1()
                + ", %" + varRegistry.get(obj.getMathArgs()._2().toString()) + "\n";
            reg++;
            main_text += "store " + obj.getType().getValue() + " %" + (reg - 1) + ", " + obj.getType().getValue() + "* %" + obj.getV1() + "\n";

        } else if (obj.getMathArgType().equals(MathArgType.VAR_NUM)) {
            main_text += "%" + reg + " = load " + obj.getType().getValue() + ", " + obj.getType().getValue() + "* %" + obj.getMathArgs()._1() + "\n";
            varRegistry.put(obj.getMathArgs()._1().toString(), reg);
            reg++;
            main_text += "%" + reg + " = "
                + operation + " " + obj.getType().getValue()
                + " %" + varRegistry.get(obj.getMathArgs()._1().toString())
                + ", " + obj.getMathArgs()._2() + "\n";
            reg++;
            main_text += "store " + obj.getType().getValue() + " %" + (reg - 1) + ", " + obj.getType().getValue() + "* %" + obj.getV1() + "\n";
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
        return main_text;
    }

    private String generateAssign(IntermediateObject obj) {
        String main_text = "";
        if (obj.getType().equals(Type.STRING)) {
            main_text += generateAssignString(obj);
        }
        else {
            main_text += "store " + obj.getType().getValue() + " " + obj.getVal() + ", " + obj.getType().getValue() + "* %" + obj.getV1() + "\n";
        }
        return main_text;
    }

    private String generateAssignString(IntermediateObject obj){
        declarations += "@.strAssignString_" + obj.getV1() + " = private unnamed_addr constant [ "+ (obj.getVal().toString().length()-1) + " x i8] c\"" + obj.getVal().toString().substring(1, obj.getVal().toString().length()-1) + "\\00\"\n";
        String main_text = "";
        main_text += "%" + reg + " = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_" + obj
            .getV1()+ ", i64 0, i64 0\n";
        reg++;
        main_text += "%" + reg + " = call i8* @__strcpy_chk(i8* %" + (reg-1) + ", i8* getelementptr inbounds ([ "+ (obj.getVal().toString().length()-1) + " x i8], [ "+ (obj.getVal().toString().length()-1) + " x i8]* @.strAssignString_" + obj.getV1() + ", i64 0, i64 0), i64 256)\n";
        reg++;
        return main_text;
    }
}
