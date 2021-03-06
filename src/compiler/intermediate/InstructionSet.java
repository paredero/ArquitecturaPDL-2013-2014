package compiler.intermediate;

public class InstructionSet {

	// ADD x y z	x := y +z 
	public static final String ADD = "ADD";
	public static final String ESCRIBE = "ESCRIBE";
	public static final String ESCRIBE_VALOR = "ESCRIBEVAL";
	
	// GR x y z		x := (y > z) ? 1 : 0
	public static final String GREATER_THAN = "GR";
	
	// EQ x y z		x := (y == z) ? 1 : 0
	public static final String EQUAL = "EQ";

	// OR x y z		x := y || z
	public static final String OR = "OR";

	// MV x y 		x := y
	public static final String MV = "MV";
	
	public static final String MVA = "MVA";
	
	// BRF x L		si !x, salto a L
	public static final String BRANCH_FALSE = "BRF";
	
	// INL L		Insertar L
	public static final String INL = "INL";
	
	// BR L			Salto a L
	public static final String BR = "BR";
	
	public static final String INCREMENT = "INC";
	
	public static final String CALL = "CALL";
	public static final String RET = "RET";
	
	public static final String DATA = "DATA";
	
	public static final String FINAL = "FINAL";

	public static final String PARAM = "PARAM";
	
	public static final String MUL = "MUL";
}
