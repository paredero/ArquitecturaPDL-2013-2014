-- if sin else, operadores relacionales >  = logico or


procedure testCase05 () is

      	t: Boolean;
	x: Integer;

begin
	Put_line("IF OPERADORES");
	
	t := True;
        Put_line("t(cierto):");
        if t or False then
                Put_line("cierto");
        end if;

	x := 2;
	Put_line("x mayor (cierto):");
	
	if x > 1 then
		Put_line("cierto");
	end if;
	Put_line("x igual (cierto):");
	if x=2 then		
        	Put_line("cierto");
	end if;

end testCase05;

