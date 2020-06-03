package com.asia.compiler.parser;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.errors.ThrowingErrorListener;
import com.asia.compiler.parser.gen.langLexer;
import com.asia.compiler.parser.gen.langParser;
import com.asia.compiler.parser.listeners.ControlFlowListener;
import com.asia.compiler.parser.listeners.IOListener;
import com.asia.compiler.parser.listeners.VariableListener;
import com.asia.compiler.parser.utils.Value;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.HashSet;

public class Parser {

    public List<IntermediateObject> parse(String code) {
        Map<String, Type> variableTypesMap = new HashMap<>();
        List<IntermediateObject> intermediateObjectList = new ArrayList<>();

        CharStream input = (CharStream) new ANTLRInputStream(code);

        langLexer lexer = prepareLexer(input);
        langParser parser = prepareParser(lexer, intermediateObjectList, variableTypesMap);

        try {
            parser.program();
        } catch (Exception e) {
            System.out.println("Message: " + e.getMessage());
        }
        System.out.println(intermediateObjectList);
        return intermediateObjectList;
    }

    private langLexer prepareLexer(CharStream input) {
        langLexer lexer = new langLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

        return lexer;
    }

    private langParser prepareParser(
            langLexer lexer,
            List<IntermediateObject> list,
            Map<String, Type> variableTypesMap) {
        Stack<Value> stack = new Stack<Value>();
        HashSet<String> functions = new HashSet<String>();

        langParser parser = new langParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        parser.setErrorHandler(new BailErrorStrategy());

        parser.addParseListener(new IOListener(list, variableTypesMap));
        parser.addParseListener(new VariableListener(list, variableTypesMap));
        parser.addParseListener(new ControlFlowListener(list, variableTypesMap, stack, functions, ""));
        return parser;
    }

}
