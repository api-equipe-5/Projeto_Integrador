//LOGIN NOVO, COM TOKEN
$(document).ready(function() {

    var login = document.getElementById('login'); //label de id login
    var cadastro = document.getElementById('cadastro'); //label de id cadastro

    window.onclick = function(event) {
        if (event.target == login) {
            login.style.display = "none";
        }

        if (event.target == cadastro) {
            cadastro.style.display = "none";
        }
    }


});


var logando = false;
$('[data-login-form]').on('submit', function(event){  
    event.preventDefault();

    if(logando) return;
    logando = true;

    var btnEntrar = document.querySelector('#entrar');
    btnEntrar.innerText = 'Entrando...';
    btnEntrar.setAttribute('disabled', '');

    var email = event.currentTarget.querySelector('#email-login').value.trim();
    var senha = event.currentTarget.querySelector('#senha-login').value.trim();

    var dados = {
        email: email,
        senha: senha
    };

    $.post("/aluno", JSON.stringify(dados) , 'json')
        .done(function(token){
            localStorage.setItem('token', token);
            sessionStorage.setItem("sess_email_aluno", dados.email);
            location.replace('/aluno/principal.html');
        })
        .fail(function() {
            logando = false;
            alert('Login ou senha invalidos');
            btnEntrar.innerText = 'Entrar';
            btnEntrar.removeAttribute('disabled');
        });
});


var cadastrando = false;

$('#form_cadastro').submit(function(e){  
    e.preventDefault();
    
    if (cadastrando) return;
    cadastrando = true;
    json = {
    		nome: $("#nome-cadastro").val(),
	        email: $("#email-cadastro").val(),
	        senha: $("#senha-cadastro").val(),
	        //Nivel em teste!!!
	        nivel: 1
    }
	jsonString = JSON.stringify(json);
    
    
    email= $("#email-cadastro").val();
    let retornoValidacao = validaEmail(email);
    if(retornoValidacao)
	{
	    $.post("/aluno-cadastro",JSON.stringify(json),'json')
	    .done(function(){
            alert('Acesse sua caixa de email e clique no link enviado para ativar sua conta!');
            location.reload();
        });
	    fechaPopupCadastro(event);
    }
    else
    {
    	alert("O cadastro só pode ser realizado com seu e-mail institucional");
    }
});


function validaEmail(email) {
    let texto = /^\s*[\w\-\+_]+(\.[\w\-\+_]+)*\@[\w\-\+_]+\.[\w\-\+_]+(\.[\w\-\+_]+)*\s*$/;
    if (texto.test(email)) {
        if (email.indexOf('@fatec.sp.gov.br', email.length - '@fatec.sp.gov.br'.length) !== -1) {
            alert('Te enviamos um email com um link, acesse-o para ativar sua conta.');
            return true;
        } else {
            alert('Use seu e-mail institucional para realizar o cadastro (seu.nome@fatec.sp.gov.br)');
            return false;
        }
    } else {
        alert('Endereço de e-mail inválido');
        return false;
    }
}


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


//botão para fazer logout
$('#sair').click(function(e){

    e.preventDefault();

    localStorage.removeItem('token');
    sessionStorage.setItem("sess_email_aluno", '');
    location.replace('/aluno');
})




