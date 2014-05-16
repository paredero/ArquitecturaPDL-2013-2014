package compiler.syntax.nonTerminal;

import java.util.List;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class CuerpoFuncion {

	List<TypeIF> listaSentenciasReturn;
	String nombreFuncion;
	
	public CuerpoFuncion() {
		
	}

	/**
	 * @return the listaSentenciasReturn
	 */
	public List<TypeIF> getListaSentenciasReturn() {
		return listaSentenciasReturn;
	}

	/**
	 * @param listaSentenciasReturn the listaSentenciasReturn to set
	 */
	public void setListaSentenciasReturn(List<TypeIF> listaSentenciasReturn) {
		this.listaSentenciasReturn = listaSentenciasReturn;
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

	
}
