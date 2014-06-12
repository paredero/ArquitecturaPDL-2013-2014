package compiler.syntax.nonTerminal;



import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Variable;
import compiler.semantic.type.TypeRecord;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Referencia [type=" + type + ", lexema=" + lexema + ", line="
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
        SymbolIF sv = scopeManager.searchSymbol(this.getLexema());
        
        Variable var = new Variable(this.getLexema(), sv.getScope());
        cb.addQuadruple(InstructionSet.MVA, temp, var);
        this.setTemporal(temp);
        this.setIntermediateCode(cb.create());
	}
	
	public void generarCodigoIntermedio(Referencia r, String campo) {
		ScopeManagerIF scopeManager = CompilerContext.getScopeManager();
		ScopeIF scope = scopeManager.getCurrentScope();
        TemporalFactory tf = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        
        TemporalIF rTemp = r.getTemporal();
        TemporalIF rTempI = r.getTemporalIndex();
        TemporalIF rTempO = tf.create();
        
        cb.addQuadruples(r.getIntermediateCode());
        TypeRecord rType = (TypeRecord)r.getType();
        int idOffSet = rType.getOffset(campo);
        
        cb.addQuadruple(InstructionSet.MV, rTempO, idOffSet);
        this.setTemporal(rTemp);
        this.setTemporalIndex(rTempI);
        this.setTemporalOffset(rTempO);
        this.setIntermediateCode(cb.create());
	}
	
}
