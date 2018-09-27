(function($){
	var $botoesSelecionar = $("button[name=detalhar]");
	var $listaFichas = $("#lista_fichas");
	var $fichaFormulario = $("#ficha_atendimento");
	var $listaServicos = $("#tabela_servicos");
	var $inputFields = $fichaFormulario.find('input');
	var $radioPagamento = $fichaFormulario.find('input[type=radio]');
	var $botaoReabrirFicha = $("#ficha_atendimento button")[0]; 
	var $botaoFecharFicha = $("#ficha_atendimento button")[1];
	
	$botoesSelecionar.on('click', function(e){
		var id_ficha = this.closest('td').children[0].value;
		var $linhas = $listaFichas.find('tbody').find('tr');
		for(var j = 0; j < $linhas.length; j++){
			if($linhas[j].classList.contains("table-primary")){
				$linhas[j].classList.remove("table-primary");
			}
		}
		if(!this.closest("td").closest("tr").classList.contains("table-primary")){
				this.closest("td").closest("tr").classList.add("table-primary");	
		}
		$.ajax({
			method: "POST",
			url: "FichaAtendimentoServlet.do",
			data: {
				opcao: 5,
				data: id_ficha
			},
			success:function(retorno){
				var ficha = JSON.parse(retorno);
				var data = ficha[2].data_abertura;
				
				data = data.split(' ')[0];
				
				$inputFields[0].value = ficha[2].status;
				$inputFields[1].value = ficha[2].numero_sequencial;
				$inputFields[2].value = data;
				$inputFields[4].value = ficha[1].nome;
				$inputFields[5].value = ficha[0].nome;
				$inputFields[6].value = ficha[1].cpf;
				console.log($inputFields);
				$inputFields[7].disabled = false;
				$inputFields[8].disabled = false;
				$inputFields[9].disabled = false;				
				
				if(ficha[2].status == "Aberta"){
//					$botaoReabrirFicha.setAttribute("disabled", true);
//					$botaoFecharFicha.removeAttribute("disabled");
				} else if (ficha[2].status == "Fechada"){
//					$botaoReabrirFicha.removeAttribute("disabled");
//					$botaoFecharFicha.setAttribute("disabled", true);
				}
				
				var $linhasServico = $listaServicos.find('tr');
				
				for(var i = 1; i < $linhasServico.length - 1; i++ ){
					$linhasServico[i].remove();
				}
				listarServicos(ficha[2].numero_sequencial);
			}
		})
		
	});
	
	$botaoReabrirFicha.addEventListener('click', function(e){
		e.preventDefault();
		$inputFields[16].value = 7
		//submit depois que mudar o valor
	});
	$botaoFecharFicha.addEventListener('click', function(e){
		
		$inputFields[16].value = 8;
		//submit depois que mudar o valor ou mudar apartir jsp de acordo com o status
	});
	$radioPagamento.on("change", function(){
		if($inputFields[0].value == "Aberta"){
			$botaoReabrirFicha.setAttribute("disabled", true);
			$botaoFecharFicha.removeAttribute("disabled");
		} else if ($inputFields[0].value == "Fechada"){
			$botaoReabrirFicha.removeAttribute("disabled");
			$botaoFecharFicha.setAttribute("disabled", true);
		}
	})
	
	
	//Funções 
	function listarServicos(id){
		$.ajax({
			method: "POST",
			url: "prescricaoServlet.do",
			data: {
				opcao: 1,
				valor: id
			},
			success:function(retorno){
				var fichas = JSON.parse(retorno);
				for(var i = 0; i < fichas.length; i++){
					var data = fichas[i][0].data_prescricao_servico;
					data = data.split(' ')[0];
					data = data.split('-').reverse().join('/');
					var $linha = "<tr><th scope='row'>"+(i+1)+"</th><td>"+fichas[i][1].categoria+"</td><td>"+fichas[i][1].nome_servico+"</td><td>Ubirajara Castro</td><td><time>"+data+"</time></td><td>R$"+fichas[i][1].preco+"</td></tr>";
					$listaServicos.find('tbody').prepend($linha);
				}
				numerarServicos();
				calcularTotal();
			}
		});
	}
	
	function numerarServicos(){
		var linhas = $listaServicos.find('tbody th');
		for(var i = 0; i < linhas.length - 1; i++ ){
			linhas[i].innerText = i + 1;
		}
	}
	
	function calcularTotal(){
		var $campoTotal = $listaServicos.find('tbody').find("tr:last-child").find('td');
		var $camposValores = $listaServicos.find('tbody').find('tr').find('td:last-child');
		var total = 0;
		for(var k = 0; k < $camposValores.length -1; k++ ){
			var valor =  $camposValores[k].innerText;
			valor = valor.replace('R$','');
			valor = parseFloat(valor);
			total += valor;
		}
		total = (Math.round(total * 100) / 100).toFixed(2);
		total = total.toString().replace('.', ',');
		$campoTotal[0].innerText = "R$"+total;
	}
}( jQuery ));