<template>
    <div class="main-container">
      <div class="dialog-ballon">
        <img alt="R4U logo" @click="step = 1" class="logo" src="../assets/logo-r4u.png">
        <p class="call-to-action-text">Em dúvida sobre qual filme assistir?</p>
        <button class="reco-button" @click="nextStep()">Ver recomendação</button>
      </div>
    </div>
</template>

<script>
export default {
  data () {
    return {
    }
  },
  methods: {
    nextStep () {
      this.$emit('nextStep')
    }
  }
}

</script>

<style scoped>
.main-container {
  color: white;
  font-size: 18px;
  padding: 10px;
  height: 100vh;
}

.call-to-action-text {
  margin: 0;
}

.reco-button {
  position: relative;
  border-radius: 2px;
  border: transparent;
  background-color: white;
  font-weight: 700;
  bottom: -40px;
  color: white;
  padding: 15px 45px;
  background-image: linear-gradient(to right, #0d44a6, #04c360);
  cursor: pointer;
  transition: 0.3s;
}

.logo {
  height: 120px;
  margin-bottom: 20px;
}

.dialog-ballon {
  padding: 30px;
  background-color: #212123;
  width: 250px;
  margin: 0 auto;
  border-radius: 10px;
}
</style>