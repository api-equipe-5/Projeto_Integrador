const modelComunicado = require('../models/comunicado');

async function validarToken(req, res) { // Parâmetros passados por URL "?token=exemploToken&id=numID"
    const token = req.query.token; // query params
    const id = req.query.id; // query params

    var func = await modelComunicado.validarComunicado(token, id);
    
    if (func){
        res.status(200);
        return res.json();
    }
    else {
        res.status(403);
        return res.json();
    }
}

module.exports = { validarToken };