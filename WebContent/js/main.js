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
//Consulta
( function($){
	var $inputData = $("#buscaData input");
	var $inputSubmit = $("#buscaData button");
	var $inputNome = $("#buscaNome input")[0];
	var $inputSubmitNome = $("#buscaNome button");

	var $formulariConsulta = $("#formularioConsulta");
	var $selectAgendamento = $("#selectAgendamento");
	var $inputDetalhar = $selectAgendamento.find("button");
	var $botoesIncluir = $("#formularioConsulta button")[0];	
	var $botoesAlterar = $("#formularioConsulta button")[1];	
	var $botoesExcluir = $("#formularioConsulta button")[2];
	
	console.log($("#formularioConsulta button")[0]);
	
	$inputSubmit.on('click', function(e){
		
		$selectAgendamento.find('select').html("");
		if($inputData.val() != ""){
			var data = $inputData.val();
			$.ajax({
				method: "POST",
				url:"consultaServlet.do",
				data:{
					opcao: 0,
					dados: data
				},
				success:function(retorno){
					var agendamentos = JSON.parse(retorno);
					for(var i = 0; i < agendamentos.length; i++){
						//Acrecentar o horario
						var $option = "<option value="+agendamentos[i].id_atendente+">"+agendamentos[i].data+" | "+agendamentos[i].nome_animal+" | "+agendamentos[i].nome_cliente+"</option>";
						$selectAgendamento.find('select').append($option);	
					}
					
				}
			});
		}
	});
	//
	$inputSubmitNome.on("click", function(e){
		$selectAgendamento.find('select').html("");
		var data = $inputNome.value;
		if(data != "" ){
			$.ajax({
				method: "POST",
				url:"consultaServlet.do",
				data:{
					opcao: 1,
					dados: data
				},
				success:function(retorno){
					var agendamentos = JSON.parse(retorno);
					for(var i = 0; i < agendamentos.length; i++){
						//Acrecentar o horario
						var dia = agendamentos[i].data.split(' ')[0];
						var hora = agendamentos[i].data.split(' ')[1];
						var $option = "<option value="+agendamentos[i].id_animal+">"+dia+" | "+hora+" | "+agendamentos[i].nome_animal+" | "+agendamentos[i].nome_cliente+"</option>";
						console.log($option);
						$selectAgendamento.find('select').append($option);	
					}
					
				}
			});
		}
	});
	
	$inputDetalhar.on('click', function(e){
		var data = $selectAgendamento.find("option:selected").val()
		data = parseInt(data);
		if(data != 0 ){
			$.ajax({
				method: 'POST',
				url:"consultaServlet.do",
				data:{
					opcao: 2,
					dados: data
				},
				success:function(retorno){
					$formulariConsulta[0].reset();
					var agendamento = JSON.parse(retorno);
					var dia = agendamento.data.split(' ')[0];
					var hora = agendamento.data.split(' ')[1];
					$formulariConsulta.find('input')[0].value  = agendamento.cpf_cliente;
					$formulariConsulta.find('input')[1].value  = agendamento.nome_cliente;
					$formulariConsulta.find('input')[2].value  = dia;
					$formulariConsulta.find('input')[3].value  = hora;
					$formulariConsulta.find('input')[4].value  = agendamento.id;
					var $option = '<option value="'+agendamento.id_animal+'">'+agendamento.nome_animal+"</option>";
					console.log($option);
					$formulariConsulta.find('select').append($option);
						
					$botoesAlterar.disabled = false;	
					$botoesExcluir.disabled = false;
					
				}
			});
		}
	});
	
	$("#formularioConsulta button")[0].on("click",function(e){
		console.log("clicou");
		e.preventDefault();
		$formulariConsulta.find('select')[0].readOnly = false;
		$formulariConsulta.find('select')[1].readOnly = false;
		$formulariConsulta.find('input')[2].readOnly = false;
		$formulariConsulta.find('input')[3].readOnly = false;
	});
	
	$botoesIncluir.on("click", function(e){
		console.log("incluir");
	});
	
	
}( jQuery ));