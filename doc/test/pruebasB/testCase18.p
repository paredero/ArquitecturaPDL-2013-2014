//llamadas a funciones sin recursividad

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
	a, b: integer;
	//c, d: integer;
	//e, f: ^integer;
	//persona: tipoPersona;
	x, y, z :boolean;	

function incrementa (x:integer):integer ;				//anidada
const uno = 1;
var y :integer;

	function escribe (x:integer):integer;
	var z:integer;
	begin
		//if (true) then
			//write(x);
		write("Paso por la funcion escribe.Imprime (parametro): ");
		write(x);
		writeln();
		escribe:= 1000;
	end;
	
begin
	write("Primera llamada a escribe con x=5.");
	writeln();
	y:=escribe(5);
	write("Imprime el valor devuelto de escribe (1000): ");
	write(y);
	writeln();
	write("Segunda llamada a escribe con x=parametro de incrementa.");
	writeln();
	//if (true) then
		//write(x);
	y := escribe(x);
	//esto es para ver que los parametros van por valor
	x := x - uno;	
	incrementa:=x;
end;

function resta (a, b, c, d : integer): integer;
var j:integer;
begin	
	write("write que escribe una expresion write(a-b-c-d) (-8): ");
	write(a-b-c-d);
	writeln();
	resta:=d;
end;

function bool (f: integer): boolean;
//var j:integer;
begin	
	bool:=true;
end;

// program
begin
	writeln();
	writeln();
	a := 10;
	b := incrementa(a);
	write("Llamada a incrementa con 10 (por valor) debe devolver(9): ");
	write(b);
	writeln();
	write("Y la variable debe continuar con el valor original (10): ");
	write(a);
	writeln();
	x := false or bool(10);
	if (x) then
		begin
  		write("Imprime si una funcion ha devuelto bien un boolean.");
  		writeln();
  		end;
  	a := resta(1, 2, 3, 4)-7;
  	write("Imprime el valor devuelto por por una funcion (-3): ");
  	write(a);
  	writeln();
  	//x := false or bool(a);
  	//write("resultado:");
  	//write(a);
  	writeln();  	
  	//write(y);
  	//write(x);
  	//write(persona.dni);
end.
