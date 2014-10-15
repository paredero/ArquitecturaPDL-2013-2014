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
        TemporalIF temporalReferencia = referencia.getTemporal();
        TemporalIF temporalIndexReferencia = referencia.getTemporalIndex();
//        TemporalIF temporalOffsetReferencia = referencia.getTemporalOffset();
        TemporalIF temporal = tF.create();
        if (referencia.getType() instanceof TypeFunction) {
        	cb.addQuadruples(expresion.getIntermediateCode());
        	cb.addQuadruple(InstructionSet.RET, temporalExpresion);
        } else {
        	cb.addQuadruples(expresion.getIntermediateCode());
        	cb.addQuadruples(referencia.getIntermediateCode());   	
        	CompilerContext.getSemanticErrorManager().semanticDebug("*temporalIndexReferencia* " + temporalIndexReferencia);
        		if (temporalIndexReferencia != null) {
        			cb.addQuadruple(InstructionSet.MUL, temporal, temporalIndexReferencia);
        		}
//        		cb.addQuadruple(InstructionSet.ADD, temporal, temporal, temporalReferencia);
//        		cb.addQuadruple(InstructionSet.ADD, temporal, temporal, temporalOffsetReferencia);
        	
        	cb.addQuadruple(InstructionSet.STP, temporal, temporalExpresion);
        	cb.addQuadruple(InstructionSet.MV, referencia.getVariable(), temporal);
        	CompilerContext.getSemanticErrorManager().semanticDebug("*Referencia asignacion* " + referencia.getVariable());
        }
        this.setIntermediateCode(cb.create()); 
	}
}
