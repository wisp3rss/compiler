package com.asia.compiler.parser.listeners;

import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.StructContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StructListener extends langBaseListener {

    private final VariableMap variableMap;

    @Override
    public void enterStruct(StructContext ctx) {
        variableMap.incrementLevel();
    }

    @Override
    public void exitStruct(StructContext ctx) {
        variableMap.decrementLevel();
    }
}
