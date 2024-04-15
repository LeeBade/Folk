import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
import axios from 'axios'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import '@/assets/styles/ fontStyle.scss'
Vue.config.productionTip = false

Vue.prototype.$axios = axios
Vue.use(Element)
Vue.use(mavonEditor)
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
