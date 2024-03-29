library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;

ENTITY ulaula IS
	port(x, y : in std_logic_vector(3 downto 0);
		S : in std_logic_vector(1 downto 0);
		C : in std_logic;
		M : in std_logic;
	    f : out std_logic_vector(3 downto 0);
	    Co: out std_logic);
END ulaula;

architecture ula of ulaula is
	signal tg: std_logic_vector(3 downto 0);
	signal carry: std_logic;
begin
	process(S,C,M)
	begin
	if M = '1' then --parte aritm�tica

       if C = '0' then
			case S is
				when "00" =>
					tg <= x;
				when "01" =>
					tg <= x + y;
				when "10" =>
					tg <= x + (not y);
				when "11" =>
					tg <= (not x) + y;
			end case;			
		else
			case S is
				when "00" =>
					tg <= x + 1;
					if tg = "0000" then
						carry <= '1';
					else
						carry <= '0';
					end if;
				when "01" =>
					tg <= x + y + 1;
				when "10" =>
					tg <= x - y;
				when "11" =>
					tg <= y - x;
			end case;	

		
	   else    --parte l�gica
		

           case S is
			when "00" =>
				tg <= x and y;
			when "01" =>
				tg <= x or y;                                                               
			when "10" =>
				tg <= x xor y;
			when "11" =>
				tg <= x xnor y;
		end case;


	  end if;
	  end if;
	  end process;
	
 	  f <= temp;
	  Co <= carry;
	
end ula;