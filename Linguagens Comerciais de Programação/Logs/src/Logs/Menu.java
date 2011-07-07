package Logs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu extends Voids{
	private String opt,s1,s2;
	private int op; 
	private double num1,num2;
	private BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	private BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

	public Menu(BufferedReader buffer) {
		this.buf = this.buff = new BufferedReader(new InputStreamReader(System.in));
	}

	public void iniciaMenu(){
		System.out.println("Escolha uma opção:");
		System.out.println("1-Escrever algo digitado");
		System.out.println("2-Somar dois termos");
		System.out.println("3-Escreve algo qualquer");
		System.out.println("4-Dividir dois termos");
		System.out.println("5-Sair");
		System.out.print("Opção: ");
		opt = buf.readLine();
		op = Integer.parseInt(opt);
	}
	
	public void escolheOpcao(){
		switch(op){
			case 1:
				System.out.println("Escreva algo");
				s1 = buff.readLine();
				escreveAlgo(s1);
				break;
				
			case 2:
				System.out.println("Escreva um numero");
				s1 = buff.readLine();
				num1 = Double.parseDouble(s1);
				System.out.println("Escreva outro numero");
				s2 = buff.readLine();
				num2 = Double.parseDouble(s2);
				System.out.println(somar(num1,num2));
				break;
				
			case 3:
				escreveAlgoQualquer();
				break;
				
			case 4:
				System.out.println("Escreva um numero");
				s1 = buff.readLine();
				num1 = Double.parseDouble(s1);
				System.out.println("Escreva outro numero");
				s2 = buff.readLine();
				num2 = Double.parseDouble(s2);
				System.out.println(dividir(num1,num2));
				break;

			case 5:System.exit(-1);
				break;
				
			default:System.out.println("Opção inválida");
		}
	}
}
