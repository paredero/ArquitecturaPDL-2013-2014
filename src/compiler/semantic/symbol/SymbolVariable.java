package compiler.semantic.symbol;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolVariable.
 */

// TODO: Student work
//       Include properties to characterize variables

public class SymbolVariable
    extends SymbolBase
{  
	private int address;
    /**
     * Constructor for SymbolVariable.
     * @param scope The declaration scope.
     * @param name The symbol name.
     * @param type The symbol type.
     */
    public SymbolVariable (ScopeIF scope, 
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
    
	private SymbolProcedure enclosingSymbol = null;
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
