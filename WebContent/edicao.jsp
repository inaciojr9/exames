<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="${encoding}" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edição de Exames</title>
<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
<!--[if lt IE 9]>
	    	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	    <![endif]-->
<sb:head />
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
			<h1>Gestão de Exames</h1>
		</div>
		<div class="row">
			<s:actionerror theme="bootstrap" />
			<s:actionmessage theme="bootstrap" />
			<s:fielderror theme="bootstrap" />
			<s:form action="persistencia" theme="bootstrap"
				cssClass="form-horizontal" label="Cadastro de Exame">
				<s:hidden name="exame.id" />
				<s:textfield name="exame.nome" label="Nome:" />
				<s:textfield name="exame.descricao" label="Descrição:" />
				<s:textfield type="date" label="Cadastro:" name="exame.cadastro"
					value="%{txtCadastro}" />
				<s:checkbox name="exame.ativo" label="Ativo" />
				<s:textarea name="exame.obs" label="Observação" />
				<s:date name="exame.ultimaAtualização" format="ddMMaaaa hh:mm:ss" />
				<s:submit cssClass="btn btn-primary" value="Salvar" />
			</s:form>
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