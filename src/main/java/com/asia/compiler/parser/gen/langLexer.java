package com.asia.compiler.parser.gen;

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
		READ=1, PRINT=2, ASSIGN=3, SEMI_COLON=4, INT=5, FLOAT=6, STRING=7, PLUS=8, 
		MINUS=9, DIV=10, MULT=11, MOD=12, DEF_INT=13, DEF_FLOAT=14, DEF_STRING=15, 
		NAME=16, NAME_PREFIX=17, BLANK=18, NEXT_LINE=19, UNKNOWN_CHAR=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"READ", "PRINT", "ASSIGN", "SEMI_COLON", "INT", "FLOAT", "STRING", "PLUS", 
			"MINUS", "DIV", "MULT", "MOD", "DEF_INT", "DEF_FLOAT", "DEF_STRING", 
			"NAME", "NAME_PREFIX", "BLANK", "NEXT_LINE", "UNKNOWN_CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'READ'", "'PRINT'", "'='", "';'", null, null, null, "'+'", "'-'", 
			"'/'", "'*'", "'%'", "'INT'", "'FLOAT'", "'STRING'", null, "'V_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "READ", "PRINT", "ASSIGN", "SEMI_COLON", "INT", "FLOAT", "STRING", 
			"PLUS", "MINUS", "DIV", "MULT", "MOD", "DEF_INT", "DEF_FLOAT", "DEF_STRING", 
			"NAME", "NAME_PREFIX", "BLANK", "NEXT_LINE", "UNKNOWN_CHAR"
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
		case 5:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0091\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\6\6<\n\6\r\6\16\6=\3\7\3\7\3\7\3\7\7\7"+
		"D\n\7\f\7\16\7G\13\7\5\7I\n\7\3\7\3\7\7\7M\n\7\f\7\16\7P\13\7\3\7\6\7"+
		"S\n\7\r\7\16\7T\3\b\3\b\7\bY\n\b\f\b\16\b\\\13\b\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\6\21}\n\21\r\21"+
		"\16\21~\3\22\3\22\3\22\3\23\6\23\u0085\n\23\r\23\16\23\u0086\3\23\3\23"+
		"\3\24\6\24\u008c\n\24\r\24\16\24\u008d\3\25\3\25\2\2\26\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26\3\2\b\3\2\62;\3\2\62\62\3\2\63;\4\2$$^^\4\2\13\13\"\"\3"+
		"\2\f\f\2\u0099\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5\60\3"+
		"\2\2\2\7\66\3\2\2\2\t8\3\2\2\2\13;\3\2\2\2\rH\3\2\2\2\17V\3\2\2\2\21_"+
		"\3\2\2\2\23a\3\2\2\2\25c\3\2\2\2\27e\3\2\2\2\31g\3\2\2\2\33i\3\2\2\2\35"+
		"m\3\2\2\2\37s\3\2\2\2!z\3\2\2\2#\u0080\3\2\2\2%\u0084\3\2\2\2\'\u008b"+
		"\3\2\2\2)\u008f\3\2\2\2+,\7T\2\2,-\7G\2\2-.\7C\2\2./\7F\2\2/\4\3\2\2\2"+
		"\60\61\7R\2\2\61\62\7T\2\2\62\63\7K\2\2\63\64\7P\2\2\64\65\7V\2\2\65\6"+
		"\3\2\2\2\66\67\7?\2\2\67\b\3\2\2\289\7=\2\29\n\3\2\2\2:<\t\2\2\2;:\3\2"+
		"\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\f\3\2\2\2?I\t\3\2\2@A\t\4\2\2AE\b"+
		"\7\2\2BD\t\2\2\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FI\3\2\2\2GE\3"+
		"\2\2\2H?\3\2\2\2H@\3\2\2\2IJ\3\2\2\2JN\13\2\2\2KM\t\2\2\2LK\3\2\2\2MP"+
		"\3\2\2\2NL\3\2\2\2NO\3\2\2\2OR\3\2\2\2PN\3\2\2\2QS\t\4\2\2RQ\3\2\2\2S"+
		"T\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\16\3\2\2\2VZ\7$\2\2WY\n\5\2\2XW\3\2\2\2"+
		"Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7$\2\2^\20\3\2"+
		"\2\2_`\7-\2\2`\22\3\2\2\2ab\7/\2\2b\24\3\2\2\2cd\7\61\2\2d\26\3\2\2\2"+
		"ef\7,\2\2f\30\3\2\2\2gh\7\'\2\2h\32\3\2\2\2ij\7K\2\2jk\7P\2\2kl\7V\2\2"+
		"l\34\3\2\2\2mn\7H\2\2no\7N\2\2op\7Q\2\2pq\7C\2\2qr\7V\2\2r\36\3\2\2\2"+
		"st\7U\2\2tu\7V\2\2uv\7T\2\2vw\7K\2\2wx\7P\2\2xy\7I\2\2y \3\2\2\2z|\5#"+
		"\22\2{}\t\2\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\"\3\2\2"+
		"\2\u0080\u0081\7X\2\2\u0081\u0082\7a\2\2\u0082$\3\2\2\2\u0083\u0085\t"+
		"\6\2\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\b\23\3\2\u0089&\3\2\2\2"+
		"\u008a\u008c\t\7\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b"+
		"\3\2\2\2\u008d\u008e\3\2\2\2\u008e(\3\2\2\2\u008f\u0090\13\2\2\2\u0090"+
		"*\3\2\2\2\f\2=EHNTZ~\u0086\u008d\4\3\7\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}