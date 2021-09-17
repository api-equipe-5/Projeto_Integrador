
var iframe=document.querySelector("#tela");
function login(){
    iframe.setAttribute("src","/src/templates/login.html");
}

function agenda(){
    iframe.setAttribute("src","/src/templates/agendamento.html");
}

function servico(){
    iframe.setAttribute("src","/src/templates/servico.html");
}
function perfil(){
    iframe.setAttribute("src","/src/templates/usuario.html");
}
