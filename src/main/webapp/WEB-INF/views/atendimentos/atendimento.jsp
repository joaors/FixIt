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
                    <li>Atendimentos</li>
                </ol>            
            </tiles:putAttribute>          

            <tiles:putAttribute name="corpo">
                <springform:form method="post" action="${pageContext.request.contextPath}/atendimentos/cadastrar" modelAttribute="atendimento">                    
                    <div class="col-md-4">
                        <div class="row">
                            <div class="form-group">
                                <label for="atendenteOrigem">Atendente Origem:</label>
                                <springform:select id="atendenteOrigem" path="atendenteOrigem.id" cssClass="form-control">
                                    <c:forEach items="${origens}" var="a">
                                        <option value="${a.id}">${a.descricao}</option>
                                    </c:forEach>
                                </springform:select>									
                            </div>

                            <div class="form-group">
                                <label for="atendenteDestino">Atendente Destino:</label>
                                <springform:select id="atendenteDestino" path="atendenteDestino.id" cssClass="form-control">
                                    <c:forEach items="${destinos}" var="d">
                                        <option value="${d.id}">${d.descricao}</option>
                                    </c:forEach>
                                </springform:select>									
                            </div>

                            <div class="form-group">
                                <label for="observacao">Detalhes</label>
                                <springform:textarea path="observacao" rows="10" cols="20" cssClass="form-control"/>
                            </div>                            
                            <springform:hidden path="chamado.id"/>
                            <input type="hidden" name="id" value="${atendimento.id}"/>                            
                        </div>
                        <input type="submit" value="Gravar" class="btn btn-lg btn-primary" />
                    </div>                    
                </springform:form>                
            </tiles:putAttribute>
        </tiles:insertDefinition>
    </html>