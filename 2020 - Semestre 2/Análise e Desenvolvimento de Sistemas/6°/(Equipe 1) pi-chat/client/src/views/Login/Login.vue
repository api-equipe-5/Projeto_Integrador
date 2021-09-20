<template>
  <v-container fluid>
    <v-row
      align="center"
      justify="center"
    >
      <v-col
        cols="8"
      >
        <div class="d-flex flex-column justify-space-between align-center">
          <v-img
            :aspect-ratio="16/9"
            src="../../assets/logo_teste.png"
            width="250"
          ></v-img>
        </div>
        <v-card color="transparent" flat>
          <p class="text-center bluePi--text headline font-weight-bold">Entrar</p>
          <v-row justify="center">
            <v-col cols="8">
              <Input
                label="CPF"
                v-model="cpf"
              />
            </v-col>
            <v-col cols="8">
              <Input
                label="Senha"
                type="password"
                v-model="senha"
              />
            </v-col>
            <v-col cols="8">
              <div class="d-flex flex-column">
                <Button @click="logar">
                  Entrar
                </Button>
              </div>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Input from '../../components/Input/Input.vue'
import Button from '../../components/Button/Button.vue'
import api from '../../services/api'
import { mapMutations } from 'vuex'

export default {
  name: 'Login',
  data () {
    return {
      cpf: '',
      senha: ''
    }
  },
  components: {
    Input,
    Button
  },
  methods: {
    logar () {
      api.auth.autenticar(this.cpf, this.senha)
        .then(res => {
          this.setToken(res.data.token)
          this.setIdUsuario(res.data.idUsuario)
          this.$store.dispatch('getUserData', {
            cpf: res.data.document
          })
          this.$router.replace('chat')
        })
        .catch(err => console.log(err))
    },
    ...mapMutations([
      'setToken',
      'setIdUsuario'
    ])
  }
}
</script>

<style scoped>

</style>
