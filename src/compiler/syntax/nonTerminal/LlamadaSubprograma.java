package compiler.syntax.nonTerminal;

import java.util.List;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Procedure;
import compiler.intermediate.Temporal;
import compiler.semantic.symbol.SymbolFunction;
import compiler.semantic.symbol.SymbolParameter;
import compiler.semantic.symbol.SymbolProcedure;
import compiler.semantic.type.TypeFunction;
import compiler.semantic.type.TypeProcedure;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class LlamadaSubprograma extends NonTerminal {

	
	private TypeIF returnType;
	private String lexema;
	private OperandIF operacion;

	/**
	 * 
	 */
	public LlamadaSubprograma() {
		super();
	}

	public LlamadaSubprograma(TypeIF returnType, String name) {
		this.returnType = returnType;
		this.lexema = name;
	}
	

	/**
	 * @return the type
	 */
	public TypeIF getType() {
		return returnType;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeIF type) {
		this.returnType = type;
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
	 * @return the operacion
	 */
	public OperandIF getOperacion() {
		return operacion;
	}

	/**
	 * @param operacion the operacion to set
	 */
	public void setOperacion(OperandIF operacion) {
		this.operacion = operacion;
	}

	public void generarCodigoIntermedio(SymbolFunction sf, 
			ListaParametrosEjecucion pa) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        Procedure p = this.creaProcedure(sf.getName(), scope, pa);       
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
        Procedure p = this.creaProcedure(sp.getName(), scope, pa); 
        		
        cb.addQuadruples(pa.getIntermediateCode());
        cb.addQuadruple (InstructionSet.CALL, p);
        this.setIntermediateCode(cb.create());
	}

	private Procedure creaProcedure(String nombre, ScopeIF scope, ListaParametrosEjecucion parametrosEjecucion) {
		TypeIF tipo = scope.getScopeManager().searchType(nombre.toUpperCase());
		TypeProcedure tProc = (TypeProcedure) tipo;
		List<SymbolParameter> parametrosDeclaracion =  tProc.getParametros();
		
		CompilerContext.getSemanticErrorManager().semanticDebug(
				"parameters decl --> " + parametrosDeclaracion.size());
		CompilerContext.getSemanticErrorManager().semanticDebug(
				"parameters ejec --> " + parametrosEjecucion.getParametros().size());
		for (int i = 0; i < parametrosDeclaracion.size(); i++) {
			Temporal temp = (Temporal) parametrosEjecucion.getParametros().get(i).getTemporal();
			CompilerContext.getSemanticErrorManager().semanticDebug("temp" + temp);
			parametrosDeclaracion.get(i).setTemporal(temp);
		}
		
		Procedure proc = new Procedure(nombre, scope);
        proc.setParams(parametrosDeclaracion);
		return proc;
	}
}
