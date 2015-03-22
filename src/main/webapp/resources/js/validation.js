$(document).ready(function () {
    $("#formAgencia").validate({
        // Define as regras
        rules: {
            "nome": {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true, minlength: 3
           },
            "cidade": {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true,
            },
         },
    });

});


function show(titulo, mensagem, simFunction, naoFunction, simMensagem, naoMensagem) {
	$('#h-componente-sim-nao-titulo').html(titulo);
	$('#p-componente-sim-nao-mensagem').html(mensagem);
	if (simMensagem != null)
		$('#btn-componente-sim-nao-sim').html(simMensagem);
	if (naoMensagem != null)
		$('#btn-componente-sim-nao-nao').html(naoMensagem);
	
	simFunctionInternal = function() {
		$('#div-componente-sim-nao').modal('toggle');
	};
	
	$('#btn-componente-sim-nao-sim').unbind('click');
	$('#btn-componente-sim-nao-sim').click(simFunctionInternal);
	if (simFunction != null)
		$('#btn-componente-sim-nao-sim').click(simFunction);
	
	$('#btn-componente-sim-nao-nao').unbind('click');
	if (simFunction != null)
		$('#btn-componente-sim-nao-nao').click(naoFunction);
	
	if (simMensagem != null)
		$('#btn-componente-sim-nao-sim').html(simMensagem);
	else
		$('#btn-componente-sim-nao-sim').html('sim');
	
	if (naoMensagem != null)
		$('#btn-componente-sim-nao-nao').html(naoMensagem);
	else
		$('#btn-componente-sim-nao-nao').html('nao');
	
	$('#div-componente-sim-nao').modal('toggle');
	
}

function confirmDelete(descricaoItem, simFunction, naoFunction) {
	titulo = 'Confirmar';
	mensagem = 'Excluir: ' + ' <span style="font-weight: bold;">' + descricaoItem +'</span>?';
	show(titulo, mensagem, simFunction, naoFunction);
}

function deleteItem(event, descricao, link){
	event.preventDefault();
	
	simFunction = function() {
		window.location.href = link;
	};
	
	naoFunction = function() {
		return;
	};
	
	confirmDelete(descricao, simFunction, naoFunction);
}
