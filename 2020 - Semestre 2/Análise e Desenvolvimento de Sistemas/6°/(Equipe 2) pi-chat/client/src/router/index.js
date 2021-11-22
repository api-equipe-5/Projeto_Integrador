import Vue from 'vue'
import VueRouter from 'vue-router'
import Chat from '../views/Chat/Chat.vue'
import Atividades from '../views/Atividades/Atividades.vue'
import Arquivos from '../views/Arquivos/Arquivos.vue'
import Login from '../views/Login/Login.vue'
import store from '../store/index'

Vue.use(VueRouter)

const routes = [
  {
    path: '/arquivos',
    name: 'arquivos',
    component: Arquivos,
    meta: {
      requiresAuth: true
    }

  },
  {
    path: '/chat',
    name: 'chat',
    component: Chat,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/atividades',
    name: 'atividades',
    component: Atividades,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/',
    redirect: '/login'
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth)
  const token = store.getters.getToken
  if (requiresAuth && !token) {
    next('login')
  } else if (!requiresAuth && token) {
    next('chat')
  } else {
    next()
  }
})

export default router
