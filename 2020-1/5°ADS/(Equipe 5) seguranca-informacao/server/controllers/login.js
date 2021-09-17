const modelDPO = require('../models/dpo');
const serviceLog = require('../servicos/logger');

async function validarLogin(req, res) {
    const email = req.body.email;
    const senha = req.body.senha;

    var func = await modelDPO.login(email, senha);
    
    if (func){
        serviceLog.sendLogDPO('info', `Login realizado com o seguinte email: ${email}`, 'Login');
        res.status(200);
        return res.json({
            session: func
        });
    }
    else {
        res.status(403);
        return res.json();
    }
}

module.exports = { validarLogin };