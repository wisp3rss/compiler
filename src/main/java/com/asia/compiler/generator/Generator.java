package com.asia.compiler.generator;

import static com.asia.compiler.generator.utils.LLVMCodeParts.ASSIGN_STRING_DECLARATION;
import static com.asia.compiler.generator.utils.LLVMCodeParts.ASSIGN_STRING_LINE_1;
import static com.asia.compiler.generator.utils.LLVMCodeParts.ASSIGN_STRING_LINE_2;
import static com.asia.compiler.generator.utils.LLVMCodeParts.BOOL_CONDITION;
import static com.asia.compiler.generator.utils.LLVMCodeParts.DEFINE_INT_FLOAT;
import static com.asia.compiler.generator.utils.LLVMCodeParts.DEFINE_STRING;
import static com.asia.compiler.generator.utils.LLVMCodeParts.EXIT_JUMP;
import static com.asia.compiler.generator.utils.LLVMCodeParts.IF_JUMP;
import static com.asia.compiler.generator.utils.LLVMCodeParts.LABEL;
import static com.asia.compiler.generator.utils.LLVMCodeParts.LOAD;
import static com.asia.compiler.generator.utils.LLVMCodeParts.MATH_OPERATION;
import static com.asia.compiler.generator.utils.LLVMCodeParts.PRINT_BOOL;
import static com.asia.compiler.generator.utils.LLVMCodeParts.PRINT_FLOAT;
import static com.asia.compiler.generator.utils.LLVMCodeParts.PRINT_INT;
import static com.asia.compiler.generator.utils.LLVMCodeParts.PRINT_STRING_LINE_1;
import static com.asia.compiler.generator.utils.LLVMCodeParts.PRINT_STRING_LINE_2;
import static com.asia.compiler.generator.utils.LLVMCodeParts.READ_BOOL;
import static com.asia.compiler.generator.utils.LLVMCodeParts.READ_FLOAT;
import static com.asia.compiler.generator.utils.LLVMCodeParts.READ_INT;
import static com.asia.compiler.generator.utils.LLVMCodeParts.READ_STRING_LNE_1;
import static com.asia.compiler.generator.utils.LLVMCodeParts.READ_STRING_LNE_2;
import static com.asia.compiler.generator.utils.LLVMCodeParts.STORE;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.utils.ArgType;
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
        result += "@.strbool = private unnamed_addr constant [4 x i8] c\"%u\\0A\\00\"\n";
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
                    case CONDITION_SIMPLE:
                        result += generateConditionSimple(o);
                        break;
                    case END:
                        result += generateEndLabel(o);
                        break;
                }
            }
        );
        result += "ret i32 0 }\n";
        return declarations + result;
    }

    private String generatePrint(IntermediateObject obj) {
        String typeValue = obj.getType().getValue();
        String main_text = String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + obj.getV1()));
        reg++;

        if (isTypeEquals(obj, Type.INT)) {
            main_text += String.format(PRINT_INT.getValue(), ("%" + reg), typeValue, ("%" + (reg - 1)));
            reg++;

        } else if (isTypeEquals(obj, Type.FLOAT)) {
            main_text += String.format(PRINT_FLOAT.getValue(), ("%" + reg), typeValue, ("%" + (reg - 1)));
            reg++;

        } else if (isTypeEquals(obj, Type.STRING)) {
            main_text += String.format(PRINT_STRING_LINE_1.getValue(), ("%" + reg), ("%tmp_" + obj.getV1()));
            reg++;

            main_text += String.format(PRINT_STRING_LINE_2.getValue(), ("%" + reg), ("%" + (reg - 1)));
            reg++;

            //TODO chce miec true/false zamiast 1/0
        } else if (isTypeEquals(obj, Type.BOOL)){
            main_text += String.format(PRINT_BOOL.getValue(), ("%" + reg), typeValue, typeValue, ("%" + (reg - 1)));
            reg++;
        }

        return main_text;
    }

    private String generateRead(IntermediateObject obj) {
        String typeValue = obj.getType().getValue();
        String main_text = "";

        if (isTypeEquals(obj, Type.INT)) {
            main_text += String.format(READ_INT.getValue(), ("%" + reg), typeValue, ("%" + obj.getV1()));

        } else if (isTypeEquals(obj, Type.FLOAT)) {
            main_text += String.format(READ_FLOAT.getValue(), ("%" + reg), typeValue, ("%" + obj.getV1()));

        } else if (isTypeEquals(obj, Type.STRING)) {
            main_text += String.format(READ_STRING_LNE_1.getValue(), ("%" + reg), ("%tmp_" + obj.getV1()));
            reg++;
            main_text += String.format(READ_STRING_LNE_2.getValue(), ("%" + reg), ("%" + (reg - 1)));

        } else if (isTypeEquals(obj, Type.BOOL)){
            main_text += String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + obj.getV1()));
            reg++;
            main_text += String.format(READ_BOOL.getValue(), ("%" + reg), typeValue, typeValue, ("%" + obj.getV1()));
        }

        reg++;
        return main_text;
    }

    private String generateDefine(IntermediateObject obj) {
        String typeValue = obj.getType().getValue();
        String main_text = "";

        if(!isTypeEquals(obj, Type.BOOL)) {
            main_text += String.format(DEFINE_INT_FLOAT.getValue(), ("%" + obj.getV1()), typeValue);

        } else {
            main_text += String.format(DEFINE_INT_FLOAT.getValue(), ("%tmp_" + obj.getV1()), typeValue);
            main_text += String.format(DEFINE_INT_FLOAT.getValue(), ("%" + obj.getV1()), typeValue);
            main_text += String.format(STORE.getValue(), typeValue, 0, typeValue, ("%tmp_" + obj.getV1()));
        }

        if (isTypeEquals(obj, Type.STRING)) {
            main_text += String.format(DEFINE_STRING.getValue(), ("%tmp_" + obj.getV1()), ("%" + obj.getV1()));
        }

        return main_text;
    }

    private String generateMathOperationResult(IntermediateObject obj, String operation) {
        String main_text = "";
        Map<String, Integer> varRegistry = new HashMap<>();
        String value = obj.getType().getValue();

        if (obj.getArgType().equals(ArgType.VAR_VAR)) {
            main_text = generateMathVarVar(obj, operation, main_text, varRegistry, value);
        } else if (obj.getArgType().equals(ArgType.NUM_NUM)) {
            main_text = generateMathNumNum(obj, operation, main_text, value);
        } else if (obj.getArgType().equals(ArgType.NUM_VAR)) {
            main_text = generateMathNumVar(obj, operation, main_text, varRegistry, value);
        } else if (obj.getArgType().equals(ArgType.VAR_NUM)) {
            main_text = generateMathVarNum(obj, operation, main_text, varRegistry, value);
        }
        return main_text;
    }

    private String generateMathVarNum(IntermediateObject obj, String operation, String main_text, Map<String, Integer> varRegistry, String value) {
        main_text += String.format(LOAD.getValue(), ("%" + reg), value, value, ("%" + obj.getMathArgs()._1()));
        varRegistry.put(obj.getMathArgs()._1().toString(), reg);
        reg++;
        main_text += String.format(MATH_OPERATION.getValue(), ("%" + reg), operation, value, ("%" + varRegistry.get(obj.getMathArgs()._1().toString())),
            obj.getMathArgs()._2());
        reg++;
        main_text += String.format(STORE.getValue(), value, ("%" + (reg - 1)), value, ("%" + obj.getV1()));
        return main_text;
    }

    private String generateMathNumVar(IntermediateObject obj, String operation, String main_text, Map<String, Integer> varRegistry, String value) {
        main_text += String.format(LOAD.getValue(), ("%" + reg), value, value, ("%" + obj.getMathArgs()._2()));
        varRegistry.put(obj.getMathArgs()._2().toString(), reg);
        reg++;
        main_text += String.format(MATH_OPERATION.getValue(), ("%" + reg), operation, value, obj.getMathArgs()._1(),
            ("%" + varRegistry.get(obj.getMathArgs()._2().toString())));
        reg++;
        main_text += String.format(STORE.getValue(), value, ("%" + (reg - 1)), value, ("%" + obj.getV1()));
        return main_text;
    }

    private String generateMathNumNum(IntermediateObject obj, String operation, String main_text, String value) {
        main_text += String.format(MATH_OPERATION.getValue(), ("%" + reg), operation, value, obj.getMathArgs()._1(), obj.getMathArgs()._2());
        reg++;
        main_text += String.format(STORE.getValue(), value, ("%" + (reg - 1)), value, ("%" + obj.getV1()));
        return main_text;
    }

    private String generateMathVarVar(IntermediateObject obj, String operation, String main_text, Map<String, Integer> varRegistry, String value) {
        main_text += String.format(LOAD.getValue(), ("%" + reg), value, value, ("%" + obj.getMathArgs()._1()));
        varRegistry.put(obj.getMathArgs()._1().toString(), reg);
        reg++;

        main_text += String.format(LOAD.getValue(), ("%" + reg), value, value, ("%" + obj.getMathArgs()._2()));
        varRegistry.put(obj.getMathArgs()._2().toString(), reg);
        reg++;

        main_text += String.format(MATH_OPERATION.getValue(), ("%" + reg), operation, value, ("%" + varRegistry.get(obj.getMathArgs()._1().toString())),
            ("%" + varRegistry.get(obj.getMathArgs()._2().toString())));
        reg++;
        main_text += String.format(STORE.getValue(), value, ("%" + (reg - 1)), value, ("%" + obj.getV1()));
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
        String typeValue = obj.getType().getValue();
        String boolValue = "0"; //default false
        String main_text = "";

        if (isTypeEquals(obj, Type.STRING)) {
            main_text += generateAssignString(obj);

        } else if (isTypeEquals(obj, Type.BOOL)) {
            boolValue = convertBoolValue(obj, boolValue);
            main_text += String.format(STORE.getValue(), typeValue, boolValue, typeValue, ("%" + obj.getV1()));

        } else {
            main_text += String.format(STORE.getValue(), typeValue, obj.getVal(), typeValue, ("%" + obj.getV1()));
        }
        return main_text;
    }

    private String convertBoolValue(IntermediateObject obj, String boolValue) {
        if (obj.getVal().equals("true")){
            boolValue = String.valueOf(1);
        } else if(obj.getVal().equals("false")){
            boolValue = String.valueOf(0);
        }
        return boolValue;
    }

    private String generateAssignString(IntermediateObject obj) {
        int valLenght = (obj.getVal().toString().length() - 1);
        String croppedObj = obj.getVal().toString().substring(1, valLenght);
        declarations += String.format(ASSIGN_STRING_DECLARATION.getValue(), obj.getV1(), valLenght, croppedObj);

        String main_text = "";
        main_text += String.format(ASSIGN_STRING_LINE_1.getValue(), ("%" + reg), ("%tmp_" + obj.getV1()));
        reg++;
        main_text += String.format(ASSIGN_STRING_LINE_2.getValue(), ("%" + reg), ("%" + (reg - 1)), valLenght, valLenght, obj.getV1());
        reg++;
        return main_text;
    }

    private boolean isTypeEquals(IntermediateObject obj, Type type) {
        return obj.getType().equals(type);
    }

    private String generateConditionSimple(IntermediateObject obj) {
        String main_text = "";
        String typeValue = obj.getType().getValue();
        String label = obj.getV1();
        String endLabel = obj.getV2();

        main_text += String.format(DEFINE_INT_FLOAT.getValue(), ("%" + reg), typeValue);
        reg++;
        main_text += String.format(STORE.getValue(), typeValue, obj.getVal(), typeValue, ("%" + (reg-1)));
        main_text += String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + (reg-1)));
        reg++;
        main_text += String.format(BOOL_CONDITION.getValue(), ("%" + reg), typeValue, ("%" + (reg-1)));


        main_text += String.format(IF_JUMP.getValue(), ("%" + (reg)), ("%" + (label)), ("%" + (endLabel)));

        main_text +=  String.format(LABEL.getValue(), label);
        reg++;

        return main_text;
    }

    private String generateEndLabel(IntermediateObject obj) {
        String main_text = "";
        main_text += String.format(EXIT_JUMP.getValue(), ("%" + obj.getV1()));
        main_text += String.format(LABEL.getValue(), obj.getV1());
        return main_text;
    }

}
