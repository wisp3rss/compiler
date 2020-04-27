package com.asia.compiler.parser.gen;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, READ=3, PRINT=4, ASSIGN=5, SEMI_COLON=6, INT=7, FLOAT=8, 
		PLUS=9, MINUS=10, DIV=11, MULT=12, MOD=13, DEF_INT=14, DEF_FLOAT=15, NAME=16, 
		NAME_PREFIX=17, BLANK=18, NEXT_LINE=19, UNKNOWN_CHAR=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "READ", "PRINT", "ASSIGN", "SEMI_COLON", "INT", "FLOAT", 
			"PLUS", "MINUS", "DIV", "MULT", "MOD", "DEF_INT", "DEF_FLOAT", "NAME", 
			"NAME_PREFIX", "BLANK", "NEXT_LINE", "UNKNOWN_CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'READ'", "'PRINT'", "'='", "';'", null, null, "'+'", 
			"'-'", "'/'", "'*'", "'%'", "'INT'", "'FLOAT'", null, "'V_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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
		case 7:
			FLOAT_action((RuleContext)_localctx, actionIndex);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0085\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\6\b@\n\b\r\b\16\bA\3\t"+
		"\3\t\3\t\3\t\7\tH\n\t\f\t\16\tK\13\t\5\tM\n\t\3\t\3\t\7\tQ\n\t\f\t\16"+
		"\tT\13\t\3\t\6\tW\n\t\r\t\16\tX\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\6\21"+
		"q\n\21\r\21\16\21r\3\22\3\22\3\22\3\23\6\23y\n\23\r\23\16\23z\3\23\3\23"+
		"\3\24\6\24\u0080\n\24\r\24\16\24\u0081\3\25\3\25\2\2\26\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26\3\2\7\3\2\62;\3\2\62\62\3\2\63;\4\2\13\13\"\"\3\2\f\f\2"+
		"\u008c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2\2\2\7"+
		"/\3\2\2\2\t\64\3\2\2\2\13:\3\2\2\2\r<\3\2\2\2\17?\3\2\2\2\21L\3\2\2\2"+
		"\23Z\3\2\2\2\25\\\3\2\2\2\27^\3\2\2\2\31`\3\2\2\2\33b\3\2\2\2\35d\3\2"+
		"\2\2\37h\3\2\2\2!n\3\2\2\2#t\3\2\2\2%x\3\2\2\2\'\177\3\2\2\2)\u0083\3"+
		"\2\2\2+,\7*\2\2,\4\3\2\2\2-.\7+\2\2.\6\3\2\2\2/\60\7T\2\2\60\61\7G\2\2"+
		"\61\62\7C\2\2\62\63\7F\2\2\63\b\3\2\2\2\64\65\7R\2\2\65\66\7T\2\2\66\67"+
		"\7K\2\2\678\7P\2\289\7V\2\29\n\3\2\2\2:;\7?\2\2;\f\3\2\2\2<=\7=\2\2=\16"+
		"\3\2\2\2>@\t\2\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\20\3\2\2\2"+
		"CM\t\3\2\2DE\t\4\2\2EI\b\t\2\2FH\t\2\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2"+
		"IJ\3\2\2\2JM\3\2\2\2KI\3\2\2\2LC\3\2\2\2LD\3\2\2\2MN\3\2\2\2NR\13\2\2"+
		"\2OQ\t\2\2\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SV\3\2\2\2TR\3\2\2"+
		"\2UW\t\4\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\22\3\2\2\2Z[\7-"+
		"\2\2[\24\3\2\2\2\\]\7/\2\2]\26\3\2\2\2^_\7\61\2\2_\30\3\2\2\2`a\7,\2\2"+
		"a\32\3\2\2\2bc\7\'\2\2c\34\3\2\2\2de\7K\2\2ef\7P\2\2fg\7V\2\2g\36\3\2"+
		"\2\2hi\7H\2\2ij\7N\2\2jk\7Q\2\2kl\7C\2\2lm\7V\2\2m \3\2\2\2np\5#\22\2"+
		"oq\t\2\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\"\3\2\2\2tu\7X\2\2"+
		"uv\7a\2\2v$\3\2\2\2wy\t\5\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2"+
		"{|\3\2\2\2|}\b\23\3\2}&\3\2\2\2~\u0080\t\6\2\2\177~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082(\3\2\2\2\u0083\u0084"+
		"\13\2\2\2\u0084*\3\2\2\2\13\2AILRXrz\u0081\4\3\t\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}