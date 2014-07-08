package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.semantic.type.TypeSimple;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Expresion extends NonTerminal {
	public static String SUMA = "+";
	public static String MAYOR = ">";
	public static String IGUAL = "=";
	public static String OR = "OR";
	
	private TypeIF type;
	private String lexema;
	private TemporalIF temporal;
	
	/**
	 * @param type
	 * @param lexema
	 */
	public Expresion(TypeIF type, String lexema) {
		super();
		this.type = type;
		this.lexema = lexema;
	}
	/**
	 * @return the type
	 */
	public TypeIF getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(TypeIF type) {
		this.type = type;
	}
	/**
	 * @return the lexema
	 */
	public String getLexema() {
		return lexema;
	}
	/**
	 * @param lexema the lexema to set
	 */
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	
	
	/**
	 * @return the temporal
	 */
	public TemporalIF getTemporal() {
		return temporal;
	}
	/**
	 * @param temporal the temporal to set
	 */
	public void setTemporal(TemporalIF temporal) {
		this.temporal = temporal;
	}
	/**
	 * 
	 */
	public Expresion() {
		super();
	}
	
	public static boolean tiposCompatibles(String operador,TypeIF t1,TypeIF t2) {
		boolean resultado = false;
		if (operador.equals(Expresion.SUMA)) {
			resultado = t1.getName().equals(TypeSimple.NUMERO)
					&& t2.getName().equals(TypeSimple.NUMERO); 
		} else if (operador.equals(Expresion.MAYOR)) {
			resultado = t1.getName().equals(TypeSimple.NUMERO)
					&& t2.getName().equals(TypeSimple.NUMERO);
		} else if (operador.equals(Expresion.IGUAL)) {
			resultado = t1.equals(t2);
		} else if (operador.equalsIgnoreCase(Expresion.OR)) {
			resultado = t1.getName().equals(TypeSimple.LOGICO)
					&& t2.getName().equals(TypeSimple.LOGICO);
		}	
		return resultado;
		
	}

	public void generarCodigoIntermedio(Expresion e1, Expresion e2, String operador) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        TemporalFactory tF = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        TemporalIF temp1 = e1.getTemporal();
        TemporalIF temp2 = e2.getTemporal();
        TemporalIF temp = tF.create ();
        cb.addQuadruples(e1.getIntermediateCode());
        cb.addQuadruples(e2.getIntermediateCode());
        cb.addQuadruple(this.getCodigoOperacion(operador), temp, temp1, temp2);
        this.setTemporal (temp);
        this.setIntermediateCode(cb.create());		
	}
	
	public void generarCodigoIntermedio(Referencia r) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        TemporalFactory tF = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        
        TemporalIF tempReferencia = r.getTemporal();
        TemporalIF temp = tF.create();
        
        cb.addQuadruples(r.getIntermediateCode());
        cb.addQuadruple(InstructionSet.MV, temp, tempReferencia);
        this.setTemporal(temp);
        this.setIntermediateCode(cb.create());
	}
	
	private String getCodigoOperacion(String operador) {
		String codigoOperacion = "";
		if (operador.equals(SUMA)) {
			codigoOperacion = InstructionSet.ADD;
		} else if (operador.equals(MAYOR)) {
			codigoOperacion = InstructionSet.GREATER_THAN;
		} else if (operador.equals(IGUAL)) {
			codigoOperacion = InstructionSet.EQUAL;
		} else if (operador.equals(OR)) {
			codigoOperacion = InstructionSet.OR;
		}  
		return codigoOperacion;
	}
	public void generarCodigoIntermedio(Valor valor) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        TemporalFactory tF = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        
        TemporalIF temp = tF.create();
        
        cb.addQuadruple(InstructionSet.MV, temp, valor.getValue());
        this.setTemporal(temp);
        this.setIntermediateCode(cb.create());
	}

}
