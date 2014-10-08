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
			sb.append("DEC .R0")
					.append(";decremento el display para que R0 apunte al ambito padre \n");
			sb.append("ADD #1, [.R0] \n");
			sb.append("MOVE ")
					.append(traducirOperando(q.getResult()))
					.append(", [.A]")
					.append(" ; Muevo el valor de retorno a su posición del RA (#1[.IX]) para tenerlo accesible desde el llamador \n");
			sb.append("INC .R0").append("; restauro el valor del display \n");
		}
		sb.append("RET \n");
		return sb.toString();
	}

}
