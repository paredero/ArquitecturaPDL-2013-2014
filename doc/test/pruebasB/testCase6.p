//Comprobacion de paso de parametros

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
		
function resta (a : integer; b: integer) : integer;
begin
resta:=a;
end;	

function suma () : boolean;
begin
suma:=true;
end;

function prod (a : integer; b: boolean; c: integer) : ^integer;
var p:^integer;
begin
prod:=p;
end;
			
begin
	w := resta (f ,e);				//llamada ordinaria y tipo de retorno coincide
// 	x := resta (f ,b);				//llamada con diferente tipo
// 	x := resta (rr,f);				//llamada con diferente tipo
//	x := resta (f , g);				//llamada con parametro inexistente
	x := resta (f , f);				//llamada con la misma variable
//	x := resta (f, w, e);			//llamada con diferente número de params
//	x := resta ();					//llamada sin parametros
	b := suma ();					//llamada correcta
//	b := suma (f, e);				//llamada con params a una func sin params
//	x := prod (b, e, f);			//diferente orden de params, será error de tipos
//	x := suma ();					//tipo de retorno no coincide
//	b := prod(x, b, f);				//tipo de retorno no coincide
//	b := resta(f,e) or b;			//tipo de retorno no coincide
end.
