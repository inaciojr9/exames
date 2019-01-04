<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestão de Exames</title>
<sb:head includeScripts="true" includeScriptsValidation="true" includeStyles="true"/>
<style type="text/css">
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Gestão de Exames - <s:text
					name="app.version" /></a>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="<s:url action='listagem'/>">Home</a></li>
				<li><a href="<s:url action='edicao'/>">Novo</a></li>
				<li><a href="<s:url action='listagem'/>">Consulta</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h1>Exames</h1>
		</div>
		<div class="row">
			<s:form action="pesquisa" theme="bootstrap" cssClass="form-inline" >
				<div class="form-group">
					<label for="nome">Nome:</label>
		  			<s:textfield id="nome" name="nome" />
		  		</div>
		  		<s:submit cssClass="btn btn-primary" value="Pesquisar" />
		  	</s:form>
		</div>
		<br>
		<div class="row">
			<s:actionerror theme="bootstrap"/>
            <s:actionmessage theme="bootstrap"/>
			<div>
				<a href="<s:url action='edicao' />" class="btn btn-primary">Novo</a>
			</div>
			<table class="table table-striped">
				<thead>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Cadastro</th>
					<th>Ativo</th>
					<th>Obs</th>
					<th>última Atualização</th>
					<th></th>
					<th></th>
				</thead>
				<tbody>
					<s:iterator value="exames" var="exame">
						<tr>
							<td><s:property value="nome" /></td>
							<td><s:property value="descricao" /></td>
							<td><s:date name="cadastro" format="dd/MM/yyyy" /></td>
							<!-- <td><fmt:formatDate value="${exame.cadastro}" pattern="dd/MM/yyyy"/></td>  -->
							<td><s:property value="ativo" /></td>
							<td><s:property value="obs" /></td>
							<td><s:date name="ultimaAtualizacao"
									format="dd/MM/yyyy hh:mm:ss" /></td>
							<!-- <td><fmt:formatDate value="${exame.ultimaAtualizacao}" pattern="dd/MM/yyyy hh:mm:ss"/></td>   -->
							<td><div>
									<a
										href="<s:url action='edicao'><s:param name="id" ><s:property value="id" /></s:param></s:url>">Editar</a>
								</div></td>
							<td><a
								href="<s:url action='delete'><s:param name="id" ><s:property value="id" /></s:param></s:url>">Excluir</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<div>
				<a href="<s:url action='edicao'/>" class="btn btn-primary">Novo</a>
			</div>
		</div>
	</div>
	<footer>
		<p class="pull-right">
			<a href="#">Back to top</a>
		</p>
		<p>
			Criado por <a href="http://twitter.com/inaciojr9" target="_blank">@inaciojr9</a>.
		</p>
	</footer>
</body>
</html>