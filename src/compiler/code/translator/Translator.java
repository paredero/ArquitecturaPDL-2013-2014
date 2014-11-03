package compiler.code.translator;

import compiler.intermediate.Procedure;
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
		if (o instanceof Procedure) {
			return "/" + ((Procedure)o).getCodeLabel();
		} if (o instanceof Variable) {
			// Si se trata de una variable global direcciona directo a memoria
			// en el espacio que se ha reservado inicialmente
			Variable v = (Variable) o;
			int dirVar = v.getAddress() + v.getDesplazamiento();
			if (v.isGlobal()) {	
				return "/" + dirVar;
			} else if (!v.isParameter()) {
				// Si se trata de una variable local se direcciona relativo al registro [.IX]
				if (v.getScope().getLevel() == scopeCount) {
					// Referencia local
					return "#" + dirVar + "[.IX]";
				} else {
					dirVar = dirVar + v.getEnclosingSymbol().getSize() + 4;
					return "#" + dirVar + "[.IX]";
				}
			} else if (v.isParameter()) {
				if (v.getScope().getLevel() == scopeCount) {
					return "#"
							+ (v.getEnclosingSymbol().getSize() + 2
									- v.getEnclosingSymbol().getParamSize() + dirVar + 1)
							+ "[.IX]";
//					return "#-" + (dirVar + 1)  + "[.IY]";
				} else {
					dirVar = dirVar + v.getEnclosingSymbol().getSize() + 4;
					return "#-" + (dirVar + 1)  + "[.IY]";
				}
			}
		} else if (o instanceof Temporal) {
			Temporal t = (Temporal) o;
			return "#" + t.getAddress() + "[.IX]";
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
	
	
	
	public String traducirOperandoNoLocal(OperandIF o) {
		if (o instanceof Procedure) {
			return "/" + ((Procedure)o).getCodeLabel();
		} if (o instanceof Variable) {
			// Si se trata de una variable global direcciona directo a memoria
			// en el espacio que se ha reservado inicialmente
			Variable v = (Variable) o;
			int dirVar = v.getAddress() + v.getDesplazamiento();
			if (v.isGlobal()) {	
				return "/" + dirVar;
			} else if (!v.isParameter()) {
				// Si se trata de una variable local se direcciona relativo al registro [.IX]
				return "#" + dirVar + "[.IY]";				
			} else if (v.isParameter()) {

					return "#"
							+ (v.getEnclosingSymbol().getSize() + 2
									- v.getEnclosingSymbol().getParamSize() + dirVar + 1)
							+ "[.IY]";
//					return "#-" + (dirVar + 1)  + "[.IY]";
				
			}
		} else if (o instanceof Temporal) {
			Temporal t = (Temporal) o;
			return "#" + t.getAddress() + "[.IY]";
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
