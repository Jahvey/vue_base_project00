<!--共有人信息-->
<template>
    <div class="mp-part-owner-info">
        <el-row>
          <p>共有人信息</p>
        </el-row>
        <el-row>
          <csc-single-table
            :pageDef="pageDef"
            :entity="entity"
            :disableRowButtons="disableRowButtons"
            :disableQueryForm="disableQueryForm"
            :disableQueryButtons="disableQueryButtons"
            @add="doAdd"
            @deleteBatch="deleteBatch"
            @refresh="refresh"
            @doEdit="doEdit"
            @pageQuery="doPageQuery"
            @rowChange="rowChange"
            @doDelete="doDelete"
            @rowDbclick="rowDbclick"
          >
          </csc-single-table>
        </el-row>
        <template>
          <el-dialog
            title="添加共有人信息"
            :visible.sync="dialogVisible"
            width="80%"
            :before-close="handleClose"
            append-to-body>
            <addPartOwnerInfo v-on:backFlag="getMsg" v-bind:info="info"/>
          </el-dialog>
        </template>

      <template>
        <el-dialog
          title="更新共有人信息"
          :visible.sync="dialogVisible2"
          width="80%"
          :before-close="handleClose"
          append-to-body>
          <editPartOwnerInfo v-on:backFlag="getMsg2" v-bind:grtTogetherCorrelative="grtTogetherCorrelative"/>
        </el-dialog>
      </template>
    </div>
</template>

<script>
  import addPartOwnerInfo from './addPartOwnerInfo'
  import editPartOwnerInfo from './editPartOwnerInfo'
  import { getAllTogetherCorrelative,deleteTogetherCorrelativeById,deleteTogetherCorrelativedBatch} from '@/api/securitymanagement'
  import enums from "@/utils/enums"
    export default {
        name: "mp-part-owner-info",
      props:{
        info:Object,
      },
      components:{
        addPartOwnerInfo,
        editPartOwnerInfo
      },
      data() {
        return {
          entity: {},
          disableRowButtons:false,//显示查询删除按钮
          disableQueryForm:true,//禁止查询表单
          disableQueryButtons:true,//不显示刷新重置按钮
          selectedRow:{},
          pageDef: {
            queryDef: {
              columnNum: 3, //一行几列
              queryCols: [
                {label: "共有人姓名", inputType: "input", modelName: "togetherCorrelativeName"},
                {label: "证件号码", inputType: "input", modelName: "togetherCertificateNum"},
                {label: "共有人证件类型", inputType: "select", modelName: "togetherCertificateType",enumType:"idTypeCd"},
              ]
            },
            tabDef: {
              isSelect: true, //是否可以多选
              isIndex: false,  //是否有序号
              //表格字段定义
              tabCols: [
                {label: "共有人姓名", prop: "togetherCorrelativeName"},
                {label: "共有人证件类型", prop: "togetherCertificateType",isFormat: true,enumType:"idTypeCd"},
                {label: "证件号码", prop: "togetherCertificateNum"},
              ]
            },
            buttons: [
              {label: "新增", funcName: "add", disabled: false},
              {label: "批量删除", funcName: "deleteBatch", disabled: false},
              {label: "刷新", funcName: "refresh", disabled: false},
            ]
          },
          multipleSelection: [],
          buttonAdd: "新增",
          buttonDelete: "删除",
          dialogVisible: false,//添加共有人dialog
          dialogVisible2: false,//更新共有人dialog
          grtTogetherCorrelative:{},
        }
      },
      methods: {
        rowChange(row){
          this.selectedRow = row;
          //this.$emit('customerInfo',row);
        },
        doPageQuery(listQuery){
          listQuery.guarantyId = this.info.guarantyId;
          getAllTogetherCorrelative(listQuery).then(response => {
            if(response.data.flag == enums.stateCode.flag.success){//返回数据成功
              var myEntity = {};
              myEntity.total=response.data.data.total;
              myEntity.data = response.data.data.list;
              this.entity = myEntity;
              this.$store.dispatch('setListLoading', false);
            } else{
              this.$message({
                message: '获取数据失败啦！',
                type: 'error'
              });
            }
          })
        },
        doAdd(){
          this.dialogVisible = true;
        },
        doEdit(row){
          this.dialogVisible2 = true;
          this.grtTogetherCorrelative = row;
          //this.$router.push({ name: 'orgEdit', query: { orgInfoId: row.orgInfoId,method:'doEdit' }})
        },
        refresh(){
          var listquery = {};
          listquery.guarantyId = this.info.guarantyId;
          this.$store.dispatch('setListLoading', true);
          this.doPageQuery(listquery);
        },
        deleteBatch(row,listquery,index){
          if(row.length<=0){
            this.$message({
              message: '请选择要删除的数据!',
              type: 'error'
            });
            return;
          }
          this.$confirm('此操作将永久删除该单据, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
             deleteTogetherCorrelativedBatch(row).then(response => {
                if(response.data.flag == enums.stateCode.flag.success){//
                  this.$message({
                    message: '删除成功',
                    type: 'success'
                  });
                  this.$store.dispatch('setListLoading', true);
                  this.doPageQuery(listquery);
                } else{
                  this.$message({
                    message: '删除失败!'+JSON.stringify(response.data),
                    type: 'error'
                  });
                }
              });
            }).catch(() => {
             this.$message({
                type: 'info',
                message: '已取消删除'
              })
            });
        },
        doDelete(row,listquery,index){
         deleteTogetherCorrelativeById(row).then(response => {
           if(response.data.flag == enums.stateCode.flag.success){//
             this.$message({
               message: '删除机构信息成功',
               type: 'success'
             });
             this.$store.dispatch('setListLoading', true);
             this.doPageQuery(listquery);
           } else{
             this.$message({
               message: '删除失败!'+JSON.stringify(response.data),
               type: 'error'
             });
           }
          });
        },
        rowDbclick(row){
          this.$router.push({ name: 'orgEdit', query: { orgInfoId: row.orgInfoId,method:'detail' }})
        },
        handleClose: function (done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              done();
            })
            .catch(_ => {
            });
        },
        getMsg: function (flag) {
          if (flag === 'ok') {
            this.dialogVisible = false;
            var listquery = {};
            listquery.pageNum=1;
            listquery.pageSize=20;
            listquery.guarantyId = this.info.guarantyId;
            this.$store.dispatch('setListLoading', true);
            this.doPageQuery(listquery);
          }
        },
        getMsg2: function (flag) {
          if (flag === 'ok') {
            this.dialogVisible2 = false;
            var listquery = {};
            listquery.pageNum=1;
            listquery.pageSize=20;
            listquery.guarantyId = this.info.guarantyId;
            this.$store.dispatch('setListLoading', true);
            this.doPageQuery(listquery);
          }
        },

      },
    }
</script>

<style scoped>
  .mp-part-owner-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-part-owner-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
  .el-pagination{
    margin:10px 0;
    text-align: center;
  }
  .part-owner-t .el-button + .el-button{
    margin-left:0px;
  }
  .part-owner-t .el-button--mini{
    padding: 6px;
  }
</style>
