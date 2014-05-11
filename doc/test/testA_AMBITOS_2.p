program Ambitos;

var
 Global: integer;

procedure Abuelo(var X: Integer);
 var
  Y: Integer;
  T: Integer;
 
procedure Padre(var Z: Integer);
    
    procedure Hijo1(var X,Y: Integer; var C: Integer);
     begin
      writeln();write("Ejecutando Hijo1 que modifica X con valor (15)"); writeln();
      writeln();write("           Hijo1 parametro X: "); write(X); writeln();
      writeln();write("           Hijo1 parametro Y: "); write(Y); writeln();
      writeln();write("           Hijo1 parametro C: "); write(C); writeln();
      C:=X+Y;
     end;

     procedure Hijo2();
     begin
        writeln();write("Llamada a HIJO1 con parametro (Y Z X)"); writeln();
        write("Y = ");write(Y); writeln(); 
        write("Z = ");write(Z); writeln(); 
        write("X = ");write(X); writeln();
        Hijo1(Y,Z,X);
        write("Valor de X despues de ejecutar Hijo1:" );write(x);
     end;

   begin
        writeln(); write("Parametro del Padre Z: "); write(z); 
        writeln(); write("--- Llamada a Hijo2 sin parametros"); 
        Hijo2();
        writeln(); write("--- Fin llamada a Hijo2 sin parametros");
   end;

 begin
  Y:=15;
  T:=7;
  writeln();write("Llamada a Padre con parametro (T=7): "); write(T);writeln();
  Padre(T);
  writeln();write("-- Fin Llamada a Padre con parametro (T=7): "); write(T);writeln();
  
 end;


begin
 Abuelo(Global);
 Write("Resultado esperado: 22"); Writeln();
 Write("Resultado obtenido: "); Write(Global); Writeln();
end.
