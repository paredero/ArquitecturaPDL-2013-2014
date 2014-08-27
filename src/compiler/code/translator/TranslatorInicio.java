/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 *
 */
public class TranslatorInicio extends Translator {

	public TranslatorInicio(QuadrupleIF q) {
		super(q);
	}

	/* (non-Javadoc)
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(";INICIO PROGRAMA PRINCIPAL \n");
		sb.append("RES ").append(q.getFirstOperand()).append(" \n");
		sb.append("MOVE #65535, ").append(STACK_POINTER).append(" \n");
		sb.append("MOVE ").append(STACK_POINTER).append(" , ").append( PUNTERO_MARCO).append(" \n");
		sb.append("SUB  ").append(STACK_POINTER).append(" , #").append(tRA).append(" \n");
		sb.append("MOVE ").append(ACUMULADOR).append(" , ").append(STACK_POINTER).append(" \n");
		sb.append("MOVE ").append(PUNTERO_MARCO).append(" , /0");
		
		return null;
	}

}
