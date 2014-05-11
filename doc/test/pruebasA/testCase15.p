// subprogramas anidamiento procedimientos Referencias globales y no locales

program quince;


var global,uno:integer;

procedure incrementa (var x:integer);

var inc1 :integer;

        procedure escribe ();
        begin
                write (inc1);
        end;
begin

        inc1:= x+1;
        escribe();
        write(" global(3):");
        write(global);


end;


begin

        write("SUBPROGRAMAS ANIDAMIENTO Referencias globales y no locales");
        writeln();

        global:=3;

        write("inc1(2):");
	  uno:=1;
        incrementa(uno);


end.
