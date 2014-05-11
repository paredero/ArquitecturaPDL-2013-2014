// Inicio programa

program completo;

// Declaracion constantes
const
    ConstInt01 = 1111; // Constantes entera
    ConstInt02 = 2222;
    ConstBitFALSE = false;
    ConstInt03 = 3333;
    ConstBitTRUE = true; // Constantes booleanas

// Declaracion tipos
type
    miRegistro = record
        itemI1 : integer;
        itemI2 : integer;
        itemB1 : boolean;
        itemB2 : boolean;
    end;
    fecha = record
        dia : integer;
        mes : integer;
        anno : integer;
        hora:integer;minuto:integer;segundo : integer;
    end;
    registroPuntero = record
        itemP1 : ^integer;
        itemP2 : ^integer;
        itemP3 : ^integer;
    end;
var
	varReg01: miRegistro;
	varInt01, varInt02, varInt03, varInt04: integer;
	varInt05: integer;
	varFecha: fecha;
	varPointer01: ^integer;
	varInt06: integer;
	varBit01 : boolean;
	varPointer02: ^integer;
	varBit02: boolean;
	varRegPtr: registroPuntero;
	varIntGlobal: integer;

function suma (a : integer; b: integer): integer;
    begin
        suma := a - (0 - b);
    end;

{  ------------------------------------------------------------

    Multiplica dos numeros enteros
    Entrada:
        -> a : Primer factor
        -> b : Segundo factor
    Salida:
        <- Producto de a y b
  ------------------------------------------------------------ 
}
function multiplica(a:integer;b:integer):integer;
    var
        acumulado:integer;
        i:integer;
    begin
        acumulado := 0;

        for(i:=1 to b) do
        begin
            acumulado := suma(acumulado, a);
        end;
        multiplica := acumulado;
    end; 
  
{
  ------------------------------------------------------------
    Eleva un número a otro
    Entrada:
        -> a : Base
        -> b : Exponente
    Salida:
        <- a elevado a b
  ------------------------------------------------------------
}

function potencia(a,b:integer):integer;
    var
        acumulado:integer;
        i:integer;
    begin
        acumulado := 1;

        for(i:=1 to b) do
        begin
            acumulado := multiplica(acumulado, a);
        end;
        potencia := acumulado;
        
    end;
    
{
  ------------------------------------------------------------
    Calcula el factorial de un número
    Entrada:
        -> n : Número entero
    Salida:
        <- factorial de n
  ------------------------------------------------------------
}

function factorial(n:integer):integer;
    begin
        if (n = 1) then
            factorial := 1;
        else
            factorial := multiplica(factorial(n-1),n);

    end;
  
{
  ------------------------------------------------------------
    Pruebas con punteros
  ------------------------------------------------------------
}

