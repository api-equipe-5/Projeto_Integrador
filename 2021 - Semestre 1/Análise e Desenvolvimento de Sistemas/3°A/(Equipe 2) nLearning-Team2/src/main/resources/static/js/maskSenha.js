function alertSenhaIncorreta() {
	senha = document.getElementById('password').value;
	senha2 = document.getElementById('password_confirmation').value;

	if (senha != senha2) {
		document.getElementById('alertId').classList.replace('hide', 'show')
	}
	else {
		document.getElementById('alertId').classList.replace('show', 'hide')
	}
}

function alertCadastro() {
	senha = document.getElementById('password').value;
	senha2 = document.getElementById('password_confirmation').value;

	if (senha != senha2) {
		alert("Usuário não cadastrado pois a senhas eram diferentes!")
	}
	else {
		alert("Usuário cadastrado com sucesso!")
	}
}