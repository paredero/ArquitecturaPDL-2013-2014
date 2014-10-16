package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelFactoryIF;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;

public class SentenciaIF extends Sentencia {

	/**
	 * Codigo intermedio para if sin else
	 * @param expCondicion
	 * @param listaSentencias
	 */
	public void generarCodigoIntermedio(Expresion expCondicion,
			ListaSentencias listaSentencias) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		LabelFactoryIF lf = new LabelFactory();
		LabelIF l1 = lf.create();
		TemporalIF eTemp = expCondicion.getTemporal();
		IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);

		cb.addQuadruples(expCondicion.getIntermediateCode());
		cb.addQuadruple(InstructionSet.BRANCH_FALSE, eTemp, l1);
		cb.addQuadruples(listaSentencias.getIntermediateCode());
		cb.addQuadruple(InstructionSet.INL, l1);

		this.setIntermediateCode(cb.create());
	}

	/**
	 * Codigo intermedio para if con else
	 * @param expCondicion
	 * @param listaSentencias
	 * @param listaSentenciasElse
	 */
	public void generarCodigoIntermedio(Expresion expCondicion,
			ListaSentencias listaSentencias, ListaSentencias listaSentenciasElse) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
		LabelFactoryIF lF = new LabelFactory(scope.getName());
		
		LabelIF l1 = lF.create();
		LabelIF l2 = lF.create();
		TemporalIF temporalExpresion = expCondicion.getTemporal();
		
		cb.addQuadruples(expCondicion.getIntermediateCode());
		cb.addQuadruple(InstructionSet.BRANCH_FALSE, temporalExpresion, l1);
		cb.addQuadruples(listaSentencias.getIntermediateCode());
		cb.addQuadruple(InstructionSet.BR, l2);
		cb.addQuadruple(InstructionSet.INL, l1);
		cb.addQuadruples(listaSentenciasElse.getIntermediateCode());
		cb.addQuadruple(InstructionSet.INL, l2);
		this.setIntermediateCode(cb.create());
	}

}
