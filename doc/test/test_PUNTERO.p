// Punteros simples y de registro

program punteros;

const  B = 3;

type  registro = RECORD
	entero: integer;
	puntero: ^integer;
end;

var
	p,q: ^integer;	
	f,e: integer;
	r:registro;
				
begin
	p := q;                                         // asignacion correcta
	p := r.puntero;                                 // asignacion correcta
	p := @e;                                        // asignacion correcta
	p := @r.entero;                                 // asingancion correcta
//  	p := q-1;                                       // error asignar entero a puntero
//      p := r.puntero -1;				// error asignar entero a puntero
//	p := q-q;                                       // error asignar entero a puntero
//      r.puntero := q-q; 	                        // error asignar entero a puntero
//	p := @e-1;                                      // error asignar entero a puntero
//	p := f;                                         // error asignar entero a puntero
//	r.puntero := f;                                 // error asignar entero a puntero
//	p := 3;                                         // error asignar entero a puntero
//	r.puntero := 3;		                        // error asignar entero a puntero
//	p := q^;                                        // error asignar entero a puntero
//      r.puntero := q^;   	                        // error asignar entero a puntero

	f := q-1;                                       // casting a enteros
	r.entero := q-1;                                // casting a enteros
	f := q-q;                                       // casting a enteros
	r.entero := q-q;  		                // casting a enteros
 	f := p;                                         // casting a enteros
	r.entero := p;          	                // casting a enteros
        f := @f;                                        // casting a enteros
        r.entero := @r.entero;				// casting a enteros
	f := @e-1;                                      // casting a enteros
	r.entero := @e-1;			        // casting a enteros

        f := p^;                                        // correcto
        r.entero := p^;					// correcto
	f := p^-3;                                      // correcto
        r.entero := p^-3;                               // correcto


	p^:= f;                                         // correcto
        r.puntero^:= f;					// correcto
	p^:= p;                                         // correcto pq es asignar un puntero a un entero, al revés no
        r.puntero^:= r.puntero;				// correcto pq es asignar un puntero a un entero, al revés no
	p^:= p-1;                                       // correcto
        r.puntero^:= r.puntero-1;			// correcto

end.
