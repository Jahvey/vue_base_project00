<template>

<el-row :gutter="20" class="form">

<el-form label-width="200px"  size="medium">
<div id="loanrate" >

<el-col :span="12">
    <el-form-item label="垫款日利率(万分之):" prop="dkll" class="special-input">
    <el-input v-model="dkll" style="width:100%" ></el-input>
    
    </el-form-item>
</el-col>


</div>

    <!-- <el-row align="middle" class="bottomBtn">
        <el-col align="center" >
        <el-button size="medium" type="primary" @click="test1">保存11</el-button>

        </el-col>
    </el-row> -->

</el-form>
 </el-row>

</template>


<script>

export default {
    name:'conDkllRate',
    // components: {
 
    // },
    props:{
        conDetailHtData:{ //这个是有关父子传参的工作

        }
    },
    data(){
       return{
           dkll:''

       }
    },
    created(){
        console.log("[接受到了参数]"+JSON.stringify(this.conDetailHtData))
        this.dkll="abcd"
    },

    methods: {
        test1(){
            console.log("test1")
            this.conDetailHtData.visiable=false
            this.$emit("conDetailHtData",this.conDetailHtData)
        }


    }
    
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .form {
    margin-top: 20px;
    margin-right: 20px
  }
  .bottomBtn {
  margin-top: 10px;
}
</style>


