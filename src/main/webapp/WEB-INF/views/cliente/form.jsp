<script src="${pageContext.request.contextPath}/resources/js/validation.js" type="text/javascript"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container-large">
	<ul class="nav nav-tabs">
	<li role="presentation"><a href="/springbank/cliente/">Inicio</a></li>
	<li role="presentation" class="active"><a href="#">Cliente</a></li>
	<li role="presentation"><a href="/springbank/cliente/usuario/${cliente.id}">Usuário</a></li>
</ul>
	<div class="panel panel-default">
		<div class="panel-heading">Manuteção Cliente</div>
		<div class="panel-body">
			<div class="error">${message}</div>

			<form id="formCliente" class="form-horizontal" role="form"
				action="/springbank/cliente/salvar" method="post">

				<div class="form-group">
					<label for="lbtipo" class="col-sm-2 control-label">Tipo
						Pessoa</label> <label class="radio-inline"> <input type="radio"
						${fisica} name="tipoCliente" id="tipoFisica" value="F">
						Física
					</label> <label class="radio-inline"> <input type="radio"
						${juridica} name="tipoCliente" id="tipoJuridica" value="J">
						Jurídica
					</label>
				</div>

				<div class="form-group">
					<label for="lbnome" class="col-sm-2 control-label">Nome</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="nome"
							placeholder="insira o nome" name="nome" value="${cliente.nome}">
					</div>
				</div>


				<div class="form-group">
					<label for="lbnome" class="col-sm-2 control-label">CPF/CNPJ</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="cpfCnpj"
							placeholder="insira o CPF/CNPJ" name="cpfCnpj"
							value="${cliente.cpfCnpj}">
					</div>
				</div>

				<div class="form-group">
					<label for="lbnome" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-8">
						<input type="email" class="form-control" id="email"
							placeholder="insira o email" name="email"
							value="${cliente.email}">
					</div>
				</div>

				<div class="form-group">
					<label for="lbnome" class="col-sm-2 control-label">Telefone</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="telefone"
							placeholder="insira o telefone" name="telefone"
							value="${cliente.telefone}">
					</div>
				</div>

				<div class="form-group">
					<label for="lbnomemae" class="col-sm-2 control-label">Endereço</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="endereco"
							placeholder="insira o endereço" name="endereco"
							value="${cliente.endereco}">
					</div>
				</div>

				<div class="form-group">
					<label for="lbnomemae" class="col-sm-2 control-label">Cidade</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="cidade"
							placeholder="insira a cidade" name="cidade"
							value="${cliente.cidade}">
					</div>
				</div>
				<input type="hidden" name="id" value="${cliente.id}">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<a class="btn btn-default" href="/springbank/cliente/">Cancelar</a>
						<button type="submit" class="btn btn-default">Salvar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>