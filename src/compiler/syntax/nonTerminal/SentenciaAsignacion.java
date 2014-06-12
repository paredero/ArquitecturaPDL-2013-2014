package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Variable;
import compiler.semantic.type.TypeFunction;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.ScopeManagerIF;

public class SentenciaAsignacion extends NonTerminal {
	
	public void generarCodigoIntermedio(Referencia referencia, Expresion expresion) {
		ScopeManagerIF scopeManager = CompilerContext.getScopeManager();
		ScopeIF scope = scopeManager.getCurrentScope();

        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        TemporalIF eTemp = expresion.getTemporal();
        cb.addQuadruples(expresion.getIntermediateCode());
        if (referencia.getType() instanceof TypeFunction) {
        	cb.addQuadruple(InstructionSet.RET, eTemp);
        } else {			
			Variable var = new Variable(referencia.getLexema(), scope);
			cb.addQuadruple(InstructionSet.MV, var, eTemp);
        }
        this.setIntermediateCode(cb.create()); 
	}
}
