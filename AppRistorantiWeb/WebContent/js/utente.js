var utente = localStorage.getItem('utente');

if(utente) {
	$('#btnLogout').show();
	$('#btnAccedi').hide();
	utente = JSON.parse(utente);
	$('#LinkNome').html(utente.nome + ' ' + utente.cognome);
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