//Definicion de Funciones
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

		
function resta (a : integer; b: tipoPersona) : integer;			//normal
var z: integer;
begin
	z:=a-f;
  	resta:=a-f;	

end;	

function incrementa (x:integer):boolean ;				//anidada
const uno = 1;
var y :integer;

	function escribe (x:integer):^integer;
	var z:integer;
	begin
		write(z);
		escribe:= @x;
	end;
	
begin
	x := x - uno;	
	incrementa:=true;
end;



function ambitos (x:integer):integer ;		//con los mismas definiciones en diferentes ambitos
const uno = 1;								//Usando variables de su ambito
type
	Persona = record
			dni : integer;
			casado : boolean;			
		end;
var y :integer;
	pers : Persona;
	p:^integer;
	
	function escribe (x:integer):integer ;
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
		escribe:=2;
	end;
	
begin
	x := x - uno;	
	pers.dni:=5;
	y:=7;
	ambitos :=8;
end;


function prueba (x:integer):^integer ;		//Usando parametros de otros ambitos
const uno = 1;
var y,z :integer;
	function escribe (x:integer):integer ;
	begin
		z:=y-6;
		escribe:=uno-7;
		write(x);
	end;
	
begin
	x := x - uno;
	prueba := @x;
end;


function suma (q,w,r : integer; t,y,u,i: boolean) : integer;		//parametros seguidos
begin
  suma:=q-r;
  t:=u or y;
end;


{
function resta (a : integer; b: integer) : integer;			//funcion repetida
begin
  resta:=a-b;
end;
}	

{
function resta (a : integer; a: integer) : integer;			//funcion con parametros repetidos
begin
  resta:=a-b;
end;
}		
{
function erronea1 (x:integer):integer ;		//Usando parametros indebidamente
const uno = 1;								//da error de variable no definida
type
	Persona = record
			dni : integer;
			casado : boolean;			
		end;
var y :integer;
	pers : Persona;
	p:^integer;
	
	function erronea2 (k:integer):integer ;		
	begin
		write(k);
		erronea2:=1;
	end;
	
begin
	x := k - uno;
	erronea1:=1;	
end;
}		
{
function resta2 (x:integer):^integer ;		//Error: una variable se llama igual que la funcion
const uno = 1;
var y,resta2 :integer;
begin
	x := x - uno;
	resta2 := @x;
end;
}
begin
e:=3;
end.

