import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "@/views/Home.vue";
import Resource from "@/views/Resource.vue";
import Edit from "@/views/Edit.vue";
import Game from "@/views/Game.vue";
import Reference from "@/views/Reference.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/resource',
    name: 'resource',
    component: Resource
  },
  {
    path: '/edit',
    name: 'edit',
    component: Edit
  },{
    path: '/game',
    name: 'game',
    component: Game
  },{
    path: '/reference',
    name: 'reference',
    component: Reference
  }
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

export default router
