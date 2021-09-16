import axios from 'axios'

const api = 'http://localhost:8020/'

const http = axios.create({
  baseURL: api
})

export default http;