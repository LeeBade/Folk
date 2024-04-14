<template>
  <div class="flex-container">
    <el-aside>
      <custom-tree @handle-node-click="handleNodeClick"></custom-tree>
    </el-aside>
    <el-main>
      <mavon-editor v-model="content" ref="md" @imgAdd="imgAdd" @imgDel="imgDel"/>
      <el-divider></el-divider>
      <el-footer>
        <el-button type="primary" @click="submitForm()">save</el-button>
      </el-footer>
    </el-main>
  </div>
</template>

<script>
import api from "../../api/api";
import { Message } from 'element-ui';
import CustomTree from '../components/CustomTree.vue';

export default {
  components: {
    CustomTree,
  },
  data() {
    return{
      id:1,
      content: '',
      img_file:[]
    }
  },
  mounted() {
    api.getText(1).then(res=>{
      this.content=res.data.text
    }).catch(err=>{
      console.log(err)
    })
  },
  methods: {
    imgAdd(pos, $file) {
      this.img_file[pos] = $file;
      const loading = this.$loading({
        lock: true,
        text: '正在上传...', // 设置加载提示文本
        spinner: 'el-icon-loading', // 设置加载图标
        background: 'rgba(0, 0, 0, 0.7)' // 设置遮罩背景颜色
      });
      api.uploadImg($file).then(res=>{
        loading.close();
        this.$refs.md.$img2Url(pos, api.urlPrefix+res.data.url);
      }).catch(error => {
        loading.close();
        delete this.img_file[pos];
        Message.error('上传失败:');
      });
    },
    imgDel(pos) {
      delete this.img_file[pos];
    },
    submitForm(){
      const loading = this.$loading({
        lock: true,
        text: '正在上传...', // 设置加载提示文本
        spinner: 'el-icon-loading', // 设置加载图标
        background: 'rgba(0, 0, 0, 0.7)' // 设置遮罩背景颜色
      });
      api.uploadText(this.content,this.id).then(res=>{
        loading.close();
        Message.success(res.data.msg);
      }).catch(error => {
        loading.close();
        console.error('上传失败:', error);
      });
    },
    handleNodeClick(data) {
      this.id=data.id
      api.getText(this.id).then(res=>{
        this.content=res.data.text
      }).catch(err=>{
        this.content=""
        console.log(err)
      })
    }
  }
};
</script>



<style>

.flex-container {
  display: flex;
}
</style>