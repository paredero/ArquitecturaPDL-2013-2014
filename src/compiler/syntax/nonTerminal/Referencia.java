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
	 * @param type
	 * @param lexema
	 * @param line
	 */
	public Referencia(TypeIF type, String lexema, int line) {
		super();
		this.type = type;
		this.lexema = lexema;
		this.line = line;
	}
	
	public Referencia(TypeIF type, String lexema, int line, boolean accesoRegistro) {
		super();
		this.type = type;
		this.lexema = lexema;
		this.line = line;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Referencia [type=" + type.getName() + ", lexema=" + lexema + ", line="
				+ line + "]";
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

	public TemporalIF getTemporalIndex() {
		return this.temporalIndex;
	}

	public void setTemporalIndex(TemporalIF temporalReferenciaIndex) {
		this.temporalIndex = temporalReferenciaIndex;
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

	public void generarCodigoIntermedio() {
		ScopeManagerIF scopeManager = CompilerContext.getScopeManager();
		ScopeIF scope = scopeManager.getCurrentScope();
        TemporalFactory tF = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        
        TemporalIF temp = tF.create();
        
        // Puede ser un SymbolVariable o un SymbolParameter
        SymbolIF symbol = scopeManager.searchSymbol(this.getLexema());
        OperandIF o;
        
        CompilerContext.getSemanticErrorManager().semanticDebug("Obtenido simbolo " + symbol.getName());
        if (symbol instanceof SymbolVariable) {
        	o = new Variable(this.getLexema(), symbol.getScope());
        	CompilerContext.getSemanticErrorManager().semanticDebug("Variable creada ");               
        } else if (symbol instanceof SymbolParameter) {
        	CompilerContext.getSemanticErrorManager().semanticDebug("Es parametro"); 
        	o = new Variable(this.getLexema(), symbol);
        	CompilerContext.getSemanticErrorManager().semanticDebug("Parametro creado ");      
        	((Variable) o).setParameter(true);       	            
        } else {
        	SymbolConstant constante = (SymbolConstant)symbol;
            o = new Value(constante.getValue());
            CompilerContext.getSemanticErrorManager().semanticDebug("Constante creada ");  
        }
        
        cb.addQuadruple (InstructionSet.MV, temp, o);        
        this.setTemporal(temp);
        this.setIntermediateCode(cb.create());
        CompilerContext.getSemanticErrorManager().semanticDebug(this);
	}
	
	public void generarCodigoIntermedio(Referencia r, String campo) {
		ScopeManagerIF scopeManager = CompilerContext.getScopeManager();
		ScopeIF scope = scopeManager.getCurrentScope();
        TemporalFactory tf = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        TemporalIF temp = tf.create();
        
        
        TypeRecord tipo = (TypeRecord)variableRegistro.getType();
        CompilerContext.getSemanticErrorManager().semanticDebug("Obtiene el tipo "+tipo);
        int idOffset = tipo.getOffset(campoRegistro.getName());
        CompilerContext.getSemanticErrorManager().semanticDebug("Obtiene el offset "+idOffset);
        Variable var = new Variable(variableRegistro.getName(), variableRegistro.getScope());
        CompilerContext.getSemanticErrorManager().semanticDebug("Crez la variable "+var);
        var.setSimbolo(variableRegistro);
        CompilerContext.getSemanticErrorManager().semanticDebug("Le asigna el simbolo "+variableRegistro);

        cb.addQuadruple(InstructionSet.MOVE_REG, temp, idOffset, var);
        this.setTemporal(temp);
        this.setIntermediateCode(cb.create());
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

	
}
