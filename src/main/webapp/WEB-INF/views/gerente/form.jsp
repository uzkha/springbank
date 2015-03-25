
<jsp:include page="../dashboard.jsp" />

<div id="container-large">
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="/springbank/gerente/">Inicio</a></li>
		<li role="presentation" class="active"><a href="#">Gerente</a></li>
		<li role="presentation"><a
			href="/springbank/gerente/usuario/${gerente.id}">Usuário</a></li>
	</ul>
	<div class="panel panel-default">
		<div class="panel-heading">Manuteção Gerente</div>
		<div class="panel-body">
			<div class="error">${message}</div>

			<form id="formGerente" class="form-horizontal" role="form"
				action="/springbank/gerente/salvar" method="post">

				<div class="form-group">
					<label for="lbnome" class="col-sm-2 control-label">Nome</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="nome"
							placeholder="insira o nome" name="nome" value="${gerente.nome}">
					</div>
				</div>


				<div class="form-group">
					<label for="lbnome" class="col-sm-2 control-label">CPF/CNPJ</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="cpfCnpj"
							placeholder="insira o CPF/CNPJ" name="cpfCnpj"
							value="${gerente.cpfCnpj}">
					</div>
				</div>

				<div class="form-group">
					<label for="lbnome" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-8">
						<input type="email" class="form-control" id="email"
							placeholder="insira o email" name="email"
							value="${gerente.email}">
					</div>
				</div>

				<div class="form-group">
					<label for="lbnome" class="col-sm-2 control-label">Telefone</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="telefone"
							placeholder="insira o telefone" name="telefone"
							value="${gerente.telefone}">
					</div>
				</div>

				<div class="form-group">
					<label for="lbnomemae" class="col-sm-2 control-label">Endereço</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="endereco"
							placeholder="insira o endereço" name="endereco"
							value="${gerente.endereco}">
					</div>
				</div>

				<div class="form-group">
					<label for="lbnomemae" class="col-sm-2 control-label">Cidade</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="cidade"
							placeholder="insira a cidade" name="cidade"
							value="${gerente.cidade}">
					</div>
				</div>

				<div class="form-group">
					<label for="lbDataContratacao" class="col-sm-2 control-label">Data
						de Contratação</label>

					<div class='col-sm-4 date input-group'>
						<input type="text" class="form-control datepicker"
							id="dataContratacao" name="dataContratacao"
							value="${dataContratacao}"> <span
							class="input-group-addon"><span
							class="glyphicon glyphicon-calendar"></span> </span>
					</div>
				</div>
				
				<input type="hidden" name="id" value="${gerente.id}">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" value="button.back" class="btn btn-default"
							onclick="document.location = '/springbank/gerente/'">Cancelar</button>
						<button type="submit" class="btn btn-default">Salvar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>