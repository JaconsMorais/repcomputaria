;Test routine for GetPut.asm      TEST_GETPUT.ASM
;
;        Objective: To test 8-bit integer input & output
;            Input: Requests an integer from the user.
;           Output: Outputs the input number.
%include "io.mac"
.STACK 100H
.DATA
prompt_msg  db   "Please input a number (-128 to +127): ",0
output_msg  db   "The number is ",0
error_msg   db   "The number is out of range. Try again!",0

.CODE
EXTERN   GetInt8, PutInt8
      .STARTUP
read_num:
      PutStr  prompt_msg    
      call    GetInt8   
      nwln
      jnc     num_OK
      ; else, out of range error
      PutStr  error_msg 
      nwln
      jmp     read_num
num_OK:
      PutStr  output_msg    
      call    PutInt8
      nwln
done:
      .EXIT
