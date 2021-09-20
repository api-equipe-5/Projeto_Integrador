$(document).ready(function() {
    $('select').formSelect();
});

$('#cadastroForm').submit(function() {
    const usuarioForm = {
      cpf: $('#cpf').val(),
      anoNascimento : $('#anoNascimento').val(),
      cidade: $('#cidade').val(),
      uf: $('#selectEstados').val(),
      sexo: $('input:radio[name=sexo]:checked').val(),
      senha: $('#senha').val(),
      confirmarSenha: $('#confirmarSenha').val()
    }
  
    $.post('http://localhost:4567/api/v1/UsuarioPessoaFisica', usuarioForm, function(response) {
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
























