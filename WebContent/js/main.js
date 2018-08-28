//Ativa os Tooltips do menu

(function($){
        
        $('[data-toggle="tooltip"]').tooltip();
        
        $("#formBuscarUsuarios input[type=search]").on('keyup', function(e){
        	var valorBusca = this.value;
        	$.ajax({
        		method: 'POST',
        		url: 'FichaAtendimentoServlet.do',
        		data: { busca: valorBusca },
        		success: function(resultado){
        			console.log(resultado);
        		}
        	})
        })
        
}( jQuery) );