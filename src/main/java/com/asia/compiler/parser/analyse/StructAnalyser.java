package com.asia.compiler.parser.analyse;

import com.asia.compiler.common.model.ClassManager;
import com.asia.compiler.common.model.Field;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.StructContext;
import com.asia.compiler.parser.utils.CancellationExceptionFactory;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StructAnalyser extends langBaseListener {
    private final ClassManager classManager;

    @Override
    public void exitStruct(StructContext ctx) {
        String className = ctx.CLASS_NAME().getText();
        if(classManager.getStructMap().containsKey(className)){
            CancellationExceptionFactory.throwCancellationException(ctx, "Struct \"" + className + "\" already defined.");
            return;
        }

        List<Field> fields = ctx.def_var().stream()
            .map(o ->
                new Field(
                    o.NAME().getText(),
                    classManager.getType(o.define()),
                    ""))
            .collect(Collectors.toList());

        classManager.getStructMap().put(className, fields);
    }
}
