// subprogramas (paso por referencia) procedimientos

program once;



var
        z: integer;
        w: integer;
 procedure incrementa (var x,y:integer; u:boolean);
//function incrementa (var w:integer):integer;
  
        begin
            u:=true;
            x:= x+1;            
            y:= y+7;
//            incrementa:=w+1;
        end;

begin

      write ("SUBPROGRAMAS PROCEDIMIENTOS");
      writeln();
      w:=0;
      z:=1;
      incrementa (z, w, false);
      // z:=incrementa(z);
      write("z(2):");
      write(z);

      writeln();
      write("w(7):");
      write(w);


end.
