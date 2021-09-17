var CryptoJS = require("crypto-js");


function criptografar(conteudo, chave){
    return CryptoJS.AES.encrypt(JSON.stringify(conteudo), chave).toString();
}
function descriptografar(conteudo, chave){
    var bytes  = CryptoJS.AES.decrypt(conteudo, chave);
    return JSON.parse(bytes.toString(CryptoJS.enc.Utf8));
}

module.exports = {
    criptografar, 
    descriptografar
};
