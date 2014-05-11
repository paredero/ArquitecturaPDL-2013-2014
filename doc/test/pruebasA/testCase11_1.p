// subprogramas (paso por referencia) procedimientos

program once;

var
        z: integer;
        w: integer;
        j: integer;
        m: boolean;
        k: integer;	
procedure incrementa (var x,y:integer; u:boolean);
 
       procedure prueba (var a:integer; var b:boolean);
            begin
                writeln();
                write("El valor de k en prueba es (666): ");
                write(k);
                a:=a+1;
                writeln();
                write("El valor de a es (667): ");
                write(a);
                b:=false;
                // prueba:=666;
            end;

        begin
            u:=true;
            x:= x+10;            
            y:= y+10;
            k:=666;
            m:=true;
            prueba(k, m);
            writeln();
            write("El valor de k en prueba es ahora (667): ");
            write(k);
            writeln();
            write("El valor de m es (FALSE): ");
            if (m=true) then write("TRUE");
                 else write("FALSE");
            
            writeln();
            write("Fin funcion incrementa");
        end;

begin

      write ("SUBPROGRAMAS PROCEDIMIENTOS");
      writeln();
      w:=222;
      z:=111;
      j:=333;
      k:=555;
      incrementa (z, w, false);
      // z:=incrementa(z);
      write("z(121):");
      write(z);

      writeln();
      write("w(232):");
      write(w);
end.
