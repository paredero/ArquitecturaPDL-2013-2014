program principal;

var a: integer;

function suma(a,b:integer):integer;
var temp :integer;
begin
	temp := 0 - a;
	b := b -temp;
	suma := b;
end;

function multiplicar(a, b: integer):integer;
var i, temp :integer;
begin
	temp := 0;
	for (i:=1 to b) do
	begin
		temp := suma(temp,a);
	end;
	multiplicar := temp;
end;

function fact(n:integer):integer;
var i:integer;
begin
	if(1>n) then
		fact := 1;
	else
		fact := multiplicar(fact(n-1),n);	
end;

begin
writeln();
write("Inicio ejecucion ----");
writeln();
a := suma(3,4);
write("La suma de 3 y 4 son (7): ");
write(a);
writeln();
a := multiplicar(3,4);
write("La multiplicacion de 3 y 4 son (12): ");
write(a);
writeln();
a := fact(5);
writeln();
write("El factorial de 5 es (120): ");
write(a);
end.