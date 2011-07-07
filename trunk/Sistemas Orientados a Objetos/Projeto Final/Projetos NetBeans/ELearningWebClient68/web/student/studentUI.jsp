<%-- 
    Document   : studentUI
    Created on : 26/06/2011, 14:36:35
    Author     : Acessa SP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="ELearning.services.client.aluno.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Área do Aluno</title>
        <script type="text/javascript">
            function setIndex(n){
                document.getElementById("index").value = n;
                document.getElementById("form").submit();
            }
        </script>
    </head>
    <body>
        <h1>Escolha sua matrícula</h1>
        
        <%
            List<StudentEnrollmentModel> matriculas = (List<StudentEnrollmentModel>)request.getSession().getAttribute("enrollments");
             
            if(matriculas.size() > 0){%>
                <form id="form" method="post" action="/ELearning/MatriculaCadastro">
                    <input type="hidden" id="index" name="index"/>
                    <table>
                        <tr>
                            <td><b>Nome da disciplina</b></td>
                            <td><b>Professor</b></td>
                            <td><b>Data Início</b></td>
                            <td><b>Data Fim</b></td>
                            <td><b>Matricular</b></td>
                        </tr>
                        <%for(StudentEnrollmentModel model : matriculas){ %>
                        <tr>
                            <td><%=model.getNomeDisciplina()%></td>
                            <td><%=model.getLogin()%></td>
                            <td><%=model.getDataInicio()%></td>
                            <td><%=model.getDataFim()%></td>
                            <td><input type="button" value="Matricular" onclick="javascript:setIndex(<%=model.getIdDisciplina()%>);"/></td>
                        </tr>
                        <%}%>
                    </table>
                </form>
          <%}else{%>
                Não há disciplinas no momento.
          <%}%>
    </body>
</html>
