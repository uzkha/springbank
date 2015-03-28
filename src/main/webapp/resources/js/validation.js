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

$(document).ready(function () {
    $("#formUsuario").validate({
        // Define as regras
        rules: {
            login: {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true, minlength: 3
            },                       
            senha: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, minlength: 5
            },
            senhaConfirmacao: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, minlength: 5, equalTo: "#senha"

            },
        },
    });

});

$(document).ready(function () {
    $("#formTransacao").validate({
        // Define as regras
        rules: {
            contaId: {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true,
            },                       
            tipoTransacao: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true,
            },
            dataMovimento: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, 

            },
            valor: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, number: true,

            },
        },
    });

});

$(document).ready(function () {
    $("#formConta").validate({
        // Define as regras
        rules: {
            clienteId: {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true,
            },                       
            gerenteId: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, minlength: 5
            },
            agenciaId: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, 

            },
            saldo: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, number: true

            },
            limite: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, number: true

            },
        },
    });

});

$(document).ready(function () {
    $("#formGerente").validate({
        // Define as regras
        rules: {
            nome: {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true,
            },                       
            cpfCnpj: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, minlength: 11, maxlenght: 11
            },
            email: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, email: true,

            },
            telefone: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, 

            },
            endereco: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, 

            },
            cidade: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, 

            },
            dataContratacao: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, 

            },
        },
    });

});

$(document).ready(function () {
    $("#formCliente").validate({
        // Define as regras
        rules: {
            nome: {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true, minlength: 3
            },                       
            endereco: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, minlength: 3
            },
            cpfCnpj: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, minlength: 11, number: true, maxlength: 11
            },
            email: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, email:true
            },
            telefone: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true
            },
            cidade: {
                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
                required: true, minlength: 3
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
