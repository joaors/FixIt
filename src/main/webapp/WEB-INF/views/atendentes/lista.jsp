<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns:th="http://www.thymeleaf.org">
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <tiles:insertDefinition name="template">

            <tiles:putAttribute name="breadCrumb">
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/atendentes/listar">Atendentes</a></li>
                </ol>            
            </tiles:putAttribute>          

            <tiles:putAttribute name="corpo">

                <table class="table table-striped table-responsive table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Descrição</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${atendentes}">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.descricao}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/atendentes/excluir?idAtendente=${p.id}">
                                        <input type="button" value="Excluir" class="btn btn-danger" />
                                    </a>                                
                                    <a href="${pageContext.request.contextPath}/atendentes/editar?idAtendente=${p.id}">
                                        <input type="button" value="Editar" class="btn btn-info" />
                                    </a>
                                </td>                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>            
                <a href="${pageContext.request.contextPath}/atendentes/preparaCadastroAtendente">
                    <input type="button" value="Novo Atendente" class="btn btn-lg btn-success" />
                </a>

            </tiles:putAttribute>
        </tiles:insertDefinition>
    </html>