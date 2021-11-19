function logar(form){

  var email = document.getElementById("login");
  var senha = document.getElementById("senha");

    if(form.login.value == "thaisrabelo" && form.senha.value == "12345" || form.login.value == "biac" && form.senha.value == "asdfg" ){
      location = "pagina-inicial.html";
    }else{
      form.login.value=""
      form.senha.value=""
      alert("Login ou Senha incorretos");
    }
}
