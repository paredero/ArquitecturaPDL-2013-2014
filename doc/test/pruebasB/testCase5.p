//Comprobacion de concordancia en referencias: registros

program principal;
	
type
	tipoPersona = record
			dni : integer;
			casado : boolean;
		end;

var
	p,q: ^integer;	
	rr: tipoPersona;
	e: integer;
				
begin
	rr.dni:= p^;
	rr.casado:= true;
//	rr.pers:=3;				//campo inexistente
//	e.dni:=6;				//e no es tipo registro
//	ff.pers=7;				//ninguno de los dos existe

end.
