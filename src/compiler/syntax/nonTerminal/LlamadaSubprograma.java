package compiler.syntax.nonTerminal;

import java.util.List;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Procedure;
import compiler.intermediate.Temporal;
import compiler.semantic.symbol.SymbolFunction;
import compiler.semantic.symbol.SymbolParameter;
import compiler.semantic.symbol.SymbolProcedure;
import compiler.semantic.type.TypeProcedure;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class LlamadaSubprograma extends Sentencia {

	
	private TypeIF returnType;
	private String nombre;
	private TemporalIF temporal;
	
	/**
	 * Genera el codigo intermedio para una llamada a funcion
	 * @param sf
	 * @param pa
	 */
	public void generarCodigoIntermedio(SymbolFunction sf, 
			ListaParametrosEjecucion pa) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        
        
        cb.addQuadruples(pa.getIntermediateCode());    
        Procedure funcion = new Procedure(nombre, scope);
        funcion.setSimbolo(sf);
        TemporalFactory tF = new TemporalFactory (scope);
        TemporalIF temporal = tF.create();
        this.setTemporal(temporal);
        cb.addQuadruple (InstructionSet.CALL, funcion, temporal);
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
        cb.addQuadruples(pa.getIntermediateCode());            
        Procedure p = creaProcedure(sp.getName().toUpperCase(), scope, pa);
        cb.addQuadruple (InstructionSet.CALL, p);
        this.setIntermediateCode(cb.create());
	}

	
	private Procedure creaProcedure(String nombre, ScopeIF scope, ListaParametrosEjecucion parametrosEjecucion) {
		TypeIF tipo = scope.getScopeManager().searchType(nombre.toUpperCase());
		TypeProcedure tProc = (TypeProcedure) tipo;
		List<SymbolParameter> parametrosDeclaracion = tProc.getParametros();
		CompilerContext.getSemanticErrorManager().semanticDebug(
				"parameters ejec --> " + parametrosEjecucion.getParametros().size());
		for (int i = 0; i < parametrosDeclaracion.size(); i++) {
			Temporal temp = (Temporal) parametrosEjecucion.getParametros().get(i).getTemporal();
			CompilerContext.getSemanticErrorManager().semanticDebug("Temporal Procedimiento " + temp);
			parametrosDeclaracion.get(i).setTemporal(temp);
		}
		
		Procedure proc = new Procedure(nombre, scope);
        proc.setParams(parametrosDeclaracion);
		return proc;
	}

	
	
//-----------------------------------------------------------------------------	
//--------------GETTER & SETTER & TOSTRING
//-----------------------------------------------------------------------------	
	/**
	 * @return the returnType
	 */
	public TypeIF getReturnType() {
		return returnType;
	}

	/**
	 * @param returnType the returnType to set
	 */
	public void setReturnType(TypeIF returnType) {
		this.returnType = returnType;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setTemporal(TemporalIF temporal) {
		this.temporal = temporal;
	}



	/**
	 * @return the temporal
	 */
	public TemporalIF getTemporal() {
		return temporal;
	}
	
	
}
