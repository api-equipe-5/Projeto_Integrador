function usuarioInvalido() {
	document.getElementById('olho').addEventListener('click', function() {
		document.getElementById('senha').type = 'text';
	});

	document.getElementById('olho').addEventListener('mousemove', function() {
		document.getElementById('senha').type = 'password';
	});

	// Para que o senhaword não fique exposto apos mover a imagem.
	//document.getElementById('olho').addEventListener('mousemove', function() {
		//document.getElementById('senha').type = 'senhaword';
	//});
}

