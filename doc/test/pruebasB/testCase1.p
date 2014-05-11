program prueba;

const CTE = 1;
uno = 1;

type
	tipoPersona = record
			dni : integer;
			casado : boolean;
			c1 : integer;
		end;
	
var
	a, b: integer;
	c, d: integer;
	e, f: ^integer;
	persona: tipoPersona;
	x, y, z :boolean;	

function incrementa (x:integer):boolean ;				//anidada
const uno = 1;
var y :integer;

	function escribe (x:integer):integer;
	var z:integer;
	begin
		write(z);
		escribe:= 5;   //escribe(4)-escribe(8);
	end;
	
begin
	x := x - uno;	
	incrementa:=true;
end;

{
function resta (a, b, c, d : integer): integer;
var j:integer;
begin

  resta:=a;
  b :=a-1;	

end;
}
// program
begin
//writeln();
	//a:=e^;
	//e^ := a;
	//a:=e^ -1;
	//e^ := a-2;
	//a := @a-@a;
	//a:= e-@a;
	//a:=f-8;
	//e:=f;
		//a:=e-f;
	//e:=@a;
		//a:= e-@a;
	//a:=3-1;
	//write("Hola mundo");
	//writeln();
	//write(a);
  	//e := @B;
  	//a := persona.dni;
  	//persona.dni := 4;
  	//persona.c1 := persona.dni;  //ojo cuando la asigna' es accreg=expr, se esta gastando un temporal que nunca se
  								//usará es porque en generarCodeIntRegistro de ExprBinaria, le he borrado elcodigo de Expr1
  								//para que no salga el acceso a registro, que no hace falta en una asignacion
  	//writeln();
  	//write(persona.c1);
  	//persona.casado := true;
  	//f := uno();
 	//write(p^);
  	//b:= suma(persona.dni, persona.casado);
  	//v:= suma (p^ ,q^);
  	//a := resta(1, 2, 3, 4);
  	//write("resultado:");
  	//write(d);
  	//write(persona.dni);
  
  { Debe mostar un 5 }
  
 //x := 2>5>true;
// y := true;
// z := x or y;
 //write(x);
{ 
  if (4>5) then
  	write("blanco");
  else
  	write("negro");
  	
  	
 for (a:=0 to 5) do
 	b:=b-1;
 	
 b:=2;
 
 for (a:=0 to 2) do
 begin
 	write("hola");
 	b:=b-1;
 	c:=c-1;
 end;
} 
end.
