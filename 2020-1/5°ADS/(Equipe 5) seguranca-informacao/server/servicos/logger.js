let winston = require('winston');
const sqlite3 = require('sqlite3').verbose();
const crypto = require('crypto');
const insertPromise = require('../servicos/insert');
const EventLogger = require('eventlogger');

const db = new sqlite3.Database('db/AppDB.db', sqlite3.OPEN_READWRITE, (err) => {
    if (err) {
        console.error(err.message);
    }
});

async function sendLog(level, message, nameFile, cod_comunicado) {
    let logger = winston.createLogger({
        level: level,
        format: winston.format.combine(
            winston.format.timestamp({format: 'YYYY-MM-DD HH:mm:ss'}),
            winston.format.printf(info => {
                return `${info.timestamp} ${info.level}: ${info.message}`;
            })
        ),
        transports: [
            new winston.transports.Console(),
            new winston.transports.File({filename: './logs/'+nameFile+'.log'})
        ]
    });

    var hash_arquivo = crypto.randomBytes(10).toString('HEX')

    logger.log(level, message);

    await insertPromise('INSERT INTO log (cod_comunicado, nome_arquivo, hash_arquivo) ' +
    'values ('+cod_comunicado + ',"' +nameFile + '","' +hash_arquivo+'")');

    const log = new EventLogger(nameFile);
    
    log.success(message);
}

function sendLogDPO(level, message, nameFile) {
    let logger = winston.createLogger({
        level: level,
        format: winston.format.combine(
            winston.format.timestamp({format: 'YYYY-MM-DD HH:mm:ss'}),
            winston.format.printf(info => {
                return `${info.timestamp} ${info.level}: ${info.message}`;
            })
        ),
        transports: [
            new winston.transports.Console(),
            new winston.transports.File({filename: './logs/'+nameFile+'.log'})
        ]
    });

    var hash_arquivo = crypto.randomBytes(10).toString('HEX')

    logger.log(level, message);

    const log = new EventLogger(nameFile);
    
    log.success(message);   
}

module.exports = {
    sendLog,
    sendLogDPO
}


/* { 
    emerg: 0, 
    alert: 1, 
    crit: 2, 
    error: 3, 
    warning: 4, 
    notice: 5, 
    info: 6, 
    debug: 7
  } */