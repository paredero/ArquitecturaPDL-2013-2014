//Aritmetica de valores logicos
program prueba;
	
var
	a: integer;	
	x, y, z :boolean;	

// program
begin
	writeln();
	//x := 5 > 7 > 1;		//esto da error	es un bool con un entero
	//x := 7 > 5 > true;	//esto es posible
	x := false;
	y := true;
	if (y) then
		begin
		write("Variable true.");
		writeln();
		end;
	x := true or true;
	if (x) then
		begin
		write("Variable true or true.");
		writeln();
		end;
	x := 5 > 4;
	if (x) then
		begin
		write("Variable 5 > 4.");
		writeln();
		end;
	x :=  6 = 6;
	if (x) then
		begin
		write("Variable 6 = 6.");
		writeln();
		end;
	x := false = false;
	if (x) then
		begin
		write("Variable false = false.");
		writeln();
		end;
	x := (4 = 5) or true;
	if (x) then
		begin
		write("Variable (4 = 5) or true.");
		writeln();
		end;
	// x := 7 > 5 > false;
	//if (x) then
	//	begin
	//	write("Variable 7 > 5 > false.");
	//	writeln();
	//	end;	
	writeln();
	//write(y);		//da error por intentar escribir un boolean
	//writeln();
	//z := false or y;
	//write(z);
	//write(x);
end.

