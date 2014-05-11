//Operaciones con punteros

program principal;

const  B = 3;

var
	p,q: ^integer;	
	f,e: integer;
				
begin
	p := q;		//asignacion correcta
	p := @e;	//asignacion correcta
//	p := q-1;	//error asignar entero a puntero
//	p := q-q;	//error asignar entero a puntero
//	p := @e-1;	//error asignar entero a puntero
//	p := f;		//error asignar entero a puntero
//	p := 3;		//error asignar entero a puntero
//	p := q^;	//error asignar entero a puntero
	f := q-1;	//casting a enteros
	f := q-q;	//casting a enteros
	f := p;		//casting a enteros
	f := @f;	//casting a enteros
	f := @e-1;	//casting a enteros
	f := p^;	//correcto
	f := p^-3;	//correcto
	p^:= f;		//coorecto
	p^:= p;    	//correcto pq es asignar un puntero a un entero, alreves no
	p^:= p-1;	//correcto

end.