{
procedure procPunteros(p,q:^integer; x:integer);
    const varPointer02 = 10000;
    type
        procPunterosRecord = record
            itemI1 : integer;
            itemI2 : integer;
            itemI3 : integer;
            itemP1 : ^integer;
            itemB1 : boolean;
            itemP2 : ^integer;
            itemB2 : boolean;
            itemB3 : boolean;
        end;
    var
        varPointer01:integer;
        z:integer;
        s:^integer;
        
    procedure anid2();
        var
            x:integer;
            r:procPunterosRecord;
            
        function anid4(a,b,c:integer):^integer;
            var
                y,z:integer;
                s:procPunterosRecord;
                i,j,k:integer;
            begin
                write("* Inicio procedimiento procPunteros.anid2.anid4"); writeln();
                s.itemi1 := 0-1-1;
                s.itemP1 := @i;
                i := 777;
                k := q^- s.itemP1^;
                write("a tiene que valer 1: "); write(a); writeln();
                write("b tiene que valer 2: "); write(b); writeln();
                c:= c - (0-1);
                write("c tiene que valer 4; "); write(c); writeln();
                write("s.itemi1 tiene que valer -2: "); write(s.itemi1); writeln();
                write("s.itemp1-> tiene que valer 777: "); write(s.itemp1^); writeln();
                write("p-> tiene que valer 12322: "); write(p^); writeln();
                write("q-> tiene que valer 12322: "); write(q^); writeln();
                write("k tiene que valer 11545: "); write(k); writeln();
                write("x tiene que valer 10: "); write(x); writeln();
                anid4 := @i;
                write("* Fin procedimiento procPunteros.anid2.anid4"); writeln();
            end;

        procedure anid3(y:integer;w: ^integer);
            var
                p:integer;
                panid3:^integer;
            begin
                write("* Inicio procedimiento procPunteros.anid2.anid3"); writeln();
                P:= 200;
                write("p tiene que valer 200: "); write(p); writeln();
                write("r.itemp1 tiene que valer 10: "); write(r.itemp1^); writeln();
                write("r.itemp2 tiene que valer 12322: "); write(r.itemp2^); writeln();
                write("q-> tiene que valer 12322: "); write(q^); writeln();
                write("s-> tiene que valer 12322: "); write(s^); writeln();
                write("y tiene que valer 9: "); write(y); writeln();
                write("w tiene que valer 10: "); write(w^); writeln();
                if (r.itemb2) then
                begin
                    write("r.itemI1 tiene que valer 11: "); write(r.itemI1); writeln();
                end;
                else
                begin
                    write("KO r.itemb2");writeln();
                end;
                if (r.itemb1) then
                begin
                    write("KO r.itemb1");writeln();
                end;
                panid3 := anid4(1,2,3);
                write("panid3-> tiene que valer 777: "); write(panid3^); writeln();
                
                write("* Fin procedimiento procPunteros.anid2.anid3"); writeln();
            end;
        begin
            write("* Inicio procedimiento procPunteros.anid2"); writeln();
            x := 14-1-1-2;
            r.itemI1 := 11-1-(0-1);
            r.itemb2 := true;
            r.itemb1 := false;
            r.itemP1 := @x;
            r.itemP2 := p;
            p^ := 12322;
            r.itemI2 := r.itemI1 - 4;
            anid3(x - 1,r.itemP1);
            r.itemP2^ := 20000;
            write("p-> tiene que valer 20000: "); write(p^); writeln();
            write("q-> tiene que valer 12322: "); write(q^); writeln();
            write("s-> tiene que valer 12322: "); write(s^); writeln();
            r.itemP2 := @r.itemI1;
            r.itemP1 := @r.itemi2;
            write("r.itemP2-> tiene que valer: "); write(r.itemI1); write(": "); write(r.itemp2^); writeln();
            write("r.itemP1-> tiene que valer: "); write(r.itemI2); write(": "); write(r.itemp1^); writeln();
            r.itemP1 := @varReg01.itemI2;
            r.itemP2 := @varReg01.itemI1;
            write("r.itemP2-> tiene que valer: "); write(varReg01.itemI1); write(": "); write(r.itemp2^); writeln();
            write("r.itemP1-> tiene que valer: "); write(varReg01.itemI2); write(": "); write(r.itemp1^); writeln();

            write("* Fin procedimiento procPunteros.anid2"); writeln();
        end;
    function anid1(p:^integer;y:integer):^integer;
    var
        r:^integer;

        begin
            write("* Inicio procedimiento procPunteros.anid1"); writeln();
            write("p-> tiene que valer 12322: "); write(p^); writeln();
            write("q-> tiene que valer 12322: "); write(q^); writeln();
            write("s-> tiene que valer 12322: "); write(s^); writeln();
            anid2();
            S^ := p^ - 1;
            varIntGlobal := 500;
            anid1 := @varIntGlobal;
            write("* Fin procedimiento procPunteros.anid1"); writeln();
        end;
    
    begin
        write("* Inicio procedimiento procPunteros"); writeln();
        varPointer01 := 20000;
        write("p-> tiene que valer 12322: "); write(p^); writeLn();
        write("q-> tiene que valer 12322: "); write(q^); writeLn();
        write("x  tiene que valer 12322: "); write(x); writeLn();
        write("varPointer02 tiene que valer 10000: "); write(varPointer02); writeLn();
        write("varPointer01 tiene que valer 20000: "); write(varPointer01); writeLn();
        p := @varPointer01;
        write("p-> tiene que valer 20000: "); write(p^); writeLn();
        s:=q;
        s:=anid1(q, p^);
        z:=s^;
        write("q-> tiene que valer 12321: "); write(q^); writeLn();
        write("z tiene que valer 500: "); write(z); writeLn();
        p^ := p^ -1;
        q^ := 30000;
        write("varPointer01 tiene que valer 19999: "); write(p^); writeLn();
        write("* Fin procedimiento procPunteros"); writeln();
    end;

}

