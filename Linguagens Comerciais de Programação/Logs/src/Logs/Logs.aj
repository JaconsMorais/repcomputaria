package Logs;

public aspect Logs {
	pointcut exec(): execution(* *.*(..));
	
	before(): exec(){
		System.out.println("Antes da execu��o de "+ thisJoinPoint.getSignature());
	}
	
	after() returning: exec(){
		System.out.println(thisJoinPoint.getSignature() + " executado com sucesso");
	}
	
	after() throwing(): exec(){
		System.out.println("Exce��o capturada em " + thisJoinPoint.getSignature());
	}
}
