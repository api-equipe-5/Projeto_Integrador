$('#loginForm').submit(function(e){    
    e.preventDefault();
    const loginURL = "http://localhost:4567/api/v1/Login"
    const usuarioForm = {
        doc_cli: $('#doc_cli').val(),
        senha: $('#senha').val(),
    }
    $.post(loginURL, usuarioForm, function(data) {
        //Se o usuário não existir, volte para a tela inicial
        const json = JSON.parse(data);
        if(json.cpf == undefined && json.cnpj == undefined){
            alert("Login ou senha inválidos.")
            window.location.href = '/index.html';
        //Se o usuário existir, vá para a tela principal
        } else {
            sessionStorage.setItem("doc_cli", json.cpf);
            $.get("http://localhost:4567/api/v1/Score/" + json.cpf, function(getscore) {
                sessionStorage.setItem("score", JSON.parse(getscore));
            });
            window.location.href = '/tela-principal.html';
        }
                    
    });
    
});

//$('#Logout').click(function() {
//    sessionStorage.clear();
//    window.location.href = '/index.html';
//});

















