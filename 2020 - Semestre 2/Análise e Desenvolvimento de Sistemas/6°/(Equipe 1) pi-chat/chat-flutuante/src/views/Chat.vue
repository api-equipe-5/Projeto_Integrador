<template>
  <v-app>
    <v-card>
    <v-toolbar dense color="#005796">
      <v-toolbar-title class="white--text">PorpsChat</v-toolbar-title>
    </v-toolbar>
    <v-card height="380" flat class="overflow-y-auto overflow-x-hidden">
      <div class="d-flex flex-row ma-2">
        <v-icon large color="red lighten-1">mdi-comment-arrow-right</v-icon>
        <v-card color="#e4e4e4" rounded>
          <span class="pa-1 ma-1">Mussum Ipsum, cacilds vidis litro abertis. Mauris nec dolor in eros commodo tempor.</span>
        </v-card>
      </div>
      <div class="d-flex flex-row ma-2 justify-end" v-for="(msg, index) in conversa" :key="index">
        <v-card color="#e4e4e4" rounded>
          <span class="pa-1 ma-1">{{ msg.conteudo }}</span>
        </v-card>
        <v-icon large color="green lighten-1">mdi-comment-quote</v-icon>
      </div>
    </v-card>
      <div class="d-flex flex-column justify-center ml-1">
        <div class="d-flex flex-row">
          <v-text-field
            label="Mensagem"
            outlined
            v-model="conteudo"
          ></v-text-field>
          <v-btn icon @click="enviarMensagem">
            <v-icon>mdi-send</v-icon>
          </v-btn>
        </div>
      </div>
    </v-card>
  </v-app>
</template>
<script>

export default {
  name: 'Chat',
  components: {
  },
  data () {
    return {
      conversa: [],
      conteudo: ''
    }
  },
  methods: {
    enviarMensagem () {
      this.conversa.push({ conteudo:this.conteudo })
      this.conteudo=''
    }
  }
}
</script>

<style scoped>
</style>
