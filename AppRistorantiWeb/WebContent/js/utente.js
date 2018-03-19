var utente = localStorage.getItem('utente');
utente = JSON.parse(utente);

//Ciao, amico

if(utente) {
	$('#btnLogout').show();
	$('#btnAccedi').hide();
	$('#LinkNome').html(utente.nome + ' ' + utente.cognome);
	$('#email').val(utente.email);
	$('#profiloNome').html(utente.nome+ ' ' + utente.cognome);
	$('#profiloTelefono').html(utente.numeroTelefono);
	$('#profiloEmail').html(utente.email);
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

// crea un locale storage dei ristoranti 

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

var prenotazioni =localStorage.getItem('utente.prenotazioni');

	
//Prenotazione

$('#btnPrenota').click(function() {
		
$.ajax({
	url : 'nuovaPrenotazione',
	method : 'post',
	data : $('#frmPrenota').serialize(),
	}).done(function(esito) {
	console.log(esito);
	alert("La tua prenotazione è andata a buon fine");
	});
});

//Lista prenotazioni

$(document).ready(function(){
	$.ajax({
		url: 'listaPrenotazioni',
		method: 'get',
		data: $('#frmPre').serialize()
	})
	.done(function(prenotazioni) {
		// <li>Anna Rossi</li>

		prenotazioni.forEach(function(p){
	
			
			var stringa = '<tr>'
				+ '<th scope="row" >#'+ p.idPrenotazione +'</th>'
			+'<td>' + p.data + '</td>'
			+ '<td>' + p.orario + '</td>'
			+'<td>' + p.numeroPrenotati + '</td>'
			+'<td>' + p.ristorante.nome + '</td>'
			+'</tr>';
			$('#elencoPrenotazioni').append(stringa);
			
	
			
		})
			
	});
});
// Lista prenotazioni cliccabile
$(document).ready(function(){
	$.ajax({
		url: 'listaPrenotazioni',
		method: 'get',
		data: $('#frmPre').serialize()
	})
	.done(function(persone) {
		
		
		persone.forEach(function(pr) {
			var stringa = '<option class="optionPr">'+pr.idPrenotazione+'</option>';
			$('#elencoPe').append(stringa);
			
		})
	})
});

//Cambia Ora

$('#btnCambiaOrario').click(function() {

	console.log($('#CambiaOrario,#frmPrenot,#frmPre').serialize())
	$.ajax({
		url : 'modificaOrarioPrenotazione',
		method : 'get',
		data :  $('#CambiaOrario,#frmPrenot,#frmPre').serialize(),
		}).done(function(esito) {
		console.log(esito);
		alert("La tua prenotazione è stata modificata");
		});
	});

//Cambia Coperti
$('#btnCambiaCoperti').click(function() {
	console.log($('#CambiaCoperti,#frmPrenot,#frmPre').serialize())
	$.ajax({
		url : 'modificaCopertiPrenotazione',
		method : 'get',
		data : $('#CambiaCoperti,#frmPrenot,#frmPre').serialize(),
		}).done(function(esito) {
		console.log(esito);
		alert("La tua prenotazione è stata modificata");
		});
	});

//Cambia Data
$('#btnCambiaData').click(function() {
	console.log($('#CambiaData,#frmPrenot,#frmPre').serialize())
	$.ajax({
		url : 'modificaDataPrenotazione',
		method : 'get',
		data : $('#CambiaData,#frmPrenot,#frmPre').serialize(),
		}).done(function(esito) {
		console.log(esito);
		alert("La tua prenotazione è stata modificata");
		});
	});

//Elimina Prenotazione
$('#btnEliminaPrenotazione').click(function() {
	console.log($('#frmPrenot,#frmPre').serialize())
	$.ajax({
		url : 'EliminaPrenotazione',
		method : 'get',
		data : $('#frmPrenot,#frmPre').serialize(),
		}).done(function(esito) {
		console.log(esito);
		alert("La tua prenotazione è stata cancellata");
		});
	});

// Cambia Password
$('#btnCambiaPassword').click(function() {
	console.log($('#CambiaPassword,#frmPre').serialize())
	$.ajax({
		url : 'modificaPasswordAccount',
		method : 'get',
		data : $('#CambiaPassword,#frmPre').serialize(),
		}).done(function(esito) {
		console.log(esito);
//		localStorage.removeItem('utente');
//		localStorage.setItem('utente', JSON.stringify(utente));
		alert("La password è stata modificata");
		});
	});


//Cambia Telefono
$('#btnCambiaTelefono').click(function() {
	console.log($('#CambiaTelefono,#frmPre').serialize())
	$.ajax({
		url : 'ModificaTelefonoAccount',
		method : 'get',
		data : $('#CambiaTelefono,#frmPre').serialize(),
		}).done(function(esito) {
		console.log(esito);
//		localStorage.setItem('utente', JSON.stringify(utente));
		alert("Il numero di telefono è stato aggiornato");
		});
	});

//Cambia Telefono
$('#btnCancAcc').click(function() {
	console.log($('#VerificaPassword,#frmPre').serialize())
	$.ajax({
		url : 'eliminaAccount',
		method : 'get',
		data : $('#VerificaPassword,#frmPre').serialize(),
		}).done(function(esito) {
		console.log(esito);

		alert("Il numero di telefono è stato aggiornato");
		localStorage.removeItem('utente');
		location.href = 'Login.html';
		});
	});


