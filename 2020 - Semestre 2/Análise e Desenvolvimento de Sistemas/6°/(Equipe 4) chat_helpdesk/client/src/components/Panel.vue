<template>
  <div>
    <header style="padding-left: 300px">
      <ul id="mobile-nav" class="sidenav sidenav-fixed lateral-sidenav">
        <li>
          <div class="user-view">
            <div class="background green lighten-1"></div>
            <a href="#user"
              ><img class="circle" src="../assets/profile.png"
            /></a>
            <a href="#name"
              ><span class="white-text name">{{ usuario.nome }}</span></a
            >
            <a href="#email"><span class="white-text email">Diretor</span></a>
          </div>
        </li>
        <li id="li_notifications">
          <a href="/panel?url=notifications" class="waves-effect waves-light"
            ><i class="material-icons">notifications</i>Atividades<span
              class="new badge red"
              data-badge-caption="novas"
              >11</span
            ></a
          >
        </li>
        <li id="li_chats">
          <a href="/panel?url=chats"
            ><i class="material-icons">chats</i>Conversas Internas</a
          >
        </li>
        <li id="li_history">
          <a href="/panel?url=history"
            ><i class="material-icons">history</i>Histórico</a
          >
        </li>
        <li id="li_employes">
          <a href="/panel?url=employes"
            ><i class="material-icons">group</i>Funcionarios</a
          >
        </li>
        <li id="li_live_chats">
          <a href="/panel?url=live_chats"
            ><i class="material-icons">record_voice_over</i>Conversas ao vivo</a
          >
        </li>
      </ul>

      <ul
        id="notifications-side-nav"
        class="sidenav notifications-sidenav"
        style="width: 250px"
      >
        <ul class="collection with-header">
          <li class="collection-header">
            <h4>Notificações</h4>
          </li>
        </ul>
      </ul>
    </header>

    <div class="teste ">
      <nav>
        <div class="nav-wrapper blue-grey lighten-3">
          <a href="#" class="brand-logo center">
            <img style="width: 100%" src="../assets/logo.png"
          /></a>
          <ul class="left hide-on-large">
            <li>
              <a href="#" data-target="mobile-nav" class="sidenav-trigger"
                ><i class="material-icons">menu</i></a
              >
            </li>
          </ul>
          <ul class="right hide-on-med-and-down">
            <li>
              <a
                data-target="notifications-side-nav"
                class="sidenav-trigger"
                style="display: block"
                ><i class="material-icons">notifications</i></a
              >
            </li>
            <li>
              <a v-on:click="logout()"><i class="material-icons">exit_to_app</i></a>
            </li>
          </ul>
        </div>
      </nav>

      <div v-if="location == '?url=notifications' || location == ''">
          <Notifications v-bind:usuario="usuario" />
      </div>

      <div v-if="location == '?url=employes'">
          <Employes v-bind:usuario="usuario" />
      </div>
    </div>

    <div class="fixed-action-btn hide-on-large-only pop">
      <a class="btn-floating btn-large green lighten-1">
        <i class="large material-icons">settings</i>
      </a>
      <ul>
        <li>
          <a
            class="btn-floating yellow darken-1 sidenav-trigger"
            data-target="notifications-side-nav"
            ><i class="material-icons">notifications</i></a
          >
        </li>
        <li>
          <a class="btn-floating red" v-on:click="logout()"
            ><i class="material-icons">exit_to_app</i></a
          >
        </li>
      </ul>
    </div>
  </div>
</template>


'<script>
let usuario
if (sessionStorage.usuario) {
  usuario = JSON.parse(sessionStorage.usuario);
}

let location = window.location.search;
import Notifications from "./Notifications.vue";
import Employes from "./Employes.vue";

function logout(){
  sessionStorage.removeItem('usuario');
  window.location.reload();
}

export default {
  name: "Panel",
  components: {
    Notifications,
    Employes
  },
  methods: {
    logout,
  },
  data() {
    return {
      usuario,
      location
    };
  },
};
</script>'

<style>
body {
  background: white;
}
</style>
