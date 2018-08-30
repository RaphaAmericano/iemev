//Ativa os Tooltips do menu

(function($){
        
        $('[data-toggle="tooltip"]').tooltip();
        var $campoClientes = $('#cliente_ficha');
        $campoClientes.hide();
        $("#formBuscarUsuarios input[type=search]").on('keyup', function(e){
        	var valorBusca = this.value;
        	if(valorBusca == "" && $campoClientes.is(":visible")){
        		$campoClientes.hide();
        	}
        	if( valorBusca.length > 2 ) {
        		$.ajax({
            		method: 'POST',
            		url: 'FichaAtendimentoServlet.do',
            		data: { 
            			opcao:0, 
            			busca: valorBusca 
            			},
            		success: function(resultado){
            			if($campoClientes.is(":hidden")){
                			$campoClientes.show();        				
            			}
            			var clientes = JSON.parse(resultado);			
            			$campoClientes.find('select').html("");
            			for(i = 0; i < clientes.length; i++ ){
            				var $option = '<option value='+clientes[i].cpf+'>'+clientes[i].nome+'</option>'
            				$campoClientes.find('select').append($option); 
        				}		
            		}
            	})
        	}
        });
        
        
}( jQuery) );

( function($){
	var $btnClienteSelect = $("#cliente_ficha button.btn-success");
	var $btnAnimalSelect = $("#ficha_atendimento select[name=select_nome]");
	$btnClienteSelect.on('click', function(e){
		e.preventDefault();
		var valor = $("#cliente_ficha select").val()[0];
		console.log(valor);
		
		$.ajax({
			method: "POST",
			url: "FichaAtendimentoServlet.do",
			data: {
				opcao: 1,
				idcliente: valor
			},
			success: function(retorno){
				console.log(retorno);
				var animais = JSON.parse(retorno);
				$("#ficha_atendimento select").html("");
				for( var i = 0; i < animais.length; i++ ){
					var $option =  "<option value='"+animais[i].id+"'>"+animais[i].nome+"</option>";
					$("#ficha_atendimento select").append($option);
				}
				
			}
		});
		
	});
	$btnAnimalSelect.on('change', function(e){
		var animal = this.value; 
		$.ajax({
			method: 'POST',
			url: 'FichaAtendimentoServlet.do',
			data: {
				opcao: 2,
				idAnimal: animal
			},
			success: function(retorno){
				console.log(retorno);
			}
		});
	})
}( jQuery ));

( function ($){
	var $botaoAbrirFicha = $("#ficha_atendimento button.btn-success");
	var $botaoEditarFicha = $("#ficha_atendimento button.btn-warning");
	$botaoAbrirFicha.on('click', function(e){
		e.preventDefault();
		var $formInputs = $('#ficha_atendimento input');
		console.log($formInputs);
		for(i = 3; i < $formInputs.length -1; i++ ){
			$formInputs[i].readOnly = false;
			$formInputs[i].value = null;
		}
	});
	
	$botaoEditarFicha.on('click', function(e){
		e.preventDefault();
		var $formInputs = $('#ficha_atendimento input');
		console.log($formInputs);
		for(i = 3; i < $formInputs.length -1; i++ ){
			$formInputs[i].readOnly = false;
		}
	})
	
	
}( jQuery ) );