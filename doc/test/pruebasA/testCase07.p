// variables logicas, if, operador logico and

program siete;

var     a:boolean;



begin

	write("IF AND");
	writeln();
		

        a:=true and true;
        write("a(true):");

        if (a and true) then
                write("true");
        else
                write("false");

        a:= true and false;
        write(" a(false):");
        if (a and true) then
                write("true");
        else
                write("false");


end.
