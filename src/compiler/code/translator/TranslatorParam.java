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
			sb.append("MOVE ").append(".SP").append(", ").append(".IY").append(" \n");
			
			//En el tope de la pila almaceno la direccion de retorno
			sb.append("MOVE ").append(".PC").append(", ").append("#0[.IY]").append(" \n");
		}
		sb.append("MOVE ");
		sb.append(traducirOperando(q.getFirstOperand()));
		sb.append(", ");
		sb.append(".SP");
		sb.append(" \n");
		return sb.toString();
	}

}
