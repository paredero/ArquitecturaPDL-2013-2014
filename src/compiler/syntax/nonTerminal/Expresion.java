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
	 * Comprueba la compatibilidad de una operación para dos tipos de operandos
	 */
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
		CompilerContext.getSemanticErrorManager().semanticDebug(
				"generarCodigoIntermedio(Expresion e1, Expresion e2, String operador) "
						+ e1 + " " + e2 + " " + operador);
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        TemporalFactory tF = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        
        TemporalIF temp1 = e1.getTemporal();
        TemporalIF temp2 = e2.getTemporal();
        TemporalIF temp = tF.create ();
        
        cb.addQuadruples(e1.getIntermediateCode());
        cb.addQuadruples(e2.getIntermediateCode());
		
        cb.addQuadruple(this.getCodigoOperacion(operador),temp, temp1, temp2);		
        
        this.setTemporal (temp);
        this.setIntermediateCode(cb.create());		
	}
	
	/**
	 * Genera el codigo intermedio de la produccion
	 * expresion ::= referencia
	 * @param r
	 */
	public void generarCodigoIntermedio(Referencia r) {
		
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        TemporalFactory tF = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        cb.addQuadruples(r.getIntermediateCode());
        
        if (r.getAccesoRegistro()) {
        	// Si se trata del acceso a un registro
        	TemporalIF tempReferencia = r.getTemporal();
        	TemporalIF tempIndexReferencia = r.getTemporalIndex();
        	TemporalIF tempOffsetReferencia = r.getTemporalOffset();
        	TemporalIF tempExpresion = tF.create();
        	int registroSize = r.getType().getSize();
        	cb.addQuadruple(InstructionSet.MUL, tempExpresion, tempIndexReferencia, registroSize);
        	cb.addQuadruple(InstructionSet.ADD, tempExpresion, tempExpresion, tempReferencia);
        	cb.addQuadruple(InstructionSet.ADD, tempExpresion, tempExpresion, tempOffsetReferencia);
        	cb.addQuadruple(InstructionSet.MVP, tempExpresion, tempExpresion);
        	this.setTemporal(tempExpresion);
        } else {
	        TemporalIF tempReferencia = r.getTemporal();
	        TemporalIF temp = tF.create();
	        cb.addQuadruple(InstructionSet.MVA, temp, tempReferencia);
	        this.setTemporal(temp);
        }
        this.setIntermediateCode(cb.create());
	}
	
	private String getCodigoOperacion(String operador) {
		String codigoOperacion = "";
		if (operador.equals(SUMA)) {
			codigoOperacion = InstructionSet.ADD;
		} else if (operador.equalsIgnoreCase(MAYOR)) {
			codigoOperacion = InstructionSet.GREATER_THAN;
		} else if (operador.equalsIgnoreCase(IGUAL)) {
			codigoOperacion = InstructionSet.EQUAL;
		} else if (operador.equalsIgnoreCase(OR)) {
			codigoOperacion = InstructionSet.OR;
		}  
		return codigoOperacion;
	}
	
	/**
	 * Genera el codigo intermedio de la produccion
	 * expresion ::= valor
	 * @param valor
	 */
	public void generarCodigoIntermedio(Valor valor) {
		CompilerContext.getSemanticErrorManager().semanticDebug("generarCodigoIntermedio(Valor " + valor);

		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        TemporalFactory tF = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        
        TemporalIF temp = tF.create();        
        cb.addQuadruple(InstructionSet.MV, temp, valor.getValue());
        
        this.setTemporal(temp);
        this.setIntermediateCode(cb.create());
	}
	
	
	public void generarCodigoIntermedio(LlamadaSubprograma l) {
		CompilerContext.getSemanticErrorManager().semanticDebug("generarCodigoIntermedio(Llamada_Subprograma " + l);
        ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        TemporalFactory tF = new TemporalFactory (scope);
        TemporalIF temp = tF.create();
        cb.addQuadruples(l.getIntermediateCode());
        cb.addQuadruple (InstructionSet.RET, temp);
        this.setTemporal(temp);
        this.setIntermediateCode(cb.create());
	}

	//-----------------CONSTRUCTORS	
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
	 * 
	 */
	public Expresion() {
		super();
	}
	
	
	//-----------------GETTER & SETTER & TOSTRING CODE
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Expresion [type=" + type.getName() + ", lexema=" + lexema + ", temporal="
				+ temporal + "]";
	}


	
	
}
