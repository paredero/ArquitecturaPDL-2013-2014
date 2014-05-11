package compiler.semantic.type;

import java.util.HashMap;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;

/**
 * Class for TypeRecord.
 */

// TODO: Student work
//       Include properties to characterize records

public class TypeRecord
    extends TypeBase
{   
    // Campos del registro
    private HashMap<String, SymbolIF> tablaCampos = new HashMap<String, SymbolIF>(); 
       
    /**
     * Constructor for TypeRecord.
     * @param scope The declaration scope.
     */
    public TypeRecord (ScopeIF scope)
    {
        super (scope);
    }

    /**
     * Constructor for TypeRecord.
     * @param scope The declaration scope.
     * @param name The name of the type.
     */
    public TypeRecord (ScopeIF scope, String name)
    {   
        super (scope, name);
    }
   
    /**
     * Constructor for TypeRecord.
     * @param record The record to copy.
     */
    public TypeRecord (TypeRecord record)
    {
        super (record.getScope (), record.getName ());
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
	 * @return the tablaCampos
	 */
	public HashMap<String, SymbolIF> getTablaCampos() {
		return tablaCampos;
	}

	/**
	 * @param tablaCampos the tablaCampos to set
	 */
	public void setTablaCampos(HashMap<String, SymbolIF> tablaCampos) {
		this.tablaCampos = tablaCampos;
	}
    
    public boolean containsCampo (String name) {
        return this.getTablaCampos().containsKey(name);
    }
    
    /**
     * Añade un campo al registro
     * @param name
     * @param simbolo
     */
    public void addCampo(String nombre, SymbolIF tipo)
    {
        this.getTablaCampos().put(nombre, tipo);
    
    }
}
