<template>
   <v-navigation-drawer
      :mini-variant.sync="mini"
      permanent
      app
    >
      <v-list dense>
        <v-list-item
          v-for="item in items"
          :key="item.title"
          link
          :to="item.url"
        >
          <v-list-item-icon>
            <v-icon color="bluePi">{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-spacer></v-spacer>
        <v-divider></v-divider>
        <v-list-item class="px-2">
            <v-list-item-icon>
              <v-icon color="bluePi">mdi-account</v-icon>
            </v-list-item-icon>
            <v-list-item-title>{{getUsuario.nomeUsuario}}</v-list-item-title>

            <v-btn
            icon
            @click.stop="mini = !mini"
            >
            <v-icon>mdi-chevron-left</v-icon>
            </v-btn>
          </v-list-item>
        <v-list-item class="px-2" @click="sair">
            <v-list-item-icon>
              <v-icon color="bluePi">mdi-logout</v-icon>
            </v-list-item-icon>
            <v-list-item-title>Sair</v-list-item-title>
          </v-list-item>
      </v-list>

    </v-navigation-drawer>
</template>

<script>
import { mapGetters, mapMutations } from 'vuex'

export default {
  name: 'Header',
  data () {
    return {
      items: [
        { title: 'Conversas', icon: 'mdi-chat', url: 'chat' },
        { title: 'Arquivos', icon: 'mdi-file-document', url: 'arquivos' },
        { title: 'Atividades', icon: 'mdi-account-edit', url: 'atividades' }
      ],
      mini: true
    }
  },
  computed: {
    ...mapGetters([
      'getUsuario'
    ])
  },
  methods: {
    ...mapMutations([
      'logout'
    ]),
    sair () {
      this.logout()
      this.$router.replace('login')
    }
  }
}
</script>

<style scoped>

</style>
