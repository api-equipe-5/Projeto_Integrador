import { DEVICE } from './types';
import { BACKEND } from '../config';

export const fetchDevice = (macAddress, nickname) => dispatch => {
  dispatch({ type: DEVICE.FETCH });

  return fetch(`${BACKEND.ADDRESS}/device/new`, {
    method: 'POST',
    body: JSON.stringify({
      macAddress: macAddress,
      nickname: nickname,
    }),
    headers: { 'Content-Type': 'application/json' },
    credentials: 'include'
  }).then(response => response.json())
    .then(json => {
      if (json.type === 'error') {
        dispatch({ type: DEVICE.FETCH_ERROR, message: json.message });
      } else {
        dispatch({ type: DEVICE.FETCH_SUCCESS, message: json.device });
      }
    })
    .catch(error => dispatch({ type: DEVICE.FETCH_ERROR, message: error.message }));
};