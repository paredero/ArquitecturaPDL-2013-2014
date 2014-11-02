package compiler.semantic.symbol;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolProcedure.
 */

// TODO: Student work
//       Include properties to characterize procedure calls

public class SymbolProcedure
    extends SymbolBase
{
	private short size;
	private short varTempSize;
    /**
     * Constructor for SymbolProcedure.
     * @param scope The declaration scope.
     * @param name The symbol name.
     * @param type The symbol type.
     */
    public SymbolProcedure (ScopeIF scope, 
                            String name,
                            TypeIF type)
    {
        super (scope, name, type);
    }
	/**
	 * @return the size
	 */
	public short getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(short size) {
		this.size = size;
	}
	public void addToSize(int i) {
		this.size+=i;
	}
	
	public void incSize() {
		this.size++;
	}
	/**
	 * @return the varTempSize
	 */
	public short getVarTempSize() {
		return varTempSize;
	}
	/**
	 * @param varTempSize the varTempSize to set
	 */
	public void setVarTempSize(short varTempSize) {
		this.varTempSize = varTempSize;
	}
   
	public int getParamSize() {
		return this.getSize() - this.varTempSize;
	}
	public void addToVarTempSize(int i) {
		this.varTempSize+=i;
	}
	
	public void incVarTempSize() {
		this.varTempSize++;
	}
}
