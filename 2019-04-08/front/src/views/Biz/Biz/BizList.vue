<template>
  <div>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity"
  @view="view"     
  @bizApply="bizApply" 
  @newly="newly"
  @abandon="abandon"
  @adjust="adjust"
  @pageQuery="doPageQuery"
  :disableQueryForm="disableQueryForm"
  :disableRowButtons="disableRowButtons"  

  >
  </csc-single-table>
  <template>
    <el-dialog
      title="业务申请"
      :visible.sync="bizVisible"
      width="80%"
      append-to-body>
      <BizApplyZC v-bind:bizInfo="bizInfo" v-on:bizTree="bizTree"/>
    </el-dialog>
  </template>
    <!--失效界面-->
  <el-dialog title="新增" width="50%":visible.sync="abandonVisible"
             :close-on-click-modal="false">
    <el-row :gutter="20">
      <el-form :model="abandonForm" label-width="120px" ref="dataForm"
               label-position="right">
        <el-col :span="12">
          <el-form-item label="强制失效：">
            <el-checkbox v-model="isCheck"></el-checkbox>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="失效类型：" prop="type">
            <el-input v-model="abandonForm.type" placeholder="失效类型" disabled></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="失效原因：" prop="abandonReason">
            <el-input type="textarea" :rows="5" placeholder="请输入失效原因" v-model="abandonForm.abandonReason"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <div slot="footer" class="dialog-footer">
      <el-button  type="primary" @click.native="submitForm" :loading="editLoading">{{$t('action.submit')}}</el-button>
      <el-button @click.native="abandonVisible = false">{{$t('action.cancel')}}</el-button>
    </div>
  </el-dialog>
  </div>
</template>

