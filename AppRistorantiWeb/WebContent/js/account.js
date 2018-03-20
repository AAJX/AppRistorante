// navbar animation 

$(document).ready(function(){
$(window).scroll(function () {
	if ($(window).scrollTop() >= 5) {
		 $('#fix').addClass('fixed');
	} 
	else {
		$('.navbar').removeClass('fixed');
	}
});
});

// registra
$('#btnRegister').click(function(e) {
	// 1. impedire al form HTML di fare submit
	e.preventDefault();

	
	$.ajax({
	url : 'nuovoAccount',
	method : 'post',
	data : $('#frmRegister').serialize()
	}).done(function(esito) {
	console.log(esito);
	if (esito.success) {
	
	alert("Utente registrato correttamente nel db")
	} else {
	alert("qualcosa è andato storto")
	}
	});

	});

	// Login
$('#btnLogin').click(function(e) {
	// 1. impedire al form HTML di fare submit
	e.preventDefault();
	$.ajax({
		url: 'Login',
		method: 'post',
		data: $('#frmLogin').serialize()
	})
	.done(function(esito){
		console.log(esito);
		if(esito.success) {
			localStorage.setItem('utente', JSON.stringify(esito.oggettoRisultante));
			// andare alla pagina areariservata
			location.href ='Homepage.html';
		} else {
			$('#pnlErrLogin').show('fast').delay(2000).hide('fast');
		}
	})
	.fail(function() {
		console.error('qualcosa è andato storto.')
	});
	
});

//popola la pagina ristorante di carousel
var pagina = "";

$(document).ready(function() {
	if($('.conte').length) {
		pagina = "content/Conte.html";
	}
	
	else if($('.madre').length) {
		pagina = "content/MadreGea.html";
	}
	
	else if($('.chat').length) {
		pagina = "content/ChatNoir.html";
	}
	
		$.ajax({
			url:pagina,
			method: 'post',
		})
		.done(function(risposta) {
			$('#par').html(risposta);
		});	
});		



$(document).ready(function(){
	$.ajax({
		url: 'listaRistoranti',
		method: 'get'
	})
	.done(function(persone) {
		// <li>Anna Rossi</li>
	
		persone.forEach(function(p) {
			var stringa = '<li>' + p.nome + '</li>';
			$('#elencoPersone').append(stringa);
		})
	});
});

	
//popola la pagina ristorante 
$(document).ready(function(){
	 
	 var url = window.location.href;
	 
	 if(url.search("#conte") >=0 ) {
		 
	 	 $('#par').addClass("conte");
		$('#ristorante').val( ristoranti[0].idRistorante);
		$('#nomeRistorante').html(ristoranti[0].nome);
		$('#nomeCitta').html(ristoranti[0].citta.nome);
		
	 } else if(url.search("#madre") >=0 ) {
		 
	 	 $('#par').addClass("madre");
	 	$('#ristorante').val( ristoranti[1].idRistorante);
	 	$('#nomeRistorante').html(ristoranti[1].nome);
	 	$('#nomeCitta').html(ristoranti[1].citta.nome);
	 }else if(url.search("#chat") >=0 ) {
		 
		 $('#par').addClass("chat");
		 $('#ristorante').val( ristoranti[2].idRistorante);
		 $('#nomeRistorante').html(ristoranti[2].nome);
		 $('#nomeCitta').html(ristoranti[2].citta.nome);
	 }
	 
});

	
