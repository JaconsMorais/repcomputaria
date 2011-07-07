<%-- 
    Document   : editDiscipline
    Created on : 02/07/2011, 13:25:09
    Author     : Acessa SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="ELearning.services.client.disciplina.Disciplina"%>
<%
Disciplina disciplinaEdicao = (Disciplina)request.getAttribute("editDiscipline");
request.getSession().setAttribute("editDiscipline",disciplinaEdicao);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar disciplina</title>
    </head>
    <body>
        <div id="divDisciplinaCadastro">
            - Disciplina
            <form method="post" action="/ELearning/DisciplinaEdicao">
                <div>
                    <span>Nome:</span>
                    <span><input id="nomeDisciplina" name="nomeDisciplina" value="<%=disciplinaEdicao.getNomeDisciplina()%>"/></span>
                </div>
                <div>
                    <span>Total de notas:</span>
                    <span><input id="totalNotas" name="totalNotas" value="<%=disciplinaEdicao.getNumNotas()%>"/></span>
                </div>
                <input type="submit" id="submitDisciplina" name="submitDisciplina" value="Editar"/>
            </form>
        </div>
    </body>
</html>
