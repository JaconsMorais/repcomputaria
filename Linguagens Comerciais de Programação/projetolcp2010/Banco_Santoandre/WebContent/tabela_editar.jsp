<%@ page import="java.sql.ResultSet"%>
<%@ page import="BancoLCP.DAO.OpFuncDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilos_menu.css" />
</head>

<body class="marTop textoNormal">
<center>
<strong>
<table>
<%
OpFuncDAO DAOSelect = new OpFuncDAO();
ResultSet rs = DAOSelect.select("Cliente",(String)request.getParameter("nome"),(String)request.getParameter("endereco"),(double) Float.parseFloat((String)request.getParameter("cpf")));
while(rs.next()){%>
	<tr class="thead">
		<td>
			ID
		</td>
		<td>
			Nome
		</td>
		<td>
			Endereço
		</td>
	</tr>
	<tr>
	  <td><%=rs.getString("ID")%></td>
	  <td><%=rs.getString("nome")%></td>
          <td><%=rs.getString("endereco")%></td>
          <td><%=rs.getString("cpf")%></td>
	  <td class="valor"><font color="#FF000000">R$ <%=rs.getString("saldo")%></font></td>
	</tr>
	<tr>
		<td><%=rs.getString("data")%></td>
		<td><%=rs.getString("tipo")%></td>
		<td>R$ <%=rs.getString("valor")%></td>
	</tr>
<%}%>
</table></strong>
</center>
</body>
</html>
