<%@ page import="java.sql.ResultSet"%>
<%@ page import="BancoLCP.DAO.ClienteDAO"%>
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
ClienteDAO DAOSelect = new ClienteDAO();
ResultSet rs = DAOSelect.selectTransacao((long) Integer.parseInt((String)request.getAttribute("ID")));
while(rs.next()){%>
	<tr class="thead">
		<td>
			Data da Transa&ccedil;&atilde;o
		</td>
		<td>
			Transação
		</td>
		<td>
			Valor
		</td>
	</tr>
	<tr>
	  <td><%=rs.getString("data")%></td>
	  <td><%=rs.getString("tipo")%></td>
	  <td class="valor"><font color="#FF000000">R$ <%=rs.getString("valor")%></font></td>
	</tr>
	<tr>
		<td><%=rs.getString("data")%></td>
		<td><%=rs.getString("tipo")%></td>
		<td>R$ <%=rs.getString("valor")%></td>
	</tr>
<%}%>
	<tr class="tfoot">
	  <td class="total">
	  Saldo Total Disponível
	  </td>
          <td colspan="2" class="valor">R$ <%=request.getAttribute("saldo")%></td>
	</tr>
</table></strong>
</center>
</body>
</html>
