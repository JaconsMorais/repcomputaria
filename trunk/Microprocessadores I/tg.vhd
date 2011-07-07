library ieee;
use ieee.std_logic_1164.all;

ENTITY ula is

port( busY:in std_logic_vector (7 downto 0);
      busX:in std_logic_vector (7 downto 0);
      ctl: in std_logic_vector (2 downto 0);
      busS:out std_logic_vector(7 downto 0);
)
end ula;

architeture somador of ula is 
component somador
PORT(

   X:  in std_logic;
   Y:  in std_logic;
   Cin:in  std_logic;
   S:  out std_logic;
   Cout: out std_logic;
   )
   end component;
   SIGNAL C0: std_logic;
   SIGNAL C1: std_logic;
   SIGNAL C2: std_logic;
   SIGNAL C3: std_logic;
   SIGNAL C4: std_logic;
   SIGNAL C5: std_logic;
   SIGNAL C6: std_logic;
   SIGNAL C7: std_logic;
   
begin
b0: somador PORT MAP(
    X => busX(0),
    Y => busY(0),
    Cin => Cin,
    (X xor Y xor Cin) => S =>busS(0),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C0(0)
    );
    
   b1: somador PORT MAP(
    X => busX(1),
    Y => busY(1),
    Cin => Cin,
    (X xor Y xor Cin) => S =>busS(1),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C1(1)
    );
 
    
b2: somador PORT MAP(
    X => busX(2),
    Y => busY(2),
    Cin => Cin,
    (X xor Y xor Cin) => S =>busS(2),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C2(2)
    );
b3: somador PORT MAP(
    X => busX(3),
    Y => busY(3),
    Cin => Cin,
    (X xor Y xor Cin) => S =>busS(3),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C3(3)
    );
b4: somador PORT MAP(
    X => busX(4),
    Y => busY(4),
    Cin => Cin,
    (X xor Y xor Cin) => S =>busS(4),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C4(4)
    );
b5: somador PORT MAP(
    X => busX(5),
    Y => busY(5),
    Cin => Cin,
    (X xor Y xor Cin) => S =>busS(5),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C5(5)
    );
b6: somador PORT MAP(
    X => busX(6),
    Y => busY(6),
    Cin => Cin,
    (X xor Y xor Cin) => S =>busS(6),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C6(6)
    );
b7: somador PORT MAP(
    X => busX(7),
    Y => busY(7),
    Cin => Cin,
    (X xor Y xor Cin) => S =>busS(7),
    (X and Y) or (X and Cin) or (Y and Cin) => Cout => C7(7)
    );

overflow <= C6 xor C7;
end somador;


--architeture subtrator of ula is



--process(ctl 



 