//Comprobacion de concordancia en referencias: registros

program conjuntos;
	
type
	conjunto = set of 1..10;        
//      conjunto1 = set of -1..10;              // Error definicion
var c1, c2, c3, c4:conjunto;
    a:boolean;
    i:integer;
    x,y,z:integer;

// Procedimientos
procedure inicializar (j:integer);
var c3:conjunto;
begin
    c3:=c1+c2;
    write("c3 debe ser true del 1 al 5");
    for (i:=1 to 10) do
    begin
        if (i in c3) then
            begin
                writeln();
                write(i);
                write(" es true");
            end;
    end;
    j:=1500;
    
end;

// Programa principal
begin
    c1:=[1..4];
    //  x:=[1..4];              // variable no es de tipo conjuntos
    // c1:=[8..11];                // conjunto fuera de rango
    // c1:=[0..2];              // conjunto fuera de rango inferior
    c2:=[5..5];
    c3:=[10..10];
    inicializar(1);
    // a:= c1 <> c2;            // Error operador no permitido para conjuntos
    // a:= c1=c2;               // Error operador no permitido para conjuntos
    c4:=(c1+c2)+(c3+c4);
    y:=100;
    z:=200;
    x:=y+z;
    writeln();
    write("x vale 300: ");
    write(x);

    writeln();
    write("C4 del 1 al 5 deben ser true y el 10:");
    for (i:=1 to 10) do
    begin
        if (i in c4) then
            begin
            writeln();
            write(i);
            write(" es true");
        end;
    end;

end.
