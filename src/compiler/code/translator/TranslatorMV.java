package compiler.code.translator;

import compiler.intermediate.Variable;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorMV extends Translator {


	public TranslatorMV(QuadrupleIF quadruple) {
		super(quadruple);
	}

	@Override
	public String translate() {
		StringBuilder sb = new StringBuilder();
		if(q.getFirstOperand() instanceof Variable) {
			Variable v = (Variable)q.getFirstOperand();
			if(isNoLocal(v)){
				int display = 65001 + v.getScope().getLevel();
				sb.append("MOVE #").append(display).append(", .R1").append(" \n");
				sb.append("SUB [.R1], #" + v.getAddress()).append(" \n");
				sb.append("MOVE .A, .R1").append(" \n");
			}
		}
		sb.append("MOVE ");
		sb.append(translate(q.getFirstOperand()));
		sb.append(", ");
		sb.append(translate(q.getResult()));
		sb.append(" \n");
		return sb.toString();
	}

}
