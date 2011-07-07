%include "io.mac"

.DATA
prompt_msg  db "Please input a primitive number (>1): ", 0
output_msg1 db "The target Fibonacci number less than "
	    db "or equal to ", 0
output_msg2 db " is ", 0

   .CODE
	.STARTUP
	PutStr  prompt_msg
	GetInt	EDX
	call 	fibonacci
	PutStr	output_msg2
	PutLInt	EAX
	nwln

   done:
	.EXIT

%define FIB_LO dword [EBP-4]

%define FIB_LO dword [HI-8]

fibonacci:

    enter 8,0
    push  EBX

    mov   FIB_LO, 1
    mov   FIB_HI, 1 


fib_loop:

   
   
    mov   EAX, FIB_HI
    mov   EBX, FIB_LO, 
    add   EBX, EAX
    mov   FIB_LO, EAX
    mov   FIB_HI, EBX
    cmp   EBX, EDX
    jle   fib_loop
    pop   EBX
    leave
    ret

      