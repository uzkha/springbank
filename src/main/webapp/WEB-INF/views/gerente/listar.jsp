<script src="${pageContext.request.contextPath}/resources/js/validation.js" type="text/javascript"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container-large">
	<div class="panel panel-default">
		<div class="panel-heading">Gerentes</div>
		<div class="panel-body">
			<div class="error">${message}</div>

			<a onclick="ajaxGet('/springbank/gerente/adicionar')" href="javascript:;"><img
				src="${pageContext.request.contextPath}/resources/img/add.png"				
				width="24" height="24" data-toggle="tooltip"
				title="Adicionar Gerente"></a>

			<table class="table table-striped table-hover">
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>&nbsp</th>
					<th>&nbsp</th>
				</tr>
				<c:forEach var="gerente" items="${gerentes}" varStatus="id">
					<tr>
						<td>${gerente.id}</td>
						<td>${gerente.nome}</td>
						<td>${gerente.telefone}</td>
						<td>${gerente.email}</td>

						<td><a onclick="ajaxGet('/springbank/gerente/editar/${gerente.id}')" href="javascript:;"><img
								src="${pageContext.request.contextPath}/resources/img/update.png"
								width="18" height="18" data-toggle="tooltip" title="Editar"></a>
						</td>

						<td><a href="javascript:;"
							onclick="deleteItem(event, '${gerente.nome}', '/springbank/gerente/deletar/${gerente.id}')"><img
								src="${pageContext.request.contextPath}/resources/img/delete.png"
								height="18" data-toggle="tooltip" title="Excluir"></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp" />