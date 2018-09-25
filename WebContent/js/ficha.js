(function($){
        //Campo de busca usuario
        var $campoClientes = $('#cliente_ficha');
        $campoClientes.hide();
        $("#formBuscarUsuarios input[type=search]").on('keyup', function(e){
        	var valorBusca = this.value;
        	if(valorBusca == "" && $campoClientes.is(":visible")){
        		$campoClientes.hide();
        		var $inputs = $("#ficha_atendimento input");
        		for(var i = 1; i < $inputs.length; i++ ){
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
            			var clientes = JSON.parse(resultado);
            			if(clientes.length > 0 ){
            				if($campoClientes.is(":hidden")){
                    			$campoClientes.show();        				
                			}
            				
            				if($('#formBuscarUsuarios .form-control').hasClass('is-invalid')){
            					$('#formBuscarUsuarios .form-control').removeClass("is-invalid");
            				} 
            				$('#formBuscarUsuarios .form-control').addClass("is-valid");
                			$campoClientes.find('select').html("");
                			for(i = 0; i < clientes.length; i++ ){
                				var $option = '<option value='+clientes[i].cpf+'>'+clientes[i].nome+'</option>'
                				$campoClientes.find('select').append($option); 
            				}	
            			} else {
            				if($('#formBuscarUsuarios .form-group .invalid-feedback')) {
            					$('#formBuscarUsuarios .form-group .invalid-feedback').remove();
            				}
            				if($('#formBuscarUsuarios .form-control').hasClass('is-valid')){
            					$('#formBuscarUsuarios .form-control').removeClass("is-valid");
            				}
            				$('#formBuscarUsuarios .form-group').append('<div class="invalid-feedback">Nenhum usuário com esse nome.</div>');
            				$('#formBuscarUsuarios .form-control').addClass("is-invalid");
            			}
            				
            		}
            	})
        	}
        });
        
}( jQuery) );

