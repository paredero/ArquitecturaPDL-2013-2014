package compiler.syntax.nonTerminal;

public class CuerpoFuncion extends NonTerminal {

	ListaSentenciasFuncion listaSentencias;
	String nombreFuncion;

	public CuerpoFuncion() {

	}

	/**
	 * @return the nombreFuncion
	 */
	public String getNombreFuncion() {
		return nombreFuncion;
	}

	/**
	 * @param nombreFuncion
	 *            the nombreFuncion to set
	 */
	public void setNombreFuncion(String nombreFuncion) {
		this.nombreFuncion = nombreFuncion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CuerpoFuncion [listaSentencias=" + listaSentencias
				+ ", nombreFuncion=" + nombreFuncion + "]";
	}

	/**
	 * @return the listaSentencias
	 */
	public ListaSentenciasFuncion getListaSentencias() {
		return listaSentencias;
	}

	/**
	 * @param listaSentencias
	 *            the listaSentencias to set
	 */
	public void setListaSentencias(ListaSentenciasFuncion listaSentencias) {
		this.listaSentencias = listaSentencias;
	}
}
