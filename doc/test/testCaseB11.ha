-- subprogramas procedimientos anidados


procedure testCase11 () is

	procedure proc1(x: Integer) is 
	
	y: Integer;

		-- procedimiento anidado 
		procedure suma(x: Integer) is 
		w: Integer;
		begin  
			-- y accesible
			w:= y+x;
			Put_line("w(16):");  
			Put_line(w);   
		end proc2; 

	begin  
		y:=5;
		suma(x); 		
	end proc1; 


begin

	Put_line ("PROCEDIMIENTOS ANIDADOS");	
	proc1 (11);

end testCase11;
