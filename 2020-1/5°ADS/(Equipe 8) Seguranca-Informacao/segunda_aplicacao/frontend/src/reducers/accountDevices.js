import { ACCOUNT_DEVICES } from '../actions/types';
import fetchStates from './fetchStates';

const DEFAULT_ACCOUNT_DEVICES = { devices: [] };

const accountDevices = (state = DEFAULT_ACCOUNT_DEVICES, action) => {
  switch(action.type) {
    case ACCOUNT_DEVICES.FETCH:
      return { ...state, status: fetchStates.fetching };
      break;
    case ACCOUNT_DEVICES.FETCH_ERROR:
      return { ...state, status: fetchStates.error, message: action.message };
      break;
    case ACCOUNT_DEVICES.FETCH_SUCCESS:
      return {
        ...state,
        status: fetchStates.success,
        message: action.message,
        devices: action.devices
      };
      break;
    default:
      return state;
  }
}

export default accountDevices;