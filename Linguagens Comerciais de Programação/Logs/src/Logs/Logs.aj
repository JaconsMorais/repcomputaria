package Logs;

public aspect Logs {
	pointcut exec(): execution(* *.*(..));
	
	before(): exec(){
		System.out.println("Antes da execução de "+ thisJoinPoint.getSignature());
	}
	
	after() returning: exec(){
		System.out.println(thisJoinPoint.getSignature() + " executado com sucesso");
	}
	
	after() throwing(): exec(){
		System.out.println("Exceção capturada em " + thisJoinPoint.getSignature());
	}
}
