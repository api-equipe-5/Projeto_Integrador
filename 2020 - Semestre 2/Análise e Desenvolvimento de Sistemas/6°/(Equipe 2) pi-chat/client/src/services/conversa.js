import http from './http'

function pegarConversasUsuario (idUsuario) {
  return http.get(`conversa/${idUsuario}`)
}

function criarConversa (listaUsuarios) {
  return http.post('conversa', {
    idUsuarios: listaUsuarios
  })
}

export default {
  pegarConversasUsuario,
  criarConversa
}
