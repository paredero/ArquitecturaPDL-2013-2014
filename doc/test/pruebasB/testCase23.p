//sentencias if y for
program principal;
var a, b: integer;

//se permite poner como variable contador de un for, un parametro de una funcion, se ignora el valor del
//parametro y se inicializa el parametro con el valor de asignacion del for

function resta (a: integer): integer;
var j:integer;
begin
	for (a:=0 to 10) do
 	begin
 		writeln(); 		
 		a:=10;
 	end;
  resta:=a;
end;

begin

writeln();
for (a:=0 to 5) do
	begin
		writeln();
		write("Escribe 6 veces (conatador bucle): ");
		write(a);
	end;
	
for (a:=0 to 5) do
	begin
		writeln();
		write("Escribe solo una vez, se modifica contador.");
		a := 5;
	end;
	
writeln();
  if (4>5) then
  	write("Escribe que 4>5");
  else
  	write("Escribe que NO 4>5.");
  	
 writeln();
 b := 10; 
 for (a:=0 to 5) do
 	b:=b-1;
 	
 writeln();
 write("b al final del bucle debe valer (4): ");
 write(b);
 b:=2;
 writeln();
 write("b despues de la asignacion debe valer (2): ");
 write(b);
 
 writeln();
   if (4>5) then
   	begin
   	b:= 2;
  	write("Escribe que 4>5");
  	end;
  else
  	begin
  	b:=4;
  	write("Escribe que NO 4>5.");
  	end; 
a := resta(8);

end.