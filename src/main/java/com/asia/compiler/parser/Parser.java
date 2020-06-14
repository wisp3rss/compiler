package com.asia.compiler.parser;

import com.asia.compiler.common.model.ClassManager;
import com.asia.compiler.common.model.IntermediateObjectsData;
import com.asia.compiler.common.model.LabelStack;
import com.asia.compiler.common.model.VariableMap;
import com.asia.compiler.parser.analyse.ClassAnalyser;
import com.asia.compiler.parser.analyse.FunctionAnalyser;
import com.asia.compiler.parser.analyse.StructAnalyser;
import com.asia.compiler.parser.errors.ThrowingErrorListener;
import com.asia.compiler.parser.gen.langLexer;
import com.asia.compiler.parser.gen.langParser;
import com.asia.compiler.parser.listeners.ClassListener;
import com.asia.compiler.parser.listeners.ConditionListener;
import com.asia.compiler.parser.listeners.FunctionListener;
import com.asia.compiler.parser.listeners.IOListener;
import com.asia.compiler.parser.listeners.LoopListener;
import com.asia.compiler.parser.listeners.StructListener;
import com.asia.compiler.parser.listeners.VariableListener;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.Optional;

@AllArgsConstructor(staticName = "of")
public class Parser {
    LabelStack labelStack;

    public Optional<IntermediateObjectsData> parse(String code) {
        VariableMap variableMap = new VariableMap();
        IntermediateObjectsData intermediateObjectsData = new IntermediateObjectsData();
        ClassManager classManager = new ClassManager();

        CharStream input = new ANTLRInputStream(code);

        langLexer analyseLexer = prepareLexer(new ANTLRInputStream(code));
        langLexer lexer = prepareLexer(new ANTLRInputStream(code));
        langParser parser = prepareParser(lexer, intermediateObjectsData, variableMap, labelStack, classManager);
        langParser analyseParser = prepareAnalyseParser(analyseLexer, classManager, variableMap);

        try {
            analyseParser.program();
            parser.program();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return Optional.empty();
        }
        return Optional.of(intermediateObjectsData);
    }

    private langLexer prepareLexer(CharStream input) {
        langLexer lexer = new langLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

        return lexer;
    }

    private langParser prepareParser(langLexer lexer, IntermediateObjectsData data, VariableMap variableMap, LabelStack labelStack, ClassManager classManager) {
        langParser parser = new langParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        parser.setErrorHandler(new BailErrorStrategy());

        VariableListener variableListener = new VariableListener(variableMap, labelStack, data, classManager);
        ConditionListener conditionListener = new ConditionListener(variableMap, labelStack, data, classManager);

        parser.addParseListener(new IOListener(variableMap, data, classManager));
        parser.addParseListener(variableListener);
        parser.addParseListener(conditionListener);
        parser.addParseListener(new LoopListener(variableMap, labelStack, data, classManager));
        parser.addParseListener(new FunctionListener(data, classManager, variableMap));
        parser.addParseListener(new ClassListener(variableMap));
        parser.addParseListener(new StructListener(variableMap));

        return parser;
    }

    private langParser prepareAnalyseParser(langLexer lexer, ClassManager classManager, VariableMap variableMap){
        langParser parser = new langParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        parser.setErrorHandler(new BailErrorStrategy());

        parser.addParseListener(new ClassAnalyser(classManager));
        parser.addParseListener(new StructAnalyser(classManager));
        parser.addParseListener(new FunctionAnalyser(classManager, variableMap));

        return parser;
    }

}
