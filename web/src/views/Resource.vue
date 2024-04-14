<template>
  <div class="flex-container">
    <el-aside>
      <custom-tree @handle-node-click="handleNodeClick"></custom-tree>
    </el-aside>
    <el-main>
      <div>
        <div class="content markdown-body"  v-html="content" ></div>
      </div>
    </el-main>
  </div>
</template>

<script>
import 'github-markdown-css/github-markdown.css'
import api from "../../api/api";
import CustomTree from "../components/CustomTree.vue"
import MarkdownIt from 'markdown-it'

export default {
  name: "Resource",
  components: {
    CustomTree,
  },
  data() {
    return {
      id:1,
      content: ""
    }
  },
  mounted() {
    api.getText(1).then(res=>{
      this.content=res.data.text
    }).catch(err=>{
      this.content=""
      console.log(err)
    })
  },
  methods:{
    handleNodeClick(data) {
      this.id=data.id
      api.getText(this.id).then(res=>{
        const md = new MarkdownIt()
        this.content = md.render(res.data.text)
      }).catch(err=>{
        this.content=""
        console.log(err)
      })
    }
  }
}
</script>


<style scoped>
.flex-container {
  display: flex;
}
</style>