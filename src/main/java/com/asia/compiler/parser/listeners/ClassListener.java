package com.asia.compiler.parser.listeners;

import com.asia.compiler.common.model.ClassManager;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.Class_Context;
import com.asia.compiler.parser.gen.langParser.Def_classContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClassListener extends langBaseListener {

    private final VariableMap variableMap;
    private final ClassManager classManager;

    @Override
    public void enterClass_(Class_Context ctx) {
        variableMap.incrementLevel();
    }

    @Override
    public void exitDef_class(Def_classContext ctx) {
        String className = ctx.CLASS_NAME().getText();
        classManager.setCurrentDefClass(className);
    }

    @Override
    public void exitClass_(Class_Context ctx) {
        variableMap.decrementLevel();
        classManager.setCurrentDefClass("Main");
    }


}
