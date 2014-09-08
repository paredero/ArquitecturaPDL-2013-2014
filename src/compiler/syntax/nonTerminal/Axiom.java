package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.intermediate.LabelIF;


/**
 * Abstract Class for Axiom non terminal.
 */
public class Axiom
    extends NonTerminal
{
	private LabelIF label;
    /**
     * Constructor for Axiom.
     */
    public Axiom ()
    {
        super (); 
    }
	/**
	 * @return the label
	 */
	public LabelIF getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(LabelIF label) {
		this.label = label;
	}
	
       
    
}
