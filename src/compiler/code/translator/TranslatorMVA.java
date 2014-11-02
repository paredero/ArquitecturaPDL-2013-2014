package compiler.code.translator;

import compiler.intermediate.Variable;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorMVA extends Translator {

	public TranslatorMVA(QuadrupleIF q) {
		super(q);
	}

	@Override
	public String translate() {
		if (q.getFirstOperand() instanceof Variable) {
			Variable v = (Variable)q.getFirstOperand();
			if (v.getScope().getLevel() != scopeCount) {
				// Variable no local
				
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("MOVE ");
		sb.append(traducirOperando(q.getFirstOperand()));
		sb.append(", ");
		sb.append(traducirOperando(q.getResult()));
		sb.append("\n");
		return sb.toString();
	}

}
