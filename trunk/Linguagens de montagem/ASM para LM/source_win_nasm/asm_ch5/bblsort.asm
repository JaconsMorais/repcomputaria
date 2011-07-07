;Bubble sort procedure                      BBLSORT.ASM
;     Objective: To implement the bubble sort algorithm.
;         Input: A set of nonzero integers to be sorted.
;                Input is terminated by entering zero.
;        Output: Outputs the numbers in ascending order.

%define    CRLF  0DH,0AH
MAX_SIZE   EQU   20
%include "io.mac"
.STACK 100H
.DATA
prompt_msg  db  "Enter nonzero integers to be sorted.",CRLF
            db  "Enter zero to terminate the input.",0
output_msg  db  "Input numbers in ascending order:",0

.UDATA
array       resd  MAX_SIZE   ; input array for integers

.CODE
      .STARTUP
      PutStr  prompt_msg     ; request input numbers
      nwln
      mov     BX,array       ; BX = array pointer
      mov     CX,MAX_SIZE    ; CX = array size
      sub     DX,DX          ; number count = 0
read_loop:
      GetLInt EAX            ; read input number
      nwln
      cmp     EAX,0          ; if the number is zero
      je      stop_reading   ; no more numbers to read
      mov     [BX],EAX       ; copy the number into array
      add     BX,4           ; BX points to the next element
      inc     DX             ; increment number count
      loop    read_loop      ; reads a max. of MAX_SIZE numbers
stop_reading:
      push    DX             ; push array size onto stack
      push    array          ; place array pointer on stack
      call    bubble_sort
      PutStr  output_msg     ; display sorted input numbers
      nwln
      mov     BX,array
      mov     CX,DX          ; CX = number count
print_loop:
      PutLInt [BX]
      nwln
      add     BX,4
      loop    print_loop
done:
      .EXIT
;-----------------------------------------------------------
;This procedure receives a pointer to an array of integers
; and the size of the array via the stack. It sorts the
; array in ascending order using the bubble sort algorithm.
;-----------------------------------------------------------
SORTED    EQU   0
UNSORTED  EQU   1
bubble_sort:
      pusha
      mov     BP,SP       
	
      ; CX serves the same purpose as the end_index variable
      ; in the C procedure. CX keeps the number of comparisons
      ; to be done in each pass. Note that CX is decremented
      ; by 1 after each pass.
      mov     CX, [BP+20]   ; load array size into CX

next_pass:
      dec     CX            ; if # of comparisons is zero
      jz      sort_done     ; then we are done
      mov     DI,CX         ; else start another pass

      ;DL is used to keep SORTED/UNSORTED status
      mov     DL,SORTED     ; set status to SORTED

      mov     SI,[BP+18]    ; load array address into SI
      ; ESI points to element i and ESI+4 to the next element
pass:
      ; This loop represents one pass of the algorithm.
      ; Each iteration compares elements at [SI] and [SI+4]
      ; and swaps them if ([SI]) < ([SI+4]).
	
      mov     EAX,[SI]      
      mov     EBX,[SI+4]
      cmp     EAX,EBX
      jg      swap
	
increment:
      ; Increment ESI by 4 to point to the next element
      add     SI,4
      dec     DI
      jnz     pass 
	
      cmp     DX,SORTED      ; if status remains SORTED
      je      sort_done      ; then sorting is done
      jmp     next_pass      ; else initiate another pass

swap:
      ; swap elements at [SI] and [SI+4]
      mov     [SI+4],EAX     ; copy [SI] in EAX to [SI+4]
      mov     [SI],EBX       ; copy [SI+4] in EBX to [SI]
      mov     DX,UNSORTED    ; set status to UNSORTED
      jmp     increment       

sort_done:
      popa
      ret     4
