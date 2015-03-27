
<jsp:include page="../dashboard.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container-large">
	<div class="panel panel-default">
		<div class="panel-heading">Inserir Transa��o</div>
		<div class="panel-body">
			<div class="error">${message}</div>
			<form id="formConta" class="form-horizontal" role="form"
				action="/springbank/transacao/salvar" method="post">
				
				<div class="form-group">
					<label for="lbtipo" class="col-sm-2 control-label">Transa��o
						Pessoa</label> <label class="radio-inline"> <input type="radio"
						${pagamento} name="tipoTransacao" id="tipoPagamento" value="P">
						Pagamento
					</label> <label class="radio-inline"> <input type="radio"
						${transferencia} name="tipoTransacao" id="transferencia" value="T">
						Transferencia
					</label>
				</div>
				
				<div class="form-group">
					<label for="lbConta" class="col-sm-2 control-label">Conta</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="contaId"
							name="contaId"	value="${transacao.conta.id}">
					</div>
				</div>

				<div class="form-group">
					<label for="dataMovimento" class="col-sm-2 control-label">Data
					</label>

					<div class='col-sm-4 date input-group'>
						<input type="text" class="form-control datepicker"
							id="dataMovimento" name="dataMovimento"
							value="${transacao.dataMovimento}"> <span
							class="input-group-addon"><span
							class="glyphicon glyphicon-calendar"></span> </span>
					</div>
				</div>

				<div class="form-group">
					<label for="lbValor" class="col-sm-2 control-label">Valor</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="valor"
							placeholder="insira o valor do movimento" name="valor"
							value="${transacao.valor}">
					</div>
				</div>

				<input type="hidden" name="id" value="${transacao.id}">
				<input type="hidden" name="tipoMovimento" value="D">
				<!-- modo update nao envia campo disabled, setar o mesmo cliente -->

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" value="button.back" class="btn btn-default"
							onclick="document.location = '/springbank/transacao/'">Cancelar</button>
						<button type="submit" class="btn btn-default">Salvar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>