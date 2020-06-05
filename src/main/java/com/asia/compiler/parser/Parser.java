package com.asia.compiler.parser;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.common.model.LabelStack;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.parser.errors.ThrowingErrorListener;
import com.asia.compiler.parser.gen.langLexer;
import com.asia.compiler.parser.gen.langParser;
import com.asia.compiler.parser.listeners.ConditionListener;
import com.asia.compiler.parser.listeners.IOListener;
import com.asia.compiler.parser.listeners.LoopListener;
import com.asia.compiler.parser.listeners.VariableListener;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor(staticName = "of")
public class Parser {
    LabelStack labelStack;

    public Optional<List<IntermediateObject>> parse(String code) {
        VariableMap variableMap = new VariableMap();
        List<IntermediateObject> intermediateObjectList = new ArrayList<>();

        CharStream input = new ANTLRInputStream(code);

        langLexer lexer = prepareLexer(input);
        langParser parser = prepareParser(lexer, intermediateObjectList, variableMap, labelStack);

        try {
            parser.program();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return Optional.empty();
        }
        return Optional.of(intermediateObjectList);
    }

    private langLexer prepareLexer(CharStream input) {
        langLexer lexer = new langLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

        return lexer;
    }

    private langParser prepareParser(langLexer lexer, List<IntermediateObject> list, VariableMap variableMap, LabelStack labelStack) {
        langParser parser = new langParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        parser.setErrorHandler(new BailErrorStrategy());

        parser.addParseListener(new IOListener(list, variableMap));
        parser.addParseListener(new VariableListener(list, variableMap));
        parser.addParseListener(new ConditionListener(list, variableMap, labelStack));
        parser.addParseListener(new LoopListener(list, variableMap, labelStack));

        return parser;
    }

}
