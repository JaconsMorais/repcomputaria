<%-- 
    Document   : adminUI
    Created on : 26/06/2011, 14:09:57
    Author     : Acessa SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Área do administrador</title>
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script>
            $(document).ready(function(){
                $("#divEdicao").hide();
                $("#divExclusao").hide();
                $("#divProfessorCadastro").hide();
                $("#divProfessorEdicao").hide();
                $("#divProfessorExclusao").hide();
                 
                $("#btCadastro").click(function(){
                    $("#divCadastro").slideDown("slow");
                    $("#divEdicao").slideUp("slow");
                    $("#divExclusao").slideUp("slow");
                });
                $("#btEdicao").click(function(){
                    $("#divCadastro").slideUp("slow");
                    $("#divEdicao").slideDown("slow");
                    $("#divExclusao").slideUp("slow");
                });
                $("#btExclusao").click(function(){
                    $("#divCadastro").slideUp("slow");
                    $("#divEdicao").slideUp("slow");
                    $("#divExclusao").slideDown("slow");
                });
                $("#btAlunoCadastro").click(function(){
                    $("#divAlunoCadastro").slideDown("slow");
                    $("#divProfessorCadastro").slideUp("slow");
                });
                $("#btProfessorCadastro").click(function(){
                    $("#divAlunoCadastro").slideUp("slow");
                    $("#divProfessorCadastro").slideDown("slow");
                });
                $("#btAlunoEdicao").click(function(){
                    $("#divAlunoEdicao").slideDown("slow");
                    $("#divProfessorEdicao").slideUp("slow");
                });
                $("#btProfessorEdicao").click(function(){
                    $("#divAlunoEdicao").slideUp("slow");
                    $("#divProfessorEdicao").slideDown("slow");
                });
                $("#btAlunoExclusao").click(function(){
                    $("#divAlunoExclusao").slideDown("slow");
                    $("#divProfessorExclusao").slideUp("slow");
                });
                $("#btProfessorExclusao").click(function(){
                    $("#divAlunoExclusao").slideUp("slow");
                    $("#divProfessorExclusao").slideDown("slow");
                });
            });
        </script>
    </head>
    <body>
        <fieldset>
            <legend style="text-align: center">
                <form>
                    <input type="button" id="btCadastro" value="Cadastrar"/>
                    <input type="button" id="btEdicao" value="Editar"/>
                    <input type="button" id="btExclusao" value="Excluir"/>
                </form>
            </legend>
            <div id="divCadastro">
                <div>
                    <div style="float:left; margin-top: 15px">
                        <div style="margin-bottom: 5px"><input type="button" id="btAlunoCadastro" value="Aluno"/></div>
                        <div style="margin-bottom: 5px"><input type="button" id="btProfessorCadastro" value="Professor"/></div>
                    </div>
                    <div style="float:left; margin-top: 15px; margin-left: 25px;">
                        Cadastro
                        <div id="divAlunoCadastro">
                            - Alunos
                            <form method="post" action="/ELearning/AlunoCadastro">
                                <div>
                                    <span>Login:</span>
                                    <span><input id="loginAluno" name="loginAluno"/></span>
                                </div>
                                <div>
                                    <span>Senha:</span>
                                    <span><input id="senhaAluno" name="senhaAluno"/></span>
                                </div>
                                <div>
                                    <span>Endereço:</span>
                                    <span><input id="enderecoAluno" name="enderecoAluno"/></span>
                                </div>
                                <div>
                                    <span>Telefone:</span>
                                    <span><input id="telefoneAluno" name="telefoneAluno"/></span>
                                </div>
                                <input type="submit" id="submitAluno" name="submitAluno" value="Cadastrar"/>
                            </form>
                        </div>
                        <div id="divProfessorCadastro">
                            - Professores
                            <form method="post" action="/ELearning/ProfessorCadastro">
                                <div>
                                    <span>Login:</span>
                                    <span><input id="loginProfessor" name="loginProfessor"/></span>
                                </div>
                                <div>
                                    <span>Senha:</span>
                                    <span><input id="senhaProfessor" name="senhaProfessor"/></span>
                                </div>
                                <div>
                                    <span>Endereço:</span>
                                    <span><input id="enderecoProfessor" name="enderecoProfessor"/></span>
                                </div>
                                <div>
                                    <span>Telefone:</span>
                                    <span><input id="telefoneProfessor" name="telefoneProfessor"/></span>
                                </div>
                                <input type="submit" id="submitProfessor" name="submitProfessor" value="Cadastrar"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div id="divEdicao">
                <div>
                    <div style="float:left; margin-top: 15px">
                        <div style="margin-bottom: 5px"><input type="button" id="btAlunoEdicao" value="Aluno"/></div>
                        <div style="margin-bottom: 5px"><input type="button" id="btProfessorEdicao" value="Professor"/></div>
                    </div>
                    <div style="float:left; margin-top: 15px; margin-left: 25px;">
                        Edição
                        <div id="divAlunoEdicao">
                            - Alunos
                            <form method="post" action="/ELearning/AlunoPesquisa">
                                <span>ID do Aluno:</span>
                                <span><input id="idAlunoEdicao" name="idAlunoEdicao"/></span>
                                <input type="submit" id="submitAlunoEdicao" name="submitAlunoEdicao" value="Editar"/>
                            </form>
                        </div>
                        <div id="divProfessorEdicao">
                            - Professores
                            <form method="post" action="/ELearning/ProfessorPesquisa">
                                <span>ID do Aluno:</span>
                                <span><input id="idProfessorEdicao" name="idProfessorEdicao"/></span>
                                <input type="submit" id="submitProfessorEdicao" name="submitProfessorEdicao" value="Editar"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div id="divExclusao">
                <div>
                    <div style="float:left; margin-top: 15px">
                        <div style="margin-bottom: 5px"><input type="button" id="btAlunoExclusao" value="Aluno"/></div>
                        <div style="margin-bottom: 5px"><input type="button" id="btProfessorExclusao" value="Professor"/></div>
                    </div>
                    <div style="float:left; margin-top: 15px; margin-left: 25px;">
                        Exclusão
                        <div id="divAlunoExclusao">
                            - Alunos
                            <form method="post" action="/ELearning/AlunoExclusao">
                                <span>ID do aluno:</span>
                                <span><input id="idAlunoExclusao" name="idAlunoExclusao"/></span>
                                <input type="submit" id="submitAlunoExclusao" name="submitAlunoExclusao" value="Excluir"/>
                            </form>
                        </div>
                        <div id="divProfessorExclusao">
                            - Professores
                            <form method="post" action="/ELearning/ProfessorExclusao">
                                <span>ID do Professor:</span>
                                <span><input id="idProfessorExclusao" name="idProfessorExclusao"/></span>
                                <input type="submit" id="submitProfessorExclusao" name="submitProfessorExclusao" value="Excluir"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </fieldset>
    </body>
</html>
