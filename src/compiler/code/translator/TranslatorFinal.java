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
		String labels = LabelManager.getLabels();
		if(labels != null)
		{
			sb.append(labels);
		}
		sb.append("END \n");
		return sb.toString();
	}

}
