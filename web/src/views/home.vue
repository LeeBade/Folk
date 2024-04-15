<template>
  <div class="container">
    <div class="first">
      <ImageWithText :height="items[0].height" :width="items[0].width"
                     :title="items[0].title" :description="items[0].description"
                     :src="getImagePath(items[0].img)" :title-size="items[0].titleSize" :description-size="items[0].descriptionSize">
      </ImageWithText>
      <el-divider></el-divider>
      <div style="display: flex; align-items: center;">

        <ImageWithText :height="items[1].height" :width="items[1].width"
                       :src="getImagePath(items[1].img)">
        </ImageWithText>
        <div>
          <h3>{{items[1].title}}</h3>
          <p>{{items[1].description}}</p>
        </div>
      </div>
      <el-divider></el-divider>
      <div style="display: flex; justify-content: space-between;">
        <ImageWithText v-for="item in items" v-if="item.id >= 2 && item.id <= 5"
                       :key="item.id"
                       :height="item.height" :width="item.width"
                       :title="item.title" :description="item.description"
                       :src="getImagePath(item.img)"
                       :flag="false"
                       >
        </ImageWithText>
      </div>
      <el-divider></el-divider>
      <div style="display: flex; justify-content: space-between;">
        <a v-for="link in links" :href="link.link">{{link.name}}</a>
      </div>
    </div>
  </div>
</template>



<script>
import Carousel from "@/components/Carousel.vue";
import ImageWithText from "@/components/ImageWithText.vue";

export default {
  name: "Home",
  components: {ImageWithText, Carousel},
  data(){
    return{
      items: [{
        id: 0,
        title: "明清至民国巴蜀民俗收录",
        titleSize:120,
        description: "--百里不同风，千里不同俗--",
        descriptionSize:30,
        height:1000,
        width:1800,
        img: "1(1).jpeg"
      }, {
        id: 1,
        title: "巴蜀风俗概览",
        description: "     民食鱼稻，无凶年之忧。其风尚侈，其俗好文。民重蚕事，俗好娱乐。土地活美，人士俊又。地大而腴，民勤耕作，无尺寸之弃，岁三四收。人多工巧、绫锦、雕镂之妙，无论贫富，生女必育。民性循柔，喜文而畏兵。",
        img: "2.jpeg",
        height:500,
        width:990,
      }, {
        id: 2,
        title: "四月八\n" +
            "嫁毛虫",
        description: "巴蜀民俗中的民间宗教信仰",
        height:180,
        width:300,
        img: "3(1).jpeg",
        link:"https://mp.weixin.qq.com/s/TpUUc0-6dpApOabIYkmD4A"
      }, {
        id: 3,
        title: "成都方言\n" +
            "词汇大赏",
        description: "",
        height:180,
        width:300,
        img: "3(2).jpeg",
        link:"https://mp.weixin.qq.com/s/teXJj5Vysj2GCXFK15oG-Q"
      }, {
        id: 4,
        title: "祈得云开见月明\n" +
            "呜呼驱鬼祟",
        description: "蜀中祈禳旧俗",
        height:180,
        width:300,
        img: "3(3).jpeg",
        link:"https://mp.weixin.qq.com/s/kPP5d0AXOti7jb82oNhnPQ"
      }, {
        id: 5,
        title: "川礼承古韵\n" +
            "蜀宴百年香",
        description: "宴饮中的蜀都礼俗",
        height:180,
        width:300,
        img: "3(4).jpeg",
        link:"https://mp.weixin.qq.com/s/f2zzPzbTAOQ_yebTygCf8Q"
      }],
      links:[{
        name:"四川博物院",
        link:"https://www.scmuseum.cn/sccms/site-1/"
      },{
        name:"成都博物馆",
        link:"https://www.cdmuseum.com/"
      },{
        name:"绵阳博物馆",
        link:"https://museum.mianyang.cn/"
      }]
    }
  },
  methods: {
    getImagePath(img) {
      return require(`@/assets/images/${img}`);
    },
    gotoLink(link) {
      // 使用 window.open 在新窗口中打开链接
      window.open(link, '_blank');
    }
  }
}
</script>



<style scoped>
.container{
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>