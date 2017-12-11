<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.Cardapio" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<% 
	Cardapio cardapio = (Cardapio) request.getAttribute("cardapio");
%>
<h2>Cardapio</h2>
<table class="table table-hover">
	<thead>
    	<tr>
    		<th><b>Id: </b></th>
    		<th><b>Nome: </b></th>
    		<th><b>Descricao: </b></th>
    		<th><b>Valor: </b></th>
    		<th><b>Disponibilidade: </b></th>
    		<th><b>Tipo: </b></th>
    	</tr>
    </thead>
    <tbody>
    	<tr>
			<td><%= cardapio.getIdProduto()				%>	</td>
			<td><%= cardapio.getNomeProduto() 			%>	</td>
			<td><%= cardapio.getDescricaoProduto()		%>	</td>
			<td><%= cardapio.getValorUnitarioProduto()	%>	</td>
			<td><%= cardapio.isDisponibilidadeProduto()	%>	</td>
			<td><%= cardapio.getTipoProduto()			%>	</td>
		</tr>
	</tbody>
</table>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>