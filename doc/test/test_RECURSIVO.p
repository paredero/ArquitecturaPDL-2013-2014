//funcion recursiva simple
program recursivo;

var a: integer;

function fact(n:integer):integer;
var i:integer;
begin
	if(1>n) then
            begin
                fact := 1;
            end;
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
a := fact(5);
writeln();
write("Resultado de fact(5)(debe devolver 1)= ");
write(a);
end.