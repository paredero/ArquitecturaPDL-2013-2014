package compiler.syntax.nonTerminal;

import compiler.CompilerContext;
import compiler.intermediate.InstructionSet;
import compiler.intermediate.Procedure;

import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.semantic.ScopeIF;

public class DeclaracionSubprograma extends NonTerminal {

	private String nombre;
	Declaraciones declaraciones;
	private CuerpoFuncion cuerpoFuncion;
	private Cuerpo cuerpoProcedimiento;
	public DeclaracionSubprograma(String nombre, Declaraciones declaraciones,
			CuerpoFuncion cf) {
		this.nombre = nombre;
		this.declaraciones = declaraciones;
		this.cuerpoFuncion = cf;
	}
	
	public DeclaracionSubprograma(String nombre, Declaraciones declaraciones,
			Cuerpo cp) {
		this.nombre = nombre;
		this.declaraciones = declaraciones;
		this.cuerpoProcedimiento = cp;
	}

	public void generarCodigoIntermedio() {
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
        Procedure sub = new Procedure(nombre, scope);
        IntermediateCodeBuilder cb = new IntermediateCodeBuilder(scope);
        if (declaraciones != null) {
        	cb.addQuadruples(declaraciones.getIntermediateCode());
        }
        cb.addQuadruple(InstructionSet.LABEL, sub.getCodeLabel(), scope.getLevel());
        if (cuerpoFuncion != null) {
        	CompilerContext.getSemanticErrorManager().semanticDebug("/////////////Declaracion de funcion" +  sub.getCodeLabel());
        	cb.addQuadruples(cuerpoFuncion.getIntermediateCode());
        	CompilerContext.getSemanticErrorManager().semanticDebug("/////////////"+cuerpoFuncion);
        	cb.addQuadruple(InstructionSet.RET);
        } else {
        	CompilerContext.getSemanticErrorManager().semanticDebug("Procedimiento " + cuerpoProcedimiento);
        	cb.addQuadruples(cuerpoProcedimiento.getIntermediateCode());
        }
        this.setIntermediateCode(cb.create());
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the declaraciones
	 */
	public Declaraciones getDeclaraciones() {
		return declaraciones;
	}

	/**
	 * @param declaraciones the declaraciones to set
	 */
	public void setDeclaraciones(Declaraciones declaraciones) {
		this.declaraciones = declaraciones;
	}

	/**
	 * @return the cuerpoFuncion
	 */
	public CuerpoFuncion getCuerpoFuncion() {
		return cuerpoFuncion;
	}

	/**
	 * @param cuerpoFuncion the cuerpoFuncion to set
	 */
	public void setCuerpoFuncion(CuerpoFuncion cuerpoFuncion) {
		this.cuerpoFuncion = cuerpoFuncion;
	}

	/**
	 * @return the cuerpoProcedimiento
	 */
	public Cuerpo getCuerpoProcedimiento() {
		return cuerpoProcedimiento;
	}

	/**
	 * @param cuerpoProcedimiento the cuerpoProcedimiento to set
	 */
	public void setCuerpoProcedimiento(Cuerpo cuerpoProcedimiento) {
		this.cuerpoProcedimiento = cuerpoProcedimiento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeclaracionSubprograma [nombre=" + nombre + ", declaraciones="
				+ declaraciones + ", cuerpoFuncion=" + cuerpoFuncion
				+ ", cuerpoProcedimiento=" + cuerpoProcedimiento + "]";
	}

	
	
}
