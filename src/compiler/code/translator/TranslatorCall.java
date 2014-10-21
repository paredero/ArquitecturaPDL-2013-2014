/**
 * 
 */
package compiler.code.translator;

import compiler.intermediate.Procedure;
import compiler.semantic.symbol.SymbolFunction;

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
		sb.append("; Llamada a la funcion, continuo creando el RA \n");
		sb.append("; En primer lugar almaceno el estado \n");
		sb.append("PUSH .SR \n");
		sb.append("; Almaceno un enlace al registro de activacion del subprograma llamante \n");
		sb.append("PUSH .IX \n");
		
		sb.append(";Almaceno el valor correcto del PC \n");
		sb.append("MOVE .PC, #1[.IY] \n");
		if (q.getResult() instanceof Procedure) {
			sb.append(";Es procedure \n");
			Procedure p = (Procedure)q.getResult();
			sb.append("; " + p + " \n");
			SymbolFunction sf = (SymbolFunction)p.getSimbolo();
			sb.append("; " + sf + " \n");
			sb.append("; " + sf.getVarTempSize() + " \n");
			int tamVarsTemp = sf.getVarTempSize();
			sb.append("; Reservo espacio para " + tamVarsTemp + " temporales y variables locales \n");
			while (tamVarsTemp > 0) {
				sb.append("DEC .SP \n");
				tamVarsTemp--;
			}
		}
		sb.append("; Situo el indice IX al inicio del frame \n");
		sb.append("MOVE .SP, .IX \n");
		sb.append("CALL ").append(traducirOperando(q.getResult()));
		return sb.toString();
	}

}
