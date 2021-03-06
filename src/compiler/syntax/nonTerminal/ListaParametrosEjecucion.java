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
	private Expresion ultimoParametro;
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
		this.ultimoParametro = parametro;
		this.parametros.add(parametro);		
	}

	public void generarCodigoIntermedio() {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        cb.addQuadruples(this.getIntermediateCode());
        cb.addQuadruples(ultimoParametro.getIntermediateCode());
        if (this.getParametros().size() == 1) {
        	cb.addQuadruple(InstructionSet.PARAM, null, ultimoParametro.getTemporal(),1);        
        } else {
        	cb.addQuadruple(InstructionSet.PARAM, null, ultimoParametro.getTemporal());
        }
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
