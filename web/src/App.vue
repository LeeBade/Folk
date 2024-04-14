<template>
  <div>
    <div class="container">
      <div class="platform-name">明清巴蜀民俗方言收录</div>
      <div>
        <el-menu
            :default-active="this.$route.path"
            router
            mode="horizontal"
            class="el-menu-horizontal"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
          <el-menu-item v-for="(item, i) in navList" :key="i" :index="item.name">
            <template slot="title">
              <i :class="item.iconName"></i>
              <span>{{ item.navItem }}</span>
            </template>
          </el-menu-item>
        </el-menu>
      </div>
    </div>
    <router-view></router-view>
  </div>
</template>
<script>
export default {
  data() {
    return {
      navList:[
        {name:'home',navItem:'首页',iconName:'el-icon-s-home'},
        {name:'resource',navItem:'民俗方言资料',iconName:'el-icon-s-tools'},
        {name:'edit',navItem:'修改',iconName:'el-icon-upload2'},
        {name:'reference',navItem:'参考文献',iconName:'el-icon-s-promotion'},
        {name:'game',navItem:'游戏',iconName:'el-icon-trophy'},
      ] }
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
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
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
.el-menu-horizontal {
  display: inline-block;
}

.platform-name {
  //position: fixed;
  //top: 20px;
  //right: 20px;
  font-family: cursive; /* 使用草书字体 */
  font-size: 24px; /* 字体大小 */
  color: #333; /* 字体颜色 */
}
.container {
  display: flex;
  align-items: center; /* 垂直居中对齐 */
}

</style>
