/* The following code was generated by JFlex 1.4.1 on 8/07/14 21:16 */

package compiler.lexical;

import compiler.syntax.sym;
import compiler.lexical.Token;
import es.uned.lsi.compiler.lexical.ScannerIF;
import es.uned.lsi.compiler.lexical.LexicalError;
import es.uned.lsi.compiler.lexical.LexicalErrorManager;

// incluir aqui, si es necesario otras importaciones


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 8/07/14 21:16 from the specification file
 * <tt>C:/Users/jgarcia/git/ArquitecturaPDL-2013-2014/doc/specs/scanner.flex</tt>
 */
public class Scanner implements java_cup.runtime.Scanner, ScannerIF {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  4,  4, 39,  0,  4, 40,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     4,  0,  3,  0,  0,  0,  0,  0, 34, 35,  0, 29, 36, 38, 33,  0, 
     2,  2,  2,  2,  2,  2,  2,  2,  2,  2, 32, 37,  0, 31, 30,  0, 
     0,  1, 10,  1,  1,  1, 18,  1,  1, 22,  1,  1,  1,  1,  1,  1, 
    24,  1,  1,  1, 27,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0, 25, 
     0, 13,  5, 14, 17,  6, 19,  7, 26,  8,  1,  1, 12,  1,  9, 11, 
    23,  1, 20, 15, 16, 21,  1,  1,  1, 28,  1,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\17\2\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\1\1\0\1\16\3\2\1\17\1\20\1\21\1\2"+
    "\1\22\14\2\1\23\1\24\1\0\1\2\1\25\7\2"+
    "\1\26\7\2\1\0\1\2\1\27\1\2\1\30\1\2"+
    "\1\31\1\32\6\2\1\0\1\33\1\34\1\35\2\2"+
    "\1\36\5\2\1\0\3\2\1\37\1\40\2\2\1\0"+
    "\1\41\2\2\1\42\1\2\1\0\1\43\1\44\1\2"+
    "\1\45\1\46";

