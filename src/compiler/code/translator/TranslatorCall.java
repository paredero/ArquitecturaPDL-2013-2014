/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 *
 */
public class TranslatorCall extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorCall(QuadrupleIF quadruple) {
		super(quadruple);
	}

	@Override
	public String translate() {
		sb.append("\n \n");
		sb.append("; Llamada a la funcion, continuo creando el RA \n");
		sb.append("; En primer lugar almaceno el estado \n");
		sb.append("PUSH .SR \n");
		sb.append("; Almaceno un enlace al registro de activacion del subprograma llamante \n");
		sb.append("PUSH .IX \n");
		sb.append("; Situo el indice \n");
		sb.append("MOVE .SP, .IX \n");
		sb.append("CALL ").append(traducirOperando(q.getResult()));
		return sb.toString();
	}

}
