<script src="${pageContext.request.contextPath}/resources/js/validation.js" type="text/javascript"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container-large">
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="/springbank/gerente/">Inicio</a></li>
		<li role="presentation"><a
			href="/springbank/gerente/editar/${gerente.id}">Gerente</a></li>
		<li role="presentation" class="active"><a
			href="/springbank/gerente/usuario/${gerente.id}">Usuário</a></li>
	</ul>

	<div class="panel panel-default">
		<div class="panel-heading">Manuteção Usuários</div>
		<div class="panel-body">
			<div class="error">${message}</div>
			<form id="formUsuario" class="form-horizontal" role="form"
				action="/springbank/gerente/salvarUsuario" method="post">

				<div class="form-group">
					<label for="lbnome" class="col-sm-2 control-label">Gerente</label>
					<div class="col-sm-8"> 
						<input type="text" class="form-control" name="nome" id="nome" disabled
							value="${gerente.nome}">
					</div>
				</div>

				<div class="form-group">
					<label for="lbtipo" class="col-sm-2 control-label">Tipo de
						Usuário</label> <label class="radio-inline"> <input type="radio"
						checked name="tipo" disabled id="tipo" value="C"> Gerente
					</label> 
				</div>

				<div class="form-group">
					<label for="lbnome" class="col-sm-2 control-label">Login</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="login"
							placeholder="insira o login" name="login"
							value="${usuario.login}">
					</div>
				</div>
				<div class="form-group">
					<label for="lbnomemae" class="col-sm-2 control-label">Senha</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="senha"
							placeholder="insira a senha" name="senha">
					</div>
				</div>
				<div class="form-group">
					<label for="lbnomemae" class="col-sm-2 control-label">Confirme
						a Senha</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="senhaConfirmacao"
							placeholder="repita a senha" name="senhaConfirmacao"
							value="${usuario.senhaConfirmacao}">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<div class="checkbox">
							<label> <input type="checkbox" ${ativo} name="ativo"
								value="true"> Ativo
							</label>
						</div>
					</div>
				</div>


				<input type="hidden" name="id" value="${usuario.id}">
				<input type="hidden" name="gerenteId" value="${gerente.id}">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" value="button.back" class="btn btn-default"
							onclick="document.location = '/springbank/gerente/editar/${gerente.id}'">Cancelar</button>
						<button type="submit" class="btn btn-default">Salvar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>