<%-- 
    Document   : editStudent
    Created on : 02/07/2011, 13:23:41
    Author     : Acessa SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ELearning.services.client.aluno.Aluno"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
Aluno alunoEdicao = (Aluno)request.getAttribute("editUser");
request.getSession().setAttribute("editUser", alunoEdicao);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Aluno</title>
    </head>
    <body>
        <form method="post" action="/ELearning/AlunoEdicao">
            <div>
                <span>Login:</span>
                <span><input id="loginAluno" name="loginAluno" value="<%=alunoEdicao.getLogin()%>"/></span>
            </div>
            <div>
                <span>Senha:</span>
                <span><input id="senhaAluno" name="senhaAluno" value="<%=alunoEdicao.getSenha()%>"/></span>
            </div>
            <div>
                <span>Endereço:</span>
                <span><input id="enderecoAluno" name="enderecoAluno" value="<%=alunoEdicao.getEndereco()%>"/></span>
            </div>
            <div>
                <span>Telefone:</span>
                <span><input id="telefoneAluno" name="telefoneAluno" value="<%=alunoEdicao.getTelefone()%>"/></span>
            </div>
            <input type="submit" id="submitAluno" name="submitAluno" value="Editar"/>
        </form>
    </body>
</html>
