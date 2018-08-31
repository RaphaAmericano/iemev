//Ativa os Tooltips do menu

(function($){
        
        $('[data-toggle="tooltip"]').tooltip();
        var $campoClientes = $('#cliente_ficha');
        $campoClientes.hide();
        $("#formBuscarUsuarios input[type=search]").on('keyup', function(e){
        	var valorBusca = this.value;
        	if(valorBusca == "" && $campoClientes.is(":visible")){
        		$campoClientes.hide();
        		var $inputs = $("#ficha_atendimento input");
        		for(var i = 0; i < $inputs.length; i++ ){
        			$inputs[i].value = null;
        		}
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
	var $btnAnimalSelect = $("#ficha_atendimento select[name=select_nome_animal]");
	$btnClienteSelect.on('click', function(e){
		e.preventDefault();
		var valor = $("#cliente_ficha select").val()[0];
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
	
	$btnAnimalSelect.on('click', function(e){
		e.preventDefault();
		var animal = this.value; 
		
		$.ajax({
			method: 'POST',
			url: 'FichaAtendimentoServlet.do',
			data: {
				opcao: 2,
				idAnimal: animal
			},
			success: function(retorno){
				var dadosAnimal = JSON.parse(retorno);
				console.log(dadosAnimal[0]);
				console.log(dadosAnimal[1]);
				var dataNascimento = dadosAnimal[0].data.split(' ');
				dataNascimento = "'"+dataNascimento[1]+" "+dataNascimento[2]+" "+dataNascimento[5]+"'";
				dataNascimento = new Date(dataNascimento);
				console.log(dataNascimento)
				var $inputs = $("#ficha_atendimento input");
				
				//$inputs[3].value = dataNascimento.getFullYear()+"-"+(dataNascimento.getMouth()+1)+"-"+dataNascimento.getDate();
				
				
				$inputs[4].value = dadosAnimal[0].especie;
				$inputs[5].value = dadosAnimal[0].raca;
				if(dadosAnimal[0].sexo === "M"){
					$inputs[6].checked = true;	
				} else {
					$inputs[7].checked = true;
				}
				$inputs[8].value = dadosAnimal[0].porte;
				$inputs[9].value = dadosAnimal[0].pelagem;
				$inputs[10].value = dadosAnimal[0].temperamento;
				$inputs[11].value = dadosAnimal[1].nome;
				$inputs[12].value = dadosAnimal[1].cpf;
				$inputs[13].value = dadosAnimal[1].telefone;
				$inputs[14].value = dadosAnimal[1].celular;
				$inputs[15].value = dadosAnimal[1].email;
			}
		});
	});
	
	
}( jQuery ) );

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