{
  ------------------------------------------------------------
  Inicio del programa principal
  ------------------------------------------------------------
}
BEGIN
    // ------------------------------------------------------------
    // Pruebas con variables globales y constantes
    // ------------------------------------------------------------
    // Pruebo las funciones de salida
    writeln(); write("*** Prueba salida"); writeln();
    write("Hola Mundo");            // Cadena de texto
    writeLn();                      // Salto de linea
    write(12345); writeLn();        // Constante entera
    write(ConstInt01); writeLn();   // Constante simbolica entera
    
    
    varInt01 := 12311;
    varFecha.dia := 11;
    varInt02 := 12322;
    varPointer01 := @varInt02;
    varPointer02 := varPointer01;
    varFECHA.anno := 2010;
    varFecha.MES := 04;
    varInt03 := 12333;
    varReg01.itemI1 := 1;
    varReg01.itemI2 := 2;
    varFecha.hora := varReg01.itemI2 - (0- varFecha.dia)-varReg01.itemI1-varReg01.itemI1;
    varReg01.itemB1 := (varReg01.itemI2 > varReg01.itemI1);
    varReg01.itemB2 := true;
    varInt04 := 12344;
    varInt04 := 12344;
    varInt05 := 12355;
    varFecha.minuto :=varFecha.hora - 3 - varReg01.itemI1;

    varfecha.segundo:=1;
    write(varInt01); writeLn();         // Variable de tipo entero
    
    write("Esto tiene que valer     2: "); write(varReg01.itemI2); writeLn();  // Registro
    write("Esto tiene que valer     1: "); write(varReg01.itemI1); writeLn();  // Registro
    write("Esto tiene que valer 12322: "); write(varInt02); writeLn(); // Puntero
    
    // Prueba punteros

