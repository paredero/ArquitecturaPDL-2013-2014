package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ListaParametrosEjecucion extends NonTerminal {
	private List<TypeIF> parameterTypes;
	private List<Expresion> parametros;
	
	public ListaParametrosEjecucion() {
		parameterTypes = new ArrayList<TypeIF>();
		parametros = new ArrayList<Expresion>();
	}

	/**
	 * @return the parameterTypes
	 */
	public List<TypeIF> getParameterTypes() {
		return parameterTypes;
	}

	/**
	 * @param parameterTypes the parameterTypes to set
	 */
	public void setParameterTypes(List<TypeIF> parameterTypes) {
		this.parameterTypes = parameterTypes;
	}
	
	public void addParameterType(TypeIF type) {
		this.parameterTypes.add(type);
	}

	/**
	 * @return the parametros
	 */
	public List<Expresion> getParametros() {
		return parametros;
	}

	/**
	 * @param parametros the parametros to set
	 */
	public void setParametros(List<Expresion> parametros) {
		this.parametros = parametros;
	}

	public void addParametro(Expresion parametro) {
		if (parametros == null) {
			parametros = new ArrayList<Expresion>();
		}
		this.parametros.add(parametro);		
		
		generarCodigoIntermedio(parametro);
		
	}

	private void generarCodigoIntermedio(Expresion parametro) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        cb.addQuadruples(this.getIntermediateCode());
        cb.addQuadruples(parametro.getIntermediateCode());
        cb.addQuadruple(InstructionSet.PARAM, null, parametro.getTemporal());
        
        this.setIntermediateCode(cb.create());
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListaParametrosEjecucion [parametros=" + parametros + "]";
	}


	
}
