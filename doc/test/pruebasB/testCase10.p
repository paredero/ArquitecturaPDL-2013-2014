//Comprobacion de definiciones en contextos

program principal;

const  B = 3;
		
type
	tipoPersona = record
			dni : integer;
			casado : boolean;
		end;

var
	p,q: ^integer;	
	rr: tipoPersona;		//tipo que si existe
	w, f,e,a ,bo: integer;
	g, h, l, d: boolean;
	//s: tipoN;				//tipo que no existe
		
procedure resta (a : integer; b: integer);
var z: integer;
begin
	z:=a-b;			//referencias locales
  	a:=a-b;			//referencia locales
  	z:=f-3;			//f es golbal
  	e:=4-z;			//e es global

end;	

procedure incrementa (x:integer);				//anidada
const uno = 1;
var y,k :integer;

	procedure escribe (x:integer);
	var y :integer;
	begin
		y:=7-k;			//k está en incrementa
		x:=7-y;
		x:=e;			//e está en ppal
		e:=x;
//		bb:=7;			//bb no esta definida
		write(uno);			
	end;
	
begin
	x := w - uno;		//w está en el ppal
//	x:= fff;			//fff no está definida		
end;
				
begin
	w:=f-B;				//variables y ctes que han sido definidas
	rr.dni:= p^;		//idem
 	g := true; 			//idem
//  k := 6 ;			//k no definida
//	b:= x-9;			//x no esta definida

	write ("resultado:");
//  write(u);			//u no definida


end.


