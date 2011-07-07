Trabalho de Banco de Dados – Prof. Dr. Farid Nourani
 
 
Universidade Estadual Paulista – Rio Claro
Daniel Cálice Martin, Paulo Renato Correia Costa, Thales Eduardo Nazatto
 
 
 
Create Tables Commands – Campeonato Brasileiro





CREATE TABLE TIMES (
codigo_times INT PRIMARY KEY,
nome VARCHAR
);

CREATE TABLE TECNICOS (
codigo_tecnicos INT PRIMARY KEY,
TIMES.codigo_times INT,
nome VARCHAR,
FOREIGN KEY(TIMES.codigo_times) REFERENCES TIMES (codigo_times)
);

CREATE TABLE JOGADORES (
codigo_jogadores INT PRIMARY KEY,
TIMES.codigo_times INT,
altura VARCHAR,
funcao VARCHAR,
peso VARCHAR,
data_nascimento DATE,
nome VARCHAR,
RB INT,
FC INT,
GC INT,
CA INT,
CV INT,
SG INT,
DD INT,
DP INT,
GS INT,
J INT,
FS INT,
PE INT,
A INT,
FT INT,
FD INT,
FF INT,
G INT,
I INT,
PP INT,
FOREIGN KEY(TIMES.codigo_times) REFERENCES TIMES (codigo_times)
);

CREATE TABLE ARBITROS (
codigo_arbitros INT PRIMARY KEY,
nome VARCHAR
);

CREATE TABLE ESTADIOS (
codigo_estadios INT PRIMARY KEY,
nome VARCHAR,
endereco VARCHAR,
capacidade INT,
ano_construcao VARCHAR
);

CREATE TABLE JOGOS (
codigo_jogos INT PRIMARY KEY,
TIMES.codigo_times_M INT,
TIMES.codigo_times_V INT,
ARBITROS.codigo_arbitros INT,
ESTADIOS.codigo_estadios INT,
data DATE,
hora_inicio TIME,
FOREIGN KEY(TIMES.codigo_times_M) REFERENCES TIMES (codigo_times),
FOREIGN KEY(TIMES.codigo_times_V) REFERENCES TIMES (codigo_times),
FOREIGN KEY(ARBITROS.codigo_arbitros) REFERENCES ARBITROS (codigo_arbitros),
FOREIGN KEY(ESTADIOS.codigo_estadios) REFERENCES ESTADIOS (codigo_estadios)
);

CREATE TABLE SUBSTITUICOES (
codigo_substituicoes INT PRIMARY KEY,
JOGADORES.codigo_jogadores_IN INT,
JOGADORES.codigo_jogadores_OUT INT,
JOGOS.codigo_jogos INT,
tempo_substituicoes TIME,
FOREIGN KEY(JOGADORES.codigo_jogadores_IN) REFERENCES JOGADORES (codigo_jogadores),
FOREIGN KEY(JOGADORES.codigo_jogadores_OUT) REFERENCES JOGADORES (codigo_jogadores),
FOREIGN KEY(JOGOS.codigo_jogos) REFERENCES JOGOS (codigo_jogos)
);

CREATE TABLE GOLS (
codigo_gols INT PRIMARY KEY,
tempo_gols TIME
);

CREATE TABLE MARCAM (
JOGADORES.codigo_jogadores INT,
JOGOS.codigo_jogos INT,
GOLS.codigo_gols INT,
PRIMARY KEY(JOGADORES.codigo_jogadores,JOGOS.codigo_jogos,GOLS.codigo_gols),
FOREIGN KEY(JOGADORES.codigo_jogadores) REFERENCES JOGADORES (codigo_jogadores),
FOREIGN KEY(JOGOS.codigo_jogos) REFERENCES JOGOS (codigo_jogos),
FOREIGN KEY(GOLS.codigo_gols) REFERENCES GOLS (codigo_gols)
);

