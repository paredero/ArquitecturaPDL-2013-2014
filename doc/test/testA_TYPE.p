//Comprobacion de concordancia en referencias: registros

program principal;
	
type
	tipoPersona = record
			dni : integer;
			casado : boolean;
		end;
        unoAdiez = set of 1..10;
        dosAtres = set of 2..3;
        sieteAocho = set of 7..8;

var
	p,q: ^integer;	
	rr: tipoPersona;
	e: integer;
        c1,c2,c3,c4:unoAdiez;
        c5:sieteAocho;
begin
	rr.dni:= p^;
        rr.casado:= true;
        c5:=[7..7];         
        c1:= c2 + (c3 + c4);                
//        c1:=c5;                               // distinto tipo
//        c1 := c2 - c3;                          // operacion no permitida en conjuntos
//      unoAdiez:=[5..6];                       // el conjunto no ha sido definido
//	rr.pers:=3;				// campo inexistente
//	e.dni:=6;				// e no es tipo registro
//	ff.pers=7;				// ninguno de los dos existe

end.
