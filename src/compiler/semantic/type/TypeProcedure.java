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
   private List<TypeIF> tipoParametro;

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
	public List<TypeIF> getTipoParametro() {
		return tipoParametro;
	}

	/**
	 * @param tipoParametro the tipoParametro to set
	 */
	public void setTipoParametro(List<TypeIF> tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

	public void addTipoParametro(TypeIF tipoParametro) {
		if (this.tipoParametro == null) {
			this.tipoParametro = new ArrayList<TypeIF>();
		}
		this.tipoParametro.add(tipoParametro);
	}
}
