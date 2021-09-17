const pool = require('../../databasePool');
const { response } = require('..');

class AccountTable {
  static storeAccount({ userId, username }) {
    return new Promise((resolve, reject) => {
      pool.query(
        `INSERT INTO account_tbl("userId", username)
         VALUES($1, $2) RETURNING *`,
        [userId, username],
        (error, response) => {
          if (error) return reject(error);
          resolve(response.rows[0]);
        }
      );
    });
  }

  static getAccount( userId ) {
    return new Promise((resolve, reject) => {
      pool.query(
        `SELECT * FROM account_tbl
         WHERE "userId" = $1`,
        [userId],
        (error, response) => {
          if (error) return reject(error);

          resolve(response.rows[0]);
        }
      )
    });
  }
}

module.exports = AccountTable;
