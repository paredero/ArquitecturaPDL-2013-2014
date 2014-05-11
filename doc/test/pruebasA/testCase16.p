// recursividad  if

program dieciseis;

var cero:integer;

procedure incrementa (var x:integer);

var y: integer;
begin

	y:=x+1;
      if (x<5) then
        incrementa (y);

      write(y);

end;


begin

        write("RECURSIVIDAD");
        writeln();

	  cero:=0;
        write("x(654321):");
        incrementa(cero);

end.
