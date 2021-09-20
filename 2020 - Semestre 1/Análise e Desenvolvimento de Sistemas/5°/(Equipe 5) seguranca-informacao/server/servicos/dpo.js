const selectPromise = require('./select');
const sqlite3 = require('sqlite3').verbose();
const serviceLog = require('../servicos/logger');
const dataService = require('../servicos/data');

const db = new sqlite3.Database('db/AppDB.db', sqlite3.OPEN_READWRITE, (err) => {
    if (err) {
        console.error(err.message);
    }
});

function createDPO(nome_dpo, email_dpo, senha, desc_dpo, telefone_dpo){
  const data_atual = dataService();
  return db.run('INSERT INTO dpo (nome_dpo, email_dpo, senha, desc_dpo, telefone_dpo, data_criado) '+
    'VALUES ("'+nome_dpo+'","'+email_dpo+'","'+senha+'","'+desc_dpo+'","'+telefone_dpo+'","'+data_atual+'");',
    function (err) {
      if (err) {
        return console.log(err.message);
      }

      else{
        serviceLog.sendLogDPO('info', `DPO criado!: ${nome_dpo}`, 'DPO_Cadastrar');
      }

  });
}

async function selectDPO(cod_dpo) {
  var resposta  = await selectPromise('SELECT d.cod_dpo, '+
  'd.nome_dpo, '+
  'd.email_dpo, '+
  'd.senha, '+
  'd.desc_dpo, '+
  'telefone_dpo, '+
  'd.data_criado, '+
  'd.data_atualizado '+
  'from dpo d '+
  'where d.cod_dpo = '+cod_dpo+';');
  
  return resposta;
  }

  async function selectTodosDPO(){
    var resposta  = await selectPromise('SELECT d.cod_dpo, '+
        'd.nome_dpo, '+
        'd.email_dpo, '+
        'd.senha, '+
        'd.desc_dpo, '+
        'telefone_dpo, '+
        'd.data_criado, '+
        'd.data_atualizado '+
        'from dpo d '+
        'order by d.cod_dpo ');
    return resposta;
  }

  function updateDPO(cod_dpo, nome_dpo, email_dpo, senha, desc_dpo, telefone_dpo){
    const data_atual = dataService();
    return db.run('UPDATE dpo SET '+
                  'nome_dpo = "'+nome_dpo+
                  '", email_dpo = "'+email_dpo+
                  '", senha = "'+senha+
                  '", desc_dpo = "'+desc_dpo+
                  '", telefone_dpo = "'+telefone_dpo+
                  '", data_atualizado = "'+data_atual+'"'+
                  ' where cod_dpo = "'+cod_dpo+'";',
   
              function (err) {
                  if (err) {
                      return console.log(err.message);
                  }

                  else
                    serviceLog.sendLogDPO('info', `DPO alterado!: ${cod_dpo} - ${nome_dpo}`, 'DPO_Alterar');
              });
  }

function deleteDPO(cod_dpo){
  serviceLog.sendLogDPO('info', `DPO deletado!: ${cod_dpo}`,'DPO_Deletar');
  return db.run('DELETE from dpo where cod_dpo = '+cod_dpo);  
}

module.exports = {
    selectDPO, 
    selectTodosDPO,
    createDPO,
    updateDPO,
    deleteDPO
};