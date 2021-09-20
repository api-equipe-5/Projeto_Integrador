const rsaWrapper = require('./rsa-wrapper');
const aesWrapper = require('./aes-wrapper');

const encryptClientData = ( clientKey, data ) => {
    const aesKey = aesWrapper.generateKey();
    const encryptedData = aesWrapper.createAesMessage(aesKey, data);
    const encryptedAesKey = rsaWrapper.encrypt(clientKey, (aesKey.toString('base64')));
    
    return {
        encryptedData: encryptedData,
        encryptedAesKey: encryptedAesKey
    };
}

module.exports = { encryptClientData };