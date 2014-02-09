package compiler.lexical;

import compiler.syntax.sym;
import compiler.lexical.Token;
import es.uned.lsi.compiler.lexical.ScannerIF;
import es.uned.lsi.compiler.lexical.LexicalError;
import es.uned.lsi.compiler.lexical.LexicalErrorManager;

// incluir aqui, si es necesario otras importaciones

%%
 
%public
%class Scanner
%char
%line
%column
%cup

%implements ScannerIF
%scanerror LexicalError

// incluir aqui, si es necesario otras directivas

LETRA = [A-Za-z]
DIGITO = [0-9]
NUMERO = {DIGITO}+
IDENTIFICADOR = {LETRA}({LETRA}|{DIGITO})*
CONTENIDO_CADENA = [^\"]* 
ESPACIO=([\ \t\b\r\n\f])+

%{
  LexicalErrorManager lexicalErrorManager = new LexicalErrorManager ();
  private int commentCount = 0;
%}  
  
%%

<YYINITIAL> 
{

// Palabras reservadas
    begin {
            Token token = new Token (sym.BEGIN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    Boolean {
            Token token = new Token (sym.BOOLEAN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    constant {
            Token token = new Token (sym.CONSTANT);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    else {
            Token token = new Token (sym.ELSE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    end {
            Token token = new Token (sym.END);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    False {
            Token token = new Token (sym.FALSE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    for {
            Token token = new Token (sym.FOR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    function {
            Token token = new Token (sym.FUNCTION);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    if {
            Token token = new Token (sym.IF);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    in {
            Token token = new Token (sym.IN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    Integer {
            Token token = new Token (sym.INTEGER);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    is {
            Token token = new Token (sym.IS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    loop {
            Token token = new Token (sym.LOOP);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    or {
            Token token = new Token (sym.OR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    procedure {
            Token token = new Token (sym.PROCEDURE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    Put_line {
            Token token = new Token (sym.PUT_LINE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    record {
            Token token = new Token (sym.RECORD);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    return {
            Token token = new Token (sym.RETURN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    then {
            Token token = new Token (sym.THEN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    True {
            Token token = new Token (sym.TRUE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    type {
            Token token = new Token (sym.TYPE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
// Operadores        
    "+" {  
            Token token = new Token (sym.PLUS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
           
    ">" {
            Token token = new Token (sym.MAYOR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    "=" {
            Token token = new Token (sym.IGUAL);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    ":=" {
            Token token = new Token (sym.ASIGNACION);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
        
    "." {
            Token token = new Token (sym.ACCESO);
           token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }

// Delimitadores
        
    "\"" {
            Token token = new Token (sym.COMILLA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
                                      
    "\(" {
            Token token = new Token (sym.ABRE_PARENTESIS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }

    "\)" {
            Token token = new Token (sym.CIERRA_PARENTESIS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }

   "\.\." {
           Token token = new Token (sym.DELIMITADOR_RANGO);
           token.setLine (yyline + 1);
           token.setColumn (yycolumn + 1);
           token.setLexema (yytext ());
           return token;
        }

  {ESPACIO}        {}   

    "," {
            Token token = new Token (sym.SEPARADOR_COMA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }

    ";" {
            Token token = new Token (sym.PUNTO_COMA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }

    ":" {
            Token token = new Token (sym.DOS_PUNTOS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }

// Otros        

    {NUMERO} {
            Token token = new Token (sym.NUMERO);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
        }
  
    {IDENTIFICADOR} {
            Token token = new Token (sym.IDENTIFICADOR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
    }
    
    "--".*\r\n {
//            Token token = new Token (sym.COMENTARIO);
//            token.setLine (yyline + 1);
//            token.setColumn (yycolumn + 1);
//            token.setLexema (yytext ());
            //****************return token;
    }
    
    \"{CONTENIDO_CADENA }\" {
            Token token = new Token (sym.CADENA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext ());
            return token;
    }       
      
    // error en caso de coincidir con ningún patrón
    [^]     
                        {                                               
                           LexicalError error = new LexicalError ();
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
                        }
    
}


                         


