/**
 * 
 */
package compiler.code.translator;

import compiler.intermediate.Procedure;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;
import es.uned.lsi.compiler.semantic.ScopeIF;

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

	/**
	 * 	/
	 *	1- Mover puntero de marco(IX) a Display[ambito]
	 *	2- Mover puntero de pila(SP) a puntero de marco(IX)
	 *  3- Colocar la direccion de retorno en el tope de la pila
	 * 
	 */
	@Override
	public String translate() {

		OperandIF subprograma = q.getResult();
		Procedure sub = (Procedure)subprograma;
		
		int size = sub.getParams().size();
		size++; // dejo una posición extra para el valor de retorno de la función. El valor de retorno estará en #-1[IX]
		
		ScopeIF scope = sub.getScope();
		int tamVariablesYTemporales = MemoryUtil.getSizeOfScope(scope.getLevel()+1);
				
		sb.append(";Registro de activacion \n");

		sb.append("MOVE .SP,.IY ;Guardo en A el valor de retorno\n");

		sb.append("SUB .IY, #1 ").append(" ;avanzo el puntero IY con - 1 espacio del valor de retorno(sentido decreciente) ").append("\n");
		sb.append("MOVE .A,.IY ").append(" ;ahora IY apunta a la posición que va a contener vinculo de control del RA").append("\n");
		sb.append("MOVE .IX,[.R0] ").append(" ;Se guarda la direccion del RA anterior en el display").append("\n");
		sb.append("INC .R0 ").append(" ;incremento el display a la siguiente posición libre").append("\n");
		sb.append("MOVE .IY,.IX ").append(" ;Ahora el puntero de marco (FP) apunta al RA actual").append("\n");
		sb.append("SUB .IX, #").append(tamVariablesYTemporales + 2).append(" ;Muevo el SP a la primera posición libre, contando las variables y temporales.").append("\n");
		sb.append("MOVE .A,.SP").append("\n");
		
		
		sb.append("CALL /")
				.append(sub.getCodeLabel())
				.append(" ;Salto a la etiqueta establecida para el procedimiento")
				.append("\n");
		sb.append("; Fin Registro Activacion ").append("\n");
		return sb.toString();
	}

}
