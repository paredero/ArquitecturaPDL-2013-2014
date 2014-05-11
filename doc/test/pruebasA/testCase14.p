// subprogramas anidamiento

program catorce;

var p,uno:integer;


// anidamiento procedimientos
procedure incrementaProc (var x:integer);

var inc1:integer;

        procedure escribeProc (var z:integer);
        begin
        	write (z);
        end;
begin

        inc1:= x+1;
        escribeProc(inc1);


end; // incrementaProc




//anidamiento funciones
function incrementaFunc (var v:integer):integer;
var inc2:integer;

        function sumaFunc (var w: integer):integer;
        begin

              sumaFunc:=w+1;

        end;


begin

        incrementaFunc:=sumaFunc(v);


end; // decementaFunc




begin

        write("SUBPROGRAMAS ANIDAMIENTO");
        writeln();

	  uno:=1;

        write("z(2):");
        incrementaProc(uno);

        write("v(2):");
        p:=incrementaFunc(uno);
        write(p);

end.
