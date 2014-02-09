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
y,j: Integer;
t: Boolean;
p: Tpersona;
        
begin

Put_line("hola");
Put_line("hola");
end testCase01;