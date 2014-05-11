// variables logicas, if, operadores relacionales mayor igual
program seis;

var     a,b:boolean;
        x,y:integer;


begin

	write("IF ELSE OPERADORES RELACIONALES");
	writeln();
	
        a:=true;
        write("a(true):");

        if (a <> false) then
                write("true");
        else
                write("false");


        x:=2;
        y:=4;
        b:= x<y;

        write(" b(true):");
        if (b <> false) then
                write("true");
        else
                write("false");


end.
