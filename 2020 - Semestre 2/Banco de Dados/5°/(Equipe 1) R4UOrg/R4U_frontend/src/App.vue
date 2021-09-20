<template>
  <div id="app">
    <div class="header" />
    <landing-page v-if="step === 1" @nextStep="nextStep()" />
    <reveal-recommendation v-if="step === 2" @previousStep="previousStep()" />
  </div>
</template>

<script>
import landingPage from './components/landing-page.vue'
import revealRecommendation from './components/reveal-recommendation.vue'

export default {
  name: 'App',
  components: {
    landingPage,
    revealRecommendation
  },
  data () {
    return {
      step: 1
    }
  },
  methods: {
    nextStep () {
      this.step = 2;
    },
    previousStep () {
      this.step = 1;
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  overflow: hidden;
}

.disclaimer {
  position: absolute;
  bottom: 0;
  padding: 10px;
}

.header {
  background-image: linear-gradient(to right, #05c05d, #0b35d1, #ef1111);
  position: absolute;
  top: 0;
  padding: 3px;
  width: 100%;
}
</style>
