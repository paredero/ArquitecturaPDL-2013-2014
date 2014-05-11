//Definicion de Procedimientos
program principal;

const  	B = 3;
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

		
procedure resta (a : integer; b: integer);			//normal
var z: integer;
begin
	z:=a-f;
  	z:=a-b;	

end;	

procedure incrementa (x:integer);				//anidado
const uno = 1;
var y :integer;

	procedure escribe (x:integer);
	var z:integer;
	begin
		write(z);		
	end;
	
begin
	x := x - uno;		
end;



procedure ambitos (x:integer) ;		//con los mismas definiciones en diferentes ambitos
const uno = 1;						//Usando variables de su ambito
type
	Persona = record
			dni : integer;
			casado : boolean;			
		end;
var y :integer;
	pers : Persona;
	p:^integer;
	
	procedure escribe (x:integer);
		const uno = 1;
		type
			Persona = record
				dni : integer;
				casado : boolean;			
			end;
		var y :integer;
			pers : Persona;
			p:^integer;
	begin
		write(x);
		pers.dni:=5;
		y:=7;		
	end;
	
begin
	x := x - uno;	
	pers.dni:=5;
	y:=7;	
end;


procedure prueba (x:integer);		//Usando parametros de otros ambitos
const uno = 1;
var y,z :integer;
	procedure escribe (x:integer);
	begin
		z:=y-6;
		x:=uno-7;
		write(x);
	end;
	
begin
	x := x - uno;	
end;


procedure suma (q,w,r : integer; t,y,u,i: boolean);		//parametros seguidos
begin
  w:=q-r;
  t:=u or y;
end;


{
procedure resta (a : integer; b: integer);			//procedure repetido
begin
  a:=a-b;
end;
}	

{
procedure resta (a : integer; a: integer);			//procedure con parametros repetidos
begin
  a:=a-b;
end;
}		
{
procedure erronea1 (x:integer);		//Usando parametros indebidamente
const uno = 1;								//da error de variable no definida
type
	Persona = record
			dni : integer;
			casado : boolean;			
		end;
var y :integer;
	pers : Persona;
	p:^integer;
	
	procedure erronea2 (k:integer);
		
	begin
		write(k);
	end;
	
begin
	x := k - uno;	
end;
}		
begin
end.

