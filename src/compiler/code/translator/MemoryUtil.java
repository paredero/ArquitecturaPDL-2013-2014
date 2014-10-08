package compiler.code.translator;

import java.util.ArrayList;
import java.util.List;

import compiler.CompilerContext;
import compiler.intermediate.Temporal;
import compiler.semantic.symbol.SymbolParameter;
import compiler.semantic.symbol.SymbolVariable;

import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;

public class MemoryUtil {

	private static int gAddress = 0;
	private static List<Integer> sizeOfScopes = new ArrayList<Integer>();

	/**
	 * @return the gAddress
	 */
	public static int getgAddress() {
		return gAddress;
	}

	/**
	 * @param gAddress
	 *            the gAddress to set
	 */
	public static void setgAddress(int gAddress) {
		MemoryUtil.gAddress = gAddress;
	}

	public static void asignarDirecciones() {
		int lOffset = 0;
		int parameterOffset = 0;
		List<ScopeIF> scopes = CompilerContext.getScopeManager().getAllScopes();
		for (ScopeIF scope : scopes) {
			List<SymbolIF> symbols = scope.getSymbolTable().getSymbols();
			CompilerContext.getSemanticErrorManager().semanticDebug(
					"Símbolos: " + symbols);
			for (SymbolIF s : symbols) {
				if (s instanceof SymbolVariable) {
					SymbolVariable symbol = (SymbolVariable) s;

					if (scope.getLevel() == 0) {
						symbol.setAddress(gAddress);
						gAddress += symbol.getType().getSize();
						CompilerContext.getSemanticErrorManager()
								.semanticDebug(
										"Simbolo " + symbol + " Direccion: "
												+ gAddress);
					} else {
						symbol.setAddress(lOffset + symbol.getType().getSize());
						lOffset += symbol.getType().getSize();
						CompilerContext.getSemanticErrorManager()
								.semanticDebug(
										"Simbolo " + symbol + " Offset: "
												+ lOffset);
					}
				} else if (s instanceof SymbolParameter) {
					SymbolParameter symbol = (SymbolParameter) s;
					symbol.setAddress(parameterOffset
							+ symbol.getType().getSize());
					parameterOffset += symbol.getType().getSize();
					CompilerContext.getSemanticErrorManager().semanticDebug(
							"PArametro " + symbol + " parameterOffset: "
									+ parameterOffset);
				}
			}
			List<TemporalIF> temporals = scope.getTemporalTable()
					.getTemporals();
			for (TemporalIF t : temporals) {
				Temporal temp = (Temporal) t;
				t.setAddress(lOffset + temp.getSize());
				lOffset += temp.getSize();
			}
			// Registrar el tamaño que ocupan las variables y temporales en cada
			// ambito.
			sizeOfScopes.add(lOffset);
			lOffset = 0;
			parameterOffset = 0;
		}
	}

	/**
	 * Si el nivel del ámbito es mayor a los registrados por MemoryManager,
	 * devuelve el tamaño del últimoámbito registrado, ya que se trata de una
	 * llamada recursiva.
	 * 
	 * @param levelOfScope
	 * @return
	 */
	public static int getSizeOfScope(int levelOfScope) {
		// El número de elementos de sizeOfScopes es el número de ámbitos
		// registrados.
		if (levelOfScope >= sizeOfScopes.size()) {
			return sizeOfScopes.get(sizeOfScopes.size() - 1);
		}
		return sizeOfScopes.get(levelOfScope);
	}

}
