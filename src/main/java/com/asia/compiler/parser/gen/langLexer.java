package com.asia.compiler.parser.gen;// Generated from /Users/annakonieczna/IdeaProjects/compiler/src/main/antlr4/lang.g4 by ANTLR 4.8
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, READ=2, PRINT=3, IF=4, THEN=5, ENDIF=6, REPEAT=7, ENDREPEAT=8, 
		ASSIGN=9, SEMI_COLON=10, INT=11, FLOAT=12, STRING=13, PLUS=14, MINUS=15, 
		DIV=16, MULT=17, MOD=18, DEF_INT=19, DEF_FLOAT=20, DEF_STRING=21, NAME=22, 
		NAME_PREFIX=23, BLANK=24, COMMENT=25, NEXT_LINE=26, UNKNOWN_CHAR=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "READ", "PRINT", "IF", "THEN", "ENDIF", "REPEAT", "ENDREPEAT", 
			"ASSIGN", "SEMI_COLON", "INT", "FLOAT", "STRING", "PLUS", "MINUS", "DIV", 
			"MULT", "MOD", "DEF_INT", "DEF_FLOAT", "DEF_STRING", "NAME", "NAME_PREFIX", 
			"BLANK", "COMMENT", "NEXT_LINE", "UNKNOWN_CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'=='", "'READ'", "'PRINT'", "'IF'", "'THEN'", "'ENDIF'", "'REPEAT'", 
			"'ENDREPEAT'", "'='", "';'", null, null, null, "'+'", "'-'", "'/'", "'*'", 
			"'%'", "'INT'", "'FLOAT'", "'STRING'", null, "'V_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "READ", "PRINT", "IF", "THEN", "ENDIF", "REPEAT", "ENDREPEAT", 
			"ASSIGN", "SEMI_COLON", "INT", "FLOAT", "STRING", "PLUS", "MINUS", "DIV", 
			"MULT", "MOD", "DEF_INT", "DEF_FLOAT", "DEF_STRING", "NAME", "NAME_PREFIX", 
			"BLANK", "COMMENT", "NEXT_LINE", "UNKNOWN_CHAR"
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
		case 11:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00ce\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\6\fl\n\f\r\f\16\fm\3\r\3\r\3\r\3\r\7\rt\n"+
		"\r\f\r\16\rw\13\r\5\ry\n\r\3\r\3\r\7\r}\n\r\f\r\16\r\u0080\13\r\3\r\6"+
		"\r\u0083\n\r\r\r\16\r\u0084\3\16\3\16\7\16\u0089\n\16\f\16\16\16\u008c"+
		"\13\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\6\27\u00ad\n\27\r\27\16\27\u00ae\3\30\3\30\3\30\3"+
		"\31\6\31\u00b5\n\31\r\31\16\31\u00b6\3\31\3\31\3\32\3\32\7\32\u00bd\n"+
		"\32\f\32\16\32\u00c0\13\32\3\32\3\32\3\32\3\32\3\33\6\33\u00c7\n\33\r"+
		"\33\16\33\u00c8\3\33\3\33\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\35\3\2\t\3\2\62;\3\2\62\62\3\2\63;\4"+
		"\2$$^^\4\2\13\13\"\"\4\2\f\f\16\17\3\2\f\f\2\u00d7\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5<\3\2\2\2\7A\3\2\2\2\tG\3"+
		"\2\2\2\13J\3\2\2\2\rO\3\2\2\2\17U\3\2\2\2\21\\\3\2\2\2\23f\3\2\2\2\25"+
		"h\3\2\2\2\27k\3\2\2\2\31x\3\2\2\2\33\u0086\3\2\2\2\35\u008f\3\2\2\2\37"+
		"\u0091\3\2\2\2!\u0093\3\2\2\2#\u0095\3\2\2\2%\u0097\3\2\2\2\'\u0099\3"+
		"\2\2\2)\u009d\3\2\2\2+\u00a3\3\2\2\2-\u00aa\3\2\2\2/\u00b0\3\2\2\2\61"+
		"\u00b4\3\2\2\2\63\u00ba\3\2\2\2\65\u00c6\3\2\2\2\67\u00cc\3\2\2\29:\7"+
		"?\2\2:;\7?\2\2;\4\3\2\2\2<=\7T\2\2=>\7G\2\2>?\7C\2\2?@\7F\2\2@\6\3\2\2"+
		"\2AB\7R\2\2BC\7T\2\2CD\7K\2\2DE\7P\2\2EF\7V\2\2F\b\3\2\2\2GH\7K\2\2HI"+
		"\7H\2\2I\n\3\2\2\2JK\7V\2\2KL\7J\2\2LM\7G\2\2MN\7P\2\2N\f\3\2\2\2OP\7"+
		"G\2\2PQ\7P\2\2QR\7F\2\2RS\7K\2\2ST\7H\2\2T\16\3\2\2\2UV\7T\2\2VW\7G\2"+
		"\2WX\7R\2\2XY\7G\2\2YZ\7C\2\2Z[\7V\2\2[\20\3\2\2\2\\]\7G\2\2]^\7P\2\2"+
		"^_\7F\2\2_`\7T\2\2`a\7G\2\2ab\7R\2\2bc\7G\2\2cd\7C\2\2de\7V\2\2e\22\3"+
		"\2\2\2fg\7?\2\2g\24\3\2\2\2hi\7=\2\2i\26\3\2\2\2jl\t\2\2\2kj\3\2\2\2l"+
		"m\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\30\3\2\2\2oy\t\3\2\2pq\t\4\2\2qu\b\r\2"+
		"\2rt\t\2\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vy\3\2\2\2wu\3\2\2"+
		"\2xo\3\2\2\2xp\3\2\2\2yz\3\2\2\2z~\13\2\2\2{}\t\2\2\2|{\3\2\2\2}\u0080"+
		"\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0081"+
		"\u0083\t\4\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\32\3\2\2\2\u0086\u008a\7$\2\2\u0087\u0089"+
		"\n\5\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7$"+
		"\2\2\u008e\34\3\2\2\2\u008f\u0090\7-\2\2\u0090\36\3\2\2\2\u0091\u0092"+
		"\7/\2\2\u0092 \3\2\2\2\u0093\u0094\7\61\2\2\u0094\"\3\2\2\2\u0095\u0096"+
		"\7,\2\2\u0096$\3\2\2\2\u0097\u0098\7\'\2\2\u0098&\3\2\2\2\u0099\u009a"+
		"\7K\2\2\u009a\u009b\7P\2\2\u009b\u009c\7V\2\2\u009c(\3\2\2\2\u009d\u009e"+
		"\7H\2\2\u009e\u009f\7N\2\2\u009f\u00a0\7Q\2\2\u00a0\u00a1\7C\2\2\u00a1"+
		"\u00a2\7V\2\2\u00a2*\3\2\2\2\u00a3\u00a4\7U\2\2\u00a4\u00a5\7V\2\2\u00a5"+
		"\u00a6\7T\2\2\u00a6\u00a7\7K\2\2\u00a7\u00a8\7P\2\2\u00a8\u00a9\7I\2\2"+
		"\u00a9,\3\2\2\2\u00aa\u00ac\5/\30\2\u00ab\u00ad\t\2\2\2\u00ac\u00ab\3"+
		"\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		".\3\2\2\2\u00b0\u00b1\7X\2\2\u00b1\u00b2\7a\2\2\u00b2\60\3\2\2\2\u00b3"+
		"\u00b5\t\6\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\31\3\2\u00b9"+
		"\62\3\2\2\2\u00ba\u00be\7%\2\2\u00bb\u00bd\n\7\2\2\u00bc\u00bb\3\2\2\2"+
		"\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1"+
		"\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\5\65\33\2\u00c2\u00c3\3\2\2\2"+
		"\u00c3\u00c4\b\32\4\2\u00c4\64\3\2\2\2\u00c5\u00c7\t\b\2\2\u00c6\u00c5"+
		"\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\b\33\4\2\u00cb\66\3\2\2\2\u00cc\u00cd\13\2"+
		"\2\2\u00cd8\3\2\2\2\r\2mux~\u0084\u008a\u00ae\u00b6\u00be\u00c8\5\3\r"+
		"\2\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}