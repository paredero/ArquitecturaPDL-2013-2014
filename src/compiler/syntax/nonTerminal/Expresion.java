package compiler.syntax.nonTerminal;

import compiler.semantic.type.TypeSimple;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Expresion extends NonTerminal {
	public static String SUMA = "+";
	public static String MAYOR = ">";
	public static String IGUAL = "=";
	public static String OR = "OR";
	
	private TypeIF type;
	private String lexema;
	/**
	 * @param type
	 * @param lexema
	 */
	public Expresion(TypeIF type, String lexema) {
		super();
		this.type = type;
		this.lexema = lexema;
	}
	/**
	 * @return the type
	 */
	public TypeIF getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(TypeIF type) {
		this.type = type;
	}
	/**
	 * @return the lexema
	 */
	public String getLexema() {
		return lexema;
	}
	/**
	 * @param lexema the lexema to set
	 */
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	/**
	 * 
	 */
	public Expresion() {
		super();
	}
	
	public static boolean tiposCompatibles(String operador,TypeIF t1,TypeIF t2) {
		boolean resultado = false;
		if (operador.equals(Expresion.SUMA)) {
			resultado = t1.getName().equals(TypeSimple.NUMERO)
					&& t2.getName().equals(TypeSimple.NUMERO); 
		} else if (operador.equals(Expresion.MAYOR)) {
			resultado = t1.getName().equals(TypeSimple.NUMERO)
					&& t2.getName().equals(TypeSimple.NUMERO);
		} else if (operador.equals(Expresion.IGUAL)) {
			resultado = t1.equals(t2);
		} else if (operador.equals(Expresion.OR)) {
			resultado = t1.getName().equals(TypeSimple.LOGICO)
					&& t2.getName().equals(TypeSimple.LOGICO);
		}	
		return resultado;
		
	}
}
