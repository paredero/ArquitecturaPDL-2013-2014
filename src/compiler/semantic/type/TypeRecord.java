package compiler.semantic.type;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;

/**
 * Class for TypeRecord.
 */

// Include properties to characterize records

public class TypeRecord extends TypeBase {
	// Campos del registro
	private LinkedHashMap<String, SymbolIF> tablaCampos = new LinkedHashMap<String, SymbolIF>();

	/**
	 * Constructor for TypeRecord.
	 * 
	 * @param scope
	 *            The declaration scope.
	 */
	public TypeRecord(ScopeIF scope) {
		super(scope);
	}

	/**
	 * Constructor for TypeRecord.
	 * 
	 * @param scope
	 *            The declaration scope.
	 * @param name
	 *            The name of the type.
	 */
	public TypeRecord(ScopeIF scope, String name) {
		super(scope, name);
	}

	/**
	 * Constructor for TypeRecord.
	 * 
	 * @param record
	 *            The record to copy.
	 */
	public TypeRecord(TypeRecord record) {
		super(record.getScope(), record.getName());
	}

	/**
	 * Returns the size of the type.
	 * 
	 * @return the size of the type.
	 */
	@Override
	public int getSize() {
		int size = 0;
		for (SymbolIF tipo : tablaCampos.values()) {
			size += tipo.getType().getSize();
		}
		return size;
	}

	/**
	 * @return the tablaCampos
	 */
	public LinkedHashMap<String, SymbolIF> getTablaCampos() {
		return tablaCampos;
	}

	/**
	 * @param tablaCampos
	 *            the tablaCampos to set
	 */
	public void setTablaCampos(LinkedHashMap<String, SymbolIF> tablaCampos) {
		this.tablaCampos = tablaCampos;
	}

	public boolean containsCampo(String name) {
		return this.getTablaCampos().containsKey(name);
	}

	/**
	 * Añade un campo al registro
	 * 
	 * @param name
	 * @param simbolo
	 */
	public void addCampo(String nombre, SymbolIF tipo) {
		this.getTablaCampos().put(nombre, tipo);

	}

	public SymbolIF getCampo(String nombre) {
		return tablaCampos.get(nombre);
	}

	
	public int getDesplazamiento(String campo) {
		int desplazamiento = 0;
		boolean seguir = true;
		Iterator<Entry<String, SymbolIF>> itCampos = this.getTablaCampos()
				.entrySet().iterator();
		while (itCampos.hasNext() && seguir) {
			String campoEncontrado = itCampos.next().getKey();
			if (campoEncontrado.equalsIgnoreCase(campo)) {
				seguir = false;
			} else {
				desplazamiento++;
			}
		}
		return desplazamiento;
	}
}
