package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Referencia extends NonTerminal {

	private TypeIF type;
	private String lexema;
	private int line;
	
	public Referencia() {
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
	public int getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * @param type
	 * @param lexema
	 * @param line
	 */
	public Referencia(TypeIF type, String lexema, int line) {
		super();
		this.type = type;
		this.lexema = lexema;
		this.line = line;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Referencia [type=" + type + ", lexema=" + lexema + ", line="
				+ line + "]";
	}

	
}
