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
        READ = 1, PRINT = 2, ASSIGN = 3, SEMI_COLON = 4, COLON = 5, OPEN_PAREN = 6, CLOSE_PAREN = 7,
        OPEN_BRACE = 8, CLOSE_BRACE = 9, OPEN_BRACKET = 10, CLOSE_BRACKET = 11, INT = 12,
        FLOAT = 13, STRING = 14, GT = 15, LT = 16, GT_EQ = 17, LT_EQ = 18, EQUAL = 19, NEQ = 20,
        NOT = 21, PLUS = 22, MINUS = 23, DIV = 24, MULT = 25, MOD = 26, TRUE = 27, FALSE = 28,
        AND = 29, OR = 30, IF = 31, END_IF = 32, ELSE = 33, WHILE = 34, DO = 35, FOR = 36, DEF_INT = 37,
        DEF_FLOAT = 38, DEF_STRING = 39, DEF_BOOL = 40, NAME = 41, NAME_PREFIX = 42, BLANK = 43,
        COMMENT = 44, NEXT_LINE = 45, UNKNOWN_CHAR = 46;
    public static final int
        RULE_program = 0, RULE_statement = 1, RULE_def_var = 2, RULE_assign_var = 3,
        RULE_for_loop_assign = 4, RULE_read = 5, RULE_print = 6, RULE_comment = 7,
        RULE_define = 8, RULE_operation = 9, RULE_init_var = 10, RULE_for_loop = 11,
        RULE_do_while_loop = 12, RULE_while_loop = 13, RULE_if_begin = 14, RULE_if_statement = 15,
        RULE_else_statement = 16, RULE_numeric_value = 17, RULE_math_var = 18,
        RULE_bool = 19, RULE_value = 20, RULE_math_module = 21, RULE_condition = 22;

    private static String[] makeRuleNames() {
        return new String[]{
            "program", "statement", "def_var", "assign_var", "for_loop_assign", "read",
            "print", "comment", "define", "operation", "init_var", "for_loop", "do_while_loop",
            "while_loop", "if_begin", "if_statement", "else_statement", "numeric_value",
            "math_var", "bool", "value", "math_module", "condition"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
            null, "'READ'", "'PRINT'", "'='", "';'", "':'", "'('", "')'", "'{'",
            "'}'", "'['", "']'", null, null, null, "'>'", "'<'", "'>='", "'<='",
            "'=='", "'!='", "'!'", "'+'", "'-'", "'/'", "'*'", "'%'", "'true'", "'false'",
            "'AND'", "'OR'", "'IF'", "'END IF'", "'ELSE'", "'WHILE'", "'DO'", "'FOR'",
            "'INT'", "'FLOAT'", "'STRING'", "'BOOL'", null, "'V_'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
            null, "READ", "PRINT", "ASSIGN", "SEMI_COLON", "COLON", "OPEN_PAREN",
            "CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET",
            "INT", "FLOAT", "STRING", "GT", "LT", "GT_EQ", "LT_EQ", "EQUAL", "NEQ",
            "NOT", "PLUS", "MINUS", "DIV", "MULT", "MOD", "TRUE", "FALSE", "AND",
            "OR", "IF", "END_IF", "ELSE", "WHILE", "DO", "FOR", "DEF_INT", "DEF_FLOAT",
            "DEF_STRING", "DEF_BOOL", "NAME", "NAME_PREFIX", "BLANK", "COMMENT",
            "NEXT_LINE", "UNKNOWN_CHAR"
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
            setState(52);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case READ:
                case PRINT:
                case IF:
                case WHILE:
                case DO:
                case FOR:
                case DEF_INT:
                case DEF_FLOAT:
                case DEF_STRING:
                case DEF_BOOL:
                case NAME:
                case COMMENT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(47);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    do {
                        {
                            {
                                setState(46);
                                statement();
                            }
                        }
                        setState(49);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    } while ((((_la) & ~0x3f) == 0 &&
                        ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L
                            << DEF_FLOAT) | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << NAME) | (1L << COMMENT))) != 0));
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

        public If_statementContext if_statement() {
            return getRuleContext(If_statementContext.class, 0);
        }

        public While_loopContext while_loop() {
            return getRuleContext(While_loopContext.class, 0);
        }

        public Do_while_loopContext do_while_loop() {
            return getRuleContext(Do_while_loopContext.class, 0);
        }

        public For_loopContext for_loop() {
            return getRuleContext(For_loopContext.class, 0);
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
            setState(63);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case DEF_INT:
                case DEF_FLOAT:
                case DEF_STRING:
                case DEF_BOOL:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(54);
                    def_var();
                }
                break;
                case NAME:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(55);
                    assign_var();
                }
                break;
                case IF:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(56);
                    if_statement();
                }
                break;
                case WHILE:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(57);
                    while_loop();
                }
                break;
                case DO:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(58);
                    do_while_loop();
                }
                break;
                case FOR:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(59);
                    for_loop();
                }
                break;
                case READ:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(60);
                    read();
                }
                break;
                case PRINT:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(61);
                    print();
                }
                break;
                case COMMENT:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(62);
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
                setState(65);
                define();
                setState(66);
                match(NAME);
                setState(67);
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

        public For_loop_assignContext for_loop_assign() {
            return getRuleContext(For_loop_assignContext.class, 0);
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
                setState(69);
                for_loop_assign();
                setState(70);
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

    public static class For_loop_assignContext extends ParserRuleContext {

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public TerminalNode ASSIGN() {
            return getToken(langParser.ASSIGN, 0);
        }

        public OperationContext operation() {
            return getRuleContext(OperationContext.class, 0);
        }

        public For_loop_assignContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_for_loop_assign;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterFor_loop_assign(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitFor_loop_assign(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitFor_loop_assign(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final For_loop_assignContext for_loop_assign() throws RecognitionException {
        For_loop_assignContext _localctx = new For_loop_assignContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_for_loop_assign);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(72);
                match(NAME);
                setState(73);
                match(ASSIGN);
                setState(74);
                operation();
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
        enterRule(_localctx, 10, RULE_read);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(76);
                match(READ);
                setState(77);
                match(NAME);
                setState(78);
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
        enterRule(_localctx, 12, RULE_print);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(80);
                match(PRINT);
                setState(81);
                match(NAME);
                setState(82);
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
        enterRule(_localctx, 14, RULE_comment);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(84);
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

        public TerminalNode DEF_BOOL() {
            return getToken(langParser.DEF_BOOL, 0);
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
        enterRule(_localctx, 16, RULE_define);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(86);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEF_INT) | (1L << DEF_FLOAT) | (1L << DEF_STRING) | (1L << DEF_BOOL))) != 0))) {
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
        enterRule(_localctx, 18, RULE_operation);
        try {
            setState(90);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(88);
                    init_var();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(89);
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
        enterRule(_localctx, 20, RULE_init_var);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(92);
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

    public static class For_loopContext extends ParserRuleContext {

        public TerminalNode FOR() {
            return getToken(langParser.FOR, 0);
        }

        public TerminalNode OPEN_PAREN() {
            return getToken(langParser.OPEN_PAREN, 0);
        }

        public List<For_loop_assignContext> for_loop_assign() {
            return getRuleContexts(For_loop_assignContext.class);
        }

        public For_loop_assignContext for_loop_assign(int i) {
            return getRuleContext(For_loop_assignContext.class, i);
        }

        public List<TerminalNode> SEMI_COLON() {
            return getTokens(langParser.SEMI_COLON);
        }

        public TerminalNode SEMI_COLON(int i) {
            return getToken(langParser.SEMI_COLON, i);
        }

        public ConditionContext condition() {
            return getRuleContext(ConditionContext.class, 0);
        }

        public TerminalNode CLOSE_PAREN() {
            return getToken(langParser.CLOSE_PAREN, 0);
        }

        public TerminalNode OPEN_BRACE() {
            return getToken(langParser.OPEN_BRACE, 0);
        }

        public TerminalNode CLOSE_BRACE() {
            return getToken(langParser.CLOSE_BRACE, 0);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public For_loopContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_for_loop;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterFor_loop(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitFor_loop(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitFor_loop(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final For_loopContext for_loop() throws RecognitionException {
        For_loopContext _localctx = new For_loopContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_for_loop);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(94);
                match(FOR);
                setState(95);
                match(OPEN_PAREN);
                setState(96);
                for_loop_assign();
                setState(97);
                match(SEMI_COLON);
                setState(98);
                condition();
                setState(99);
                match(SEMI_COLON);
                setState(100);
                for_loop_assign();
                setState(101);
                match(CLOSE_PAREN);
                setState(102);
                match(OPEN_BRACE);
                setState(106);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 &&
                    ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L << DEF_FLOAT)
                        | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << NAME) | (1L << COMMENT))) != 0)) {
                    {
                        {
                            setState(103);
                            statement();
                        }
                    }
                    setState(108);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(109);
                match(CLOSE_BRACE);
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

    public static class Do_while_loopContext extends ParserRuleContext {

        public TerminalNode DO() {
            return getToken(langParser.DO, 0);
        }

        public TerminalNode OPEN_BRACE() {
            return getToken(langParser.OPEN_BRACE, 0);
        }

        public TerminalNode CLOSE_BRACE() {
            return getToken(langParser.CLOSE_BRACE, 0);
        }

        public TerminalNode WHILE() {
            return getToken(langParser.WHILE, 0);
        }

        public TerminalNode OPEN_PAREN() {
            return getToken(langParser.OPEN_PAREN, 0);
        }

        public ConditionContext condition() {
            return getRuleContext(ConditionContext.class, 0);
        }

        public TerminalNode CLOSE_PAREN() {
            return getToken(langParser.CLOSE_PAREN, 0);
        }

        public TerminalNode SEMI_COLON() {
            return getToken(langParser.SEMI_COLON, 0);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public Do_while_loopContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_do_while_loop;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterDo_while_loop(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitDo_while_loop(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitDo_while_loop(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Do_while_loopContext do_while_loop() throws RecognitionException {
        Do_while_loopContext _localctx = new Do_while_loopContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_do_while_loop);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(111);
                match(DO);
                setState(112);
                match(OPEN_BRACE);
                setState(116);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 &&
                    ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L << DEF_FLOAT)
                        | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << NAME) | (1L << COMMENT))) != 0)) {
                    {
                        {
                            setState(113);
                            statement();
                        }
                    }
                    setState(118);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(119);
                match(CLOSE_BRACE);
                setState(120);
                match(WHILE);
                setState(121);
                match(OPEN_PAREN);
                setState(122);
                condition();
                setState(123);
                match(CLOSE_PAREN);
                setState(124);
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

    public static class While_loopContext extends ParserRuleContext {

        public TerminalNode WHILE() {
            return getToken(langParser.WHILE, 0);
        }

        public TerminalNode OPEN_PAREN() {
            return getToken(langParser.OPEN_PAREN, 0);
        }

        public ConditionContext condition() {
            return getRuleContext(ConditionContext.class, 0);
        }

        public TerminalNode CLOSE_PAREN() {
            return getToken(langParser.CLOSE_PAREN, 0);
        }

        public TerminalNode OPEN_BRACE() {
            return getToken(langParser.OPEN_BRACE, 0);
        }

        public TerminalNode CLOSE_BRACE() {
            return getToken(langParser.CLOSE_BRACE, 0);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public While_loopContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_while_loop;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterWhile_loop(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitWhile_loop(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitWhile_loop(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final While_loopContext while_loop() throws RecognitionException {
        While_loopContext _localctx = new While_loopContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_while_loop);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(126);
                match(WHILE);
                setState(127);
                match(OPEN_PAREN);
                setState(128);
                condition();
                setState(129);
                match(CLOSE_PAREN);
                setState(130);
                match(OPEN_BRACE);
                setState(134);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 &&
                    ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L << DEF_FLOAT)
                        | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << NAME) | (1L << COMMENT))) != 0)) {
                    {
                        {
                            setState(131);
                            statement();
                        }
                    }
                    setState(136);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(137);
                match(CLOSE_BRACE);
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

    public static class If_beginContext extends ParserRuleContext {

        public TerminalNode IF() {
            return getToken(langParser.IF, 0);
        }

        public TerminalNode OPEN_PAREN() {
            return getToken(langParser.OPEN_PAREN, 0);
        }

        public ConditionContext condition() {
            return getRuleContext(ConditionContext.class, 0);
        }

        public TerminalNode CLOSE_PAREN() {
            return getToken(langParser.CLOSE_PAREN, 0);
        }

        public TerminalNode OPEN_BRACE() {
            return getToken(langParser.OPEN_BRACE, 0);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public If_beginContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_if_begin;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterIf_begin(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitIf_begin(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitIf_begin(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final If_beginContext if_begin() throws RecognitionException {
        If_beginContext _localctx = new If_beginContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_if_begin);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(139);
                match(IF);
                setState(140);
                match(OPEN_PAREN);
                setState(141);
                condition();
                setState(142);
                match(CLOSE_PAREN);
                setState(143);
                match(OPEN_BRACE);
                setState(147);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 &&
                    ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L << DEF_FLOAT)
                        | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << NAME) | (1L << COMMENT))) != 0)) {
                    {
                        {
                            setState(144);
                            statement();
                        }
                    }
                    setState(149);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
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

    public static class If_statementContext extends ParserRuleContext {

        public If_beginContext if_begin() {
            return getRuleContext(If_beginContext.class, 0);
        }

        public TerminalNode CLOSE_BRACE() {
            return getToken(langParser.CLOSE_BRACE, 0);
        }

        public Else_statementContext else_statement() {
            return getRuleContext(Else_statementContext.class, 0);
        }

        public If_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_if_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterIf_statement(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitIf_statement(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitIf_statement(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final If_statementContext if_statement() throws RecognitionException {
        If_statementContext _localctx = new If_statementContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_if_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(150);
                if_begin();
                setState(151);
                match(CLOSE_BRACE);
                setState(154);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case EOF:
                    case READ:
                    case PRINT:
                    case CLOSE_BRACE:
                    case IF:
                    case WHILE:
                    case DO:
                    case FOR:
                    case DEF_INT:
                    case DEF_FLOAT:
                    case DEF_STRING:
                    case DEF_BOOL:
                    case NAME:
                    case COMMENT: {
                    }
                    break;
                    case ELSE: {
                        setState(153);
                        else_statement();
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

    public static class Else_statementContext extends ParserRuleContext {

        public TerminalNode ELSE() {
            return getToken(langParser.ELSE, 0);
        }

        public TerminalNode OPEN_BRACE() {
            return getToken(langParser.OPEN_BRACE, 0);
        }

        public TerminalNode CLOSE_BRACE() {
            return getToken(langParser.CLOSE_BRACE, 0);
        }

        public If_statementContext if_statement() {
            return getRuleContext(If_statementContext.class, 0);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public Else_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_else_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterElse_statement(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitElse_statement(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitElse_statement(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Else_statementContext else_statement() throws RecognitionException {
        Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_else_statement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(156);
                match(ELSE);
                setState(166);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case OPEN_BRACE: {
                        setState(157);
                        match(OPEN_BRACE);
                        setState(161);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while ((((_la) & ~0x3f) == 0 &&
                            ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L
                                << DEF_FLOAT) | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << NAME) | (1L << COMMENT))) != 0)) {
                            {
                                {
                                    setState(158);
                                    statement();
                                }
                            }
                            setState(163);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(164);
                        match(CLOSE_BRACE);
                    }
                    break;
                    case IF: {
                        setState(165);
                        if_statement();
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
        enterRule(_localctx, 34, RULE_numeric_value);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(168);
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
        enterRule(_localctx, 36, RULE_math_var);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(172);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case INT:
                    case FLOAT: {
                        setState(170);
                        numeric_value();
                    }
                    break;
                    case NAME: {
                        setState(171);
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

    public static class BoolContext extends ParserRuleContext {

        public TerminalNode TRUE() {
            return getToken(langParser.TRUE, 0);
        }

        public TerminalNode FALSE() {
            return getToken(langParser.FALSE, 0);
        }

        public BoolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_bool;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterBool(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitBool(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitBool(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final BoolContext bool() throws RecognitionException {
        BoolContext _localctx = new BoolContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_bool);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(174);
                _la = _input.LA(1);
                if (!(_la == TRUE || _la == FALSE)) {
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

    public static class ValueContext extends ParserRuleContext {

        public TerminalNode STRING() {
            return getToken(langParser.STRING, 0);
        }

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public TerminalNode TRUE() {
            return getToken(langParser.TRUE, 0);
        }

        public TerminalNode FALSE() {
            return getToken(langParser.FALSE, 0);
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
        enterRule(_localctx, 40, RULE_value);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(181);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case STRING: {
                        setState(176);
                        match(STRING);
                    }
                    break;
                    case NAME: {
                        setState(177);
                        match(NAME);
                    }
                    break;
                    case TRUE: {
                        setState(178);
                        match(TRUE);
                    }
                    break;
                    case FALSE: {
                        setState(179);
                        match(FALSE);
                    }
                    break;
                    case INT:
                    case FLOAT: {
                        setState(180);
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
        enterRule(_localctx, 42, RULE_math_module);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(183);
                math_var();
                setState(184);
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
                setState(185);
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

    public static class ConditionContext extends ParserRuleContext {

        public Token comp;

        public List<ValueContext> value() {
            return getRuleContexts(ValueContext.class);
        }

        public ValueContext value(int i) {
            return getRuleContext(ValueContext.class, i);
        }

        public List<Math_moduleContext> math_module() {
            return getRuleContexts(Math_moduleContext.class);
        }

        public Math_moduleContext math_module(int i) {
            return getRuleContext(Math_moduleContext.class, i);
        }

        public TerminalNode GT() {
            return getToken(langParser.GT, 0);
        }

        public TerminalNode LT() {
            return getToken(langParser.LT, 0);
        }

        public TerminalNode GT_EQ() {
            return getToken(langParser.GT_EQ, 0);
        }

        public TerminalNode LT_EQ() {
            return getToken(langParser.LT_EQ, 0);
        }

        public TerminalNode EQUAL() {
            return getToken(langParser.EQUAL, 0);
        }

        public TerminalNode NEQ() {
            return getToken(langParser.NEQ, 0);
        }

        public BoolContext bool() {
            return getRuleContext(BoolContext.class, 0);
        }

        public TerminalNode NOT() {
            return getToken(langParser.NOT, 0);
        }

        public ConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_condition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterCondition(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitCondition(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitCondition(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final ConditionContext condition() throws RecognitionException {
        ConditionContext _localctx = new ConditionContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_condition);
        int _la;
        try {
            setState(200);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(189);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
                        case 1: {
                            setState(187);
                            value();
                        }
                        break;
                        case 2: {
                            setState(188);
                            math_module();
                        }
                        break;
                    }
                    setState(191);
                    ((ConditionContext) _localctx).comp = _input.LT(1);
                    _la = _input.LA(1);
                    if (!((((_la) & ~0x3f) == 0
                        && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GT_EQ) | (1L << LT_EQ) | (1L << EQUAL) | (1L << NEQ))) != 0))) {
                        ((ConditionContext) _localctx).comp = (Token) _errHandler.recoverInline(this);
                    } else {
						if (_input.LA(1) == Token.EOF) {
							matchedEOF = true;
						}
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(194);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 14, _ctx)) {
                        case 1: {
                            setState(192);
                            value();
                        }
                        break;
                        case 2: {
                            setState(193);
                            math_module();
                        }
                        break;
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(197);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(196);
                            match(NOT);
                        }
                    }

                    setState(199);
                    bool();
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

    public static final String _serializedATN =
        "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u00cd\4\2\t\2" +
            "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
            "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
            "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\6\2\62" +
            "\n\2\r\2\16\2\63\3\2\5\2\67\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5" +
            "\3B\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3" +
            "\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\5\13]\n\13\3\f\3\f\3\r\3\r\3" +
            "\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\rk\n\r\f\r\16\rn\13\r\3\r\3\r\3\16\3" +
            "\16\3\16\7\16u\n\16\f\16\16\16x\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3" +
            "\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0087\n\17\f\17\16\17\u008a\13" +
            "\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0094\n\20\f\20\16\20" +
            "\u0097\13\20\3\21\3\21\3\21\3\21\5\21\u009d\n\21\3\22\3\22\3\22\7\22\u00a2" +
            "\n\22\f\22\16\22\u00a5\13\22\3\22\3\22\5\22\u00a9\n\22\3\23\3\23\3\24" +
            "\3\24\5\24\u00af\n\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u00b8\n" +
            "\26\3\27\3\27\3\27\3\27\3\30\3\30\5\30\u00c0\n\30\3\30\3\30\3\30\5\30" +
            "\u00c5\n\30\3\30\5\30\u00c8\n\30\3\30\5\30\u00cb\n\30\3\30\2\2\31\2\4" +
            "\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\7\3\2\'*\3\2\16\17\3\2" +
            "\35\36\3\2\30\34\3\2\21\26\2\u00d0\2\66\3\2\2\2\4A\3\2\2\2\6C\3\2\2\2" +
            "\bG\3\2\2\2\nJ\3\2\2\2\fN\3\2\2\2\16R\3\2\2\2\20V\3\2\2\2\22X\3\2\2\2" +
            "\24\\\3\2\2\2\26^\3\2\2\2\30`\3\2\2\2\32q\3\2\2\2\34\u0080\3\2\2\2\36" +
            "\u008d\3\2\2\2 \u0098\3\2\2\2\"\u009e\3\2\2\2$\u00aa\3\2\2\2&\u00ae\3" +
            "\2\2\2(\u00b0\3\2\2\2*\u00b7\3\2\2\2,\u00b9\3\2\2\2.\u00ca\3\2\2\2\60" +
            "\62\5\4\3\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64" +
            "\67\3\2\2\2\65\67\3\2\2\2\66\61\3\2\2\2\66\65\3\2\2\2\67\3\3\2\2\28B\5" +
            "\6\4\29B\5\b\5\2:B\5 \21\2;B\5\34\17\2<B\5\32\16\2=B\5\30\r\2>B\5\f\7" +
            "\2?B\5\16\b\2@B\5\20\t\2A8\3\2\2\2A9\3\2\2\2A:\3\2\2\2A;\3\2\2\2A<\3\2" +
            "\2\2A=\3\2\2\2A>\3\2\2\2A?\3\2\2\2A@\3\2\2\2B\5\3\2\2\2CD\5\22\n\2DE\7" +
            "+\2\2EF\7\6\2\2F\7\3\2\2\2GH\5\n\6\2HI\7\6\2\2I\t\3\2\2\2JK\7+\2\2KL\7" +
            "\5\2\2LM\5\24\13\2M\13\3\2\2\2NO\7\3\2\2OP\7+\2\2PQ\7\6\2\2Q\r\3\2\2\2" +
            "RS\7\4\2\2ST\7+\2\2TU\7\6\2\2U\17\3\2\2\2VW\7.\2\2W\21\3\2\2\2XY\t\2\2" +
            "\2Y\23\3\2\2\2Z]\5\26\f\2[]\5,\27\2\\Z\3\2\2\2\\[\3\2\2\2]\25\3\2\2\2" +
            "^_\5*\26\2_\27\3\2\2\2`a\7&\2\2ab\7\b\2\2bc\5\n\6\2cd\7\6\2\2de\5.\30" +
            "\2ef\7\6\2\2fg\5\n\6\2gh\7\t\2\2hl\7\n\2\2ik\5\4\3\2ji\3\2\2\2kn\3\2\2" +
            "\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7\13\2\2p\31\3\2\2\2qr\7" +
            "%\2\2rv\7\n\2\2su\5\4\3\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3" +
            "\2\2\2xv\3\2\2\2yz\7\13\2\2z{\7$\2\2{|\7\b\2\2|}\5.\30\2}~\7\t\2\2~\177" +
            "\7\6\2\2\177\33\3\2\2\2\u0080\u0081\7$\2\2\u0081\u0082\7\b\2\2\u0082\u0083" +
            "\5.\30\2\u0083\u0084\7\t\2\2\u0084\u0088\7\n\2\2\u0085\u0087\5\4\3\2\u0086" +
            "\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2" +
            "\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7\13\2\2\u008c" +
            "\35\3\2\2\2\u008d\u008e\7!\2\2\u008e\u008f\7\b\2\2\u008f\u0090\5.\30\2" +
            "\u0090\u0091\7\t\2\2\u0091\u0095\7\n\2\2\u0092\u0094\5\4\3\2\u0093\u0092" +
            "\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096" +
            "\37\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\5\36\20\2\u0099\u009c\7\13" +
            "\2\2\u009a\u009d\3\2\2\2\u009b\u009d\5\"\22\2\u009c\u009a\3\2\2\2\u009c" +
            "\u009b\3\2\2\2\u009d!\3\2\2\2\u009e\u00a8\7#\2\2\u009f\u00a3\7\n\2\2\u00a0" +
            "\u00a2\5\4\3\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2" +
            "\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6" +
            "\u00a9\7\13\2\2\u00a7\u00a9\5 \21\2\u00a8\u009f\3\2\2\2\u00a8\u00a7\3" +
            "\2\2\2\u00a9#\3\2\2\2\u00aa\u00ab\t\3\2\2\u00ab%\3\2\2\2\u00ac\u00af\5" +
            "$\23\2\u00ad\u00af\7+\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af" +
            "\'\3\2\2\2\u00b0\u00b1\t\4\2\2\u00b1)\3\2\2\2\u00b2\u00b8\7\20\2\2\u00b3" +
            "\u00b8\7+\2\2\u00b4\u00b8\7\35\2\2\u00b5\u00b8\7\36\2\2\u00b6\u00b8\5" +
            "$\23\2\u00b7\u00b2\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b7\u00b4\3\2\2\2\u00b7" +
            "\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8+\3\2\2\2\u00b9\u00ba\5&\24\2" +
            "\u00ba\u00bb\t\5\2\2\u00bb\u00bc\5&\24\2\u00bc-\3\2\2\2\u00bd\u00c0\5" +
            "*\26\2\u00be\u00c0\5,\27\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0" +
            "\u00c1\3\2\2\2\u00c1\u00c4\t\6\2\2\u00c2\u00c5\5*\26\2\u00c3\u00c5\5," +
            "\27\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00cb\3\2\2\2\u00c6" +
            "\u00c8\7\27\2\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3" +
            "\2\2\2\u00c9\u00cb\5(\25\2\u00ca\u00bf\3\2\2\2\u00ca\u00c7\3\2\2\2\u00cb" +
            "/\3\2\2\2\23\63\66A\\lv\u0088\u0095\u009c\u00a3\u00a8\u00ae\u00b7\u00bf" +
            "\u00c4\u00c7\u00ca";
    public static final ATN _ATN =
        new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}