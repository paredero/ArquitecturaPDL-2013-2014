/**
 * 
 */
package compiler.code.translator;

import compiler.intermediate.Value;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 *
 */
public class TranslatorLabel extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorLabel(QuadrupleIF quadruple) {
		super(quadruple);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		StringBuilder sb = new StringBuilder();
		sb.append(q.getResult() + " : ");
		if (q.getFirstOperand() != null) {
			// En las etiquetas que marcan el inicio de un subprograma, se
			// incluye el nivel de
			// ámbito como primer operando.
			Value v = (Value) q.getFirstOperand();
			scopeCount = (int) v.getValue();
			sb.append(" ; Ambito ").append(scopeCount).append(" \n");
		}
		return sb.toString();
	}

}
