//sentencias complejas de registro
program registros2;

type
	tipoPersona = record
			dni : integer;
			casado : boolean;
			c1 : integer;
		end;
	
var
	a: integer;
	//c, d: integer;
	//e, f: ^integer;
	persona: tipoPersona;
	//x, y, z :boolean;	

function suma(a:integer; b:boolean):integer;
begin
	write("Parametro a (-2): ");
	write(a);
	writeln();
	if (b) then
		begin
		write("Imprime parametro b.");
		writeln();
		end;
	suma:=100-a;
end;

// program
begin
	writeln();
	persona.dni := 3;
	persona.c1 := 5;
	persona.casado := true;
	write("Imprime persona.dni(3): ");
	write(persona.dni);
	writeln();
	a := 9 - persona.dni - 5;
	write("Imprime 9 - persona.dni - 5 (1): ");
	write(a);
	writeln();
	
        persona.dni := persona.c1;
        write("Imprime asignacion persona.dni := persona.c1 (5): ");
	write(persona.dni);
	writeln();
	persona.dni := persona.c1-persona.dni-2;
	write("Imprime asignacion persona.dni := persona.c1-persona.dni (-2): ");
	write(persona.dni);
	writeln();
	if (persona.casado) then
		begin
		write("Imprime persona.casado:");
		writeln();
		end;
	if (false or persona.casado) then
		begin
		write("Imprime false or persona.casado:");
		writeln();
		end;

	a:= suma(persona.dni, persona.casado);
	write("Imprime campos pasados como argumento(102): ");
	write(a);
	writeln();  	
  	
end.