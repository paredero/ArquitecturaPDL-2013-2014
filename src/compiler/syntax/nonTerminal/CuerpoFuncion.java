package compiler.syntax.nonTerminal;

import java.util.List;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class CuerpoFuncion extends NonTerminal {

	List<TypeIF> listaTiposReturn;
	ListaSentencias listaSentencias;
	String nombreFuncion;
	
	public CuerpoFuncion() {
		
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
	public void getListaTiposReturn(List<TypeIF> listaTiposReturn) {
		this.listaTiposReturn = listaTiposReturn;
	}

	/**
	 * @return the nombreFuncion
	 */
	public String getNombreFuncion() {
		return nombreFuncion;
	}

	/**
	 * @param nombreFuncion the nombreFuncion to set
	 */
	public void setNombreFuncion(String nombreFuncion) {
		this.nombreFuncion = nombreFuncion;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CuerpoFuncion [listaTiposReturn=" + listaTiposReturn.size()
				+ ", listaSentencias=" + listaSentencias + ", nombreFuncion="
				+ nombreFuncion + "]";
	}

	/**
	 * @return the listaSentencias
	 */
	public ListaSentencias getListaSentencias() {
		return listaSentencias;
	}

	/**
	 * @param listaSentencias the listaSentencias to set
	 */
	public void setListaSentencias(ListaSentencias listaSentencias) {
		this.listaSentencias = listaSentencias;
	}

	/**
	 * @param listaTiposReturn the listaTiposReturn to set
	 */
	public void setListaTiposReturn(List<TypeIF> listaTiposReturn) {
		this.listaTiposReturn = listaTiposReturn;
	}

	

	
}
