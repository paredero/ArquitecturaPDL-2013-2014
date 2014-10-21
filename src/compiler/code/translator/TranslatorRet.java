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
			sb.append("; Asigno el valor devuelto \n");
			sb.append("MOVE ").append(traducirOperando(q.getResult())).append(", #0[.IY]").append(" \n");
		}
		sb.append("RET \n");
		return sb.toString();
	}

}
