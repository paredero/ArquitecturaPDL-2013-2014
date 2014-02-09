-- tipos estructurados REGISTROS


procedure testCase07 () is

	type Tpersona is record
		dni: Integer;
		casado: Boolean;
	end record;
	
	p1 : Tpersona;	
	x: Integer;

begin

	Put_line("REGISTROS");	

	x:= 12345;
	
	p1.dni:=x;
	p1.casado:=False;		
			
	Put_line("dni(12345):");
	Put_line(p1.dni);
	Put_line("casado(false):");
	Put_line(p1.casado);


end testCase07;