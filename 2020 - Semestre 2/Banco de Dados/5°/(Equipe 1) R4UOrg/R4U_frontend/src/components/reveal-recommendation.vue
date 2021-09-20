<template>
  <div class="main-container">
    <div class="main-card">
      <p>Nossa recomendação para você é:</p>
      <p class="movie-title">{{filme}}</p>
      <button class="voltar-button" @click="previousStep()">Voltar</button>
    </div>
  </div> 
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
       filme: 'Filmasso'
    }
  },
  mounted () {
    axios
      .get('http://3.133.126.210:5001/getRecommendation')
      .then(response => {
        this.filme = response.data.filme
      })
  },
  methods: {
    previousStep () {
      this.$emit('previousStep')
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

.main-card {
  padding: 30px;
  background-color: #212123;
  margin: 0 auto;
  border-radius: 10px;
  width: 300px;
}

.voltar-button {
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

.movie-title {
  font-size: 20px;
  font-weight: 700;
}

</style>
