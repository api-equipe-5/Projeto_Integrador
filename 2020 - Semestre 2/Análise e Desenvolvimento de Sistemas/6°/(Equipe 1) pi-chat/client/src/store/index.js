import Vue from 'vue'
import Vuex from 'vuex'
import VuexPersist from 'vuex-persist'
import api from '@/services/api'

Vue.use(Vuex)

const vuexPersist = new VuexPersist({
  key: 'porps-app',
  storage: localStorage
})

export default new Vuex.Store({
  plugins: [
    vuexPersist.plugin
  ],
  state: {
    token: null,
    usuario: {},
    request: {
      loading: false,
      mensagem: '',
      cor: '',
      snackbar: ''
    }
  },
  mutations: {
    setUsuario (state, usuario) {
      state.usuario = usuario
    },
    setToken (state, token) {
      state.token = token
    },
    setIdUsuario (state, idUsuario) {
      state.usuario.idUsuario = idUsuario
    },
    logout (state) {
      state.token = null
      state.usuario = {}
    },
    beforeRequest (state) {
      state.request.loading = true
    },
    afterRequest (state, payload) {
      state.request.loading = false
      state.request.mensagem = payload.mensagem
      state.request.cor = payload.cor
      state.request.snackbar = true
    },
    closeSnackbar (state) {
      state.request.snackbar = false
    }
  },
  getters: {
    getToken (state) {
      return state.token
    },
    getUsuario (state) {
      return state.usuario
    },
    getRequest (state) {
      return state.request
    }
  },
  actions: {
    getUserData (context, payload) {
      api.usuario.buscarUsuarioPorCPF(payload.cpf)
        .then(res => {
          context.commit('setUsuario', res.data)
        })
        .catch((err) => {
          console.log(err)
        })
    }
  },
  modules: {
  }
})
