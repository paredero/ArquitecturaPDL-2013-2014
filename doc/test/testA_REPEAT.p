//Operaciones con Bucle

program principal;

var
	a,b: integer;	
				
begin
        a:=0;
	// Esto debe dar error porque no hay parentesis en la condicion o falta UNTIL
	// repeat
	//	writeln();
	// (a<10);
	b:=0;
        writeln();
        write("Este bucle se debe repetir 10 veces: ");
        repeat 
		a:=a+1;
                writeln();
		write("Valor de a: ");
		write(a);
		
	until (a + b = 10);

	// a:=20;

	// repeat 
	// 	a:=a-1;
	// until (a=10);
        writeln();
	write("Despues de salir bucle individual ");
	write(a);


end.
