//Comprobacion de paso de parametros en procedimientos

program principal;

	type
		tipoPersona = record
			dni : integer;
			casado : boolean;
		end;
	var
		x, w,e,f: integer;
		b,c,d:boolean;	
		rr: tipoPersona;	
		p,q : ^integer;
		
procedure resta (a : integer; b: integer);
begin
end;	

procedure suma ();
begin
end;

procedure prod (a : integer; b: boolean; c: integer) ;
begin
end;
			
begin
	resta (f ,e);				//llamada ordinaria
// 	resta (f ,b);				//llamada con diferente tipo
// 	resta (rr,f);				//llamada con diferente tipo
//	resta (f , g);				//llamada con parametro inexistente
	resta (f , f);				//llamada con la misma variable
//	resta (f, w, e);			//llamada con diferente número de params
//	resta ();					//llamada sin parametros
	suma ();					//llamada correcta
//	suma (f, e);				//llamada con params a un proc sin params
//	prod (b, e, f);			//diferente orden de params, será error de tipos

end.
