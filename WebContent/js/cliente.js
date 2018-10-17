(function($){
	//Campo Busca
	var busca = $('#formularioBusca');
	var $campo = busca.find('input.form-control');
	var $botao = busca.find('button');
	//Container Select
	var containerSelect = $("#containerSelect");
	var $select = containerSelect.find('select');
	var $botaoDetalhar = containerSelect.find('button');
	//Ficha de cadastro cliente
	var containerFormulario = $("#formularioCliente");
	var $inputsFormulario = containerFormulario.find('input'); 
	var $buttonsFormulario = containerFormulario.find('button');
	var $botaoIncluir = $buttonsFormulario[0];
	var $botaoEditar = $buttonsFormulario[1];
	var $botaoExcluir = $buttonsFormulario[2];
	var $botaoSubmit = $buttonsFormulario[3];
	//Modal 
	var $modal = $("#modalExcluirCliente");
	 
	//Preencher lista do select
	$botao.on('click', function(e){
		e.preventDefault();
		var valor = $campo.val();
		if(valor != ""){
			$.ajax({
				method: "POST",
				url: "clienteServlet.do",
				data: {
					opcao: 0,
					busca: valor
				}, 
				success:function(retorno){
					var valor = JSON.parse(retorno);
					if(valor.length > 0 ){
						containerSelect.show();
						$select.append($option);
						$select.html("");
						$botaoDetalhar.attr('disabled', false );
						for(var i = 0; i < valor.length; i++ ){
							var $option = "<option value="+valor[i][0].cpf+">"+valor[i][0].nome+"</option>";
							$select.append($option);
						}
					} else  {
						$select.html("");
						$botaoDetalhar.attr('disabled', true );
					}
				}
			});
		}
	});
	//Preencher campos com o cliente selecionado
	$botaoDetalhar.on('click', function(e){
		e.preventDefault();
		var valor = containerSelect.find("option:selected").val();
		if(valor != undefined ){
			$.ajax({
				method: "POST",
				url: "clienteServlet.do",
				data: {
					opcao: 1,
					cpf: valor
				},success:function(retorno){
					var cliente = JSON.parse(retorno);
					var data = cliente[0].dataDeNascimento;
					data = data.split(' ');
					console.log(cliente);
					$buttonsFormulario[0].disabled = false;
					$buttonsFormulario[1].disabled = false;
					$buttonsFormulario[2].disabled = false;
					$buttonsFormulario[3].disabled = true;
					
					$inputsFormulario[1].value = cliente[0].nome;
					$inputsFormulario[1].readOnly = true;
					$inputsFormulario[2].value = cliente[0].cpf;
					$inputsFormulario[2].readOnly = true;
					$inputsFormulario[3].value = cliente[0].rg;
					$inputsFormulario[3].readOnly = true;
					$inputsFormulario[4].value = data[0];
					$inputsFormulario[4].readOnly = true;
					$inputsFormulario[5].value = cliente[0].endereco;
					$inputsFormulario[5].readOnly = true;
					$inputsFormulario[6].value = cliente[0].telefoneResidencial;
					$inputsFormulario[6].readOnly = true;
					$inputsFormulario[7].value = cliente[0].celular;
					$inputsFormulario[7].readOnly = true;
					$inputsFormulario[8].value = cliente[1].emailCliente;
					$inputsFormulario[8].readOnly = true;
					$inputsFormulario[9].value = cliente[1].idAtendenteDeCadastramento;
					
				}
			});
		}
	});
	$botaoIncluir.addEventListener("click", function(e){
		e.preventDefault();
		$buttonsFormulario[1].disabled = true;
		$buttonsFormulario[2].disabled = true;
		$buttonsFormulario[3].disabled = false;
	
		$inputsFormulario[1].value = "";
		$inputsFormulario[1].readOnly = false;
		$inputsFormulario[2].value = "";
		$inputsFormulario[2].readOnly = false;
		$inputsFormulario[3].value = "";
		$inputsFormulario[3].readOnly = false;
		$inputsFormulario[4].value = "";
		$inputsFormulario[4].readOnly = false;
		$inputsFormulario[5].value = "";
		$inputsFormulario[5].readOnly = false;
		$inputsFormulario[6].value = "";
		$inputsFormulario[6].readOnly = false;
		$inputsFormulario[7].value = "";
		$inputsFormulario[7].readOnly = false;
		$inputsFormulario[8].value = "";
		$inputsFormulario[10].value = 2;
	});
	
	$botaoEditar.addEventListener("click", function(e){
		e.preventDefault();
		$buttonsFormulario[0].disabled = true;
		$inputsFormulario[1].readOnly = false;
		$inputsFormulario[2].readOnly = false;
		$inputsFormulario[3].readOnly = false;
		$inputsFormulario[4].readOnly = false;
		$inputsFormulario[5].readOnly = false;
		$inputsFormulario[6].readOnly = false;
		$inputsFormulario[7].readOnly = false;
		$inputsFormulario[8].readOnly = false;
		$inputsFormulario[10].value = 3;
	});
	$botaoExcluir.addEventListener('click', function(e){
		e.preventDefault();
		$inputsFormulario[10].value = 4;
	}) 
	
}( jQuery ));