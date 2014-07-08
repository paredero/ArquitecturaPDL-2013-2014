package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

import compiler.CompilerContext;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.semantic.ScopeIF;

public class ListaSentencias extends NonTerminal {
	private List<NonTerminal> listaSentencias;

	/**
	 * 
	 */
	public ListaSentencias() {
		super();
		this.listaSentencias = new ArrayList<NonTerminal>();
	}
	
	public void addSentencia(NonTerminal sentencia) {
		this.listaSentencias.add(0, sentencia);
	}
	
	public void generarCodigoIntermedio() {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope ();
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        for (NonTerminal sentencia:this.listaSentencias) {
        	cb.addQuadruples(sentencia.getIntermediateCode());
        }
        this.setIntermediateCode(cb.create());
	}
}
