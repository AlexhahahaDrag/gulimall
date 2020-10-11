<template>
  <div>
    <el-tree
      :data="menus"
      :props="defaultProps"
      @node-click="handleNodeClick"
      show-checkbox
      :expand-on-click-node="false"
      node-key="catId"
      :default-expanded-keys="expandedKey"
    >
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>
        <span>
          <el-button
            type="text"
            size="mini"
            @click="() => append(data)"
            v-if="node.level < 3"
          >
            Append
          </el-button>
          <el-button
            type="text"
            size="mini"
            @click="() => edit(node, data)"
          >
            Edit
          </el-button>
          <el-button
            type="text"
            size="mini"
            v-if="node.childNodes == null || node.childNodes.length == 0"
            @click="() => remove(node, data)"
          >
            Delete
          </el-button>
        </span>
      </span>
    </el-tree>
    <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      width="30%"
      :close-on-click-modal="false"
    >
      <el-form :model="category">
        <el-form-item label="分类名称">
          <el-input v-model="category.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="图标">
          <el-input v-model="category.icon" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="计量单位">
          <el-input
            v-model="category.productUnit"
            autocomplete="off"
          ></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitData">确 定</el-button>
      </span>
    </el-dialog>
  </div>
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
      expandedKey: [],
      category: {
        name: "",
        icon: "",
        productUnit: "",
        parentCid: "",
        catLevel: "",
        showStatus: "1",
        sort: "",
      },
      dialogVisible: false,
      title: "",
      dialogType: "", //add edit
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
        }
      });
    },
    append(data) {
      this.dialogVisible = true;
      this.titel = "新增菜单";
      this.dialogType = "add";
      this.category = {
        name: "",
        icon: "",
        productUnit: "",
        parentCid: data.catId,
        catLevel: data.catLevel * 1 + 1,
        showStatus: "1",
        sort: "",
      };
    },
    edit(data) {
      var { catId, name, icon, productUnit } = data.data;
      this.category.catId = catId;
      this.category.name = name;
      this.category.icon = icon;
      this.category.productUnit = productUnit;
      this.dialogVisible = true;
      this.titel = "修改菜单";
      this.dialogType = "edit";
    },
    remove(node, data) {
      var ids = [data.catId];
      this.$confirm(`是否删除【${data.name}】菜单?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.$http({
            url: this.$http.adornUrl("/product/category/delete"),
            method: "post",
            data: this.$http.adornData(ids, false),
          }).then(({ data }) => {
            this.$message({
              message: "菜单删除成功",
              type: "success",
            });
            //刷新出新的菜单
            this.getListTree();
            //设置需要默认展开的菜单
            this.expandedKey = [node.parent.data.catId];
          });
        })
        .catch(() => {});
      console.log("remove", node, data);
    },
    submitData() {
      if (this.dialogType === "add") {
        this.addCategory();
      } else if (this.dialogType === "edit") {
        this.editCategory();
      }
    },
    addCategory() {
      this.$http({
        url: this.$http.adornUrl("/product/category/save"),
        method: "post",
        data: this.$http.adornData(this.category, false),
      }).then(({ data }) => {
        this.$message({
          message: "菜单修改成功",
          type: "success",
        });
        //关闭对话框
        this.dialogVisible = false;
        //刷新出新的菜单
        this.getListTree();
        //设置需要默认展开的菜单
        this.expandedKey = [this.category.parentCid];
      });
    },
    editCategory() {
      var { catId, name, icon, productUnit } = this.category;
      this.$http({
        url: this.$http.adornUrl("/product/category/update"),
        method: "post",
        data: this.$http.adornData({ catId, name, icon, productUnit }, false),
      }).then(({ data }) => {
        this.$message({
          message: "菜单修改成功",
          type: "success",
        });
        //关闭对话框
        this.dialogVisible = false;
        //刷新出新的菜单
        this.getListTree();
        //设置需要默认展开的菜单
        this.expandedKey = [this.category.catId];
      });
    },
  },
  activated() {
    this.getListTree();
  },
};
</script>