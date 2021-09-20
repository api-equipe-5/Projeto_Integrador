const selectPromise = require('../servicos/select');
const insertPromise = require('../servicos/insert');
const servicoComunicado = require('../servicos/comunicado');
const dataService = require('../servicos/data');

async function criar(responsavel_comunicado, email_comunicado, hash_comunicado, cod_dpo) {
    const data_atual = dataService()

    await insertPromise('INSERT INTO comunicado (data_comunicado, responsavel_comunicado, email_comunicado, data_comunicado_criado, data_comunicado_atualizado, hash_comunicado, cod_dpo) VALUES ("'+data_atual+'","'+responsavel_comunicado+'","'+email_comunicado+'","'+data_atual+'","'+data_atual+'","'+hash_comunicado+'", "'+ cod_dpo +'")');
    
    const [result] = await selectPromise('SELECT cod_comunicado from comunicado order by 1 desc limit 1');

    const comunicado = {
        cod_comunicado: result.cod_comunicado,
        data_comunicado: data_atual,
        responsavel_comunicado: responsavel_comunicado,
        email_comunicado: email_comunicado,
        data_comunicado_criado: data_atual,
        data_comunicado_atualizado: data_atual,
        hash_comunicado: hash_comunicado,
        cod_dpo: cod_dpo
    };

    return comunicado;
}

async function listar(cod_comunicado) {
    return (await servicoComunicado.selectComunicado(cod_comunicado));
}

async function listarTodosComunicado(){
    return (await servicoComunicado.selectTodosComunicado());
}

async function validarComunicado(token, id_comunicado){
    tableHash = await selectPromise('select hash_comunicado from comunicado where cod_comunicado = '+id_comunicado);
    hash = tableHash[0].hash_comunicado;
    if (token == hash)
        return true;
        
    return false;
}

module.exports = {
    criar,
    listar,
    listarTodosComunicado,
    validarComunicado
};