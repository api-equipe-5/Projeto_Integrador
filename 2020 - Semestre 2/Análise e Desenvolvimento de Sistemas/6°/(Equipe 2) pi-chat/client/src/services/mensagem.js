import http from './http'

function enviarMensagem (conteudoMsg, idUsuario, idConversa) {
  const dadosMensagens = {
    conteudoMsg,
    idUsuario,
    idConversa
  }
  return http.post('mensagem', dadosMensagens)
}

function pegarMensagensConversa (idConversa) {
  return http.get(`mensagem/conversa/${idConversa}`)
}

export default {
  enviarMensagem,
  pegarMensagensConversa
}
