import http from './http'

function pegarArquivosPorUsuario (idUsuario) {
  return http.get(`arquivo/${idUsuario}`)
}

function enviarArquivo (nome, descricao, idUsuarios) {
  return http.post('arquivo', {
    nome,
    descricao,
    idUsuarios

  })
}

export default {
  pegarArquivosPorUsuario,
  enviarArquivo
}
