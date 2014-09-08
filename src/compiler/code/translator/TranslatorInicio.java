/**
 * 
 */
package compiler.code.translator;

import compiler.intermediate.Value;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 *
 */
public class TranslatorInicio extends Translator {

	public TranslatorInicio(QuadrupleIF q) {
		super(q);
	}

	/* (non-Javadoc)
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		StringBuilder sb = new StringBuilder();
		
		try {
			Value valor = (Value) q.getFirstOperand();
			int tra = 5;
			tra = (int) valor.getValue();
			sb.append("RES ").append(q.getFirstOperand()).append(";Reservo memoria para variables globales \n");
			sb.append("MOVE #65535, ").append(STACK_POINTER).append(";Situo el puntero de pila al final del espacio de memoria \n");
			sb.append("MOVE ").append(STACK_POINTER).append(" , ").append( PUNTERO_MARCO).append(";Inicializo el puntero de marco \n");
			sb.append("SUB  ").append(STACK_POINTER).append(" , #").append(tra).append(" \n");
			//Posicionar el puntero del display
			sb.append("MOVE ").append(ACUMULADOR).append(", ").append(STACK_POINTER).append(" \n");
			sb.append("MOVE ").append(PUNTERO_MARCO).append(" , /0").append(" \n");
			
			sb.append("BR /").append(q.getSecondOperand()).append("; Salto a la etiqueta del procedimiento principal \n");
		} catch (Exception e) {
			sb.append(e.getMessage());
		}
		return sb.toString();
	}

}
