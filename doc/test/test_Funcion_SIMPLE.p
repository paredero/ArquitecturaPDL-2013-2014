//valores devueltos ejemplo simple

program FuncionSimple;

type reg = record
     entero : integer;
     puntero: ^integer;
     cierto : boolean;
end;
var x,y,z: integer;
    a,b,c: boolean;
    d,e,f: ^integer;
    registro:reg;

// Funcion sin parametros
function fact():integer;
	begin
	fact := 6;
	x:=99;
	fact:= 3-7;
end;

// Funcion con muchos parametros y vacia
function test( p1, p2: integer; p3:boolean; p4:^integer; p5:boolean):integer;
begin
    writeln();
    write("Parametro 1: ");
    write(p1); 
    writeln();
    write("Parametro 2: ");
    write(p2);
    writeln();
    write("Parametro 3: ");
    if (p3) then write("p3 es true"); else write("p3 es false");
    writeln();
    write("Parametro 4: ");
    write(p4^);
    writeln();
    write("Parametro 5: ");
    if (p5) then write("p5 es true"); else write("p5 es false");
    writeln();
    
    test:=p1;
    
end; 

begin
    writeln();
    x := fact() -5;
    registro.puntero:=@x;
//  y := test(777,2,true);                             // error en el paso de parámetros
//  y := test(111, 222,true, registro.puntero, 999);   // error Paso parametros no coincide tipos
    y := test(111, 222,true, registro.puntero, false);   

    writeln()
    write("Escribe 6 - 5 = (1): ");
    write(x);

    writeln();
    write("Escribe (111): ");
    write(y);
    writeln();
end.