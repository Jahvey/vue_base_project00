<template>
  <div>
    <el-row>
      <el-form el-form label-width="200px"  size="mini" :model="data" label-position="right" :rules="rules" ref="validate" >
        <el-col :span="24">
          <el-form-item label="抵质押人名称" prop="partyName">
            <el-input :disabled="inputComponentDisable" v-model="data.partyName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="抵质押物名称" prop="suretyName">
            <el-input :disabled="inputComponentDisable" v-model="data.suretyName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="data.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyCd" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue">
            <el-input :disabled="inputComponentDisable" v-model="data.marketValue"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="已设定担保额(元)" prop="usedAmt">
            <el-input :disabled="inputComponentDisable" v-model="data.usedAmt"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="抵质押品占用价值(元)" prop="totalKhAmt">
            <el-input :disabled="inputComponentDisable2" v-model="data.totalKhAmt"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="本次实际担保债权金额(元)" prop="suretyAmt">
            <el-input :disabled="inputComponentDisable2" v-model="data.suretyAmt"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="抵质押类型" prop="collType" >
            <el-select :disabled="inputComponentDisable"  v-model="data.collType" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in collTypeCd" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="12" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="comfirm" :loading="isLoading">{{buttonText}}</el-button>
        <el-button size="medium"  type="primary" @click="close">关闭</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import { selectMortgageBasicBySuretyId,updateMortgageBasic} from '@/api/securitymanagement'
  import enums from "@/utils/enums"
    export default {
      name: "edit-mortgage-goods",
      props:{
        info:{
          type:Object,
        },
      },
      beforeMount(){
        //回显数据
        this.buttonDisable = true;
        this.buttonText = "";
        this.isLoading = true;
        if(this.info.isScan){
          this.inputComponentDisable2 = true;
          this.buttonDisable = true;
          this.buttonText = "保存";
          this.isLoading = false;
        }
        selectMortgageBasicBySuretyId(this.info).then(response=>{
          if(response.data.flag == enums.stateCode.flag.success) {//返回数据成功
            this.data.partyId = response.data.mortgageBasicBean.partyId;
            this.data.partyName = response.data.mortgageBasicBean.partyName;
            this.data.suretyName = response.data.mortgageBasicBean.suretyName;
            this.data.currencyCd = response.data.mortgageBasicBean.currencyCd;
            this.data.marketValue = response.data.mortgageBasicBean.marketValue;
            this.data.usedAmt = response.data.mortgageBasicBean.usedAmt;
            this.data.collType = response.data.mortgageBasicBean.collType;
            this.data.suretyNo = response.data.mortgageBasicBean.suretyNo;
            this.data.sortType = response.data.mortgageBasicBean.sortType;
            this.data.assessValue = response.data.mortgageBasicBean.assessValue;
            this.data.ifOtherCommon = response.data.mortgageBasicBean.ifOtherCommon;
            this.data.mybankSetValue = response.data.mortgageBasicBean.mybankSetValue;
            this.data.totalKhAmt = response.data.mortgageBasicBean.totalKhAmt;
            this.data.suretyAmt = response.data.mortgageBasicBean.suretyAmt;
            this.data.suretyId = response.data.mortgageBasicBean.suretyId;
            this.data.relationId = response.data.mortgageBasicBean.relationId;
            this.buttonDisable = false;
            this.buttonText = "保存";
            this.isLoading = false;
          }else{
            this.$message({
              message: '获取数据失败啦！'+JSON.stringify(response.data),
              type: 'error'
            });
          }
          if(this.info.isScan){
            this.buttonDisable = true;
            this.buttonText = "保存";
            this.isLoading = false;
          }
        });
      },
      data(){
        return{
          /*提交后台数据*/
          data:{
            partyId:"",//抵质押人id
            partyName:"",//抵质押人
            suretyName:"",//抵质押物名称
            currencyCd:"",//币种
            marketValue:"",//抵质押物认定价值(元)
            usedAmt:"",//已设定担保额(元)
            totalKhAmt:"",//抵质押品占用价值(元)
            suretyAmt:"",//本次实际担保债权金额(元)
            collType:"",//抵质押类型
            suretyNo:"",//抵质押物编号
            suretyId:"",//抵质押物id
            applyId:this.info.applyId,//业务id
            relationId:"",//押品关联主键
            userNum:"200555",
            orgNum:"0700",
            sortType:"",//抵质押物类型
            assessValue:"",//评估价值
            ifOtherCommon:"",//是否有共有人
            mybankSetValue:"",//我行已设定担保额
          },
          rules:{
            partyName:[
              {
                required: true,
                message: "抵质押人不能为空",
                trigger: 'change'
              },
            ],
            suretyName:[
              {
                required: true,
                message: "抵质押物名称不能为空",
                trigger: 'change'
              },
            ],
            currencyCd:[
              {
                required: true,
                message: "请选择币种",
                trigger: 'change'
              },
            ],
            marketValue:[
              {
                required: true,
                message: "抵质押物认定价值不能为空",
                trigger: 'change'
              },
            ],
            usedAmt:[
              {
                required: true,
                message: "已设定担保额不能为空",
                trigger: 'change'
              },
            ],
            totalKhAmt:[
              {
                required: true,
                message: "抵质押品占用价值不能为空",
                trigger: 'change'
              },
              {
                max: 20,
                message: '长度不超过 20 个字符',
                trigger: 'change'
              },
              {
                pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
                message: '请输入正确的金额',
                trigger: 'change'
              }
            ],
            suretyAmt:[
              {
                required: true,
                message: "本次实际担保债权金额不能为空",
                trigger: 'change'
              },
              {
                max: 20,
                message: '长度不超过 20 个字符',
                trigger: 'change'
              },
              {
                pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
                message: '请输入正确的金额',
                trigger: 'change'
              }
            ],
            collType:[
              {
                required: true,
                message: "请选择抵质押类型",
                trigger: 'change'
              },
            ],
          },
          /*按钮数据*/
          buttonText:"保存",
          buttonDisable:false,
          isLoading:false,//按钮提交状态
          inputComponentDisable:true,
          inputComponentDisable2:false,
          currencyCd:enums.currencyCd,
          collTypeCd:enums.collTypeCd1,
        }
      },
      methods:{
        comfirm(){
          this.$refs["validate"].validate((valid) => {
            if(valid){
              if(Number(this.data.totalKhAmt) >　Number(this.data.marketValue)-Number(this.data.usedAmt)){
                this.$message({
                  message: '抵质押品占用价值不能大于：'+(Number(this.data.marketValue)-Number(this.data.usedAmt))+'元',
                  type: 'error'
                });
                return;
              }
              if(Number(this.data.suretyAmt)>Number(this.data.totalKhAmt)){
                this.$message({
                  message: '抵质押品占用价值不能大于本次实际担保债权金额',
                  type: 'error'
                });
                return;
              }
              if(Number(this.data.suretyAmt) / Number(this.data.totalKhAmt) >= 0.9){
                this.$message({
                  message: '抵质押率不能超过90%',
                  type: 'error'
                });
                return;
              }
              this.buttonDisable = true;
              this.buttonText = "";
              this.isLoading = true;
              updateMortgageBasic(this.data).then(response => {
                if(response.data.flag == enums.stateCode.flag.success) {//返回数据成功
                  this.$emit('backFlag',"ok");
                  this.$message({
                    message: '数据提交成功！',
                    type: 'success'
                  });
                }else{
                  this.$message({
                    message: '获取数据失败啦！'+JSON.stringify(response.data),
                    type: 'error'
                  });
                  this.buttonDisable = false;
                  this.buttonText = "提交";
                  this.isLoading = false;
                }
              });
            } else{
              this.$message({
                message: '请将信息填写完整',
                type: 'error'
              });
            }
          });
        },
        close:function () {
          this.$refs["validate"].resetFields();
          this.$emit('backFlag',"close");
        }
      },
    }
</script>

<style scoped>

</style>
