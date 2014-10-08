package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorParam extends Translator {

	
	public TranslatorParam(QuadrupleIF q) {
		super(q);
	}

	@Override
	public String translate() {
		sb.append("MOVE ");
		sb.append(traducirOperando(q.getFirstOperand()));
		sb.append(", ");
		sb.append(".SP");
		sb.append(" \n");
		return sb.toString();
	}

}
