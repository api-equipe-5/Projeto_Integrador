import { ACCOUNT_DEVICES } from './types';
import { fetchFromAccount } from './account';

export const fetchAccountDevices = () => fetchFromAccount({
  endpoint: 'devices',
  options: { credentials: 'include' },
  FETCH_TYPE: ACCOUNT_DEVICES.FETCH,
  ERROR_TYPE: ACCOUNT_DEVICES.FETCH_ERROR,
  SUCCESS_TYPE: ACCOUNT_DEVICES.FETCH_SUCCESS
});