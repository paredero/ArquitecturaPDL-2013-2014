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
//	private TemporalIF temporalOffset;
//	private Boolean accesoRegistro = false;
//	SymbolVariable variableRegistro;
//	SymbolVariable campoRegistro;
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
            cb.addQuadruple(InstructionSet.MV, temp, o);
            CompilerContext.getSemanticErrorManager().semanticDebug("Constante creada " + o);  
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
        
        String nombreRegistro = r.getLexema().toUpperCase();
        SymbolVariable symbol = (SymbolVariable)scopeManager.searchSymbol(nombreRegistro);
        TypeRecord tRec = (TypeRecord) r.getType();
        if (symbol instanceof SymbolVariable) {
        	// Se trata de una variable
        	CompilerContext.getSemanticErrorManager().semanticDebug("Es Variable");  
        	Variable variable = new Variable(nombreRegistro, symbol.getScope());
        	
        	int desplazamiento = tRec.getDesplazamiento(campo);
        	CompilerContext.getSemanticErrorManager().semanticDebug("Es Variable *Campo: " + campo + " Desplazamiento: " + desplazamiento);
        	variable.setDesplazamiento(desplazamiento);
        	TemporalIF temp = tf.create();
        	cb.addQuadruple (InstructionSet.MVA, temp, variable);   
        	this.setVariable(variable);
        	this.setTemporal(temp);
        } 
        
        
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
		return "Referencia [fieldType=" + type + ", lexema=" + lexema
				+ ", line=" + line + ", temporal=" + temporal
				+ ", temporalIndex=" + temporalIndex + "]";
	}


	
	
	
	
}



