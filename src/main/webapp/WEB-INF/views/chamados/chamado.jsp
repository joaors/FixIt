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
                    <li><a href="${pageContext.request.contextPath}/chamados/listar">Chamados</a></li>
                </ol>            
            </tiles:putAttribute>          

            <tiles:putAttribute name="corpo">

                <springform:form method="post" action="${pageContext.request.contextPath}/chamados/cadastrar" modelAttribute="chamado">
                    <div class="col-md-4">
                        <div class="row">                    
                            
                            <div class="form-group">
                                <label for="situacao">Situacao:</label>
  				<springform:select id="situacao" path="situacao" cssClass="form-control">
                                    <c:forEach items="${situacoes}" var="e">
                                        <option value="${e}">${e}</option>
                                    </c:forEach>
				</springform:select>
                            </div>                           
                            <div class="form-group">					
                                <label for="atendente">Atendente:</label>
                                <springform:select id="atendente" path="atendente.id" cssClass="form-control">
                                    <c:forEach items="${atendentes}" var="a">
                                        <option value="${a.id}">${a.descricao}</option>
                                    </c:forEach>
                                </springform:select>									
                            </div>

                            <div class="form-group">					
                                <label for="cliente">Cliente:</label>
                                <springform:select id="cliente" path="cliente.id" cssClass="form-control">
                                    <c:forEach items="${clientes}" var="c">
                                        <option value="${c.id}">${c.descricao}</option>
                                    </c:forEach>
                                </springform:select>									
                            </div>

                            <div class="form-group">					
                                <label for="produto">Produto:</label>
                                <springform:select id="produto" path="produto.id" cssClass="form-control">
                                    <c:forEach items="${produtos}" var="p">
                                        <option value="${p.id}">${p.descricao}</option>
                                    </c:forEach>
                                </springform:select>									
                            </div>
                            <div class="form-group">
                                <label for="titulo">Titulo</label>
                                <springform:input path="titulo" cssClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="descricao">Detalhes</label>
                                <springform:textarea path="descricao" rows="10" cols="20" cssClass="form-control"/>
                            </div>
                            <input type="hidden" name="id" value="${chamado.id}"/>
                        </div>
                        <input type="submit" value="Gravar" class="btn btn-lg btn-primary" />
                    </div>                    
                </springform:form>
                <springform:form method="get" action="${pageContext.request.contextPath}/atendimentos/preparaCadastroAtendimento" modelAttribute="chamado">                    
                    <div class="col-md-8">                   
                        <table class="table table-striped table-responsive table-hover">
                            <thead>
                                <tr>
                                    <th>Origem</th>
                                    <th>Destino</th>
                                    <th>Observação</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="a" items="${atendimentos}">
                                    <tr>
                                        <td>${a.atendenteOrigem.descricao}</td>
                                        <td>${a.atendenteDestino.descricao}</td>
                                        <td>${a.observacao}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <input type="hidden" name="id" value="${chamado.id}"/>
                        <input type="submit" value="Add Atendimento" class="btn btn-lg btn-success" ${disableAddAtendimento ? 'disabled' : ''}/>
                    </div>
                </springform:form>                 
            </tiles:putAttribute>
        </tiles:insertDefinition>
    </html>