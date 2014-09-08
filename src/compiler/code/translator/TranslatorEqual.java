/**
 * 
 */
package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 * 
 */
public class TranslatorEqual extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorEqual(QuadrupleIF quadruple) {
		super(quadruple);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		sb.append("CMP ").append(translate(q.getFirstOperand())).append(", ")
				.append(translate(q.getSecondOperand())).append("\n");
		String label = LabelManager.getLabelText();
		String label2 = LabelManager.getLabelText();
		sb.append("BNZ /").append(label).append("\n");
		sb.append("MOVE #1, ").append(translate(q.getResult())).append("\n");
		sb.append("BR /").append(label2).append("\n");
		sb.append(label).append(" : ").append("\n");
		sb.append("MOVE #0, ").append(translate(q.getResult())).append("\n");
		sb.append(label2).append(" : ").append("\n");
		return sb.toString();
	}

}
