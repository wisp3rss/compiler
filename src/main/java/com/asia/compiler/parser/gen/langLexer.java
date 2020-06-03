package com.asia.compiler.parser.gen;// Generated from /Users/annakonieczna/IdeaProjects/compiler/src/main/antlr4/lang.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, READ=2, PRINT=3, IF=4, THEN=5, ENDIF=6, REPEAT=7, ENDREPEAT=8, 
		FUNCTION=9, ENDFUNCTION=10, NEWLINE=11, ASSIGN=12, SEMI_COLON=13, INT=14, 
		FLOAT=15, STRING=16, PLUS=17, MINUS=18, DIV=19, MULT=20, MOD=21, DEF_INT=22, 
		DEF_FLOAT=23, DEF_STRING=24, NAME=25, NAME_PREFIX=26, BLANK=27, COMMENT=28, 
		NEXT_LINE=29, UNKNOWN_CHAR=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "READ", "PRINT", "IF", "THEN", "ENDIF", "REPEAT", "ENDREPEAT", 
			"FUNCTION", "ENDFUNCTION", "NEWLINE", "ASSIGN", "SEMI_COLON", "INT", 
			"FLOAT", "STRING", "PLUS", "MINUS", "DIV", "MULT", "MOD", "DEF_INT", 
			"DEF_FLOAT", "DEF_STRING", "NAME", "NAME_PREFIX", "BLANK", "COMMENT", 
			"NEXT_LINE", "UNKNOWN_CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'=='", "'READ'", "'PRINT'", "'IF'", "'THEN'", "'ENDIF'", "'REPEAT'", 
			"'ENDREPEAT'", "'FUNCTION'", "'ENDFUNCTION'", null, "'='", "';'", null, 
			null, null, "'+'", "'-'", "'/'", "'*'", "'%'", "'INT'", "'FLOAT'", "'STRING'", 
			null, "'V_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "READ", "PRINT", "IF", "THEN", "ENDIF", "REPEAT", "ENDREPEAT", 
			"FUNCTION", "ENDFUNCTION", "NEWLINE", "ASSIGN", "SEMI_COLON", "INT", 
			"FLOAT", "STRING", "PLUS", "MINUS", "DIV", "MULT", "MOD", "DEF_INT", 
			"DEF_FLOAT", "DEF_STRING", "NAME", "NAME_PREFIX", "BLANK", "COMMENT", 
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
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 14:
			FLOAT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void FLOAT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			1
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u00ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\5\f\u0083"+
		"\n\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\6\17\u008c\n\17\r\17\16\17\u008d\3"+
		"\20\3\20\3\20\3\20\7\20\u0094\n\20\f\20\16\20\u0097\13\20\5\20\u0099\n"+
		"\20\3\20\3\20\7\20\u009d\n\20\f\20\16\20\u00a0\13\20\3\20\6\20\u00a3\n"+
		"\20\r\20\16\20\u00a4\3\21\3\21\7\21\u00a9\n\21\f\21\16\21\u00ac\13\21"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\6\32\u00cd\n\32\r\32\16\32\u00ce\3\33\3\33\3\33\3\34\6"+
		"\34\u00d5\n\34\r\34\16\34\u00d6\3\34\3\34\3\35\3\35\7\35\u00dd\n\35\f"+
		"\35\16\35\u00e0\13\35\3\35\3\35\3\35\3\35\3\36\6\36\u00e7\n\36\r\36\16"+
		"\36\u00e8\3\36\3\36\3\37\3\37\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= \3\2\t\3\2\62;\3\2\62\62\3\2\63"+
		";\4\2$$^^\4\2\13\13\"\"\4\2\f\f\16\17\3\2\f\f\2\u00f8\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\3?\3\2\2\2\5B\3\2\2\2\7G\3\2\2\2\tM\3\2\2\2\13P\3\2\2\2\rU\3\2\2\2\17"+
		"[\3\2\2\2\21b\3\2\2\2\23l\3\2\2\2\25u\3\2\2\2\27\u0082\3\2\2\2\31\u0086"+
		"\3\2\2\2\33\u0088\3\2\2\2\35\u008b\3\2\2\2\37\u0098\3\2\2\2!\u00a6\3\2"+
		"\2\2#\u00af\3\2\2\2%\u00b1\3\2\2\2\'\u00b3\3\2\2\2)\u00b5\3\2\2\2+\u00b7"+
		"\3\2\2\2-\u00b9\3\2\2\2/\u00bd\3\2\2\2\61\u00c3\3\2\2\2\63\u00ca\3\2\2"+
		"\2\65\u00d0\3\2\2\2\67\u00d4\3\2\2\29\u00da\3\2\2\2;\u00e6\3\2\2\2=\u00ec"+
		"\3\2\2\2?@\7?\2\2@A\7?\2\2A\4\3\2\2\2BC\7T\2\2CD\7G\2\2DE\7C\2\2EF\7F"+
		"\2\2F\6\3\2\2\2GH\7R\2\2HI\7T\2\2IJ\7K\2\2JK\7P\2\2KL\7V\2\2L\b\3\2\2"+
		"\2MN\7K\2\2NO\7H\2\2O\n\3\2\2\2PQ\7V\2\2QR\7J\2\2RS\7G\2\2ST\7P\2\2T\f"+
		"\3\2\2\2UV\7G\2\2VW\7P\2\2WX\7F\2\2XY\7K\2\2YZ\7H\2\2Z\16\3\2\2\2[\\\7"+
		"T\2\2\\]\7G\2\2]^\7R\2\2^_\7G\2\2_`\7C\2\2`a\7V\2\2a\20\3\2\2\2bc\7G\2"+
		"\2cd\7P\2\2de\7F\2\2ef\7T\2\2fg\7G\2\2gh\7R\2\2hi\7G\2\2ij\7C\2\2jk\7"+
		"V\2\2k\22\3\2\2\2lm\7H\2\2mn\7W\2\2no\7P\2\2op\7E\2\2pq\7V\2\2qr\7K\2"+
		"\2rs\7Q\2\2st\7P\2\2t\24\3\2\2\2uv\7G\2\2vw\7P\2\2wx\7F\2\2xy\7H\2\2y"+
		"z\7W\2\2z{\7P\2\2{|\7E\2\2|}\7V\2\2}~\7K\2\2~\177\7Q\2\2\177\u0080\7P"+
		"\2\2\u0080\26\3\2\2\2\u0081\u0083\7\17\2\2\u0082\u0081\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\f\2\2\u0085\30\3\2\2\2\u0086"+
		"\u0087\7?\2\2\u0087\32\3\2\2\2\u0088\u0089\7=\2\2\u0089\34\3\2\2\2\u008a"+
		"\u008c\t\2\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\36\3\2\2\2\u008f\u0099\t\3\2\2\u0090\u0091"+
		"\t\4\2\2\u0091\u0095\b\20\2\2\u0092\u0094\t\2\2\2\u0093\u0092\3\2\2\2"+
		"\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0099"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u008f\3\2\2\2\u0098\u0090\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009e\13\2\2\2\u009b\u009d\t\2\2\2\u009c\u009b\3"+
		"\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a3\t\4\2\2\u00a2\u00a1\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		" \3\2\2\2\u00a6\u00aa\7$\2\2\u00a7\u00a9\n\5\2\2\u00a8\u00a7\3\2\2\2\u00a9"+
		"\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2"+
		"\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7$\2\2\u00ae\"\3\2\2\2\u00af\u00b0"+
		"\7-\2\2\u00b0$\3\2\2\2\u00b1\u00b2\7/\2\2\u00b2&\3\2\2\2\u00b3\u00b4\7"+
		"\61\2\2\u00b4(\3\2\2\2\u00b5\u00b6\7,\2\2\u00b6*\3\2\2\2\u00b7\u00b8\7"+
		"\'\2\2\u00b8,\3\2\2\2\u00b9\u00ba\7K\2\2\u00ba\u00bb\7P\2\2\u00bb\u00bc"+
		"\7V\2\2\u00bc.\3\2\2\2\u00bd\u00be\7H\2\2\u00be\u00bf\7N\2\2\u00bf\u00c0"+
		"\7Q\2\2\u00c0\u00c1\7C\2\2\u00c1\u00c2\7V\2\2\u00c2\60\3\2\2\2\u00c3\u00c4"+
		"\7U\2\2\u00c4\u00c5\7V\2\2\u00c5\u00c6\7T\2\2\u00c6\u00c7\7K\2\2\u00c7"+
		"\u00c8\7P\2\2\u00c8\u00c9\7I\2\2\u00c9\62\3\2\2\2\u00ca\u00cc\5\65\33"+
		"\2\u00cb\u00cd\t\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc"+
		"\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\64\3\2\2\2\u00d0\u00d1\7X\2\2\u00d1"+
		"\u00d2\7a\2\2\u00d2\66\3\2\2\2\u00d3\u00d5\t\6\2\2\u00d4\u00d3\3\2\2\2"+
		"\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8"+
		"\3\2\2\2\u00d8\u00d9\b\34\3\2\u00d98\3\2\2\2\u00da\u00de\7%\2\2\u00db"+
		"\u00dd\n\7\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2"+
		"\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1"+
		"\u00e2\5;\36\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\b\35\4\2\u00e4:\3\2\2\2"+
		"\u00e5\u00e7\t\b\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6"+
		"\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\b\36\4\2"+
		"\u00eb<\3\2\2\2\u00ec\u00ed\13\2\2\2\u00ed>\3\2\2\2\16\2\u0082\u008d\u0095"+
		"\u0098\u009e\u00a4\u00aa\u00ce\u00d6\u00de\u00e8\5\3\20\2\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}