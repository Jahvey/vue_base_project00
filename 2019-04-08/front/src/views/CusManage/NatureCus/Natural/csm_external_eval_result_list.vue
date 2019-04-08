<template>
  <div class="app-container">
    <el-row class="warp">
      <el-col :span="24">
        <fieldset>
          <legend>基本信息：</legend>
          <el-form ref="dashboard" :model="party" label-width="140px">
            <el-col :span="12">
              <el-form-item label="客户编号" prop="partyNum">
                <el-input v-model="party.partyNum" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="客户名称" prop="partyName">
                <el-input v-model="party.partyName" disabled></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </fieldset>
        <fieldset>
          <legend>评级历史信息：</legend>
          <csc-single-button-table
            :pageDef="pageDef"
            :entity="entity"
            :disableQueryForm="disableQueryForm"
            @pageQuery="doPageQuery"
          >
          </csc-single-button-table>
        </fieldset>
      </el-col>
    </el-row>
  </div>
</template>
<script>
  import {isEmpty} from "@/utils/validate"

  export default {
    data(){
      return {
        disableQueryForm:true,
        party: {
          partyName: '',
          partyNum: ''
        },
        entity: {},
        selectedRow:{},
        pageDef: {
          queryDef: {
          },
          tabDef: {
            isSelect: false, //是否可以多选
            isIndex: true,  //是否有序号
            //表格字段定义
            tabCols: [
              {label: "客户名称", prop: "partyName"},
              {label: "评级日期", prop: "ratingDt"},
              {label: "贷款性质", prop: "ratingType"},
              {label: "信用等级", prop: "creditRatingCd"},
              {label: "起始日期", prop: "effectiveStartDt"},
              {label: "到期日期", prop: "effectiveEndDt"},
              {label: "是否有效评级", prop: "ratingState"},
              {label: "经办人", prop: "userNum"},
              {label: "经办机构", prop: "orgNum"}
            ]
          },
          buttons: [],
          rowButtons:[
            {label:"查看",type:"success",funcName:"doView",visible:true}
          ]
        }
      }
    },
    methods: {
      doPageQuery(listQuery){
        let query =  Object.assign({},listQuery,{partyId:this.$route.query.rowData.partyId});
        this.$api.cusManage_naturalCus.getInternalRatingResultList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询评级信息信息失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询评级信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询评级信息失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      },
      doView(row){
       //查看评级报告页面
      },
    },
    mounted() {
      this.party.partyName = this.$route.query.rowData.partyName;
      this.party.partyNum = this.$route.query.rowData.partyNum;
    }
  }
</script>
