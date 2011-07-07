<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilos_menu.css" />
</head>

<body class="textoNormal">
<form action="tabela_editar.jsp" method="post">
<center>
    <div class="marTop">
		<h1>Informe os dados para pesquisa de cliente</h1>
		<div class="cpf">
		CPF: <input style="margin-right: 1px" maxlength="11" type="text" name="cpf" />
		</div>
		<div class="nome">
		Nome: <input type="text" maxlength="30" name="nome" />
		</div>
		<div style="margin-right: 5px" class="endereco">
		Endereço: <input type="text" maxlength="50" name="endereco" />
		</div>
		<input type="submit" class="cadastro" value="Pesquisar"/>
	</div>
</center>
</form>
</body>
</html>