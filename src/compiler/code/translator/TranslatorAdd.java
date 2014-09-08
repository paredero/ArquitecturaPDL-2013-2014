package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorAdd extends Translator {

	public TranslatorAdd(QuadrupleIF quadruple) {
		super(quadruple);
	}

	@Override
	public String translate() {
		sb.append("ADD ").append(translate(q.getFirstOperand())).append(", ")
				.append(translate(q.getSecondOperand())).append(" \n");
		sb.append("MOVE .A, ").append(translate(q.getResult()))
				.append(" \n");
		return sb.toString();
	}

}
