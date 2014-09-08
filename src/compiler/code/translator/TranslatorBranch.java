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
public class TranslatorBranch extends Translator {

	/**
	 * @param quadruple
	 */
	public TranslatorBranch(QuadrupleIF quadruple) {
		super(quadruple);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see compiler.code.translator.Translator#translate()
	 */
	@Override
	public String translate() {
		sb.append("BR /" + q.getResult()).append(" \n");
		
		return sb.toString();
	}

}
