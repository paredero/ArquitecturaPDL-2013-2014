//Comprobacion de definiciones en contextos y sentencia devuelve

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
		
function resta (a : integer; b: integer) : integer;
var z: integer;
begin
	z:=a-b;			//referencias locales
  	resta:=a-b;		//referencia locales
  	z:=f-3;			//f es golbal
  	e:=4-z;			//e es global

end;	

function incrementa (x:integer):boolean ;				//anidada
const uno = 1;
var y,k :integer;

	function escribe (x:integer):^integer;
	var y :integer;
	begin
		y:=7-k;			//k está en incrementa
		x:=7-y;
		x:=e;			//e está en ppal
		e:=x;
//		bb:=7;			//bb no esta definida
		write(uno);
		escribe:=@x;	
	end;
	
begin
	x := w - uno;		//w está en el ppal
//	x:= fff;			//fff no está definida	
	incrementa:=true;
end;
{	
function resta2 (a : integer; b: integer) : integer;		//sin sentencia devuelve en 1r ambito
var z: integer;
begin
	z:=a-b;			//referencias locales
  	a:=a-b;			//referencia locales
end;
}
{
function incrementa2 (x:integer):boolean ;				//sin sentencia devuelve en 2do ambito
const uno = 1;
var y,k :integer;

	function escribe (x:integer):^integer;
	var y :integer;
	begin
		y:=7-k;
		x:=7-y;
	end;
	
begin
	incrementa2:=true;
end;
}			
begin
	w:=f-B;				//variables y ctes que han sido definidas
	rr.dni:= p^;		//idem
 	g := true; 			//idem
//  k := 6 ;			//k no definida
//	b:= x-9;			//x no esta definida

	write ("resultado:");
//  write(dd);			//dd no definida
//	write(g);			//write con un boolean
//	write(rr);			//write con una variable registro
	write(p);			//write con una variable puntero
	write(w-3);			//write expresion entera


end.


