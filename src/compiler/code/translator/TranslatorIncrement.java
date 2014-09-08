/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 * 
 */
public class TranslatorIncrement extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorIncrement(QuadrupleIF quadruple) {
		super(quadruple);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		sb.append("INC ").append(translate(q.getResult())).append(" \n");
		return sb.toString();
	}

}
