<template>
  <v-container fluid>
      <v-row
        no-gutters
      >
          <v-col
            cols="3"
          >
            <v-card flat>
              <v-card-title class="bluePi--text">
                Conversas
                <v-spacer></v-spacer>
                <Button
                  icon
                  @click="modalConversa = true"
                >
                  <v-icon>mdi-plus</v-icon>
                </Button>
              </v-card-title>
            </v-card>
            <v-list
            two-line
            class="overflow-y-auto"
            :max-height="windowSize"
            >
            <v-list-item
              v-for="(item,key) in items"
              :key="key"
              @click="trocaConversa(item)"
            >
              <v-list-item-content>
                  <v-list-item-title>
                    <span class="heading-6">{{item.author}}</span>
                  </v-list-item-title>
                  <v-list-item-subtitle class="body-2">
                    <span class="indigo--text text--darken-2">{{item.role}}</span>
                  </v-list-item-subtitle>
                </v-list-item-content>
                <v-list-item-action class="body-2">
                  {{item.date}}
                </v-list-item-action>
            </v-list-item>
          </v-list>
          </v-col>
          <v-col
            cols="9"
            v-if="idConversa"
          >
            <MessageHeader :title="destinatario"/>
            <v-container>
              <v-row
                no-gutters
                align="center"
                justify="center"
              >
                <v-col
                  cols="12"
                >
                  <v-card
                    class="overflow-y-auto"
                    :max-height="maxChatListSize"
                    :min-height="minChatListSize"
                    color="transparent"
                    flat
                  >
                    <MessageCard
                      v-for="item in messageList"
                      :author="item.author"
                      :date="item.date"
                      :content="item.content"
                      :key="item.id"
                    />
                  </v-card>
                </v-col>
                <v-col cols="10">
                  <TextArea
                    label="digite aqui sua mensagem"
                    v-model="message"
                  />
                </v-col>
                <v-col cols="2">
                  <Button @click="sendMsg"> Enviar </Button>
                </v-col>
              </v-row>
            </v-container>
          </v-col>
          <v-col
            cols="9"
            v-else
          >
            <div class="d-flex flex-column justify-space-between align-center">
              <span
                class="bluePi--text headline"
              >
                Selecione um contato e troque mensagems
              </span>
            </div>
          </v-col>
          <v-dialog
          v-model="modalConversa"
        >
          <v-card>
            <v-toolbar
                dark
                color="bluePi">
                <v-btn
                  icon
                  dark
                  @click="modalConversa = false">
                  <v-icon>mdi-close</v-icon>
                </v-btn>
                <v-toolbar-title>Conversar Com</v-toolbar-title>
                <v-spacer></v-spacer>
                <v-toolbar-items>
                  <v-btn
                    dark
                    text
                    @click="criarConversa"
                  >
                    Iniciar Conversa
                  </v-btn>
                </v-toolbar-items>
              </v-toolbar>
          <ShareCard
            @selectUser="pegarUsuarios($event)"
          />
          </v-card>
        </v-dialog>
      </v-row>
  </v-container>
</template>

<script>
import MessageCard from '../../components/MessageCard/MessageCard.vue'
import MessageHeader from '../../components/MessageHeader/MessageHeader.vue'
import TextArea from '../../components/TextArea/TextArea.vue'
import Button from '../../components/Button/Button.vue'
import ShareCard from '../../components/ShareCard/ShareCard.vue'
import api from '../../services/api'
import { mapGetters } from 'vuex'
import SockJS from 'sockjs-client'
import Stomp from 'webstomp-client'

export default {
  components: {
    MessageCard,
    MessageHeader,
    TextArea,
    Button,
    ShareCard
  },
  data: () => ({
    items: [],
    message: '',
    messageList: [],
    idConversa: 0,
    modalConversa: false,
    destinatario: '',
    idUsuarios: [],
    stompClient: null,
    messages: [],
    url_socket: process.env.VUE_APP_URL_GITPOD + 'spring-app/chat'
  }),
  computed: {
    maxChatListSize: function () {
      return window.innerHeight * 0.7
    },
    minChatListSize: function () {
      return window.innerHeight * 0.7
    },
    windowSize: function () {
      return window.innerHeight * 0.8
    },
    ...mapGetters([
      'getUsuario',
      'getToken'
    ])
  },
  mounted () {
    this.pegarConversasUsuario()
  },
  beforeDestroy () {
    this.disconnect()
  },
  methods: {
    connect () {
      var socket = new SockJS(this.url_socket)
      this.stompClient = Stomp.over(socket)
      const that = this
      this.stompClient.connect(
        { Authorization: 'Bearer ' + this.getToken },
        function (frame) {
          that.stompClient.subscribe('/topic/message/' + that.idConversa, function (response) {
            const data = JSON.parse(response.body)
            that.messageList.push({
              id: data.idMensagem,
              author: data.nomeUsuario,
              date: data.dataCriado.substring(0, 10),
              content: data.conteudoMsg
            })
          })
        })
    },
    sendMsg () {
      this.stompClient.send('/app/conversa/' + this.idConversa, JSON.stringify({
        conteudoMsg: this.message,
        idUsuario: this.getUsuario.idUsuario,
        idConversa: this.idConversa
      }), { Authorization: 'Bearer ' + this.getToken })
      this.message = ''
    },
    disconnect () {
      if (this.stompClient != null) {
        this.stompClient.disconnect()
      }
    },
    trocaConversa (conversa) {
      this.disconnect()
      this.connect()
      this.idConversa = conversa.idConversa
      this.destinatario = conversa.author
      this.messageList = []
      this.pegarMensagensConversa()
    },
    addmessage () {
      api.mensagem.enviarMensagem(this.message, this.getUsuario.idUsuario, this.idConversa)
        .then(() => {
          this.message = ''
          this.pegarMensagensConversa()
        })
        .catch(err => console.log(err))
    },
    pegarMensagensConversa () {
      api.mensagem.pegarMensagensConversa(this.idConversa)
        .then(res => {
          const mensagens = res.data.map(mensagem => {
            return {
              id: mensagem.idMensagem,
              author: mensagem.usuarios.nomeUsuario,
              date: mensagem.dataCriado.substring(0, 10),
              content: mensagem.conteudoMsg
            }
          })
          this.messageList = mensagens
        })
        .catch(err => console.log(err))
    },
    pegarConversasUsuario () {
      api.conversa.pegarConversasUsuario(this.getUsuario.idUsuario)
        .then(res => {
          const conversas = res.data.map(conversa => {
            const author = conversa.usuarios[0].nomeUsuario === this.getUsuario.nomeUsuario ? conversa.usuarios[1].nomeUsuario : conversa.usuarios[0].nomeUsuario
            return {
              idConversa: conversa.idConversa,
              author: author,
              date: conversa.dataInicial.substring(0, 10),
              role: conversa.usuarios[0].tiposUsuarios.nome.substring(5)
            }
          })
          this.items = conversas
        })
        .catch(err => console.log(err))
    },
    pegarUsuarios (listaIdUsuarios) {
      this.idUsuarios = listaIdUsuarios
    },
    criarConversa () {
      this.modalConversa = false
      api.conversa.criarConversa([this.getUsuario.idUsuario, ...this.idUsuarios])
        .then(() => {
          this.pegarConversasUsuario()
        })
        .catch(err => console.log(err))
    }
  }
}
</script>

<style scoped>

</style>
