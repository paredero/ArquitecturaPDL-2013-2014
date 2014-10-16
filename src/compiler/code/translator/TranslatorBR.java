/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 *
 */
public class TranslatorBR extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorBR(QuadrupleIF quadruple) {
		super(quadruple);
	}

	/* (non-Javadoc)
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		sb.append("BR /" + q.getResult()).append(" \n");
		
		return sb.toString();
	}

}
