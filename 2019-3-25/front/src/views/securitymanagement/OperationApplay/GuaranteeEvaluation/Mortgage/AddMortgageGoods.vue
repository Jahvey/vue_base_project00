<!--新增抵押品-->
<template>
  <div class="add-mortgage-goods">
    <el-container>
      <el-aside width="50%">
        <el-row>
          <p class="mortgage-title">选择抵押信息</p>
        </el-row>
        <el-row>
          <el-form label-position="right" label-width="125px">
            <el-col :span="18" :offset="6">
              <el-form-item label="客户类型" prop="customerType" >
                <el-radio-group v-model="customerType" disabled="true">
                  <el-radio :label="0">个人客户</el-radio>
                  <el-radio :label="6">对公客户</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
        <el-row>
          <el-col :span="24">
            <csc-single-table
              :pageDef="pageDef"
              :entity="entity"
              :disableRowButtons="disableRowButtons"
              :disableQueryForm="disableQueryForm"
              :disableQueryButtons="disableQueryButtons"
              @refresh="refresh"
              @choose="choose"
              @pageQuery="doPageQuery"
            >
            </csc-single-table>
          </el-col>
        </el-row>
      </el-aside>
      <el-main>
        <el-row>
          <p class="mortgage-title">补填抵押信息</p>
        </el-row>
        <el-row>
          <el-form el-form label-width="200px"  size="mini" :model="data" label-position="right" :rules="rules" ref="validate" >
            <el-col :span="24">
              <el-form-item label="抵质押人名称" prop="partyName">
                <el-input :disabled="inputComponentDisable" v-model="data.partyName"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="抵质押物名称" prop="collateralName">
                <el-input :disabled="inputComponentDisable" v-model="data.collateralName"></el-input>
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
              <el-form-item label="已设定担保额(元)" prop="setGuarantyAmt">
                <el-input :disabled="inputComponentDisable" v-model="data.setGuarantyAmt"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="抵质押品占用价值(元)" prop="mortgageValue">
                <el-input :disabled="inputComponentDisable2" v-model="data.mortgageValue"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="本次实际担保债权金额(元)" prop="suretyAmt">
                <el-input :disabled="inputComponentDisable2" v-model="data.suretyAmt"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="抵质押类型" prop="suretyType" >
                <el-select :disabled="inputComponentDisable"  v-model="data.suretyType" placeholder="请选择" style="width:100%">
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
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import { getCollateralList,saveMortgageBasic} from '@/api/securitymanagement'
  import enums from "@/utils/enums"
    export default {
      name: "add-mortgage-goods",
      props:{
        info:{
          type:Object,
        },
      },
      data(){
        return{
          /*提交后台数据*/
          data:{
            partyName:"",//抵质押人
            collateralName:"",//抵质押物名称
            currencyCd:"",//币种
            marketValue:"",//抵质押物认定价值(元)
            setGuarantyAmt:"",//已设定担保额(元)
            mortgageValue:"",//抵质押品占用价值(元)
            suretyAmt:"",//本次实际担保债权金额(元)
            suretyId:"",//抵质押物id
            applyId:this.info.applyId,//业务id
            suretyType:"",//抵质押类型
          },
          rules:{
            partyName:[
              {
                required: true,
                message: "抵质押人不能为空",
                trigger: 'change'
              },
            ],
            collateralName:[
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
            setGuarantyAmt:[
              {
                required: true,
                message: "已设定担保额不能为空",
                trigger: 'change'
              },
            ],
            mortgageValue:[
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
            suretyType:[
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
          /*表格数据*/
          customerType:"02",//自然人客户02，公司客户01
          entity: {},
          disableRowButtons:true,//显示查询删除按钮
          disableQueryForm:false,//禁止查询表单
          disableQueryButtons:false,//不显示刷新重置按钮
          pageDef: {
            queryDef: {
              columnNum:2, //一行几列
              queryCols: [
                {label: "抵质押人", inputType: "input", modelName: "partyName"},
                /*{label: "证件类型", inputType: "select", modelName: "certType",enumType:"idTypeCd"},*/
                {label: "证件号码", inputType: "input", modelName: "certNum"},
              ]
            },
            tabDef: {
              isSelect: false, //是否可以多选
              isIndex: false,  //是否有序号
              isCheckRadio:true,//是否单选
              //表格字段定义
              tabCols: [
                {label: "抵质押人名称", prop: "partyName",},
                {label: "抵质押物名称", prop: "collateralName"},
                {label: "抵质押物类型", prop: "collateralTypeCd",isFormat: true,enumType:'CollateralStatusCd'},
                {label: "币种", prop: "currencyCd",isFormat: true,enumType:'currencyCd'},
                {label: "抵质押物认定价值(元)", prop: "marketValue",},
                {label: "已设定担保额(元)", prop: "setGuarantyAmt",},
              ]
            },
            buttons: [
              {label: "选择", funcName: "choose", disabled: false},
            ]
          },
        }
      },
      methods:{
        doPageQuery(listQuery){
          listQuery.customerType = this.customerType;
          listQuery.mpType = '01';//只查询抵押物
          listQuery.pageNum=1;
          listQuery.pageSize=10;
          getCollateralList(listQuery).then(response => {
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
        choose(row){//选择
          if(row.length<=0){
            this.$message({
              message: '请选择要操作的数据!',
              type: 'error'
            });
            return;
          }
          this.data.suretyId = row.guarantyId;
          this.data.partyName = row.partyName;
          this.data.collateralName = row.collateralName;
          this.data.currencyCd = row.currencyCd;
          this.data.marketValue = row.marketValue;
          this.data.setGuarantyAmt = row.setGuarantyAmt;
          this.data.suretyType = row.mpType;
        },
        comfirm(){
          this.$refs["validate"].validate((valid) => {
            if(valid){
              if(Number(this.data.mortgageValue) >　Number(this.data.marketValue)-Number(this.data.setGuarantyAmt)){
                this.$message({
                  message: '抵质押品占用价值不能大于：'+(Number(this.data.marketValue)-Number(this.data.setGuarantyAmt))+'元',
                  type: 'error'
                });
                return;
              }
              if(Number(this.data.suretyAmt)>Number(this.data.mortgageValue)){
                this.$message({
                  message: '抵质押品占用价值不能大于本次实际担保债权金额',
                  type: 'error'
                });
                return;
              }
              if(Number(this.data.suretyAmt) / Number(this.data.mortgageValue) >= 0.9){
                this.$message({
                  message: '抵质押率不能超过90%',
                  type: 'error'
                });
                return;
              }
              this.buttonDisable = true;
              this.buttonText = "";
              this.isLoading = true;
              saveMortgageBasic(this.data).then(response => {
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

<style >
  .add-mortgage-goods .el-aside {
    border-right: 1px solid #cccccc;
  }
  .add-mortgage-goods .mortgage-title{
    margin:0px 0px 10px 0px;
    padding: 0px;
    font-size: 18px;
    font-weight: bold;
    text-align: center;
  }
  .add-mortgage-goods .el-main{
    padding: 0px;
  }
  .add-mortgage-goods .app-container{
    padding:0px 10px;
  }
</style>
