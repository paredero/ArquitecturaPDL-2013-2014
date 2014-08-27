package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public abstract class Translator {
    public static final String PUNTERO_MARCO = ".IY"; 
    public static final String VINCULO_CONTROL = ".IX";
    public static final String STACK_POINTER = ".SP";
    public static final String ACUMULADOR = ".A";
    public static final String CONTADOR_PROGRAMA = ".PC";
    
	protected QuadrupleIF q;

	public abstract String translate();

	/**
	 * @param q
	 */
	public Translator(QuadrupleIF q) {
		super();
		this.q = q;
	}

	
}
