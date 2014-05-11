package compiler.syntax.nonTerminal;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gemma
 */


import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class CampoRegistro extends NonTerminal {

    private String nombre;
    private Integer linea;
    private Integer columna;
    private TypeIF tipo;
    private SymbolIF simbolo;
    private Integer despl;

    public CampoRegistro() {
    }

    public CampoRegistro(String nombre, Integer linea, Integer columna, SymbolIF simbolo) {
        this.nombre = nombre;
        this.linea = linea;
        this.columna = columna;
        this.simbolo= simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }
    public TypeIF getTipo() {
        return tipo;
    }

    public void setTipo(TypeIF tipo) {
        this.tipo = tipo;
    }
    public SymbolIF getSymbol() {
        return simbolo;
    }

    public void setSymbol(SymbolIF simbolo) {
        this.simbolo = simbolo;
    }
    
    public Integer getDesplazamiento() {
        return despl;
    }

    public void setDesplazamiento(Integer despl) {
        this.despl = despl;
    }


    @Override
    public String toString() {
        return "Nom:"+this.getNombre() + "; Lin:" + this.getLinea() + "; Col:" + this.getColumna();
    }

    
}
