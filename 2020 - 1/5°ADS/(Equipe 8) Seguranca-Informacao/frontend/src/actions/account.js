import { ACCOUNT } from './types';
import { BACKEND, SECOND_APP } from '../config';

export const fetchFromAccount = ({
  endpoint,
  options,
  FETCH_TYPE,
  ERROR_TYPE,
  SUCCESS_TYPE
}) => dispatch => {
  dispatch({ type: FETCH_TYPE });

  return fetch(`${BACKEND.ADDRESS}/account/${endpoint}`, options)
    .then(response => response.json())
    .then(json => {
      if (json.type === 'error') {
        dispatch({ type: ERROR_TYPE, message: json.message });
      } else {
        dispatch({ type: SUCCESS_TYPE, ...json });
      }
    })
    .catch(error => dispatch({
      type: ERROR_TYPE, message: error.message
    }));
}

export const login = () => {
  window.location = `${BACKEND.ADDRESS}/auth/google`;
}

export const logout = () => fetchFromAccount({
  endpoint: 'logout',
  options: { credentials: 'include' },
  FETCH_TYPE: ACCOUNT.FETCH,
  ERROR_TYPE: ACCOUNT.FETCH_ERROR,
  SUCCESS_TYPE: ACCOUNT.FETCH_LOGOUT_SUCCESS
});

export const fetchAuthenticated = () => fetchFromAccount({
  endpoint: 'authenticated',
  options: { credentials: 'include' },
  FETCH_TYPE: ACCOUNT.FETCH,
  ERROR_TYPE: ACCOUNT.FETCH_ERROR,
  SUCCESS_TYPE: ACCOUNT.FETCH_AUTHENTICATED_SUCCESS
});