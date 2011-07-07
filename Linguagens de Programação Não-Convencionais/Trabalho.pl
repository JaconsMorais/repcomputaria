lex(X,[X|_]).
lex(X,[_|Y]):- lex(X,Y).

/*Artigos*/
artigo(Arv_art) --> [Artigo],{lex(Artigo,[o,um]),Arv_art=['<artigo genero = "masculino" numero = "singular">',Artigo,'</artigo>']}.
artigo(Arv_art) --> [Artigo],{lex(Artigo,[a,uma]),Arv_art=['<artigo genero = "feminino" numero = "singular">',Artigo,'</artigo>']}.
artigo(Arv_art) --> [Artigo],{lex(Artigo,[os,uns]),Arv_art=['<artigo genero = "masculino" numero = "plural">',Artigo,'</artigo>']}.
artigo(Arv_art) --> [Artigo],{lex(Artigo,[as,umas]),Arv_art=['<artigo genero = "feminino" numero = "plural">',Artigo,'</artigo>']}.

/*Preposição*/
prepro(Arv_pre) --> [Preposicao],{lex(Preposicao,[com,entre]),Arv_pre=['<preposicao>',Preposicao,'</preposicao>']}.

/*Substantivos*/
substa(Arv_sub) --> [Substantivo],{lex(Substantivo,[menino,gato]),Arv_sub=['<substantivo genero = "masculino" numero = "singular">',Substantivo,'</substantivo>']}.
substa(Arv_sub) --> [Substantivo],{lex(Substantivo,[menina,gata]),Arv_sub=['<substantivo genero = "feminino" numero = "singular">',Substantivo,'</substantivo>']}.
substa(Arv_sub) --> [Substantivo],{lex(Substantivo,[meninos,gatos]),Arv_sub=['<substantivo genero = "masculino" numero = "plural">',Substantivo,'</substantivo>']}.
substa(Arv_sub) --> [Substantivo],{lex(Substantivo,[meninas,gatas]),Arv_sub=['<substantivo genero = "feminino" numero = "plural">',Substantivo,'</substantivo>']}.

/*Concatenar Listas*/
conlist([],""):-!.
conlist([Str],Str):-!.
conlist([Str1,Str2],Res):-concat(Str1,Str2,Res),!.
conlist([H|T],Res):-conlist(T,Temp),concat(H,Temp,Res).

/*Verbos*/
verbo(Arv_ver) --> [Verbo],{lex(Verbo,[viu,olhou,jogou,ganhou]),Arv_ver=['<verbo numero = "singular">',Verbo,'</verbo>']}.
verbo(Arv_ver) --> [Verbo],{lex(Verbo,[viram,olharam,jogaram,ganharam]),Arv_ver=['<verbo numero = "plural">',Verbo,'</verbo>']}.

/*SIntagma Nominal*/
sinnom(Arv_sn) --> artigo(Artigo),substa(Substantivo),{Arv_sn=['<sentenca_nominal>',Artigo,Substantivo,'</sentenca_nominal>']}.

/*Sintagma Verbal*/
sinver(Arv_sv) --> verbo(Verbo),sinnom(SN),{Arv_sv=['<sentenca_verbal>',Verbo,SN,'</sentenca_verbal>']}.

/*Escrever em Arquivo*/
write_file(File,Contents) :- open(File,write,Stream), write(Stream,Contents), nl(Stream), close(Stream).


snr(Arv_sn) --> artr(Artigo),substr(Substantivo),{Arv_sn=['<sentenca_nominal>',Artigo,Substantivo,'</sentenca_nominal>']}.
svr(Arv_sv) --> verbr(Verbo),snr(SN),{Arv_sv=['<sentenca_verbal>', Verbo,SN,'</sentenca_verbal>']}.
spr(Arv_sp) --> prepr(Preposicao), snr(SN),{Arv_sp=['<sentenca_preposicional>',Preposicao,SN,'</sentenca_preposicional>']}.

/*Substantivo*/
subst(substantivo) --> [Substantivo],{lex(Substantivo,[menino,gato,brinquedo,telescopio,meninos,gatos,brinquedos,telescopios])}.

art(artigo) --> [Artigo],{lex(Artigo,[o,a,as,os,um,uns,uma,umas])}.

/*Verbos*/
verb(verbo) --> [Verbo],{lex(Verbo,[viu,olhou,jogou,ganhou,viram,olharam,jogaram,ganharam])}.

/*Preposicao*/
prep(preposicao) --> [Preposicao],{lex(Preposicao,[com,entre])}.

/*Sintagma Nomimal*/
sn(sintagma_nominal(Artigo,Substantivo)) --> art(Artigo),subst(Substantivo).
sn(sintagma_nominal(Artigo,Substantivo,SP)) --> art(Artigo),subst(Substantivo),sp(SP).

/*Sintagma Verbal*/
sv(sintagma_verbal(Verbo,SN)) --> verb(Verbo),sn(SN).
sv(sintagma_verbal(Verbo,SN,SP)) --> verb(Verbo),sn(SN),sp(SP).

/*Sintagma Preposicional*/
sp(sintagma_preposicional(Preposicao,SN)) --> prep(Preposicao), sn(SN).

/*Sentenca*/
s(sentenca(SN,SV)) --> sn(SN),sv(SV).