  private static int [] zzUnpackAction() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\51\0\122\0\173\0\244\0\315\0\366\0\u011f"+
    "\0\u0148\0\u0171\0\u019a\0\u01c3\0\u01ec\0\u0215\0\u023e\0\u0267"+
    "\0\u0290\0\u02b9\0\u02e2\0\u030b\0\u0334\0\51\0\51\0\51"+
    "\0\u035d\0\u0386\0\51\0\51\0\51\0\51\0\u03af\0\244"+
    "\0\51\0\u03d8\0\u0401\0\u042a\0\122\0\122\0\122\0\u0453"+
    "\0\122\0\u047c\0\u04a5\0\u04ce\0\u04f7\0\u0520\0\u0549\0\u0572"+
    "\0\u059b\0\u05c4\0\u05ed\0\u0616\0\u063f\0\51\0\51\0\u0668"+
    "\0\u0691\0\122\0\u06ba\0\u06e3\0\u070c\0\u0735\0\u075e\0\u0787"+
    "\0\u07b0\0\122\0\u07d9\0\u0802\0\u082b\0\u0854\0\u087d\0\u08a6"+
    "\0\u08cf\0\u08f8\0\u0921\0\122\0\u094a\0\122\0\u0973\0\122"+
    "\0\122\0\u099c\0\u09c5\0\u09ee\0\u0a17\0\u0a40\0\u0a69\0\u0a92"+
    "\0\122\0\51\0\122\0\u0abb\0\u0ae4\0\122\0\u0b0d\0\u0b36"+
    "\0\u0b5f\0\u0b88\0\u0bb1\0\u0bda\0\u0c03\0\u0c2c\0\u0c55\0\122"+
    "\0\122\0\u0c7e\0\u0ca7\0\u0cd0\0\122\0\u0cf9\0\u0d22\0\122"+
    "\0\u0d4b\0\u0d74\0\122\0\122\0\u0d9d\0\51\0\122";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\3"+
    "\1\11\1\3\1\12\1\13\1\14\1\3\1\15\1\3"+
    "\1\16\1\3\1\17\1\20\1\21\1\3\1\22\1\23"+
    "\1\24\1\2\1\3\1\25\1\3\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\2\6"+
    "\52\0\2\3\2\0\24\3\1\0\3\3\16\0\1\4"+
    "\46\0\3\40\1\41\45\40\4\0\1\6\42\0\2\6"+
    "\1\0\2\3\2\0\1\3\1\42\22\3\1\0\3\3"+
    "\15\0\2\3\2\0\4\3\1\43\2\3\1\44\14\3"+
    "\1\0\3\3\15\0\2\3\2\0\4\3\1\45\5\3"+
    "\1\46\3\3\1\47\5\3\1\0\3\3\15\0\2\3"+
    "\2\0\6\3\1\50\15\3\1\0\3\3\15\0\2\3"+
    "\2\0\17\3\1\51\4\3\1\0\3\3\15\0\2\3"+
    "\2\0\6\3\1\52\15\3\1\0\3\3\15\0\2\3"+
    "\2\0\6\3\1\53\15\3\1\0\3\3\15\0\2\3"+
    "\2\0\24\3\1\0\1\54\1\3\1\55\15\0\2\3"+
    "\2\0\10\3\1\56\13\3\1\0\3\3\15\0\2\3"+
    "\2\0\6\3\1\57\11\3\1\60\3\3\1\0\3\3"+
    "\15\0\2\3\2\0\1\3\1\61\22\3\1\0\3\3"+
    "\15\0\2\3\2\0\4\3\1\62\17\3\1\0\3\3"+
    "\15\0\2\3\2\0\17\3\1\63\4\3\1\0\3\3"+
    "\15\0\2\3\2\0\20\3\1\64\3\3\1\0\3\3"+
    "\15\0\2\3\2\0\17\3\1\65\4\3\1\0\3\3"+
    "\53\0\1\66\52\0\1\67\55\0\1\70\3\0\2\3"+
    "\2\0\2\3\1\71\21\3\1\0\3\3\15\0\2\3"+
    "\2\0\14\3\1\72\7\3\1\0\3\3\15\0\2\3"+
    "\2\0\12\3\1\73\11\3\1\0\3\3\15\0\2\3"+
    "\2\0\6\3\1\74\15\3\1\0\3\3\15\0\2\3"+
    "\2\0\6\3\1\75\15\3\1\0\3\3\15\0\2\3"+
    "\2\0\4\3\1\76\17\3\1\0\3\3\15\0\2\3"+
    "\2\0\1\3\1\77\22\3\1\0\3\3\15\0\2\3"+
    "\2\0\22\3\1\100\1\3\1\0\3\3\15\0\2\3"+
    "\2\0\7\3\1\101\14\3\1\0\3\3\15\0\2\3"+
    "\2\0\17\3\1\102\4\3\1\0\3\3\15\0\2\3"+
    "\2\0\4\3\1\103\17\3\1\0\3\3\15\0\2\3"+
    "\2\0\11\3\1\104\1\3\1\105\10\3\1\0\3\3"+
    "\15\0\2\3\2\0\13\3\1\106\10\3\1\0\3\3"+
    "\15\0\2\3\2\0\6\3\1\107\15\3\1\0\3\3"+
    "\15\0\2\3\2\0\13\3\1\110\10\3\1\0\3\3"+
    "\15\0\2\3\2\0\20\3\1\111\3\3\1\0\3\3"+
    "\14\0\47\70\1\0\1\112\1\0\2\3\2\0\3\3"+
    "\1\113\20\3\1\0\3\3\15\0\2\3\2\0\1\3"+
    "\1\114\22\3\1\0\3\3\15\0\2\3\2\0\7\3"+
    "\1\115\14\3\1\0\3\3\15\0\2\3\2\0\22\3"+
    "\1\116\1\3\1\0\3\3\15\0\2\3\2\0\12\3"+
    "\1\117\11\3\1\0\3\3\15\0\2\3\2\0\4\3"+
    "\1\120\17\3\1\0\3\3\15\0\2\3\2\0\1\3"+
    "\1\121\22\3\1\0\3\3\15\0\2\3\2\0\12\3"+
    "\1\122\11\3\1\0\3\3\15\0\2\3\2\0\11\3"+
    "\1\123\12\3\1\0\3\3\15\0\2\3\2\0\6\3"+
    "\1\124\15\3\1\0\3\3\15\0\2\3\2\0\20\3"+
    "\1\125\3\3\1\0\3\3\15\0\2\3\2\0\1\3"+
    "\1\126\22\3\1\0\3\3\15\0\2\3\2\0\11\3"+
    "\1\127\12\3\1\0\3\3\15\0\2\3\2\0\24\3"+
    "\1\130\3\3\15\0\2\3\2\0\1\3\1\131\22\3"+
    "\1\0\3\3\14\0\47\70\1\132\1\112\1\0\2\3"+
    "\2\0\4\3\1\133\17\3\1\0\3\3\15\0\2\3"+
    "\2\0\1\3\1\134\22\3\1\0\3\3\15\0\2\3"+
    "\2\0\13\3\1\135\10\3\1\0\3\3\15\0\2\3"+
    "\2\0\1\3\1\136\22\3\1\0\3\3\15\0\2\3"+
    "\2\0\13\3\1\137\10\3\1\0\3\3\15\0\2\3"+
    "\2\0\17\3\1\140\4\3\1\0\3\3\15\0\2\3"+
    "\2\0\17\3\1\141\4\3\1\0\3\3\15\0\2\3"+
    "\2\0\2\3\1\142\21\3\1\0\3\3\15\0\2\3"+
    "\2\0\1\3\1\143\22\3\1\0\3\3\30\0\1\144"+
    "\35\0\2\3\2\0\10\3\1\145\13\3\1\0\3\3"+
    "\15\0\2\3\2\0\10\3\1\146\13\3\1\0\3\3"+
    "\15\0\2\3\2\0\3\3\1\147\20\3\1\0\3\3"+
    "\15\0\2\3\2\0\14\3\1\150\7\3\1\0\3\3"+
    "\15\0\2\3\2\0\4\3\1\151\17\3\1\0\3\3"+
    "\15\0\2\3\2\0\1\3\1\152\22\3\1\0\3\3"+
    "\15\0\2\3\2\0\14\3\1\153\7\3\1\0\3\3"+
    "\24\0\1\154\41\0\2\3\2\0\4\3\1\155\17\3"+
    "\1\0\3\3\15\0\2\3\2\0\4\3\1\156\17\3"+
    "\1\0\3\3\15\0\2\3\2\0\6\3\1\157\15\3"+
    "\1\0\3\3\15\0\2\3\2\0\17\3\1\160\4\3"+
    "\1\0\3\3\15\0\2\3\2\0\20\3\1\161\3\3"+
    "\1\0\3\3\25\0\1\162\40\0\2\3\2\0\13\3"+
    "\1\163\10\3\1\0\3\3\15\0\2\3\2\0\4\3"+
    "\1\164\17\3\1\0\3\3\15\0\2\3\2\0\17\3"+
    "\1\165\4\3\1\0\3\3\22\0\1\166\43\0\2\3"+
    "\2\0\1\3\1\167\22\3\1\0\3\3\14\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3526];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\23\1\3\11\2\1\4\11\1\1\1\0"+
    "\1\11\24\1\2\11\1\0\21\1\1\0\15\1\1\0"+
    "\1\1\1\11\11\1\1\0\7\1\1\0\5\1\1\0"+
    "\3\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[119];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  LexicalErrorManager lexicalErrorManager = new LexicalErrorManager ();
  private int commentCount = 0;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) throws LexicalError {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new LexicalError(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  throws LexicalError {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException, LexicalError {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 20: 
          { Token token = new Token (sym.DELIMITADOR_RANGO);
           token.setLine (yyline + 1);
           token.setColumn (yycolumn + 1);
           token.setLexema (yytext ());
           return token;
          }
        case 39: break;
        case 13: 
          { Token token = new Token (sym.PUNTO_COMA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 40: break;
        case 18: 
          { Token token = new Token (sym.OR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 41: break;
        case 22: 
          { Token token = new Token (sym.FOR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 42: break;
        case 38: 
          { Token token = new Token (sym.PROCEDURE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 43: break;
        case 29: 
          { Token token = new Token (sym.BEGIN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 44: break;
        case 15: 
          { Token token = new Token (sym.IN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 45: break;
        case 1: 
          { LexicalError error = new LexicalError ();
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
          }
        case 46: break;
        case 17: 
          { Token token = new Token (sym.IF);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 47: break;
        case 33: 
          { Token token = new Token (sym.BOOLEAN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 48: break;
        case 11: 
          { Token token = new Token (sym.CIERRA_PARENTESIS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 49: break;
        case 12: 
          { Token token = new Token (sym.SEPARADOR_COMA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 50: break;
        case 8: 
          { Token token = new Token (sym.DOS_PUNTOS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 51: break;
        case 19: 
          { Token token = new Token (sym.ASIGNACION);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 52: break;
        case 27: 
          { Token token = new Token (sym.TRUE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 53: break;
        case 10: 
          { Token token = new Token (sym.ABRE_PARENTESIS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 54: break;
        case 31: 
          { Token token = new Token (sym.RECORD);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 55: break;
        case 28: 
          { //            Token token = new Token (sym.COMENTARIO);
//            token.setLine (yyline + 1);
//            token.setColumn (yycolumn + 1);
//            token.setLexema (yytext ());
            //****************return token;
          }
        case 56: break;
        case 6: 
          { Token token = new Token (sym.MAYOR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 57: break;
        case 34: 
          { Token token = new Token (sym.INTEGER);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 58: break;
        case 7: 
          { Token token = new Token (sym.IGUAL);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 59: break;
        case 23: 
          { Token token = new Token (sym.ELSE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 60: break;
        case 26: 
          { Token token = new Token (sym.TYPE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 61: break;
        case 32: 
          { Token token = new Token (sym.RETURN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 62: break;
        case 21: 
          { Token token = new Token (sym.END);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 63: break;
        case 25: 
          { Token token = new Token (sym.THEN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 64: break;
        case 35: 
          { Token token = new Token (sym.CONSTANT);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 65: break;
        case 24: 
          { Token token = new Token (sym.LOOP);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 66: break;
        case 2: 
          { Token token = new Token (sym.IDENTIFICADOR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 67: break;
        case 37: 
          { Token token = new Token (sym.PUT_LINE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 68: break;
        case 14: 
          { Token token = new Token (sym.CADENA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 69: break;
        case 16: 
          { Token token = new Token (sym.IS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 70: break;
        case 9: 
          { Token token = new Token (sym.ACCESO);
           token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 71: break;
        case 5: 
          { Token token = new Token (sym.PLUS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 72: break;
        case 3: 
          { Token token = new Token (sym.NUMERO);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 73: break;
        case 30: 
          { Token token = new Token (sym.FALSE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 74: break;
        case 36: 
          { Token token = new Token (sym.FUNCTION);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
          }
        case 75: break;
        case 4: 
          { 
          }
        case 76: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
