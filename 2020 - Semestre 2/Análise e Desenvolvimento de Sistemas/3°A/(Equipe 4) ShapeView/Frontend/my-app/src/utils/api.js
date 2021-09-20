import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:5000',
  headers: {
    contentType: 'application/json; charset=utf-8'
  },
  xhrFields: {
    withCredentials: true
  },
  crossDomain: true,
});

export default api;