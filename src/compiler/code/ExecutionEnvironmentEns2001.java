package compiler.code;

import java.util.Arrays;
import java.util.List;

import compiler.code.translator.Translator;
import compiler.code.translator.TranslatorAdd;
import compiler.code.translator.TranslatorBranch;
import compiler.code.translator.TranslatorBranchFalse;
import compiler.code.translator.TranslatorCall;
import compiler.code.translator.TranslatorEqual;
import compiler.code.translator.TranslatorEscribe;
import compiler.code.translator.TranslatorEscribeValor;
import compiler.code.translator.TranslatorGE;
import compiler.code.translator.TranslatorGT;
import compiler.code.translator.TranslatorIncrement;
import compiler.code.translator.TranslatorInicio;
import compiler.code.translator.TranslatorLabel;
import compiler.code.translator.TranslatorMV;
import compiler.code.translator.TranslatorMVReg;
import compiler.code.translator.TranslatorOR;
import compiler.code.translator.TranslatorRet;
import compiler.intermediate.InstructionSet;
import compiler.semantic.type.TypeSimple;

import es.uned.lsi.compiler.code.ExecutionEnvironmentIF;
import es.uned.lsi.compiler.code.MemoryDescriptorIF;
import es.uned.lsi.compiler.code.RegisterDescriptorIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Class for the ENS2001 Execution environment.
 */

public class ExecutionEnvironmentEns2001 implements ExecutionEnvironmentIF {
	private final static int MAX_ADDRESS = 65535;
	private final static String[] REGISTERS = { ".PC", ".SP", ".SR", ".IX",
			".IY", ".A", ".R0", ".R1", ".R2", ".R3", ".R4", ".R5", ".R6",
			".R7", ".R8", ".R9" };

	private RegisterDescriptorIF registerDescriptor;
	private MemoryDescriptorIF memoryDescriptor;

	/**
	 * Constructor for ENS2001Environment.
	 */
	public ExecutionEnvironmentEns2001() {
		super();
	}

	/**
	 * Returns the size of the type within the architecture.
	 * 
	 * @return the size of the type within the architecture.
	 */
	@Override
	public final int getTypeSize(TypeSimple type) {
		return 1;
	}

	/**
	 * Returns the registers.
	 * 
	 * @return the registers.
	 */
	@Override
	public final List<String> getRegisters() {
		return Arrays.asList(REGISTERS);
	}

	/**
	 * Returns the memory size.
	 * 
	 * @return the memory size.
	 */
	@Override
	public final int getMemorySize() {
		return MAX_ADDRESS;
	}

	/**
	 * Returns the registerDescriptor.
	 * 
	 * @return Returns the registerDescriptor.
	 */
	@Override
	public final RegisterDescriptorIF getRegisterDescriptor() {
		return registerDescriptor;
	}

	/**
	 * Returns the memoryDescriptor.
	 * 
	 * @return Returns the memoryDescriptor.
	 */
	@Override
	public final MemoryDescriptorIF getMemoryDescriptor() {
		return memoryDescriptor;
	}

	/**
	 * Translate a quadruple into a set of final code instructions.
	 * 
	 * @param cuadruple
	 *            The quadruple to be translated.
	 * @return a quadruple into a set of final code instructions.
	 */
	@Override
	public final String translate(QuadrupleIF quadruple) {
		StringBuilder sb = new StringBuilder();
		sb.append(";").append(quadruple.toString()).append(" \n");
		try {
			String op = quadruple.getOperation();
			Translator trans;
			if (op.equals(InstructionSet.INICIO)) {
				trans = new TranslatorInicio(quadruple);
			} else if (op.equals(InstructionSet.FINAL)) {
				trans = new TranslatorFinal(quadruple);
			} else if (op.equals(InstructionSet.ADD)) {
				trans = new TranslatorAdd(quadruple);
			} else if (op.equals(InstructionSet.BRANCH)) {
				trans = new TranslatorBranch(quadruple);
			} else if (op.equals(InstructionSet.BRANCH_FALSE)) {
				trans = new TranslatorBranchFalse(quadruple);
			} else if (op.equals(InstructionSet.CALL)) {
				trans = new TranslatorCall(quadruple);
			} else if (op.equals(InstructionSet.EQUAL)) {
				trans = new TranslatorEqual(quadruple);
			} else if (op.equals(InstructionSet.ESCRIBE)) {
				trans = new TranslatorEscribe(quadruple);
			} else if (op.equals(InstructionSet.ESCRIBE_VALOR)) {
				trans = new TranslatorEscribeValor(quadruple);
			} else if (op.equals(InstructionSet.GREATER_EQUAL)) {
				trans = new TranslatorGE(quadruple);
			} else if (op.equals(InstructionSet.GREATER_THAN)) {
				trans = new TranslatorGT(quadruple);
			} else if (op.equals(InstructionSet.INCREMENT)) {
				trans = new TranslatorIncrement(quadruple);
			} else if (op.equals(InstructionSet.LABEL)) {
				trans = new TranslatorLabel(quadruple);
			} else if (op.equals(InstructionSet.MV)) {
				trans = new TranslatorMV(quadruple);
			} else if(op.equals(InstructionSet.MOVE_REG)){	    		
	    		trans = new TranslatorMVReg(quadruple);
	    	} else if (op.equals(InstructionSet.OR)) {
				trans = new TranslatorOR(quadruple);
			} else if (op.equals(InstructionSet.RET)) {
				trans = new TranslatorRet(quadruple);
			} else {
				return quadruple.toString();
			}
			sb.append(trans.translate());
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "Excepcion en el proceso de traduccion " +quadruple + e.getMessage();
		}
	}
}
