package com.asia.compiler.parser;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.errors.ThrowingErrorListener;
import com.asia.compiler.parser.gen.langLexer;
import com.asia.compiler.parser.gen.langParser;
import com.asia.compiler.parser.listeners.IOListener;
import com.asia.compiler.parser.listeners.VariableListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Parser {

    public List<IntermediateObject> parse(String code) {
//        Map<String, Type> variableTypesMap = new HashMap<>();
        VariableMap variableMap = new VariableMap();
        List<IntermediateObject> intermediateObjectList = new ArrayList<>();

        CharStream input = new ANTLRInputStream(code);

        langLexer lexer = prepareLexer(input);
        langParser parser = prepareParser(lexer, intermediateObjectList, variableMap);

        try {
            parser.program();
        } catch (Exception e) {
            System.out.println("Message: " + e.getMessage());
        }
        return intermediateObjectList;
    }

    private langLexer prepareLexer(CharStream input) {
        langLexer lexer = new langLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

        return lexer;
    }

    private langParser prepareParser(langLexer lexer, List<IntermediateObject> list, VariableMap variableMap) {
        langParser parser = new langParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        parser.setErrorHandler(new BailErrorStrategy());

        parser.addParseListener(new IOListener(list, variableMap));
        parser.addParseListener(new VariableListener(list, variableMap));

        return parser;
    }

}
