import http from './http'

function pegarAtividades (idUsuario) {
  return http.get(`atividade/open/usuario/${idUsuario}`)
}

function enviarAtividades (descricaoAtividade, tituloAtividade, corAtividade, idUsuarios, dataPrevista) {
  return http.post('atividade', {
    descricaoAtividade,
    tituloAtividade,
    corAtividade,
    idUsuarios,
    dataPrevista,
    atividadeAberta: true
  })
}

function pegarAtividadesFechadas (idUsuarios) {
  return http.get(`atividade/close/usuario/${idUsuarios}`)
}

function fecharAtividades (idAtividade) {
  return http.put(`atividade/${idAtividade}`)
}

export default { pegarAtividades, enviarAtividades, pegarAtividadesFechadas, fecharAtividades }
