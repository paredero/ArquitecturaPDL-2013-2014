//Unicidad de declaraciones y definiciones
program principal;

const  	B = 3;
		ww = true;
		//B = 6;    //repetir constante
		//ww = true;	//repetir constante

type
	tipoPersona = record
			dni : integer;
			casado : boolean;
			punter : ^integer;
		end;
{
	tipoDistinto = record		//campos repetidos
			dni : integer;
			casado : boolean;
			dni : ^integer;
		end;
}
{
	tipoPersona = record		//repetir tipo
			dni2 : integer;			
		end;
}

{	ww = record		// tipo igual a cte   Si se puede
			dn : integer; 
			casa : boolean;
		end;
}

	Persona = record		//campo igual a cte  si se puede
			B : integer;
			w : boolean;
		end;

{
	tipoNuevo = record		//arreglar el NullPointerException??
			dni : int;			//tipos primitivos no definidos
			casado : boole;
			punter : ^integer;
		end;
}
var
	p,q: ^integer;	
//	p: ^integer;			//variable repetida
	rr: tipoPersona;
	f,e,a ,bo: integer;
//	f: integer;				//variable repetida
//	rr: tipoPersona;		//varible repetida
	g, h, l, d: boolean;
//	g: boolean;				//varible repetida
//	aa: int;				//tipo no definido
//	B:integer;				//variable igual a cte  No se puede
	tipoPersona:^integer;	//variable igual a tipo   SI se puede
	casado:boolean;			//variable igual a campo si se puede
//	p:integer;				//variable repetida con diferente tipo
				
begin

end.
