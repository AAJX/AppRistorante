var utente = localStorage.getItem('utente');
utente = JSON.parse(utente);

//Ciao, amico

if(utente) {
	$('#btnLogout').show();
	$('#btnAccedi').hide();
	$('#LinkNome').html(utente.nome + ' ' + utente.cognome);
	$('#emaill').html(utente.email);
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
		// <li>Anna Rossi</li>
		localStorage.setItem('ristoranti', JSON.stringify(ristoranti));
//		ristoranti.forEach(function(r) {
//			for (var i =0; i<3 ; i++)
//			
//			localStorage.setItem('ristorante'+i, JSON.stringify(r));
//		
//		})
	});
});

var ristoranti = localStorage.getItem('ristoranti');
ristoranti = JSON.parse(ristoranti);


	


$('#btnPrenota').click(function() {
	
$.ajax({
	url : 'nuovaPrenotazione',
	method : 'post',
	data : $('#frmPrenota').serialize(),
	}).done(function(esito) {
	console.log(esito);
	if (esito.success) {
	
	alert("Utente registrato correttamente nel db")
	} else {
	alert("qualcosa è andato storto")
	}
	});
});