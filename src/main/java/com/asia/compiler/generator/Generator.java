package com.asia.compiler.generator;

import static com.asia.compiler.generator.utils.LLVMCodeParts.ASSIGN_STRING_DECLARATION;
import static com.asia.compiler.generator.utils.LLVMCodeParts.ASSIGN_STRING_LINE_1;
import static com.asia.compiler.generator.utils.LLVMCodeParts.ASSIGN_STRING_LINE_2;
import static com.asia.compiler.generator.utils.LLVMCodeParts.BOOL_CONDITION;
import static com.asia.compiler.generator.utils.LLVMCodeParts.CONDITION_OPERATION;
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
import com.asia.compiler.common.model.LabelStack;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generator {

    static String header_text = "";
    static int reg = 1;
    String result = "";
    String declarations = "";
    LabelStack labelStack;

    List<IntermediateObject> intermediateObjectList;

    public Generator(LabelStack labelStack) {
        this.labelStack = labelStack;
    }

    public String generate(List<IntermediateObject> list) {
        intermediateObjectList = list;

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

        intermediateObjectList.forEach(o -> result += generateHandler(o));

        result += "ret i32 0 }\n";
        return declarations + result;
    }

    private String generateHandler(IntermediateObject o) {
        switch (o.getInstructions()) {
            case PRINT:
                return generatePrint(o);
            case READ:
                return generateRead(o);
            case DECLARE:
                return generateDefine(o);
            case ASSIGN:
                return generateAssign(o);
            case ADD:
                return generateAdd(o);
            case SUB:
                return generateSub(o);
            case MUL:
                return generateMul(o);
            case DIV:
                return generateDiv(o);
            case MOD:
                return generateMod(o);
            case CONDITION_SIMPLE:
                return generateConditionSimple(o);
            case CONDITION_EXTENDED:
                return generateConditionExtended(o);
            case END_IF_ELSE:
                return generateEndIfElseLabel(o);
            case END_WHILE:
                return geneateWhileLabel(o);
            case DO_WHILE:
                return generateDoLabel(o);
            case END_DO_WHILE:
                return generateEndDoWhile(o);
        }
        return "";
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

        } else if (isTypeEquals(obj, Type.BOOL)) {
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

        } else if (isTypeEquals(obj, Type.BOOL)) {
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

        if (!isTypeEquals(obj, Type.BOOL)) {
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
        main_text += String.format(LOAD.getValue(), ("%" + reg), value, value, ("%" + obj.getArgs()._1()));
        varRegistry.put(obj.getArgs()._1().toString(), reg);
        reg++;
        main_text += String.format(MATH_OPERATION.getValue(), ("%" + reg), operation, value, ("%" + varRegistry.get(obj.getArgs()._1().toString())),
            obj.getArgs()._2());
        reg++;
        main_text += String.format(STORE.getValue(), value, ("%" + (reg - 1)), value, ("%" + obj.getV1()));
        return main_text;
    }

    private String generateMathNumVar(IntermediateObject obj, String operation, String main_text, Map<String, Integer> varRegistry, String value) {
        main_text += String.format(LOAD.getValue(), ("%" + reg), value, value, ("%" + obj.getArgs()._2()));
        varRegistry.put(obj.getArgs()._2().toString(), reg);
        reg++;
        main_text += String.format(MATH_OPERATION.getValue(), ("%" + reg), operation, value, obj.getArgs()._1(),
            ("%" + varRegistry.get(obj.getArgs()._2().toString())));
        reg++;
        main_text += String.format(STORE.getValue(), value, ("%" + (reg - 1)), value, ("%" + obj.getV1()));
        return main_text;
    }

    private String generateMathNumNum(IntermediateObject obj, String operation, String main_text, String value) {
        main_text += String.format(MATH_OPERATION.getValue(), ("%" + reg), operation, value, obj.getArgs()._1(), obj.getArgs()._2());
        reg++;
        main_text += String.format(STORE.getValue(), value, ("%" + (reg - 1)), value, ("%" + obj.getV1()));
        return main_text;
    }

    private String generateMathVarVar(IntermediateObject obj, String operation, String main_text, Map<String, Integer> varRegistry, String value) {
        main_text += String.format(LOAD.getValue(), ("%" + reg), value, value, ("%" + obj.getArgs()._1()));
        varRegistry.put(obj.getArgs()._1().toString(), reg);
        reg++;

        main_text += String.format(LOAD.getValue(), ("%" + reg), value, value, ("%" + obj.getArgs()._2()));
        varRegistry.put(obj.getArgs()._2().toString(), reg);
        reg++;

        main_text += String.format(MATH_OPERATION.getValue(), ("%" + reg), operation, value, ("%" + varRegistry.get(obj.getArgs()._1().toString())),
            ("%" + varRegistry.get(obj.getArgs()._2().toString())));
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
        if (obj.getVal().equals("true")) {
            boolValue = String.valueOf(1);
        } else if (obj.getVal().equals("false")) {
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
        String endLabel = "";

        if (obj.getV1().contains("if")) {
            if (!labelStack.getElseExistMap().get(label)) {
                endLabel = obj.getV2();
            } else {
                endLabel = "else_" + label.split("_")[1];
            }
        } else if (obj.getV1().contains("while")) {
            main_text += String.format(EXIT_JUMP.getValue(), ("%" + label + "_c"));
            main_text += String.format(LABEL.getValue(), (label + "_c"));

            endLabel = obj.getV2();
        }

        main_text = generateCondition(obj, main_text, typeValue, label, endLabel);

        return main_text;
    }

    private String generateCondition(IntermediateObject obj, String main_text, String typeValue, String label, String endLabel) {
        main_text += String.format(DEFINE_INT_FLOAT.getValue(), ("%" + reg), typeValue);
        reg++;
        main_text += String.format(STORE.getValue(), typeValue, obj.getVal(), typeValue, ("%" + (reg - 1)));
        main_text += String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + (reg - 1)));
        reg++;

        main_text += String.format(BOOL_CONDITION.getValue(), ("%" + reg), typeValue, ("%" + (reg - 1)));

        main_text += generateJumpInstruction(obj, label, endLabel);

        return main_text;
    }

    private int lastClosedIfIndex = -1;

    private String generateEndIfElseLabel(IntermediateObject obj) {
        String main_text = "";
        String endLabel = "";
        String label = "";
        Boolean lavelValue = labelStack.getElseExistMap().get(obj.getV1());

        if (lavelValue != null && !lavelValue) {
            /* if only */
            main_text += String.format(EXIT_JUMP.getValue(), ("%" + obj.getV2()));
            main_text += String.format(LABEL.getValue(), obj.getV2());
        } else {
            /* if else */

            if (obj.getV1().contains("if")) {
                lastClosedIfIndex++;
            }

            label = "else_" + labelStack.getLastClosedIf().get(lastClosedIfIndex).split("_")[1];
            endLabel = "end_" + label;
            main_text += String.format(EXIT_JUMP.getValue(), ("%" + endLabel));

            if (obj.getV1().contains("if")) {
                main_text += String.format(LABEL.getValue(), label);
            } else {
                main_text += String.format(LABEL.getValue(), endLabel);
                lastClosedIfIndex--;
            }
        }

        return main_text;
    }

    private String geneateWhileLabel(IntermediateObject obj) {
        String main_text = "";
        String label = obj.getV1();

        main_text += String.format(EXIT_JUMP.getValue(), ("%" + label + "_c"));
        main_text += String.format(LABEL.getValue(), obj.getV2());

        return main_text;
    }

    private String generateConditionExtended(IntermediateObject obj) {
        String main_text = "";
        Map<String, Integer> varRegistry = new HashMap<>();
        String typeValue = obj.getType().getValue();
        String label = obj.getV1();
        String endLabel = "";
        String operation = "";

        if (obj.getV1().contains("if")) {
            if (!labelStack.getElseExistMap().get(label)) {
                endLabel = obj.getV2();
            } else {
                endLabel = "else_" + label.split("_")[1];
            }
        } else if (obj.getV1().contains("while")) {
            main_text += String.format(EXIT_JUMP.getValue(), ("%" + label + "_c"));
            main_text += String.format(LABEL.getValue(), (label + "_c"));

            if (obj.getArgs().toSeq().toStream()
                .filter(o -> o.toString().contains("math_var")).size() > 0) {
                int objIndex = intermediateObjectList.indexOf(obj);
                main_text += generateHandler(intermediateObjectList.get(objIndex-1));
            }

            endLabel = obj.getV2();
        }

        operation = getOperation(obj);

        if (obj.getArgType().equals(ArgType.VAR_VAR)) {
            main_text = generateConditionVarVar(obj, main_text, varRegistry, typeValue, label, endLabel, operation);
        } else if (obj.getArgType().equals(ArgType.NUM_NUM)) {
            main_text = generateConditionNumNum(obj, main_text, typeValue, label, endLabel, operation);
        } else if (obj.getArgType().equals(ArgType.NUM_VAR)) {
            main_text = generateConditionNumVar(obj, main_text, varRegistry, typeValue, label, endLabel, operation);
        } else if (obj.getArgType().equals(ArgType.VAR_NUM)) {
            main_text = generateConditionVarNum(obj, main_text, varRegistry, typeValue, label, endLabel, operation);
        }
        return main_text;
    }

    private String getOperation(IntermediateObject obj) {
        if (obj.getVal().equals(">")) {
            return "sgt";
        } else if (obj.getVal().equals("<")) {
            return "slt";
        } else if (obj.getVal().equals(">=")) {
            return "sge";
        } else if (obj.getVal().equals("<=")) {
            return "sle";
        } else if (obj.getVal().equals("==")) {
            return "eq";
        } else if (obj.getVal().equals("!=")) {
            return "ne";
        } else if (obj.getVal().equals("!")) {
            return "ne";
        }
        return "";
    }

    private String generateConditionVarNum(IntermediateObject obj, String main_text, Map<String, Integer> varRegistry, String typeValue, String label,
        String endLabel, String operation) {

        main_text += String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + obj.getArgs()._1()));
        varRegistry.put(obj.getArgs()._1().toString(), reg);
        reg++;
        main_text += String.format(CONDITION_OPERATION.getValue(), ("%" + reg), operation, typeValue, ("%" + varRegistry.get(obj.getArgs()._1().toString())),
            obj.getArgs()._2());

        main_text += generateJumpInstruction(obj, label, endLabel);

        return main_text;
    }

    private String generateConditionNumVar(IntermediateObject obj, String main_text, Map<String, Integer> varRegistry, String typeValue, String label,
        String endLabel, String operation) {

        main_text += String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + obj.getArgs()._2()));
        varRegistry.put(obj.getArgs()._2().toString(), reg);
        reg++;

        main_text += String.format(CONDITION_OPERATION.getValue(), ("%" + reg), operation, typeValue, obj.getArgs()._1(),
            ("%" + varRegistry.get(obj.getArgs()._2().toString())));

        main_text += generateJumpInstruction(obj, label, endLabel);

        return main_text;
    }

    private String generateConditionVarVar(IntermediateObject obj, String main_text, Map<String, Integer> varRegistry, String typeValue, String label,
        String endLabel, String operation) {
        main_text += String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + obj.getArgs()._1()));
        varRegistry.put(obj.getArgs()._1().toString(), reg);
        reg++;

        main_text += String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + obj.getArgs()._2()));
        varRegistry.put(obj.getArgs()._2().toString(), reg);

        reg++;

        main_text += String.format(CONDITION_OPERATION.getValue(), ("%" + reg), operation, typeValue, ("%" + varRegistry.get(obj.getArgs()._1().toString())),
            ("%" + varRegistry.get(obj.getArgs()._2().toString())));

        main_text += generateJumpInstruction(obj, label, endLabel);

        return main_text;
    }

    private String generateConditionNumNum(IntermediateObject obj, String main_text, String typeValue, String label, String endLabel, String operation) {

        main_text += String.format(CONDITION_OPERATION.getValue(), ("%" + reg), operation, typeValue, obj.getArgs()._1(),
            obj.getArgs()._2());

        main_text += generateJumpInstruction(obj, label, endLabel);

        return main_text;
    }

    private String generateJumpInstruction(IntermediateObject obj, String label, String endLabel) {
        String main_text = "";

        main_text += String.format(IF_JUMP.getValue(), ("%" + (reg)), ("%" + (label)), ("%" + (endLabel)));

        if (obj.getV1().contains("dowhile")){
            main_text += String.format(LABEL.getValue(), endLabel);
        }
        else {
            main_text += String.format(LABEL.getValue(), label);
        }
        reg++;
        return main_text;
    }

    private String generateDoLabel(IntermediateObject obj){
        String main_text = "";
        String label = obj.getV1();

        main_text += String.format(EXIT_JUMP.getValue(), ("%" + label));
        main_text += String.format(LABEL.getValue(), obj.getV1());

        return main_text;
    }

    private String generateEndDoWhile(IntermediateObject obj){
        String main_text = "";
//        main_text += String.format(LABEL.getValue(), obj.getV2());

        return main_text;
    }
}