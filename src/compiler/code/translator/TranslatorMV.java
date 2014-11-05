package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorMV extends Translator {


	public TranslatorMV(QuadrupleIF quadruple) {
		super(quadruple);
	}

	@Override
	public String translate() {
		StringBuilder sb = new StringBuilder();
		sb.append("MOVE ");
		sb.append(traducirOperando(q.getFirstOperand()));
		sb.append(", ");
		sb.append(traducirOperando(q.getResult()));
		sb.append(" \n");
		return sb.toString();
	}

}
