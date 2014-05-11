//Operaciones Sumas + restas

program aritmetica;

var
	a, b, c: integer;	
	d: boolean;
begin

       a:=12;
	b:=10;
	
	// Error semantico
	// c:=d+c;
	// c:=d-a;

	write("El resultado debe ser 22: ");
	c:= a+b;
	write(c);
	writeln();
	write("El resultado debe ser 2: ");
	c:= a-b;
	write(c);
	writeln();

	c:=c+a+100-b;
	write("El resultado debe ser 104: ");
	write(c);
        writeln();
        a:=6;
        b:=0;
        write("Repetir hasta b sea 7");
        writeln();
        REPEAT
            b:=b+1;
            write("Resultado del bucle");
            write(b);
            writeln();
        UNTIL (b=4+3);
        
        // RESTA
	a := 10;
	b := 20;
	writeln();
	write("Escribe numero (30): ");
	write(30);
	writeln();
	write("Variable a(10): ");
	write(a);
	writeln();
	write("Resta 20 - 10= (10): ");
	a := b - a;
	write(a);
	writeln();
	write("Resta 100-50-30-10 = (10): ");
	a := 100-50-30-10;
	write(a);
	writeln();

        // Sentencia Control
        a:=100;
        b:=50;
        if (a > b) then
            begin
                write("a es > 10: ");
                write(a);
                writeln();
            end;
        else
            begin   
                write("El valor de a es: ");
                write(a);
                writeln();
                if (a=100) then
                    write("a vale 100");
            end;
        
        writeln();
        a:=5;
        write("Empiezo el bucle FOR");
        writeln();
        for (b:=1 to a) do

        begin
            write(b);
            writeln();
        end;
end.
