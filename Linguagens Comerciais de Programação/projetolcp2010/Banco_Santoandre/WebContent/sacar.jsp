 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilos_menu.css" /> 
</head>
<body class="textoNormal">
<form action="" method="post">
<h1 align="center">Selecione o valor do saque em R$:</h1>
<div class="saques" align="center">
<ul class="opcoes">
<li><input type="submit" style="width:1000px; height:50px" value="20" name="sacar"></li>
<li><input class="marTop" type="submit" style="width:1000px; height:50px" value="30" name="sacar"></li>
<li><input class="marTop" type="submit" style="width:1000px; height:50px" value="50" name="sacar"></li>
<li><input class="marTop" type="submit" style="width:1000px; height:50px" value="100" name="sacar"></li>
<li><input class="marTop" type="submit" style="width:1000px; height:50px" value="250" name="sacar"></li>
<li class="marTop">Outro valor. Qual? R$ <input id="qualquer_valor" name="sacar" type="text"/></li> 
<li><input class="marTop" name="sacar" value="Confirmar" type="submit"/></li>
</ul>

</div>
</form>
</body>
</html>