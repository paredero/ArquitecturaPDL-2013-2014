package compiler.code.translator;

import compiler.intermediate.Variable;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorMVA extends Translator {

	public TranslatorMVA(QuadrupleIF q) {
		super(q);
	}

	@Override
	public String translate() {
		StringBuilder sb = new StringBuilder();
		String traduccionOperando1 = null;
		if (q.getFirstOperand() instanceof Variable) {
			Variable v = (Variable)q.getFirstOperand();
			if (v.getScope().getLevel() != scopeCount) {
				// Variable no local
				sb.append("; Variable no local, nivel funcion: ")
						.append(scopeCount).append(" Nivel variable: ")
						.append(v.getScope().getLevel()).append(" \n");
				sb.append("MOVE ").append("#")
						.append(v.getEnclosingSymbol().getVarTempSize()+1)
						.append("[.IX]").append(", ").append(".IY \n");
				traduccionOperando1 = traducirOperandoNoLocal(q.getFirstOperand());
			} else {
				traduccionOperando1 = traducirOperando(q.getFirstOperand());
			}
		} else {
			traduccionOperando1 = traducirOperando(q.getFirstOperand());
		}
		
		sb.append("MOVE ");
		sb.append(traduccionOperando1);
		sb.append(", ");
		sb.append(traducirOperando(q.getResult()));
		sb.append("\n");
		return sb.toString();
	}

}
