<%-- 
    Document   : editProfessor
    Created on : 02/07/2011, 13:24:22
    Author     : Acessa SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ELearning.services.client.professor.Professor"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
Professor professorEdicao = (Professor)request.getAttribute("editUser");
request.getSession().setAttribute("editUser",professorEdicao);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Professor</title>
    </head>
    <body>
        <form method="post" action="/ELearning/ProfessorEdicao">
            <div>
                <span>Login:</span>
                <span><input id="loginProfessor" name="loginProfessor" value="<%=professorEdicao.getLogin()%>"/></span>
            </div>
            <div>
                <span>Senha:</span>
                <span><input id="senhaProfessor" name="senhaProfessor" value="<%=professorEdicao.getSenha()%>"/></span>
            </div>
            <div>
                <span>Endereço:</span>
                <span><input id="enderecoProfessor" name="enderecoProfessor" value="<%=professorEdicao.getEndereco()%>"/></span>
            </div>
            <div>
                <span>Telefone:</span>
                <span><input id="telefoneProfessor" name="telefoneProfessor" value="<%=professorEdicao.getTelefone()%>"/></span>
            </div>
            <input type="submit" id="submitProfessor" name="submitProfessor" value="Editar"/>
        </form>
    </body>
</html>
