var utente = localStorage.getItem('utente');

if(utente) {
	$('#btnLogout').show();
	$('#btnAccedi').hide();
	utente = JSON.parse(utente);
	$('#LinkNome').html(utente.nome + ' ' + utente.cognome);
}else {
	$('#btnLogout').hide();
	$('#btnAccedi').show();
	$('#LinkNome').html( 'amico' );
}


$('#btnLogout').click(function() {
	localStorage.removeItem('utente');
	location.href = 'Login.html';
});