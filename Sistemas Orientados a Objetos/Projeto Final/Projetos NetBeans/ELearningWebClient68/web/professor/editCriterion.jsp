<%-- 
    Document   : editCriterion
    Created on : 02/07/2011, 13:24:56
    Author     : Acessa SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="ELearning.services.client.criterioavaliacao.CriterioAvaliacao"%>
<%
CriterioAvaliacao criterioEdicao = (CriterioAvaliacao)request.getAttribute("editCriterion");
request.getSession().setAttribute("editCriterion",criterioEdicao);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Critério de avaliação</title>
    </head>
    <body>
        <form method="post" action="/ELearning/CriterioAvaliacaoEdicao">
            <div>
                <span>ID da disciplina:</span>
                <span><input id="idDisciplinaCriterio" name="idDisciplinaCriterio" disabled="disabled" value="<%=criterioEdicao.getIdDisciplina()%>"/></span>
            </div>
            <div>
                <span>Nome:</span>
                <span><input id="nomeCriterio" name="nomeCriterio" value="<%=criterioEdicao.getNome()%>"/></span>
            </div>
            <div>
                <span>Peso:</span>
                <span><input id="pesoCriterio" name="pesoCriterio" value="<%=criterioEdicao.getPeso()%>"/></span>
            </div>
            <input type="submit" id="submitCriterios" name="submitCriterios" value="Editar"/>
        </form>
    </body>
</html>
