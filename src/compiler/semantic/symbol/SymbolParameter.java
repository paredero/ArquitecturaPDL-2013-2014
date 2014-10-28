package compiler.semantic.symbol;

import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolVariable.
 */

// TODO: Student work
//       Include properties to characterize parameters

public class SymbolParameter
    extends SymbolBase
{  
   int address;
   TemporalIF temporal;
   private SymbolProcedure enclosingSymbol = null;
    /**
     * Constructor for SymbolParameter.
     * @param scope The declaration scope.
     * @param name The symbol name.
     * @param type The symbol type.
     */
    public SymbolParameter (ScopeIF scope, 
                           String name,
                           TypeIF type)
    {
        super (scope, name, type);
    }



	/**
	 * @return the address
	 */
	public int getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(int address) {
		this.address = address;
	}



	/**
	 * @return the temporal
	 */
	public TemporalIF getTemporal() {
		return temporal;
	}

	/**
	 * @param temporal the temporal to set
	 */
	public void setTemporal(TemporalIF temporal) {
		this.temporal = temporal;
	}



	/**
	 * @return the enclosingSymbol
	 */
	public SymbolProcedure getEnclosingSymbol() {
		return enclosingSymbol;
	}



	/**
	 * @param enclosingSymbol the enclosingSymbol to set
	 */
	public void setEnclosingSymbol(SymbolProcedure enclosingSymbol) {
		this.enclosingSymbol = enclosingSymbol;
	} 

	
}
