<script src="${pageContext.request.contextPath}/resources/js/validation.js" type="text/javascript"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container-large">
	<div class="panel panel-default">
		<div class="panel-heading">Clientes</div>
		<div class="panel-body">
			<div class="error">${message}</div>

			<a href="/springbank/cliente/adicionar"><img
				src="${pageContext.request.contextPath}/resources/img/add.png"
				width="24" height="24" data-toggle="tooltip"
				title="Adicionar Cliente"></a>

			<table class="table table-striped table-hover">
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>&nbsp</th>
					<th>&nbsp</th>
				</tr>
				<c:forEach var="cliente" items="${clientes}" varStatus="id">
					<tr>
						<td>${cliente.id}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.telefone}</td>
						<td>${cliente.email}</td>

						<td><a href="/springbank/cliente/editar/${cliente.id}"><img
								src="${pageContext.request.contextPath}/resources/img/update.png"
								width="18" height="18" data-toggle="tooltip" title="Editar"></a>
						</td>

						<td><a href="#"
							onclick="deleteItem(event, '${cliente.nome}', '/springbank/cliente/deletar/${cliente.id}')"><img
								src="${pageContext.request.contextPath}/resources/img/delete.png"
								height="18" data-toggle="tooltip" title="Excluir"></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp" />