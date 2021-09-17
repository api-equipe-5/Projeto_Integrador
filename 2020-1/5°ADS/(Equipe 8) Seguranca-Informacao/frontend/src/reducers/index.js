import { combineReducers } from 'redux';
import device from './device';
import account from './account';
import accountDevices from './accountDevices';
import accountInfo from './accountInfo';

export default combineReducers({
  account,
  device,
  accountDevices,
  accountInfo
});