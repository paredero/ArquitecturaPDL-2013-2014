package compiler.code.translator;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorFinal extends Translator {

	public TranslatorFinal(QuadrupleIF q) {
		super(q);
	}

	@Override
	public String translate() {
		StringBuilder sb = new StringBuilder();
		sb.append("HALT\n");
		sb.append("END \n");
		return sb.toString();
	}

}
