<template>
  <el-tree
    :data="menus"
    :props="defaultProps"
    @node-click="handleNodeClick"
    show-checkbox
    :default-expanded-keys="[2, 3]"
  :default-checked-keys="[5]"
  ></el-tree>
</template>
<script>
export default {
  data() {
    return {
      menus: [],
      defaultProps: {
        children: "children",
        label: "name",
      },
    };
  },
  methods: {
    handleNodeClick(data) {},
    getListTree() {
      this.$http({
        url: this.$http.adornUrl("/product/category/list/tree"),
        method: "get",
      }).then(({ data }) => {
        if (data.code == 0) {
          this.menus = data.data;
          console.log("1111111111111" + JSON.parse(JSON.stringify(data.data)));
          console.log("-------------------------data:" + data.data);
          console.log("-------------------------data:" + this.menus);
          console.log("-------------------------data:" + this.menus[0]);
          console.log("-------------------------data:" + this.menus[0].name);
          console.log("-------------------------data:" + this.menus[0].catId);
        }
      });
    },
  },
  activated() {
    this.getListTree();
  },
};
</script>