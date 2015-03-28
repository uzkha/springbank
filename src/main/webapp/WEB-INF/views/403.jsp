<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringBank</title>

<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-theme.css"
	rel="stylesheet" type="text/css" />

<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-validation/dist/jquery.validate.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-validation/dist/localization/messages_pt_BR.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/validation.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/datepicker/js/bootstrap-datepicker.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/springbank/">SpringBank</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/springbank">Home</a></li>
					<li class="active"><a href="/springbank/agencia/">Agencias</a>
					</li>
					<li class="active"><a href="/springbank/usuario/">Usuarios</a>
					</li>
					<li class="active"><a href="/springbank/cliente/">Clientes</a>
					</li>
					<li class="active"><a href="/springbank/gerente/">Gerentes</a>
					</li>
					<li class="active"><a href="/springbank/conta/">Contas</a></li>
					<li class="active"><a href="/springbank/transacao/">Transações</a>
					</li>
					<li class="active"><a
						href="<c:url value="/j_spring_security_logout"/>">Sair</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
	</nav>
	<div id="container-large">
		<div class="panel panel-default">
			<div class="panel-heading">Usuário sem Acesso</div>
			<div class="panel-body">
				<div class="form-group">
					<h3>HTTP Status 403 - Permissão Negada</h3>
					<h4>${msg}</h4>
				</div>
			</div>
		</div>
	</div>
	//
</body>
</html>