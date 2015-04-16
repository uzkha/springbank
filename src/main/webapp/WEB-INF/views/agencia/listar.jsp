<!-- chama pagina que contem o carregamento das bibliotecas -->


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container-large">
	<div class="panel panel-default">
		<div class="panel-heading">Agencias</div>
		<div class="panel-body">
			<div class="error">${message}</div>

			<a onclick="ajaxGet('/springbank/agencia/adicionar')" href="javascript:;"><img
				src="${pageContext.request.contextPath}/resources/img/add.png"
				width="24" height="24" data-toggle="tooltip"
				title="Adicionar Agencia"></a>

			<table class="table table-striped table-hover">
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Cidade</th>
					<th>&nbsp</th>
					<th>&nbsp</th>
				</tr>
				<c:forEach var="agencia" items="${agencias}" varStatus="id">
					<tr>
						<td>${agencia.id}</td>
						<td>${agencia.nome}</td>
						<td>${agencia.cidade}</td>

						<td><a onclick="ajaxGet('/springbank/agencia/editar/${agencia.id}')" href="javascript:;"><img
								src="${pageContext.request.contextPath}/resources/img/update.png"
								width="18" height="18" data-toggle="tooltip" title="Editar"></a>
						</td>

						<td><a href="javascript:;"
							onclick="deleteItem(event, '${agencia.nome}', '/springbank/agencia/deletar/${agencia.id}')"><img
								src="${pageContext.request.contextPath}/resources/img/delete.png"
								height="18" data-toggle="tooltip" title="Excluir"></a></td>


					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>