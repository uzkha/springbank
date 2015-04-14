/*$(document).ready(function () {
	
    $('#formGerente').submit(function (e) {
		
    	$form = $(this);
    	
    	var url = $form.attr('action');
    	
    	alert(url);
    	
        //$.post('/springbank/gerente/salvar', $(this).serialize(), function(data) {
     //  	   $.post($(this).parent("form").attr("action"), $(this).serialize(), function(data) { 	
    //    	$( ".view_principal" ).html( data );
     //   });

        return false;
    });

});
*/

function ajaxGet(url){
	$.get(url)
	.done(function(data) {
		$( ".view_principal" ).html( data );
	});
}