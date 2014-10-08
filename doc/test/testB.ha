-- funciones paso por valor


procedure testCase08 () is

a, z: Integer;

function suma (x: Integer) return Integer is
begin    
    Put_line(x);
    return x; 
end suma;


begin
    a := 6;
    Put_line(a);
    z:= suma (5);
    Put_line(z);
end testCase08;
