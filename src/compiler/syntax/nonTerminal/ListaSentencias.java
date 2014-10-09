package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

import compiler.CompilerContext;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.semantic.ScopeIF;

public class ListaSentencias extends NonTerminal {
	protected List<Sentencia> listaSentencias;

	/**
	 * 
	 */
	public ListaSentencias() {
		super();
		this.listaSentencias = new ArrayList<Sentencia>();
	}
	
	public void addSentencia(Sentencia sentencia) {
		this.listaSentencias.add(0, sentencia);
	}
	
	public void generarCodigoIntermedio() {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope ();
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        for (Sentencia sentencia:this.listaSentencias) {
        	cb.addQuadruples(sentencia.getIntermediateCode());
        }
        this.setIntermediateCode(cb.create());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListaSentencias [listaSentencias=" + listaSentencias + "]";
	}

	/**
	 * @return the listaSentencias
	 */
	public List<Sentencia> getListaSentencias() {
		return listaSentencias;
	}

	/**
	 * @param listaSentencias the listaSentencias to set
	 */
	public void setListaSentencias(List<Sentencia> listaSentencias) {
		this.listaSentencias = listaSentencias;
	}
	
	
	
}
