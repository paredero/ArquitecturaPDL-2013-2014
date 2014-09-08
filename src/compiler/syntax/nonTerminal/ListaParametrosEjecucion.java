package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

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
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListaParametrosEjecucion [parametros=" + parametros + "]";
	}

	
	
}
