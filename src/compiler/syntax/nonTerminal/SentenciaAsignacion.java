package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.semantic.type.TypeFunction;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.ScopeManagerIF;

public class SentenciaAsignacion extends Sentencia {
	
	public void generarCodigoIntermedio(Referencia referencia, Expresion expresion) {
		ScopeManagerIF scopeManager = CompilerContext.getScopeManager();
		ScopeIF scope = scopeManager.getCurrentScope();
		TemporalFactory tF = new TemporalFactory (scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);        
        
        TemporalIF temporalExpresion = expresion.getTemporal();
        TemporalIF temporalIndexReferencia = referencia.getTemporalIndex();
        TemporalIF temporal = tF.create();
        
        if (expresion.getType() instanceof TypeFunction) {
        	cb.addQuadruples(expresion.getIntermediateCode());
        	cb.addQuadruple(InstructionSet.MV, temporal, temporalExpresion);
        	cb.addQuadruple(InstructionSet.MV, referencia.getVariable(), temporal);
        } else {
        	cb.addQuadruples(expresion.getIntermediateCode());
        	cb.addQuadruples(referencia.getIntermediateCode());   	
        	if (temporalIndexReferencia != null) {
        		cb.addQuadruple(InstructionSet.MUL, temporal, temporalIndexReferencia);
        	}
        	cb.addQuadruple(InstructionSet.MV, temporal, temporalExpresion);
        	cb.addQuadruple(InstructionSet.MV, referencia.getVariable(), temporal);
        }
        
        this.setIntermediateCode(cb.create()); 
	}
}
