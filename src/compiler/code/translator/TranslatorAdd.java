package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorAdd extends Translator {

	public TranslatorAdd(QuadrupleIF quadruple) {
		super(quadruple);
	}

	@Override
	public String translate() {
		sb.append("ADD ").append(traducirOperando(q.getFirstOperand())).append(", ")
				.append(traducirOperando(q.getSecondOperand())).append(" \n");
		sb.append("MOVE .A, ").append(traducirOperando(q.getResult()))
				.append(" \n");
		return sb.toString();
	}

}
