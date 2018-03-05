var utente = localStorage.getItem('utente');
utente = JSON.parse(utente);

//Ciao, amico

if(utente) {
	$('#btnLogout').show();
	$('#btnAccedi').hide();
	$('#LinkNome').html(utente.nome + ' ' + utente.cognome);
	$('#email').val(utente.email);
	$('#preAttivo').show();
	$('#preSpento').hide();
}else {
	$('#btnLogout').hide();
	$('#btnAccedi').show();
	$('#LinkNome').html( 'amico' );
	$('#preAttivo').hide();
	$('#preSpento').show();
}


$('#btnLogout').click(function() {
	localStorage.removeItem('utente');
	location.href = 'Login.html';
});

// classi ristoranti

$(document).ready(function(){
	$.ajax({
		url: 'listaRistoranti',
		method: 'get'
	})
	.done(function(ristoranti) {
		localStorage.setItem('ristoranti', JSON.stringify(ristoranti));
	});
});

var ristoranti = localStorage.getItem('ristoranti');
ristoranti = JSON.parse(ristoranti);


	


$('#btnPrenota').click(function() {
	
	/*var prenotazione = {};
	prenotazione.data=$('#data').val;
	prenotazione.data=$('#orario').val;
	prenotazione.data=$('#numeroPrenotati').val;
	prenotazione.data=$('#email').val;
	prenotazione.data=$('#id').val;
	prenotazione.data=$('#ristorant').val;*/
	
$.ajax({
	url : 'nuovaPrenotazione',
	method : 'post',
	data : $('#frmPrenota').serialize(),
	//data: JSON.stringify(prenotazione)
	}).done(function(esito) {
	console.log(esito);
	if (esito.success) {
	
	alert("Utente registrato correttamente nel db")
	} else {
	alert("qualcosa è andato storto")
	}
	});
});