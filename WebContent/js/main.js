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
				var dataNascimento = dadosAnimal[0].data.split(' ');
				dataNascimento = "'"+dataNascimento[1]+" "+dataNascimento[2]+" "+dataNascimento[5]+"'";
				dataNascimento = new Date(dataNascimento);
				
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
		for(i = 3; i < $formInputs.length -1; i++ ){
			$formInputs[i].readOnly = false;
			$formInputs[i].value = null;
		}
	});
	
	$botaoEditarFicha.on('click', function(e){
		e.preventDefault();
		var $formInputs = $('#ficha_atendimento input');
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
	var $formularioConsulta = $("#formularioConsulta");
	var $selectAgendamento = $("#selectAgendamento");
	var $inputDetalhar = $selectAgendamento.find("button");
	var $botoesIncluir = $("#incluirAge");
	var $botoesAlterar = $formularioConsulta.find("button")[1];	
	var $botoesExcluir = $formularioConsulta.find("button")[2];
	var $botoesIncluirCliente = $formularioConsulta.find("button")[3];
	var $modalConfirmacao = $("#modalConfirmacao");
	
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
						$selectAgendamento.find('select').append($option);	
					}
					
				}
			});
		}
	});
	
	$inputDetalhar.on('click', function(e){
		var data = $selectAgendamento.find("option:selected").val()
		$formularioConsulta.find('input')[0].readOnly = true;
		$formularioConsulta.find('input')[2].readOnly = true;
		$formularioConsulta.find('input')[3].readOnly = true;
		$formularioConsulta.find('select[name=nome_animal]').attr("readonly", true );
		$formularioConsulta.find('select[name=consulta]').attr("readonly", true);
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
					$formularioConsulta[0].reset();
					var agendamento = JSON.parse(retorno);
					var dia = agendamento.data.split(' ')[0];
					var hora = agendamento.data.split(' ')[1];
					$formularioConsulta.find('input')[0].value  = agendamento.cpf_cliente;
					$formularioConsulta.find('input')[1].value  = agendamento.nome_cliente;
					$formularioConsulta.find('input')[2].value  = dia;
					$formularioConsulta.find('input')[3].value  = hora;
					//Retirar essa atualizacao do atendente - esse dado deve vir por jsp
					$formularioConsulta.find('input')[4].value  = agendamento.id_atendente;
					//
					$formularioConsulta.find('input')[7].value  = agendamento.id;
					var $option = '<option value="'+agendamento.id_animal+'">'+agendamento.nome_animal+"</option>";
					$formularioConsulta.find('select[name=nome_animal]').append($option);
					$formularioConsulta.find('select[name=consulta]').val(agendamento.id_servico);
						
					$botoesAlterar.disabled = false;	
					$botoesExcluir.disabled = false;
					
				}
			});
		}
	});
	
	$botoesIncluir[0].addEventListener("click", function(){
		console.log("incluir");
		$formularioConsulta[0].reset();
		$formularioConsulta.find('select[name=nome_animal]').html("");
		$botoesIncluirCliente.disabled = false;
		$botoesAlterar.disabled = true;	
		$botoesExcluir.disabled = true;
		$formularioConsulta.find('input')[5].value  = 4;
		$formularioConsulta.find('input')[0].readOnly = false;
		$formularioConsulta.find('input')[2].readOnly = false;
		$formularioConsulta.find('input')[3].readOnly = false;
		$formularioConsulta.find('input')[6].disabled = false;
		$formularioConsulta.find('select[name=nome_animal]').removeAttr("readonly");
		$formularioConsulta.find('select[name=consulta]').removeAttr("readonly");	
		
	})
	
	$botoesAlterar.addEventListener("click", function(){
		$formularioConsulta.find('input')[5].value  = 5;
		$formularioConsulta.find('input')[0].readOnly = false;
		$formularioConsulta.find('input')[2].readOnly = false;
		$formularioConsulta.find('input')[3].readOnly = false;
		$formularioConsulta.find('input')[6].disabled = false;
		$formularioConsulta.find('input')[6].value = "Alterar";
		$formularioConsulta.find('select[name=nome_animal]').removeAttr("readonly");
		$formularioConsulta.find('select[name=consulta]').removeAttr("readonly");
		
		
		
	});
	
	$botoesIncluirCliente.addEventListener('click', function(){
		var data = $formularioConsulta.find('input[name=cpfcliente]').val();
		$formularioConsulta.find('input')[5].value  = 3;
		if(data != undefined && data != ""){
			$.ajax({
				method: 'POST',
				url:"consultaServlet.do",
				data:{
					opcao: 3,
					dados: data
				},
				success:function(retorno){
					var animais = JSON.parse(retorno);
					for(var i = 0; i < animais.length; i++){
						var $option = "<option value='"+animais[i].idAnimal+"' name='nome_animal'>"+animais[i].nomeAnimal+"</option>";
						$formularioConsulta.find('select[name=nome_animal]').append($option);	
					};
				}
			});
			$.ajax({
				method: 'POST',
				url: "consultaServlet.do",
				data: {
					opcao: 7,
					dados: data
				},
				success: function(retorno){
					$formularioConsulta.find('input')[5].value  = 4;
					 $formularioConsulta.find('input')[1].value  = retorno;
				 }
			})
		}
	});
	
	$modalConfirmacao.on("show.bs.modal", function(){
		$formularioConsulta.find('input')[5].value  = 6;
	});
	
}( jQuery ));