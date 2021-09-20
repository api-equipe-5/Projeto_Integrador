$(document).ready(function() {

    var login = document.getElementById('login');
    var cadastro = document.getElementById('cadastro');
    
    window.onclick = function(event) {
        if (event.target == login) {
            login.style.display = "none";
        }

        if (event.target == cadastro) {
            cadastro.style.display = "none";
        }
    }

    $('#cpf-cadastro').mask('000.000.000-00', {reverse: true});

});

var cadastrando = false;

$("#btn-cadastro").click(function(event) {

    event.preventDefault();

    if (cadastrando) return;

    cadastrando = true;

    var json = {
      nome: $("#nome-cadastro").val(),
      email: $("#email-cadastro").val(),
      empresa: $("#empresa-cadastro").val(),
      cpf: $("#cpf-cadastro").val(),
      senha: $("#senha-cadastro").val()
    };

    var btn = document.querySelector('#btn-cadastro');

    btn.innerText = 'Cadastrando...';
    btn.setAttribute('disabled', '');

    var jsonString = JSON.stringify(json);

    $.post("/cadastroempresario", jsonString, 'json')
        .done(function(){
            alert('Te enviamos um email com um link, acesse-o para ativar sua conta.');
            location.reload();
        });
})

var logando = false;
$('[data-login-form]').on('submit', function(event){
    event.preventDefault();

    if(logando) return;
    logando = true;

    var btn = document.querySelector('#entraaaaa');
    btn.innerText = 'Entrando...';
    btn.setAttribute('disabled', '');

    var email = event.currentTarget.querySelector('#email-login').value;
    var pass = event.currentTarget.querySelector('#senha-login').value;

    var data = {
        email: email,
        senha: pass
    };

    $.post("/Auth", JSON.stringify(data), 'json')
        .done(function(token){
            localStorage.setItem('token', token);
            location.replace('/empresa.html');
        })
        .fail(function() {
            logando = false;
            alert('Login ou senha invalidos');
            btn.innerText = 'Entrar';
            btn.removeAttribute('disabled');
        });
});

function abrePopupLogin(event) {
    event.preventDefault();
    document.getElementById('login').style.display='block';    
}

function fechaPopupLogin(event) {
    event.preventDefault();
    document.getElementById('login').style.display='none';    
}

function abrePopupCadastro(event) {
    event.preventDefault();
    document.getElementById('cadastro').style.display='block';    
}

function fechaPopupCadastro(event) {
    event.preventDefault();
    document.getElementById('cadastro').style.display='none';    
}