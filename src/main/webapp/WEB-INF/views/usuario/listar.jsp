
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container-large">
	<div class="panel panel-default">
		<div class="panel-heading">Usuários</div>
		<div class="panel-body">
			<div class="error">${message}</div>

			<a href="/springbank/usuario/adicionar"><img
				src="${pageContext.request.contextPath}/resources/img/add.png"
				width="24" height="24" data-toggle="tooltip"
				title="Adicionar Usuário"></a>

			<table class="table table-striped table-hover">
				<tr>
					<th>Id</th>
					<th>Login</th>					
					<th>&nbsp</th>
					<th>&nbsp</th>
				</tr>
				<c:forEach var="usuario" items="${usuarios}" varStatus="id">
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.login}</td>
						

						<td><a href="/springbank/usuario/editar/${usuario.id}"><img
								src="${pageContext.request.contextPath}/resources/img/update.png"
								width="18" height="18" data-toggle="tooltip" title="Editar"></a>
						</td>

						<td><a href="#"
							onclick="deleteItem(event, '${usuario.login}', '/springbank/usuario/deletar/${usuario.id}')"><img
								src="${pageContext.request.contextPath}/resources/img/delete.png"
								height="18" data-toggle="tooltip" title="Excluir"></a></td>


					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp" />