<template>
  <v-card flat>
    <v-card-title class="bluePi--text">{{ title }}</v-card-title>
  </v-card>
</template>

<script>
export default {
  name: 'MessageHeader',
  props: {
    title: {
      type: String,
      required: true
    }
  }
}
</script>

<style scoped>

</style>
