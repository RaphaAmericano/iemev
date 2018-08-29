//Ativa os Tooltips do menu

(function($){
        
        $('[data-toggle="tooltip"]').tooltip();
        var $campoClientes = $('#cliente_ficha');
        $campoClientes.hide();
        $("#formBuscarUsuarios input[type=search]").on('keyup', function(e){
        	var valorBusca = this.value;
        	
        	$.ajax({
        		method: 'POST',
        		url: 'FichaAtendimentoServlet.do',
        		data: { busca: valorBusca },
        		success: function(resultado){
        			$campoClientes.show();
        			var clientes = JSON.parse(resultado);			
        			$campoClientes.find('select').html("");
        			for(i = 0; i < clientes.length; i++ ){
        				var $option = '<option value='+clientes[i].cpf+'>'+clientes[i].nome+'</option>'
        				$campoClientes.find('select').append($option); 
    				}
        			
        		}
        	})
        })
        
}( jQuery) );