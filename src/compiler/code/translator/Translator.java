package compiler.code.translator;

import compiler.intermediate.Temporal;
import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public abstract class Translator {
	public static final String PUNTERO_MARCO = ".IY";
	public static final String STACK_POINTER = ".SP";
	public static final String ACUMULADOR = ".A";

	protected QuadrupleIF q;
	protected StringBuilder sb;

	public static int scopeCount = 0;

	public abstract String translate();

	/**
	 * @param q
	 */
	public Translator(QuadrupleIF q) {
		super();
		this.q = q;
		this.sb = new StringBuilder();
	}

	public boolean isNoLocal(Variable var) {
		return (var.getScope().getLevel() != scopeCount);
	}

	public String traducirOperando(OperandIF o) {
		if (o instanceof Variable) {
			// Si se trata de una variable global direcciona directo a memoria
			Variable v = (Variable) o;
			if (v.isGlobal()) {
				return "/" + v.getAddress();
			}
			// Los parámetros se posicionan en las direcciones superiores al
			// puntero de marco.
			// Se deja un espacio para el valor de retorno en las funciones
			if (v.isParameter()) {
				return "#" + (v.getAddress() + 1) + "[.IX]";
			}
			if (isNoLocal(v)) {
				// Si la variable es no local su direción está en el registro
				// R1.
				// Esta dirección se calcula en la clase TranslatorMove cuando
				// se detecta
				// que la variable es no local
				return "[.R1]";
			}
			return "#-" + v.getAddress() + "[.IX]";
		} else if (o instanceof Temporal) {
			Temporal t = (Temporal) o;
			return "#-" + t.getAddress() + "[.IX]";
		} else if (o instanceof Value) {
			Value v = (Value) o;
			if (v.getValue().toString().equals("true")) {
				return "#1";
			} else if (v.getValue().toString().equals("false")) {
				return "#0";
			} else if (v.getValue() instanceof String) {
				return v.getValue().toString();
			}

			return "#" + v.getValue();
		}
		return "NO IMPLEMENTADO: " + o;
	}


}
