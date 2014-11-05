/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 *
 */
public class TranslatorEscribe extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorEscribe(QuadrupleIF quadruple) {
		super(quadruple);
	}

	/* (non-Javadoc)
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		sb.append("WRSTR ");
		String label = LabelManager.getLabelText();
		sb.append("/").append(label).append(" \n");
		sb.append("WRCHAR #10 ").append(" \n");
		sb.append("WRCHAR #13 ").append(" \n");
		sb.append(label).append(": DATA ").append(q.getFirstOperand()).append(" \n");
		sb.append("NOP \n");
		return sb.toString();
	}

}
