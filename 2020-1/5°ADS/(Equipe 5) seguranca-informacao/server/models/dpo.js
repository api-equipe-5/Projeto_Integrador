const selectPromise = require('../servicos/select');
const authConfig = require('./config/auth.json');
const servicoDPO = require('../servicos/dpo');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcrypt');

async function criar(nome_dpo, email_dpo, senha, desc_dpo, telefone_dpo) {
    const hashedPassword = await bcrypt.hash(senha, 10);

    const dpo = {
        nome_dpo: nome_dpo,
        email_dpo: email_dpo,
        senha: hashedPassword,
        desc_dpo: desc_dpo,
        telefone_dpo: telefone_dpo
    };

    servicoDPO.createDPO(nome_dpo, email_dpo, hashedPassword, desc_dpo, telefone_dpo);

    return dpo;
}

async function listar(cod_dpo) {
    return (await servicoDPO.selectDPO(cod_dpo));
}

function alterar(cod_dpo, nome_dpo, email_dpo, senha, desc_dpo, telefone_dpo){
    return servicoDPO.updateDPO(cod_dpo, nome_dpo, email_dpo, senha, desc_dpo, telefone_dpo)
}

async function listarTodosDPO(){
    return (await servicoDPO.selectTodosDPO());
}

function deletar(cod_dpo){
    return servicoDPO.deleteDPO(cod_dpo);
}

async function login(email, senha){
    try{
        let currentDPO = await selectPromise('select * from dpo where email_dpo = "'+email+'"');

        if (currentDPO) {
            if(await bcrypt.compare(senha, currentDPO[0].senha)){
                const token = jwt.sign({
                    id_user: currentDPO[0].cod_dpo,
                    email: currentDPO[0].email_dpo
                }, authConfig.secret, {
                    expiresIn: "1h"
                });
                return { token: token, nome_dpo: currentDPO[0].nome_dpo};
            }
        }
    } catch(err){
        console.log(err);
        return false;
    }

    

}

module.exports = {
    criar,
    listar,
    alterar,
    deletar,
    listarTodosDPO,
    login
};