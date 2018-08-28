//Ativa os Tooltips do menu

(function($){
        
        $('[data-toggle="tooltip"]').tooltip();
        
        $("#formBuscarUsuarios").on('change', function(e){
        	console.log(e);
        	$.ajax({
        		method: 'POST',
        		url: 'FichaAtendimentoServlet.do',
        		data: { parametro: 1 },
        		success: function(resultado){
        			console.log(resultado);
        		}
        	})
        })
        
}( jQuery) );