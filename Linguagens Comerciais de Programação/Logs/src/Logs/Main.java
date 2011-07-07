package Logs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]){
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		Menu menu = new Menu(buffer);
		
		while(true){
			menu.iniciaMenu();
			menu.escolheOpcao();
		}
	}
}
