//funciones con llamadas a funcion en parametros

program prueba;

var
	a: integer;
	c, d: integer;
	//e, f: ^integer;
	//persona: tipoPersona;
	//x, y, z :boolean;	

function incrementa (x:integer):integer ;
const uno = 1;
begin
	x := x - uno;	
	incrementa:=x;
end;

function muchosParam(a, b, c, d, e, f: integer): integer;
begin
	muchosParam := f;
end;

function devuelve (a: integer): integer;
begin
	devuelve := a;
end;

function resta (a, b: integer): integer;
begin
	resta := a-b;
end;

function suma(a,b:integer):integer;
var temp :integer;
begin
	temp := 0 - a;
	b := b -temp;
	suma := b;
end;

// program
begin
	//writeln();
	//write(suma(10,10));
	//writeln();
	//write(resta(20,5));
	writeln();
	a := resta(suma(10,10),suma(8,8));
	write("Imprime (4): ");
	write(a);
	writeln();
	a := muchosParam(1, suma(0,1), 1, resta(4,3), 1, 1);
	write("Imprime (1): ");
	write(a);
	writeln();
	a := muchosParam(suma(suma(3,1),4), suma(resta(2,3), resta(3,2)), suma(resta(1,1),1), 4, 7,resta(suma(3,8),9));
	write("Imprime (2): ");
	write(a);
	writeln();
	//c := 50;
	//d := 100;
	//write("Resta 100 -50: ");
	//a:= resta (d, c);
	//writeln();
	//write(a);
	//writeln();
	//a := escribe(escribe(2));  	
end.
