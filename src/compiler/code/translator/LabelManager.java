package compiler.code.translator;


public class LabelManager {
	private static int i = 0;
	
	public static String getLabelText() {
		String label = "txt" + i;
		i++;
		return label;
	}
}
