<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12">
        <v-card>
          <v-card-title class="bluePi--text">
            Arquivos
            <v-spacer></v-spacer>
            <v-text-field
              v-model="search"
              append-icon="mdi-magnify"
              label="Search"
              single-line
              hide-details
            ></v-text-field>
          </v-card-title>
          <v-data-table
            :headers="headers"
            :items="arquivos"
            :search="search"
          ></v-data-table>
        </v-card>
      </v-col>
       <Button
        fab
        right
        bottom
        fixed
        @click="openNewFile()"
        v-if="getUsuario.tiposUsuarios.nome === 'ROLE_ADMIN'"
        >
        <v-icon v-if="buttonNewFile">mdi-close</v-icon>
        <v-icon v-else>mdi-plus</v-icon>
      </Button>
    </v-row>
    <v-dialog
        v-model="buttonNewFile"
        width="70%"
        heigth="50%"
        transition="dialog-bottom-transition"
      >
        <v-card tile>
          <v-row>
            <v-toolbar
              dark
              color="bluePi">
              <v-btn
                icon
                dark
                @click="buttonNewFile = false">
                <v-icon>mdi-close</v-icon>
              </v-btn>
              <v-toolbar-title>Novo Arquivo</v-toolbar-title>
              <v-spacer></v-spacer>
              <v-toolbar-items>
                <v-btn
                  dark
                  text
                  @click="addFile">
                  Salvar
                </v-btn>
              </v-toolbar-items>
            </v-toolbar>
          </v-row>
          <v-card-text>
            <v-row>
                <v-col cols="12">
                  <Input label='Legenda do Arquivo' v-model="file.legenda"/>
                </v-col>
                <v-col cols="12">
                  <v-file-input
                    v-model="file.nomeArquivo"
                    placeholder="Suba seu arquivo"
                    label="Arquivo"
                    prepend-icon="mdi-paperclip"
                  >
                    <template v-slot:selection="{ text }">
                      <v-chip
                        small
                        label
                        color="primary"
                      >
                        {{ text }}
                      </v-chip>
                    </template>
                  </v-file-input>
                </v-col>
                <v-col cols="12">
                  <Button
                    @click="sharedButton = !sharedButton"
                  >
                    Selecionar usuários
                  </Button>
                </v-col>
              </v-row>
          </v-card-text>

        </v-card>
      </v-dialog>
      <v-dialog
        v-model="sharedButton"
      >
        <v-card>
          <v-toolbar
              dark
              color="bluePi">
              <v-btn
                icon
                dark
                @click="sharedButton = false">
                <v-icon>mdi-close</v-icon>
              </v-btn>
              <v-toolbar-title>Enviar para</v-toolbar-title>
              <v-spacer></v-spacer>
              <v-toolbar-items>
                <v-btn
                  dark
                  text
                  @click="addFile">
                  Compartilhar
                </v-btn>
              </v-toolbar-items>
            </v-toolbar>
        <SharedCard @selectUser="pegarUsuarios($event)" />
        </v-card>
      </v-dialog>
  </v-container>
</template>

<script>
import Input from '../../components/Input/Input.vue'
import Button from '../../components/Button/Button.vue'
import SharedCard from '../../components/ShareCard/ShareCard.vue'
import api from '../../services/api'
import { mapGetters } from 'vuex'

export default {
  components: {
    Input,
    Button,
    SharedCard
  },
  data () {
    return {
      search: '',
      buttonNewFile: false,
      sharedButton: false,
      headers: [
        {
          text: 'Nome do Arquivo',
          value: 'nomeArquivo'
        },
        {
          text: 'Legenda',
          sortable: false,
          value: 'legenda'
        },
        {
          text: 'Usuarios',
          sortable: false,
          value: 'usuarios'
        },
        {
          text: 'Data de Criação',
          value: 'dataCriacao'
        }
      ],
      arquivos: [],
      file: {
        legenda: '',
        nomeArquivo: '',
        dataCriacao: ''
      },
      idUsuarios: []
    }
  },
  computed: {
    ...mapGetters([
      'getUsuario'
    ])
  },
  mounted () {
    this.pegarArquivos()
  },
  methods: {
    pegarUsuarios (listaIdUsuarios) {
      this.idUsuarios = listaIdUsuarios
    },
    addFile () {
      let newFile = {}
      newFile = Object.assign(newFile, this.file)
      if (newFile) {
        newFile.nomeArquivo = this.file.nomeArquivo.name
        api.arquivos.enviarArquivo(newFile.nomeArquivo, newFile.legenda, [this.getUsuario.idUsuario, ...this.idUsuarios])
          .then(() => {
            this.buttonNewFile = false
            this.sharedButton = false
            this.clearFile()
            this.pegarArquivos()
          })
          .catch(err => console.log(err))
      }
    },
    clearFile () {
      for (const key in this.file) {
        this.file[key] = null
      }
    },
    openNewFile () {
      this.buttonNewFile = true
    },
    pegarArquivos () {
      api.arquivos.pegarArquivosPorUsuario(this.getUsuario.idUsuario)
        .then(response => {
          const arquivos = response.data.map(arquivo => {
            var usuarios = arquivo.usuarios.reduce((total, usuario, index, arr) => {
              if (index === arr.length - 1) {
                return total + usuario.nomeUsuario
              } else {
                return total + usuario.nomeUsuario + ', '
              }
            }, '')
            return {
              legenda: arquivo.descArquivo,
              nomeArquivo: arquivo.nomeArquivo,
              dataCriacao: arquivo.dataCriado.substring(0, 10),
              usuarios: usuarios
            }
          })
          this.arquivos = arquivos
        })
        .catch(error => console.log(error))
    }
  }
}
</script>

<style scoped>
</style>
