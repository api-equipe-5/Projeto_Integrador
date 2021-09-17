var fs = require('fs');

var templateDatabaseConfig = `module.exports = {
    user: '<db_user>',
    host: '<host>',
    database: '<db_name>',
    password: '<db_user_password>',
    port: '<db_port>'
};`;

var templateKeys = `module.exports = {
    google: {
        clientID: '<Client_ID>',
        clientSecret: '<Client_Secret>'
    },
    session: {
        cookieKey: '<key>'
    }
};`;

var templateSecretsIndex = `const APP_SECRET = '<key>';
module.exports = { APP_SECRET }`;

var templatePublicKey = `-----BEGIN PUBLIC KEY-----
-----END PUBLIC KEY-----`;

var templatePrivateKey = `-----BEGIN RSA PRIVATE KEY-----
-----END RSA PRIVATE KEY-----`;

fs.mkdir('./backend/secrets', {recursive: true}, (err) => {
    if (err) {
        throw err;
    }
});
fs.mkdir('.segunda_aplicacao/backend/secrets', {recursive: true}, (err) => {
    if (err) {
        throw err;
    }
});
fs.writeFileSync('./backend/secrets/databaseConfiguration.js', templateDatabaseConfig);
fs.writeFileSync('./backend/secrets/keys.js', templateKeys);
fs.writeFileSync('./backend/secrets/index.js', templateSecretsIndex);
fs.writeFileSync('./backend/secrets/rsa_private.pem', templatePrivateKey);
fs.writeFileSync('./backend/secrets/rsa_public.pem', templatePublicKey);
fs.writeFileSync('./segunda_aplicacao/backend/secrets/databaseConfiguration.js', templateDatabaseConfig);
fs.writeFileSync('./segunda_aplicacao/backend/secrets/keys.js', templateKeys);
fs.writeFileSync('./segunda_aplicacao/backend/secrets/index.js', templateSecretsIndex);
fs.writeFileSync('./segunda_aplicacao/backend/secrets/rsa_private.pem', templatePrivateKey);
fs.writeFileSync('./segunda_aplicacao/backend/secrets/rsa_public.pem', templatePublicKey);
