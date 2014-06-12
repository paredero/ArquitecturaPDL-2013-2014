package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Value;
import compiler.semantic.type.TypeSimple;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelFactoryIF;
import es.uned.lsi.compiler.intermediate.LabelIF;

public class SentenciaPutLine extends NonTerminal {

	public void generarCodigoIntermedio(Expresion exp) {
		IntermediateCodeBuilder cb = new IntermediateCodeBuilder(CompilerContext.getScopeManager().getCurrentScope());
        cb.addQuadruples(exp.getIntermediateCode());
        if(esValorBooleano(exp))
        {
	        LabelFactoryIF lF = new LabelFactory();
	        LabelIF l1 = lF.create();
	        LabelIF l2 = lF.create();
	        cb.addQuadruple(InstructionSet.BRANCH_FALSE, exp.getTemporal(), l1);
	        cb.addQuadruple(InstructionSet.ESCRIBE, new Value("\"true\""));
	        cb.addQuadruple(InstructionSet.BRANCH, l2);
	        cb.addQuadruple(InstructionSet.LABEL, l1);
	        cb.addQuadruple(InstructionSet.ESCRIBE, new Value("\"false\""));
	        cb.addQuadruple(InstructionSet.LABEL, l2);
        }else{
        	cb.addQuadruple(InstructionSet.ESCRIBE_VALOR, exp.getTemporal());
        }
        this.setIntermediateCode(cb.create());
	}

	private boolean esValorBooleano(Expresion exp) {
		boolean valorBooleano = false;
		if (exp.getType().equals(
				CompilerContext.getScopeManager().getCurrentScope()
						.getTypeTable().getType(TypeSimple.LOGICO))) {
			valorBooleano = true;
		}
		return valorBooleano;
	}
}
