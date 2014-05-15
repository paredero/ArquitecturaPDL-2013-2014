package compiler.semantic.type;

import java.util.ArrayList;
import java.util.List;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for TypeProcedure.
 */

// TODO: Student work
//       Include properties to characterize procedure declarations

public class TypeProcedure
    extends TypeBase
{   
	// Almacena el listado de parametros
   private List<TypeIF> tipoParametros;

/**
     * Constructor for TypeProcedure.
     * @param scope The declaration scope.
     */
    public TypeProcedure (ScopeIF scope)
    {
        super (scope);
    }

    /**
     * Constructor for TypeProcedure.
     * @param scope The declaration scope
     * @param name The name of the procedure.
     */
    public TypeProcedure (ScopeIF scope, String name)
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
	 * @return the tipoParametro
	 */
	public List<TypeIF> getTipoParametros() {
		return tipoParametros;
	}

	/**
	 * @param tipoParametro the tipoParametro to set
	 */
	public void setTipoParametros(List<TypeIF> tipoParametros) {
		this.tipoParametros = tipoParametros;
	}

	public void addTipoParametro(TypeIF tipoParametro) {
		if (this.tipoParametros == null) {
			this.tipoParametros = new ArrayList<TypeIF>();
		}
		this.tipoParametros.add(tipoParametro);
	}
}
