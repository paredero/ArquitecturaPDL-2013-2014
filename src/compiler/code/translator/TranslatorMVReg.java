package compiler.code.translator;

import compiler.intermediate.Variable;
import compiler.semantic.symbol.SymbolVariable;
import compiler.semantic.type.TypeRecord;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorMVReg extends Translator {

	public TranslatorMVReg(QuadrupleIF quadruple) {
		super(quadruple);
	}

	// MOVE_REG tiene que sumar la direccion de var y el offset y almacenarla en
	// un registro.
	// despues alojar la variable temp en la direccion dada por dicho registro.
	@Override
	public String translate() {
		Variable var;

			String offset = traducirOperando(q.getFirstOperand());
			if (q.getSecondOperand() instanceof Variable) {

				var = (Variable) q.getSecondOperand();

				SymbolVariable s = (SymbolVariable) var.getSimbolo();
				// Sumo la direccion de la variable mas el desplazamiento para
				// obtener la dir del campo
				sb.append("ADD ")
						.append(offset)
						.append(", #")
						.append(var.getAddress())
						.append(" ;Sumo la direccion de la variable mas el desplazamiento para obtener la dir del campo")
						.append("\n");
				// Guardo el temporal en la direccion del campo
				sb.append("MOVE [.A], ").append(traducirOperando(q.getResult()))
						.append(" ;Guardo el campo en el temporal").append("\n");
			} else {				
				var = (Variable) q.getResult();
				SymbolVariable s = (SymbolVariable) var.getSimbolo();
				TypeRecord t = (TypeRecord) s.getType();
				sb.append(";Registro: ").append(t).append("\n");

				// Sumo la direccion de la variable mas el desplazamiento para
				// obtener la dir del campo
				sb.append("ADD ")
						.append(offset + ", #")
						.append(var.getAddress())
						.append(" ; Sumo la direccion de la variable mas el desplazamiento para obtener la dir del campo")
						.append("\n");
				// Guardo el temporal en la direccion del campo
				sb.append("MOVE ").append(traducirOperando(q.getSecondOperand()))
						.append(", [.A]")
						.append(" ;Guardo el temporal en la direccion del campo")
						.append("\n");
			}
		return sb.toString();
	}

}
