package compiler.semantic.type;

import java.util.ArrayList;
import java.util.List;

import compiler.semantic.symbol.SymbolParameter;

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
   protected List<SymbolParameter> parametros;

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
		return tipoParametros != null? tipoParametros:new ArrayList<TypeIF>();
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

	/**
	 * @return the parametros
	 */
	public List<SymbolParameter> getParametros() {
		return parametros;
	}

	/**
	 * @param parametros the parametros to set
	 */
	public void setParametros(List<SymbolParameter> parametros) {
		this.parametros = parametros;
	}
	
	
	public void addParametro(SymbolParameter parametro) {
		if (this.parametros == null) {
			this.parametros = new ArrayList<SymbolParameter>();
		}
		this.parametros.add(parametro);
	}
}
