<template>
  <div class="image-container" :style="{ width: containerWidth, height: containerHeight}">
    <img :src="src" alt="image" :style="{ width: '100%', height: '100%' }" />
    <div v-if="flag" class="title" :style="{ width: containerWidth, top: (containerHeight / 2) - 20, fontSize:hSize}">{{ title }}</div>
    <div v-else class="title" :style="{ width: containerWidth, top: (containerHeight / 2) - 20, fontSize:hSize}">
      <a v-bind:href="link">{{ title }}</a>
    </div>
    <div  class="description" :style="{ width: containerWidth, top: (containerHeight / 2) + 20, fontSize:pSize}">{{ description }}</div>
  </div>
</template>

<script>
export default {
  props: {
    src: {
      type: String,
      required: true
    },
    title: {
      type: String,
      required: true
    },
    description: {
      type: String,
      required: true
    },
    width: {
      type: Number,
      required: true
    },
    height: {
      type: Number,
      required: true
    },
    titleSize: {
      type: Number,
      default: 20 // 默认标题大小
    },
    descriptionSize: {
      type: Number,
      default: 14 // 默认描述大小
    },
    link:{
      type:String,
      default:undefined
    },
    flag:{
      type:Boolean,
      default:true
    }
  },
  computed: {
    containerWidth() {
      return this.width + 'px';
    },
    containerHeight() {
      return this.height + 'px';
    },
    hSize(){
      return this.titleSize+'px';
    },
    pSize(){
      return this.descriptionSize+'px';
    }
  },
  methods:{
  }
};
</script>

<style>
.image-container {
  position: relative;
  overflow: hidden;
  display: inline-block;
  text-align: center;
  position: relative;
}

.title,
.description {
  position: absolute;
  left: 0;
  right: 0;
  margin: auto;
  color: white;
  font-weight: bold;
}

.title {
  top: 50%;
  transform: translateY(-50%);
  font-family: Cursive;
}

.description {
  top: 70%;
  transform: translateY(-50%);
}
</style>
