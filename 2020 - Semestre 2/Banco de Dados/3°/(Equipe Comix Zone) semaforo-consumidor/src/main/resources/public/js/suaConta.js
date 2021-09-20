$(document).ready(function(){
    const cpf = sessionStorage.getItem("doc_cli");
    $.get('http://localhost:4567/api/v1/DadosPF/' + cpf, function(response) {
        const json = JSON.parse(response);
        console.log(json);
        var conteudoTabela = ""
        for(var item in json.operacoes){
//            console.log(item + ' - ' + json.operacoes[item].id)
            conteudoTabela = conteudoTabela +
                "<tr>" +
                "<td>"+ json.operacoes[item].id + "</td>" +
                "<td>"+ json.operacoes[item].cpf + "</td>" +
                "<td>"+ json.operacoes[item].movimentos.lenght + "</td>" +
                "<td>"+ json.operacoes[item].quantidadeParcelasContrato + "</td>" +
                "<td>"+ json.operacoes[item].dataVencimentoUltimaParcela + "</td>" +
                "<td>"+ json.operacoes[item].numeroContrato + "</td>" +
                "<td>"+ json.operacoes[item].valorTotalContratadoParcelado + "</td>" +
                "<td>"+ json.operacoes[item].idModalidade + "</td>" +
                "</tr>";
        }
        document.getElementById("operacoes").innerHTML = conteudoTabela
    });
})

$('#cadastroForm').submit(function() {
    const usuarioForm = {
        docCliBloqueador: sessionStorage.getItem("cpf"),
        docCliBloqueado: $('#cnpj').val()
    }

    $.post('http://localhost:4567/api/v1/ListaNegra', usuarioForm, function(response) {
        alert(response);
    })
        .done(function() {
            alert('CNPJ bloqueado com sucesso!')
            window.location.href = 'http://localhost:4567'
        })
        .fail(function() {
            alert('Algum erro ocorreu, tente novamente mais tarde');
        })
        .always(function() {
            alert('Você será redirecionado para a próxima página.');
        });
})