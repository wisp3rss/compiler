package com.asia.compiler.common.model;

import java.util.Stack;
import lombok.Data;

@Data
public class LabelStack {

    Stack<String> labelStack;
    int ifNumber;
    int elseNumber;
    int forNumber;
    int whileNumber;
    int doWhileNumber;

    public LabelStack() {
        labelStack = new Stack<>();
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
        }
    }

    public void decrementNumber(String methodName) {
        if ("IF".equals(methodName)) {
            ifNumber--;
        } else if ("ELSE".equals(methodName)) {
            elseNumber--;
        } else if ("FOR".equals(methodName)) {
            forNumber--;
        } else if ("WHILE".equals(methodName)) {
            whileNumber--;
        } else if ("DOWHILE".equals(methodName)) {
            doWhileNumber--;
        }
    }

}
