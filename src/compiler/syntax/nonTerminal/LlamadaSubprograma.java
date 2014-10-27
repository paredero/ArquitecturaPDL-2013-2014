package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Procedure;
import compiler.semantic.symbol.SymbolFunction;
import compiler.semantic.symbol.SymbolProcedure;

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
        if (pa == null || pa.getParametros() == null || pa.getParametros().size() == 0) {
        	CompilerContext.getSemanticErrorManager().semanticDebug("Funcion sin parametros");
        	cb.addQuadruple(InstructionSet.PARAM);
        }
        cb.addQuadruple (InstructionSet.CALL, funcion, temporal);
        this.setIntermediateCode(cb.create());
        CompilerContext.getSemanticErrorManager().semanticDebug("Codigo generado por la llamada a la funcion");
        CompilerContext.getSemanticErrorManager().semanticDebug(cb.create());
	}



	/**
	 * Genera el codigo intermedio para un procedimiento
	 * @param sp el simbolo del procedimiento
	 * @param pa
	 */
	public void generarCodigoIntermedio(SymbolProcedure sp, 
			ListaParametrosEjecucion pa) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        
        cb.addQuadruples(pa.getIntermediateCode());  
        Procedure procedimiento = new Procedure(nombre, scope);
        procedimiento.setSimbolo(sp);
        if (pa == null || pa.getParametros() == null || pa.getParametros().size() == 0) {
        	CompilerContext.getSemanticErrorManager().semanticDebug("procedimiento sin parametros");
        	cb.addQuadruple(InstructionSet.PARAM);
        }
        cb.addQuadruple (InstructionSet.CALL, procedimiento, temporal);
        this.setIntermediateCode(cb.create());
        CompilerContext.getSemanticErrorManager().semanticDebug("Codigo generado por la llamada al procedimiento");
        CompilerContext.getSemanticErrorManager().semanticDebug(cb.create());
        
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
