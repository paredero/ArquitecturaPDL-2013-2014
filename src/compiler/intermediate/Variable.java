package compiler.intermediate;

import compiler.semantic.symbol.SymbolParameter;
import compiler.semantic.symbol.SymbolVariable;

import es.uned.lsi.compiler.intermediate.VariableIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;

/**
 * Class for variables in intermediate code.
 */

public class Variable
    implements VariableIF 
{
    private String  name     = null;
    private ScopeIF scope    = null;
    private boolean isParameter = false;
    private SymbolIF simbolo = null;
    // Para calcular el desplazamiento de un campo de un registro
    private int desplazamiento = 0;
        
    /**
	 * @return the simbolo
	 */
	public SymbolIF getSimbolo() {
		return simbolo;
	}

	/**
	 * @param simbolo the simbolo to set
	 */
	public void setSimbolo(SymbolIF simbolo) {
		this.simbolo = simbolo;
	}

	/**
     * Constructor for Variable.
     * @param name The name.
     * @param scope The scope index.
     */
    public Variable(String name, ScopeIF scope)
    {
        super ();
        this.name = name;
        this.scope = scope;
        this.simbolo = scope.getSymbolTable().getSymbol(name);
    }

    public Variable(String name, SymbolIF simbolo) {
    	super ();
        this.name = name;
        this.simbolo = simbolo;
        this.scope = simbolo.getScope();  
	}

	/**
     * Returns the name.
     * @return Returns the name.
     */
    @Override
    public final String getName ()
    {
        return name;
    }

    /**
     * Returns the scope.
     * @return Returns the scope.
     */
    @Override
    public final ScopeIF getScope ()
    {
        return scope;
    }

    /**
     * Returns the address.
     * @return Returns the address.
     */
    @Override
    public final int getAddress ()
    {
    	if (simbolo instanceof SymbolVariable) {
    		return ((SymbolVariable) simbolo).getAddress();
    	} else {
    		return ((SymbolParameter) simbolo).getAddress();
    	}
        
    }

    /**
     * Indicates whether the address is a global address.
     * @return true if the address is a global address.
     */
    @Override
    public final boolean isGlobal ()
    {
        return scope.getLevel() == 0;
    }

    /**
     * Compares this object with another one.
     * @param other the other object.
     * @return true if both objects has the same properties.
     */
    @Override
    public final boolean equals (Object other)
    {
        if (other == null) 
        {
            return false;
        }
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof Variable))
        {
            return false;
        }
        
        final Variable aVariable = (Variable) other;
        return ((scope   == null) ? (aVariable.scope == null) : (aVariable.scope.equals (scope))) && 
               ((name    == null) ? (aVariable.name  == null) : (aVariable.name.equals (name)));
    }

    /**
     * Returns a hash code for the object.
     */
    @Override
    public final int hashCode ()
    {
        return 31 * scope.hashCode() +
                  ((name == null)? 0 : name.hashCode ());
    } 





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Variable [name=" + name + ", scope=" + scope.getLevel() + ", isParameter="
				+ isParameter + ", desplazamiento="
				+ desplazamiento + "]";
	}

	/**
	 * @return the isParameter
	 */
	public boolean isParameter() {
		return isParameter;
	}

	/**
	 * @param isParameter the isParameter to set
	 */
	public void setParameter(boolean isParameter) {
		this.isParameter = isParameter;
	}

	/**
	 * @return the desplazamiento
	 */
	public int getDesplazamiento() {
		return desplazamiento;
	}

	/**
	 * @param desplazamiento the desplazamiento to set
	 */
	public void setDesplazamiento(int desplazamiento) {
		this.desplazamiento = desplazamiento;
	}

	
    
}
