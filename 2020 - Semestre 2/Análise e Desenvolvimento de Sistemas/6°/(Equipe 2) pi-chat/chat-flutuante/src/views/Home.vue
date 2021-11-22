<template>
  <div>
    <div>
      <iframe class="chat" scrolling="no" src="/chat" v-if="active"/>
      <v-btn
        class="mx-2"
        fab
        right
        bottom
        fixed
        dark
        color="#005796"
        @click="active = !active"
      >
        <v-icon dark>
          mdi-forum
        </v-icon>
      </v-btn>
    </div>
  </div>
</template>

<script>

export default {
  name: 'Home',
  components: {
  },
  data () {
    return {
      active: false
    }
  }
}
</script>

<style scoped>
.chat{
  width: 350px;
  height: 500px;
  position:fixed;
  right: 20px;
  bottom: 90px;
  border-radius: 15px;
  box-shadow: 5px 10px #888888;
}
</style>