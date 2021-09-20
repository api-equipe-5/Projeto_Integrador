$(document).ready(function() {
    $('select').formSelect();
});

$('#cadastroFormPJ').submit(function() {
    const usuarioForm = {
      cnpj: $('#cnpj').val(),
      cidade: $('#cidadePJ').val(),
      uf: $('#selectEstadosPJ').val(),
      senha: $('#senhaPJ').val(),
      confirmarSenha: $('#confirmarSenhaPJ').val()
    }
  
    $.post('http://localhost:4567/api/v1/UsuarioPessoaJuridica', usuarioForm, function(response) {
        alert(response);
    })
    .done(function() {
        alert('Cadastrado com sucesso!')
        window.location.href = 'http://localhost:4567'
    })
    .fail(function() {
        alert('Algum erro ocorreu, tente novamente mais tarde');
    })
    .always(function() {
        alert('Você será redirecionado para a próxima página.');
    });
})
























