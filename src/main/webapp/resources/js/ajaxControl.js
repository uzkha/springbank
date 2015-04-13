
function ajaxGet(url){
	$.get(url)
	.done(function(data) {
		$( ".view_principal" ).html( data );
	});
}
