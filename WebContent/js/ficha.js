(function($){
        //Campo de busca usuario
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
	//Seleciona oo cliente
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
				var animais = JSON.parse(retorno);
				//$("#ficha_atendimento select").html("");
				$btnAnimalSelect.html("");
				for( var i = 0; i < animais.length; i++ ){
					var $option =  "<option value='"+animais[i].id+"'>"+animais[i].nome+"</option>";
					//$("#ficha_atendimento select").append($option);
					$btnAnimalSelect.append($option);
				}
			}
		});
		$.ajax({
			method: "POST",
			url: "FichaAtendimentoServlet.do",
			data: {
				opcao: 4,
				idcliente: valor
			},
			success: function(retorno){
				var fichas = JSON.parse(retorno);
				var $tabelaFichas = $("#tabelaFichas");
				$tabelaFichas.html("");
				for( var i = 0; i < fichas.length; i++ ){
					var data = new Date(fichas[i].dataAbertura);
					datatime = data.getFullYear()+"-"+(data.getMonth()+1)+'-'+data.getDate();
					data = data.getDate()+'/'+(data.getMonth()+1)+'/'+data.getFullYear();
					var $linha =  '<tr><th scope="row">'+fichas[i].numeroFicha+'</th><td><time datetime="'+datatime+'">'+data.get+'</time></td><td>'+fichas[i].idAnimal+'</td><td><button class="btn btn-info" name="detalhar[0]">Detalhar Ficha</button></td></tr>'
					$tabelaFichas.append($linha);
				}	
			}
		});
	});
	//Selecao animal
	$btnAnimalSelect.on('click', function(e){
		e.preventDefault();
		var animal = this.value; 
		console.log(animal);
		$.ajax({
			method: 'POST',
			url: 'FichaAtendimentoServlet.do',
			data: {
				opcao: 2,
				idAnimal: animal
			},
			success: function(retorno){
				var dadosAnimal = JSON.parse(retorno);
				console.log(dadosAnimal);
				var dataNascimento = dadosAnimal[0].data.split(' ');
				dataNascimento = "'"+dataNascimento[1]+" "+dataNascimento[2]+" "+dataNascimento[5]+"'";
				dataNascimento = new Date(dataNascimento);
				var $inputs = $("#ficha_atendimento input");
				//$inputs[3].value = dataNascimento.getFullYear()+"-"+(dataNascimento.getMouth()+1)+"-"+dataNascimento.getDate();
				$inputs[6].value = dadosAnimal[0].especie;
				$inputs[7].value = dadosAnimal[0].raca;
				if(dadosAnimal[0].sexo === "M"){
					$inputs[8].checked = true;	
				} else {
					$inputs[9].checked = true;
				}
				$inputs[10].value = dadosAnimal[0].porte;
				$inputs[11].value = dadosAnimal[0].pelagem;
				$inputs[12].value = dadosAnimal[0].temperamento;
				$inputs[13].value = dadosAnimal[1].nome;
				$inputs[14].value = dadosAnimal[1].cpf;
				$inputs[15].value = dadosAnimal[1].telefone;
				$inputs[16].value = dadosAnimal[1].celular;
				$inputs[17].value = dadosAnimal[1].email;
			}
		});
	});
	
	
}( jQuery ) );

( function ($){
	var $tabelaServicos = $("#tabelaServicos");
	var $formButtons = $("#tabelaServicos button");
	var $formSelects = $("#tabelaServicos select");
	var $botaoAbrirFicha = $("#ficha_atendimento button.btn-success");
	var $botaoEditarFicha = $("#ficha_atendimento button.btn-warning");
	console.log($formButtons);
	console.log($formSelects);
	$botaoAbrirFicha.on('click', function(e){
		e.preventDefault();
		
	});
	
	$botaoEditarFicha.on('click', function(e){
		e.preventDefault();
		//
		$("html, body").animate({
			scrollTo: $tabelaServicos
		}, 500, 'linear');
		//
		
		
		console.log($formButtons[i]);
		for(var i = 0; i < $formButtons; i++){
			
			$formButtons[i].disabled = false;
		}
		for(var i = 0; i < $formSelects; i++){
			$formSelects[i].readOnly = false;
		}
		
	})
	
}( jQuery ) );

( function($){
	var $selectCategoria = $("select[name=categoria]");
	var $selectServico = $("select[name=servico]");
	$selectCategoria.on('change', function(){
		var categoria = $selectCategoria.val();
		$.ajax({
			method: 'POST',
			url: 'servicoServlet.do',
			data: {
				opcao: 0,
				data: categoria
			},
			success:function(retorno){
				var servicos = JSON.parse(retorno);
				$selectServico.html("");
				for(var i = 0; i < servicos.length; i++ ){
					var $option = "<option value="+servicos[i].idServico+">"+servicos[i].nomeServico+"</option>";
					$selectServico.append($option);
				}
			}
		})
	})
}( jQuery ));