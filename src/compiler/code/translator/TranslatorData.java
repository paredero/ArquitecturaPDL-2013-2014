/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 * 		La instruccion DATA se encarga de reservar espacio en memoria
 *         para las variables globales, las direccion en la que terminan las
 *         direcciones globales se ha calculado en la produccion de 
 *         program :: axiom y se ha almacenado como globalAddress en el 
 *         primer operando de la cuadrupla
 */
public class TranslatorData extends Translator {

	public TranslatorData(QuadrupleIF q) {
		super(q);
	}

	/* (non-Javadoc)
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		StringBuilder sb = new StringBuilder();
		try {
		// TODO Si le pongo una etiqueta a RES, podré referenciar el comienzo del programa
			sb.append("RES ").append(q.getFirstOperand())
					.append(";Reservo memoria para variables globales \n");
//			sb.append("MOVE #65535, ").append(STACK_POINTER).append(";Situo el puntero de pila al final del espacio de memoria \n");
//			sb.append("MOVE ").append(STACK_POINTER).append(" , ").append( PUNTERO_MARCO).append(";Inicializo el puntero de marco \n");
////			sb.append("SUB  ").append(STACK_POINTER).append(" , #").append(tra).append(" \n");
//			//Posicionar el puntero del display
//			sb.append("MOVE ").append(ACUMULADOR).append(", ").append(STACK_POINTER).append(" \n");
//			sb.append("MOVE ").append(PUNTERO_MARCO).append(" , /0").append(" \n");
//			
//			sb.append("BR /").append(q.getSecondOperand()).append("; Salto a la etiqueta del procedimiento principal \n");
		} catch (Exception e) {
			sb.append(e.getMessage());
		}
		return sb.toString();
	}

}
