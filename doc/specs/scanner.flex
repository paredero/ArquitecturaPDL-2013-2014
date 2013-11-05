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

//Macros
LETRA = [A-Za-z]
DIGITO = [0-9]

// incluir aqui, si es necesario otras directivas

%{
  LexicalErrorManager lexicalErrorManager = new LexicalErrorManager ();
  private int commentCount = 0;
%}  
  
%%

<YYINITIAL> 
{
           			       
    "+"                {  
                           Token token = new Token (sym.PLUS);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext () + " *PLUS*");
           			       return token;
                        }
    // incluir aqui el resto de las reglas patron - accion                        
                        
                       
    // operadores relacionales

    ">"                {  
                           Token token = new Token (sym.MAYOR);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext () + " *MAYOR*");
                           return token;
                        }  
                        
    "="                {  
                           Token token = new Token (sym.IGUAL);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext () + " *IGUAL*" );
                           return token;
                        } 
                        
    // Operadores logicos
    "or" {  
        Token token = new Token (sym.OR);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + " *OR*");
        return token;
    }
    
    //Operadores de asignacion
    ":=" {  
        Token token = new Token (sym.ASIGNACION);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*ASIGNACION*");
        return token;
    }
                        
    // Operadores de acceso
    "." {  
        Token token = new Token (sym.ACCESO);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + " *ACCESO*");
        return token;
    }                                                                                            
         
    // Constantes literales                         
    {DIGITO}+ {  
        Token token = new Token (sym.LITERAL_ENTERO);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + " *LITERAL_ENTERO*");
        return token;
    } 
    
    "True"|"False" {
        Token token = new Token (sym.LITERAL_LOGICO);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + " *LITERAL_LOGICO*");
        return token;
    }
    
    \".*\" {
        Token token = new Token (sym.CADENA);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + " *CADENA*");
        return token;
    }
    
// Palabras reservadas
    "for" {  
        Token token = new Token (sym.FOR);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*FOR*");
        return token;
    }    
    
    "function" {  
        Token token = new Token (sym.FUNCTION);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*FUNCTION*");
        return token;
    }
    
    "if" {  
        Token token = new Token (sym.IF);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*IF*");
        return token;
    }
    
    "in" {  
        Token token = new Token (sym.IN);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*IN*");
        return token;
    }
    
    "Integer" {  
        Token token = new Token (sym.INTEGER);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*INTEGER*");
        return token;
    }
    
    "is" {  
        Token token = new Token (sym.IS);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*IS*");
        return token;
    }
    
    "loop" {  
        Token token = new Token (sym.LOOP);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*LOOP*");
        return token;
    }
    
    "of" {  
        Token token = new Token (sym.OF);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*OF*");
        return token;
    }
    
    "procedure" {  
        Token token = new Token (sym.PROCEDURE);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*PROCEDURE*");
        return token;
    }
    
    "Put_line" {  
        Token token = new Token (sym.PUT_LINE);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*PUT_LINE*");
        return token;
    }
    
    "record" {  
        Token token = new Token (sym.RECORD);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*RECORD*");
        return token;
    }
    
    "return" {  
        Token token = new Token (sym.RETURN);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*RETURN*");
        return token;
    }
    
    "then" {  
        Token token = new Token (sym.THEN);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*THEN*");
        return token;
    }
    
    "type" {  
        Token token = new Token (sym.TYPE);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + "*TYPE*");
        return token;
    }
    
    // Identificadores    
    {LETRA}({LETRA}|{DIGITO})* {
        Token token = new Token (sym.IDENTIFICADOR);
        token.setLine (yyline + 1);
        token.setColumn (yycolumn + 1);
        token.setLexema (yytext () + " *IDENTIFICADOR*");
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


                         


