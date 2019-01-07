<template>
    <div class="summary-info">
      <el-row :gutter="20" type="flex" justify="center" >
        <el-form label-width="120px" label-position="right">
          <el-col :span="24">
            <el-form-item label="抵质押物类别" >
              <el-input  v-model="grtCollateralInfo.collateralTypeCd" disabled="true" ></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="抵质押物编号" >
              <el-input  v-model="grtCollateralInfo.collateralNum" disabled="true"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="抵质押物名称" >
              <el-input  v-model="grtCollateralInfo.collateralName" disabled="true"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="抵质押人编号">
              <el-input  v-model="grtCollateralInfo.customerNum" disabled="true"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="建档日期" >
              <el-input  v-model="grtCollateralInfo.timeMark" disabled="true"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
    </div>
</template>

<script>
  import enums from "@/utils/enums"
  import commonUtil from '@/utils/commonUtil'
    export default {
        name: "summary-info",
      beforeMount(){
        //alert(JSON.stringify(enums.CollateralStatusCd));
        //alert(JSON.stringify(this.grtCollateralInfo));
        //alert(this.grtCollateralInfo.collateralTypeCd);
        //var obj = enums.CollateralStatusCd;
        //this.grtCollateralInfo.collateralTypeCd = enums.CollateralStatusCd[this.grtCollateralInfo.collateralTypeCd];
        this.grtCollateralInfo.timeMark = commonUtil.timeStampToDate(this.grtCollateralInfo.timeMark);
        },
      props:{
        grtCollateralInfo:{
          collateralTypeCd:'',//抵质押物类别
          collateralNum:'',//抵质押物编号
          collateralName:'',//抵质押物名称
          customerNum:'',//抵质押人编号
          timeMark:'',//建档日期
        },
      },
      methods:{

      },
      compute:{
          getTypeValue:function () {
            var value='';
            //value = enums.CollateralStatusCd[this.collateralTypeCd];
            alert(enums.CollateralStatusCd);
            alert(this.collateralTypeCd);
            return value;
          }
      },
    }
</script>

<style scoped>
  .summary-info{
    width:100%;
    height:100%;
  }
</style>
