package Logs;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public aspect Excecoes {

	pointcut rl(): call(String *.readLine());
	
	declare soft: IOException: rl();
	
	String around(): rl() && withincode(void iniciaMenu()){
		String opcao = null;		
		
		try{
			opcao = proceed();
			if(opcao.equals("")) opcao = "0";
		}catch(IOException e){
			e.printStackTrace();
		}
		
		Pattern p = Pattern.compile("-?[1-9][0-9]*"); 
		Matcher m = p.matcher(opcao);
		
		if(m.find()){
			if(m.end(0) < opcao.length())
				opcao = "0";
		}else opcao = "0"; //!m.find()
		
		return opcao;
		
	}
	
}
