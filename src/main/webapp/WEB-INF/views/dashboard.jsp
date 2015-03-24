<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringBank</title>
      
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>

<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-validation/dist/localization/messages_pt_BR.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/validation.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/datepicker/js/bootstrap-datepicker.js"></script>

<div id="div-componente-sim-nao" class="modal fade">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 id="h-componente-sim-nao-titulo" class="modal-title">TITULO</h4>
			</div>
			<div class="modal-body">
				<p id="p-componente-sim-nao-mensagem">MENSAGEM_EXCLUSAO</p>
			</div>
			<div class="modal-footer">
				<button id="btn-componente-sim-nao-nao" type="button"
					class="btn btn-default" data-dismiss="modal">Não</button>
				<button id="btn-componente-sim-nao-sim" type="button"
					class="btn btn-primary">Sim</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		$('.datepicker').datepicker({
			language : "pt-BR",
			format : "dd/mm/yyyy"
		});
	});
</script>

</head>
<body>
   <body>
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/springbank/">SpringBank</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                    	<li class="active">  <a href="/springbank">Home</a> </li>
                    	<li class="active">  <a href="/springbank/agencia/">Agencias</a> </li>
                    	<li class="active">  <a href="/springbank/usuario/">Usuarios</a> </li>
                    	<li class="active">  <a href="/springbank/cliente/">Clientes</a> </li>
                    	<li class="active">  <a href="/springbank/gerente/">Gerentes</a> </li>
                    </ul>               
                </div><!-- /.navbar-collapse -->     
           </div>           
        </nav>   