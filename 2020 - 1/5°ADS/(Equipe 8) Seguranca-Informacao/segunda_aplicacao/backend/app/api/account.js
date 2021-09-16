const { Router } = require('express');
const AccountTable = require('../account/table');
const AccountDeviceTable = require('../accountDevice/table');
const { hash } = require('../account/helper');
const { authenticatedAccount } = require('./helper');
const DeviceTable = require('../device/table')
const Device = require('../device/index')
const PortDataTable = require('../portData/table');
const { encryptClientData } = require('../../bin/cryptography/criptography');
const router = new Router();
const axios = require('axios');
const fs = require('fs');
const path = require('path');
const rsaWrapper = require('../../bin/cryptography/rsa-wrapper');
const aesWrapper = require('../../bin/cryptography/aes-wrapper');

router.get('/logout', authenticatedAccount, (req, res, next) => {
  req.logout();
  res.json({ message: 'Logout successful' });
});

router.get('/authenticated', (req, res, next) => {
  if (!req.user) {
    res.json({});
  } else {
    res.json({ authenticated: true });
  }
});

router.get('/devices', authenticatedAccount, (req, res, next) => {
  AccountDeviceTable.getAccountDevices({
      accountId: req.user.id
  })
  .then(({ accountDevices }) => {
    return Promise.all(
      accountDevices.map(accountDevice => {
        return DeviceTable.getDevice({ deviceId: accountDevice.deviceId });
      })
    );
  })
  .then(devices => {
    res.json({ devices });
  })
  .catch(error => next(error));
});

router.get('/info', authenticatedAccount, (req, res, next) => {
  res.json({ info: req.user });
});

router.post('/portDataRequest', (req, res, next) => {
  const { clientPublicKey, userId } = req.body;
  AccountTable.getAccount( userId )
  .then((account) => {
      if (account == undefined) {
        res.json({ message: 'User not registered'});
      }
      else {
        AccountDeviceTable.getAccountDevices({
          accountId: account.id
        })
        .then(({ accountDevices }) => {
          return Promise.all(
            accountDevices.map(accountDevice => {
              return DeviceTable.getPortDevice({ deviceId: accountDevice.deviceId });
            })
          );
        })
        .then(devices => {
          let encryptedData = encryptClientData(clientPublicKey, JSON.stringify(devices));
          PortDataTable.storePortData({
            accountId: account.id
          })
          res.json(encryptedData);
        })
      }
  })
  .catch(error => next(error));
});

router.post('/portDataOk', (req, res, next) => {
  const { userId } = req.body;
  AccountTable.getAccount( userId )
  .then((account) => {
    if(account == undefined){
      res.json({ message: 'User not registered'});
    }
    else{
      PortDataTable.getPortData({ 
        accountId: account.id 
      })
      .then(({ portData }) => {
        if (portData == undefined){
          const error = new Error('Portability not requested');
          error.statusCode = 400;
          throw error;
        }
        else{
          return AccountDeviceTable.getAccountDevices({
            accountId: account.id
          })
          .then(({ accountDevices }) => {
            accountDevices.map(accountDevice => {
              return DeviceTable.deleteDevice({ deviceId: accountDevice.deviceId });
            })
            PortDataTable.deletePortData(account.id)
            res.json({ message: 'Successful data port' });
          }) 
        }
      })
    }
  })
  .catch(error => next(error));
});

router.post('/requestPortData', authenticatedAccount, (req, res, next) => {
  const { appURL, id } = req.body;
  let decryptedData, device, accountId; 
  accountId = req.user.id;
  let key = fs.readFileSync(path.resolve(__dirname, '../../secrets/rsa_public.pem')).toString();
  axios.post(appURL+'/account/portDataRequest', {
    clientPublicKey: key,
    userId: id
  })
  .then((response) => {
    const {encryptedData, encryptedAesKey} = response.data;
    const decryptedKey = rsaWrapper.decrypt(encryptedAesKey);
    decryptedData = aesWrapper.decrypt(Buffer.from(decryptedKey, 'base64'), encryptedData);
    JSON.parse(decryptedData).forEach((portedDevice) => {
      let macAddress = portedDevice.macAddress;
      let nickname = portedDevice.nickname;
      device = new Device({ macAddress, nickname});
      DeviceTable.storeDevice(device)
      .then(({ deviceId }) => {
        device.deviceId = deviceId;
        AccountDeviceTable.storeAccountDevice({ accountId, deviceId});
      })
    });
    return axios.post(appURL+'/account/portDataOk', {
      userId: id
    })
    .then((response) => {
      if ( response.status == 200 ) {
        res.json({ message: 'Data ported successfully' });
      }
      else{
        res.json({ message: 'Error' });
      }
    })
  })
  .catch((error) => next(error));
});

module.exports = router;