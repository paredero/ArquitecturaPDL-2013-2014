package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class SentenciaReturn extends NonTerminal {
	
	Expresion expresion;
	
	

	/**
	 * @param type
	 */
	public SentenciaReturn(Expresion e) {
		super();
		this.expresion = e;
	}

	/**
	 * 
	 */
	public SentenciaReturn() {
		super();
	}

	public void generarCodigoIntermedio() {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
		cb.addQuadruples(expresion.getIntermediateCode());
		cb.addQuadruple(InstructionSet.RET, expresion.getTemporal());
		this.setIntermediateCode(cb.create());
	}

	/**
	 * @return the type
	 */
	public TypeIF getType() {
		return expresion.getType();
	}
	
	public TemporalIF getTemporal() {
		return expresion.getTemporal();
	}
	
	
	

}
