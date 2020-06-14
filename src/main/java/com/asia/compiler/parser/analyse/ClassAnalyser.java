package com.asia.compiler.parser.analyse;

import com.asia.compiler.common.model.ClassManager;
import com.asia.compiler.common.model.Field;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.Class_Context;
import com.asia.compiler.parser.gen.langParser.Def_classContext;
import com.asia.compiler.parser.utils.CancellationExceptionFactory;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClassAnalyser extends langBaseListener {

    private ClassManager classManager;

    @Override
    public void exitDef_class(Def_classContext ctx) {
        String className = ctx.CLASS_NAME().getText();
        if (classManager.getClassMap().containsKey(className)) {
            CancellationExceptionFactory.throwCancellationException(ctx, "Class " + className + " already defined.");
            return;
        } else {
            classManager.setCurrentDefClass(className);

        }
    }

    @Override
    public void exitClass_(Class_Context ctx) {
        classManager.setCurrentDefClass("Main");

        String classStructName = ctx.def_class().CLASS_NAME().getText();

        List<Field> fields = ctx.def_var().stream()
            .map(o ->
                new Field(
                    o.NAME().getText(),
                    classManager.getType(o.define()),
                    ""))
            .collect(Collectors.toList());

        List<Field> classes = ctx.create_class().stream()
            .map(o ->
                new Field(
                    o.NAME().getText(),
                    Type.CLASS_STRUCT,
                    o.CLASS_NAME(0).getText()))
            .collect(Collectors.toList());

        List<Field> structs = ctx.create_struct().stream()
            .map(o ->
                new Field(
                    o.NAME().getText(),
                    Type.CLASS_STRUCT,
                    o.CLASS_NAME(0).getText()))
            .collect(Collectors.toList());

        fields.addAll(classes);
        fields.addAll(structs);

        if (fields.stream().map(f -> f.getName()).distinct().count() != fields.size()) {
            CancellationExceptionFactory.throwCancellationException(ctx, "In class \"" + classStructName + "\" variable already defined.");
            return;
        }

        classManager.getStructMap().put(classStructName, fields);        //structmap zawiera wszystkie nazwy pol w klasach i strukturah
    }

}
