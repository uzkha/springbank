$(document).ready(function () {
    $("#formPaciente").validate({
        // Define as regras
        rules: {
            "paciente.nome": {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true, minlength: 3
            },
            "paciente.sexo": {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true,
            },
            "paciente.rg": {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true, minlength: 8
            },
            "paciente.cpf": {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true, minlength: 11, number:true
            },            
            "paciente.nomeMae": {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true, minlength: 3
            },
            "paciente.endereco": {
                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
                required: true, minlength: 3
            },
         },
    });

});

function confirmDelete() {
    if (confirm("Are you sure you want to delete:")) {
        document.location = delUrl;
    }
}
