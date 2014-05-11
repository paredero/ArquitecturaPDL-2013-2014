//Comprobacion de concordancia en referencias: registros

program registros;
	
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
//	rr.dni:= p^;
//	rr.casado:= true;
//	rr.pers:=3;				//campo inexistente
	// e.dni:=6;				//e no es tipo registro
//	ff.pers=7;				//ninguno de los dos existe
        e:=rr.dni;
        rr.dni:=3;
        writeln();
        write("Valor de rr.dni (3): ");
        write(rr.dni);
end.
