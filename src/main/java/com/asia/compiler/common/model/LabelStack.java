package com.asia.compiler.common.model;

import java.util.*;

import lombok.Data;
import lombok.Setter;

@Data
public class LabelStack {

    Stack<String> labelStack;
    int ifNumber;
    int elseNumber;
    int forNumber;
    int whileNumber;
    int doWhileNumber;
    int mathVarNumber;
    Map<String,Boolean> elseExistMap;
    List<String> lastClosedIf;

    public LabelStack() {

        labelStack = new Stack<>();
        elseExistMap = new HashMap<>();
        lastClosedIf = new ArrayList<>();
        mathVarNumber = 0;
    }

    public void incrementNumber(String methodName) {
        if ("IF".equals(methodName)) {
            ifNumber++;
        } else if ("ELSE".equals(methodName)) {
            elseNumber++;
        } else if ("FOR".equals(methodName)) {
            forNumber++;
        } else if ("WHILE".equals(methodName)) {
            whileNumber++;
        } else if ("DOWHILE".equals(methodName)) {
            doWhileNumber++;
        } else if ("MATH_VAR".equals(methodName)) {
            mathVarNumber++;
        }
    }

    public int getMathVarNumber() {
        int value = mathVarNumber;
        mathVarNumber++;
        return value;
    }

    public void changeElseExist(String label, boolean value){
        elseExistMap.put(label,value);
    }

}
