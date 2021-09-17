const pool = require('../../databasePool');

class DeviceTable {
    static storeDevice(device) {
        const { macAddress, nickname, status } = device;

        return new Promise((resolve, reject) => {
            pool.query(
                `INSERT INTO device_tbl("macAddress", nickname, status) 
                 VALUES($1, $2, $3)
                 RETURNING id`,
                 [macAddress, nickname, status],
                 (error, response) => {
                    if(error) return reject(error);

                    const deviceId = response.rows[0].id;

                    resolve({ deviceId });
                }
            )
        });
    }

    static getDevice({ deviceId }) {
        return new Promise((resolve, reject)=> {
            pool.query(
                `SELECT id, "macAddress", nickname, status
                 FROM device_tbl
                 WHERE device_tbl.id = $1`,
                 [deviceId],
                 (error, response) => {
                     if (error) return reject(error);

                     if (response.rows.length === 0) return reject(new Error('no device'));
                     resolve(response.rows[0]);
                 }
            )
        });
    }

    static getPortDevice({ deviceId }) {
        return new Promise((resolve, reject)=> {
            pool.query(
                `SELECT "macAddress", nickname
                 FROM device_tbl
                 WHERE device_tbl.id = $1`,
                 [deviceId],
                 (error, response) => {
                     if (error) return reject(error);

                     if (response.rows.length === 0) return reject(new Error('no device'));
                     resolve(response.rows[0]);
                 }
            )
        });
    }

    static updateDevice({ deviceId, macAddress, nickname, status }) { 
        const settingsMap = { macAddress, nickname, status };
    
        const validQueries = Object.entries(settingsMap).filter(([settingKey, settingValue]) => {
          if (settingValue !== undefined) {
            return new Promise((resolve, reject) => {
              pool.query(
                `UPDATE device_tbl SET "${settingKey}" = $1 WHERE id = $2`,
                [settingValue, deviceId],
                (error, response) => {
                  if (error) return reject(error);
    
                  resolve();
                }
              )
            });
          }
        });
        return Promise.all(validQueries);
    }

    static deleteDevice({ deviceId }) {
        return new Promise((resolve, reject)=> {
            pool.query(
                `DELETE FROM device_tbl
                 WHERE device_tbl.id = $1`,
                 [deviceId],
                 (error, response) => {
                     if (error) return reject(error);

                     resolve();
                 }
            )
        });
    }
}

module.exports = DeviceTable;