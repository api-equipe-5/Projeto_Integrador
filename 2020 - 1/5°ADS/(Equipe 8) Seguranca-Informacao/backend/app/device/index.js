const DEFAULT_PROPERTIES = {
    deviceId: undefined,
    macAddress: "FFFFFFFFFFFF",
    nickname: "unnamed",
    status: 0,
}

class Device {
    constructor({ deviceId, macAddress, nickname, status } = {}) {
        this.deviceId = deviceId || DEFAULT_PROPERTIES.deviceId;
        this.macAddress = macAddress || DEFAULT_PROPERTIES.macAddress;
        this.nickname = nickname || DEFAULT_PROPERTIES.nickname;
        this.status = status || DEFAULT_PROPERTIES.status;
    }
}

module.exports = Device;