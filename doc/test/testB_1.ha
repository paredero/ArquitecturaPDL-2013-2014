-- programa vacio

procedure testCase01 () is

-- Declaracion de constantes
CIERTO: constant := True;
FALSO: constant := False;
UNO: constant := 1;

-- Declaracion de tipos
type Tpersona is record
       dni: Integer;
        casado: Boolean;
    end record;
    

-- Declaracion de variables    
y,j,k: Integer;
t: Boolean;
p: Tpersona;
suma: Boolean;

function suma (a : Integer; b: Integer; c:Boolean) return Integer is
begin

  return a+b;   

end suma;

        
begin

      if t then
                Put_line("cierto");
      end if;
    k := suma(y,j,t);
Put_line("hola");
Put_line("hola");
end testCase01;