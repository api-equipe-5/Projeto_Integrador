<template>
   <v-card
        :color="note.style.bg"
        :dark="note.style.darken"
        height="100%"
    >
        <v-card-title class="headline">{{note.title}}</v-card-title>

        <v-card-text>
          <p class="white--text"><span class="font-weight-bold">Data Conclusão: </span>{{note.date}}</p>
          <p class="white--text"><span class="font-weight-bold">Usuarios: </span>{{note.users}}</p>
          <p class="white--text">{{ noteText }} </p>
        </v-card-text>
        <v-card-actions>
        <v-spacer/>
        <v-btn
          color="blue-grey lighten-5"
          class="black--text"
          @click="$emit('click')"
        >
          Fechar Atividade
        </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
export default {
  name: 'NoteCard',
  props: {
    note: {
      type: Object,
      required: true
    }
  },
  computed: {
    noteText: function () {
      return this.note.text.replace(/(\\r)*\\n/g, '<br>')
    }
  }
}
</script>

<style scoped>

</style>
