const crypto = require('crypto');
const fs = require('fs');
const path = require('path');

const rsaWrapper = {};

rsaWrapper.encrypt = (publicKey, message) => {
    fs.writeFileSync('tempKey.pem', publicKey);
    let tempKey = fs.readFileSync('tempKey.pem');
    let enc = crypto.publicEncrypt({
        key: tempKey,
        padding: crypto.RSA_PKCS1_OAEP_PADDING
    }, Buffer.from(message));
    fs.unlink('tempKey.pem', function (err) {
        if (err) throw err;
    });
    return enc.toString('base64');
};

rsaWrapper.decrypt = (message) => {
    let privateKey = fs.readFileSync(path.resolve(__dirname, '../../secrets/rsa_private.pem'));
    let enc = crypto.privateDecrypt({
        key: privateKey,
        padding: crypto.RSA_PKCS1_OAEP_PADDING
    }, Buffer.from(message, 'base64'));
    return enc.toString();
};

module.exports = rsaWrapper;