<script src="${pageContext.request.contextPath}/resources/js/validation.js" type="text/javascript"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container-large">
	<div class="panel panel-default">
		<div class="panel-heading">Inserir Transação</div>
		<div class="panel-body">
			<div class="error">${message}</div>
			<form id="formTransacao" class="form-horizontal" role="form"
				action="/springbank/transacao/salvar" method="post">

				<div class="form-group">
					<label for="lbtipo" class="col-sm-2 control-label">Transação
						Pessoa</label> <label class="radio-inline"> <input type="radio"
						${pagamento} ${disabled} name="tipoTransacao" id="tipoPagamento"
						value="P"> Pagamento
					</label> <label class="radio-inline"> <input type="radio"
						${transferencia} ${disabled} name="tipoTransacao"
						id="transferencia" value="T"> Transferencia
					</label>
				</div>

				<div class="form-group">
					<label for="lbConta" class="col-sm-2 control-label">Conta Origem</label>
					<div class="col-sm-4">
						<select ${disabled} name="contaId" class="form-control">
							<c:forEach var="conta" items="${contas}" varStatus="id">
								<c:choose>
									<c:when test="${conta.id == transacao.conta.id}">
										<option selected value="${conta.id}">${conta.id}</option>
									</c:when>
									<c:otherwise>
										<option value="${conta.id}">${conta.id}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="dataMovimento" class="col-sm-2 control-label">Data
					</label>

					<div class='col-sm-4 date input-group'>
						<input type="text" ${disabled} class="form-control datepicker"
							id="dataMovimento" name="dataMovimento"
							value="${transacao.dataMovimento}"> <span
							class="input-group-addon"><span
							class="glyphicon glyphicon-calendar"></span> </span>
					</div>
				</div>

				<div class="form-group">
					<label for="lbContaDestino" class="col-sm-2 control-label">Conta Destino</label>
					<div class="col-sm-4">
						<select ${disabled} name="contaIdDestino" class="form-control">
							<option>nenhum</option>
							<c:forEach var="conta" items="${contasDestino}" varStatus="id">
								<c:choose>
									<c:when test="${conta.id == contaDestinoId}">
										<option selected value="${conta.id}">${conta.id}</option>
									</c:when>
									<c:otherwise>
										<option value="${conta.id}">${conta.id}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="lbValor" class="col-sm-2 control-label">Código
						de Barras</label>
					<div class="col-sm-4">
						<input type="text" ${disabled} class="form-control"
							id="codigoPagamento" placeholder="insira o código de barras"
							name="codigoPagamento" value="${transacao.codigoPagamento}">
					</div>
				</div>

				<div class="form-group">
					<label for="lbValor" class="col-sm-2 control-label">Valor</label>
					<div class="col-sm-4">
						<input type="text" ${disabled} class="form-control" id="valor"
							placeholder="insira o valor do movimento" name="valor"
							value="${transacao.valor}">
					</div>
				</div>

				<input type="hidden" name="id" value="${transacao.id}"> <input
					type="hidden" name="tipoMovimento" value="D">
				<!-- modo update nao envia campo disabled, setar o mesmo cliente -->

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" value="button.back" class="btn btn-default"
							onclick="ajaxGet('/springbank/transacao/')">Cancelar</button>
						<input id="submit" class="btn btn-default" type="submit" value="Salvar">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>