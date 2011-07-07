program test;

var x, y: integer;

begin
  read (y);
  for x:= 1 To y + x do
    begin
	if x > y then
		writeln (x)
	else
		writeln (y)
    end
end.
