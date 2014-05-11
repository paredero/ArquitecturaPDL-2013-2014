//funciones con f(a) + f(b)
program prueba;
const C4 = 1;
uno = 1;

type
	tipoPersona = record
			dni : integer;
			casado : boolean;
			c1 : integer;
		end;
	
var
	a, b, c, t: integer;
	//c, d: integer;
	// e, f: ^integer;
        e: ^integer;
	persona: tipoPersona;
	x, y, z :boolean;	

function f (x:integer):integer ;				//anidada
const uno = 1;
var a1, b1 :integer;	
begin
	write("Paso por la funcion.");
	writeln();	
	a1 := 90;
	f:= 100;
end;

// program
begin
	writeln();
	a := f(1)-200;
	write("Llamada f(1)-200 (-100): ");
	write(a);
	writeln();
	a := f(1)-f(1)-f(1);
	write("Llamada a f()-f()-f() (-100): ");
	write(a);
	writeln();
end.