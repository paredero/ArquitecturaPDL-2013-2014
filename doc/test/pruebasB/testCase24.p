//funcion recursiva simple
program principal;

var a: integer;

function fact(n:integer):integer;
var i:integer;
begin
	if(1>n) then
		fact := 1;
	else
		begin
			writeln();
			write("Llamada a fact desde fact n = ");
			write(n);
			fact := fact(n-1);
		end;
end;

begin
writeln();
write("Nueva ejecucion----");
writeln();
write("LLamada desde el principal.");
writeln();
a := fact(3);
writeln();
write("Resultado de fact(3)(debe devolver 1)= ");
write(a);
end.