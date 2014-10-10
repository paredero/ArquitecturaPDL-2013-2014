package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;

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
        TemporalIF temporalOffsetReferencia = referencia.getTemporalOffset();
        TemporalIF temporal = tF.create();
        
        cb.addQuadruples(expresion.getIntermediateCode());
        cb.addQuadruples(referencia.getIntermediateCode());
        
        cb.addQuadruple(InstructionSet.MUL, temporal, temporalIndexReferencia);
        cb.addQuadruple(InstructionSet.ADD, temporal, temporal, temporalReferencia);
        cb.addQuadruple(InstructionSet.ADD, temporal, temporal, temporalOffsetReferencia);
        cb.addQuadruple(InstructionSet.STP, temporal, temporalExpresion);
        this.setIntermediateCode(cb.create()); 
        //TODO SOBRA???
//        if (referencia.getType() instanceof TypeFunction) {
//        	cb.addQuadruple(InstructionSet.RET, temporalExpresion);
//        } else if (referencia.getAccesoRegistro()) {        	
//        	Variable var = new Variable(referencia.getVariableRegistro().getName(), scope);
//        	var.setSimbolo(referencia.getVariableRegistro());
//            int offset = ((TypeRecord)referencia.getVariableRegistro().getType()).getOffset(referencia.getCampoRegistro().getName());
//            cb.addQuadruples(expresion.getIntermediateCode());
//            //Mueve el valor del temporal a la variable-registro var que se calcula con el offset
//            cb.addQuadruple(InstructionSet.MOVE_REG, var, offset, temporalExpresion);
//            this.setIntermediateCode(cb.create()); 
//        } else  {     
//			Variable var = new Variable(referencia.getLexema(), scope);
//			cb.addQuadruple(InstructionSet.MV, var, temporalExpresion);
//        }
	}
}
