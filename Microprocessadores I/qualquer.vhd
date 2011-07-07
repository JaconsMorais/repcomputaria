library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_arith.all;
use ieee.std_logic_unsigned.all;


ENTITY ula is

port( busY:in std_logic_vector (3 downto 0);
      busX:in std_logic_vector (3 downto 0);
      ctl: in std_logic_vector (2 downto 0);
      busS:out std_logic_vector(3 downto 0);
	overflow: out std_logic;
	Cin: in std_logic;
);
END ula;
---------------------------------------------------------------------
architeture somador of ula is 
component somador
port(

   X:  in std_logic;
   Y:  in std_logic;
   Cin:in  std_logic;
   S:  out std_logic;
   Cout: out std_logic;
   overflow <= C2 xor C3;
);
   end component;
   SIGNAL C0: std_logic;
   SIGNAL C1: std_logic;
   SIGNAL C2: std_logic;
   SIGNAL C3: std_logic;
   
begin
b0: somador PORT MAP(
    X => busX(0),
    Y => busY(0),
    Cin => 0,
    (X xor Y xor Cin) => S =>busS(0),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C0
    );
   
b1: somador PORT MAP(
    X => busX(1),
    Y => busY(1),
    Cin => C0,
    (X xor Y xor Cin) => S =>busS(1),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C1
    );
    
b2: somador PORT MAP(
    X => busX(2),
    Y => busY(2),
    Cin => C1,
    (X xor Y xor Cin) => S =>busS(2),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C2
    );

b3: somador PORT MAP(
    X => busX(3),
    Y => busY(3),
    Cin => C2,
    (X xor Y xor Cin) => S =>busS(3),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C3
    );


end somador;

-----------------------------------------------------------------------------
architecture subtrator of ula is--architeture subtrator of ula is
component subtrator
port(
	X:  in std_logic;
	Y:  in std_logic;
	Cin:in  std_logic;
   	S:  out std_logic;
   	Cout: out std_logic;
   	overflow <= C2 xor C3;
	);
end component

   SIGNAL C0: std_logic;
   SIGNAL C1: std_logic;
   SIGNAL C2: std_logic;
   SIGNAL C3: std_logic;

begin

b0: subtrator PORT MAP(
	x => busX(0),
	y => busY(0),
	Cin => 0,
	(Xnot +1) + Y => S =>busS(0),
	(x and y) or (x and Cin) or (y and Cin) => Cout => C0
	);

b1: subtrator PORT MAP(
	x => busX(1),
	y => busY(1),
	Cin => C0,
	(Xnot +1) + Y => S =>busS(1),
	(x and y) or (x and Cin) or (y and Cin) => Cout => C1
	);

b2: subtrator PORT MAP(
	x => busX(2),
	y => busY(2),
	Cin => C1,
	(Xnot +1) + Y => S =>busS(2),
	(x and y) or (x and Cin) or (y and Cin) => Cout => C2
	);

b3: subtrator PORT MAP(
	x => busX(3),
	y => busY(3),
	Cin => C2,
	(Xnot +1) + Y => S =>busS(3),
	(x and y) or (x and Cin) or (y and Cin) => Cout => C3
	);


end subtrator;



-----------------------------------------------------------------------------

architecture multiplicador of ula is
	component multiplicador
PORT(
	X:  in std_logic;
   	Y:  in std_logic;
   	Cin:in  std_logic;
   	S:  out std_logic;
   	Cout: out std_logic;
   	overflow <= C2 xor C3;
	);
end component

   SIGNAL C0: std_logic;
   SIGNAL C1: std_logic;
   SIGNAL C2: std_logic;
   SIGNAL C3: std_logic;

begin

b0 : multiplicador PORT MAP(
	x => busX(0),
	y => busY(0),
	Cin => 0,
	x and y => S => busS(0),
	(x and y)or(x and Cin)or(y and Cin) => Cout C0
	);

b1 : multiplicador PORT MAP(
	x => busX(1),
	y => busY(1),
	Cin => C0,
	x and y => S => busS(1),
	(x and y)or(x and Cin)or(y and Cin) => Cout C1
	);

b2 : multiplicador PORT MAP(
	x => busX(2),
	y => busY(2),
	Cin => C1,
	x and y => S => busS(2),
	(x and y)or(x and Cin)or(y and Cin) => Cout C2
	);

b3 : multiplicador PORT MAP(
	x => busX(3),
	y => busY(3),
	Cin => C2,
	x and y => S => busS(3),
	(x and y)or(x and Cin)or(y and Cin) => Cout C3
	);

end multiplicador;

--process(ctl 



 