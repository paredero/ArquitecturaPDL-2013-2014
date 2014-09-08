/**
 * 
 */
package compiler.code.translator;

import compiler.intermediate.InstructionSet;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * @author jgarcia
 *
 */
public class TranslatorBranchFalse extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorBranchFalse(QuadrupleIF quadruple) {
		super(quadruple);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {		 
		sb.append("CMP #1, ").append(translate(q.getResult())).append(" \n");
		sb.append("BNZ /" + q.getFirstOperand()).append(" \n");
		return sb.toString();
	}

}
