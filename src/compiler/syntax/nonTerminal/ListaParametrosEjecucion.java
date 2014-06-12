package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ListaParametrosEjecucion extends NonTerminal {
	private List<TypeIF> parameterTypes;
	
	public ListaParametrosEjecucion() {
		parameterTypes = new ArrayList<TypeIF>();
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

}
