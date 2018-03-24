//crea un locale storage dei ristoranti 

$(document).ready(function(){
	$.ajax({
		url: 'listaRistoranti',
		method: 'get'
	})
	.done(function(ristoranti) {
		localStorage.setItem('ristoranti', JSON.stringify(ristoranti));
	});
});
//inizializza ristoranti
var ristoranti = localStorage.getItem('ristoranti');
ristoranti = JSON.parse(ristoranti);


$(document).ready(function(){

	ristoranti.forEach(function(r){
		$('#'+r.idRistorante).attr("href", 'PagRisto.html#'+r.idRistorante);
	
	})
	
})

//Tutti i ristoranti
$(document).ready(function(){
	$('#fade').hide();
	$.ajax({
		url: 'listaRistoranti',
		method: 'get'
	})
	.done(function(ristoranti) {
		ristoranti.forEach(function(r) {
			
			$('#elencoRistoranti').append('<div class="card" style="border: aqua;background-color: #82d264;padding: 8px;">'
		    +'<img class="card-img-top" src="media/risto/ristorante10'+r.idRistorante+'.jpg" alt="Card image cap" style=border-radius:0.5rem;>'
		   +' <div class="card-body">'
		     + '<h5 class="card-title">'+r.nome+'</h5>'
		     + '<p class="card-text">'+r.descrizione+'</p>'
		    +'</div>'
		   +'<div class="card-footer">'
		   +'<a href=PagRisto.html#'+r.idRistorante+' class="btn btn-info  btn-block">Visita</a>'
		    +'</div>'
		  +'</div>');
			
		})
	});
})
	
var vedi;	
function VediTutto(){
	vedi =true;
	if($('#fade').is(':visible')&&$('#elencoRistoranti').is(':visible')){
		$('#fade').fadeOut();
		vedi=false;	
	}
	$('#elencoRistoranti').fadeIn();
	$('#elencoRisto').fadeOut();
	if($('#fade').is(':hidden')&& vedi==true){
	$('#fade').fadeIn();
	}
}



var citta = localStorage.getItem('citta');
citta = JSON.parse(citta);

var ricerca;


//Barra di ricerca
$('#btnSearchRist').click(function() {
	

	sessionStorage.setItem('ricerca',$('#searchRist').val());
	ricerca=sessionStorage.getItem('ricerca');
	
var idcitta="";
	
	citta.forEach(function(c){
		
		if(c.nome==ricerca){
			idcitta=c.idCitta
			
			$.ajax({
				url : 'listaRistoranti',
				method : 'get',
				data : idcitta
				}).done(function(ristoranti) {
				
					sessionStorage.setItem('risto', JSON.stringify(ristoranti));
					
					
					var risto = sessionStorage.getItem('risto');
					risto = JSON.parse(risto);
					
					risto.forEach(function(r) {
						console.log(r.citta.nome)
						if(r.citta.nome==ricerca){
							$('#elencoRisto').fadeIn();
							$('#elencoRisto').empty();
							$('#elencoRistoranti').hide();
							$('#fade').fadeIn();
						$('#elencoRisto').append('<div class="card col-md-4" style="border: aqua;background-color: #82d264;padding: 8px;">'
							    +'<img class="card-img-top" src="media/risto/ristorante10'+r.idRistorante+'.jpg" alt="Card image cap" style="border-radius:0.5rem;">'
								   +' <div class="card-body">'
								     + '<h5 class="card-title">'+r.nome+'</h5>'
								     + '<p class="card-text">'+r.descrizione+'</p>'
								    +'</div>'
								   +'<div class="card-footer">'
								   +'<a href=PagRisto.html#'+r.idRistorante+' class="btn btn-info  btn-block">Visita</a>'
								    +'</div>'
								  +'</div>');	
						}
								
					})
					
				});
			
			
		}else 
			idcitta={"citta":ricerca};
		
$.ajax({
	url : 'ListaRistorantiPerNome',
	method : 'get',
	data : idcitta
	}).done(function(ristoranti) {
	
		sessionStorage.setItem('risto', JSON.stringify(ristoranti));
		
		
		var risto = sessionStorage.getItem('risto');
		risto = JSON.parse(risto);
		
		risto.forEach(function(r) {
			console.log(r.citta.nome)
			if(r.nome==ricerca){
				$('#elencoRisto').fadeIn();
				$('#elencoRisto').empty();
				$('#elencoRistoranti').hide();
				$('#fade').fadeIn();
			$('#elencoRisto').append('<div class="card col-md-4" style="border: aqua;background-color: #82d264;padding: 8px;">'
				    +'<img class="card-img-top" src="media/risto/ristorante10'+r.idRistorante+'.jpg" alt="Card image cap" style="border-radius:0.5rem;">'
					   +' <div class="card-body">'
					     + '<h5 class="card-title">'+r.nome+'</h5>'
					     + '<p class="card-text">'+r.descrizione+'</p>'
					    +'</div>'
					   +'<div class="card-footer">'
					   +'<a href=PagRisto.html#'+r.idRistorante+' class="btn btn-info  btn-block">Visita</a>'
					    +'</div>'
					  +'</div>');	
			}
					
		})
		
	});
	})
	
	
});





	
//popola la pagina ristorante 
$(document).ready(function(){
	 
	 var url = window.location.href;
	 ristoranti.forEach(function(r){
		 if(url.search("#"+r.idRistorante) >=0) {
		 
	
		$('#ristorante').val( r.idRistorante);
		$('.nomeRistorante').html(r.nome);
		$('#nomeCitta').html(r.citta.nome);
		//$('#nomeCitta').html(r.citta.regione);
		$('#descrizione').html('<<..'+r.descrizione+'..>>');
		$('#prezzo').html('Prezzo fisso: '+r.prezzoMenu+' \u20AC');
	 } 
 })
	 
	 
});
	

//popola la pagina ristorante di carousel
var pagina = "";


$(document).ready(function() {
	$('#par').empty();
	var url = window.location.href;
	ristoranti.forEach(function(r){
		if(url.search('#'+r.idRistorante) >=0) {
		pagina ='content/ContentRisto'+r.idRistorante+'.html';
	}
	})
	$.ajax({
			url:pagina,
			method: 'post',
		})
		.done(function(risposta) {
			$('#par').fadeIn();
			$('#par').html(risposta);
		});	
});		

	