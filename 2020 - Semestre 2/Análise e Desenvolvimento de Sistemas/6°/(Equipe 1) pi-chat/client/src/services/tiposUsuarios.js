import http from './http'

function pegarTiposUsuarios () {
  return http.get('tipoUsuario')
}

export default {
  pegarTiposUsuarios
}
