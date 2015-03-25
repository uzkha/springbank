
<jsp:include page="../dashboard.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container-large">
	<div class="panel panel-default">
		<div class="panel-heading">Transações</div>
		<div class="panel-body">
			<div class="error">${message}</div>

			<a href="/springbank/transacao/adicionar"><img
				src="${pageContext.request.contextPath}/resources/img/add.png"
				width="24" height="24" data-toggle="tooltip"
				title="Adicionar Transacao"></a>

			<table class="table table-striped table-hover">
				<tr>
					<th>Transacao</th>
					<th>Conta</th>
					<th>Valor</th>
					<th>Tipo de Transação</th>
					<th>Movimento</th>
					<th>&nbsp</th>
					<th>&nbsp</th>
				</tr>
				<c:forEach var="transacao" items="${transacoes}" varStatus="id">
					<tr>
						<td>${transacao.id}</td>
						<td>${transacao.conta.id}</td>
						<td>${transacao.valor}</td>
						<td>${transacao.tipoTransacao}</td>
						<td>${transacao.tipoMovimento}</td>

						<td><a href="/springbank/transacao/visualizar/${transacao.id}"><img
								src="${pageContext.request.contextPath}/resources/img/update.png"
								width="18" height="18" data-toggle="tooltip" title="Editar"></a>
						</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp" />