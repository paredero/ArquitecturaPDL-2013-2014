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
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		sb.append("WRSTR ");
		String label = LabelManager.getLabelText();
		sb.append("/").append(label).append( "\nWRCHAR #10\nWRCHAR #13");
		LabelManager.addLabel(label, "DATA "+ q.getResult());
		return sb.toString();
	}

}
