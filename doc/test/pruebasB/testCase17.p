//operaciones básicas con punteros

program prueba;
const
	C = 1;

var
	a, b: integer;
	//c, d: integer;
	p, q: ^integer;	
	//x, y, z :boolean;	

// program
begin
	writeln();
	a := 3;
	p := @a;
	write("Imprime el contenido de la variable apuntada por p (3): ");
	write(p^);
	writeln();
	write("Imprime la direccion de memoria de a(-6): ");
	write(p);
	q := p;
	a := a - 1;
	writeln();
	write("Imprime el valor actual de a (2): ");
	write(q^);
	writeln();
	write("Imprime la direccion de memoria de a (-6): ");
	write(q);
	b := p - 1;
	writeln();
	write("Imprime la direccion de memoria de a menos 1 (-7): ");
	write(b);	
	writeln();
	a:=p^;
	write("Imprime el contenido de la direccon de p (2): ");
	write(a);
	writeln();	
	p^ := 9;
	a:=p^ -1;
	write("Imprime el valor actual de a (8): ");
	write(a);	
	writeln();
	p^ := a-2;
	write("Imprime el contenido de la direccion apuntada por p (6): ");
	write(p^);
	writeln();
	a := @a-@a;
	write("Imprime el valor actual de a (0): ");
	write(0);
	writeln();
	a:= p-@a;
	write("Imprime el valor actual de a (0): ");
	write(a);
	writeln();
	a:=q-8;
	write("Imprime el valor actual de a (-14): ");
	write(a);
	writeln();
	//p:=q;
	a:=p-q;
	write("Imprime el valor actual de a (0): ");
	write(a);
	writeln();
	p:=@a;
		a:= p-@a;
	write("Imprime el valor actual de a (0): ");
	write(a);
	//writeln();
	//write(a);
	//write(p);
  	//p := @B;		//error al tratar la direccion de la constante
 	//write(p^);
  	
end.
