const sqlite3 = require('sqlite3').verbose();
const db = new sqlite3.Database('db/AppDB.db', sqlite3.OPEN_READWRITE, (err) => {
    if (err) {
        console.error(err.message);
    }
});

const insertPromise = (insert) => {
    return new Promise((resolve, reject) => {
        db.run(insert,(err) => {
          if (err) {
            return reject(err);
          }
          return resolve();
        }); 
    })
}

module.exports = insertPromise;