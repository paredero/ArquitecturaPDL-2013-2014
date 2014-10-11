package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorMul extends Translator {

	
	public TranslatorMul(QuadrupleIF q) {
		super(q);
	}

	@Override
	public String translate() {
		sb.append("MUL ");
		sb.append(traducirOperando(q.getFirstOperand()));
		sb.append(", ").append(traducirOperando(q.getSecondOperand()));
		sb.append(" \n");
		return sb.toString();
	}

}
