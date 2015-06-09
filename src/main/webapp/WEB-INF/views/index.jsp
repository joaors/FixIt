<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <tiles:insertDefinition name="template">
        <tiles:putAttribute name="breadCrumb">
            <ol class="breadcrumb">
              <li><a href="${pageContext.request.contextPath}">Home</a></li>
            </ol>            
        </tiles:putAttribute>        
        <tiles:putAttribute name="corpo">
            <p></p>
            <div class="jumbotron">
              <h1>Olá, bem vindo ao FixIt</h1>
            </div>            
        </tiles:putAttribute>
    </tiles:insertDefinition>
</html>


