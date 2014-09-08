package compiler.code;

import compiler.code.translator.LabelManager;
import compiler.code.translator.Translator;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorFinal extends Translator {

	public TranslatorFinal(QuadrupleIF q) {
		super(q);
	}

	@Override
	public String translate() {
		StringBuilder sb = new StringBuilder();
		sb.append("HALT\n");
		sb.append("ORG 32768\n");
		String labels = LabelManager.getLabels();
		if(labels != null)
		{
			sb.append(labels);
		}
		sb.append("END \n");
		return sb.toString();
	}

}
