<template>
  <el-carousel :interval="5000" type="card" width="640px" height="400px">
    <el-carousel-item v-for="item in items" :key="item.id">
      <el-image :src="getImagePath(item.img)" style="object-fit: scale-down; width: 100%;height: 100%"></el-image>
      <div>
        <h2 >{{ item.title }}</h2>
        <p >{{ item.description }}</p>
      </div>
    </el-carousel-item>
  </el-carousel>
</template>

<script>
export default {
  data() {
    return {
      items: [{
        id: 1,
        title: "巴蜀民俗收录",
        description: "--百里不同风，千里不同俗——",
        img: "1(1).jpeg"
      }, {
        id: 2,
        title: "标题2",
        description: "描述2",
        img: "1(2).jpeg"
      }, {
        id: 3,
        title: "标题3",
        description: "描述3",
        img: "1(3).jpeg"
      }]
    }
  },
  methods: {
    getImagePath(img) {
      return require(`@/assets/images/${img}`);
    }
  }
}
</script>

<style>
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>