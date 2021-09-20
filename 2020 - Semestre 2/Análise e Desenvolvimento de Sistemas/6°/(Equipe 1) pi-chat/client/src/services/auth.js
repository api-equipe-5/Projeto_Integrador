import http from './http'

function autenticar (documento, senha) {
  return http.post('/login', {
    document: documento,
    password: senha
  })
}

export default {
  autenticar
}
