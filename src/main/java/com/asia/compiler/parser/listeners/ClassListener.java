package com.asia.compiler.parser.listeners;

import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.Class_Context;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClassListener extends langBaseListener {

    private VariableMap variableMap;

    @Override
    public void enterClass_(Class_Context ctx) {
        variableMap.incrementLevel();
    }

    @Override
    public void exitClass_(Class_Context ctx) {
        variableMap.decrementLevel();
    }
}
