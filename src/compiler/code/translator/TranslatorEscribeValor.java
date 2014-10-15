/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 *
 */
public class TranslatorEscribeValor extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorEscribeValor(QuadrupleIF quadruple) {
		super(quadruple);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		sb.append("WRINT ");
		sb.append(traducirOperando(q.getResult())).append(" \n");
		sb.append("WRCHAR #10 \n").append("WRCHAR #13 \n");
		return sb.toString();
	}

}
