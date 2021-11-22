<template>
  <v-card>
    <v-overlay :value="getRequest.loading">
        <v-progress-circular
          indeterminate
          size="64"
        />
    </v-overlay>
    <Input
      label="Pesquisar pelo nome"
      prepend-icon="mdi-magnify"
      v-model="search"
    />
    <v-container>
        <v-row>
            <v-col
              cols="3"
              v-for="(f, key) in user_filtros"
              :key="key"
            >
                <v-checkbox
                    v-model="filtros"
                    :label="f.label"
                    :value="f.value"
                ></v-checkbox>
            </v-col>
        </v-row>
    </v-container>
    <v-list dense>
      <v-subheader>Compartilhar com:</v-subheader>
       <v-list-item-group
          multiple
        >
        <v-list-item
          v-for="(user, key) in filteredList"
          :key="key"
        >
          <template v-slot:default="{ active }">
            <v-list-item-content>
              <v-list-item-title>
                {{user.name}}
                -
                <span class="bluePi--text"> {{user.role}} </span>
              </v-list-item-title>
            </v-list-item-content>
            <v-list-item-action>
              <v-checkbox
              :input-value="active"
              @click="selecionarUsuario(user)">
              </v-checkbox>
            </v-list-item-action>
          </template>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-card>
</template>

<script>
import Input from '../Input/Input'
import api from '../../services/api'
import { mapGetters } from 'vuex'

export default {
  name: 'ShareCard',
  data: () => ({
    users: [],
    search: '',
    filtros: [],
    idUsuarios: [],
    user_filtros: []
  }),
  computed: {
    ...mapGetters([
      'getRequest'
    ]),
    filteredList: function () {
      if (this.search && this.filtros.length > 0) {
        return this.users.filter((user) => {
          const name = user.name.toLowerCase()
          const target = this.search.toLowerCase()
          return name.match(target) && this.filtros.includes(user.role)
        })
      }
      if (this.search) {
        return this.users.filter((user) => {
          const name = user.name.toLowerCase()
          const target = this.search.toLowerCase()
          return name.match(target)
        })
      }
      if (this.filtros.length > 0) {
        return this.users.filter((user) => {
          return this.filtros.includes(user.role)
        })
      }
      return this.users
    }
  },
  created () {
    this.pegarUsuarios()
    this.pegarTiposUsuarios()
  },
  methods: {
    pegarUsuarios () {
      api.usuario.buscarUsuarios()
        .then(response => {
          const usuarios = response.data.map(usuario => {
            return {
              id: usuario.idUsuario,
              name: usuario.nomeUsuario,
              role: usuario.tiposUsuarios.nome.substring(5)
            }
          })
          this.users = usuarios
        }).catch(error => {
          console.log(error)
        })
    },
    pegarTiposUsuarios () {
      api.tiposUsuarios.pegarTiposUsuarios()
        .then(response => {
          const tipos = response.data.map(tipoUsuario => {
            const nome = tipoUsuario.nome.substring(5)
            return {
              label: nome,
              value: nome
            }
          })
          this.user_filtros = tipos
        })
        .catch(error => console.log(error))
    },
    selecionarUsuario (user) {
      if (user.selected) {
        const index = this.idUsuarios.indexOf(user.id)
        if (index > -1) {
          this.idUsuarios.splice(index, 1)
        }
        user.selected = false
      } else {
        user.selected = true
        this.idUsuarios.push(user.id)
      }
      this.$emit('selectUser', this.idUsuarios)
    }
  },
  components: {
    Input
  }
}
</script>
