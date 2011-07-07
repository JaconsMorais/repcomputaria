package Logs;

public aspect TempoExecucao {
	pointcut exec(): execution(* *.*(..));
	
	long ti, tf;
	
	before(): exec(){			
		ti = System.nanoTime();
	}
	
	after() returning: exec(){
		tf = System.nanoTime();
		
		System.out.println("Tempo de execu��o do m�todo " + thisJoinPoint.getSignature() + ": " + (tf-ti));
	}
}