( function($){
	var $btnClienteSelect = $("#cliente_ficha button.btn-success");
	var $btnAnimalSelect = $("#ficha_atendimento select[name=select_nome_animal]");
	var $btnDetalhar;
	var $tabelaServicos = $("#tabelaServicos");	
	var $formSelects = $("#tabelaServicos select");	
	var $botaoAbrirFicha = $("#ficha_atendimento input.btn-success");
	var $botaoEditarFicha = $("#ficha_atendimento button.btn-alertg");
	var $botaorFicha = $("#ficha_atendimento button.btn-warning");
	
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
				if(animais.length > 0 ){
					$botaoAbrirFicha.prop('disabled', false);
					if($("#cliente_ficha .alert")){
						$("#cliente_ficha .alert").remove();
					}
					$btnAnimalSelect.prop("disabled", false);
					$btnAnimalSelect.html("");
					for( var i = 0; i < animais.length; i++ ){
						var $option =  "<option value='"+animais[i].id+"'>"+animais[i].nome+"</option>";
						$btnAnimalSelect.append($option);
					}	
				} else {
					$("#cliente_ficha .form-group").append('<div class="alert alert-warning mt-2" role="alert">O cliente não possui animais cadastrados!</div>');
					$btnAnimalSelect.html("");
					$btnAnimalSelect.prop("disabled", true);
				}
			}
		});
		//Lista as prescricoes
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
				if(fichas.length > 0 ){
					if($("#tabela_prescricoes .alert")){
						$("#tabela_prescricoes .alert").remove();
					}
					$tabelaFichas.html("");
					for( var i = 0; i < fichas.length; i++ ){
						var data = new Date(fichas[i].dataAbertura);
						datatime = data.getFullYear()+"-"+(data.getMonth()+1)+'-'+data.getDate();
						data = data.getDate()+'/'+(data.getMonth()+1)+'/'+data.getFullYear();
						var $linha =  '<tr><th scope="row">'+fichas[i].numeroFicha+'</th><td><time datetime="'+datatime+'">'+data.get+'</time></td><td>'+fichas[i].idAnimal+'</td><td><button class="btn btn-info" name="detalhar">Detalhar Ficha</button></td></tr>'
						$tabelaFichas.append($linha);
					}	
					$btnDetalhar = $("button[name=detalhar]");
					for(var i = 0; i < $btnDetalhar.length; i++ ){
						$btnDetalhar[i].addEventListener("click", function(e){
							e.preventDefault();
							$botaoEditarFicha.prop('disabled', false);
							var id_detalhar = parseInt(this.closest("td").closest("tr").children[0].innerText);
							ajaxDetalhar(id_detalhar);
							ajaxServicos(id_detalhar);
							//Aqui tem que chamr uma funcao preenchendo os servicos
						});
					}	
				} else {
					$tabelaFichas.html("");
					$("#tabela_prescricoes").append('<div class="alert alert-warning mt-2" role="alert">Os animais do cliente não possuem prescrições</div>');
				}
			}
		});
		
	});
	//Funcao para adicionar prescricao
	var $btnIncluirServicos = $("#tabelaServicos .btn.btn-success");
	var $selectCategoria = $("#tabelaServicos select[name=categoria]");
	var $selectServicos = $("#tabelaServicos select[name=servico]");
	var $inputFicha = $("#ficha_atendimento input[name=id_ficha]");
	
	//Comandos dos botoes de crud da ficha
	
	$botaoAbrirFicha.on('click', function(e){
		e.preventDefault();	
	});
	
	$botaoEditarFicha.on('click', function(e){
		e.preventDefault();
		$btnIncluirServico.prop("disabled", false);
		$selectServicos.prop("disabled", false);
		$selectCategoria.prop("disabled", false);
		//
		var $formButtons = $("#tabelaServicos button");
		$("html, body").animate({
			scrollTo: $tabelaServicos
		}, 500, 'linear');
		//
		
		for(var i = 0; i < $formButtons; i++){
			$formButtons[i].prop('disabled', false);
		}
		for(var i = 0; i < $formSelects; i++){
			$formSelects[i].prop('disabled', false);
		}	
	})
	
	//
	
	
	//trocar o campo para o veterinario
	var $inputAtendente = $("#ficha_atendimento input[name=idatendente]");
	var $inputVeterinario = $("#ficha_atendimento input[name=cpf_veterinario]");
	var $tabelaServicos = $("#tabelaServicos");
	
	//trocar o campo para o veterinario
	$btnIncluirServicos.on('click', function(e){
		e.preventDefault();
		var idservico = $selectServicos.val();
		var idficha = $inputFicha.val();
		var idatendente = $inputAtendente.val();
		var idveterinario = $inputVeterinario.val(); 
		
		$.ajax({
			method: "POST",
			url:'prescricaoServlet.do',
			data:{
				opcao: 0,
				ficha: idficha,
				servico: idservico,
				atendente: idatendente,
				veterinario: idveterinario
			},
			success:function(retorno){
				var servico = JSON.parse(retorno);
				var numeroItem = $("#tabelaServicos tr").length;
				var ultimaLinha = $("#tabelaServicos tr:last-child");
				var data = servico[0].data_prescricao_servico;
				var preco = servico[1].preco.toFixed(2);
				data = data.split(' ');
				data = data[0].replace('-', '/').replace('-', '/');
				var $linha = '<tr><th scope="row">'+numeroItem+'</th><td>'+servico[1].nome_servico+'</td><td>'+servico[1].categoria+'</td><td>Jorge Teste</td><td><time>'+data+'</time></td><td>R$'+preco+'</td><td><button type="button" class="btn btn-danger">Excluir</button></td></tr>';
				$tabelaServicos.prepend($linha);
				
				var $linhas = $("#tabelaServicos tr");
				var total = 0;
				for(var i = 0; i < $linhas.length -1; i++ ){
					var valor =  $linhas.find('td')[4];
					valor = valor.innerText;
					valor = valor.replace('R$','');
					valor = parseFloat(valor);
					total += valor;
				}
				total = (Math.round(total * 100) / 100).toFixed(2);
				total = total.toString().replace('.', ',');
				ultimaLinha.find('td')[3].innerText = "R$"+total;
			}
		});
	})
	
	///
	//Funcao para o ajax de detalhar
	function ajaxDetalhar(num){
		$.ajax({
			method: "POST",
			url: "FichaAtendimentoServlet.do",
			data:{
				opcao: 5,
				data:num
			},
			success:function(retorno){
				var dadosFicha = JSON.parse(retorno);
				var dataAbertura = dadosFicha[2].data_abertura.split(' ');
				var dataNascimento = dadosFicha[0].data.split(' ');
				var $inputs = $("#ficha_atendimento input");
				$inputs[2].value = dadosFicha[2].status;
				$inputs[3].value = dadosFicha[2].numero_sequencial;
				$inputs[4].value = dataAbertura[0];
				$inputs[5].value = dataNascimento[0];			
				$inputs[6].value = dadosFicha[0].especie;
				$inputs[7].value = dadosFicha[0].raca;
				if(dadosFicha[0].sexo === "M"){
					$inputs[8].checked = true;	
				} else {
					$inputs[9].checked = true;
				}
				$inputs[10].value = dadosFicha[0].porte;
				$inputs[11].value = dadosFicha[0].pelagem;
				$inputs[12].value = dadosFicha[0].temperamento;
				$inputs[13].value = dadosFicha[1].nome;
				$inputs[14].value = dadosFicha[1].cpf;
				$inputs[15].value = dadosFicha[1].telefone;
				$inputs[16].value = dadosFicha[1].celular;
				$inputs[17].value = dadosFicha[1].email;
			}
		})
	}
	function ajaxServicos(num){
		$.ajax({
			method: "POST",
			url: "prescricaoServlet.do",
			data: {
				opcao: 1,
				valor: num
			}, success: function(retorno){
				var servicos = JSON.parse(retorno);
				
				var $tabelaServicos = $("#tabelaServicos");	
				$("#tabelaServicos tr").remove(':not(:last-child)');
				var numeroItem = $("#tabelaServicos tr").length;
				
				for( var i = 0; i < servicos.length; i++ ){
					
					var data = servicos[i][0].data_prescricao_servico;
					var preco = servicos[i][1].preco.toFixed(2);
					data = data.split(' ');
					data = data[0].replace('-', '/').replace('-', '/');
					var $linha = '<tr><th scope="row">'+(i + 1)+'</th><td>'+servicos[i][1].nome_servico+'</td><td>'+servicos[i][1].categoria+'</td><td>Jorge Teste</td><td><time>'+data+'</time></td><td>R$'+preco+'</td><td><button type="button" class="btn btn-danger" value='+servicos[i][0].id_prescricao+' disabled>Excluir</button></td></tr>';
					$tabelaServicos.prepend($linha);

				}
				calcularTotal();
				botoesExcluir();
			}
		})
	}
	
	function calcularTotal(){
		var ultimaLinha = $("#tabelaServicos tr:last-child");
		var $linhas = $("#tabelaServicos tr");
		var total = 0;
		for(var k = 0; k < $linhas.length -1; k++ ){
			var valor =  $linhas.find('td')[4];
			valor = valor.innerText;
			valor = valor.replace('R$','');
			valor = parseFloat(valor);
			total += valor;
		}
		total = (Math.round(total * 100) / 100).toFixed(2);
		total = total.toString().replace('.', ',');
		ultimaLinha.find('td')[3].innerText = "R$"+total;
	}
	
	function botoesExcluir(){
		var $botoesExcluir = $("#tabelaServicos .btn.btn-danger");
		$botoesExcluir.on('click', function(e){
			
			var id_prescricao = this.value;
			$.ajax({
				method: "POST",
				url: "prescricaoServlet.do",
				data: {
					opcao: 2,
					id: id_prescricao
				}, 
				success: function(retorno){
					if(retorno == 1 ){
						$linha = $(".btn.btn-danger[value="+id_prescricao+"]").closest('td').closest('tr');
						console.log($linha);
						$linha.remove();
						calcularTotal();
					}
				}
			});
			
		});	
	}
	
	
	//Selecao animal
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

//Carregar select de servicos a partir da categoria
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