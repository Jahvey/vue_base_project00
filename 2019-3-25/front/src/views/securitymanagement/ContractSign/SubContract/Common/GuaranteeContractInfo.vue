<!--担保合同信息详情tab页面-->
<template>
  <el-row>
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <template v-if="currentPage == 'mortgage'">
        <el-tab-pane label="抵押合同基本信息" name="a"><editMortgageContractBasicInfo v-bind:info="info"/></el-tab-pane>
        <el-tab-pane label="押品关联信息" name="b"><mortgageRelInfo v-bind:info="info"/></el-tab-pane>
      </template>
      <template v-if="currentPage == 'pledge'">
        <el-tab-pane label="质押合同基本信息" name="c"><editPledgeContractBasicInfo v-bind:info="info"/></el-tab-pane>
        <el-tab-pane label="押品关联信息" name="d"><pledgeRelInfo v-bind:info="info"/></el-tab-pane>
      </template>
      <template v-if="currentPage == 'guarantor'">
        <el-tab-pane label="保证人基本信息" name="e"><editGuarantorContractBasicInfo v-bind:info="info"/></el-tab-pane>
        <el-tab-pane label="保证人关联信息" name="f"><guarantorRelInfo v-bind:info="info"/></el-tab-pane>
      </template>
      <template v-if="currentPage == 'deposit'">
        <el-tab-pane label="保证金协议基本信息" name="g"><editDepositContractBasicInfo v-bind:info="info"/></el-tab-pane>
        <el-tab-pane label="保证金关联信息" name="h"><depositRelInfo v-bind:info="info"/></el-tab-pane>
      </template>
    </el-tabs>
  </el-row>
</template>

<script>
  import editMortgageContractBasicInfo from '../MortgageContract/EditMortgageContractBasicInfo'
  import mortgageRelInfo from '../MortgageContract/MortgageRelInfo'
  import pledgeRelInfo from '../PledgeContract/PledgeRelInfo'
  import editPledgeContractBasicInfo from '../PledgeContract/EditPledgeContractBasicInfo'
  import editGuarantorContractBasicInfo from '../GuarantorContract/EditGuarantorContractBasicInfo'
  import guarantorRelInfo from '../GuarantorContract/GuarantorRelInfo'
  import editDepositContractBasicInfo from '../DepositContract/EditDepositContractBasicInfo'
  import depositRelInfo from '../DepositContract/DepositRelInfo'
    export default {
      props:{
        info:{
          type:Object,
        },
      },
      components:{
        editMortgageContractBasicInfo,
        mortgageRelInfo,
        editPledgeContractBasicInfo,
        pledgeRelInfo,
        editGuarantorContractBasicInfo,
        guarantorRelInfo,
        editDepositContractBasicInfo,
        depositRelInfo,
      },
      beforeMount(){
        this.currentPage = this.info.page;
        if(this.currentPage=='mortgage'){
          this.activeName = 'a';
        } else if(this.currentPage=='pledge'){
          this.activeName = 'c';
        } else if(this.currentPage=='guarantor'){
          this.activeName = 'e';
        } else if(this.currentPage=='deposit'){
          this.activeName = 'g';
        }
      },
      name: "guarantee-contract-info",
      data() {
        return {
          activeName: 'a',//当前选中
          currentPage:"",//当前抵押合同，质押合同，保证合同，保证金
        };
      },
      methods: {
        handleClick(tab, event) {
          console.log(tab, event);
        }
      }
    }
</script>

<style scoped>

</style>
