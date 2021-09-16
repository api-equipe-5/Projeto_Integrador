const DEFAULT_PROPERTIES = {
    measurementId: undefined,
    measurementData: "",
    deviceId: undefined,
    get measurementDate() {
        return new Date();
    }
}

class Measurement {
    constructor({ measurementId, measurementDate, measurementData, deviceId} = {}) {
        this.measurementId = measurementId || DEFAULT_PROPERTIES.measurementId;
        this.measurementDate = measurementDate || DEFAULT_PROPERTIES.measurementDate;
        this.measurementData = measurementData || DEFAULT_PROPERTIES.measurementData;
        this.deviceId = deviceId || DEFAULT_PROPERTIES.deviceId;
    }
}

module.exports = Measurement;