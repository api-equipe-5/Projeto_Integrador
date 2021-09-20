import http from './http'

function buscarUsuarioPorCPF (cpf) {
  return http.get(`/usuario/cpf/${cpf}`)
}

function buscarUsuarios () {
  return http.get('usuario')
}

export default {
  buscarUsuarioPorCPF,
  buscarUsuarios
}
