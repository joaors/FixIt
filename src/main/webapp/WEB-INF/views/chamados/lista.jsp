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
                    <li><a href="${pageContext.request.contextPath}/chamados/listar">Chamados</a></li>
                </ol>            
            </tiles:putAttribute>          

            <tiles:putAttribute name="corpo">

                <table class="table table-striped table-responsive table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Título</th>
                            <th>Cliente</th>
                            <th>Produto</th>
                            <th>Situação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${chamados}">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.titulo}</td>
                                <td>${p.cliente.descricao}</td>
                                <td>${p.produto.descricao}</td>
                                <td><span class="${p.situacao.classeCss}">${p.situacao}</span></td>
                                <td>
                                    <c:if test="${p.situacao != 'Finalizado'}">
                                        <a href="${pageContext.request.contextPath}/chamados/excluir?idChamado=${p.id}">
                                    </c:if>                                    
                                    <input type="button" value="Excluir" class="btn btn-danger" ${p.situacao == 'Finalizado' ? 'disabled' : ''}/>
                                    <c:if test="${p.situacao != 'Finalizado'}">
                                        </a>
                                    </c:if>
                                    
                                    <c:if test="${p.situacao != 'Finalizado'}">
                                        <a href="${pageContext.request.contextPath}/chamados/editar?idChamado=${p.id}">
                                    </c:if>                                    
                                        <input type="button" value="Editar" class="btn btn-info" ${p.situacao == 'Finalizado' ? 'disabled' : ''}/>
                                    <c:if test="${p.situacao != 'Finalizado'}">
                                        </a>
                                    </c:if>                                    
                                </td>                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>            
                <a href="${pageContext.request.contextPath}/chamados/preparaCadastroChamado">                    
                    <input type="button" value="Novo Chamado" class="btn btn-lg btn-success"/>
                </a>

            </tiles:putAttribute>
        </tiles:insertDefinition>
    </html>