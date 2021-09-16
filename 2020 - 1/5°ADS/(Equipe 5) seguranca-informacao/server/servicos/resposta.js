const sqlite3 = require('sqlite3').verbose();
const dataService = require('../servicos/data');
const db = new sqlite3.Database('db/AppDB.db', sqlite3.OPEN_READWRITE, (err) => {
    if (err) {
        console.error(err.message);
    }
});

function insertQuery(conteudo, autor, cod_comunicado) {
    const data_atual = dataService();

    return db.run('INSERT INTO resposta (conteudo_resposta, autor_resposta, data_resposta, data_resposta_atualizado, cod_comunicado) ' +
        'values ("' + conteudo + '","' + autor + '","'+data_atual+'","'+data_atual+'",' + cod_comunicado + ');',
        function (err) {
            if (err) {
                return console.log(err.message);
            }
        });
}

function updateComunicado(cod_comunicado){
    const data_atual = dataService();
    return db.run('UPDATE comunicado SET data_comunicado_atualizado = "'+data_atual+'" WHERE cod_comunicado = '+cod_comunicado);
}

module.exports = {
    insertQuery,
    updateComunicado
};