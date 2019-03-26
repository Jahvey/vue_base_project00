<template>
  <div>
    <el-button type="primary" @click="dialogFormVisible = true">增加</el-button>
    <el-button type="primary" @click="del">删除</el-button>
    <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons"
                      :formData="form"  :disableQueryButtons="disableQueryButtons" @delete="del" @add="dialogFormVisible" @doSave="doSave">
    </csc-single-table>
    <el-dialog title="新增" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="支付时间" :label-width="formLabelWidth">
          <el-input v-model="form.payTime" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="支付金额" :label-width="formLabelWidth">
          <el-input v-model="form.applyAmount" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="支付对象" :label-width="formLabelWidth">
          <el-input v-model="form.payObject" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="支付用途" :label-width="formLabelWidth">
          <el-input v-model="form.payUse" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="支付方式" :label-width="formLabelWidth">
          <el-select v-model="form.payWay" placeholder="--请选择--">
            <el-option label="转账支付" value="zhuanzhang"></el-option>
            <el-option label="现金支付" value="xianjin"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否符合审批或约定用途" :label-width="formLabelWidth">
          <el-select v-model="form.isFitDeal" placeholder="--请选择--">
            <el-option label="是" value="yes"></el-option>
            <el-option label="否" value="no"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="doSave">保 存</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryMoneyUse,addMoneyUse} from '@/api/afterloan'
  export default {
    name: "MoneyUseList",
    data() {
      return {
        entity: {},
        disableRowButtons:true,
        disableQueryButtons:true,
        dialogFormVisible: false,
        form: {
          payTime: '',
          applyAmount: '',
          payObject: '',
          payUse: '',
          //    delivery: false,
          payWay: [],
          isFitDeal: '',
          //  desc: '',
        },
        formLabelWidth: '80px',
        pageDef: {
          /*buttons: [
           // { label: '增加', funcName: 'add',disabled:false },
            { label: '删除', funcName: 'delete',disabled:true }
          ],*/
          // 查询条件定义
           queryDef: {

             },
          tabDef: {
            isSelect: true, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '支付时间', prop: 'payTime', isSort: true },
              { label: '支付金额', prop: 'applyAmount', isSort: true },
              { label: '支付对象', prop: 'payObject', isSort: true },
              { label: '支付用途', prop: 'payUse', isSort: true },
              { label: '支付方式', prop: 'payWay', isSort: true, isFormat: true,enumType:'payWay'},
              { label: '是否符合审批或约定用途', prop: 'isFitDeal', isSort: true }
            ],
          }

        }
      }
    },
    components: { CscSingleTable },
    methods: {
      doPageQuery(listQuery) {
        this.queryMoneyUse(listQuery)
      },

      queryMoneyUse(listQuery) {
        queryMoneyUse(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      },
      del(row, listQuery){
        if(row){
          alert('请选择一条记录');
          return;
        }
        deleteUser(row).then(response => {
          this.userList(listQuery);
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        })
      },
      dialogFormVisible(from){

      },
      doSave(){
        alert('进来没有！');
        console.log("传入参数1:"+JSON.parse(JSON.stringify(this.form)));
        addMoneyUse(this.form).then(response => {
          alert('进来没有1111！');
          this.$message({
            type: 'success',
            message: '保存成功!'
          });
          this.$router.back()
        })
      }
      /*rowDbclick(row) {
        this.$router.push({ path: '/user/add/card/' + row.userId })
      },

      create() {
        this.$router.push({ path: '/user/add' })
      },
      doEdit(row) {
        this.$router.push({ path: '/user/add/edit/' + row.userId })
      },
      doDelete(row, listQuery) {
        deleteUser(row).then(response => {
          this.userList(listQuery)
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        })
      }*/
    }
  }
</script>

<style scoped>

</style>


