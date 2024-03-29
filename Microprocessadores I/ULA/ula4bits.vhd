library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;

ENTITY ula4bits IS
	port(a, b : in std_logic_vector(3 downto 0);
		S : in std_logic_vector(1 downto 0);
		C : in std_logic;
		M : in std_logic;
	    f : out std_logic_vector(3 downto 0);
	    Co: out std_logic);
END ula4bits;

architecture ula of ula4bits is
	signal temp: std_logic_vector(3 downto 0);
	signal carry: std_logic;
begin
	process(S,C,M)
	begin
	if M = '0' then --parte l�gica
		carry <= '0';
		case S is
			when "00" =>
				temp <= a and b;
			when "01" =>
				temp <= a or b;
			when "10" =>
				temp <= a xor b;
			when "11" =>
				temp <= a xnor b;
		end case;
	else    --parte aritm�tica
		if C = '0' then
			case S is
				when "00" =>
					temp <= a;
				when "01" =>
					temp <= a + b;
					if (a(3) = '1' or b(3) = '1') and temp(3) = '0' then
						carry <= '1';
					else
						carry <= '0';
					end if;
				when "10" =>
					temp <= a + (not b);
					if (a(3) = '1' or b(3) = '0') and temp(3) = '0' then
						carry <= '1';
					else
						carry <= '0';
					end if;
				when "11" =>
					temp <= (not a) + b;
					if (a(3) = '0' or b(3) = '1') and temp(3) = '0' then
						carry <= '1';
					else
						carry <= '0';
					end if;
			end case;			
		else
			case S is
				when "00" =>
					temp <= a + 1;
					if temp = "0000" then
						carry <= '1';
					else
						carry <= '0';
					end if;
				when "01" =>
					temp <= a + b + 1;
					if (a(3) = '1' or b(3) = '1') and temp(3) = '0' then
						carry <= '1';
					else
						carry <= '0';
					end if;
				when "10" =>
					temp <= a - b;
					if a < b then
						carry <= '1';
					else
						carry <= '0';
					end if;
				when "11" =>
					temp <= b - a;
					if a > b then
						carry <= '1';
					else
						carry <= '0';
					end if;
			end case;	
		end if;
	end if;
	end process;
	
	f <= temp;
	Co <= carry;
	
end ula;