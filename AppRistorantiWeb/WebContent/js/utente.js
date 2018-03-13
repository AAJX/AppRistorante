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
		method: 'get'
	})
	.done(function(prenotazioni) {
		// <li>Anna Rossi</li>
		var i =1;
		prenotazioni.forEach(function(p){
			
			
			var stringa = '<tr>'
				+ '<th scope="row" >'+ i +'</th>'
			+'<td>' + p.data + '</td>'
			+ '<td>' + p.orario + '</td>'
			+'<td>' + p.numeroPrenotati + '</td>'
			+'<td>' + p.ristorante.nome + '</td>'
			+'<tr>';
			$('#elencoPrenotazioni').append(stringa);
			
			i++;
			
		})
			
	});
});
// Lista prenotazioni cliccabile
$(document).ready(function(){
	$.ajax({
		url: 'listaPrenotazioni',
		method: 'get'
	})
	.done(function(persone) {
		
		var i=1;
		persone.forEach(function(pr) {
			var stringa = '<option class="optionPr">'+pr.idPrenotazione+'</option>';
			$('#elencoPe').append(stringa);
		i++;	
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
$('btnEliminaPrenotazione').click(function() {
	console.log($('#frmPrenot,#frmPre').serialize())
	$.ajax({
		url : 'EliminaPrenotazione',
		method : 'delete',
		data : $('#frmPrenot,#frmPre').serialize(),
		}).done(function(esito) {
		console.log(esito);
		alert("La tua prenotazione è stata cancellata");
		});
	});
