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
		int espacioVaryTemp = MemoryManager.getSizeOfScope(scope.getLevel()+1);
				
		sb.append(";Registro de activacion \n");
		//getTranslation().append("MOVE .IX, #" + scopeCount + "[.R0]	;1- Mover puntero de marco(IX) a Display[" + scopeCount + "]" + SALTO_LINEA);
		sb.append("MOVE .SP, .IY ;posiciono el puntero IY en la primera posicion libre de la pila \n");
		//Avanzo el puntero una posición para dejar espacio para el valor de retorno.
		//Los parametros ya están insertados mediante instruciones PUSH, por lo cual el puntero de pila ya
		// ha avanzado el nº de parámetros.
		sb.append("SUB .IY, #1 ").append(" ;avanzo el puntero IY con - 1 espacio del valor de retorno(sentido decreciente) ").append("\n");
		sb.append("MOVE .A,.IY ").append(" ;ahora IY apunta a la posición que va a contener vinculo de control del RA").append("\n");
		sb.append("MOVE .IX,[.R0] ").append(" ;Se guarda la direccion del RA anterior en el display").append("\n");
		sb.append("INC .R0 ").append(" ;incremento el display a la siguiente posición libre").append("\n");
		sb.append("MOVE .IY,.IX ").append(" ;Ahora el puntero de marco (FP) apunta al RA actual").append("\n");
		sb.append("SUB .IX, #").append(espacioVaryTemp + 2).append(" ;Muevo el SP a la primera posición libre, contando las variables y temporales.").append("\n");
		sb.append("MOVE .A,.SP").append("\n");
		sb.append("CALL /")
				.append(sub.getCodeLabel())
				.append(" ;Salto al código del procedimiento, agregando la direccion de retorno al RA")
				.append("\n");
		sb.append("; Fin Registro Activacion ").append("\n");
		//Espacio del RA: tamaño parámetros (size)
		// +1 (valor de retorno)
		// +1 (vínculo de control)
		// tamaño de variables y temporales (espacioVaryTemp)
		// El RA también contiene la dirección de retorno en la posición mas baja del registro
		// de activación, pero al devolver la llamada (instrucción RET) se hace POP del puntero de pila
		// y se adelanta el puntero .SP una posición, por lo que ahora no hay que sumarla.
		sb.append("ADD .SP, #")
				.append((size + espacioVaryTemp + 2))
				.append(" ;Devuelvo el puntero de pila a la dirección inicial del RA padre")
				.append("\n");
		sb.append("MOVE .A,.SP").append("\n");
		sb.append("DEC .R0 ")
				.append(" ;decremento el display para que apunte al ambito padre ")
				.append("\n");
		sb.append("MOVE [.R0],.IX").append("\n");
		return sb.toString();
	}

}
