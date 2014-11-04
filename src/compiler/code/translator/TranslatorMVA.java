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
		boolean restaurarIY = false;
		if (q.getFirstOperand() instanceof Variable) {
			Variable v = (Variable)q.getFirstOperand();
			if (v.getScope().getLevel() != scopeCount) {
				// Variable no local
				sb.append("; Variable no local, nivel funcion: ")
						.append(scopeCount).append(" Nivel variable: ")
						.append(v.getScope().getLevel()).append(" \n");
				if (v.getScope().getLevel() == 0) {
					traduccionOperando1 = traducirOperando(q.getFirstOperand());
				} else {
					restaurarIY  = true;
					sb.append("MOVE ").append("[.IY]").append(", ").append(".IY \n");

					if (scopeCount - v.getScope().getLevel() > 1) {
						int nivelDescendido = v.getScope().getLevel() +1;
						while (nivelDescendido < scopeCount) {
							sb.append("; subo al nivel: ").append(nivelDescendido).append("\n");
							sb.append("MOVE ").append("[.IY]").append(", ").append(".IY \n");
							nivelDescendido++;
						}
					}
					traduccionOperando1 = traducirOperandoNoLocal(q.getFirstOperand());
				}
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
		if (restaurarIY) {
			sb.append("; Restauro IY ").append("\n");
			sb.append("MOVE .IX, .IY \n");
		}
		return sb.toString();
	}

}