{
    writeln(); write("*** Prueba punteros"); writeln();
    write("Esto tiene que valer 12322: "); write(varPointer01^); writeLn(); // Puntero
    write("Esto tiene que valer 12322: "); write(varPointer02^); writeLn(); // Puntero
    varInt02 := varInt02 - 1;
    write("Esto tiene que valer 12321: "); write(varPointer01^); writeLn(); // Puntero
    write("Esto tiene que valer 12321: "); write(varPointer02^); writeLn(); // Puntero
    varPointer02^ := varInt02 - (0 - 1);
    write("Esto tiene que valer 12322: "); write(varPointer01^); writeLn(); // Puntero
    write("Esto tiene que valer 12322: "); write(varPointer02^); writeLn(); // Puntero
    procPunteros(varPointer01, varPointer02, varPointer02^);
    write("Esto tiene que valer 30000: "); write(varPointer01^); writeLn(); // Puntero
    write("Esto tiene que valer 30000: "); write(varPointer02^); writeLn(); // Puntero
    varPointer01^ := suma(12321, 1);
    varRegPtr.itemp2 := @varFECHA.anno;
    varRegPtr.itemp1 := @varFECHA.mes;
    write("varRegPtr.itemp2-> tiene que valer: "); write(varFECHA.anno); write(": "); write(varRegPtr.itemp2^); writeln();
    write("varRegPtr.itemp1-> tiene que valer: "); write(varFECHA.mes); write(": "); write(varRegPtr.itemp1^); writeln();

    // Calculos (-, :=, >, or, ., ^, @, =)
    writeln(); write("*** Prueba calculos"); writeln();
    varInt06 := 1 - (0 - 1);
    write("Esto tiene que valer     2: "); write(varInt06); writeLn();
    write("Esto tiene que valer   100: "); write(varInt02 - varInt01 - (0-89)); writeLn(); // 12321 - 12311 + 89 || 30000 - 12311 + 89
    write("Esto tiene que valer   -78: "); write(varInt02 - varInt01 - 0-89); writeLn();
    write("Esto tiene que valer    -2: "); write(1-2-1-0); writeLn();

    varInt01 := varInt01 - (0-varInt02);
    varInt02 := varInt01 - varInt02;
    varInt01 := varInt01 - varInt02;
    write("Esto tiene que valer  12322: "); write(varInt01); writeLn();
    write("Esto tiene que valer  12311: "); write(varInt02); writeLn();
    varInt01 := varInt01 - (0 - varInt02);
    varInt02 := varInt01 - varInt02;
    varInt01 := varInt01 - varInt02;
    write("Esto tiene que valer  12311: "); write(varInt01); writeLn();
    write("Esto tiene que valer  12322: "); write(varInt02); writeLn();
    write("Esto tiene que valer     12: "); write(suma(factorial(4-1), multiplica(2,3))); writeln();
    //esto no va porque el 0 no esta definido en el factorial write("Esto tiene que valer     12: "); write(suma(multiplica(factorial(0), multiplica(suma(1,1),5-2)), suma(6,7) - 1)); writeln();
    varPointer02 := @varInt01;
    varRegPtr.itemp1 := varPointer02;
    varInt01 := potencia(3,4) - 1;
    varRegPtr.itemp2 := @varInt02;
    varRegPtr.itemp3 := varRegPtr.itemp2;
    varInt02 := multiplica(potencia(2,2), 4-1) -2;
    write("Esto tiene que valer    800: "); write(multiplica(varInt01, varInt02) - suma(100, 0 - 100)); writeln();
    write("Esto tiene que valer    800: "); write(multiplica(varPointer02^, varInt02) - suma(100, 0 - 100)); writeln();
    write("Esto tiene que valer    100: "); write(multiplica(varRegPtr.itemp1^, varRegPtr.itemp3^) - multiplica(7, multiplica(varRegPtr.itemp2^, varRegPtr.itemp2^))); writeln();
    write("Esto tiene que valer      0: "); write(varRegPtr.itemp2^ - varRegPtr.itemp3^ - (varRegPtr.itemp1^- varRegPtr.itemp1^)); writeln();

    write("Hoy es dia 11/4/2010 : "); write(varFecha.dia); write("/"); write(varFecha.mes); write("/"); write(varFecha.anno); writeLN();
    write("La hora es 11:7:1 : "); write(varFecha.hora); write(":"); write(varFecha.minuto); write(":"); write(varFecha.seGundo); writeLN();

   
    // Condicionales
    
    writeln(); write("*** Prueba condicionales"); writeln();
    if (true) then
    begin
        write("OK Condición verdadera 001"); writeLn();
        if (true) then
        begin
            write("OK Condición verdadera 002"); writeLn();
            if (varInt01>varInt02) then
            begin
                write("KO 003"); writeLn();
            end;
            else
            begin
                write("OK Condición falsa 003"); writeLn();
                if (false or (varInt03>varInt04) or (varInt04-11= varInt03)) then
                begin
                    write("OK Condición verdadera 004"); writeLn();
                    if (ConstBitTRUE) then
                    begin
                        write("OK Condición verdadera 005"); writeLn();
                        varBit02 := ConstBitFALSE or (3>1);
                        if (ConstBitFALSE = varBit02) then
                        begin
                            write("KO 006"); writeLn();
                        end;
                        else
                        begin
                            write("OK Condición falsa 006"); writeLn();
                        end;
                    end;
                    else
                    begin
                        write("KO 005"); writeLn();
                    end;
                end;
                else
                begin
                    write("KO 004"); writeLn();
                end;
            end;
        end;
        else
        begin
            write("KO 002"); writeLn();
        end;
    end;
    else
    begin
        write("KO 001"); writeLn();
    end;
}    
    writeLn(); write("*** Llamadas a funciones"); writeln();
    write("Esto tiene que dar 10: "); write(suma(3,7)); writeln();
    write("Esto tiene que dar 06: "); write(suma(multiplica(suma(potencia(2,5), suma(16, 16)), 2) - 125,7)-4); writeln();
    varPointer01^ := 5;
    write("Esto tiene que dar 05: "); write(multiplica(2,varpointer01^)-5); writeln();
    varFecha.MES := 3;
    write("Esto tiene que dar 09: "); write(potencia(varFecha.MES,varFecha.MES-1)-0); writeln();

end.

