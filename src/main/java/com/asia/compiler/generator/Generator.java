package com.asia.compiler.generator;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.LabelStack;
import com.asia.compiler.common.utils.ArgType;
import com.asia.compiler.common.utils.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.asia.compiler.generator.utils.LLVMCodeParts.*;

public class Generator {

    static String header_text = "";
    static int reg = 1;
    String result = "";
    String declarations = "";
    LabelStack labelStack;

    public Generator(LabelStack labelStack) {
        this.labelStack = labelStack;
    }

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
                        case CONDITION_EXTENDED:
                            result += generateConditionExtended(o);
                            break;
                        case END_IF_ELSE:
                            result += generateEndIfElseLabel(o);
                            break;
                        case END_WHILE:
                            result += geneateWhileLabel(o);
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

        main_text += String.format(IF_JUMP.getValue(), ("%" + (reg)), ("%" + (label)), ("%" + (endLabel)));

        main_text += String.format(LABEL.getValue(), label);
        reg++;
        return main_text;
    }

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
            System.out.println(labelStack.getLastClosedIf().get(0));
            label = "else_" + labelStack.getLastClosedIf().get(0).split("_")[1];
            endLabel = "end_" + label;
            main_text += String.format(EXIT_JUMP.getValue(), ("%" + endLabel));

            if (obj.getV1().contains("if")) {
                main_text += String.format(LABEL.getValue(), label);
            } else {
                main_text += String.format(LABEL.getValue(), endLabel);
                labelStack.getLastClosedIf().remove(0);
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

    private String generateConditionVarNum(IntermediateObject obj, String main_text, Map<String, Integer> varRegistry, String typeValue, String label, String endLabel, String operation) {

        main_text += String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + obj.getArgs()._1()));
        varRegistry.put(obj.getArgs()._1().toString(), reg);
        reg++;
        main_text += String.format(CONDITION_OPERATION.getValue(), ("%" + reg), operation, typeValue, ("%" + varRegistry.get(obj.getArgs()._1().toString())),
                obj.getArgs()._2());

        main_text += generateJumpInstruction(obj, label, endLabel);

        return main_text;
    }

    private String generateConditionNumVar(IntermediateObject obj, String main_text, Map<String, Integer> varRegistry, String typeValue, String label, String endLabel, String operation) {

        main_text += String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + obj.getArgs()._2()));
        varRegistry.put(obj.getArgs()._2().toString(), reg);
        reg++;

        main_text += String.format(CONDITION_OPERATION.getValue(), ("%" + reg), operation, typeValue, obj.getArgs()._1(), ("%" + varRegistry.get(obj.getArgs()._2().toString())));

        main_text += generateJumpInstruction(obj.getVal(), label, endLabel);

        return main_text;
    }

    private String generateConditionVarVar(IntermediateObject obj, String main_text, Map<String, Integer> varRegistry, String typeValue, String label, String endLabel, String operation) {
        main_text += String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + obj.getArgs()._1()));
        varRegistry.put(obj.getArgs()._1().toString(), reg);
        reg++;

        main_text += String.format(LOAD.getValue(), ("%" + reg), typeValue, typeValue, ("%" + obj.getArgs()._2()));
        varRegistry.put(obj.getArgs()._2().toString(), reg);

        reg++;

        main_text += String.format(CONDITION_OPERATION.getValue(), ("%" + reg), operation, typeValue, ("%" + varRegistry.get(obj.getArgs()._1().toString())), ("%" + varRegistry.get(obj.getArgs()._2().toString())));

        main_text += generateJumpInstruction(obj.getVal(), label, endLabel);

        return main_text;
    }

    private String generateConditionNumNum(IntermediateObject obj, String main_text, String typeValue, String label, String endLabel, String operation) {

        main_text += String.format(CONDITION_OPERATION.getValue(), ("%" + reg), operation, typeValue, obj.getArgs()._1(),
                obj.getArgs()._2());

        main_text += generateJumpInstruction(obj, label, endLabel);

        return main_text;
    }

    private String generateJumpInstruction(Object val, String label, String endLabel) {
        String main_text = "";

        if (val.toString().equals("!")) {
            main_text += String.format(IF_JUMP.getValue(), ("%" + (reg)), ("%" + (endLabel)), ("%" + (label)));
        }
        main_text += String.format(IF_JUMP.getValue(), ("%" + (reg)), ("%" + (label)), ("%" + (endLabel)));

        main_text += String.format(LABEL.getValue(), label);
        reg++;
        return main_text;
    }
}

