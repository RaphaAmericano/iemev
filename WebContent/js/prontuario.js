(function( $ ){
	//Container Busca
	var $containerBusca = $("#containerBusca");
	var $inputBusca = $containerBusca.find("input");
	var $botaoBusca = $containerBusca.find("button");
	var $boxAlert = $containerBusca.find('.alert-danger');
	//Container Animais
	var $containerAnimais = $("#containerAnimais");
	var $labelNome = $containerAnimais.find('label strong');
	var $selectAnimal = $containerAnimais.find('select');
	var $botaoConsultar = $containerAnimais.find('button');
	//Resumo do animal
	var $containerFicha = $("#fichaAnimal");
	var $inputsFicha = $containerFicha.find("input");
	//Prescricoes 
	var $containerPrescricoes = $("#containerPrescricoes");
	var $corpoTabela = $containerPrescricoes.find("tbody"); 
	
	
	//Mascaras
	$inputBusca.mask("000.000.000-00");
	$botaoBusca.on('click', function(e){
		e.preventDefault();
		$boxAlert.hide();
		var valor = $inputBusca.val();
		if( valor.length > 0 ){
			$.ajax({
				method: "POST",
				url: "ProntuarioServlet.do",
				data: {
					opcao: 0,
					cpf: valor
				}, success: function(retorno){
					var cliente;
					try {
						cliente = JSON.parse(retorno);
						$labelNome.html(cliente[0].nome);
						if(cliente[1].length > 0 ){
							$selectAnimal.html("");
							for(var i = 0; i < cliente[1].length; i++ ){
								var $option = "<option value='"+cliente[1][i].idAnimal+"'>"+cliente[1][i].nomeAnimal+"</option>";
								$selectAnimal.append($option);
							}
						}
					} catch(e){
						cliente = retorno;
						$boxAlert.show();
						$boxAlert.html(retorno);
					}	
				}
			});
		}
	});
	
	// Carregar o prontuário
	$botaoConsultar.on('click', function(e){
		e.preventDefault();
		var valor = $selectAnimal[0].value;
		if( valor > 0 ){
			$.ajax({
				method: "POST",
				url: "ProntuarioServlet.do",
				data:{
					opcao: 1,
					idanimal: valor
				}, success:function(retorno){
					var animal = JSON.parse(retorno);
					console.log(animal);
					$inputsFicha[0].value = animal[0].nomeAnimal;
					$inputsFicha[1].value = animal[0].especie;
					$inputsFicha[2].value = animal[0].sexo;
					$inputsFicha[3].value = animal[0].dataDeNascimentoAnimal.split(' ')[0];
					$inputsFicha[4].value = animal[0].raca;
					$inputsFicha[5].value = animal[0].pelagem;
					$inputsFicha[6].value = animal[0].porte;
					$inputsFicha[7].value = animal[0].temperamento;
					$corpoTabela.html("");
					
					for( var i = 0; i < animal[1].length; i++ ){
						var $linha = "<tr><td><time datetime='"+animal[1][i].data_prescricao_servico.split(' ')[0]+"'>2016-07-31</time></td><td>"+animal[1][i].numero_ficha+"</td><td>"+animal[1][i].categoria+"</td><td>"+animal[1][i].servico+"</td><td>"+animal[1][i].veterinario+"</td></tr>";
						$corpoTabela.append($linha);
					}
				}
			});
		}
	});
	
	
}( jQuery ));