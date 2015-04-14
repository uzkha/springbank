<script src="${pageContext.request.contextPath}/resources/js/validation.js" type="text/javascript"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container-large">
	<div class="panel panel-default">
		<div class="panel-heading">Contas</div>
		<div class="panel-body">
			<div class="error">${message}</div>

			<a href="/springbank/conta/adicionar"><img
				src="${pageContext.request.contextPath}/resources/img/add.png"
				width="24" height="24" data-toggle="tooltip"
				title="Adicionar Conta"></a>

			<table class="table table-striped table-hover">
				<tr>
					<th>Conta</th>
					<th>Agencia</th>
					<th>Cliente</th>
					<th>Saldo</th>
					<th>Limite</th>
					<th>&nbsp</th>
					<th>&nbsp</th>
				</tr>
				<c:forEach var="conta" items="${contas}" varStatus="id">
					<tr>
						<td>${conta.id}</td>
						<td>${conta.agencia.nome}</td>
						<td>${conta.cliente.nome}</td>
						<td>${conta.saldo}</td>
						<td>${conta.limite}</td>

						<td><a href="/springbank/conta/editar/${conta.id}"><img
								src="${pageContext.request.contextPath}/resources/img/update.png"
								width="18" height="18" data-toggle="tooltip" title="Editar"></a>
						</td>

						<td><a href="javascript:;"
							onclick="deleteItem(event, '${conta.id}', '/springbank/conta/deletar/${conta.id}')"><img
								src="${pageContext.request.contextPath}/resources/img/delete.png"
								height="18" data-toggle="tooltip" title="Excluir"></a></td>


					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp" />