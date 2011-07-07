<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="geral.js"></script> 
<link rel="stylesheet" type="text/css" href="estilos_menu.css" /> 

<script type="text/javascript" src="jquery.js"></script>
<script>
 function verificaClique(valor){
	
}

 function expandeMenuClientes(){
   var menuClientes = true;
   $(".link_clientes").click(function(event){
	  if(menuClientes){ 
	    menuClientes = false;
		$(".servicos_clientes").slideDown("slow");
	  }else{
		menuClientes = true;
		$(".servicos_clientes").slideUp("slow");
	  }
   }); 
 }
 
 function expandeMenuFuncionarios(){
   var menuFuncionarios = true;
   $(".link_funcionarios").click(function(event){
	  if(menuFuncionarios){ 
	    menuFuncionarios = false;
		$(".servicos_funcionarios").slideDown("slow");
	  }else{
		menuFuncionarios = true;
		$(".servicos_funcionarios").slideUp("slow");
	  }
   }); 
 }
 
 
 function expandeMenuOutrosPedidos(){
   var menuOutrosServicos = true;
   $(".link_outros_pedidos").click(function(event){
	  if(menuOutrosServicos){ 
	    menuOutrosServicos = false;
		$(".servicos_outros_pedidos").slideDown("slow");
	  }else{
		menuOutrosServicos = true;
		$(".servicos_outros_pedidos").slideUp("slow");
	  }
   }); 
 }
 function init(){
 $(document).ready(function(){
	expandeMenuClientes();
	expandeMenuFuncionarios();
	expandeMenuOutrosPedidos();
 });
 }
</script>
</head>
<body onload="init();">
<form method="post" id="enviarDados" action="verificaClique(valor);">
<center>
<div align="center" style="width:400px; height:700px;" class="fundoLogo">

<%if(((String)request.getAttribute("tipo")).equals("Cliente")){%>
	<div class="fundoLogo">
		<a onclick="frameSize();" class="link_clientes">Clientes</a>
		<div class="servicos_clientes">
			<a class="link" href="sacar.jsp" id="saque" target="direita">Saque</a>
			<br />
			<a class="link" href="saldo.jsp" id="saldo" target="direita">Saldos</a>
			<br />
			<a class="link" href="deposito.jsp" id="deposito" target="direita">Depósitos</a>
			<br />
			<a class="link" href="extrato.jsp" id="extrato" target="direita">Extratos</a>
		</div>
	</div>
<%}else{%>
	<div class="fundoLogo">
		<a onclick="frameSize();" class="link_funcionarios">Operações de funcionário</a>
		<div class="servicos_funcionarios">
			<a class="link" href="cadastrar.jsp" id="cadastrar" target="direita">Cadastrar</a>
			<br />
			<a class="link" href="editar.jsp" id="editar" target="direita">Editar</a>
			<br />
			<a class="link" href="excluir.jsp" id="remover" target="direita">Remover</a>
			<br />
			<a class="link" href="localizar.jsp" id="localizar" target="direita">Localizar</a>
		</div>
	</div>
<%}
//}else{%>
 <!--
 <center>
 Login inválido
 <br/>
 <a href="javascript:history.back();">Voltar</a>
 </center>
 -->
<%//}%>
	
</div>
</center>
</form>
</body>
</html>
