const sqlite3 = require('sqlite3').verbose();
const db = new sqlite3.Database('db/AppDB.db', sqlite3.OPEN_READWRITE, (err) => {
    if (err) {
        console.error(err.message);
    }
});

const selectPromise = (select) => {
    return new Promise((resolve, reject) => {
        db.all(select,(err, row) => {
          if (err) {
            return reject(err);
          }
          resolve(row);
        }); 
    })
}

module.exports = selectPromise;