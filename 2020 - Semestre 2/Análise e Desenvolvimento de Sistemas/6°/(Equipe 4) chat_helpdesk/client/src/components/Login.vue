<template>
  <div class="container pop" style="margin-top: 10%">
    <div class="row">
      <div class="col s12 m6 l6 offset-m3 offset-l3">
        <div class="card">
          <div class="card-panel">
            <div class="row">
              <form class="col s12">
                <div class="row">
                  <div class="input-field col s12">
                    <i class="material-icons prefix">person</i>
                    <input id="name" type="text" class="validate" />
                    <label for="name">Nome</label>
                  </div>
                  <div class="input-field col s12">
                    <i class="material-icons prefix">lock</i>
                    <input id="password" type="password" class="validate" />
                    <label for="password">Senha</label>
                  </div>
                  <div class="section"></div>
                  <a
                    v-on:click="login()"
                    class="btn waves-effect waves-light col s12 green lighten-1"
                    >Entrar</a
                  >
                </div>
                <div class="input-field col s6 m6 l6">
                  <p class="medium-small"><a href="">Forgot password?</a></p>
                </div>
              </form>
            </div>
          </div>
        </div>

        <div id="modal1" class="modal">
          <div class="modal-content">
            <h4>Modal Header</h4>
            <p>A bunch of text</p>
          </div>
          <div class="modal-footer">
            <a href="#!" class="modal-close waves-effect waves-green btn-flat"
              >Agree</a
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>



<script>
import axios from "axios";

function login() {
  let name = document.getElementById("name").value;
  let password = document.getElementById("password").value;
  axios
    .get(
      `http://localhost:8081/spring-app/usuario/login?nome=${name}&senha=${password}`,
      {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      }
    )
    .then((data) => {sessionStorage.setItem('usuario', JSON.stringify(data.data)); window.location.reload()});
}

export default {
  name: "Login",
  methods: {
    login,
  },
};
</script>

<style>
body {
  background: #66bb6a !important;
}
</style>