// Generated from java-escape by ANTLR 4.11.1

package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PrismLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, ID=14, INT=15, BOOL=16, FUNCTION=17, 
		CLASS=18, IF=19, ELSE=20, METHODS=21, ATTRIBUTES=22, RETURN=23, COMMENT=24, 
		WS=25, LCURLY=26, RCURLY=27, LPAREN=28, RPAREN=29, SEMICOLON=30, MUL=31, 
		DIV=32, ADD=33, SUB=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "ID", "INT", "BOOL", "FUNCTION", "CLASS", 
			"IF", "ELSE", "METHODS", "ATTRIBUTES", "RETURN", "COMMENT", "WS", "LCURLY", 
			"RCURLY", "LPAREN", "RPAREN", "SEMICOLON", "MUL", "DIV", "ADD", "SUB"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'INT'", "'BOOL'", "'VOID'", "','", "'!'", "'=='", "'||'", 
			"'&&'", "'>'", "'<'", "'>='", "'<='", null, null, null, "'FUNCTION'", 
			"'CLASS'", "'IF'", "'ELSE'", "'METHODS'", "'ATTRIBUTES'", "'RETURN'", 
			null, null, "'{'", "'}'", "'('", "')'", "';'", "'*'", "'/'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "ID", "INT", "BOOL", "FUNCTION", "CLASS", "IF", "ELSE", "METHODS", 
			"ATTRIBUTES", "RETURN", "COMMENT", "WS", "LCURLY", "RCURLY", "LPAREN", 
			"RPAREN", "SEMICOLON", "MUL", "DIV", "ADD", "SUB"
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


	public PrismLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Prism.g4"; }

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

	public static final String _serializedATN =
		"\u0004\u0000\"\u00e0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0005\ro\b\r\n\r\f\rr\t\r\u0001\u000e\u0001\u000e\u0003"+
		"\u000ev\b\u000e\u0001\u000e\u0001\u000e\u0005\u000ez\b\u000e\n\u000e\f"+
		"\u000e}\t\u000e\u0003\u000e\u007f\b\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u008a\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u00c1\b\u0017\n\u0017\f\u0017\u00c4\t\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0004\u0018\u00c9\b\u0018\u000b\u0018"+
		"\f\u0018\u00ca\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001!\u0001!\u0000\u0000\"\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d"+
		";\u001e=\u001f? A!C\"\u0001\u0000\u0006\u0001\u0000az\u0004\u000009AZ"+
		"__az\u0001\u000019\u0001\u000009\u0002\u0000\n\n\r\r\u0002\u0000\t\n "+
		" \u00e6\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000"+
		"\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000"+
		"\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003"+
		"\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000"+
		"\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000"+
		"\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A"+
		"\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0001E\u0001\u0000"+
		"\u0000\u0000\u0003G\u0001\u0000\u0000\u0000\u0005K\u0001\u0000\u0000\u0000"+
		"\u0007P\u0001\u0000\u0000\u0000\tU\u0001\u0000\u0000\u0000\u000bW\u0001"+
		"\u0000\u0000\u0000\rY\u0001\u0000\u0000\u0000\u000f\\\u0001\u0000\u0000"+
		"\u0000\u0011_\u0001\u0000\u0000\u0000\u0013b\u0001\u0000\u0000\u0000\u0015"+
		"d\u0001\u0000\u0000\u0000\u0017f\u0001\u0000\u0000\u0000\u0019i\u0001"+
		"\u0000\u0000\u0000\u001bl\u0001\u0000\u0000\u0000\u001d~\u0001\u0000\u0000"+
		"\u0000\u001f\u0089\u0001\u0000\u0000\u0000!\u008b\u0001\u0000\u0000\u0000"+
		"#\u0094\u0001\u0000\u0000\u0000%\u009a\u0001\u0000\u0000\u0000\'\u009d"+
		"\u0001\u0000\u0000\u0000)\u00a2\u0001\u0000\u0000\u0000+\u00aa\u0001\u0000"+
		"\u0000\u0000-\u00b5\u0001\u0000\u0000\u0000/\u00bc\u0001\u0000\u0000\u0000"+
		"1\u00c8\u0001\u0000\u0000\u00003\u00ce\u0001\u0000\u0000\u00005\u00d0"+
		"\u0001\u0000\u0000\u00007\u00d2\u0001\u0000\u0000\u00009\u00d4\u0001\u0000"+
		"\u0000\u0000;\u00d6\u0001\u0000\u0000\u0000=\u00d8\u0001\u0000\u0000\u0000"+
		"?\u00da\u0001\u0000\u0000\u0000A\u00dc\u0001\u0000\u0000\u0000C\u00de"+
		"\u0001\u0000\u0000\u0000EF\u0005=\u0000\u0000F\u0002\u0001\u0000\u0000"+
		"\u0000GH\u0005I\u0000\u0000HI\u0005N\u0000\u0000IJ\u0005T\u0000\u0000"+
		"J\u0004\u0001\u0000\u0000\u0000KL\u0005B\u0000\u0000LM\u0005O\u0000\u0000"+
		"MN\u0005O\u0000\u0000NO\u0005L\u0000\u0000O\u0006\u0001\u0000\u0000\u0000"+
		"PQ\u0005V\u0000\u0000QR\u0005O\u0000\u0000RS\u0005I\u0000\u0000ST\u0005"+
		"D\u0000\u0000T\b\u0001\u0000\u0000\u0000UV\u0005,\u0000\u0000V\n\u0001"+
		"\u0000\u0000\u0000WX\u0005!\u0000\u0000X\f\u0001\u0000\u0000\u0000YZ\u0005"+
		"=\u0000\u0000Z[\u0005=\u0000\u0000[\u000e\u0001\u0000\u0000\u0000\\]\u0005"+
		"|\u0000\u0000]^\u0005|\u0000\u0000^\u0010\u0001\u0000\u0000\u0000_`\u0005"+
		"&\u0000\u0000`a\u0005&\u0000\u0000a\u0012\u0001\u0000\u0000\u0000bc\u0005"+
		">\u0000\u0000c\u0014\u0001\u0000\u0000\u0000de\u0005<\u0000\u0000e\u0016"+
		"\u0001\u0000\u0000\u0000fg\u0005>\u0000\u0000gh\u0005=\u0000\u0000h\u0018"+
		"\u0001\u0000\u0000\u0000ij\u0005<\u0000\u0000jk\u0005=\u0000\u0000k\u001a"+
		"\u0001\u0000\u0000\u0000lp\u0007\u0000\u0000\u0000mo\u0007\u0001\u0000"+
		"\u0000nm\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000"+
		"\u0000\u0000pq\u0001\u0000\u0000\u0000q\u001c\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000s\u007f\u00050\u0000\u0000tv\u0005-\u0000\u0000"+
		"ut\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000w{\u0007\u0002\u0000\u0000xz\u0007\u0003\u0000\u0000yx\u0001\u0000"+
		"\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001"+
		"\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000"+
		"\u0000~s\u0001\u0000\u0000\u0000~u\u0001\u0000\u0000\u0000\u007f\u001e"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0005t\u0000\u0000\u0081\u0082\u0005"+
		"r\u0000\u0000\u0082\u0083\u0005u\u0000\u0000\u0083\u008a\u0005e\u0000"+
		"\u0000\u0084\u0085\u0005f\u0000\u0000\u0085\u0086\u0005a\u0000\u0000\u0086"+
		"\u0087\u0005l\u0000\u0000\u0087\u0088\u0005s\u0000\u0000\u0088\u008a\u0005"+
		"e\u0000\u0000\u0089\u0080\u0001\u0000\u0000\u0000\u0089\u0084\u0001\u0000"+
		"\u0000\u0000\u008a \u0001\u0000\u0000\u0000\u008b\u008c\u0005F\u0000\u0000"+
		"\u008c\u008d\u0005U\u0000\u0000\u008d\u008e\u0005N\u0000\u0000\u008e\u008f"+
		"\u0005C\u0000\u0000\u008f\u0090\u0005T\u0000\u0000\u0090\u0091\u0005I"+
		"\u0000\u0000\u0091\u0092\u0005O\u0000\u0000\u0092\u0093\u0005N\u0000\u0000"+
		"\u0093\"\u0001\u0000\u0000\u0000\u0094\u0095\u0005C\u0000\u0000\u0095"+
		"\u0096\u0005L\u0000\u0000\u0096\u0097\u0005A\u0000\u0000\u0097\u0098\u0005"+
		"S\u0000\u0000\u0098\u0099\u0005S\u0000\u0000\u0099$\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0005I\u0000\u0000\u009b\u009c\u0005F\u0000\u0000\u009c"+
		"&\u0001\u0000\u0000\u0000\u009d\u009e\u0005E\u0000\u0000\u009e\u009f\u0005"+
		"L\u0000\u0000\u009f\u00a0\u0005S\u0000\u0000\u00a0\u00a1\u0005E\u0000"+
		"\u0000\u00a1(\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005M\u0000\u0000\u00a3"+
		"\u00a4\u0005E\u0000\u0000\u00a4\u00a5\u0005T\u0000\u0000\u00a5\u00a6\u0005"+
		"H\u0000\u0000\u00a6\u00a7\u0005O\u0000\u0000\u00a7\u00a8\u0005D\u0000"+
		"\u0000\u00a8\u00a9\u0005S\u0000\u0000\u00a9*\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0005A\u0000\u0000\u00ab\u00ac\u0005T\u0000\u0000\u00ac\u00ad\u0005"+
		"T\u0000\u0000\u00ad\u00ae\u0005R\u0000\u0000\u00ae\u00af\u0005I\u0000"+
		"\u0000\u00af\u00b0\u0005B\u0000\u0000\u00b0\u00b1\u0005U\u0000\u0000\u00b1"+
		"\u00b2\u0005T\u0000\u0000\u00b2\u00b3\u0005E\u0000\u0000\u00b3\u00b4\u0005"+
		"S\u0000\u0000\u00b4,\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005R\u0000"+
		"\u0000\u00b6\u00b7\u0005E\u0000\u0000\u00b7\u00b8\u0005T\u0000\u0000\u00b8"+
		"\u00b9\u0005U\u0000\u0000\u00b9\u00ba\u0005R\u0000\u0000\u00ba\u00bb\u0005"+
		"N\u0000\u0000\u00bb.\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005/\u0000"+
		"\u0000\u00bd\u00be\u0005/\u0000\u0000\u00be\u00c2\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c1\b\u0004\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c6\u0006\u0017\u0000\u0000\u00c6"+
		"0\u0001\u0000\u0000\u0000\u00c7\u00c9\u0007\u0005\u0000\u0000\u00c8\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00c8"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cc"+
		"\u0001\u0000\u0000\u0000\u00cc\u00cd\u0006\u0018\u0000\u0000\u00cd2\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0005{\u0000\u0000\u00cf4\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d1\u0005}\u0000\u0000\u00d16\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0005(\u0000\u0000\u00d38\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005"+
		")\u0000\u0000\u00d5:\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005;\u0000"+
		"\u0000\u00d7<\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005*\u0000\u0000\u00d9"+
		">\u0001\u0000\u0000\u0000\u00da\u00db\u0005/\u0000\u0000\u00db@\u0001"+
		"\u0000\u0000\u0000\u00dc\u00dd\u0005+\u0000\u0000\u00ddB\u0001\u0000\u0000"+
		"\u0000\u00de\u00df\u0005-\u0000\u0000\u00dfD\u0001\u0000\u0000\u0000\b"+
		"\u0000pu{~\u0089\u00c2\u00ca\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}