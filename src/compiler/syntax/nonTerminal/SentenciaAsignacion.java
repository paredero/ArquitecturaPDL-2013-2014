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
        	CompilerContext.getSemanticErrorManager().semanticDebug("Codigo intermedio de una asignacion de funcion ");
        	CompilerContext.getSemanticErrorManager().semanticDebug(expresion);
        	CompilerContext.getSemanticErrorManager().semanticDebug(referencia);
        	cb.addQuadruples(expresion.getIntermediateCode());
        	cb.addQuadruple(InstructionSet.STP, temporal, temporalExpresion);
        	cb.addQuadruple(InstructionSet.MV, referencia.getVariable(), temporal);
        } else {
        	cb.addQuadruples(expresion.getIntermediateCode());
        	cb.addQuadruples(referencia.getIntermediateCode());   	
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
