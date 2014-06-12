package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Variable;
import compiler.semantic.symbol.SymbolFunction;
import compiler.semantic.symbol.SymbolProcedure;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class LlamadaSubprograma extends NonTerminal {

	
	private TypeIF type;
	private String lexema;

	/**
	 * 
	 */
	public LlamadaSubprograma() {
		super();
	}

	public LlamadaSubprograma(TypeIF returnType, String name) {
		this.type = returnType;
		this.lexema = name;
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

	public void generarCodigoIntermedio(SymbolFunction sf, 
			ListaParametrosEjecucion pa) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        Variable p = new Variable(sf.getName(), scope);
        
        cb.addQuadruples(pa.getIntermediateCode());
        cb.addQuadruple (InstructionSet.CALL, p);
        this.setIntermediateCode(cb.create());
	}

	/**
	 * Genera el codigo intermedio para un procedimiento
	 * @param tp
	 * @param pa
	 */
	public void generarCodigoIntermedio(SymbolProcedure sp, 
			ListaParametrosEjecucion pa) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        Variable p = new Variable(sp.getName(), scope);
        
        cb.addQuadruples(pa.getIntermediateCode());
        cb.addQuadruple (InstructionSet.CALL, p);
        this.setIntermediateCode(cb.create());
	}
}
