package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Variable;
import compiler.semantic.symbol.SymbolVariable;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelFactoryIF;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;


public class SentenciaFor extends Sentencia {

	public void generarCodigoIntermedio(SymbolVariable indice, Expresion expInicio,
			Expresion expFin, ListaSentencias listaSentencias) {
		
		
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope ();
        LabelFactoryIF lF = new LabelFactory();
        TemporalFactory tF = new TemporalFactory(scope);
        TemporalIF tempCondicion = tF.create();
        
        LabelIF l1 = lF.create();
        LabelIF l2 = lF.create();
        Variable varIterator = new Variable(indice.getName(), scope);
        
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        cb.addQuadruples(expInicio.getIntermediateCode());
        cb.addQuadruple(InstructionSet.MV, varIterator, expInicio.getTemporal());
        cb.addQuadruples(expFin.getIntermediateCode());
        cb.addQuadruple(InstructionSet.LABEL, l1);
        cb.addQuadruple(InstructionSet.GREATER_EQUAL, tempCondicion, expFin.getTemporal(), varIterator);
        cb.addQuadruple(InstructionSet.BRANCH_FALSE, tempCondicion, l2);
        cb.addQuadruples(listaSentencias.getIntermediateCode());
        cb.addQuadruple(InstructionSet.INCREMENT, varIterator);
        cb.addQuadruple(InstructionSet.BRANCH, l1);
        cb.addQuadruple(InstructionSet.LABEL, l2);
        this.setIntermediateCode(cb.create());		
	}
	
}
