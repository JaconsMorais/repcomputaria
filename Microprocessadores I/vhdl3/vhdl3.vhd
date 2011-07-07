library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_arith.all;
use ieee.std_logic_unsigned.all;


ENTITY vhdl3 is

port( busY : in std_logic_vector (3 downto 0);
      busX : in std_logic_vector (3 downto 0);
		v : in std_logic_vector (2 downto 0);
      --ctl : in std_logic_vector (2 downto 0);
      busS : out std_logic_vector(3 downto 0);
	  overflow : out std_logic
	 -- Cout : out std_logic;
	  );
	
END vhdl3;
---------------------------------------------------------------------
architecture somador of vhdl3 is 
   --SIGNAL   X:   std_logic;
   --SIGNAL   Y:   std_logic;
 --  SIGNAL   Cin: std_logic;
   --SIGNAL   S:   std_logic;
   SIGNAL C0: std_logic;
   SIGNAL C1: std_logic;
   SIGNAL C2: std_logic;
   SIGNAL C3: std_logic;
   SIGNAL temp: std_logic_vector (2 downto 0);
begin
	
	 case v is
			when "000" =>
	
     temp <= (busS(0)   <= (busX(0) xor busY(0)); 
    C0 <= (busX(0) and busY(0)); 
     
     busS(1)   <= (busX(1) xor busY(1) xor C0);
    C1 <= ((busX(1) and busY(1)) or (busX(1) and C0) or (busY(1) and C0));
       
    
     busS(2)   <= (busX(2) xor busY(2) xor C1); 
    C2 <= ((busX(2) and busY(2)) or (busX(2) and C1) or (busY(2) and C1));

     busS(3)   <= (busX(3) xor busY(3) xor C2);
    C3 <= ((busX(3) and busY(3)) or (busX(3) and C2) or (busY(3) and C2));
		overflow <= C2 xor C3;

    )
end case;
	case v is
	    when "001" =>
	temp <=(

		busS(0)   <= (busX(0) xor not busY(0)); 
    C0 <= (busX(0) and not busY(0)); 
     
     busS(1)   <= (busX(1) xor not busY(1) xor C0);
    C1 <= ((busX(1) and not busY(1)) or (busX(1) and C0) or (not busY(1) and C0));
       
    
     busS(2)   <= (busX(2) xor not busY(2) xor C1); 
    C2 <= ((busX(2) and not busY(2)) or (busX(2) and C1) or (not busY(2) and C1));

     busS(3)   <= (busX(3) xor not busY(3) xor C2);
    C3 <= ((busX(3) and not busY(3)) or (busX(3) and C2) or (not busY(3) and C2));
	overflow <= C2 xor C3;
)
end case;
end somador;

