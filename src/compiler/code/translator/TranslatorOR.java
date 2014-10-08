/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 * 
 */
public class TranslatorOR extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorOR(QuadrupleIF quadruple) {
		super(quadruple);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		sb.append("OR ").append(traducirOperando(q.getFirstOperand())).append(", ")
				.append(traducirOperando(q.getSecondOperand())).append("\n");
		sb.append("MOVE .A, ").append(traducirOperando(q.getResult()));
		return sb.toString();
	}
}
