import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:5000',
});

export const api_crud = axios.create({
  baseURL: 'http://localhost:3333',
});

export default api;
