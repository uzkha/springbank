<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Bank</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources//bootstrap/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

 	    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/plugins/morris/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/plugins/morris/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources//bootstrap/js/plugins/morris/morris-data.js"></script>
    
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js" type="text/javascript"></script>	
	
	<link href="${pageContext.request.contextPath}/resources/bootstrap/datepicker/css/datepicker3.css"
	rel="stylesheet" type="text/css" />
	<script	src="${pageContext.request.contextPath}/resources/bootstrap/datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/resources/bootstrap/datepicker/js/locales/bootstrap-datepicker.pt-BR.js" type="text/javascript"></script>
	
	<script	src="${pageContext.request.contextPath}/resources/js/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/resources/js/jquery-validation/dist/localization/messages_pt_BR.min.js" type="text/javascript"></script>
	
	<script src="${pageContext.request.contextPath}/resources/js/validation.js" type="text/javascript"></script>
	
<div id="div-componente-sim-nao" class="modal fade">
	-
	<div class="modal-dialog modal-sm">
		-
		<div class="modal-content">
			-
			<div class="modal-header">
				-
				<button type="button" class="close" data-dismiss="modal"
					-					aria-hidden="true">&times;</button>
				Add a comment to this line -
				<h4 id="h-componente-sim-nao-titulo" class="modal-title">TITULO</h4>
				-
			</div>
			-
			<div class="modal-body">
				-
				<p id="p-componente-sim-nao-mensagem">MENSAGEM_EXCLUSAO</p>
				-
			</div>
			-
			<div class="modal-footer">
				-
				<button id="btn-componente-sim-nao-nao" type="button"
					-					class="btn btn-default" data-dismiss="modal">NГЈo</button>
				-
				<button id="btn-componente-sim-nao-sim" type="button"
					-					class="btn btn-primary">Sim</button>
				-
			</div>
			-
		</div>
		-
	</div>
	-
</div>

</head>

<body>
		
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<?php echo $base_url;?>">Spring Bank</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${usuarioNome} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="<?php echo $base_url?>usuario/editar/<?php echo $usuarioId;?>"><i class="fa fa-fw fa-user"></i>Perfil</a>
                        </li>
                        <li>
                            <a href="<c:url value="/j_spring_security_logout"/>"><i class="fa fa-fw fa-power-off"></i> Sair</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="/springbank/transacao/"><i class="glyphicon glyphicon-usd"></i> Transações</a>
                    </li>
                    <li>
                        <a href="/springbank/conta/"><i class="fa fa-fw fa-bar-chart-o"></i> Contas</a>
                    </li>   
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-wrench"></i> Cadastros <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
                                <a href="/springbank/agencia/">Agencias</a>
                            </li> 
                            <li>
                                <a href="/springbank/cliente/">Clientes</a>
                            </li>    
                            <li>
                                <a href="/springbank/gerente/">Gerentes</a>
                            </li> 
                            <li>
                                <a href="/springbank/usuario/">Usuários</a>
                            </li>                          	                    
                        </ul>
                    </li>                  
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
	
		
        <div id="page-wrapper">		
            <div class="container-fluid principal">
				<!-- carrega a pagina enviada pelo controller -->
				<div class="view_principal">
					
					
				</div>
            </div>
            <!-- /.container-fluid -->	
        </div>
        <!-- /#page-wrapper -->
	
    </div>
    
    <!-- /#wrapper -->