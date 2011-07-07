prep(Arv_prep) --> [Preposicao],{lex(Preposicao,[com,entre]),
Arv_prep=['<preposicao>' , Preposicao , '</preposicao>']}.

conlist([],""):-!.
conlist([Str],Str):-!.
conlist([Str1,Str2],Res):-concat(Str1,Str2,Res),!.
conlist([H|T],Res):-conlist(T,Temp),concat(H,Temp,Res).

write_file(File, Contents) :- open(File, write, Stream), write(Stream,
Contents), nl(Stream), close(Stream).

