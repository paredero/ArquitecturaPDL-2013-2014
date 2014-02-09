-- recursividad 


procedure testCase12 () is
	
	procedure incrementa(x: Integer) is

		y: Integer;
	begin
	
		y:=x;
		x:=x+1;
		if (6>x) then
			incrementa(x);
		end if;

		Put_line(y);

	end decrementa;


begin
	
	Put_line("RECURSIVIDAD");
	Put_line("12345:");
	incrementa(1);	

end testCase12;

