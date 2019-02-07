<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="exame==null || exame.Id == null">
	<s:set var="title" value="Incluir novo exame" />
</s:if>
<s:else>
	<s:set var="title" value="Atualizar exame" />
</s:else>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<link href="<s:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css"/>
<link href="<s:url value='/css/app.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h3>
		<s:text name="Cadastro de Exames" />
	</h3>
	<s:form action="saveExame" method="post" class="form-group">
		<s:textfield key="exame.nome" id="nome" label="Nome do Exame" class="form-control"/>
		<s:textfield key="exame.descricao" id="descricao" label="Descrição do Exame" class="form-control" />
		<s:hidden name="exame.Id" value="%{exame.Id}" />
		<s:submit value="Salvar" class="btn btn-primary" />
		<s:submit value="Cancelar" action="index" class="btn btn-primary" />
	</s:form> 	
</body>
</html>