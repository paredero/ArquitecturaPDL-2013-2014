program SerieDeFibonacci;
var
 	numTerminoFibonnaci, resultadoSuma:integer;
 	n1, n2, contador: integer;

	
begin
	numTerminoFibonnaci := 15;
	n1 := 1;
	n2 := 0;
	
	contador := 3;
	
	write("0, 1");
	
	repeat
		resultadoSuma := n2 + n1;
		
		write(", ");
		write(resultadoSuma);
		
		n2 := n1;
		n1 := resultadoSuma;
		contador := contador + 1;
		
	until (numTerminoFibonnaci < contador);

	writeln();
end.