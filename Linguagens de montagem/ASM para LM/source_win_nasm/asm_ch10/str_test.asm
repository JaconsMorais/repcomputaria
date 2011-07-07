;Program to test string procedures    STR_TEST.ASM
;        Objective: To test all string processing procedures
;                   in STRING.ASM and to illustrate how
;                   indirect procedure call can be used.
;           Inputs: As per queries.
;          Outputs: Displayed on the screen.
%include "io.mac"
CR              EQU 0DH
LF              EQU 0AH
STR_MAX         EQU 128
.STACK  100H
.DATA
proc_ptr_table  dw  str_len_fun,str_cpy_fun,str_cat_fun
                dw  str_cmp_fun,str_chr_fun,str_cnv_fun
                dw  str_mov_fun
MAX_FUNCTIONS   EQU ($ - proc_ptr_table)/2

choice_prompt   db  "You can test several functions.",CR,LF
                db  "    To test       enter",CR,LF
                db  "String length       1",CR,LF
                db  "String copy         2",CR,LF
                db  "String concatenate  3",CR,LF
                db  "String compare      4",CR,LF
                db  "Locate character    5",CR,LF
                db  "Convert string      6",CR,LF
                db  "Move string         7",CR,LF
                db  "Invalid response terminates program.",CR,LF
                db  "Please enter your choice: ",0

invalid_choice  db  "Invalid choice - program terminates.",0
string0_msg     db  "Please enter a string: ",0
string1_msg     db  "Please enter the first string: ",0
string2_msg     db  "Please enter the second string: ",0
char_msg        db  "Please enter a search character: ",0
number_msg      db  "Please enter # places to move: ",0

str_len_msg     db  "String length = ",0
str_cpy_msg     db  "The copied string is: ",0
str_cat_msg     db  "First string now contains: ",0

str_match_msg   db  "Both strings match.",0
str1_below_msg  db  "First string is less than second string.",0
str1_above_msg  db  "First string is greater than second string.",0

str_chr_msg     db  "The character is located at: ",0
str_chr_err_msg db  "No character match!",0
str_cnv_msg     db  "The converted string is: ",0
str_mov_msg     db  "The updated string is: ",0


no_string_msg   db  "Error: Not a string!",0
str_len_hdr_msg db  "String length function selected.",0
str_cpy_hdr_msg db  "String copy function selected.",0
str_cat_hdr_msg db  "String concatenate function selected.",0
str_cmp_hdr_msg db  "String compare function selected.",0
str_chr_hdr_msg db  "Locate character function selected.",0
str_cnv_hdr_msg db  "Convert string function selected.",0
str_mov_hdr_msg db  "Move string function selected.",0

.UDATA
string1         resb  STR_MAX
string2         resb  STR_MAX


.CODE
EXTERN   str_len, str_cpy
EXTERN   str_cat, str_cmp
EXTERN   str_chr, str_cnv
EXTERN   str_mov

        .STARTUP
        mov     AX,DS
        mov     ES,AX

query_choice:
        xor     BX,BX
        PutStr  choice_prompt    ; display menu
        GetCh   BL               ; read response
        nwln
        sub     BL,'1'
        cmp     BL,0
        jb      invalid_response
        cmp     BL,MAX_FUNCTIONS
        jb      response_ok
invalid_response:
        PutStr  invalid_choice
        jmp     SHORT done
response_ok:
        shl     BL,1                ; multiply BL by 2
        call    [proc_ptr_table+BX] ; indirect call
        jmp     query_choice
done:
        .EXIT

str_len_fun:
        PutStr  str_len_hdr_msg
        nwln
        PutStr  string0_msg
        GetStr  string1,STR_MAX
        nwln
        push    DS
        push    string1
        call    str_len
        call    error1
        PutStr  str_len_msg
        PutInt  AX
        nwln
        ret
        
str_cpy_fun:
        PutStr  str_cpy_hdr_msg
        nwln
        PutStr  string0_msg
        GetStr  string2,STR_MAX
        nwln
        push    DS
        push    string2
        push    ES
        push    string1
        call    str_cpy
        call    error1
        PutStr  str_cpy_msg
        PutStr  string1
        nwln
        ret
        
str_cat_fun:
        PutStr  str_cat_hdr_msg
        nwln
        PutStr  string1_msg
        GetStr  string1,STR_MAX
        nwln
        PutStr  string2_msg
        GetStr  string2,STR_MAX
        nwln
        push    DS
        push    string2
        push    ES
        push    string1
        call    str_cat
        call    error1
        PutStr  str_cat_msg
        PutStr  string1
        nwln
        ret
        
str_cmp_fun:
        PutStr  str_cmp_hdr_msg
        nwln
        PutStr  string1_msg
        GetStr  string1,STR_MAX
        nwln
        PutStr  string2_msg
        GetStr  string2,STR_MAX
        nwln
        push    DS
        push    string2
        push    ES
        push    string1
        call    str_cmp
        call    error1
        cmp     AX,0
        je      str_match
        jg      str1_above
str1_below:
        PutStr  str1_below_msg
        jmp     SHORT sm_skip
str_match:
        PutStr  str_match_msg
        jmp     SHORT sm_skip
str1_above:
        PutStr  str1_above_msg
sm_skip:
        nwln
        ret

str_chr_fun:
        PutStr  str_chr_hdr_msg
        nwln
        PutStr  string0_msg
        GetStr  string1,STR_MAX
        nwln
        PutStr  char_msg
        GetCh   AL
        nwln
        xor     AH,AH
        push    AX
        push    DS
        push    string1
        call    str_chr
        call    error1
        cmp     AX,0
        jne     skip_err
        PutStr  str_chr_err_msg
        jmp     SHORT finished
skip_err:
        PutStr  str_chr_msg
        sub     AX,string1-1                     ;;;;;
        PutInt  AX
finished:
        nwln
        ret
        
str_cnv_fun:
        PutStr  str_cnv_hdr_msg
        nwln
        PutStr  string0_msg
        GetStr  string2,STR_MAX
        nwln
        push    DS
        push    string2
        push    ES
        push    string1
        call    str_cnv
        call    error1
        PutStr  str_cnv_msg
        PutStr  string1
        nwln
        ret

str_mov_fun:
        PutStr  str_mov_hdr_msg
        nwln
        PutStr  string0_msg
        GetStr  string1,STR_MAX
        nwln
        PutStr  number_msg
        GetInt  DX
        nwln
        push    DX
        push    DS
        mov     AX,string1
        cmp     DX,0
        jge     skip1
        sub     AX,DX
skip1:
        push    AX
        call    str_mov
        call    error1
        PutStr  str_mov_msg
        PutStr  string1
        nwln
        ret

error1:
        push    AX
        jnc     no_error
        PutStr  no_string_msg
        nwln
        mov     AX,4C01H       ; return to DOS
        int     21H            ;  with error code 1
no_error:
        pop     AX
        ret
