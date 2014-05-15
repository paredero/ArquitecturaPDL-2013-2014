package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Parametro extends NonTerminal {
	private TypeIF tipo;
	private String lexema;
	private Integer line;
	/**
	 * @param tipo
	 * @param lexema
	 * @param line
	 */
	public Parametro(TypeIF tipo, String lexema, Integer line) {
		super();
		this.tipo = tipo;
		this.lexema = lexema;
		this.line = line;
	}
	/**
	 * 
	 */
	public Parametro() {
		super();
		
	}
	/**
	 * @return the tipo
	 */
	public TypeIF getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
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
	 * @return the linea
	 */
	public Integer getLine() {
		return line;
	}
	/**
	 * @param line the linea to set
	 */
	public void setLine(Integer line) {
		this.line = line;
	}
	
}
