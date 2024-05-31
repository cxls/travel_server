<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="酒店名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入酒店名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="酒店地址" prop="region">
        <el-input
          v-model="queryParams.region"
          placeholder="请输入酒店地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:hotel:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:hotel:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:hotel:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:hotel:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="hotelList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="酒店名称" align="center" prop="name" />
      <!-- <el-table-column label="坐标" align="center" prop="location" /> -->
      <el-table-column
        label="缩略图"
        align="center"
        prop="imageUrl"
        width="100"
      >
        <template slot-scope="scope">
          <image-preview :src="scope.row.imageUrl" :width="50" :height="50" />
        </template>
      </el-table-column>
      <el-table-column label="酒店地址" align="center" prop="region" />
      <el-table-column label="酒店描述" align="center" prop="description">
        <template slot-scope="scope">
          <el-tooltip :content="scope.row.description" placement="top">
            <p class="descStyle">{{ scope.row.description }}</p>
          </el-tooltip>
        </template>
      </el-table-column>
      <el-table-column label="价格" align="center" prop="price" />
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:hotel:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:hotel:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改酒店信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="酒店名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入酒店名称" />
        </el-form-item>
        <!-- <el-form-item label="坐标" prop="location">
          <el-input v-model="form.location" placeholder="请输入坐标" />
        </el-form-item> -->
        <el-form-item label="缩略图" prop="imageUrl">
          <image-upload v-model="form.imageUrl" />
        </el-form-item>
        <el-form-item label="酒店地址" prop="region">
          <!-- <el-input v-model="form.region" placeholder="请输入酒店地址" /> -->
          <area-selector
            v-model="form.regionArr"
            @change="areaChange"
          ></area-selector>
        </el-form-item>
        <el-form-item label="酒店描述" prop="description">
          <el-input
            v-model="form.description"
            type="textarea"
            placeholder="请输入内容"
          />
        </el-form-item>
        <el-form-item label="酒店价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入酒店价格" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listHotel,
  getHotel,
  delHotel,
  addHotel,
  updateHotel,
} from "@/api/system/hotel";

import AreaSelector from "@/components/AreaSelector";

export default {
  name: "Hotel",
  components: {
    AreaSelector,
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 酒店信息表格数据
      hotelList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        location: null,
        region: null,
        description: null,
        price: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "酒店名称不能为空", trigger: "blur" },
        ],
        imageUrl: [
          { required: true, message: "图片不能为空", trigger: "blur" },
        ],
        region: [
          { required: true, message: "酒店地址不能为空", trigger: "blur" },
        ],
        price: [
          { required: true, message: "酒店价格不能为空", trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getList();
  },
  watch: {
    "form.region"(val) {
      this.form.regionArr = val.split("/");
    },
  },
  methods: {
    /** 查询酒店信息列表 */
    getList() {
      this.loading = true;
      listHotel(this.queryParams).then((response) => {
        this.hotelList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        location: null,
        region: null,
        description: null,
        imageUrl: null,
        price: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加酒店信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getHotel(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改酒店信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateHotel(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHotel(this.form).then((response) => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal
        .confirm('是否确认删除酒店信息编号为"' + ids + '"的数据项？')
        .then(function () {
          return delHotel(ids);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    areaChange(val) {
      this.form.region = val;
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "system/hotel/export",
        {
          ...this.queryParams,
        },
        `hotel_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>

<style scoped>
.descStyle {
  overflow: hidden;
  text-overflow: ellipsis;
  word-break: break-all;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  /*行数 */
  -webkit-box-orient: vertical;
}
</style>
