//llamada a funcion

program prueba;

const B = 1;
uno = 1;

var
	a: integer;
	//c, d: integer;
	x, y, z :boolean;	

function resta (a, b, c, d : integer): integer;
var j:integer;
begin
	writeln();
	resta:=d;
end;

// program
begin
	writeln();
	writeln();
	//a := resta (1-2-2-3-4, 2, 3, 4);	
  	a := resta(1-2-3, 2, resta(1,1,1,1), 4);
  	write("Valor devuelto de una funcion con muchos parametros (4): ");
  	write(a);
  	writeln();
end.
