<%-- 
    Document   : professorUI
    Created on : 26/06/2011, 14:36:15
    Author     : Acessa SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Área do professor</title>
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script>
            $(document).ready(function(){
                $("#divEdicao").hide();
                $("#divExclusao").hide();
                $("#divCriteriosCadastro").hide();
                $("#divCriteriosEdicao").hide();
                $("#divCriteriosExclusao").hide();
                $("#divNotaCadastro").hide();
                $("#divNotaEdicao").hide();
                $("#divNotaExclusao").hide();
                 
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
                $("#btDisciplinaCadastro").click(function(){
                    $("#divDisciplinaCadastro").slideDown("slow");
                    $("#divCriteriosCadastro").slideUp("slow");
                    $("#divNotaCadastro").slideUp("slow");
                });
                $("#btCriteriosCadastro").click(function(){
                    $("#divDisciplinaCadastro").slideUp("slow");
                    $("#divCriteriosCadastro").slideDown("slow");
                    $("#divNotaCadastro").slideUp("slow");
                });
                $("#btNotaCadastro").click(function(){
                    $("#divDisciplinaCadastro").slideUp("slow");
                    $("#divCriteriosCadastro").slideUp("slow");
                    $("#divNotaCadastro").slideDown("slow");
                });
                $("#btDisciplinaEdicao").click(function(){
                    $("#divDisciplinaEdicao").slideDown("slow");
                    $("#divCriteriosEdicao").slideUp("slow");
                    $("#divNotaEdicao").slideUp("slow");
                });
                $("#btCriteriosEdicao").click(function(){
                    $("#divDisciplinaEdicao").slideUp("slow");
                    $("#divCriteriosEdicao").slideDown("slow");
                    $("#divNotaEdicao").slideUp("slow");
                });
                $("#btNotaEdicao").click(function(){
                    $("#divDisciplinaEdicao").slideUp("slow");
                    $("#divCriteriosEdicao").slideUp("slow");
                    $("#divNotaEdicao").slideDown("slow");
                });
                $("#btDisciplinaExclusao").click(function(){
                    $("#divDisciplinaExclusao").slideDown("slow");
                    $("#divCriteriosExclusao").slideUp("slow");
                    $("#divNotaExclusao").slideUp("slow");
                });
                $("#btCriteriosExclusao").click(function(){
                    $("#divDisciplinaExclusao").slideUp("slow");
                    $("#divCriteriosExclusao").slideDown("slow");
                    $("#divNotaExclusao").slideUp("slow");
                });
                $("#btNotaExclusao").click(function(){
                    $("#divDisciplinaExclusao").slideUp("slow");
                    $("#divCriteriosExclusao").slideUp("slow");
                    $("#divNotaExclusao").slideDown("slow");
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
                        <div style="margin-bottom: 5px"><input type="button" id="btDisciplinaCadastro" value="Disciplina"/></div>
                        <div style="margin-bottom: 5px"><input type="button" id="btCriteriosCadastro" value="Critérios de Avaliação"/></div>
                        <div style="margin-bottom: 5px"><input type="button" id="btNotaCadastro" value="Nota"/></div>
                    </div>
                    <div style="float:left; margin-top: 15px; margin-left: 25px;">
                        Cadastro
                        <div id="divDisciplinaCadastro">
                            - Disciplina
                            <form method="post" action="/ELearning/DisciplinaCadastro">
                                <div>
                                    <span>Nome:</span>
                                    <span><input id="nomeDisciplina" name="nomeDisciplina"/></span>
                                </div>
                                <div>
                                    <span>Total de notas:</span>
                                    <span><input id="totalNotas" name="totalNotas"/></span>
                                </div>
                                <input type="submit" id="submitDisciplina" name="submitDisciplina" value="Cadastrar"/>
                            </form>
                        </div>
                        <div id="divCriteriosCadastro">
                            - Critérios de avaliação
                            <form method="post" action="/ELearning/CriterioAvaliacaoCadastro">
                                <div>
                                    <span>ID da disciplina:</span>
                                    <span><input id="idDisciplinaCriterio" name="idDisciplinaCriterio"/></span>
                                </div>
                                <div>
                                    <span>Nome:</span>
                                    <span><input id="nomeCriterio" name="nomeCriterio"/></span>
                                </div>
                                <div>
                                    <span>Peso:</span>
                                    <span><input id="pesoCriterio" name="pesoCriterio"/></span>
                                </div>
                                <input type="submit" id="submitCriterios" name="submitCriterios" value="Cadastrar"/>
                            </form>
                        </div>
                        <div id="divNotaCadastro">
                            - Notas
                            <form method="post" action="/ELearning/NotaCadastro">
                                <div>
                                    <span>ID da matrícula:</span>
                                    <span><input id="idMatricula" name="idMatricula"/></span>
                                </div>
                                <div>
                                    <span>ID do critério:</span>
                                    <span><input id="idCriterio" name="idCriterio"/></span>
                                </div>
                                <div>
                                    <span>Nota:</span>
                                    <span><input id="notaCriterio" name="notaCriterio"/></span>
                                </div>
                                <input type="submit" id="submitNota" name="submitNota" value="Cadastrar"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div id="divEdicao">
                <div>
                    <div style="float:left; margin-top: 15px">
                        <div style="margin-bottom: 5px"><input type="button" id="btDisciplinaEdicao" value="Disciplina"/></div>
                        <div style="margin-bottom: 5px"><input type="button" id="btCriteriosEdicao" value="Critérios de Avaliação"/></div>
                        <div style="margin-bottom: 5px"><input type="button" id="btNotaEdicao" value="Nota"/></div>
                    </div>
                    <div style="float:left; margin-top: 15px; margin-left: 25px;">
                        Edição
                        <div id="divDisciplinaEdicao">
                            - Disciplina
                            <form method="post" action="/ELearning/DisciplinaPesquisa">
                                <span>ID da Disciplina:</span>
                                <span><input id="idDisciplinaEdicao" name="idDisciplinaEdicao"/></span>
                                <input type="submit" id="submitDisciplinaEdicao" name="submitDisciplinaEdicao" value="Editar"/>
                            </form>
                        </div>
                        <div id="divCriteriosEdicao">
                            - Critérios de avaliação
                            <form method="post" action="/ELearning/CriterioAvaliacaoPesquisa">
                                <span>ID do Critério:</span>
                                <span><input id="idCriterioEdicao" name="idCriterioEdicao"/></span>
                                <input type="submit" id="submitCriterioEdicao" name="submitCriterioEdicao" value="Editar"/>
                            </form>
                        </div>
                        <div id="divNotaEdicao">
                            - Nota
                            <form method="post" action="/ELearning/NotaPesquisa">
                                <span>ID da Nota:</span>
                                <span><input id="idNotaEdicao" name="idNotaEdicao"/></span>
                                <input type="submit" id="submitNotaEdicao" name="submitNotaEdicao" value="Editar"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div id="divExclusao">
                <div>
                    <div style="float:left; margin-top: 15px">
                        <div style="margin-bottom: 5px"><input type="button" id="btDisciplinaExclusao" value="Disciplina"/></div>
                        <div style="margin-bottom: 5px"><input type="button" id="btCriteriosExclusao" value="Critérios de Avaliação"/></div>
                        <div style="margin-bottom: 5px"><input type="button" id="btNotaExclusao" value="Nota"/></div>
                    </div>
                    <div style="float:left; margin-top: 15px; margin-left: 25px;">
                        Exclusão
                        <div id="divDisciplinaExclusao">
                            - Disciplina
                            <form method="post" action="/ELearning/DisciplinaExclusao">
                                <span>ID da Disciplina:</span>
                                <span><input id="idDisciplinaExclusao" name="idDisciplinaExclusao"/></span>
                                <input type="submit" id="submitDisciplinaExclusao" name="submitDisciplinaExclusao" value="Excluir"/>
                            </form>
                        </div>
                        <div id="divCriteriosExclusao">
                            - Critérios de avaliação
                            <form method="post" action="/ELearning/CriterioAvaliacaoExclusao">
                                <span>ID do Critério:</span>
                                <span><input id="idCriterioExclusao" name="idCriterioExclusao"/></span>
                                <input type="submit" id="submitCriterioExclusao" name="submitCriterioExclusao" value="Excluir"/>
                            </form>
                        </div>
                        <div id="divNotaExclusao">
                            - Nota
                            <form method="post" action="/ELearning/NotaExclusao">
                                <span>ID da Nota:</span>
                                <span><input id="idNotaExclusao" name="idNotaExclusao"/></span>
                                <input type="submit" id="submitNotaExclusao" name="submitNotaExclusao" value="Excluir"/>
                            </form>
                        </div>
                    </div>
                </div>
        </fieldset>
    </body>
</html>