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

    private static final String PRINT_INT = "%s = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), %s %s)\n";
    private static final String PRINT_FLOAT = "%s = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), %s %s)\n";
    private static final String PRINT_STRING_LINE_1 = "%s = getelementptr inbounds [256 x i8], [256 x i8]* %s, i64 0, i64 0\n";
    private static final String PRINT_STRING_LINE_2 = "%s = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.stringPrint, i64 0, i64 0), i8* %s)\n";

    private static final String READ_INT = "%s = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i64 0, i64 0), %s* %s)\n";
    private static final String READ_FLOAT = "%s = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strdouble, i64 0, i64 0), %s* %s)\n";
    private static final String READ_STRING_LNE_1 = "%s  = getelementptr inbounds [256 x i8], [256 x i8]* %s, i64 0, i64 0\n";
    private static final String READ_STRING_LNE_2 = "%s  = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.stringScan, i64 0, i64 0), i8* %s)\n";

    private static final String DEFINE_INT_FLOAT = "%s = alloca %s\n";
    private static final String DEFINE_STRING = "%s = alloca [256 x i8]\nstore i32 0, i32* %s\n";

    private static final String ASSIGN_STRING_DECLARATION = "@.strAssignString_%s = private unnamed_addr constant [ %s x i8] c\"%s\\00\"\n";
    private static final String ASSIGN_STRING_LINE_1 = "%s = getelementptr inbounds [256 x i8], [256 x i8]* %s, i64 0, i64 0\n";
    private static final String ASSIGN_STRING_LINE_2 = "%s = call i8* @__strcpy_chk(i8* %s, i8* getelementptr inbounds ([ %s x i8], [ %s x i8]* @.strAssignString_%s, i64 0, i64 0), i64 256)\n";
    private static final String ASSIGN_INT_FLOAT = "store %s %s, %s* %s\n";

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

        if (isTypeEquals(obj, Type.INT)) {
            main_text += String.format(PRINT_INT, ("%" + reg), obj.getType().getValue(), ("%" + (reg - 1)));
            reg++;

        } else if (isTypeEquals(obj, Type.FLOAT)) {
            main_text += String.format(PRINT_FLOAT, ("%" + reg), obj.getType().getValue(), ("%" + (reg - 1)));
            reg++;

        } else if (isTypeEquals(obj, Type.STRING)) {
            main_text += String.format(PRINT_STRING_LINE_1, ("%" + reg), ("%tmp_" + obj.getV1()));
            reg++;

            main_text += String.format(PRINT_STRING_LINE_2, ("%" + reg), ("%" + (reg - 1)));
            reg++;
        }

        return main_text;
    }

    private String generateRead(IntermediateObject obj) {
        String main_text = "";
        if (isTypeEquals(obj, Type.INT)) {
            main_text = String.format(READ_INT, ("%" + reg), obj.getType().getValue(), ("%" + obj.getV1()));

        } else if (isTypeEquals(obj, Type.FLOAT)) {
            main_text = String.format(READ_FLOAT, ("%" + reg), obj.getType().getValue(), ("%" + obj.getV1()));

        } else if (isTypeEquals(obj, Type.STRING)) {
            main_text += String.format(READ_STRING_LNE_1, ("%" + reg), ("%tmp_" + obj.getV1()));
            reg++;
            main_text += String.format(READ_STRING_LNE_2, ("%" + reg), ("%" + (reg - 1)));
        }
        reg++;
        return main_text;
    }

    private String generateDefine(IntermediateObject obj) {
        String main_text = "";
        main_text += String.format(DEFINE_INT_FLOAT, ("%" + obj.getV1()), obj.getType().getValue());

        if (isTypeEquals(obj, Type.STRING)) {
            main_text += String.format(DEFINE_STRING, ("%tmp_" + obj.getV1()), ("%" + obj.getV1()));
        }
        return main_text;
    }

    //TODO
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
        if (isTypeEquals(obj, Type.INT)) {
            return generateMathOperationResult(obj, "add");
        } else if (isTypeEquals(obj, Type.FLOAT)) {
            return generateMathOperationResult(obj, "fadd");
        }
        return "";
    }

    private String generateSub(IntermediateObject obj) {
        if (isTypeEquals(obj, Type.INT)) {
            return generateMathOperationResult(obj, "sub");
        } else if (isTypeEquals(obj, Type.FLOAT)) {
            return generateMathOperationResult(obj, "fsub");
        }
        return "";
    }

    private String generateMul(IntermediateObject obj) {
        if (isTypeEquals(obj, Type.INT)) {
            return generateMathOperationResult(obj, "mul");
        } else if (isTypeEquals(obj, Type.FLOAT)) {
            return generateMathOperationResult(obj, "fmul");
        }
        return "";
    }

    private String generateDiv(IntermediateObject obj) {
        if (isTypeEquals(obj, Type.INT)) {
            return generateMathOperationResult(obj, "sdiv");
        } else if (isTypeEquals(obj, Type.FLOAT)) {
            return generateMathOperationResult(obj, "fdiv");
        }
        return "";
    }

    private String generateMod(IntermediateObject obj) {
        String main_text = "";
        if (isTypeEquals(obj, Type.INT)) {
            main_text += generateMathOperationResult(obj, "sub");
        } else if (isTypeEquals(obj, Type.FLOAT)) {
            main_text += generateMathOperationResult(obj, "fsub");
        }
        return main_text;
    }

    private String generateAssign(IntermediateObject obj) {
        String main_text = "";
        if (isTypeEquals(obj, Type.STRING)) {
            main_text += generateAssignString(obj);
        }
        else {
            main_text += String.format(ASSIGN_INT_FLOAT, obj.getType().getValue(), obj.getVal(),obj.getType().getValue(),("%" + obj.getV1()));
        }
        return main_text;
    }

    private String generateAssignString(IntermediateObject obj){
        int valLenght = (obj.getVal().toString().length()-1);
        String croppedObj = obj.getVal().toString().substring(1, valLenght);
        declarations += String.format(ASSIGN_STRING_DECLARATION, obj.getV1(), valLenght, croppedObj);

        String main_text = "";
        main_text += String.format(ASSIGN_STRING_LINE_1, ("%" + reg), ("%tmp_" + obj.getV1()));
        reg++;
        main_text += String.format(ASSIGN_STRING_LINE_2, ("%" + reg), ("%" + (reg-1)), valLenght, valLenght, obj.getV1());
        reg++;
        return main_text;
    }

    private boolean isTypeEquals(IntermediateObject obj, Type anInt) {
        return obj.getType().equals(anInt);
    }
}
