<template>

  <div>
    <template>

      <el-transfer class="transfer-class"
        style="text-align: left; display: inline-block"
        v-model="pageDef.rightData"
        filterable
        :left-default-checked="form.leftDefaultChecked"
        :right-default-checked="form.rightDefaultChecked"
        :titles="pageDef.titles"
        :button-texts="pageDef.buttonTexts"
        :isManyButton=pageDef.isManyButton :props="pageDef.name"
        :format="{
        noChecked: '${total}',
        hasChecked: '${checked}/${total}'
      }"
        @change="handleChange" @left-check-change="leftCheckChange" @right-check-change="rightCheckChange"
        :data="pageDef.totalData">
        <template v-if="pageDef.showButton">
        <span slot-scope="{ option }">{{ option[pageDef.name.key] }} - {{ option[pageDef.name.label] }}</span>
          <el-button class="transfer-footer" slot="left-footer" size="small">操作</el-button>
          <el-button class="transfer-footer" slot="right-footer" size="small">操作</el-button>
        </template>

      </el-transfer>

    </template>
  </div>

</template>

<script>
    export default {
        name: "csc-el-transfer",
        data() {
          // const generateData = _ => {
          //   const data = [];
          //   for (let i = 1; i <= 18; i++) {
          //     data.push({
          //       key: i,
          //       label: `备选项 ${ i }`,
          //       disabled: i % 4 === 0
          //     });
          //   }
          //   return data;
          // };

          //以下设置别名
          const generateData = _ => {
            const data = [];
            for (let i = 1; i <= 18; i++) {
              data.push({
                value: i,
                desc: `备选项 ${ i }`,
                disabled: i % 4 === 0
              });
            }
            return data;
          };

          return {

            data: generateData(),
            // data: [],//2019-1-17 数据库查询返回结果
            // value3: [1],//render-content 自定义数据项
            value4: [1,7], //右侧选择框展现值
            form: {
              leftDefaultChecked:[2, 3],
              rightDefaultChecked:[1],

              // leftDefaultChecked:[],
              // rightDefaultChecked:[],

              value4: [1,7] //右侧选择框展现值   默认为未选择角色
            }
          }
        },
      props:{
          pageDef:{
            type:Object,
            required:true
          }

      },
      created:function () {
        console.log("CscElTransfer:"+this.pageDef.rightData);
      },
      mounted:function () {
          //2019-01-17 测试初始化时查询两边列表框数据
        this.doQuery();
      },
      methods:{
        doQuery(){
          this.$emit('doQuery');
        },
        handleChange(value, direction, movedKeys) {//@change 右侧值发生变化时事件  value 变化后右侧值
          console.log("CscElTransfer handleChange--"+value+"--"+direction+"--"+movedKeys);
          this.$emit("handleChange",value,direction,movedKeys);
        },
        leftCheckChange(checkedVal,changeVal) {
          console.log("CscElTransfer leftCheckChange--"+checkedVal+"--"+changeVal);
        },
        rightCheckChange(checkedVal,changeVal) {
          console.log("CscElTransfer rightCheckChange--"+checkedVal+"--"+changeVal);
        }
      }
    }
</script>

<style>
  .transfer-footer {
    margin-left: 20px;
    padding: 6px 5px;
  }
  .transfer-class.el-transfer-panel {
    text-align: left;
    border: 0px solid #ebeef5;
    border-radius: 4px;
    overflow: hidden;
    background: #fff;
    display: inline-block;
    vertical-align: middle;
    width: 250px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    position: relative;
  }
</style>
