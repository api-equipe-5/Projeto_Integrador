<template>
  <v-app>
    <SideBar
      v-if="getToken"
    />
    <v-main>
      <router-view/>
      <v-overlay :value="getRequest.loading">
        <v-progress-circular
          indeterminate
          size="64"
        />
      </v-overlay>
      <v-snackbar
        v-model="getRequest.snackbar"
        :color="getRequest.cor"
        bottom
        left
      >
        {{ getRequest.mensagem }}

        <template v-slot:action="{ attrs }">
          <v-btn
            dark
            v-bind="attrs"
            icon
            @click="closeSnackbar"
          >
            <v-icon>mdi-close</v-icon>
          </v-btn>
        </template>
      </v-snackbar>
    </v-main>
  </v-app>
</template>
<script>
import SideBar from './components/SideBar/SideBar.vue'
import { mapGetters, mapMutations } from 'vuex'

export default {
  components: {
    SideBar
  },
  computed: {
    ...mapGetters([
      'getToken',
      'getRequest'
    ])
  },
  methods: {
    ...mapMutations([
      'closeSnackbar'
    ])
  }
}
</script>
<style scoped>
</style>
