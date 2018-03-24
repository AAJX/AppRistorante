
//Citta
$.ajax({
	
	url:'ListaCitta',
	method:'get'
}).done(function(esito){
	localStorage.setItem('citta', JSON.stringify(esito))
})




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

