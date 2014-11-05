/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 *
 */
public class TranslatorBranchFalse extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorBranchFalse(QuadrupleIF quadruple) {
		super(quadruple);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		if (q.getSecondOperand() != null) {
		sb.append("CMP ").append(traducirOperando(q.getFirstOperand()))
				.append(", ").append(traducirOperando(q.getSecondOperand()))
				.append(" \n");
		} else {
			sb.append("CMP #0, ").append(traducirOperando(q.getFirstOperand())).append(" \n");
		}
		sb.append("BZ /" + q.getResult()).append(" \n");
		return sb.toString();
	}

}
