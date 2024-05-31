<!-- AreaState.vue -->
<template>
  <el-cascader
    v-model="selectedArea"
    :options="areaOptions"
    @change="handleChange"
    filterable
    clearable
    placeholder="请选择地区"
  >
  </el-cascader>
</template>

<script>
import areaData from "@/assets/pcas-code.json";

export default {
  props: ["value"], // 接受父组件传递的初始值
  data() {
    return {
      selectedArea: this.value, // 初始化时使用从父组件传递的值
      areaOptions: this.formatAreaData(areaData),
    };
  },
  watch: {
    // 监听 selectedArea 的变化，并通知父组件
    selectedArea(newVal) {
      this.$emit("input", newVal);
    },
    // 确保父组件传递的 value 更新时，本地也同步更新
    value(newVal) {
      this.selectedArea = newVal;
    },
  },
  methods: {
    formatAreaData(data) {
      return Object.entries(data).map(([provinceCode, province]) => ({
        value: province.name,
        label: province.name,
        children: Object.entries(province.children || {}).map(
          ([cityCode, city]) => ({
            value: city.name,
            label: city.name,
            children: Object.entries(city.children || {}).map(
              ([areaCode, area]) => ({
                value: area.name,
                label: area.name,
              })
            ),
          })
        ),
      }));
    },
    findLabelByValue(value, options) {
      for (let option of options) {
        if (option.value === value) {
          return option.label;
        }
        if (option.children) {
          let found = this.findLabelByValue(value, option.children);
          if (found) return found;
        }
      }
      return null;
    },
    handleChange(value) {
      const fullAddress = value.join("/");
      console.log(fullAddress);
      this.$emit("change", fullAddress); // 可以选择向父组件传递完整地址字符串
    },
  },
};
</script>
