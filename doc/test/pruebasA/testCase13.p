// Control de flujo repeat 

program trece;



var
        x,y,z,w: integer;


begin

        write ("CRONTROL FLUJO REPEAT");
        writeln();

	
      x:=0;
	write("x(012345):");
      repeat 		
		write(x);
		x:=x+1;
      until (x>5);

end.
