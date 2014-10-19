package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorParam extends Translator {

	
	public TranslatorParam(QuadrupleIF q) {
		super(q);
	}

	@Override
	public String translate() {
		if (q.getSecondOperand() != null && q.getSecondOperand().toString().equals("1")) {
			//Primer parametro, preparo registro de activacion
			
			// Apunto el indice IY al tope de pila
			sb.append("; como es el primer parametro preparo el registro de activacion \n");
			sb.append("; Apunto el indice IY al comienzo \n");
			sb.append("MOVE ").append(".SP").append(", ").append(".IY").append(" \n");
			// Reservo un espacio para el valor de retorno
			sb.append("; Reservo un espacio al valor de retorno \n");
			sb.append("DEC ").append(".SP").append(" \n");
			//En el tope de la pila almaceno la direccion de retorno
			sb.append("; Almaceno la direccion de retorno \n");
			sb.append("PUSH ").append(".PC").append(" \n");
		}
		//Introduzco el parametro
		sb.append("; Introduzco el parametro \n");
		sb.append("PUSH ");
		sb.append(traducirOperando(q.getFirstOperand()));
		sb.append(" \n");
		return sb.toString();
	}

}
