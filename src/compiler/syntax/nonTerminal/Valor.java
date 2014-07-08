package compiler.syntax.nonTerminal;

import compiler.intermediate.Value;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Valor extends NonTerminal {
	private TypeIF type;
	private String lexema;
	private Value value;
	
	private Integer line;
	public Valor() {
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
	 * @return the line
	 */
	public Integer getLine() {
		return line;
	}
	/**
	 * @param line the line to set
	 */
	public void setLine(Integer line) {
		this.line = line;
	}
	/**
	 * @param type
	 * @param lexema
	 * @param line
	 */
	public Valor(TypeIF type, String lexema, Integer line, Value value) {
		super();
		this.type = type;
		this.lexema = lexema;
		this.line = line;
		this.value = value;
	}
	/**
	 * @return the value
	 */
	public Value getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Value value) {
		this.value = value;
	}
	
	

}
