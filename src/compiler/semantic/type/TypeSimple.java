package compiler.semantic.type;

import compiler.CompilerContext;

import es.uned.lsi.compiler.code.ExecutionEnvironmentIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;

/**
 * Class for TypeSimple.
 */

// TODO: Student work
//       Include properties to characterize simple types

public class TypeSimple
    extends TypeBase
{
	public static String NUMERO = "INTEGER";
	public static String LOGICO = "BOOLEAN";
	public static String CADENA = "STRING";
    
    /**
     * Constructor for TypeSimple.
     * @param scope The declaration scope.
     */
    public TypeSimple (ScopeIF scope)
    {
        super (scope);
    }
    
    /**
     * Returns the size of the type.
     * @return the size of the type.
     */
    @Override
    public int getSize ()
    {
        ExecutionEnvironmentIF environment = CompilerContext.getExecutionEnvironment ();
        return environment.getTypeSize (this);
    }
}
