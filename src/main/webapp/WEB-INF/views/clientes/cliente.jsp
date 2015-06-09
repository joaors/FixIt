<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<html xmlns:th="http://www.thymeleaf.org">
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <tiles:insertDefinition name="template">

            <tiles:putAttribute name="breadCrumb">
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/clientes/listar">Clientes</a></li>
                </ol>            
            </tiles:putAttribute>          

            <tiles:putAttribute name="corpo">

                <springform:form method="post" action="${pageContext.request.contextPath}/clientes/cadastrar" modelAttribute="cliente">
                    <div class="row">
                        <div class="form-group">
                            <label for="descricao">Descrição</label>
                            <springform:input id="descricao" path="descricao" cssClass="form-control" />
                        </div>
                        <input type="hidden" name="id" value="${cliente.id}"/>
                    </div>

                    <input type="submit" value="Gravar" class="btn btn-lg btn-primary" />
                </springform:form>
            </tiles:putAttribute>
        </tiles:insertDefinition>
    </html>