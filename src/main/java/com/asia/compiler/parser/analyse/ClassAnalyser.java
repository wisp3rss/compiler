package com.asia.compiler.parser.analyse;

import com.asia.compiler.common.model.ClassManager;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.Class_Context;
import com.asia.compiler.parser.utils.CancellationExceptionFactory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClassAnalyser extends langBaseListener {

    private final ClassManager classManager;

    @Override
    public void enterClass_(Class_Context ctx) {
        String className = ctx.CLASS_NAME().getText();
        if(classManager.getClassMap().containsKey(className)){
            CancellationExceptionFactory.throwCancellationException(ctx, "Class " + className + " already defined.");
            return;
        } else {
            classManager.setCurrentDefClass(className);

        }
    }

    @Override
    public void exitClass_(Class_Context ctx) {
        classManager.setCurrentDefClass("Main");
    }

}
