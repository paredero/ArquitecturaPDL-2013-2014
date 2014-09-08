package compiler.syntax.nonTerminal;

public class Declaraciones extends NonTerminal {

	/**
	 * 
	 */
	public Declaraciones() {
		super();
	}

	public Declaraciones(Declaraciones declaraciones) {
		this();
		this.setIntermediateCode(declaraciones.getIntermediateCode());
	}

	public Declaraciones addDeclaracion(Declaraciones declaraciones) {
		if (declaraciones != null) {
			if (this.getIntermediateCode() != null){
			this.getIntermediateCode().addAll(0,
					declaraciones.getIntermediateCode());
			} else {
				this.setIntermediateCode(declaraciones.getIntermediateCode());
			}
		}
		return this;
	}

	public Declaraciones addDeclaracionSubprograma(
			DeclaracionSubprograma declaracionSubprograma) {
		this.getIntermediateCode().addAll(0,
				declaracionSubprograma.getIntermediateCode());
		return this;
	}
}
