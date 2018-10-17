(function( $ ){
	//Campo busca
	var busca = $('#formularioBusca');
	var $campo = busca.find('input.form-control');
	var $botao = busca.find('button');
	//Container Select
	var $containerSelect = $("#selectAnimais");
	var $selectInput = $containerSelect.find('select');
	var $selectForm = $containerSelect.find('form');
	var $botaoDetalhar = $containerSelect.find('button');
	var $alerta = $containerSelect.find('.alert.alert-danger');
	//Container formulario
	var $containerFormulario = $("#containerFormulario");
	var $camposInput = $containerFormulario.find('input');
	var $botaoIncluir = $containerFormulario.find('button')[0];
	var $botaoEditar = $containerFormulario.find('button')[1];
	var $botaoExcluir = $containerFormulario.find('button')[2];
	//
	$botao.on('click', function(e){
		e.preventDefault();
		var valor = $campo.val();
		if(valor != ""){
			$.ajax({
				method: "POST",
				url: "animalServlet.do",
				data: {
					opcao: 0,
					busca: valor
				}, 
				success:function(retorno){
					var valor = JSON.parse(retorno);
					console.log(valor);
					if(valor.length > 0 ){
						$selectForm.show();
						$alerta.hide();
						$selectInput.html("");
						$botaoDetalhar.attr('disabled', false );
						for(var i = 0; i < valor.length; i++ ){
							var $option = "<option value="+valor[i].idAnimal+">"+valor[i].nomeAnimal+"</option>";
							$selectInput.append($option);
						}
					} else  {
						$selectInput.html("");
						$alerta.show();
					}
				}
			});
		}
	});
	//
	$botaoDetalhar.on('click', function(e){
		e.preventDefault();
		console.log($camposInput);
		var valor = $selectInput[0].value;
		$.ajax({
			method:"POST",
			url: "animalServlet.do",
			data: {
				opcao: 1,
				idAnimal: valor
			}, success:function(retorno){
				var animal = JSON.parse(retorno);
				$botaoEditar.disabled = false;
				$botaoExcluir.disabled = false;
				leituraCampos(true);
				$camposInput[13].disabled = true;
				$camposInput[0].value = animal.nomeAnimal;
				if(animal.sexo == "M"){
					$camposInput[1].checked = true;	
				} else {
					$camposInput[2].checked = true;
				}
				$camposInput[3].value = animal.dataDeNascimentoAnimal.split(' ')[0];
				$camposInput[4].value = animal.especie;
				$camposInput[5].value = animal.raca;
				$camposInput[6].value = animal.porte;
				$camposInput[7].value = animal.pelagem;
				$camposInput[8].value = animal.temperamento;
				$camposInput[9].value = animal.cpfCliente;
				$camposInput[10].value = animal.idAtendimentoDeCadastramento;
				$camposInput[11].value = animal.idAnimal;
			}
		});
	});
	
	$botaoIncluir.addEventListener('click', function(e){
		e.preventDefault();
		$containerFormulario.find('form')[0].reset();
		$camposInput[11].value = 2;
		leituraCampos(false);
		//$camposInput[10].value = animal.idAtendimentoDeCadastramento;
		//$camposInput[11].value = "";
		$camposInput[13].disabled = false;
	});
	$botaoEditar.addEventListener('click', function(e){
		e.preventDefault();
		leituraCampos(false);
		$camposInput[12].value = 3;
		$camposInput[13].disabled = false;
	});
	$botaoExcluir.addEventListener('click', function(e){
		e.preventDefault();
		$camposInput[12].value = 4;
	});
	
	//Funcao auxiliar
	function leituraCampos(valor){
		if(valor == true ){
			$camposInput[0].readOnly = true;
			$camposInput[1].disabled = true;	
			$camposInput[2].disabled = true;
			$camposInput[3].readOnly = true;
			$camposInput[4].readOnly = true;
			$camposInput[5].readOnly = true;
			$camposInput[6].readOnly = true;
			$camposInput[7].readOnly = true;
			$camposInput[8].readOnly = true;
		} else 
		if( valor == false){
			$camposInput[0].readOnly = false;
			$camposInput[1].disabled = false;	
			$camposInput[2].disabled = false;
			$camposInput[3].readOnly = false;
			$camposInput[4].readOnly = false;
			$camposInput[5].readOnly = false;
			$camposInput[6].readOnly = false;
			$camposInput[7].readOnly = false;
			$camposInput[8].readOnly = false;
		}
	}
}( jQuery ));