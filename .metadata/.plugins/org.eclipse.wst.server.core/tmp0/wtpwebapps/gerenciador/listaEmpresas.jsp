<%@page import="com.alura.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	Lista de empresas: <br />
	
	<ul>
		// Es mas escalable y mantenible
		<c:forEach items="${empresas}" var="empresa">
			<li>${ empresa.nombre } - <fmt:formatDate value="${ empresa.fechaApertura }" pattern="dd/MM/yyyy"/></li>
		</c:forEach>
		
	</ul>
	
	<ul>
		<% // No es escalable
			List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas"); //${empresas}
			for (Empresa empresa : lista) {
		%>
			<li><%= empresa.getNombre()%></li>
		<% 
			}
		%>
		
	</ul>

</body>
</html>