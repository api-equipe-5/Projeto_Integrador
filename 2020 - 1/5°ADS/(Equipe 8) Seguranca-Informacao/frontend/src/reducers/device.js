import { DEVICE } from '../actions/types';
import fetchStates from './fetchStates';

const DEFAULT_DEVICE = {
  deviceId: '',
  nickname: '',
  birthdate: '',
  status: 0
};

const device = (state = DEFAULT_DEVICE, action) => {
  switch(action.type) {
    case DEVICE.FETCH:
      return { ...state, status: fetchStates.fetching };
    case DEVICE.FETCH_ERROR:
      return { ...state, status: fetchStates.error, message: action.message };
    case DEVICE.FETCH_SUCCESS:
      return { ...state, status: fetchStates.success, ...action.device };
    default:
      return state;
  };
};

export default device;