package compiler.syntax.nonTerminal;



import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import compiler.semantic.symbol.SymbolConstant;
import compiler.semantic.symbol.SymbolParameter;
import compiler.semantic.symbol.SymbolVariable;
import compiler.semantic.type.TypeRecord;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.ScopeManagerIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Referencia extends NonTerminal {

	private TypeIF type;
	private String lexema;
	private int line;
	private TemporalIF temporal;
	private TemporalIF temporalIndex;
	private TemporalIF temporalOffset;
	private Boolean accesoRegistro = false;
	SymbolVariable variableRegistro;
	SymbolVariable campoRegistro;
	private Variable variable;
	


	/**
	 * Genera el codigo intermedio de referencia ::= IDENTIFICADOR:id
	 */
	public void generarCodigoIntermedio() {
		ScopeManagerIF scopeManager = CompilerContext.getScopeManager();
		ScopeIF scope = scopeManager.getCurrentScope();
        TemporalFactory tF = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        
        TemporalIF temp = tF.create();
        
        //Obtengo el simbolo correspondiente al lexema
        SymbolIF symbol = scopeManager.searchSymbol(lexema);
        OperandIF o;
        
        CompilerContext.getSemanticErrorManager().semanticDebug("Obtenido simbolo " + symbol.getName());
        if (symbol instanceof SymbolVariable) {
        	// Se trata de una variable
        	CompilerContext.getSemanticErrorManager().semanticDebug("Es Variable");  
        	Variable variable = new Variable(lexema, symbol.getScope());
        	cb.addQuadruple (InstructionSet.MVA, temp, variable);   
        	this.setVariable(variable);
        } else if (symbol instanceof SymbolParameter) {
        	CompilerContext.getSemanticErrorManager().semanticDebug("Es parametro"); 
        	o = new Variable(lexema, symbol);
        	CompilerContext.getSemanticErrorManager().semanticDebug("Parametro creado ");      
        	((Variable) o).setParameter(true);      
        	//TODO El codigo de un parametro
        } else {
        	SymbolConstant constante = (SymbolConstant)symbol;
            o = new Value(constante.getValue());
            CompilerContext.getSemanticErrorManager().semanticDebug("Constante creada ");  
        	//TODO El codigo de una constante
        }       
                
        this.temporal = temp;
        this.setIntermediateCode(cb.create());
	}
	

	

	/**
	 * Genera el codigo intermedio del acceso a campo de registro
	 * @param r
	 * @param campo
	 */
	public void generarCodigoIntermedioAccesoRegistro(Referencia r, String campo) {
		ScopeManagerIF scopeManager = CompilerContext.getScopeManager();
		ScopeIF scope = scopeManager.getCurrentScope();
        TemporalFactory tf = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        
        TemporalIF tempRegistro = r.getTemporal();
        this.temporalIndex = r.getTemporalIndex();
        this.temporalOffset = tf.create();        
        
        cb.addQuadruples(r.getIntermediateCode());        
        TypeRecord tipoRegistro = (TypeRecord)variableRegistro.getType();
        
        CompilerContext.getSemanticErrorManager().semanticDebug("Obtiene el tipo del registro "+tipoRegistro);
        int idOffset = tipoRegistro.getOffset(campoRegistro.getName());
        
        cb.addQuadruple(InstructionSet.MV, temporalOffset, idOffset);
        this.temporal = tempRegistro;
        
        this.setIntermediateCode(cb.create());
	}
	
	
	//-------------------------------------------------------------------------
	//----------CONSTRUCTOR & GETTER & SETTER & TOSTRING METHODS---------------
	//-------------------------------------------------------------------------

	public Referencia() {
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
	 * @return the line
	 */
	public int getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(int line) {
		this.line = line;
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
	 * @return the temporalIndex
	 */
	public TemporalIF getTemporalIndex() {
		return temporalIndex;
	}

	/**
	 * @param temporalIndex the temporalIndex to set
	 */
	public void setTemporalIndex(TemporalIF temporalIndex) {
		this.temporalIndex = temporalIndex;
	}

	/**
	 * @return the temporalOffset
	 */
	public TemporalIF getTemporalOffset() {
		return temporalOffset;
	}

	/**
	 * @param temporalOffset the temporalOffset to set
	 */
	public void setTemporalOffset(TemporalIF temporalOffset) {
		this.temporalOffset = temporalOffset;
	}

	/**
	 * @return the accesoRegistro
	 */
	public Boolean getAccesoRegistro() {
		return accesoRegistro;
	}

	/**
	 * @param accesoRegistro the accesoRegistro to set
	 */
	public void setAccesoRegistro(Boolean accesoRegistro) {
		this.accesoRegistro = accesoRegistro;
	}

	/**
	 * @return the variableRegistro
	 */
	public SymbolVariable getVariableRegistro() {
		return variableRegistro;
	}

	/**
	 * @param variableRegistro the variableRegistro to set
	 */
	public void setVariableRegistro(SymbolVariable variableRegistro) {
		this.variableRegistro = variableRegistro;
	}

	/**
	 * @return the campoRegistro
	 */
	public SymbolVariable getCampoRegistro() {
		return campoRegistro;
	}

	/**
	 * @param campoRegistro the campoRegistro to set
	 */
	public void setCampoRegistro(SymbolVariable campoRegistro) {
		this.campoRegistro = campoRegistro;
	}

	
	/**
	 * @return the variable
	 */
	public Variable getVariable() {
		return variable;
	}




	/**
	 * @param variable2 the variable to set
	 */
	public void setVariable(Variable variable2) {
		this.variable = variable2;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Referencia [fieldType=" + type + ", lexema=" + lexema + ", line="
				+ line + ", temporal=" + temporal + ", temporalIndex="
				+ temporalIndex + ", temporalOffset=" + temporalOffset
				+ ", accesoRegistro=" + accesoRegistro + ", variableRegistro="
				+ variableRegistro + ", campoRegistro=" + campoRegistro + "]";
	}


	
	
	
	
}



