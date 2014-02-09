-- funciones paso por valor


procedure testCase08 () is

z: Integer;

a,b: Integer;

function suma (x,y: Integer) return Integer is
begin
		
	return x+y;	

end resta;


begin

	Put_line ("SUBPROGRAMAS FUNCIONES");
	a:= 5;
	b:= 3;
	z:= suma (a,b);
	Put_line("z(8):");
	Put_line(z);
			

end testCase08;
