//valores devueltos

program principal;

var a: integer;

function fact():integer;
var j: integer;
begin
//fact := 6;
fact:= 3-7;
write("Sentencia detras de un valor devuelto");
writeln();
j := 2;
write("sentencia detras de valor devuelto debe escribir (2): ");
write(j);
writeln();
fact:=100;
end;

begin
write("Nueva ejecucion---");
writeln();
a := fact()-5;
writeln();
write("Imprime valor devuelto por una funcion con dos 'devuelves', en el primero acaba(-9): ");
write(a);
writeln();
end.