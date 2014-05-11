// Operaciones básicas con punteros y punteros Registro

program punteros2;
const
	C = 1;

type
	registro = RECORD
		entero: integer;
		puntero: ^integer;		
end;
var
	a, b: integer;
	//c, d: integer;
	p, q: ^integer;	
	// x, y, z :boolean;	
	r: registro;

// program
begin
	writeln();
	a := 3;
	p := @a;
	r.puntero := @a;
	writeln(); write("Imprime el contenido de la variable apuntada por p (3): ");
	write(p^);

	writeln(); write("Imprime el contenido de la variable apuntada por resitro.puntero (3): ");
	write(r.puntero^);

	writeln(); write("Imprime la direccion de memoria de a(-6): ");
	write(p);

	writeln(); write("Imprime la direccion de memoria de a(-6): ");
	write(r.puntero);

	q := p;
	a := a - 1;
	writeln(); write("Imprime el valor actual de a (2): ");
	write(q^);

	writeln(); write("Imprime la direccion de memoria de a (-6): ");
	write(q);

	b := p - 1;
	writeln(); write("Imprime la direccion de memoria de a menos 1 (-7): ");
	write(b);	
	
	a:=p^;
	writeln(); write("Imprime el contenido de la direccon de p (2): ");
	write(a);
	a:=r.puntero^;
	writeln(); write("Imprime el contenido de la direccon de p (2): ");
	write(a);
	
	
	p^ := 9;
	a:=p^ -1;
	writeln(); write("Imprime el valor actual de a (8): ");
	write(a);

        r.puntero^:=99;
	a:=r.puntero^ -1;
	writeln(); write("Imprime el valor actual de a (98): ");
	write(a);	

	a:=8;
	p^ := a-2;
	writeln(); write("Imprime el contenido de la direccion apuntada por p (6): ");
	write(p^);
        r.puntero^ := a+2; 
	writeln(); write("Imprime el contenido de la direccion apuntada por r.puntero (8): ");
	write(r.puntero^);

	a := @a-@a;
	writeln(); write("Imprime el valor actual de a (0): ");
	write(a);

	r.entero:= @r.entero-@r.entero;
	writeln(); write("Imprime el valor actual de r.entero (0): ");
	write(r.entero);

	r.entero:=1999;
	writeln(); write("Imprime el valor actual de r.entero (-10): ");
	write(@r.entero);


	a:= p-@a;
	writeln(); write("Imprime el valor actual de a (0): ");
	write(a);

	a:=q-8;
	writeln(); write("Imprime el valor actual de a (-14): ");
	write(a);

	//p:=q;
	a:=p-q;
	writeln(); write("Imprime el valor actual de a (0): ");
	write(a);

	p:=@a;
	a:= p-@a;
	writeln(); write("Imprime el valor actual de a (0): ");
	write(a);

	//writeln();
	//write(a);
	//write(p);
  	// p := @C;		//error al tratar la direccion de la constante
 	//write(p^);
  	
end.