<script>
  import BizApplyZC from '../BizApply/BizApplyZC'

  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import { getBizList, newly } from '@/api/csm'// 正常往后台发送异步请求的类


  export default {
    data() {
      return {
        isCheck:false,
        abandonVisible: false,
        bizVisible: false,
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        editLoading:false,
        bizInfo:{},
        entity: {

        },
        abandonForm: {
          type:'单笔业务失效'
        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 2, // 一行几列
            queryCols: [
            ]
          },
          tabDef: {
      
            isSelect: false, // 是否可以多选
            isCheckRadio:true,
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
            
              { label: '客户编号', prop: 'partyNum', isSort: true},
              { label: '客户名称', prop: 'partyName', isSort: true},
              { label: '业务编号', prop: 'bizNum', isSort: true,isLink: true,
              url:'/Biz/Biz/biz_info',param:["approveId"]},
              { label: '业务产品', prop: 'productType', isSort: true,isFormat:true,enumType:'productType'},
              { label: '业务类型', prop: 'bizHappenType', isSort: true,isFormat:true,enumType:'bizHappenType'},//XD_SXYW0001
              { label: '业务性质', prop: 'creditMode', isSort: true,isFormat:true,enumType:'creditMode' },//XD_BIZ0003
              { label: '银团', prop: 'isBankTeamLoan', isSort: true,isFormat:true,enumType:'isBankTeamLoan' },//XD_0002
              { label: '合同起期', prop: 'validDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true },
              { label: '业务金额（元）', prop: 'rmbAmt', isSort: true },
              { label: '可用金额（元）', prop: 'boUse', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true },
              { label: '经办机构', prop: 'orgNum', isSort: true },


            ]
          },
          buttons: [
            { label: '业务申请', funcName: 'bizApply',visible:false },
            { label: '查看', funcName: 'view' },
            
            { label: '失效', funcName: 'abandon' },
            { label: '调整', funcName: 'adjust' },
            { label: '重算额度', funcName: 'newly' },
            
            ]
        }
      }
    },

    components: { CscSingleTable, BizApplyZC}, // 这个没有问题

    methods: {

      doPageQuery(listQuery) {
        let query =  Object.assign({},listQuery,{partyId:""});
        //console.log('listQuery ....' + listQuery)
        getBizList(query).then((res) => {
            console.log(JSON.stringify(res))
            if(res && res.data && res.data.code == 200){//返回数据成功
              let myEntity = {};
              myEntity.total= res.data.data.total;
              myEntity.data = res.data.data.list;
              this.entity = myEntity;
              this.$store.dispatch('setListLoading', false);
            } else{
              this.$message({
                message: '查询自然人业务申请信息信息失败！',
                type: 'error'
              });
            }
            this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
          }).catch((res) => {
            this.$message({message: '初始查询自然人业务申请信息失败, 错误信息：' + res, type: 'error'})
            console.error('初始查询自然人业务申请信息失败, 错误信息：' + res)
          }).then(data!=null?data.callback:'')

      },
      // 调整
      adjust(row) {
        if(row.length == 0){
          alert("请选中一条记录");
        }else if(row.creditMode == "02"){
          alert("一体化用信数据无法调整");
        }else{
          this.$confirm('是否确定调整编号[' + row.bizNum + ']的业务信息？', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
            this.$message({
              message: '调整成功',
              type: 'success'
            });
            // 调用接口
            // adjust(row).then(res => {
            //   if(res && res.data && res.data.code == 200){
            //     this.$message({
            //       message: '调整成功',
            //       type: 'success'
            //     });
            //   } else{
            //     this.$message({
            //       message: '调整失败!'+JSON.stringify(response.data),
            //       type: 'error'
            //     });
            //   }
            // });
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消调整'
            })
          });
        }
      },
      view(row) {
        console.log('view 合同...'+JSON.stringify(row))

        console.log(row)
        //this.$router.push({path: '/Biz/Biz/biz_info',query:{approveId: "ff808081655f5cb801655f60dfd80029" }})//good work
        this.$router.push({name: '业务结构基本信息',params:{approveId:row.approveId }}) //nice work

    
      },
      newly(row) {
        if(row.length == 0){
          alert("请选中一条记录");
        }else{
          let data = {bizId:row.approveId};
          newly(data).then((res) => {
            console.log(JSON.stringify(res))
            if(res && res.data && res.data.code == 200){//返回数据成功
              this.$message({
                type: 'success',
                message: '重算额度成功!'
              });
              this.doPageQuery();
            } else{
              this.$message({
                message: res.data.msg,
                type: 'error'
              });
            }
          }).catch((res) => {
            this.$message({message: '重算额度失败, 错误信息：' + res, type: 'error'})
            console.error('重算额度失败, 错误信息：' + res)
          }).then(data!=null?data.callback:'')
        }
      },
      abandon(row) {
        if(row.length == 0){
          alert("请选择一笔授信");
        }else{
          this.$confirm('是否确定失效编号[' + row.bizNum + ']的授信信息？', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
            this.abandonVisible = true;
            // adjust(row).then(res => {
            //   if(res && res.data && res.data.code == 200){
            //     this.$message({
            //       message: '失效成功',
            //       type: 'success'
            //     });
            //   } else{
            //     this.$message({
            //       message: '失效失败!'+JSON.stringify(response.data),
            //       type: 'error'
            //     });
            //   }
            // });
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消失效'
            })
          });
        }
      },
      // 失效表单提交
      submitForm () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$confirm('确认提交吗？', '提示', {}).then(() => {
              this.editLoading = true;
              this.abandonVisible = false;
              this.$message({ message: '失效成功', type: 'success' });
              // let params = Object.assign({}, this.dataForm);
              // this.$api.cusManage_naturalCus.save(params).then((res) => {
              //   this.editLoading = false;
              //   if(res && res.data && res.data.code == 200) {
              //     this.$message({ message: '添加成功', type: 'success' });
              //     this.dialogVisible = false;
              //     this.viewVisible = true;
              //     this.handleType = 'add';
              //     this.$router.push({ path : '/cusManage/natureCus/natural/natural_info',
              //       query : { vueType:'add', partyId:res.data.partyId
              //       }
              //     });
              //     this.selectData = Object.assign({},res.data, this.dataForm);
              //     this.isCheck = false;
              //     this.$refs['dataForm'].resetFields();
              //   } else {
              //     this.$message({message: '添加失败, ' + res.data.msg, type: 'error'})
              //   }
              // }).catch((res) =>{
              //   console.error(JSON.stringify(res))
              // })

            })
          }
        })
      },
      bizApply(row) { 
       // console.log('bizApply 合同...'+JSON.stringify(row))
       // console.log(row)
       //  //this.$router.push({path: '/Biz/Biz/biz_info',query:{approveId: "ff808081655f5cb801655f60dfd80029" }})//good work
       //  this.$router.push({name: '业务申请新增',params:{approveId:row.approveId }}) //nice work
        this.bizVisible = true;

        this.bizInfo = {guarantyType:[],productType:'02002005',partyId:'ff8080816141a3ed016146824278236b',
          partyName:'乔臻傅',partyNum:'2020180130005239',certType:'10',certNum:'510282198011307887',
          creditLevel:'',creditMode:'03',bizHappenType:'10',partyTypeCd:'02',orgNum:'0700',userNum:'200555'};
        // this.bizInfo = Object.assign({},row,{guarantyType:[]});
      },
      bizTree(){
        this.bizVisible = false;
      },
      handleClose:function (done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
    },
    mounted() {				
      // this.doPageQuery(listQuery) // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
  }

  }
</script>
