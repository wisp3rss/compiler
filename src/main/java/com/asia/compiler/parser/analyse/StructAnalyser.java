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

    private ClassManager classManager;

    @Override
    public void exitStruct(StructContext ctx) {
        String className = ctx.CLASS_NAME().getText();
        if (classManager.getStructMap().containsKey(className)) {
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

        if (fields.stream().map(f -> f.getName()).distinct().count() != fields.size()) {
            CancellationExceptionFactory.throwCancellationException(ctx, "In struct \"" + className + "\" variable already defined.");
            return;
        }

        classManager.getStructMap().put(className, fields);
    }
}
