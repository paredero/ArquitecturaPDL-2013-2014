package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ListaSentenciasFuncion extends ListaSentencias {

	List<TypeIF> listaTiposReturn;
	public ListaSentenciasFuncion() {
		listaTiposReturn = new ArrayList<TypeIF>();
	}

	public void addReturnType(TypeIF t) {
		listaTiposReturn.add(t);
	}

	/**
	 * @return the listaTiposReturn
	 */
	public List<TypeIF> getListaTiposReturn() {
		return listaTiposReturn;
	}

	/**
	 * @param listaTiposReturn the listaTiposReturn to set
	 */
	public void setListaTiposReturn(List<TypeIF> listaTiposReturn) {
		this.listaTiposReturn = listaTiposReturn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListaSentenciasFuncion [listaSentencias=" + listaSentencias
				+ "tipos que se devuelver:" + listaTiposReturn + "]";
	}

}
