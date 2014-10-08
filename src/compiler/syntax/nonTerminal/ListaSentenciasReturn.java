package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ListaSentenciasReturn extends NonTerminal {

	List<TypeIF> listaTiposReturn;
	ListaSentencias listaSentencias;
	public ListaSentenciasReturn() {
		listaTiposReturn = new ArrayList<TypeIF>();
		listaSentencias = new ListaSentencias();
	}

	public void addReturnType(TypeIF t) {
		listaTiposReturn.add(t);
	}

	
	public void addSentencia(NonTerminal sentencia) {
		this.listaSentencias.addSentencia(sentencia);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListaSentenciasReturn [listaSentencias=" + listaSentencias
				+ "]";
	}

	public void generarCodigoIntermedio() {
		this.listaSentencias.generarCodigoIntermedio();
		this.setIntermediateCode(this.listaSentencias.getIntermediateCode());
	}
}
