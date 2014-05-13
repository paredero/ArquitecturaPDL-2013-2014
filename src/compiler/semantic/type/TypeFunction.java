package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for TypeFunction.
 */

// TODO: Student work
//       Include properties to characterize function declarations

public class TypeFunction
    extends TypeProcedure
{   
	private TypeIF tipoResultado;
	/**
     * Constructor for TypeFunction.
     * @param scope The declaration scope.
     */
    public TypeFunction (ScopeIF scope)
    {
        super (scope);
    }

    /**
     * Constructor for TypeFunction.
     * @param scope The declaration scope
     * @param name The name of the function.
     */
    public TypeFunction (ScopeIF scope, String name)
    {
        super (scope, name);
    }
    
    /**
     * Returns the size of the type.
     * @return the size of the type.
     */
    @Override
    public int getSize ()
    {
        // TODO: Student work
        return 1;
    }

	/**
	 * @return the tipoResultado
	 */
	public TypeIF getTipoResultado() {
		return tipoResultado;
	}

	/**
	 * @param tipoResultado the tipoResultado to set
	 */
	public void setTipoResultado(TypeIF tipoResultado) {
		this.tipoResultado = tipoResultado;
	}
}
