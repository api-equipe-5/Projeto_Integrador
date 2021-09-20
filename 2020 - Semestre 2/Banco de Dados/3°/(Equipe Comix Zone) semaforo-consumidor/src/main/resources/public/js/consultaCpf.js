$(document).ready(function() {
    $('select').formSelect();
});

$('#consultaCpfForm').submit(function(e) {
    e.preventDefault();
    const cpf = $('#cpf').val();
    $.get('http://localhost:4567/api/v1/DadosPF/' + cpf, function(response) {
        const json = JSON.parse(response);

        var conteudoTabela = "<h2 class='suaConta'>Dados de Terceiros</h2>" +
            "<p class='suaConta'>Tabela com os dados referentes cpf pesquisado:</p>" +
            "<table id='tabela' class='table table-bordered'>" +
            "<thead>" +
            "<tr>" +
            "<th>ID pagamento</th>" +
            "<th>CPF</th>" +
            "<th>Nº Pgtos Realizados</th>" +
            "<th>Quantidade Parcelas</th>" +
            "<th>Vencimento Ult.Parcela</th>" +
            "<th>Número contrato</th>" +
            "<th>Valor Total-Contrato</th>" +
            "<th>Código modalidade</th>" +
            "</tr>" +
            "</thead>" +
            "<tbody'>" +
            "<tr>"

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

        conteudoTabela = conteudoTabela +
            "</tr>" +
            "</tbody>" +
            "</table>"

        document.getElementById("operacoes").innerHTML = conteudoTabela
    });
})
