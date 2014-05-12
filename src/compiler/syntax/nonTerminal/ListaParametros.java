package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

import compiler.semantic.symbol.SymbolParameter;

public class ListaParametros extends NonTerminal {
	private List<SymbolParameter> listaParametros;

	/**
	 * @return the listaParametros
	 */
	public List<SymbolParameter> getListaParametros() {
		return listaParametros;
	}

	/**
	 * @param listaParametros the listaParametros to set
	 */
	public void setListaParametros(List<SymbolParameter> listaParametros) {
		this.listaParametros = listaParametros;
	}

	/**
	 * @param listaParametros
	 */
	public ListaParametros(List<SymbolParameter> listaParametros) {
		super();
		this.listaParametros = listaParametros;
	}

	/**
	 * 
	 */
	public ListaParametros() {
		super();
		this.listaParametros = new ArrayList<SymbolParameter>();
	}
	
	
}
