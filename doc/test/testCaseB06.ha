-- if con else operadores

procedure testCase06 () is


        x: Integer;
	y: Integer;
	a: Boolean;

begin
	Put_line("IF ELSE OPERADORES");
	
        x:=2;
        y:=1;
 
	-- false
	a := y>x;  

        Put_line("x (falso):");
     
	if x = 5 then
                Put_line("cierto");
        else
                Put_line("falso");
	end if;

	
	Put_line("x (cierto):");
	
	if x > 1 then 
                Put_line("cierto");
        else 
                Put_line("falso");
	end if;


	Put_line("a (falso):");

	-- if con parentesis al ser una expresion logica
	if (a or False) then
		Put_line("cierto");	
	else 
		Put_line("falso");
	end if;

	-- true
	a := x > y;
	Put_line("a (cierto):");

	if a or (True or True) then
		Put_line("cierto");	
	else 
		Put_line("falso");
	end if;

end testCase06;