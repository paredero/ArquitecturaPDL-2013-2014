-- Control de flujo FOR

procedure testCase10 () is

        x: Integer;

begin	
        Put_line ("CRONTROL FLUJO FOR");
	
	x:=0;
	Put_line("x(1,2,3,4,5):");

	for x in 1..5 loop

		Put_line(x);

	end loop;

end testCase10;
