package com.asia.compiler.parser.gen;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langLexer extends Lexer {

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
    public static String[] channelNames = {
        "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
        "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
            "READ", "PRINT", "ASSIGN", "SEMI_COLON", "COLON", "OPEN_PAREN", "CLOSE_PAREN",
            "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET", "INT",
            "FLOAT", "STRING", "GT", "LT", "GT_EQ", "LT_EQ", "EQUAL", "NEQ", "NOT",
            "PLUS", "MINUS", "DIV", "MULT", "MOD", "TRUE", "FALSE", "AND", "OR",
            "IF", "END_IF", "ELSE", "WHILE", "DO", "FOR", "DEF_INT", "DEF_FLOAT",
            "DEF_STRING", "DEF_BOOL", "NAME", "NAME_PREFIX", "BLANK", "COMMENT",
            "NEXT_LINE", "UNKNOWN_CHAR"
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


    public langLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    @Override
    public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
        switch (ruleIndex) {
            case 12:
                FLOAT_action((RuleContext) _localctx, actionIndex);
                break;
        }
    }

    private void FLOAT_action(RuleContext _localctx, int actionIndex) {
        switch (actionIndex) {
            case 0:
                break;
        }
    }

    public static final String _serializedATN =
        "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u0125\b\1\4\2" +
            "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
            "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" +
            "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31" +
            "\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t" +
            " \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t" +
            "+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3" +
            "\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f" +
            "\3\f\3\r\6\r~\n\r\r\r\16\r\177\3\16\3\16\3\16\3\16\7\16\u0086\n\16\f\16" +
            "\16\16\u0089\13\16\5\16\u008b\n\16\3\16\3\16\7\16\u008f\n\16\f\16\16\16" +
            "\u0092\13\16\3\16\6\16\u0095\n\16\r\16\16\16\u0096\3\17\3\17\7\17\u009b" +
            "\n\17\f\17\16\17\u009e\13\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3" +
            "\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3" +
            "\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3" +
            "\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3" +
            "!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3%" +
            "\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)" +
            "\3)\3)\3)\3)\3*\3*\6*\u0104\n*\r*\16*\u0105\3+\3+\3+\3,\6,\u010c\n,\r" +
            ",\16,\u010d\3,\3,\3-\3-\7-\u0114\n-\f-\16-\u0117\13-\3-\3-\3-\3-\3.\6" +
            ".\u011e\n.\r.\16.\u011f\3.\3.\3/\3/\2\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17" +
            "\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+" +
            "\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+" +
            "U,W-Y.[/]\60\3\2\t\3\2\62;\3\2\62\62\3\2\63;\4\2$$^^\4\2\13\13\"\"\4\2" +
            "\f\f\16\17\3\2\f\f\2\u012e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2" +
            "\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2" +
            "\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3" +
            "\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2" +
            "\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67" +
            "\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2" +
            "\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2" +
            "\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]" +
            "\3\2\2\2\3_\3\2\2\2\5d\3\2\2\2\7j\3\2\2\2\tl\3\2\2\2\13n\3\2\2\2\rp\3" +
            "\2\2\2\17r\3\2\2\2\21t\3\2\2\2\23v\3\2\2\2\25x\3\2\2\2\27z\3\2\2\2\31" +
            "}\3\2\2\2\33\u008a\3\2\2\2\35\u0098\3\2\2\2\37\u00a1\3\2\2\2!\u00a3\3" +
            "\2\2\2#\u00a5\3\2\2\2%\u00a8\3\2\2\2\'\u00ab\3\2\2\2)\u00ae\3\2\2\2+\u00b1" +
            "\3\2\2\2-\u00b3\3\2\2\2/\u00b5\3\2\2\2\61\u00b7\3\2\2\2\63\u00b9\3\2\2" +
            "\2\65\u00bb\3\2\2\2\67\u00bd\3\2\2\29\u00c2\3\2\2\2;\u00c8\3\2\2\2=\u00cc" +
            "\3\2\2\2?\u00cf\3\2\2\2A\u00d2\3\2\2\2C\u00d9\3\2\2\2E\u00de\3\2\2\2G" +
            "\u00e4\3\2\2\2I\u00e7\3\2\2\2K\u00eb\3\2\2\2M\u00ef\3\2\2\2O\u00f5\3\2" +
            "\2\2Q\u00fc\3\2\2\2S\u0101\3\2\2\2U\u0107\3\2\2\2W\u010b\3\2\2\2Y\u0111" +
            "\3\2\2\2[\u011d\3\2\2\2]\u0123\3\2\2\2_`\7T\2\2`a\7G\2\2ab\7C\2\2bc\7" +
            "F\2\2c\4\3\2\2\2de\7R\2\2ef\7T\2\2fg\7K\2\2gh\7P\2\2hi\7V\2\2i\6\3\2\2" +
            "\2jk\7?\2\2k\b\3\2\2\2lm\7=\2\2m\n\3\2\2\2no\7<\2\2o\f\3\2\2\2pq\7*\2" +
            "\2q\16\3\2\2\2rs\7+\2\2s\20\3\2\2\2tu\7}\2\2u\22\3\2\2\2vw\7\177\2\2w" +
            "\24\3\2\2\2xy\7]\2\2y\26\3\2\2\2z{\7_\2\2{\30\3\2\2\2|~\t\2\2\2}|\3\2" +
            "\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\32\3\2\2\2\u0081" +
            "\u008b\t\3\2\2\u0082\u0083\t\4\2\2\u0083\u0087\b\16\2\2\u0084\u0086\t" +
            "\2\2\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087" +
            "\u0088\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u0081\3\2" +
            "\2\2\u008a\u0082\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u0090\13\2\2\2\u008d" +
            "\u008f\t\2\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2" +
            "\2\2\u0090\u0091\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093" +
            "\u0095\t\4\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2" +
            "\2\2\u0096\u0097\3\2\2\2\u0097\34\3\2\2\2\u0098\u009c\7$\2\2\u0099\u009b" +
            "\n\5\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c" +
            "\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7$" +
            "\2\2\u00a0\36\3\2\2\2\u00a1\u00a2\7@\2\2\u00a2 \3\2\2\2\u00a3\u00a4\7" +
            ">\2\2\u00a4\"\3\2\2\2\u00a5\u00a6\7@\2\2\u00a6\u00a7\7?\2\2\u00a7$\3\2" +
            "\2\2\u00a8\u00a9\7>\2\2\u00a9\u00aa\7?\2\2\u00aa&\3\2\2\2\u00ab\u00ac" +
            "\7?\2\2\u00ac\u00ad\7?\2\2\u00ad(\3\2\2\2\u00ae\u00af\7#\2\2\u00af\u00b0" +
            "\7?\2\2\u00b0*\3\2\2\2\u00b1\u00b2\7#\2\2\u00b2,\3\2\2\2\u00b3\u00b4\7" +
            "-\2\2\u00b4.\3\2\2\2\u00b5\u00b6\7/\2\2\u00b6\60\3\2\2\2\u00b7\u00b8\7" +
            "\61\2\2\u00b8\62\3\2\2\2\u00b9\u00ba\7,\2\2\u00ba\64\3\2\2\2\u00bb\u00bc" +
            "\7\'\2\2\u00bc\66\3\2\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7t\2\2\u00bf" +
            "\u00c0\7w\2\2\u00c0\u00c1\7g\2\2\u00c18\3\2\2\2\u00c2\u00c3\7h\2\2\u00c3" +
            "\u00c4\7c\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7g\2\2" +
            "\u00c7:\3\2\2\2\u00c8\u00c9\7C\2\2\u00c9\u00ca\7P\2\2\u00ca\u00cb\7F\2" +
            "\2\u00cb<\3\2\2\2\u00cc\u00cd\7Q\2\2\u00cd\u00ce\7T\2\2\u00ce>\3\2\2\2" +
            "\u00cf\u00d0\7K\2\2\u00d0\u00d1\7H\2\2\u00d1@\3\2\2\2\u00d2\u00d3\7G\2" +
            "\2\u00d3\u00d4\7P\2\2\u00d4\u00d5\7F\2\2\u00d5\u00d6\7\"\2\2\u00d6\u00d7" +
            "\7K\2\2\u00d7\u00d8\7H\2\2\u00d8B\3\2\2\2\u00d9\u00da\7G\2\2\u00da\u00db" +
            "\7N\2\2\u00db\u00dc\7U\2\2\u00dc\u00dd\7G\2\2\u00ddD\3\2\2\2\u00de\u00df" +
            "\7Y\2\2\u00df\u00e0\7J\2\2\u00e0\u00e1\7K\2\2\u00e1\u00e2\7N\2\2\u00e2" +
            "\u00e3\7G\2\2\u00e3F\3\2\2\2\u00e4\u00e5\7F\2\2\u00e5\u00e6\7Q\2\2\u00e6" +
            "H\3\2\2\2\u00e7\u00e8\7H\2\2\u00e8\u00e9\7Q\2\2\u00e9\u00ea\7T\2\2\u00ea" +
            "J\3\2\2\2\u00eb\u00ec\7K\2\2\u00ec\u00ed\7P\2\2\u00ed\u00ee\7V\2\2\u00ee" +
            "L\3\2\2\2\u00ef\u00f0\7H\2\2\u00f0\u00f1\7N\2\2\u00f1\u00f2\7Q\2\2\u00f2" +
            "\u00f3\7C\2\2\u00f3\u00f4\7V\2\2\u00f4N\3\2\2\2\u00f5\u00f6\7U\2\2\u00f6" +
            "\u00f7\7V\2\2\u00f7\u00f8\7T\2\2\u00f8\u00f9\7K\2\2\u00f9\u00fa\7P\2\2" +
            "\u00fa\u00fb\7I\2\2\u00fbP\3\2\2\2\u00fc\u00fd\7D\2\2\u00fd\u00fe\7Q\2" +
            "\2\u00fe\u00ff\7Q\2\2\u00ff\u0100\7N\2\2\u0100R\3\2\2\2\u0101\u0103\5" +
            "U+\2\u0102\u0104\t\2\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105" +
            "\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106T\3\2\2\2\u0107\u0108\7X\2\2\u0108" +
            "\u0109\7a\2\2\u0109V\3\2\2\2\u010a\u010c\t\6\2\2\u010b\u010a\3\2\2\2\u010c" +
            "\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2" +
            "\2\2\u010f\u0110\b,\3\2\u0110X\3\2\2\2\u0111\u0115\7%\2\2\u0112\u0114" +
            "\n\7\2\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115" +
            "\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119\5[" +
            ".\2\u0119\u011a\3\2\2\2\u011a\u011b\b-\4\2\u011bZ\3\2\2\2\u011c\u011e" +
            "\t\b\2\2\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f" +
            "\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\b.\4\2\u0122\\\3\2\2\2" +
            "\u0123\u0124\13\2\2\2\u0124^\3\2\2\2\r\2\177\u0087\u008a\u0090\u0096\u009c" +
            "\u0105\u010d\u0115\u011f\5\3\16\2\2\3\2\b\2\2";
    public static final ATN _ATN =
        new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}