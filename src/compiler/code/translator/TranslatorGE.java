/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 * 
 */
public class TranslatorGE extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorGE(QuadrupleIF quadruple) {
		super(quadruple);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		sb.append("SUB ").append(traducirOperando(q.getFirstOperand())).append(", ")
				.append(traducirOperando(q.getSecondOperand())).append("\n");
		String label = LabelManager.getLabelText();
		String label2 = LabelManager.getLabelText();
		sb.append("BN /")
				.append(label)
				.append("	;Salto si el resultado es negativo, es decir, op1 < op2")
				.append("\n");
		sb.append("MOVE #1, ").append(traducirOperando(q.getResult())).append("\n");
		sb.append("BR /").append(label2).append("\n");
		sb.append(label).append(" : ").append("\n");
		sb.append("MOVE #0, ").append(traducirOperando(q.getResult())).append("\n");
		sb.append(label2).append(" : ").append("\n");
		return sb.toString();
	}

}
