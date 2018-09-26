(function($){
	var $botoesSelecionar = $("button[name=detalhar]");
	var $fichaFormulario = $("#ficha_atendimento");
	var $listaServicos = $("#tabela_servicos");
	var $inputFields = $fichaFormulario.find('input');
	console.log($inputFields);
	$botoesSelecionar.on('click', function(e){
		var id_ficha = this.closest('td').children[0].value; 
		
		$.ajax({
			method: "POST",
			url: "FichaAtendimentoServlet.do",
			data: {
				opcao: 5,
				data: id_ficha
			},
			success:function(retorno){
				console.log(retorno);
				var ficha = JSON.parse(retorno);
				var data = ficha[2].data_abertura;
				data = data.split(' ')[0];
				
				$inputFields[0].value = ficha[2].status;
				$inputFields[1].value = ficha[2].numero_sequencial;
				$inputFields[2].value = data;
				$inputFields[4].value = ficha[1].nome;
				$inputFields[5].value = ficha[0].nome;
				$inputFields[6].value = ficha[1].cpf;
				
				var $linhasServico = $listaServicos.find('tr');
				
				for(var i = 1; i < $linhasServico.length - 1; i++ ){
					$linhasServico[i].remove();
				}
				listarServicos(ficha[2].numero_sequencial);
			}
		})
		
	});
	
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
				//calcularTotal();
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
		var ultimaLinha = $listaServicos.find("tr:last-child");
		var $linhas = $listaServicos.find("tr");
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
		ultimaLinha.find('td')[0].innerText = "R$"+total;
	}

}( jQuery ));