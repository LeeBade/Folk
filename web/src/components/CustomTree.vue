<template>
  <div class="tree-container">
    <el-tree :data="data" :props="defaultProps" icon-class="el-icon-arrow-right" @node-click="handleNodeClick"
             indent=20 highlight-current="true"
             class="custom-tree">
    </el-tree>
  </div>
</template>

<script>
export default {
  data() {
    return {
      data :[
        {
          "label": "风貌总述",
          "id": 1
        },
        {
          "label": "衣食住行",
          "id": 2
        },
        {
          "label": "士业百态",
          "id": 3,
          "children": [
            {
              "label": "士习",
              "id": 4
            },
            {
              "label": "娱乐",
              "id": 5
            },
            {
              "label": "市场赶集",
              "id": 6
            },
            {
              "label": "农事",
              "id": 7
            },
            {
              "label": "百工",
              "id": 8
            },
            {
              "label": "商贸",
              "id": 9
            }
          ]
        },
        {
          "label": "多样礼俗",
          "id": 10,
          "children": [
            {
              "label": "冠礼、笄礼",
              "id": 11
            },
            {
              "label": "婚礼",
              "id": 12,
              "children": [
                {
                  "label": "婚前",
                  "id": 13
                },
                {
                  "label": "婚期",
                  "id": 14
                },
                {
                  "label": "新婚俗",
                  "id": 15
                }
              ]
            },
            {
              "label": "丧葬礼",
              "id": 16,
              "children": [
                {
                  "label": "丧礼",
                  "id": 17
                },
                {
                  "label": "葬礼",
                  "id": 18
                },
                {
                  "label": "祭礼",
                  "id": 19
                }
              ]
            },
            {
              "label": "宴饮礼",
              "id": 21,
              "children": [
                {
                  "label": "节宴/庆宴",
                  "id": 22
                },
                {
                  "label": "乡饮",
                  "id": 23
                }
              ]
            }
          ]
        },
        {
          "label": "民间信仰",
          "id": 24,
          "children": [
            {
              "label": "祭祀",
              "id": 25
            },
            {
              "label": "祈禳",
              "id": 26
            }
          ]
        },
        {
          "label": "节庆万花筒",
          "id": 27,
          "children": [
            {
              "label": "正月",
              "id": 28
            },
            {
              "label": "二月",
              "id": 29
            },
            {
              "label": "三月",
              "id": 30
            },
            {
              "label": "四月",
              "id": 31
            },
            {
              "label": "五月",
              "id": 32
            },
            {
              "label": "六月",
              "id": 33
            },
            {
              "label": "七月",
              "id": 34
            },
            {
              "label": "八月",
              "id": 35
            },
            {
              "label": "九月",
              "id": 36
            },
            {
              "label": "十月",
              "id": 37
            },
            {
              "label": "十一月",
              "id": 38
            },
            {
              "label": "十二月",
              "id": 39
            }
          ]
        }
      ]
      ,
      defaultProps: {
        children: 'children',
        label: 'label'
      }
    };
  },
  methods: {
    handleNodeClick(data) {
      this.$emit('handle-node-click', data);
    }
  }
};
</script>

<style scoped>
.tree-container /deep/ .el-tree-node {
  position: relative;
  padding-left: 13px;
  color: #000;
}
</style>
