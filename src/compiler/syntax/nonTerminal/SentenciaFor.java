package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.semantic.symbol.SymbolVariable;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelFactoryIF;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;


public class SentenciaFor extends Sentencia {

	public void generarCodigoIntermedio(SymbolVariable indice, Expresion expInicio,
			Expresion expFin, ListaSentencias listaSentencias) {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope ();
        LabelFactoryIF lF = new LabelFactory(scope.getName());
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        
        TemporalIF tempExpresionFin = expFin.getTemporal();
        LabelIF l1 = lF.create();
        LabelIF l2 = lF.create();
        
        cb.addQuadruples(expInicio.getIntermediateCode());
        cb.addQuadruple(InstructionSet.INL, l1);
        cb.addQuadruples(expFin.getIntermediateCode());
        cb.addQuadruple(InstructionSet.BRANCH_FALSE, tempExpresionFin, l2);
        cb.addQuadruples(listaSentencias.getIntermediateCode());
        cb.addQuadruple(InstructionSet.BRANCH, l1);
        cb.addQuadruple(InstructionSet.INL, l2);
        this.setIntermediateCode(cb.create());		
	}
	
}
