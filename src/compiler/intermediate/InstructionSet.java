package compiler.intermediate;

public class InstructionSet {

	// ADD x y z	x := y +z 
	public static final String ADD = "ADD";
	public static final String ESCRIBE = "ESCRIBE";
	public static final String ESCRIBE_VALOR = "ESCRIBEVAL";
	
	// MUL x y z	x := y * z 
	public static final String MUL = "MUL";
	
	// GR x y z		x := (y > z) ? 1 : 0
	public static final String GREATER_THAN = "GR";
	
	// EQ x y z		x := (y == z) ? 1 : 0
	public static final String EQUAL = "EQ";

	// OR x y z		x := y || z
	public static final String OR = "OR";

	// MVP x y 		x := *y
	public static final String MVP = "MVP";

	// MVA x y		x := &y
	public static final String MVA = "MVA";

	// MV x y 		x := y
	public static final String MV = "MV"; 
	
	// BRF x L		si !x, salto a L
	public static final String BRANCH_FALSE = "BRF";
	
	// INL L		Insertar L
	public static final String LABEL = "INL";
	
	// BR L			Salto a L
	public static final String BRANCH = "BR";

//	STP x y			*x := y
	public static final String STP = "STP";
	
	public static final String GREATER_EQUAL = "GE";
	
	public static final String INCREMENT = "INC";
	
	public static final String CALL = "CALL";
	public static final String RET = "RET";
}
