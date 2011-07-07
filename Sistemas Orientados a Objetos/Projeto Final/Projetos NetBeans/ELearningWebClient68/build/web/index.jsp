<%-- 
    Document   : index
    Created on : 26/06/2011, 13:48:57
    Author     : Acessa SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Learning</title>
    </head>
    <body>
        <form action="/ELearning/Login" method="post" style="text-align: center">
            <h1>Seja bem-vindo ao sistema de E-Learning</h1>
            <br/>
            <div id="divCampos">
                <div id="divLogin">
                    <span>Login:</span>
                    <span><input name="login" id="login"/></span>
                </div>
                <div id="divSenha">
                    <span>Senha: </span>
                    <span><input type="password" name="senha" id="senha"/>
                </div>
            </div>
            <br/>
            <div id="divButton">
                <span><input type="submit" name="submitLogin" id="submitLogin" value="Login"/></span>
            </div>
    </body>
</html>
