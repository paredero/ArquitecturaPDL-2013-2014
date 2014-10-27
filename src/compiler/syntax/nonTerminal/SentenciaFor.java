package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Variable;
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
        Variable variableIndice = new Variable(indice.getName(), indice);
        
        
        cb.addQuadruples(expInicio.getIntermediateCode());        
        cb.addQuadruple(InstructionSet.MV, variableIndice, expInicio.getTemporal());
        cb.addQuadruple(InstructionSet.INL, l1);
        cb.addQuadruples(expFin.getIntermediateCode());
        cb.addQuadruple(InstructionSet.INCREMENT, tempExpresionFin); //Para pillar el ultimo del rango
        cb.addQuadruple(InstructionSet.BRANCH_FALSE,l2, variableIndice, tempExpresionFin);
        cb.addQuadruples(listaSentencias.getIntermediateCode());
        cb.addQuadruple(InstructionSet.INCREMENT, variableIndice);
        cb.addQuadruple(InstructionSet.BR, l1);
        cb.addQuadruple(InstructionSet.INL, l2);
        this.setIntermediateCode(cb.create());		
	}
	
}
