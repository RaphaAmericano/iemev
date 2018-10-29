( function($){
	var $containerBusca = $("#containerBusca");
	var $inputBusca = $containerBusca.find("input");
	var $submitButton = $containerBusca.find("button");
	
	$submitButton.on("click", function(e){
		var valor = $inputBusca.val();
		console.log(valor);
	});
}( jQuery ))