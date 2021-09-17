const checkUser = document.querySelector('.usuario');
const checkPass = document.querySelector('.senha');

const user = 'admin';
const pass = '123456';

function verify() {
  if (checkUser.value != user) {
    alert('Usuário inválido');
  } else if (checkPass.value != pass) {
    alert('Senha inválida');
  } else {
    window.location.href = "../ferramenta/index.html";
  }
}

