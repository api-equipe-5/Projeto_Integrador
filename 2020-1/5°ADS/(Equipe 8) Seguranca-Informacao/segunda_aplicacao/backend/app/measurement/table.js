const pool = require('../../databasePool');

class MeasurementTable {
    static storeMeasurement(measurement) {
        const { measurementDate, measurementData, deviceId } = measurement;

        return new Promise((resolve, reject) => {
            pool.query(
                `INSERT INTO measurement_tbl("measurementDate", "measurementData", "deviceId") 
                 VALUES($1, $2, $3)
                 RETURNING id`,
                 [measurementDate, measurementData, deviceId],
                 (error, response) => {
                    if(error) return reject(error);

                    const measurementId = response.rows[0].id;

                    resolve({ measurementId });
                }
            )
        });
    }

    static getMeasurement({ measurementId }) {
        return new Promise((resolve, reject)=> {
            pool.query(
                `SELECT "measurementDate", "measurementData", "deviceId"
                 FROM measurement_tbl
                 WHERE measurement_tbl.id = $1`,
                 [measurementId],
                 (error, response) => {
                     if (error) return reject(error);

                     if (response.rows.length === 0) return reject(new Error('no measurement'));
                     resolve(response.rows[0]);
                 }
            )
        });
    }
}

module.exports = MeasurementTable;