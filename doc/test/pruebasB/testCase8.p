//Comprobacion de tipos. Las referencias en el contexto estan declaradas 
//y coincide el tipo

program principal;
const	B = 3;
		ww = 67;		
type
	tipoPersona = record
			dni : integer;
			casado : boolean;
		end;
var
	p,q: ^integer;	
	rr: tipoPersona;
	w, f,e,a ,bo: integer;
	g, h, l, d: boolean;			
begin
	rr.dni:= p^;
	f :=3;
	e :=f-e;
	g := true; 
 	e := B - 6;
//  f := g;				//error de tipos
//  f := g -1;			//error en expresion
//  g := true or f;		//error en expresion
//	g := rr.dni;		//error de tipos
//	g := p;				//error de tipos
//	g := B or true;		//error de tipos
//	k := 5;				//variable no declarada
end.
