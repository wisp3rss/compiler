package com.asia.compiler.parser.gen;

import java.util.List;
import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langParser extends Parser {

    static {
        RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int
        T__0 = 1, T__1 = 2, READ = 3, PRINT = 4, ASSIGN = 5, SEMI_COLON = 6, INT = 7, FLOAT = 8,
        PLUS = 9, MINUS = 10, DIV = 11, MULT = 12, MOD = 13, DEF_INT = 14, DEF_FLOAT = 15, NAME = 16,
        NAME_PREFIX = 17, BLANK = 18, NEXT_LINE = 19, UNKNOWN_CHAR = 20;
    public static final int
        RULE_program = 0, RULE_statement = 1, RULE_def_var = 2, RULE_assign_var = 3,
        RULE_read = 4, RULE_print = 5, RULE_define = 6, RULE_operation = 7, RULE_init_var = 8,
        RULE_numeric_value = 9, RULE_math_var = 10, RULE_value = 11, RULE_math_module = 12;

    private static String[] makeRuleNames() {
        return new String[]{
            "program", "statement", "def_var", "assign_var", "read", "print", "define",
            "operation", "init_var", "numeric_value", "math_var", "value", "math_module"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
            null, "'('", "')'", "'READ'", "'PRINT'", "'='", "';'", null, null, "'+'",
            "'-'", "'/'", "'*'", "'%'", "'INT'", "'FLOAT'", null, "'V_'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
            null, null, null, "READ", "PRINT", "ASSIGN", "SEMI_COLON", "INT", "FLOAT",
            "PLUS", "MINUS", "DIV", "MULT", "MOD", "DEF_INT", "DEF_FLOAT", "NAME",
            "NAME_PREFIX", "BLANK", "NEXT_LINE", "UNKNOWN_CHAR"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "lang.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public langParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class ProgramContext extends ParserRuleContext {

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public ProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_program;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterProgram(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitProgram(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitProgram(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final ProgramContext program() throws RecognitionException {
        ProgramContext _localctx = new ProgramContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_program);
        int _la;
        try {
            setState(32);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case READ:
                case PRINT:
                case DEF_INT:
                case DEF_FLOAT:
                case NAME:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(27);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    do {
                        {
                            {
                                setState(26);
                                statement();
                            }
                        }
                        setState(29);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    } while ((((_la) & ~0x3f) == 0
                        && ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << DEF_INT) | (1L << DEF_FLOAT) | (1L << NAME))) != 0));
                }
                break;
                case EOF:
                    enterOuterAlt(_localctx, 2);
                {
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StatementContext extends ParserRuleContext {

        public Def_varContext def_var() {
            return getRuleContext(Def_varContext.class, 0);
        }

        public Assign_varContext assign_var() {
            return getRuleContext(Assign_varContext.class, 0);
        }

        public ReadContext read() {
            return getRuleContext(ReadContext.class, 0);
        }

        public PrintContext print() {
            return getRuleContext(PrintContext.class, 0);
        }

        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterStatement(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitStatement(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitStatement(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_statement);
        try {
            setState(38);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case DEF_INT:
                case DEF_FLOAT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(34);
                    def_var();
                }
                break;
                case NAME:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(35);
                    assign_var();
                }
                break;
                case READ:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(36);
                    read();
                }
                break;
                case PRINT:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(37);
                    print();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Def_varContext extends ParserRuleContext {

        public DefineContext define() {
            return getRuleContext(DefineContext.class, 0);
        }

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public TerminalNode SEMI_COLON() {
            return getToken(langParser.SEMI_COLON, 0);
        }

        public Def_varContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_def_var;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterDef_var(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitDef_var(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitDef_var(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Def_varContext def_var() throws RecognitionException {
        Def_varContext _localctx = new Def_varContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_def_var);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(40);
                define();
                setState(41);
                match(NAME);
                setState(42);
                match(SEMI_COLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Assign_varContext extends ParserRuleContext {

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public TerminalNode ASSIGN() {
            return getToken(langParser.ASSIGN, 0);
        }

        public OperationContext operation() {
            return getRuleContext(OperationContext.class, 0);
        }

        public TerminalNode SEMI_COLON() {
            return getToken(langParser.SEMI_COLON, 0);
        }

        public Assign_varContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assign_var;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterAssign_var(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitAssign_var(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitAssign_var(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Assign_varContext assign_var() throws RecognitionException {
        Assign_varContext _localctx = new Assign_varContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_assign_var);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(44);
                match(NAME);
                setState(45);
                match(ASSIGN);
                setState(46);
                operation();
                setState(47);
                match(SEMI_COLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ReadContext extends ParserRuleContext {

        public TerminalNode READ() {
            return getToken(langParser.READ, 0);
        }

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public TerminalNode SEMI_COLON() {
            return getToken(langParser.SEMI_COLON, 0);
        }

        public ReadContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_read;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterRead(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitRead(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitRead(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final ReadContext read() throws RecognitionException {
        ReadContext _localctx = new ReadContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_read);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(49);
                match(READ);
                setState(50);
                match(NAME);
                setState(51);
                match(SEMI_COLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PrintContext extends ParserRuleContext {

        public TerminalNode PRINT() {
            return getToken(langParser.PRINT, 0);
        }

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public TerminalNode SEMI_COLON() {
            return getToken(langParser.SEMI_COLON, 0);
        }

        public PrintContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_print;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterPrint(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitPrint(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitPrint(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final PrintContext print() throws RecognitionException {
        PrintContext _localctx = new PrintContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_print);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(53);
                match(PRINT);
                setState(54);
                match(NAME);
                setState(55);
                match(SEMI_COLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DefineContext extends ParserRuleContext {

        public TerminalNode DEF_INT() {
            return getToken(langParser.DEF_INT, 0);
        }

        public TerminalNode DEF_FLOAT() {
            return getToken(langParser.DEF_FLOAT, 0);
        }

        public DefineContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterDefine(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitDefine(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitDefine(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final DefineContext define() throws RecognitionException {
        DefineContext _localctx = new DefineContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_define);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(57);
                _la = _input.LA(1);
                if (!(_la == DEF_INT || _la == DEF_FLOAT)) {
                    _errHandler.recoverInline(this);
                } else {
					if (_input.LA(1) == Token.EOF) {
						matchedEOF = true;
					}
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OperationContext extends ParserRuleContext {

        public Init_varContext init_var() {
            return getRuleContext(Init_varContext.class, 0);
        }

        public Math_moduleContext math_module() {
            return getRuleContext(Math_moduleContext.class, 0);
        }

        public OperationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_operation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterOperation(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitOperation(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitOperation(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final OperationContext operation() throws RecognitionException {
        OperationContext _localctx = new OperationContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_operation);
        try {
            setState(61);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(59);
                    init_var();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(60);
                    math_module(0);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Init_varContext extends ParserRuleContext {

        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        public Init_varContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_init_var;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterInit_var(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitInit_var(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitInit_var(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Init_varContext init_var() throws RecognitionException {
        Init_varContext _localctx = new Init_varContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_init_var);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(63);
                value();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Numeric_valueContext extends ParserRuleContext {

        public TerminalNode INT() {
            return getToken(langParser.INT, 0);
        }

        public TerminalNode FLOAT() {
            return getToken(langParser.FLOAT, 0);
        }

        public Numeric_valueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_numeric_value;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterNumeric_value(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitNumeric_value(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitNumeric_value(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Numeric_valueContext numeric_value() throws RecognitionException {
        Numeric_valueContext _localctx = new Numeric_valueContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_numeric_value);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(65);
                _la = _input.LA(1);
                if (!(_la == INT || _la == FLOAT)) {
                    _errHandler.recoverInline(this);
                } else {
					if (_input.LA(1) == Token.EOF) {
						matchedEOF = true;
					}
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Math_varContext extends ParserRuleContext {

        public Numeric_valueContext numeric_value() {
            return getRuleContext(Numeric_valueContext.class, 0);
        }

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public Math_varContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_math_var;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterMath_var(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitMath_var(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitMath_var(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Math_varContext math_var() throws RecognitionException {
        Math_varContext _localctx = new Math_varContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_math_var);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(69);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case INT:
                    case FLOAT: {
                        setState(67);
                        numeric_value();
                    }
                    break;
                    case NAME: {
                        setState(68);
                        match(NAME);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ValueContext extends ParserRuleContext {

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public Numeric_valueContext numeric_value() {
            return getRuleContext(Numeric_valueContext.class, 0);
        }

        public ValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_value;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterValue(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitValue(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitValue(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final ValueContext value() throws RecognitionException {
        ValueContext _localctx = new ValueContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_value);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(73);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case NAME: {
                        setState(71);
                        match(NAME);
                    }
                    break;
                    case INT:
                    case FLOAT: {
                        setState(72);
                        numeric_value();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Math_moduleContext extends ParserRuleContext {

        public Token mult;
        public Token add;

        public List<Math_moduleContext> math_module() {
            return getRuleContexts(Math_moduleContext.class);
        }

        public Math_moduleContext math_module(int i) {
            return getRuleContext(Math_moduleContext.class, i);
        }

        public Math_varContext math_var() {
            return getRuleContext(Math_varContext.class, 0);
        }

        public TerminalNode MULT() {
            return getToken(langParser.MULT, 0);
        }

        public TerminalNode DIV() {
            return getToken(langParser.DIV, 0);
        }

        public TerminalNode MOD() {
            return getToken(langParser.MOD, 0);
        }

        public TerminalNode PLUS() {
            return getToken(langParser.PLUS, 0);
        }

        public TerminalNode MINUS() {
            return getToken(langParser.MINUS, 0);
        }

        public Math_moduleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_math_module;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterMath_module(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitMath_module(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitMath_module(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Math_moduleContext math_module() throws RecognitionException {
        return math_module(0);
    }

    private Math_moduleContext math_module(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        Math_moduleContext _localctx = new Math_moduleContext(_ctx, _parentState);
        Math_moduleContext _prevctx = _localctx;
        int _startState = 24;
        enterRecursionRule(_localctx, 24, RULE_math_module, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(81);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__0: {
                        setState(76);
                        match(T__0);
                        setState(77);
                        math_module(0);
                        setState(78);
                        match(T__1);
                    }
                    break;
                    case INT:
                    case FLOAT:
                    case NAME: {
                        setState(80);
                        math_var();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(91);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
						if (_parseListeners != null) {
							triggerExitRuleEvent();
						}
                        _prevctx = _localctx;
                        {
                            setState(89);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                                case 1: {
                                    _localctx = new Math_moduleContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_math_module);
                                    setState(83);
									if (!(precpred(_ctx, 4))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 4)");
									}
                                    setState(84);
                                    ((Math_moduleContext) _localctx).mult = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIV) | (1L << MULT) | (1L << MOD))) != 0))) {
                                        ((Math_moduleContext) _localctx).mult = (Token) _errHandler.recoverInline(this);
                                    } else {
										if (_input.LA(1) == Token.EOF) {
											matchedEOF = true;
										}
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(85);
                                    math_module(5);
                                }
                                break;
                                case 2: {
                                    _localctx = new Math_moduleContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_math_module);
                                    setState(86);
									if (!(precpred(_ctx, 3))) {
										throw new FailedPredicateException(this, "precpred(_ctx, 3)");
									}
                                    setState(87);
                                    ((Math_moduleContext) _localctx).add = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == PLUS || _la == MINUS)) {
                                        ((Math_moduleContext) _localctx).add = (Token) _errHandler.recoverInline(this);
                                    } else {
										if (_input.LA(1) == Token.EOF) {
											matchedEOF = true;
										}
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(88);
                                    math_module(4);
                                }
                                break;
                            }
                        }
                    }
                    setState(93);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 12:
                return math_module_sempred((Math_moduleContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean math_module_sempred(Math_moduleContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 4);
            case 1:
                return precpred(_ctx, 3);
        }
        return true;
    }

    public static final String _serializedATN =
        "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26a\4\2\t\2\4\3\t" +
            "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4" +
            "\f\t\f\4\r\t\r\4\16\t\16\3\2\6\2\36\n\2\r\2\16\2\37\3\2\5\2#\n\2\3\3\3" +
            "\3\3\3\3\3\5\3)\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3" +
            "\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\5\t@\n\t\3\n\3\n\3\13\3\13\3\f\3\f" +
            "\5\fH\n\f\3\r\3\r\5\rL\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16T\n\16\3" +
            "\16\3\16\3\16\3\16\3\16\3\16\7\16\\\n\16\f\16\16\16_\13\16\3\16\2\3\32" +
            "\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\6\3\2\20\21\3\2\t\n\3\2\r\17\3" +
            "\2\13\f\2^\2\"\3\2\2\2\4(\3\2\2\2\6*\3\2\2\2\b.\3\2\2\2\n\63\3\2\2\2\f" +
            "\67\3\2\2\2\16;\3\2\2\2\20?\3\2\2\2\22A\3\2\2\2\24C\3\2\2\2\26G\3\2\2" +
            "\2\30K\3\2\2\2\32S\3\2\2\2\34\36\5\4\3\2\35\34\3\2\2\2\36\37\3\2\2\2\37" +
            "\35\3\2\2\2\37 \3\2\2\2 #\3\2\2\2!#\3\2\2\2\"\35\3\2\2\2\"!\3\2\2\2#\3" +
            "\3\2\2\2$)\5\6\4\2%)\5\b\5\2&)\5\n\6\2\')\5\f\7\2($\3\2\2\2(%\3\2\2\2" +
            "(&\3\2\2\2(\'\3\2\2\2)\5\3\2\2\2*+\5\16\b\2+,\7\22\2\2,-\7\b\2\2-\7\3" +
            "\2\2\2./\7\22\2\2/\60\7\7\2\2\60\61\5\20\t\2\61\62\7\b\2\2\62\t\3\2\2" +
            "\2\63\64\7\5\2\2\64\65\7\22\2\2\65\66\7\b\2\2\66\13\3\2\2\2\678\7\6\2" +
            "\289\7\22\2\29:\7\b\2\2:\r\3\2\2\2;<\t\2\2\2<\17\3\2\2\2=@\5\22\n\2>@" +
            "\5\32\16\2?=\3\2\2\2?>\3\2\2\2@\21\3\2\2\2AB\5\30\r\2B\23\3\2\2\2CD\t" +
            "\3\2\2D\25\3\2\2\2EH\5\24\13\2FH\7\22\2\2GE\3\2\2\2GF\3\2\2\2H\27\3\2" +
            "\2\2IL\7\22\2\2JL\5\24\13\2KI\3\2\2\2KJ\3\2\2\2L\31\3\2\2\2MN\b\16\1\2" +
            "NO\7\3\2\2OP\5\32\16\2PQ\7\4\2\2QT\3\2\2\2RT\5\26\f\2SM\3\2\2\2SR\3\2" +
            "\2\2T]\3\2\2\2UV\f\6\2\2VW\t\4\2\2W\\\5\32\16\7XY\f\5\2\2YZ\t\5\2\2Z\\" +
            "\5\32\16\6[U\3\2\2\2[X\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\33\3\2" +
            "\2\2_]\3\2\2\2\13\37\"(?GKS[]";
    public static final ATN _ATN =
        new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}