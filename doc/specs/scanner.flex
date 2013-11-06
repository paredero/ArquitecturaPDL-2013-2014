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
            token.setLexema (yytext () + "***PALABRA RESERVADA: begin***");
            return token;
        }
        
    Boolean {
            Token token = new Token (sym.BOOLEAN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: Boolean***");
            return token;
        }
        
    constant {
            Token token = new Token (sym.CONSTANT);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: constant***");
            return token;
        }
        
    else {
            Token token = new Token (sym.ELSE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: else***");
            return token;
        }
        
    end {
            Token token = new Token (sym.END);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: end***");
            return token;
        }
        
    False {
            Token token = new Token (sym.FALSE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: False***");
            return token;
        }
        
    for {
            Token token = new Token (sym.FOR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: for***");
            return token;
        }
        
    function {
            Token token = new Token (sym.FUNCTION);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: function***");
            return token;
        }
        
    if {
            Token token = new Token (sym.IF);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: if***");
            return token;
        }
        
    in {
            Token token = new Token (sym.IN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: in***");
            return token;
        }
        
    Integer {
            Token token = new Token (sym.INTEGER);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: Integer***");
            return token;
        }
        
    is {
            Token token = new Token (sym.IS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: is***");
            return token;
        }
        
    loop {
            Token token = new Token (sym.LOOP);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: loop***");
            return token;
        }
        
    or {
            Token token = new Token (sym.OR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: or***");
            return token;
        }
        
    procedure {
            Token token = new Token (sym.PROCEDURE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: procedure***");
            return token;
        }
        
    Put_line {
            Token token = new Token (sym.PUT_LINE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: Put_line***");
            return token;
        }
        
    record {
            Token token = new Token (sym.RECORD);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: record***");
            return token;
        }
        
    return {
            Token token = new Token (sym.RETURN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: return***");
            return token;
        }
        
    then {
            Token token = new Token (sym.THEN);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: then***");
            return token;
        }
        
    True {
            Token token = new Token (sym.TRUE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: True***");
            return token;
        }
        
    type {
            Token token = new Token (sym.TYPE);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***PALABRA RESERVADA: type***");
            return token;
        }
        
// Operadores        
    "+" {  
            Token token = new Token (sym.PLUS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***OPERADOR MAS***");
            return token;
        }
           
    ">" {
            Token token = new Token (sym.MAYOR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***OPERADOR MAYOR***");
            return token;
        }
        
    "=" {
            Token token = new Token (sym.IGUAL);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***OPERADOR IGUAL***");
            return token;
        }
        
    ":=" {
            Token token = new Token (sym.ASIGNACION);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***OPERADOR ASIGNACION***");
            return token;
        }
        
    "." {
            Token token = new Token (sym.ACCESO);
           token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***OPERADOR ACCESO***");
            return token;
        }

// Delimitadores
        
    "\"" {
            Token token = new Token (sym.COMILLA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***DELIMITADOR COMILLA***");
            return token;
        }
                                      
    "\(" {
            Token token = new Token (sym.ABRE_PARENTESIS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***DELIMITADOR ABRE PARENTESIS***");
            return token;
        }

    "\)" {
            Token token = new Token (sym.CIERRA_PARENTESIS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***DELIMITADOR CIERRA PARENTESIS***");
            return token;
        }

   "\.\." {
           Token token = new Token (sym.DELIMITADOR_RANGO);
           token.setLine (yyline + 1);
           token.setColumn (yycolumn + 1);
           token.setLexema (yytext () + "***DELIMITADOR RANGO***");
           return token;
        }

    \n|\r|\r\n {
            Token token = new Token (sym.SALTO_LINEA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***DELIMITADOR SALTO LINEA***");
            return token;
        }
        
    \t {
            Token token = new Token (sym.TABULADOR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***DELIMITADOR TABULADOR***");
            return token;
        }        
        
    " " {
            Token token = new Token (sym.ESPACIO);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***DELIMITADOR ESPACIO***");
            return token;
        }        

    "," {
            Token token = new Token (sym.SEPARADOR_COMA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***DELIMITADOR COMA***");
            return token;
        }

    ";" {
            Token token = new Token (sym.PUNTO_COMA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***DELIMITADOR PUNTO Y COMA***");
            return token;
        }

    ":" {
            Token token = new Token (sym.DOS_PUNTOS);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***DELIMITADOR DOS PUNTOS***");
            return token;
        }

// Otros        

    {NUMERO} {
            Token token = new Token (sym.NUMERO);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***NUMERO***");
            return token;
        }
  
    {IDENTIFICADOR} {
            Token token = new Token (sym.IDENTIFICADOR);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***IDENTIFICADOR***");
            return token;
    }
    
    "--".*\r\n {
            Token token = new Token (sym.COMENTARIO);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***COMENTARIO***");
            return token;
    }
    
    \"{CONTENIDO_CADENA}\" {
            Token token = new Token (sym.CADENA);
            token.setLine (yyline + 1);
            token.setColumn (yycolumn + 1);
            token.setLexema (yytext () + "***CADENA***");
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


                         


