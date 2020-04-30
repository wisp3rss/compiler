package com.asia.compiler.parser.gen;

import java.util.List;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
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
        READ = 1, PRINT = 2, ASSIGN = 3, SEMI_COLON = 4, INT = 5, FLOAT = 6, STRING = 7, PLUS = 8,
        MINUS = 9, DIV = 10, MULT = 11, MOD = 12, DEF_INT = 13, DEF_FLOAT = 14, DEF_STRING = 15,
        NAME = 16, NAME_PREFIX = 17, BLANK = 18, COMMENT = 19, NEXT_LINE = 20, UNKNOWN_CHAR = 21;
    public static final int
        RULE_program = 0, RULE_statement = 1, RULE_def_var = 2, RULE_assign_var = 3,
        RULE_read = 4, RULE_print = 5, RULE_comment = 6, RULE_define = 7, RULE_operation = 8,
        RULE_init_var = 9, RULE_numeric_value = 10, RULE_math_var = 11, RULE_value = 12,
        RULE_math_module = 13;

    private static String[] makeRuleNames() {
        return new String[]{
            "program", "statement", "def_var", "assign_var", "read", "print", "comment",
            "define", "operation", "init_var", "numeric_value", "math_var", "value",
            "math_module"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
            null, "'READ'", "'PRINT'", "'='", "';'", null, null, null, "'+'", "'-'",
            "'/'", "'*'", "'%'", "'INT'", "'FLOAT'", "'STRING'", null, "'V_'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
            null, "READ", "PRINT", "ASSIGN", "SEMI_COLON", "INT", "FLOAT", "STRING",
            "PLUS", "MINUS", "DIV", "MULT", "MOD", "DEF_INT", "DEF_FLOAT", "DEF_STRING",
            "NAME", "NAME_PREFIX", "BLANK", "COMMENT", "NEXT_LINE", "UNKNOWN_CHAR"
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
            setState(34);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case READ:
                case PRINT:
                case DEF_INT:
                case DEF_FLOAT:
                case DEF_STRING:
                case NAME:
                case COMMENT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(29);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    do {
                        {
                            {
                                setState(28);
                                statement();
                            }
                        }
                        setState(31);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    } while ((((_la) & ~0x3f) == 0 &&
                        ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << DEF_INT) | (1L << DEF_FLOAT) | (1L << DEF_STRING) | (1L << NAME) | (1L
                            << COMMENT))) != 0));
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

        public CommentContext comment() {
            return getRuleContext(CommentContext.class, 0);
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
            setState(41);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case DEF_INT:
                case DEF_FLOAT:
                case DEF_STRING:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(36);
                    def_var();
                }
                break;
                case NAME:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(37);
                    assign_var();
                }
                break;
                case READ:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(38);
                    read();
                }
                break;
                case PRINT:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(39);
                    print();
                }
                break;
                case COMMENT:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(40);
                    comment();
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
                setState(43);
                define();
                setState(44);
                match(NAME);
                setState(45);
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
                setState(47);
                match(NAME);
                setState(48);
                match(ASSIGN);
                setState(49);
                operation();
                setState(50);
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
                setState(52);
                match(READ);
                setState(53);
                match(NAME);
                setState(54);
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
                setState(56);
                match(PRINT);
                setState(57);
                match(NAME);
                setState(58);
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

    public static class CommentContext extends ParserRuleContext {

        public TerminalNode COMMENT() {
            return getToken(langParser.COMMENT, 0);
        }

        public CommentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_comment;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterComment(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitComment(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitComment(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final CommentContext comment() throws RecognitionException {
        CommentContext _localctx = new CommentContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_comment);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(60);
                match(COMMENT);
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

        public TerminalNode DEF_STRING() {
            return getToken(langParser.DEF_STRING, 0);
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
        enterRule(_localctx, 14, RULE_define);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(62);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEF_INT) | (1L << DEF_FLOAT) | (1L << DEF_STRING))) != 0))) {
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
        enterRule(_localctx, 16, RULE_operation);
        try {
            setState(66);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(64);
                    init_var();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(65);
                    math_module();
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
        enterRule(_localctx, 18, RULE_init_var);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(68);
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
        enterRule(_localctx, 20, RULE_numeric_value);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(70);
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
        enterRule(_localctx, 22, RULE_math_var);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(74);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case INT:
                    case FLOAT: {
                        setState(72);
                        numeric_value();
                    }
                    break;
                    case NAME: {
                        setState(73);
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

        public TerminalNode STRING() {
            return getToken(langParser.STRING, 0);
        }

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
        enterRule(_localctx, 24, RULE_value);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(79);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case STRING: {
                        setState(76);
                        match(STRING);
                    }
                    break;
                    case NAME: {
                        setState(77);
                        match(NAME);
                    }
                    break;
                    case INT:
                    case FLOAT: {
                        setState(78);
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

        public Token op;

        public List<Math_varContext> math_var() {
            return getRuleContexts(Math_varContext.class);
        }

        public Math_varContext math_var(int i) {
            return getRuleContext(Math_varContext.class, i);
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
        Math_moduleContext _localctx = new Math_moduleContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_math_module);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(81);
                math_var();
                setState(82);
                ((Math_moduleContext) _localctx).op = _input.LT(1);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << DIV) | (1L << MULT) | (1L << MOD))) != 0))) {
                    ((Math_moduleContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                } else {
					if (_input.LA(1) == Token.EOF) {
						matchedEOF = true;
					}
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(83);
                math_var();
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

    public static final String _serializedATN =
        "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27X\4\2\t\2\4\3\t" +
            "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4" +
            "\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\6\2 \n\2\r\2\16\2!\3\2\5\2%\n\2" +
            "\3\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6" +
            "\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\5\nE\n\n\3\13\3\13" +
            "\3\f\3\f\3\r\3\r\5\rM\n\r\3\16\3\16\3\16\5\16R\n\16\3\17\3\17\3\17\3\17" +
            "\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\5\3\2\17\21\3\2\7\b" +
            "\3\2\n\16\2S\2$\3\2\2\2\4+\3\2\2\2\6-\3\2\2\2\b\61\3\2\2\2\n\66\3\2\2" +
            "\2\f:\3\2\2\2\16>\3\2\2\2\20@\3\2\2\2\22D\3\2\2\2\24F\3\2\2\2\26H\3\2" +
            "\2\2\30L\3\2\2\2\32Q\3\2\2\2\34S\3\2\2\2\36 \5\4\3\2\37\36\3\2\2\2 !\3" +
            "\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"%\3\2\2\2#%\3\2\2\2$\37\3\2\2\2$#\3\2\2" +
            "\2%\3\3\2\2\2&,\5\6\4\2\',\5\b\5\2(,\5\n\6\2),\5\f\7\2*,\5\16\b\2+&\3" +
            "\2\2\2+\'\3\2\2\2+(\3\2\2\2+)\3\2\2\2+*\3\2\2\2,\5\3\2\2\2-.\5\20\t\2" +
            "./\7\22\2\2/\60\7\6\2\2\60\7\3\2\2\2\61\62\7\22\2\2\62\63\7\5\2\2\63\64" +
            "\5\22\n\2\64\65\7\6\2\2\65\t\3\2\2\2\66\67\7\3\2\2\678\7\22\2\289\7\6" +
            "\2\29\13\3\2\2\2:;\7\4\2\2;<\7\22\2\2<=\7\6\2\2=\r\3\2\2\2>?\7\25\2\2" +
            "?\17\3\2\2\2@A\t\2\2\2A\21\3\2\2\2BE\5\24\13\2CE\5\34\17\2DB\3\2\2\2D" +
            "C\3\2\2\2E\23\3\2\2\2FG\5\32\16\2G\25\3\2\2\2HI\t\3\2\2I\27\3\2\2\2JM" +
            "\5\26\f\2KM\7\22\2\2LJ\3\2\2\2LK\3\2\2\2M\31\3\2\2\2NR\7\t\2\2OR\7\22" +
            "\2\2PR\5\26\f\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2R\33\3\2\2\2ST\5\30\r\2T" +
            "U\t\4\2\2UV\5\30\r\2V\35\3\2\2\2\b!$+DLQ";
    public static final ATN _ATN =
        new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}