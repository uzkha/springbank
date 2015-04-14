<script src="${pageContext.request.contextPath}/resources/js/validation.js" type="text/javascript"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container-large">
	<div class="panel panel-default">
		<div class="panel-heading">Manuteção Conta</div>
		<div class="panel-body">
			<div class="error">${message}</div>
			<form id="formConta" class="form-horizontal" role="form"
				action="/springbank/conta/salvar" method="post">
				<div class="form-group">

					<div class="form-group">
						<label for="lbAgencia" class="col-sm-2 control-label">Agencia</label>
						<div class="col-sm-4">
							<select name="agenciaId" class="form-control">
								<option value="">Nenhum</option>
								<c:forEach var="agencia" items="${agencias}" varStatus="id">
									<c:choose>
										<c:when test="${agencia.id == conta.agencia.id}"><option selected value="${agencia.id}">${agencia.nome}</option></c:when>
										<c:otherwise><option value="${agencia.id}">${agencia.nome}</option></c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="lbCliente" class="col-sm-2 control-label">Cliente</label>
						<div class="col-sm-4">
							<select ${disabled} name="clienteId" class="form-control">
								<option  value="">Nenhum</option>
								<c:forEach var="cliente" items="${clientes}" varStatus="id">
									<c:choose>
										<c:when test="${cliente.id == conta.cliente.id}"><option selected value="${cliente.id}">${cliente.nome}</option></c:when>
										<c:otherwise><option value="${cliente.id}">${cliente.nome}</option></c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="lbGerente" class="col-sm-2 control-label">Gerente</label>
						<div class="col-sm-4">
							<select   name="gerenteId" class="form-control">
								<option value="">Nenhum</option>
								<c:forEach var="gerente" items="${gerentes}" varStatus="id">
									<c:choose>
										<c:when test="${gerente.id == conta.gerente.id}"><option selected value="${gerente.id}">${gerente.nome}</option></c:when>
										<c:otherwise><option value="${gerente.id}">${gerente.nome}</option></c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>


					<label for="lbSaldo" class="col-sm-2 control-label">Saldo</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="saldo" ${disabled}
							placeholder="insira o deposito inicial" name="saldo"
							value="${conta.saldo}">
					</div>
				</div>
				<div class="form-group">
					<label for="lbLimite" class="col-sm-2 control-label">Limite</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="limite"
							placeholder="insira o limite da conta" name="limite"
							value="${conta.limite}">
					</div>
				</div>
				<input type="hidden" name="id" value="${conta.id}">
				<!-- modo update nao envia campo disabled, setar o mesmo cliente -->
				<c:choose> 
					<c:when test="${conta.id > 0}">
						<input type="hidden" name="clienteId" value="${conta.cliente.id}">
						<input type="hidden" name="saldo" value="${conta.saldo}">
					</c:when>	
				</c:choose>				
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<a class="btn btn-default" href="/springbank/conta/">Cancelar</a>
						<input id="submit" class="btn btn-default" type="submit" value="Salvar">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>