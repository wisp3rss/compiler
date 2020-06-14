package com.asia.compiler.parser.analyse;

import com.asia.compiler.common.model.ClassManager;
import com.asia.compiler.common.model.Function;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.Def_funcContext;
import com.asia.compiler.parser.utils.CancellationExceptionFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FunctionAnalyser extends langBaseListener {

    private ClassManager classManager;
    private VariableMap variableMap;

    @Override
    public void enterDef_func(Def_funcContext ctx) {
    }

    @Override
    public void exitDef_func(Def_funcContext ctx) {
        String name = ctx.NAME().getText();
        Type type = classManager.getType(ctx.define());
        List<Type> argsType = ctx.def_args().stream().map(o -> classManager.getType(o.define())).collect(Collectors.toList());
        List<String> argsName = ctx.def_args().stream().map(o -> o.NAME().getText()).collect(Collectors.toList());
        Function function = new Function(name, type, argsType, argsName);

        addFunction(ctx, name, function);
    }

    private void addFunction(Def_funcContext ctx, String name, Function function) {
        Map<String, List<Function>> classMap = classManager.getClassMap().get(getCurrentDefClass());
        if (!classMap.containsKey(name)) {
            List<Function> list = new ArrayList<>();
            list.add(function);
            classMap.put(name, list);
        } else {
            if (classMap.get(name).stream().noneMatch(f -> f.getArgsType().size() == function.getArgsType().size())) {
                classMap.get(name).add(function);
            } else {
                classMap.get(name).stream().filter(func ->

                    (IntStream.iterate(0, i -> i + 1)
                        .limit(function.getArgsType().size())
                        .filter(i -> function.getArgsType().size() == func.getArgsType().size() && function.getArgsType().get(i).name()
                            .equals(func.getArgsType().get(i).name()))
                        .count() == function.getArgsType().size())
                ).findAny().ifPresent(none -> {
                    CancellationExceptionFactory.throwCancellationException(ctx,
                        "Function \"" + name + "\" with parameters: " + function.getArgsType() + " in class \"" + getCurrentDefClass() + "\" already defined.");
                    return;
                });
                classMap.get(name).add(function);
            }
        }
    }

    private String getCurrentDefClass() {
        return classManager.getCurrentDefClass();
    }
}
