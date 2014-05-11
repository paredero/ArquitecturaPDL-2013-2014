//Referencias a variables definidas en otros ambitos

program ambitosSimple;
// const C = 1;
// uno = 1;

{type
	tipoPersona = record
			dni : integer;
			casado : boolean;
			c1 : integer;
		end;
}	
var a0,resultado:integer;
    b0:boolean;

// NIVEL 1 
function nivel1 (x:integer):integer ;				//anidada
	var a1:integer;
            b1:boolean;

        // NIVEL 2
        function nivel2 (y:integer):integer;
        begin
                nivel2:=19999;
        end;

	begin
		a0 := 100;
                write("Nivel 1 var a0 (100): ");
                write(a0);
                writeln();
                a0 := nivel2(0);
                write("Nivel 2 var a0 (19999): ");
                write(a0);
                writeln();
                
                a1 := 555;
		writeln();
                b1:=false;
                b0:= b1 or true;
                if (b0) then
                    write("b0 es cierta");
                else
                    write("b0 es falsa");
                writeln();    
                write("Nivel 1 var a1 (555): ");
                write(a1);
                writeln();
      	nivel1 := 77;
	end;
	
// program principal
begin
	writeln();
	writeln();
        resultado:=nivel1(0);
	write("Paso por nivel a0 (19999): ");
        write(a0);
        writeln();
        write("Resultado NIVEL: (77)");
        write(resultado);
	writeln();
        if (b0) then 
            write("b0 sigue siendo cierta");

end.