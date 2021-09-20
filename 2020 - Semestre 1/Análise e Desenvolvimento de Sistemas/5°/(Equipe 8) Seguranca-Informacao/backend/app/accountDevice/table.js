const pool = require('../../databasePool');

class AccountDeviceTable {
  static storeAccountDevice({ accountId, deviceId }) {
    return new Promise((resolve, reject) => {
      pool.query(
        'INSERT INTO accountDevice_tbl("accountId", "deviceId") VALUES($1, $2)',
        [accountId, deviceId],
        (error, response) => {
          if (error) return reject(error);

          resolve();
        }
      )
    });
  }

  static getAccountDevices({ accountId }) {
    return new Promise((resolve, reject) => {
      pool.query(
        'SELECT "deviceId" FROM accountDevice_tbl WHERE "accountId" = $1',
        [accountId],
        (error, response) => {
          if (error) return reject(error);

          resolve({ accountDevices: response.rows });
        }
      )
    })
  }

  static getAccountDevicesForPort({ accountUserId }) {
    return new Promise((resolve, reject) => {
      pool.query(
        'SELECT "deviceId" FROM accountDevice_tbl WHERE "accountId" IN (SELECT id FROM account_tbl where "userId" = $1)',
        [accountUserId],
        (error, response) => {
          if (error) return reject(error);
          resolve({ accountDevices: response.rows });
        }
      )
    })
  }

  static getDeviceAccount({ deviceId }) {
    return new Promise((resolve, reject) => {
      pool.query(
        'SELECT "accountId" FROM accountDevice_tbl WHERE "deviceId" = $1',
        [deviceId],
        (error, response) => {
          if (error) return reject(error);

          resolve({ accountId: response.rows[0].accountId });
        }
      )
    });
  };

  static updateAccountDevice({ deviceId, accountId }) {
    return new Promise((resolve, reject) => {
      pool.query(
        'UPDATE accountDevice_tbl SET "accountId" = $1 WHERE "deviceId" = $2',
        [accountId, deviceId],
        (error, response) => {
          if (error) return reject(error);

          resolve();
        }
      )
    });
  }
}

module.exports = AccountDeviceTable;