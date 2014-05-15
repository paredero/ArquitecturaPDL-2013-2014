package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Parametro extends NonTerminal {
	private TypeIF type;
	private String lexema;
	private Integer line;
	/**
	 * @param type
	 * @param lexema
	 * @param line
	 */
	public Parametro(TypeIF type, String lexema, Integer line) {
		super();
		this.type = type;
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
	public TypeIF getType() {
		return type;
	}
	/**
	 * @param type the tipo to set
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
