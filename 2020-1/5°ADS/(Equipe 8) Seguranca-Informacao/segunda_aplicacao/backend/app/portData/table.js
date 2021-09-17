const pool = require('../../databasePool');

class PortDataTable {
  static storePortData({ accountId }) {
    return new Promise((resolve, reject) => {
      pool.query(
        'INSERT INTO portData_tbl("accountId") VALUES($1)',
        [accountId],
        (error, response) => {
          if (error) return reject(error);

          resolve();
        }
      )
    });
  }

  static getPortData({ accountId }) {
    return new Promise((resolve, reject) => {
      pool.query(
        'SELECT id FROM portData_tbl WHERE "accountId" = $1',
        [accountId],
        (error, response) => {
          if (error) return reject(error);

          resolve({ portData: response.rows[0] });
        }
      )
    })
  }

  static deletePortData({ accountId }) {
    return new Promise((resolve, reject)=> {
        pool.query(
            `DELETE FROM portData_tbl
             WHERE portData_tbl."accountId" = $1`,
             [accountId],
             (error, response) => {
                 if (error) return reject(error);

                 resolve();
             }
        )
    });
}
}

module.exports = PortDataTable;