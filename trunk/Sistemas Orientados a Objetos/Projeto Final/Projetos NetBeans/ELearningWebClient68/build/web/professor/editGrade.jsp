<%-- 
    Document   : editGrade
    Created on : 02/07/2011, 13:24:35
    Author     : Acessa SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="ELearning.services.client.nota.Nota"%>
<%
Nota notaEdicao = (Nota)request.getAttribute("editGrade");
request.getSession().setAttribute("editGrade",notaEdicao);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Nota</title>
    </head>
    <body>
        <form method="post" action="/ELearning/NotaEdicao">
            <div>
                <span>ID da matrícula:</span>
                <span><input id="idMatricula" name="idMatricula" disabled="disabled" value="<%=notaEdicao.getIdMatricula()%>"/></span>
            </div>
            <div>
                <span>ID do critério:</span>
                <span><input id="idCriterio" name="idCriterio" disabled="disabled" value="<%=notaEdicao.getIdCriterion()%>"/></span>
            </div>
            <div>
                <span>Nota:</span>
                <span><input id="notaCriterio" name="notaCriterio" value="<%=notaEdicao.getNotaCriterio()%>"/></span>
            </div>
            <input type="submit" id="submitNota" name="submitNota" value="Editar"/>
        </form>
    </body>
</html>
