const modelDPO = require('../models/dpo');

async function index(req, res) {
    const cod_dpo = req.params.cod_dpo;
    const dpo = await modelDPO.listar(cod_dpo);
    
    var lista_dpo = {};

    lista_dpo.nome_dpo = dpo[0].nome_dpo
    lista_dpo.email_dpo = dpo[0].email_dpo
    lista_dpo.desc_dpo = dpo[0].desc_dpo
    lista_dpo.telefone_dpo = dpo[0].telefone_dpo
    lista_dpo.data_criado = dpo[0].data_criado
    lista_dpo.data_atualizado = dpo[0].data_atualizado
    
    res.json({lista_dpo: lista_dpo});
}

async function retornarTodosDPO(req, res){
    const retorno = await modelDPO.listarTodosDPO();
    res.json({retorno:retorno});
}

function alterarDPO(req, res){
    const id = req.params.cod_dpo;
    const {
        nome_dpo,
        email_dpo,
        senha,
        desc_dpo,
        telefone_dpo
    } = req.body;
    
    const dpo = modelDPO.alterar(
        id,
        nome_dpo,
        email_dpo,
        senha,
        desc_dpo,
        telefone_dpo);

    res.json({dpo: dpo})
}

function criarDPO(req, res) {
    const {
        nome_dpo,
        email_dpo,
        senha,
        desc_dpo,
        telefone_dpo
    } = req.body;

    const dpo = modelDPO.criar(
        nome_dpo,
        email_dpo,
        senha,
        desc_dpo,
        telefone_dpo
    );

    res.json({dpo: dpo});
}

function deletarDPO(req, res){
    const cod_dpo = req.params.cod_dpo;
    const dpo = modelDPO.deletar(cod_dpo);
    res.json({dpo: dpo});
}

module.exports = {
    index,
    criarDPO,
    retornarTodosDPO,
    alterarDPO,
    deletarDPO
}