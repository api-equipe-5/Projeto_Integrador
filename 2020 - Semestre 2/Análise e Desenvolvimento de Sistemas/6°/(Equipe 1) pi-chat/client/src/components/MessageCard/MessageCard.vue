<template>
  <v-card
    color="#e4e4e4"
  >
      <v-card-text>
        <div class="overline mb-4">
          <span class="font-weight-black">{{author}}</span>
          {{date}}
        </div>
          {{content}}
      </v-card-text>
  </v-card>
</template>

<script>
export default {
  name: 'MessageCard',
  props: {
    author: {
      type: String,
      required: true
    },
    date: {
      type: String,
      required: true
    },
    content: {
      type: String,
      required: true
    }
  }
}
</script>

<style scoped>

</style>
