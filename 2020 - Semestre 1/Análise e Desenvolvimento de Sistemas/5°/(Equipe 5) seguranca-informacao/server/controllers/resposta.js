const modelResposta = require('../models/resposta');
const modelComunicado = require('../models/comunicado');
const cripto = require('../servicos/criptografia');
const logService = require('../servicos/logger');


async function criar(req, res) {
    var { conteudo, autor, cod_comunicado} = req.body;
   
    const result = await modelComunicado.listar(cod_comunicado);
    const hash_comunicado = result[0].hash_comunicado;
    

    conteudo = cripto.criptografar(conteudo, hash_comunicado);

    const resposta = modelResposta.criar(conteudo, autor, cod_comunicado);

    modelResposta.updateTableComunicado(cod_comunicado);

    logService.sendLog('info', `Resposta adicionada ao comunicado por ${autor}!`, hash_comunicado, cod_comunicado);

    res.status(200).json({ resposta: resposta });
}

module.exports = {
    criar
};