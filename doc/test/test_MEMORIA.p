program Memoria;

type
    tipoPersona = record
        dni : integer;
        casado : boolean;
	c1 : ^integer;
    end;
    conjunto10 = set of 1..10;
    conjunto5  = set of 5..6;

var global: integer;
    unoAdiez:conjunto10;
    persona:tipoPersona;

function multiplicar(a, b: integer):integer;
var i, temp :integer;
begin
	temp := 0;
	for (i:=1 to b) do
            temp := temp + a;
	multiplicar := temp;
end;	

function fact(n:integer):integer;
var i:integer;
begin
    if (1>n) then
        fact := 1;
    else
        begin
            write("El parametro vale: "); write(n);
            writeln();
            fact := multiplicar(fact(n-1),n);
        end;
end;

procedure padre (p1:integer; p2:integer);      
    // Procedimiento anidado por REF + valor
    procedure hijo(var h1,h2:integer; h3:boolean);       
    begin
         h1:=11; h2:=22; h3:=true;
    end; 
begin   
    hijo(p1,p2, false);
    writeln(); write("El p1 debe valer (11): "); write(p1);
    writeln(); write("El p2 debe valer (22): "); write(p2);
    writeln(); write("Var global vale (120): "); write(global);
end;

// programa principal
begin
    global:= fact(5);
    writeln();
    write("El factorial de 5 es (120): ");
    write(global);
    padre(0,0);
    persona.c1^:=@global;
    writeln();write("persona.c1 despl global(-6):" ); write(persona.c1^);
end.