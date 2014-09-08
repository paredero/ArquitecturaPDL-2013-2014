package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Variable;
import compiler.semantic.type.TypeFunction;
import compiler.semantic.type.TypeRecord;

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
        if (eTemp == null) {
            CompilerContext.getSemanticErrorManager().semanticDebug("*** TEMPORAL NULO " + expresion.getLexema());  
        }
        cb.addQuadruples(expresion.getIntermediateCode());
        if (referencia.getType() instanceof TypeFunction) {
        	cb.addQuadruple(InstructionSet.RET, eTemp);
        } else if (referencia.getAccesoRegistro()) {        	
        	Variable var = new Variable(referencia.getVariableRegistro().getName(), scope);
        	var.setSimbolo(referencia.getVariableRegistro());
            int offset = ((TypeRecord)referencia.getVariableRegistro().getType()).getOffset(referencia.getCampoRegistro().getName());
            cb.addQuadruples(expresion.getIntermediateCode());
            //Mueve el valor del temporal a la variable-registro var que se calcula con el offset
            cb.addQuadruple(InstructionSet.MOVE_REG, var, offset, eTemp);
            this.setIntermediateCode(cb.create()); 
        } else  {     
			Variable var = new Variable(referencia.getLexema(), scope);
			cb.addQuadruple(InstructionSet.MV, var, eTemp);
        }
        this.setIntermediateCode(cb.create()); 
	}
}
