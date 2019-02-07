<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <s:head />
        <link href="<s:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css"/>
        <title><s:text name="Exames"/></title>
    </head>
    <body>
        
        <h3><s:text name="Lista de Exames"/></h3>
        <s:url var="url" action="inputExame" />
        <a href="<s:property value="#url"/>">Incluir Novo Exame</a>
        <br/><br/>
        <table class="table table-striped">
            <tr>
                <th>Nome do Exame</th>
                <th>Descrição do Exame</th>
                <th>&nbsp;</th>
            </tr>
            <s:iterator value="exames" status="status">
                <tr>
                    <td><s:property value="nome"/></td>
                    <td><s:property value="descricao"/></td>
                    <td>
                        <s:url action="inputExame" var="url">
                            <s:param name="exame.Id" value="id"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">Editar</a>
                        &nbsp;&nbsp;&nbsp;
                        <s:url action="deleteExame" var="url">
                            <s:param name="exame.Id" value="id"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">Excluir</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>