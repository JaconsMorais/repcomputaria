.section .bss 

.global 
.common a, 4
.global 
.common b, 4
.global 
.common c, 4
.global 
.common d, 4
.global 
.common x, 4
.global 
.common y, 4
.global 
.common w, 4

.section .text 

P1:
	 pushl %ebp 
	 movl %esp, %ebp 
	 addl $0, %esp 

	 movl $4, %eax
	 movl $1, %ebx
	 movl Digite valor de b   , %ecx
	 movl 20, %edx
	 int 0x80


	 movl $3, %eax
	 movl $0, %ebx
	 movl b,%ecx
	 movl 4, %edx
	 int 0x80

	 pushl %eax 
 	 movl 0 , %eax 
 	 movl %eax, d
	 movl %ebp, %esp
	 popl %ebp 
	 ret 

.section .text 

F1:
	 pushl %eax 
 	 movl 2 , %eax 
 	 imul a, %eax
	 imul b, %eax
	 movl %eax, d
	 movl 1, %eax
	 movl %eax, x
	 movl 3, %edx
.L0:
	 movl x, %eax
	 cmpl %edx, %eax 
	 setgeb %al 
	 jz .L1
	 inc %eax
	 movl %eax, x
	 pushl %eax
	 movl y, %eax
	 pushl %eax 
 	 movl 1 , %eax 
 	 popl %ebx
	 addl %ebx, %eax
	 movl %eax, y
	 jmp .L0
.L1:

.section .text 

	 .global _start 
_start: 
	 pushl %eax 
 	 movl 0 , %eax 
 	 movl %eax, a
	 pushl %eax 
 	 movl 2 , %eax 
 	 movl %eax, b
	 pushl %eax
	 movl b, %eax
	 pushl %eax 
 	 movl 2 , %eax 
 	 movl %eax, %ecx 
	 popl %ebx 
	 xorl %eax 
	 cmpl %ecx, %ebx 
	 seteb %al 
	 pushl %eax
	 movl a, %eax
	 pushl %eax 
 	 movl 0 , %eax 
 	 movl %eax, %ecx 
	 popl %ebx 
	 xorl %eax 
	 cmpl %ecx, %ebx 
	 seteb %al 
	 popl %ebx 
	 orl %ebx, %eax 
	 and %eax,%eax
	 jz .L2
	 pushl %eax
	 movl b, %eax
	 imul c, %eax
	 movl %eax, a
	 pushl %eax
	 movl a, %eax
	 divl $3, %eax
	 movl %eax, a
	 pushl %eax 
 	 movl 2 , %eax 
 	 divl b, %eax
	 movl %eax, c
	 jmp .L3
.L2:
.L4:
	 pushl %eax
	 movl a, %eax
	 pushl %eax 
 	 movl 1 , %eax 
 	 popl %ebx
	 addl %ebx, %eax
	 movl %eax, c
	 pushl %eax
	 movl c, %eax
	 pushl %eax 
 	 movl 2 , %eax 
 	 movl %eax, %ecx 
	 popl %ebx 
	 xorl %eax 
	 cmpl %ecx, %ebx 
	 setgeb %al 
	 jz .L4
.L3:
	 call P1
.L5:
	 pushl %eax
	 movl w, %eax
	 pushl %eax 
 	 movl 0 , %eax 
 	 movl %eax, %ecx 
	 popl %ebx 
	 xorl %eax 
	 cmpl %ecx, %ebx 
	 seteb %al 
	 jz .L6
	 pushl %eax
	 movl a, %eax
	 divl $2, %eax
	 movl %eax, a
	 pushl %eax
	 movl b, %eax
	 mull $2, %eax
	 movl %eax, b
	 pushl %eax
	 movl a, %eax
	 pushl %eax 
 	 movl 2 , %eax 
 	 movl %eax, %ecx 
	 popl %ebx 
	 xorl %eax 
	 cmpl %ecx, %ebx 
	 setlb %al 
	 pushl %eax
	 movl b, %eax
	 pushl %eax 
 	 movl 100 , %eax 
 	 movl %eax, %ecx 
	 popl %ebx 
	 xorl %eax 
	 cmpl %ecx, %ebx 
	 setgb %al 
	 popl %ebx 
	 andl %ebx, %eax 
	 and %eax,%eax
	 jz .L7
	 pushl %eax 
 	 movl 1 , %eax 
 	 movl %eax, w
.L7:
	 jmp .L5
.L6:
	 movl a, %eax
	 pushl %eax
.L8:
	 movl 2, %edx
	 popl %ebx
	 cmpl %edx, %ebx 
	 seteb %al 
	 pushl %ebx
	 jnz .L9
	 jmp .L10
.L9:
	 pushl %eax 
 	 movl 3 , %eax 
 	 movl %eax, a
	 jmp .L10
.L10:
	 movl 3, %edx
	 popl %ebx
	 cmpl %edx, %ebx 
	 seteb %al 
	 pushl %ebx
	 jnz .L11
	 jmp .L12
.L11:
	 pushl %eax 
 	 movl 5 , %eax 
 	 movl %eax, a
	 jmp .L12
.L12:

	 movl $4, %eax
	 movl $1, %ebx
	 movl compilador , %ecx
	 movl 11, %edx
	 int 0x80

	 call F1
_end: 
	 movl $1, %eax
	 xorl %ebx, %ebx 
	 int 0x80
