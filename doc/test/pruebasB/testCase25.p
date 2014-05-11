//Referencias a variables definidas en otros ambitos

program prueba;
const C = 1;
uno = 1;

type
	tipoPersona = record
			dni : integer;
			casado : boolean;
			c1 : integer;
		end;
	
var
	a0, b5, c2, t: integer;
	//c, d: integer;
	e, f: ^integer;
	persona: tipoPersona;
	x, y, z :boolean;	

function nivel1 (x:integer):integer ;				//anidada
const uno = 1;
var a1, b1 :integer;

	function nivel2 (x:integer):integer;
	var a2, t:integer;
		function nivel3 (a:integer):integer;
		var a3 : integer;
		begin
			a3 := 100;
			a2 := 100;
			a1 := 100;
			a0 := 100;
			writeln();
			write("Paso por nivel 3");
			writeln();
			nivel3 := 0;
		end;
	begin
		t := nivel3(2);
		write("Paso por nivel 2");
		writeln();
		write("Imprime valor asignado en nivel 3 (100): ");
		write(a2);
		writeln();
		b5 := 15;
		b1 := 8;
		nivel2:= 1000;
	end;
	
begin
	t := nivel2(2);
	write("Paso por nivel 1");
	writeln();
	write("Imprime valor asignado en nivel 3 (100): ");
	write(a1);
	writeln();
	write("Imprime valor asignado en nivel 2 (8): ");
	write(b1);
	writeln();
	c2 := 90;
	nivel1:= 1000;
end;

// program
begin
	writeln();
	writeln();
	t := nivel1(2);
	write("Paso por nivel 0");
	writeln();
	write("Imprime valor asignado en nivel 3 (100): ");
	write(a0);
	writeln();
	write("Imprime valor asignado en nivel 2 (15): ");
	write(b5);
	writeln();
	write("Imprime valor asignado en nivel 1 (90): ");
	write(c2);
	writeln();
end.