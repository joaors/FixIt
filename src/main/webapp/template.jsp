<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Fix It - Sistema de Chamados</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    </head>
    <body>        
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-header"> 
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-1">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span> 
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}">Início</a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-1">
                    <ul class="nav navbar-nav">
                        <li> 
                            <a href="${pageContext.request.contextPath}/chamados/listar">Chamados</a> 
                        </li>
                        <li> 
                            <a href="${pageContext.request.contextPath}/produtos/listar">Produtos</a> 
                        </li>
                        <li> 
                            <a href="${pageContext.request.contextPath}/clientes/listar">Clientes</a> 
                        </li>
                        <li> 
                            <a href="${pageContext.request.contextPath}/atendentes/listar">Atendentes</a>
                        </li>                                                 
                    </ul>
                </div>
            </div>
        </nav> 
        <div class="container" role="main">
            <div>
                <tiles:insertAttribute name="breadCrumb"/>            
            </div> 
            <c:if test="${mensagem != null}">
                <div class="${mensagem.tipoMensagem.classeCss}" role="alert">${mensagem.texto}</div> 
            </c:if>

            <div>
                <div class="panel-body">
                    <tiles:insertAttribute name="corpo" />
                </div>
            </div>
        </div>
    </body>
</html>

