/*Consulta para pegar todas as matrículas não feitas pelo aluno*/
SELECT DISTINCT Disciplina.idDisciplina, nomeDisciplina, login, dataInicio, dataFim
FROM Matricula, Disciplina, Usuario, Aluno
WHERE
Disciplina.idProfessor = Usuario.idUsuario AND
Disciplina.idDisciplina NOT IN
(SELECT idDisciplina FROM Matricula WHERE idAluno = 6)
ORDER BY nomeDisciplina;

/*Consulta para pegar todos os Alunos*/
SELECT login, endereco, telefone
FROM Usuario, Pessoa, Aluno
WHERE
Usuario.idUsuario = Pessoa.idPessoa AND
Pessoa.idPessoa = Aluno.idAluno
ORDER BY login;

/*Consulta para pegar todos os Professores*/
SELECT login, endereco, telefone
FROM Usuario, Pessoa, Professor
WHERE
Usuario.idUsuario = Pessoa.idPessoa AND
Pessoa.idPessoa = Professor.idProfessor
ORDER BY login;


/*Consulta para pegar todas as disciplinas e seus Professores*/
SELECT nomeDisciplina, login, dataInicio, dataFim
FROM Usuario, Disciplina
WHERE
Disciplina.idProfessor = Usuario.idUsuario
ORDER BY nomeDisciplina;

/*Consulta para pegar todas as disciplinas e seus Critérios e pesos*/
SELECT nomeDisciplina, nome, peso
FROM Disciplina, CriterioAvaliacao
WHERE
Disciplina.idDisciplina = CriterioAvaliacao.idDisciplina AND
idProfessor = 2
ORDER BY nomeDisciplina, idCriterioAvaliacao;

/*Consulta para pegar todas as matrículas e seus alunos*/
SELECT login, nomeDisciplina
FROM Aluno, Usuario, Disciplina, Matricula
WHERE
Aluno.idAluno = Matricula.idAluno AND
Usuario.idUsuario = Aluno.idAluno AND
Disciplina.idDisciplina = Matricula.idDisciplina AND
idProfessor = 2
ORDER BY nomeDisciplina;

/*Consulta para pegar todas as matrículas e seu total de alunos*/
SELECT nomeDisciplina, COUNT(*)
FROM Aluno, Disciplina, Matricula
WHERE
Aluno.idAluno = Matricula.idAluno AND
Disciplina.idDisciplina = Matricula.idDisciplina AND
idProfessor = 2
GROUP BY nomeDisciplina;

/*Consulta para pegar média final na disciplina X*/
SELECT login, nomeDisciplina, notaFinal
FROM Matricula, Disciplina, Usuario
WHERE
Matricula.idAluno = Usuario.idUsuario AND
Matricula.idDisciplina = Disciplina.idDisciplina AND
idProfessor = 2
ORDER BY login;

/*Consulta para pegar média final nas disciplinas do aluno X*/
SELECT nomeDisciplina, notaFinal
FROM Matricula, Disciplina, Usuario
WHERE
Matricula.idAluno = Usuario.idUsuario AND
Matricula.idDisciplina = Disciplina.idDisciplina AND
Matricula.idAluno = 4
ORDER BY login;

/*Consulta para pegar média final na disciplina X, com notas*/
/*SELECT login,
sum(notaCriterio*(1-abs(sign(numCriterio-1)))) as nota1,
sum(notaCriterio*(1-abs(sign(numCriterio-2)))) as nota2,
sum(notaCriterio*(1-abs(sign(numCriterio-3)))) as nota3,
sum(notaCriterio*(1-abs(sign(numCriterio-4)))) as nota4,
notaFinal
FROM Matricula, Disciplina, CriterioAvaliacao, Nota, Usuario
WHERE
Matricula.idAluno = Usuario.idUsuario AND
Matricula.idMatricula = Nota.idMatricula AND 
CriterioAvaliacao.idDisciplina = Matricula.idDisciplina AND
Matricula.idDisciplina = 1
GROUP BY login;*/


/*
INSERT INTO Usuario (login,senha,tipoUsuario) VALUES ('admin','admin',1);
INSERT INTO Pessoa (idPessoa,telefone) VALUES (1,'admin');
*/