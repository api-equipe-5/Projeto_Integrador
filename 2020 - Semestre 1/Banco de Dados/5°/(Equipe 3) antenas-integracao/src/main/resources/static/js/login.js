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

function loginEmpresario() {
  const data = {
    email: document.getElementsByName("email-login-emp")[0].value,
    senha: document.getElementsByName("senha-login-emp")[0].value
  };
  Fetch.post('/empresario/login', data)
    .then(() => {
      
     window.location = "/empresa/painel";
      localStorage.setItem('email', data.email);
    })
    .catch(_ => {
      alert("Credenciais inválidas.");
    });
}

function loginCadi() {
  const data = {
    email: document.getElementsByName("email-login-cadi")[0].value,
    senha: document.getElementsByName("senha-login-cadi")[0].value
  };
  Fetch.post('/cadi/login', data)
    .then(() => {
      
     window.location = "/cadi/painel";
      localStorage.setItem('email', data.email);
    })
    .catch(_ => {
      alert("Credenciais inválidas.");
    });
}

function loginAluno() {
  const data = {
    email: document.getElementsByName("email-login-alu")[0].value,
    senha: document.getElementsByName("senha-login-alu")[0].value
  };
  Fetch.post('/aluno/login', data)
    .then(() => {
      
     window.location = "/aluno/painel";
      localStorage.setItem('email', data.email);
    })
    .catch(_ => {
      alert("Credenciais inválidas.");
    });
}
function loginProfessor() {
  const data = {
    email: document.getElementsByName("email-login-prof")[0].value,
    senha: document.getElementsByName("senha-login-prof")[0].value
  };
  Fetch.post('/professor/login', data)
    .then(() => {
      
     window.location = "/professor/painel";
      localStorage.setItem('email', data.email);
    })
    .catch(_ => {
      alert("Credenciais inválidas.");
    });
}


function registerEmpresario(url){
  const data = {
    nome: document.getElementsByName("nome-cadastro")[0].value,
    email: document.getElementsByName("email-cadastro")[0].value,
    empresa: document.getElementsByName("empresa-cadastro")[0].value,
    cpf: document.getElementsByName("cpf-cadastro")[0].value,
    senha: document.getElementsByName("senha-cadastro")[0].value
  };
  Fetch.post(url, data).then(() => {
    const $form = document.getElementById("formulario");
    $form.reset();
  });
} 


function register(url, tipo){
  const data = {
    nome: document.getElementsByName("nome-cadastro-"+tipo)[0].value,
    email: document.getElementsByName("email-cadastro-"+tipo)[0].value,
    senha: document.getElementsByName("senha-cadastro-"+tipo)[0].value
  };
  Fetch.post(url, data).then(() => {
    const $form = document.getElementById("formulario");
    $form.reset();
  });
} 





function abrePopupLogin(event) {
  event.preventDefault();
  document.getElementById('login').style.display='block';  
  $('#formulario-emp').append(_formLogin('emp'));
  $('#formulario-alu').append(_formLogin('alu'));
  $('#formulario-cadi').append(_formLogin('cadi'));
  $('#formulario-prof').append(_formLogin('prof'));
    
}

function fechaPopupLogin(event) {
  event.preventDefault();
  document.getElementById('login').style.display='none';    
  $('#formulario-emp').html("");
  $('#formulario-alu').html("");
  $('#formulario-cadi').html("");
  $('#formulario-prof').html("");
}

function abrePopupCadastro(event) {
  event.preventDefault();
  document.getElementById('cadastro').style.display='block';    
  $('#form-cad-emp').append(_formRegisterEmpresario());
  $('#form-cad-prof').append(_formRegister('prof'));
  $('#form-cad-alu').append(_formRegister('alu'));
  $('#form-cad-cadi').append(_formRegister('cadi'));
}

function fechaPopupCadastro(event) {
  event.preventDefault();
  document.getElementById('cadastro').style.display='none';   
  $('#form-cad-emp').html("");
  $('#form-cad-prof').html("");
  $('#form-cad-alu').html("");
  $('#form-cad-cadi').html(""); 
 
}

function _formLogin(tipo){
  return `
  <div class="imgcontainer">
          <span onclick="fechaPopupLogin(event)" class="close" title="Close Modal">&times;</span>
        </div>

        <div class="container">
          <label for="email-login-${tipo}"><b>E-mail</b></label>
          <input type="text"  name="email-login-${tipo}" required>

          <label for="senha-login"><b>Senha</b></label>
          <input type="password" name="senha-login-${tipo}" required>
            
          <button>Entrar</button>
        </div>`;
}

function _formRegisterEmpresario(){
  return `<div class="imgcontainer">
  <span onclick="fechaPopupCadastro(event)" class="close" title="Close Modal">&times;</span>
  </div>

  <div class="container">
    <label for="nome-cadastro"><b>Nome</b></label>
    <input type="text"  name="nome-cadastro" required>

    <label for="email-cadastro"><b>E-mail</b></label>
    <input type="email"  name="email-cadastro" class="email-field" required>

    <label for="empresa-cadastro"><b>Empresa</b></label>
    <input type="text" name="empresa-cadastro" class="email-field" required>

  
    <label for="cpf-cadastro"><b>CPF</b></label>
    <input type="text" name="cpf-cadastro" >

    
    <label for="senha-cadastro"><b>Senha</b></label>
    <input type="password" name="senha-cadastro" required>

    <button>Cadastrar</button>
  </div>`;
}

function _formRegister(tipo){
  return `<div class="imgcontainer">
  <span onclick="fechaPopupCadastro(event)" class="close" title="Close Modal">&times;</span>
  </div>

  <div class="container">
    <label for="nome-cadastro"><b>Nome</b></label>
    <input type="text" name="nome-cadastro-${tipo}" required>

    <label for="email-cadastro"><b>E-mail</b></label>
    <input type="email" name="email-cadastro-${tipo}" class="email-field" required>
    
    <label for="senha-cadastro"><b>Senha</b></label>
    <input type="password" name="senha-cadastro-${tipo}" required>

    <button>Cadastrar</button>
  </div>`;
}
