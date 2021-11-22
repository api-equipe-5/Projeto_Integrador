<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12">
        <v-row>
          <h1 class="bluePi--text">Atividades</h1>
          <v-spacer></v-spacer>
          <span class="blue-grey--text text--lighten-2 text-decoration-underline" @click="mostrarAtividadesFechadas">ver atividades fechadas</span>
        </v-row>
        <v-row>
          <v-col
            v-for="(note, index) in notes"
            :key="index"
            cols="12"
            sm="12"
            md="3"
          >
            <NoteCard :note="note" @click="fecharAtividades(note.id)"/>
          </v-col>
        </v-row>
      </v-col>
      <Button
        fab
        right
        bottom
        fixed
        @click="openNewNote()"
        v-if="getUsuario.tiposUsuarios.nome === 'ROLE_ADMIN'"
        >
        <v-icon v-if="buttonNewNote">mdi-close</v-icon>
        <v-icon v-else>mdi-plus</v-icon>
      </Button>
    </v-row>
    <v-dialog
        v-model="buttonNewNote"
        fullscreen
        hide-overlay
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
                @click="buttonNewNote = false">
                <v-icon>mdi-close</v-icon>
              </v-btn>
              <v-toolbar-title>Nova Nota</v-toolbar-title>
              <v-spacer></v-spacer>
              <v-toolbar-items>
                <v-btn
                  dark
                  text
                  @click="addNote">
                  Salvar
                </v-btn>
              </v-toolbar-items>
            </v-toolbar>
          </v-row>
          <v-card-text>
            <v-row>
                <v-col cols="12">
                  <Input
                    label="Título"
                    v-model="note.title"
                  />
                </v-col>
                <v-col cols="12">
                  <TextArea
                    label="Descrição da tarefa"
                    rows="4"
                    v-model="note.text"
                  />
                </v-col>
                <v-col cols="12">
                  <span v-for="(color, index) in styles" :key="index" style="margin-left: 5px">
                    <v-btn @click="selectColor(index)" :color="color.bg" fab small depressed="" :dark="color.darken" class="text-white">
                      <v-icon v-if="color.selected" color="white">mdi-check-bold</v-icon>
                    </v-btn>
                  </span>
                </v-col>
                <v-col cols="12">
                  <v-menu
                    v-model="menu"
                    :close-on-content-click="false"
                    transition="scale-transition"
                    offset-y
                    max-width="290px"
                    min-width="290px"
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-text-field
                        v-model="dataFormatada"
                        label="Data Conclusão"
                        hint="DD/MM/AAAA"
                        persistent-hint
                        prepend-icon="mdi-calendar"
                        readonly
                        v-bind="attrs"
                        v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker
                      v-model="dataConclusao"
                      no-title
                      @input="menu = false"
                    ></v-date-picker>
                  </v-menu>
                </v-col>
                <v-col>
                  <Button
                    @click="sharedButton = !sharedButton"
                  >
                    Compartilhar Atividade
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
                  @click="sharedButton = false"
                >
                  Selecionar usuários
                </v-btn>
              </v-toolbar-items>
            </v-toolbar>
        <SharedCard @selectUser="pegarUsuarios($event)"/>
        </v-card>
      </v-dialog>
      <v-dialog
        v-model="botaoAtividadesFechadas"
      >
      <v-card>
      <v-toolbar
          dark
          color="bluePi">
          <v-btn
            icon
            dark
            @click="botaoAtividadesFechadas = false">
            <v-icon>mdi-close</v-icon>
          </v-btn>
          <v-toolbar-title>Atividades Fechadas</v-toolbar-title>
          <v-spacer></v-spacer>
        </v-toolbar>
        <v-list-item  two-line v-for="atividade in atividadesFechadas" :key="atividade.title">
          <v-list-item-content>
            <v-list-item-title>{{ atividade.title }}</v-list-item-title>
            <v-list-item-subtitle>{{ atividade.text }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        </v-card>
      </v-dialog>
  </v-container>
</template>

<script>
import NoteCard from '../../components/NoteCard/NoteCard.vue'
import Button from '../../components/Button/Button.vue'
import Input from '../../components/Input/Input.vue'
import TextArea from '../../components/TextArea/TextArea.vue'
import SharedCard from '../../components/ShareCard/ShareCard.vue'
import api from '../../services/api'
import { mapGetters } from 'vuex'

export default {
  name: 'Atividades',
  components: {
    NoteCard,
    Button,
    Input,
    TextArea,
    SharedCard
  },
  data: () => ({
    buttonNewNote: false,
    sharedButton: false,
    botaoAtividadesFechadas: false,
    notes: [],
    idUsuarios: [],
    atividadesFechadas: [],
    note: {
      title: '',
      text: '',
      created: '',
      style: ''
    },
    styles: [
      {
        bg: '#385F73',
        darken: true,
        selected: false
      },
      {
        bg: 'red',
        darken: true,
        selected: false
      },
      {
        bg: 'light-blue',
        darken: true,
        selected: false
      },
      {
        bg: 'teal',
        darken: true,
        selected: false
      },
      {
        bg: 'amber',
        darken: true,
        selected: false
      },
      {
        bg: 'green',
        darken: true,
        selected: false
      }
    ],
    dataConclusao: '',
    menu: false
  }),
  computed: {
    ...mapGetters([
      'getUsuario'
    ]),
    dataFormatada () {
      return this.formatDate(this.dataConclusao)
    }
  },
  mounted () {
    this.pegarAtividades()
  },
  methods: {
    mostrarAtividadesFechadas () {
      this.pegarAtividadesFechadas()
      this.botaoAtividadesFechadas = true
    },
    formatDate (date) {
      if (!date) return null
      const [year, month, day] = date.split('-')
      return `${day}/${month}/${year}`
    },
    pegarUsuarios (listaIdUsuarios) {
      this.idUsuarios = listaIdUsuarios
    },
    addNote () {
      let newNote = {}
      newNote = Object.assign(newNote, this.note)
      if (newNote.title && newNote.text) {
        console.log(this.idUsuarios)
        api.atividades.enviarAtividades(newNote.text, newNote.title, newNote.style.bg, [this.getUsuario.idUsuario, ...this.idUsuarios], this.dataConclusao)
          .then(resposta => {
            this.buttonNewNote = false
            this.sharedButton = false
            this.clearNote()
            this.pegarAtividades()
          })
          .catch(erro => {
            console.log(erro)
          })
      }
    },
    selectColor (index) {
      this.styles.map(e => {
        e.selected = false
      })
      this.styles[index].selected = true
      this.note.style = this.styles[index]
    },
    clearNote () {
      for (const key in this.note) {
        this.note[key] = ''
      }
      this.styles.map(e => {
        e.selected = false
      })
    },
    openNewNote () {
      this.buttonNewNote = true
      this.selectColor(0)
    },
    pegarAtividades () {
      api.atividades.pegarAtividades(this.getUsuario.idUsuario)
        .then(resposta => {
          const atividades = resposta.data.map(atividade => {
            var usuarios = atividade.usuarios.reduce((total, usuario, index, arr) => {
              if (index === arr.length - 1) {
                return total + usuario.nomeUsuario
              } else {
                return total + usuario.nomeUsuario + ', '
              }
            }, '')
            return {
              title: atividade.tituloAtividade,
              id: atividade.idAtividade,
              text: atividade.descAtividade,
              style: {
                bg: atividade.corAtividade,
                darken: true,
                selected: false
              },
              date: this.formatDate(atividade.dataPrevista.substring(0, 10)),
              users: usuarios
            }
          })
          this.notes = atividades
        })
        .catch(erro => {
          console.log(erro)
        })
    },
    pegarAtividadesFechadas () {
      api.atividades.pegarAtividadesFechadas(this.getUsuario.idUsuario)
        .then(resposta => {
          const atividades = resposta.data.map(atividade => {
            return {
              title: atividade.tituloAtividade,
              text: atividade.descAtividade.substring(0, 30) + '...'
            }
          })
          this.atividadesFechadas = atividades
        })
        .catch(erro => {
          console.log(erro)
        })
    },
    fecharAtividades (idAtividade) {
      api.atividades.fecharAtividades(idAtividade)
        .then(resposta => {
          this.pegarAtividades()
          this.pegarAtividadesFechadas()
        })
        .catch(erro => {
          console.log(erro)
        })
    }
  }
}
</script>

<style scoped>
</style>
