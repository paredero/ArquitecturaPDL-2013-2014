package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorMVA extends Translator {

	public TranslatorMVA(QuadrupleIF q) {
		super(q);
	}

	@Override
	public String translate() {
		StringBuilder sb = new StringBuilder();
		sb.append("MOVE ");
		sb.append(traducirOperando(q.getFirstOperand()));
		sb.append(", ");
		sb.append(traducirOperando(q.getResult()));
		sb.append("\n");
		return sb.toString();
	}

}
