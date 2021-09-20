const { Router } = require('express');
const Device = require('../device/index');
const DeviceTable = require('../device/table');
const AccountDeviceTable = require('../accountDevice/table');
const AccountTable = require('../account/table');
const { authenticatedAccount } = require('./helper');

const router = new Router();

router.post('/new', authenticatedAccount, (req, res, next) => {
  let accountId, device;
  const { macAddress, nickname } = req.body;
  accountId = req.user.id;
  device = new Device({ macAddress, nickname });
  return DeviceTable.storeDevice(device)
  .then(({ deviceId }) => {
    device.deviceId = deviceId;
    return AccountDeviceTable.storeAccountDevice({ accountId, deviceId });
  })
  .then(() => res.json({ device }))
  .catch(error => next(error));
});

router.put('/update', (req, res, next) => {
  const { deviceId, macAddress, nickname, status } = req.body;
  DeviceTable.updateDevice({ deviceId, macAddress, nickname, status })
    .then(() => res.json({ message: 'successfully updated device' }))
    .catch(error => next(error));
});

router.put('/delete', (req, res, next) => {
    const { deviceId } = req.body;
  
    DeviceTable.deleteDevice({ deviceId })
      .then(() => res.json({ message: 'successfully deleted device' }))
      .catch(error => next(error));
});

module.exports = router;
