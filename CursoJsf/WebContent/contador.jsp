<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Contagem de Acessos por Pagina</title>
	<style type="text/css">
	caption, td, th, tr, thead, tbody, tfoot, table {
		border: 1px solid black;
		padding: 2px;
		margin: 0px;
		border-collapse: collapse;
		border-spacing: 0px;
	}
	caption {
		font-weight: bold;
		border-bottom: none;
	}
	</style>
</head>
<body>
	<c:if test="${empty contador}">
		Nenhum acesso contado
	</c:if>
	<c:if test="${not empty contador}">
	<table>
		<caption>Contagem de Acessos por Pagina</caption>
		<thead>
			<tr>
				<th style="text-align: left;">Pagina</th>
				<th>Quantidade de Acessos</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contador}" var="item">
			<tr>
				<td>${item.key}</td>
				<td style="text-align: center;">${item.value}</td>
			</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<a href="index.xhtml">Voltar</a>
				</td>
			</tr>
		</tfoot>
	</table>
	</c:if>
</body>
</html>