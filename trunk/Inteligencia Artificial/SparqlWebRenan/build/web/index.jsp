<%--
    Universidade: UNESP campus Rio Claro
    Document   : index
    Created on : 22/06/2009, 09:16:54
    Author     : Renan Aleixo Paganatto
    Gostaria de agradecer ao professor Erik Aceiro pela grande ajuda para
    conseguir criar a página e finalizar o trabalho!!!!!
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Esportes</title>
    </head>
    <body>
        <h1><center>******* Digite valores abaixo para encontrar um esporte recomendável *******</center></h1><hr />
       <img src="C:\Documents and Settings\Renan\Desktop\SparqlWeb\src\esportes.gif" alt="esportes.gif" style="float:left;" />
	   <img src="C:\Documents and Settings\Renan\Desktop\SparqlWeb\src\esportes.gif" alt="esportes.gif" style="float:right;" />
       <p><center>
        <form action="teste" method="POST">
            <table border="0">
                <tr><td>Peso (kg): </td> <td><input type="text" name="txtpeso" value=70 length="30"/> </td></tr>
                <tr><td>Altura (cm): </td> <td><input type="text" name="txtaltura" value=175 length="30"/></td><br></tr>
                <tr><td>Tamanho das Mãos (cm): </td> <td><input type="text" name="txtmaos" value=15 length="30"/></td><br></tr>
                <tr><td>Tamanho dos Pés (cm): </td> <td><input type="text" name="txtpes" value=39 length="30"/></td><br></tr>
                <tr><td>Massa Muscular: </td> <td><input type="text" name="txtmassa" value="media" length="30"/></td><br></tr>
                <tr><td>Sexo: </td> <td> <input type="text" name="txtsexo" value="masculino" length="30"/></td><br></tr>
                <tr><td>Envergadura: </td> <td> <input type="text" name="txtenvergadura" value="proporcionais" length="30"/></td></tr>
            </table><br><hr /><br>
			<tr><td><center><input type="submit" name="Enviar" value="CONSULTAR"/></center><br></td></tr>
        </form>
		</center>
       </p>
    </body>
</html>

