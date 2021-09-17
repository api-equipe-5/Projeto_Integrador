const servicoResposta = require('../servicos/resposta')

function criar(conteudo, autor, cod_comunicado){
    const resposta = {
        conteudo: conteudo,
        autor: autor,
        cod_comunicado: cod_comunicado
    };

    servicoResposta.insertQuery(conteudo, autor, cod_comunicado);

    return resposta;
}

function updateTableComunicado(cod_comunicado){
    servicoResposta.updateComunicado(cod_comunicado); 
}

module.exports = {criar, updateTableComunicado};