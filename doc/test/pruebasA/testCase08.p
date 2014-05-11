// Precedencia de operadores

program ocho;

var     a :boolean;
        x :integer;


begin
	write("PRECEDENCIA DE OPERADORES");
	writeln();

      x:=5;
      a:= ((x+1) < 8) and true;

      write ("a(true):");
      if (a and true) then
        write("true");
      else
        write("false");

end.