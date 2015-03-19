<div id="container-large">
	<div class="panel panel-default">
		<div class="panel-heading">Agencias</div>
		<div class="panel-body">
			<div class="error">${message}</div>

			<a href="/pacsaude/paciente/adicionar"><img
				src="resources/img/add.png" width="24" height="24"
				data-toggle="tooltip" title="Adicionar Paciente"></a>

			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Cidade</th>
					<th>&nbsp</th>
					<th>&nbsp</th>
				</tr>
				<c:forEach var="paciente" items="${agencias}" varStatus="id">
					<tr>
						<td>${agencia.id}</td>
						<td>${agencia.nome}</td>
						<td>${agencia.cidade}</td>

						<td><a href="/pacsaude/paciente/editar/${agencia.id}"><img
								src="resources/img/update.png" width="18" height="18"
								data-toggle="tooltip" title="Editar"></a>
						<td>
						<td><a href="/pacsaude/paciente/deletar/${agencia.id}"><img
								src="resources/img/delete.png" width="18" height="18"
								data-toggle="tooltip" title="Excluir"
								onclick="return confirm('Tem certeza que deseja excluir: ' + '${agencia.nome}')"></a>
						<td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
