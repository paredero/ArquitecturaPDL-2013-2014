/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 * 
 */
public class TranslatorRet extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorRet(QuadrupleIF quadruple) {
		super(quadruple);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		// Esta parte solo es válida para las funciones
		if (q.getResult() != null) {
		}
		sb.append("RET \n");
		return sb.toString();
	}

}
