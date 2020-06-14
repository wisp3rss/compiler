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
        T__0 = 1, T__1 = 2, READ = 3, PRINT = 4, ASSIGN = 5, SEMI_COLON = 6, COLON = 7, OPEN_PAREN = 8,
        CLOSE_PAREN = 9, OPEN_BRACE = 10, CLOSE_BRACE = 11, OPEN_BRACKET = 12, CLOSE_BRACKET = 13,
        INT = 14, FLOAT = 15, STRING = 16, GT = 17, LT = 18, GT_EQ = 19, LT_EQ = 20, EQUAL = 21,
        NEQ = 22, NOT = 23, PLUS = 24, MINUS = 25, DIV = 26, MULT = 27, MOD = 28, TRUE = 29, FALSE = 30,
        AND = 31, OR = 32, IF = 33, END_IF = 34, ELSE = 35, WHILE = 36, DO = 37, FOR = 38, FUNCTION = 39,
        RETURN = 40, CLASS = 41, STRUCT = 42, NEW = 43, DEF_INT = 44, DEF_FLOAT = 45, DEF_STRING = 46,
        DEF_BOOL = 47, CLASS_NAME = 48, NAME = 49, BLANK = 50, COMMENT = 51, NEXT_LINE = 52,
        UNKNOWN_CHAR = 53;
    public static final int
        RULE_program = 0, RULE_statement = 1, RULE_def_var = 2, RULE_assign_var = 3,
        RULE_for_loop_assign = 4, RULE_read = 5, RULE_print = 6, RULE_comment = 7,
        RULE_define = 8, RULE_operation = 9, RULE_init_var = 10, RULE_def_class = 11,
        RULE_class_ = 12, RULE_create_class = 13, RULE_call_class_field = 14,
        RULE_call_class_func = 15, RULE_struct = 16, RULE_create_struct = 17,
        RULE_call_struct = 18, RULE_def_func = 19, RULE_def_args = 20, RULE_args = 21,
        RULE_call_func = 22, RULE_ret = 23, RULE_for_loop = 24, RULE_do_while_loop = 25,
        RULE_while_loop = 26, RULE_if_begin = 27, RULE_if_statement = 28, RULE_else_statement = 29,
        RULE_numeric_value = 30, RULE_math_var = 31, RULE_bool = 32, RULE_value = 33,
        RULE_call_external = 34, RULE_math_module = 35, RULE_condition = 36;

    private static String[] makeRuleNames() {
        return new String[]{
            "program", "statement", "def_var", "assign_var", "for_loop_assign", "read",
            "print", "comment", "define", "operation", "init_var", "def_class", "class_",
            "create_class", "call_class_field", "call_class_func", "struct", "create_struct",
            "call_struct", "def_func", "def_args", "args", "call_func", "ret", "for_loop",
            "do_while_loop", "while_loop", "if_begin", "if_statement", "else_statement",
            "numeric_value", "math_var", "bool", "value", "call_external", "math_module",
            "condition"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
            null, "'.'", "','", "'READ'", "'PRINT'", "'='", "';'", "':'", "'('",
            "')'", "'{'", "'}'", "'['", "']'", null, null, null, "'>'", "'<'", "'>='",
            "'<='", "'=='", "'!='", "'!'", "'+'", "'-'", "'/'", "'*'", "'%'", "'true'",
            "'false'", "'AND'", "'OR'", "'IF'", "'END IF'", "'ELSE'", "'WHILE'",
            "'DO'", "'FOR'", "'func'", "'return'", "'class'", "'struct'", "'new'",
            "'INT'", "'FLOAT'", "'STRING'", "'BOOL'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
            null, null, null, "READ", "PRINT", "ASSIGN", "SEMI_COLON", "COLON", "OPEN_PAREN",
            "CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET",
            "INT", "FLOAT", "STRING", "GT", "LT", "GT_EQ", "LT_EQ", "EQUAL", "NEQ",
            "NOT", "PLUS", "MINUS", "DIV", "MULT", "MOD", "TRUE", "FALSE", "AND",
            "OR", "IF", "END_IF", "ELSE", "WHILE", "DO", "FOR", "FUNCTION", "RETURN",
            "CLASS", "STRUCT", "NEW", "DEF_INT", "DEF_FLOAT", "DEF_STRING", "DEF_BOOL",
            "CLASS_NAME", "NAME", "BLANK", "COMMENT", "NEXT_LINE", "UNKNOWN_CHAR"
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

        public List<Def_funcContext> def_func() {
            return getRuleContexts(Def_funcContext.class);
        }

        public Def_funcContext def_func(int i) {
            return getRuleContext(Def_funcContext.class, i);
        }

        public List<Class_Context> class_() {
            return getRuleContexts(Class_Context.class);
        }

        public Class_Context class_(int i) {
            return getRuleContext(Class_Context.class, i);
        }

        public List<StructContext> struct() {
            return getRuleContexts(StructContext.class);
        }

        public StructContext struct(int i) {
            return getRuleContext(StructContext.class, i);
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
            enterOuterAlt(_localctx, 1);
            {
                setState(80);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 &&
                    ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << FUNCTION) | (1L << CLASS) | (
                        1L << STRUCT) | (1L << DEF_INT) | (1L << DEF_FLOAT) | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << CLASS_NAME) | (1L << NAME) | (1L
                        << COMMENT))) != 0)) {
                    {
                        setState(78);
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
                            case CLASS_NAME:
                            case NAME:
                            case COMMENT: {
                                setState(74);
                                statement();
                            }
                            break;
                            case FUNCTION: {
                                setState(75);
                                def_func();
                            }
                            break;
                            case CLASS: {
                                setState(76);
                                class_();
                            }
                            break;
                            case STRUCT: {
                                setState(77);
                                struct();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    setState(82);
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

        public Call_funcContext call_func() {
            return getRuleContext(Call_funcContext.class, 0);
        }

        public TerminalNode SEMI_COLON() {
            return getToken(langParser.SEMI_COLON, 0);
        }

        public Call_structContext call_struct() {
            return getRuleContext(Call_structContext.class, 0);
        }

        public Call_class_fieldContext call_class_field() {
            return getRuleContext(Call_class_fieldContext.class, 0);
        }

        public Call_class_funcContext call_class_func() {
            return getRuleContext(Call_class_funcContext.class, 0);
        }

        public Create_classContext create_class() {
            return getRuleContext(Create_classContext.class, 0);
        }

        public Create_structContext create_struct() {
            return getRuleContext(Create_structContext.class, 0);
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
            setState(106);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(83);
                    def_var();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(84);
                    assign_var();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(85);
                    if_statement();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(86);
                    while_loop();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(87);
                    do_while_loop();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(88);
                    for_loop();
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(89);
                    read();
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(90);
                    print();
                }
                break;
                case 9:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(91);
                    comment();
                }
                break;
                case 10:
                    enterOuterAlt(_localctx, 10);
                {
                    {
                        setState(92);
                        call_func();
                        setState(93);
                        match(SEMI_COLON);
                    }
                }
                break;
                case 11:
                    enterOuterAlt(_localctx, 11);
                {
                    {
                        setState(95);
                        call_struct();
                        setState(96);
                        match(SEMI_COLON);
                    }
                }
                break;
                case 12:
                    enterOuterAlt(_localctx, 12);
                {
                    {
                        setState(98);
                        call_class_field();
                        setState(99);
                        match(SEMI_COLON);
                    }
                }
                break;
                case 13:
                    enterOuterAlt(_localctx, 13);
                {
                    {
                        setState(101);
                        call_class_func();
                        setState(102);
                        match(SEMI_COLON);
                    }
                }
                break;
                case 14:
                    enterOuterAlt(_localctx, 14);
                {
                    setState(104);
                    create_class();
                }
                break;
                case 15:
                    enterOuterAlt(_localctx, 15);
                {
                    setState(105);
                    create_struct();
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
                setState(108);
                define();
                setState(109);
                match(NAME);
                setState(110);
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
                setState(112);
                for_loop_assign();
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
                setState(114);
                match(NAME);
                setState(115);
                match(ASSIGN);
                setState(116);
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
                setState(118);
                match(READ);
                setState(119);
                match(NAME);
                setState(120);
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
                setState(122);
                match(PRINT);
                setState(123);
                match(NAME);
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
                setState(126);
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
                setState(128);
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

        public TerminalNode SEMI_COLON() {
            return getToken(langParser.SEMI_COLON, 0);
        }

        public Init_varContext init_var() {
            return getRuleContext(Init_varContext.class, 0);
        }

        public Math_moduleContext math_module() {
            return getRuleContext(Math_moduleContext.class, 0);
        }

        public Call_funcContext call_func() {
            return getRuleContext(Call_funcContext.class, 0);
        }

        public Call_structContext call_struct() {
            return getRuleContext(Call_structContext.class, 0);
        }

        public Call_class_funcContext call_class_func() {
            return getRuleContext(Call_class_funcContext.class, 0);
        }

        public Call_class_fieldContext call_class_field() {
            return getRuleContext(Call_class_fieldContext.class, 0);
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
            setState(140);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    {
                        setState(133);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                            case 1: {
                                setState(130);
                                init_var();
                            }
                            break;
                            case 2: {
                                setState(131);
                                math_module();
                            }
                            break;
                            case 3: {
                                setState(132);
                                call_func();
                            }
                            break;
                        }
                        setState(135);
                        match(SEMI_COLON);
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(137);
                    call_struct();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(138);
                    call_class_func();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(139);
                    call_class_field();
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
                setState(142);
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

    public static class Def_classContext extends ParserRuleContext {

        public TerminalNode CLASS() {
            return getToken(langParser.CLASS, 0);
        }

        public TerminalNode CLASS_NAME() {
            return getToken(langParser.CLASS_NAME, 0);
        }

        public Def_classContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_def_class;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterDef_class(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitDef_class(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitDef_class(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Def_classContext def_class() throws RecognitionException {
        Def_classContext _localctx = new Def_classContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_def_class);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(144);
                match(CLASS);
                setState(145);
                match(CLASS_NAME);
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

    public static class Class_Context extends ParserRuleContext {

        public Def_classContext def_class() {
            return getRuleContext(Def_classContext.class, 0);
        }

        public TerminalNode OPEN_BRACE() {
            return getToken(langParser.OPEN_BRACE, 0);
        }

        public TerminalNode CLOSE_BRACE() {
            return getToken(langParser.CLOSE_BRACE, 0);
        }

        public List<Def_varContext> def_var() {
            return getRuleContexts(Def_varContext.class);
        }

        public Def_varContext def_var(int i) {
            return getRuleContext(Def_varContext.class, i);
        }

        public List<Def_funcContext> def_func() {
            return getRuleContexts(Def_funcContext.class);
        }

        public Def_funcContext def_func(int i) {
            return getRuleContext(Def_funcContext.class, i);
        }

        public List<Create_structContext> create_struct() {
            return getRuleContexts(Create_structContext.class);
        }

        public Create_structContext create_struct(int i) {
            return getRuleContext(Create_structContext.class, i);
        }

        public List<Create_classContext> create_class() {
            return getRuleContexts(Create_classContext.class);
        }

        public Create_classContext create_class(int i) {
            return getRuleContext(Create_classContext.class, i);
        }

        public Class_Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_class_;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterClass_(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitClass_(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitClass_(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Class_Context class_() throws RecognitionException {
        Class_Context _localctx = new Class_Context(_ctx, getState());
        enterRule(_localctx, 24, RULE_class_);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(147);
                def_class();
                setState(148);
                match(OPEN_BRACE);
                setState(155);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0
                    && ((1L << _la) & ((1L << FUNCTION) | (1L << DEF_INT) | (1L << DEF_FLOAT) | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << CLASS_NAME)))
                    != 0)) {
                    {
                        setState(153);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                            case 1: {
                                setState(149);
                                def_var();
                            }
                            break;
                            case 2: {
                                setState(150);
                                def_func();
                            }
                            break;
                            case 3: {
                                setState(151);
                                create_struct();
                            }
                            break;
                            case 4: {
                                setState(152);
                                create_class();
                            }
                            break;
                        }
                    }
                    setState(157);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(158);
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

    public static class Create_classContext extends ParserRuleContext {

        public List<TerminalNode> CLASS_NAME() {
            return getTokens(langParser.CLASS_NAME);
        }

        public TerminalNode CLASS_NAME(int i) {
            return getToken(langParser.CLASS_NAME, i);
        }

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public TerminalNode ASSIGN() {
            return getToken(langParser.ASSIGN, 0);
        }

        public TerminalNode NEW() {
            return getToken(langParser.NEW, 0);
        }

        public TerminalNode CLASS() {
            return getToken(langParser.CLASS, 0);
        }

        public TerminalNode OPEN_PAREN() {
            return getToken(langParser.OPEN_PAREN, 0);
        }

        public TerminalNode CLOSE_PAREN() {
            return getToken(langParser.CLOSE_PAREN, 0);
        }

        public TerminalNode SEMI_COLON() {
            return getToken(langParser.SEMI_COLON, 0);
        }

        public Create_classContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_class;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterCreate_class(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitCreate_class(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitCreate_class(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Create_classContext create_class() throws RecognitionException {
        Create_classContext _localctx = new Create_classContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_create_class);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(160);
                match(CLASS_NAME);
                setState(161);
                match(NAME);
                setState(162);
                match(ASSIGN);
                setState(163);
                match(NEW);
                setState(164);
                match(CLASS);
                setState(165);
                match(CLASS_NAME);
                setState(166);
                match(OPEN_PAREN);
                setState(167);
                match(CLOSE_PAREN);
                setState(168);
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

    public static class Call_class_fieldContext extends ParserRuleContext {

        public List<TerminalNode> NAME() {
            return getTokens(langParser.NAME);
        }

        public TerminalNode NAME(int i) {
            return getToken(langParser.NAME, i);
        }

        public Call_class_fieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_call_class_field;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterCall_class_field(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitCall_class_field(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitCall_class_field(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Call_class_fieldContext call_class_field() throws RecognitionException {
        Call_class_fieldContext _localctx = new Call_class_fieldContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_call_class_field);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(170);
                match(NAME);
                setState(173);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(171);
                            match(T__0);
                            setState(172);
                            match(NAME);
                        }
                    }
                    setState(175);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T__0);
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

    public static class Call_class_funcContext extends ParserRuleContext {

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public Call_funcContext call_func() {
            return getRuleContext(Call_funcContext.class, 0);
        }

        public Call_class_funcContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_call_class_func;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterCall_class_func(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitCall_class_func(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitCall_class_func(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Call_class_funcContext call_class_func() throws RecognitionException {
        Call_class_funcContext _localctx = new Call_class_funcContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_call_class_func);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(177);
                match(NAME);
                setState(178);
                match(T__0);
                setState(179);
                call_func();
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

    public static class StructContext extends ParserRuleContext {

        public TerminalNode STRUCT() {
            return getToken(langParser.STRUCT, 0);
        }

        public TerminalNode CLASS_NAME() {
            return getToken(langParser.CLASS_NAME, 0);
        }

        public TerminalNode OPEN_BRACE() {
            return getToken(langParser.OPEN_BRACE, 0);
        }

        public TerminalNode CLOSE_BRACE() {
            return getToken(langParser.CLOSE_BRACE, 0);
        }

        public List<Def_varContext> def_var() {
            return getRuleContexts(Def_varContext.class);
        }

        public Def_varContext def_var(int i) {
            return getRuleContext(Def_varContext.class, i);
        }

        public StructContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_struct;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterStruct(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitStruct(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitStruct(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final StructContext struct() throws RecognitionException {
        StructContext _localctx = new StructContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_struct);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(181);
                match(STRUCT);
                setState(182);
                match(CLASS_NAME);
                setState(183);
                match(OPEN_BRACE);
                setState(187);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEF_INT) | (1L << DEF_FLOAT) | (1L << DEF_STRING) | (1L << DEF_BOOL))) != 0)) {
                    {
                        {
                            setState(184);
                            def_var();
                        }
                    }
                    setState(189);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(190);
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

    public static class Create_structContext extends ParserRuleContext {

        public List<TerminalNode> CLASS_NAME() {
            return getTokens(langParser.CLASS_NAME);
        }

        public TerminalNode CLASS_NAME(int i) {
            return getToken(langParser.CLASS_NAME, i);
        }

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public TerminalNode ASSIGN() {
            return getToken(langParser.ASSIGN, 0);
        }

        public TerminalNode NEW() {
            return getToken(langParser.NEW, 0);
        }

        public TerminalNode STRUCT() {
            return getToken(langParser.STRUCT, 0);
        }

        public TerminalNode OPEN_PAREN() {
            return getToken(langParser.OPEN_PAREN, 0);
        }

        public TerminalNode CLOSE_PAREN() {
            return getToken(langParser.CLOSE_PAREN, 0);
        }

        public TerminalNode SEMI_COLON() {
            return getToken(langParser.SEMI_COLON, 0);
        }

        public Create_structContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_struct;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterCreate_struct(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitCreate_struct(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitCreate_struct(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Create_structContext create_struct() throws RecognitionException {
        Create_structContext _localctx = new Create_structContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_create_struct);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(192);
                match(CLASS_NAME);
                setState(193);
                match(NAME);
                setState(194);
                match(ASSIGN);
                setState(195);
                match(NEW);
                setState(196);
                match(STRUCT);
                setState(197);
                match(CLASS_NAME);
                setState(198);
                match(OPEN_PAREN);
                setState(199);
                match(CLOSE_PAREN);
                setState(200);
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

    public static class Call_structContext extends ParserRuleContext {

        public List<TerminalNode> NAME() {
            return getTokens(langParser.NAME);
        }

        public TerminalNode NAME(int i) {
            return getToken(langParser.NAME, i);
        }

        public Call_structContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_call_struct;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterCall_struct(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitCall_struct(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitCall_struct(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Call_structContext call_struct() throws RecognitionException {
        Call_structContext _localctx = new Call_structContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_call_struct);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(202);
                match(NAME);
                setState(203);
                match(T__0);
                setState(204);
                match(NAME);
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

    public static class Def_funcContext extends ParserRuleContext {

        public TerminalNode FUNCTION() {
            return getToken(langParser.FUNCTION, 0);
        }

        public DefineContext define() {
            return getRuleContext(DefineContext.class, 0);
        }

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public TerminalNode OPEN_PAREN() {
            return getToken(langParser.OPEN_PAREN, 0);
        }

        public TerminalNode CLOSE_PAREN() {
            return getToken(langParser.CLOSE_PAREN, 0);
        }

        public TerminalNode OPEN_BRACE() {
            return getToken(langParser.OPEN_BRACE, 0);
        }

        public RetContext ret() {
            return getRuleContext(RetContext.class, 0);
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

        public List<Def_argsContext> def_args() {
            return getRuleContexts(Def_argsContext.class);
        }

        public Def_argsContext def_args(int i) {
            return getRuleContext(Def_argsContext.class, i);
        }

        public Def_funcContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_def_func;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterDef_func(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitDef_func(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitDef_func(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Def_funcContext def_func() throws RecognitionException {
        Def_funcContext _localctx = new Def_funcContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_def_func);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(206);
                match(FUNCTION);
                setState(207);
                define();
                setState(208);
                match(NAME);
                setState(209);
                match(OPEN_PAREN);
                setState(222);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 11, _ctx)) {
                    case 1: {
                        setState(211);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEF_INT) | (1L << DEF_FLOAT) | (1L << DEF_STRING) | (1L << DEF_BOOL))) != 0)) {
                            {
                                setState(210);
                                def_args();
                            }
                        }

                    }
                    break;
                    case 2: {
                        {
                            setState(216);
                            _errHandler.sync(this);
                            _alt = 1;
                            do {
                                switch (_alt) {
                                    case 1: {
                                        {
                                            setState(213);
                                            def_args();
                                            setState(214);
                                            match(T__1);
                                        }
                                    }
                                    break;
                                    default:
                                        throw new NoViableAltException(this);
                                }
                                setState(218);
                                _errHandler.sync(this);
                                _alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
                            } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                            setState(220);
                            def_args();
                        }
                    }
                    break;
                }
                setState(224);
                match(CLOSE_PAREN);
                setState(225);
                match(OPEN_BRACE);
                setState(229);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 &&
                    ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L << DEF_FLOAT)
                        | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << CLASS_NAME) | (1L << NAME) | (1L << COMMENT))) != 0)) {
                    {
                        {
                            setState(226);
                            statement();
                        }
                    }
                    setState(231);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(232);
                ret();
                setState(233);
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

    public static class Def_argsContext extends ParserRuleContext {

        public DefineContext define() {
            return getRuleContext(DefineContext.class, 0);
        }

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public Def_argsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_def_args;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterDef_args(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitDef_args(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitDef_args(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Def_argsContext def_args() throws RecognitionException {
        Def_argsContext _localctx = new Def_argsContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_def_args);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(235);
                define();
                setState(236);
                match(NAME);
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

    public static class ArgsContext extends ParserRuleContext {

        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        public ArgsContext args() {
            return getRuleContext(ArgsContext.class, 0);
        }

        public ArgsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_args;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterArgs(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitArgs(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitArgs(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final ArgsContext args() throws RecognitionException {
        ArgsContext _localctx = new ArgsContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_args);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(238);
                value();
                setState(242);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case CLOSE_PAREN:
                    case INT:
                    case FLOAT:
                    case STRING:
                    case TRUE:
                    case FALSE:
                    case NAME: {
                    }
                    break;
                    case T__1: {
                        {
                            setState(240);
                            match(T__1);
                            setState(241);
                            args();
                        }
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

    public static class Call_funcContext extends ParserRuleContext {

        public TerminalNode NAME() {
            return getToken(langParser.NAME, 0);
        }

        public TerminalNode OPEN_PAREN() {
            return getToken(langParser.OPEN_PAREN, 0);
        }

        public TerminalNode CLOSE_PAREN() {
            return getToken(langParser.CLOSE_PAREN, 0);
        }

        public List<ArgsContext> args() {
            return getRuleContexts(ArgsContext.class);
        }

        public ArgsContext args(int i) {
            return getRuleContext(ArgsContext.class, i);
        }

        public Call_funcContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_call_func;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterCall_func(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitCall_func(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitCall_func(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Call_funcContext call_func() throws RecognitionException {
        Call_funcContext _localctx = new Call_funcContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_call_func);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(244);
                match(NAME);
                setState(245);
                match(OPEN_PAREN);
                setState(249);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0
                    && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << STRING) | (1L << TRUE) | (1L << FALSE) | (1L << NAME))) != 0)) {
                    {
                        {
                            setState(246);
                            args();
                        }
                    }
                    setState(251);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(252);
                match(CLOSE_PAREN);
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

    public static class RetContext extends ParserRuleContext {

        public TerminalNode RETURN() {
            return getToken(langParser.RETURN, 0);
        }

        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        public TerminalNode SEMI_COLON() {
            return getToken(langParser.SEMI_COLON, 0);
        }

        public RetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ret;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterRet(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitRet(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitRet(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final RetContext ret() throws RecognitionException {
        RetContext _localctx = new RetContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_ret);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(254);
                match(RETURN);
                setState(255);
                value();
                setState(256);
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
        enterRule(_localctx, 48, RULE_for_loop);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(258);
                match(FOR);
                setState(259);
                match(OPEN_PAREN);
                setState(260);
                for_loop_assign();
                setState(261);
                match(SEMI_COLON);
                setState(262);
                condition();
                setState(263);
                match(SEMI_COLON);
                setState(264);
                for_loop_assign();
                setState(265);
                match(CLOSE_PAREN);
                setState(266);
                match(OPEN_BRACE);
                setState(270);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 &&
                    ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L << DEF_FLOAT)
                        | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << CLASS_NAME) | (1L << NAME) | (1L << COMMENT))) != 0)) {
                    {
                        {
                            setState(267);
                            statement();
                        }
                    }
                    setState(272);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(273);
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
        enterRule(_localctx, 50, RULE_do_while_loop);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(275);
                match(DO);
                setState(276);
                match(OPEN_BRACE);
                setState(280);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 &&
                    ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L << DEF_FLOAT)
                        | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << CLASS_NAME) | (1L << NAME) | (1L << COMMENT))) != 0)) {
                    {
                        {
                            setState(277);
                            statement();
                        }
                    }
                    setState(282);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(283);
                match(CLOSE_BRACE);
                setState(284);
                match(WHILE);
                setState(285);
                match(OPEN_PAREN);
                setState(286);
                condition();
                setState(287);
                match(CLOSE_PAREN);
                setState(288);
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
        enterRule(_localctx, 52, RULE_while_loop);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(290);
                match(WHILE);
                setState(291);
                match(OPEN_PAREN);
                setState(292);
                condition();
                setState(293);
                match(CLOSE_PAREN);
                setState(294);
                match(OPEN_BRACE);
                setState(298);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 &&
                    ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L << DEF_FLOAT)
                        | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << CLASS_NAME) | (1L << NAME) | (1L << COMMENT))) != 0)) {
                    {
                        {
                            setState(295);
                            statement();
                        }
                    }
                    setState(300);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(301);
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
        enterRule(_localctx, 54, RULE_if_begin);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(303);
                match(IF);
                setState(304);
                match(OPEN_PAREN);
                setState(305);
                condition();
                setState(306);
                match(CLOSE_PAREN);
                setState(307);
                match(OPEN_BRACE);
                setState(311);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 &&
                    ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L << DEF_FLOAT)
                        | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << CLASS_NAME) | (1L << NAME) | (1L << COMMENT))) != 0)) {
                    {
                        {
                            setState(308);
                            statement();
                        }
                    }
                    setState(313);
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
        enterRule(_localctx, 56, RULE_if_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(314);
                if_begin();
                setState(315);
                match(CLOSE_BRACE);
                setState(318);
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
                    case FUNCTION:
                    case RETURN:
                    case CLASS:
                    case STRUCT:
                    case DEF_INT:
                    case DEF_FLOAT:
                    case DEF_STRING:
                    case DEF_BOOL:
                    case CLASS_NAME:
                    case NAME:
                    case COMMENT: {
                    }
                    break;
                    case ELSE: {
                        setState(317);
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
        enterRule(_localctx, 58, RULE_else_statement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(320);
                match(ELSE);
                setState(330);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case OPEN_BRACE: {
                        setState(321);
                        match(OPEN_BRACE);
                        setState(325);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while ((((_la) & ~0x3f) == 0 &&
                            ((1L << _la) & ((1L << READ) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << DEF_INT) | (1L
                                << DEF_FLOAT) | (1L << DEF_STRING) | (1L << DEF_BOOL) | (1L << CLASS_NAME) | (1L << NAME) | (1L << COMMENT))) != 0)) {
                            {
                                {
                                    setState(322);
                                    statement();
                                }
                            }
                            setState(327);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(328);
                        match(CLOSE_BRACE);
                    }
                    break;
                    case IF: {
                        setState(329);
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
        enterRule(_localctx, 60, RULE_numeric_value);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(332);
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

        public Call_externalContext call_external() {
            return getRuleContext(Call_externalContext.class, 0);
        }

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
        enterRule(_localctx, 62, RULE_math_var);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(337);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 22, _ctx)) {
                    case 1: {
                        setState(334);
                        call_external();
                    }
                    break;
                    case 2: {
                        setState(335);
                        numeric_value();
                    }
                    break;
                    case 3: {
                        setState(336);
                        match(NAME);
                    }
                    break;
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
        enterRule(_localctx, 64, RULE_bool);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(339);
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

        public Call_structContext call_struct() {
            return getRuleContext(Call_structContext.class, 0);
        }

        public Call_class_fieldContext call_class_field() {
            return getRuleContext(Call_class_fieldContext.class, 0);
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
        enterRule(_localctx, 66, RULE_value);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(348);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 23, _ctx)) {
                    case 1: {
                        setState(341);
                        match(STRING);
                    }
                    break;
                    case 2: {
                        setState(342);
                        match(NAME);
                    }
                    break;
                    case 3: {
                        setState(343);
                        match(TRUE);
                    }
                    break;
                    case 4: {
                        setState(344);
                        match(FALSE);
                    }
                    break;
                    case 5: {
                        setState(345);
                        numeric_value();
                    }
                    break;
                    case 6: {
                        setState(346);
                        call_struct();
                    }
                    break;
                    case 7: {
                        setState(347);
                        call_class_field();
                    }
                    break;
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

    public static class Call_externalContext extends ParserRuleContext {

        public Call_funcContext call_func() {
            return getRuleContext(Call_funcContext.class, 0);
        }

        public Call_structContext call_struct() {
            return getRuleContext(Call_structContext.class, 0);
        }

        public Call_class_funcContext call_class_func() {
            return getRuleContext(Call_class_funcContext.class, 0);
        }

        public Call_class_fieldContext call_class_field() {
            return getRuleContext(Call_class_fieldContext.class, 0);
        }

        public Call_externalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_call_external;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).enterCall_external(this);
			}
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
			if (listener instanceof langListener) {
				((langListener) listener).exitCall_external(this);
			}
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof langVisitor) {
				return ((langVisitor<? extends T>) visitor).visitCall_external(this);
			} else {
				return visitor.visitChildren(this);
			}
        }
    }

    public final Call_externalContext call_external() throws RecognitionException {
        Call_externalContext _localctx = new Call_externalContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_call_external);
        try {
            setState(354);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 24, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(350);
                    call_func();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(351);
                    call_struct();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(352);
                    call_class_func();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(353);
                    call_class_field();
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
        enterRule(_localctx, 70, RULE_math_module);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(356);
                math_var();
                setState(357);
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
                setState(358);
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

        public List<Call_externalContext> call_external() {
            return getRuleContexts(Call_externalContext.class);
        }

        public Call_externalContext call_external(int i) {
            return getRuleContext(Call_externalContext.class, i);
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
        enterRule(_localctx, 72, RULE_condition);
        int _la;
        try {
            setState(380);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 29, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(363);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 25, _ctx)) {
                        case 1: {
                            setState(360);
                            value();
                        }
                        break;
                        case 2: {
                            setState(361);
                            math_module();
                        }
                        break;
                        case 3: {
                            setState(362);
                            call_external();
                        }
                        break;
                    }
                    setState(365);
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
                    setState(369);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 26, _ctx)) {
                        case 1: {
                            setState(366);
                            value();
                        }
                        break;
                        case 2: {
                            setState(367);
                            math_module();
                        }
                        break;
                        case 3: {
                            setState(368);
                            call_external();
                        }
                        break;
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(372);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(371);
                            match(NOT);
                        }
                    }

                    setState(376);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case TRUE:
                        case FALSE: {
                            setState(374);
                            bool();
                        }
                        break;
                        case NAME: {
                            setState(375);
                            call_external();
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
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
        "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u0181\4\2\t\2" +
            "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
            "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
            "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
            "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
            "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\7\2Q\n\2\f\2\16\2" +
            "T\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3" +
            "\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3m\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6" +
            "\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13" +
            "\5\13\u0088\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u008f\n\13\3\f\3\f\3\r" +
            "\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u009c\n\16\f\16\16\16\u009f" +
            "\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20" +
            "\3\20\3\20\6\20\u00b0\n\20\r\20\16\20\u00b1\3\21\3\21\3\21\3\21\3\22\3" +
            "\22\3\22\3\22\7\22\u00bc\n\22\f\22\16\22\u00bf\13\22\3\22\3\22\3\23\3" +
            "\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3" +
            "\25\3\25\3\25\3\25\5\25\u00d6\n\25\3\25\3\25\3\25\6\25\u00db\n\25\r\25" +
            "\16\25\u00dc\3\25\3\25\5\25\u00e1\n\25\3\25\3\25\3\25\7\25\u00e6\n\25" +
            "\f\25\16\25\u00e9\13\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3" +
            "\27\5\27\u00f5\n\27\3\30\3\30\3\30\7\30\u00fa\n\30\f\30\16\30\u00fd\13" +
            "\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3" +
            "\32\3\32\3\32\7\32\u010f\n\32\f\32\16\32\u0112\13\32\3\32\3\32\3\33\3" +
            "\33\3\33\7\33\u0119\n\33\f\33\16\33\u011c\13\33\3\33\3\33\3\33\3\33\3" +
            "\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u012b\n\34\f\34\16\34" +
            "\u012e\13\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0138\n\35\f" +
            "\35\16\35\u013b\13\35\3\36\3\36\3\36\3\36\5\36\u0141\n\36\3\37\3\37\3" +
            "\37\7\37\u0146\n\37\f\37\16\37\u0149\13\37\3\37\3\37\5\37\u014d\n\37\3" +
            " \3 \3!\3!\3!\5!\u0154\n!\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\5#\u015f\n#\3$" +
            "\3$\3$\3$\5$\u0165\n$\3%\3%\3%\3%\3&\3&\3&\5&\u016e\n&\3&\3&\3&\3&\5&" +
            "\u0174\n&\3&\5&\u0177\n&\3&\3&\5&\u017b\n&\3&\3&\5&\u017f\n&\3&\2\2\'" +
            "\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH" +
            "J\2\7\3\2.\61\3\2\20\21\3\2\37 \3\2\32\36\3\2\23\30\2\u0197\2R\3\2\2\2" +
            "\4l\3\2\2\2\6n\3\2\2\2\br\3\2\2\2\nt\3\2\2\2\fx\3\2\2\2\16|\3\2\2\2\20" +
            "\u0080\3\2\2\2\22\u0082\3\2\2\2\24\u008e\3\2\2\2\26\u0090\3\2\2\2\30\u0092" +
            "\3\2\2\2\32\u0095\3\2\2\2\34\u00a2\3\2\2\2\36\u00ac\3\2\2\2 \u00b3\3\2" +
            "\2\2\"\u00b7\3\2\2\2$\u00c2\3\2\2\2&\u00cc\3\2\2\2(\u00d0\3\2\2\2*\u00ed" +
            "\3\2\2\2,\u00f0\3\2\2\2.\u00f6\3\2\2\2\60\u0100\3\2\2\2\62\u0104\3\2\2" +
            "\2\64\u0115\3\2\2\2\66\u0124\3\2\2\28\u0131\3\2\2\2:\u013c\3\2\2\2<\u0142" +
            "\3\2\2\2>\u014e\3\2\2\2@\u0153\3\2\2\2B\u0155\3\2\2\2D\u015e\3\2\2\2F" +
            "\u0164\3\2\2\2H\u0166\3\2\2\2J\u017e\3\2\2\2LQ\5\4\3\2MQ\5(\25\2NQ\5\32" +
            "\16\2OQ\5\"\22\2PL\3\2\2\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2QT\3\2\2\2RP\3" +
            "\2\2\2RS\3\2\2\2S\3\3\2\2\2TR\3\2\2\2Um\5\6\4\2Vm\5\b\5\2Wm\5:\36\2Xm" +
            "\5\66\34\2Ym\5\64\33\2Zm\5\62\32\2[m\5\f\7\2\\m\5\16\b\2]m\5\20\t\2^_" +
            "\5.\30\2_`\7\b\2\2`m\3\2\2\2ab\5&\24\2bc\7\b\2\2cm\3\2\2\2de\5\36\20\2" +
            "ef\7\b\2\2fm\3\2\2\2gh\5 \21\2hi\7\b\2\2im\3\2\2\2jm\5\34\17\2km\5$\23" +
            "\2lU\3\2\2\2lV\3\2\2\2lW\3\2\2\2lX\3\2\2\2lY\3\2\2\2lZ\3\2\2\2l[\3\2\2" +
            "\2l\\\3\2\2\2l]\3\2\2\2l^\3\2\2\2la\3\2\2\2ld\3\2\2\2lg\3\2\2\2lj\3\2" +
            "\2\2lk\3\2\2\2m\5\3\2\2\2no\5\22\n\2op\7\63\2\2pq\7\b\2\2q\7\3\2\2\2r" +
            "s\5\n\6\2s\t\3\2\2\2tu\7\63\2\2uv\7\7\2\2vw\5\24\13\2w\13\3\2\2\2xy\7" +
            "\5\2\2yz\7\63\2\2z{\7\b\2\2{\r\3\2\2\2|}\7\6\2\2}~\7\63\2\2~\177\7\b\2" +
            "\2\177\17\3\2\2\2\u0080\u0081\7\65\2\2\u0081\21\3\2\2\2\u0082\u0083\t" +
            "\2\2\2\u0083\23\3\2\2\2\u0084\u0088\5\26\f\2\u0085\u0088\5H%\2\u0086\u0088" +
            "\5.\30\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2\2\2\u0088" +
            "\u0089\3\2\2\2\u0089\u008a\7\b\2\2\u008a\u008f\3\2\2\2\u008b\u008f\5&" +
            "\24\2\u008c\u008f\5 \21\2\u008d\u008f\5\36\20\2\u008e\u0087\3\2\2\2\u008e" +
            "\u008b\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2\2\2\u008f\25\3\2\2" +
            "\2\u0090\u0091\5D#\2\u0091\27\3\2\2\2\u0092\u0093\7+\2\2\u0093\u0094\7" +
            "\62\2\2\u0094\31\3\2\2\2\u0095\u0096\5\30\r\2\u0096\u009d\7\f\2\2\u0097" +
            "\u009c\5\6\4\2\u0098\u009c\5(\25\2\u0099\u009c\5$\23\2\u009a\u009c\5\34" +
            "\17\2\u009b\u0097\3\2\2\2\u009b\u0098\3\2\2\2\u009b\u0099\3\2\2\2\u009b" +
            "\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2" +
            "\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\r\2\2\u00a1" +
            "\33\3\2\2\2\u00a2\u00a3\7\62\2\2\u00a3\u00a4\7\63\2\2\u00a4\u00a5\7\7" +
            "\2\2\u00a5\u00a6\7-\2\2\u00a6\u00a7\7+\2\2\u00a7\u00a8\7\62\2\2\u00a8" +
            "\u00a9\7\n\2\2\u00a9\u00aa\7\13\2\2\u00aa\u00ab\7\b\2\2\u00ab\35\3\2\2" +
            "\2\u00ac\u00af\7\63\2\2\u00ad\u00ae\7\3\2\2\u00ae\u00b0\7\63\2\2\u00af" +
            "\u00ad\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2" +
            "\2\2\u00b2\37\3\2\2\2\u00b3\u00b4\7\63\2\2\u00b4\u00b5\7\3\2\2\u00b5\u00b6" +
            "\5.\30\2\u00b6!\3\2\2\2\u00b7\u00b8\7,\2\2\u00b8\u00b9\7\62\2\2\u00b9" +
            "\u00bd\7\f\2\2\u00ba\u00bc\5\6\4\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2" +
            "\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf" +
            "\u00bd\3\2\2\2\u00c0\u00c1\7\r\2\2\u00c1#\3\2\2\2\u00c2\u00c3\7\62\2\2" +
            "\u00c3\u00c4\7\63\2\2\u00c4\u00c5\7\7\2\2\u00c5\u00c6\7-\2\2\u00c6\u00c7" +
            "\7,\2\2\u00c7\u00c8\7\62\2\2\u00c8\u00c9\7\n\2\2\u00c9\u00ca\7\13\2\2" +
            "\u00ca\u00cb\7\b\2\2\u00cb%\3\2\2\2\u00cc\u00cd\7\63\2\2\u00cd\u00ce\7" +
            "\3\2\2\u00ce\u00cf\7\63\2\2\u00cf\'\3\2\2\2\u00d0\u00d1\7)\2\2\u00d1\u00d2" +
            "\5\22\n\2\u00d2\u00d3\7\63\2\2\u00d3\u00e0\7\n\2\2\u00d4\u00d6\5*\26\2" +
            "\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00e1\3\2\2\2\u00d7\u00d8" +
            "\5*\26\2\u00d8\u00d9\7\4\2\2\u00d9\u00db\3\2\2\2\u00da\u00d7\3\2\2\2\u00db" +
            "\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2" +
            "\2\2\u00de\u00df\5*\26\2\u00df\u00e1\3\2\2\2\u00e0\u00d5\3\2\2\2\u00e0" +
            "\u00da\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\7\13\2\2\u00e3\u00e7\7" +
            "\f\2\2\u00e4\u00e6\5\4\3\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7" +
            "\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2" +
            "\2\2\u00ea\u00eb\5\60\31\2\u00eb\u00ec\7\r\2\2\u00ec)\3\2\2\2\u00ed\u00ee" +
            "\5\22\n\2\u00ee\u00ef\7\63\2\2\u00ef+\3\2\2\2\u00f0\u00f4\5D#\2\u00f1" +
            "\u00f5\3\2\2\2\u00f2\u00f3\7\4\2\2\u00f3\u00f5\5,\27\2\u00f4\u00f1\3\2" +
            "\2\2\u00f4\u00f2\3\2\2\2\u00f5-\3\2\2\2\u00f6\u00f7\7\63\2\2\u00f7\u00fb" +
            "\7\n\2\2\u00f8\u00fa\5,\27\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb" +
            "\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2" +
            "\2\2\u00fe\u00ff\7\13\2\2\u00ff/\3\2\2\2\u0100\u0101\7*\2\2\u0101\u0102" +
            "\5D#\2\u0102\u0103\7\b\2\2\u0103\61\3\2\2\2\u0104\u0105\7(\2\2\u0105\u0106" +
            "\7\n\2\2\u0106\u0107\5\n\6\2\u0107\u0108\7\b\2\2\u0108\u0109\5J&\2\u0109" +
            "\u010a\7\b\2\2\u010a\u010b\5\n\6\2\u010b\u010c\7\13\2\2\u010c\u0110\7" +
            "\f\2\2\u010d\u010f\5\4\3\2\u010e\u010d\3\2\2\2\u010f\u0112\3\2\2\2\u0110" +
            "\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112\u0110\3\2" +
            "\2\2\u0113\u0114\7\r\2\2\u0114\63\3\2\2\2\u0115\u0116\7\'\2\2\u0116\u011a" +
            "\7\f\2\2\u0117\u0119\5\4\3\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a" +
            "\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2" +
            "\2\2\u011d\u011e\7\r\2\2\u011e\u011f\7&\2\2\u011f\u0120\7\n\2\2\u0120" +
            "\u0121\5J&\2\u0121\u0122\7\13\2\2\u0122\u0123\7\b\2\2\u0123\65\3\2\2\2" +
            "\u0124\u0125\7&\2\2\u0125\u0126\7\n\2\2\u0126\u0127\5J&\2\u0127\u0128" +
            "\7\13\2\2\u0128\u012c\7\f\2\2\u0129\u012b\5\4\3\2\u012a\u0129\3\2\2\2" +
            "\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012f" +
            "\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0130\7\r\2\2\u0130\67\3\2\2\2\u0131" +
            "\u0132\7#\2\2\u0132\u0133\7\n\2\2\u0133\u0134\5J&\2\u0134\u0135\7\13\2" +
            "\2\u0135\u0139\7\f\2\2\u0136\u0138\5\4\3\2\u0137\u0136\3\2\2\2\u0138\u013b" +
            "\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a9\3\2\2\2\u013b" +
            "\u0139\3\2\2\2\u013c\u013d\58\35\2\u013d\u0140\7\r\2\2\u013e\u0141\3\2" +
            "\2\2\u013f\u0141\5<\37\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141" +
            ";\3\2\2\2\u0142\u014c\7%\2\2\u0143\u0147\7\f\2\2\u0144\u0146\5\4\3\2\u0145" +
            "\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2" +
            "\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014d\7\r\2\2\u014b" +
            "\u014d\5:\36\2\u014c\u0143\3\2\2\2\u014c\u014b\3\2\2\2\u014d=\3\2\2\2" +
            "\u014e\u014f\t\3\2\2\u014f?\3\2\2\2\u0150\u0154\5F$\2\u0151\u0154\5> " +
            "\2\u0152\u0154\7\63\2\2\u0153\u0150\3\2\2\2\u0153\u0151\3\2\2\2\u0153" +
            "\u0152\3\2\2\2\u0154A\3\2\2\2\u0155\u0156\t\4\2\2\u0156C\3\2\2\2\u0157" +
            "\u015f\7\22\2\2\u0158\u015f\7\63\2\2\u0159\u015f\7\37\2\2\u015a\u015f" +
            "\7 \2\2\u015b\u015f\5> \2\u015c\u015f\5&\24\2\u015d\u015f\5\36\20\2\u015e" +
            "\u0157\3\2\2\2\u015e\u0158\3\2\2\2\u015e\u0159\3\2\2\2\u015e\u015a\3\2" +
            "\2\2\u015e\u015b\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015d\3\2\2\2\u015f" +
            "E\3\2\2\2\u0160\u0165\5.\30\2\u0161\u0165\5&\24\2\u0162\u0165\5 \21\2" +
            "\u0163\u0165\5\36\20\2\u0164\u0160\3\2\2\2\u0164\u0161\3\2\2\2\u0164\u0162" +
            "\3\2\2\2\u0164\u0163\3\2\2\2\u0165G\3\2\2\2\u0166\u0167\5@!\2\u0167\u0168" +
            "\t\5\2\2\u0168\u0169\5@!\2\u0169I\3\2\2\2\u016a\u016e\5D#\2\u016b\u016e" +
            "\5H%\2\u016c\u016e\5F$\2\u016d\u016a\3\2\2\2\u016d\u016b\3\2\2\2\u016d" +
            "\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0173\t\6\2\2\u0170\u0174\5D" +
            "#\2\u0171\u0174\5H%\2\u0172\u0174\5F$\2\u0173\u0170\3\2\2\2\u0173\u0171" +
            "\3\2\2\2\u0173\u0172\3\2\2\2\u0174\u017f\3\2\2\2\u0175\u0177\7\31\2\2" +
            "\u0176\u0175\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u017b" +
            "\5B\"\2\u0179\u017b\5F$\2\u017a\u0178\3\2\2\2\u017a\u0179\3\2\2\2\u017b" +
            "\u017c\3\2\2\2\u017c\u017d\b&\1\2\u017d\u017f\3\2\2\2\u017e\u016d\3\2" +
            "\2\2\u017e\u0176\3\2\2\2\u017fK\3\2\2\2 PRl\u0087\u008e\u009b\u009d\u00b1" +
            "\u00bd\u00d5\u00dc\u00e0\u00e7\u00f4\u00fb\u0110\u011a\u012c\u0139\u0140" +
            "\u0147\u014c\u0153\u015e\u0164\u016d\u0173\u0176\u017a\u017e";
    public static final ATN _ATN =
        new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}