<!--添加保证人页面-->
<template>
  <div class="add-guarantor">
    <el-row>
      <el-form el-form label-width="125px"  size="mini" :model="data" label-position="right" :rules="rules" ref="validate" >
        <el-col :span="12">
          <el-form-item label="保证人名称" prop="partyName" class="special-input">
            <el-input :readonly="readOnlyDisable" v-model="data.partyName"></el-input>
            <el-button type="primary" icon="el-icon-search" size="mini" class="special-button" @click="queryCustomer"></el-button>
          </el-form-item>
        </el-col>
        <template v-if="isNaturalCustomer">
          <el-col :span="12">
            <el-form-item label="证件类型" prop="certType" >
              <el-select :disabled="inputComponentDisable"  v-model="data.certType" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in idTypeCd" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="证件号码" prop="certNum" >
              <el-input :readonly="readOnlyDisable" v-model="data.certNum" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <template v-else>
          <el-col :span="12">
            <el-form-item label="营业执照" prop="registrCd" >
              <el-input :readonly="readOnlyDisable" v-model="data.registrCd" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="组织机构代码" prop="orgRegisterCd" >
              <el-input :readonly="readOnlyDisable" v-model="data.orgRegisterCd" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="信用等级" prop="marketValue" >
            <el-input :readonly="readOnlyDisable" v-model="data.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否担保公司" prop="isGuaranteeCompany" >
            <el-select :disabled="inputComponentDisable"  v-model="data.isGuaranteeCompany" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in commonYesAndNotCd" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="data.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyCd" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="isGuaranteeCorporation">
          <el-col :span="12">
            <el-form-item label="担保额度起期" prop="beginDate" >
              <el-date-picker :editable="false" :readonly="readOnlyDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.beginDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="担保额度止期" prop="endDate" >
              <el-date-picker :editable="false" :readonly="readOnlyDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.endDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="授信额度" prop="creditAmount" >
              <el-input :readonly="readOnlyDisable" v-model="data.creditAmount" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="单户总额" prop="simpleAmount" >
              <el-input :readonly="readOnlyDisable" v-model="data.simpleAmount" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="保证金存储方式" prop="accnoWay" >
              <el-checkbox-group v-model="data.accnoWay">
                <el-checkbox label="A01" name="accnoWay">大保证金</el-checkbox>
                <el-checkbox label="A02" name="accnoWay">小保证金</el-checkbox>
                <el-checkbox label="A03" name="accnoWay">存单</el-checkbox>
              </el-checkbox-group>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合作状态" prop="creditStatus" >
              <el-select :disabled="inputComponentDisable"  v-model="data.creditStatus" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in creditStatus" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="性质" prop="creditType" >
              <el-select :disabled="inputComponentDisable"  v-model="data.creditType" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in creditType" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="责任分担比例" prop="creditApport" >
              <el-input :readonly="readOnlyDisable" v-model="data.creditApport" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="预用担保金额(元)" prop="useAmt" >
              <el-input :disabled="inputComponentDisable" v-model="data.useAmt" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="已担保金额(元)" prop="usedAmt" >
              <el-input :disabled="inputComponentDisable" v-model="data.usedAmt" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="可用保证金额(元)" prop="aviAmt" >
              <el-input :disabled="inputComponentDisable" v-model="data.aviAmt" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="申请担保金额(元)" prop="suretyAmt" >
            <el-input  v-model="data.suretyAmt" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <template v-if="isGuaranteeCorporation">
      <el-row>
        <p class="m-t-b-0">担保公司账户信息</p>
        <el-col :span="24">
          <csc-single-table
            :pageDef="pageDef"
            :entity="entity"
            :disableRowButtons="disableRowButtons"
            :disableQueryForm="disableQueryForm"
            :disableQueryButtons="disableQueryButtons"
            @refresh="refresh"
            @pageQuery="doPageQuery"
          >
          </csc-single-table>
        </el-col>
      </el-row>
    </template>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="comfirm" :loading="isLoading">{{buttonText}}</el-button>
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="close">关闭</el-button>
      </el-col>
    </el-row>
    <el-dialog
      :title="dialogTitle"
      :visible.sync="dialogVisible"
      width="80%"
      v-if='dialogVisible'
      :fullscreen="fullScreen"
      :before-close="handleGoodsDetailInfoClose"
      append-to-body>
      <customerTable v-on:backData='getMsg'/>
    </el-dialog>
  </div>
</template>

<script>
  import customerTable from './CustomerTable'
  import { getPartyInfoByPartyId,queryApplyInfoByApplyId,queryCompanyStatus,addGuaranteeApplyTbGrtGuaranteer,selectGuaranteeConZh} from '@/api/securitymanagement'
  import enums from "@/utils/enums"
    export default {
      name: "AddGuarantor",
      components:{
        customerTable
      },
      props:{
        info:{
          type:Object,
        },
      },
      beforeMount(){
        //查询业务发生方式，业务申请金额
        var param = {applyId:this.info.applyId};
        queryApplyInfoByApplyId(param).then(response => {
          if(response.data.flag == enums.stateCode.flag.success){//返回数据成功
              this.bizHappenType = response.data.bizApply.bizHappenType;
              this.rmb = response.data.bizApply.rmbAmt;
              this.buttonDisable = false;
              console.log("申请金额:"+this.rmb);
          } else{
            this.$message({
              message: '获取数据失败啦！'+JSON.stringify(response.data),
              type: 'error'
            });
          }
        })
      },
      data(){
          return{
            /*业务信息*/
            bizHappenType:"",//业务发生方式
            rmb:"",//业务申请金额
            /**/
            isNaturalCustomer:true,//是否自然人客户
            dialogVisible:false,//对话框
            fullScreen:true,//是否全屏
            dialogTitle:'选择保证人',
            buttonText:"保存",
            buttonDisable:true,
            isLoading:false,//按钮提交状态
            /*保证人信息*/
            data:{
              applyId:this.info.applyId,
              userNum:"200555",
              orgNum:"0700",
              guarantorPartyId:"",//担保客户id
              partyName:"",//保证人称
              certType:"",//证件类型
              certNum:"",//证件号码
              registrCd:"",//营业执照
              orgRegisterCd:"",//组织机构代码
              thirdCustTypeCd:"",//第三方公司类型，关注担保值为：1
              //grtGuaranteeBasic
              isGuaranteeCompany:"",//是否担保公司
              currencyCd:"CNY",
              accnoWay:[],//保证金存储方式
              suretyAmt:"",//担保金额
              guaranteeForm:"",//保证担保形式:01阶段性担保02全程担保(:XD_DBCD4005)
              //tbCrdThirdPartyLimit
              beginDate:"",//担保额度起期
              endDate:"",//担保额度止期
              //tbConGuarantOrgInfo
              creditAmount:"",//授信额度
              creditStatus:"",//合作状态
              creditType:"",//性质
              creditApport:"",//责任分担比例
              simpleAmount:"",//单户总额
              //party
              useAmt:"",//预用担保金额
              usedAmt:"",//已担保金额
              aviAmt:"",//可用保证金额
            },
            rules:{
              partyName:[
                {
                  required: true,
                  message: "请选择担保人",
                  trigger: 'change'
                },
              ],
              accnoWay:[
                {
                  type: 'array', required: true, message: '请至少选择一个保证金存储方式', trigger: 'change'
                },
              ],
              suretyAmt:[
                {
                  required: true,
                  message: "请输入申请担保金额",
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

            },
            readOnlyDisable:true,
            inputComponentDisable:true,
            idTypeCd:enums.idTypeCd,
            currencyCd:enums.currencyCd,
            commonYesAndNotCd:enums.yesOrNo,
            creditType:enums.creditType,
            creditStatus:enums.creditStatus,
            /*担保公司账户信息--表格*/
            isGuaranteeCorporation:false,//是否担保公司
            entity: {},
            disableRowButtons:true,//显示查询删除按钮
            disableQueryForm:true,//禁止查询表单
            disableQueryButtons:true,//不显示刷新重置按钮

            pageDef: {
              queryDef: {
                columnNum:0, //一行几列
                queryCols: [
                  {label: "开户行", inputType: "input", modelName: "zhkhjg"},
                ]
              },
              tabDef: {
                isSelect: false, //是否可以多选
                isIndex: true,  //是否有序号
                //表格字段定义
                tabCols: [
                  {label: "账户类型", prop: "zhlx",isFormat: true,enumType:'zhlxCd'},
                  {label: "账号", prop: "zh"},
                  {label: "账户名称", prop: "zhmc",},
                  {label: "开户行", prop: "zhkhjg",},
                  {label: "账户状态", prop: "accStatus",},
                ]
              },
              buttons: [
                {label: "刷新", funcName: "refresh", disabled: false},
              ]
            },
          }
      },
      methods:{
        doPageQuery(listQuery){
          listQuery.statusCd = '03';
          listQuery.partyId = this.data.guarantorPartyId;
          if(this.isGuaranteeCorporation){
            selectGuaranteeConZh(listQuery).then(response => {
              if(response.data.flag == enums.stateCode.flag.success){//返回数据成功
                var myEntity = {};
                myEntity.total=response.data.data.total;
                myEntity.data = response.data.data.list;
                this.entity = myEntity;
                this.$store.dispatch('setListLoading', false);
              } else{
                this.$message({
                  message: '获取数据失败啦！'+JSON.stringify(response.data),
                  type: 'error'
                });
              }
            });
          }
        },
        queryCustomer(){//查询客户信息对话框
          this.dialogVisible = true;
        },
        getMsg(row){//选择客户信息确定回调函数
          this.dialogVisible = false;
          //row.partyId = "ff8080815f32ca68015f3338f7ce0baa";//担保公司ff8080815f32ca68015f3338f7ce0baa，失效的担保公司ff80808165cd327a0165d0c1efd90067
          this.buttonDisable = true;
          this.buttonText = "";
          this.isLoading = true;
          getPartyInfoByPartyId(row).then(response => {
            if(response.data.flag == enums.stateCode.flag.success){//返回数据成功
              this.data.guarantorPartyId =  response.data.data.partyId;
              console.log("担保人："+response.data.data.partyId);
              this.data.partyName = response.data.data.partyName;
                if(response.data.data.partyTypeCd=='02'){//自然人客户
                  this.isNaturalCustomer = true;
                  this.data.certNum = response.data.data.certNum;
                  this.data.certType = response.data.data.certType;
                } else{ //公司客户
                  this.isNaturalCustomer = false;
                  this.data.registrCd = response.data.data.registrCd;
                  this.data.orgRegisterCd = response.data.data.orgRegisterCd;
                  this.data.thirdCustTypeCd = response.data.data.thirdCustTypeCd;
                }
                if(response.data.isZYDBGS=='true'){//是否担保公司
                  this.data.isGuaranteeCompany = '1';
                  this.isGuaranteeCorporation = true;
                  //是担保公司：赋值
                  /**
                   *               //grtGuaranteeBasic
                   isGuaranteeCompany:"",//是否担保公司
                   currencyCd:"CNY",
                   accnoWay:[],//保证金存储方式
                   suretyAmt:"",//担保金额
                   //tbCrdThirdPartyLimit
                   beginDate:"",//担保额度起期
                   endDate:"",//担保额度止期
                   //tbConGuarantOrgInfo
                   creditAmount:"",//授信额度
                   creditStatus:"",//合作状态
                   creditType:"",//性质
                   creditApport:"",//责任分担比例
                   simpleAmount:"",//单户总额
                   //party
                   useAmt:"",//预用担保金额
                   usedAmt:"",//已担保金额
                   aviAmt:"",//可用保证金额 */
                  this.data.beginDate = response.data.crdThirdPartyLimit.beginDate;
                  this.data.endDate = response.data.crdThirdPartyLimit.endDate;
                  this.data.creditAmount = response.data.conGuarantOrgInfo.creditAmount;
                  this.data.creditStatus = response.data.conGuarantOrgInfo.creditStatus;
                  this.data.creditType = response.data.conGuarantOrgInfo.creditType;
                  this.data.creditApport = response.data.conGuarantOrgInfo.creditApport;
                  this.data.simpleAmount = response.data.conGuarantOrgInfo.simpleAmount;
                  this.data.useAmt = response.data.comMoney.USEAMT;
                  this.data.usedAmt = response.data.comMoney1.USEDAMT;
                  this.data.aviAmt = Number(this.data.creditAmount)- Number(this.data.useAmt);
                  var listquery = {};
                  listquery.pageSize=10;
                  listquery.pageNum=1;
                  this.doPageQuery(listquery);
                } else{
                  this.data.isGuaranteeCompany = '0';
                  this.data.guaranteeForm = "02";
                  this.isGuaranteeCorporation = false;
                }
              this.buttonDisable = false;
              this.buttonText = "提交";
              this.isLoading = false;
            } else{
              this.$message({
                message: '获取数据失败啦！'+JSON.stringify(response.data),
                type: 'error'
              });
              this.buttonDisable = true;
              this.buttonText = "提交";
              this.isLoading = false;
            }
          });
        },
        refresh(){
          var listQuery ={};
          listQuery.pageNum=1;
          listQuery.pageSize=10;
          this.doPageQuery(listQuery);
        },
        handleGoodsDetailInfoClose:function (done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              this.$refs["validate"].resetFields();
              done();
            })
            .catch(_ => {});
        },
        comfirm:function () {
          this.$refs["validate"].validate((valid) => {
            if(valid){
              /*担保公司逻辑
               */
              //照抄普元逻辑，好像逻辑有点乱
              if(this.data.thirdCustTypeCd=='1' && !this.isGuaranteeCorporation ){
                this.$message({
                  message: '该公司状态为担保公司，但未签署专业担保协议，不能作为保证人!',
                  type: 'error'
                });
                return;
              }
              if(this.isGuaranteeCorporation && (Number(this.data.suretyAmt) > Number(this.data.aviAmt))){
                if(this.bizHappenType !="06"){
                  this.$message({
                    message: '申请担保金额不能大于可用担保金额!',
                    type: 'error'
                  });
                  return;
                }
              }
              if(this.bizHappenType =="06" && Number(this.data.suretyAmt) > Number(this.rmb)){
                this.$message({
                  message: '申请担保金额不能大于申请金额!',
                  type: 'error'
                });
                return;
              }
              if (this.isGuaranteeCorporation && Number(this.data.suretyAmt) > Number(this.data.simpleAmount)) {
                this.$message({
                  message: '申请担保金额不能大于单户总额!',
                  type: 'error'
                });
                return;
              }
              if(this.data.creditStatus == "03"){//停止合作
                this.$message({
                  message: '担保公司合作状态为\'停止合作\'的不允许作为担保!',
                  type: 'error'
                });
                return;
              } else if(this.data.creditStatus == "02"){
                if(this.bizHappenType !="06"){
                  var stopJson={guarantorPartyId:this.data.guarantorPartyId,partyId:this.info.partyId};
                  this.buttonDisable = true;
                  this.buttonText = "";
                  this.isLoading = true;
                  var flg ="";
                  var suretyAmts;//担保总合同额
                  var aviconuseAmt;
                  queryCompanyStatus(stopJson).then(response => {
                    console.log("quota:"+JSON.stringify(response.data));
                    if(response.data.flag == enums.stateCode.flag.success){//
                        if(response.data.conGuaranteQuota){
                          suretyAmts = response.data.tbConGuaranteQuota.guaranteAmt;
                          var userAmt ="0";//已经担保额
                          if(response.data.obj){
                            userAmt = response.data.obj.useAmt;
                          }
                          aviconuseAmt = Number(suretyAmts)-Number(userAmt);//剩余（可用）担保额
                          if(suretyAmts){
                            if(Number(this.data.suretyAmt) >Number(aviconuseAmt)){
                              flg ="0";
                            }
                          }else{
                            flg ="3";
                          }
                        } else{
                          flg ="3";
                        }
                      if(flg =="0"){
                        this.buttonDisable = false;
                        this.buttonText = "提交";
                        this.isLoading = false;
                        this.$message({
                          message: "担保公司合作状态为'暂停新增'的不允许超过该担保公司为该借款人担保的总担保合同额度"+suretyAmts+"元和可用担保额度"+aviconuseAmt+"元",
                          type: 'error'
                        });
                        return;
                      }
                      if(flg =="3"){
                        this.buttonDisable = false;
                        this.buttonText = "提交";
                        this.isLoading = false;
                        this.$message({
                          message:"担保公司合作状态为'暂停新增'时未查询到该担保公司为该借款人的担保合同，故不允许作为担保",
                          type: 'error'
                        });
                        return;
                      }
                      //未使用同步请求
                      addGuaranteeApplyTbGrtGuaranteer(this.data).then(req =>{
                        if(req.data.flag == enums.stateCode.flag.success){//
                          this.$emit('backFlag',"ok");
                          this.$message({
                            message: '数据提交成功！',
                            type: 'success'
                          });
                        }else{
                          this.$message({
                            message: '操作失败!'+JSON.stringify(req.data),
                            type: 'error'
                          });
                        }
                      });
                      return;
                    } else{
                      this.$message({
                        message: '操作失败!'+JSON.stringify(response.data),
                        type: 'error'
                      });
                      this.buttonDisable = false;
                      this.buttonText = "提交";
                      this.isLoading = false;
                    }
                  });
                }
              }
              console.log("担保人："+JSON.stringify(this.data));
              //未使用同步请求
              addGuaranteeApplyTbGrtGuaranteer(this.data).then(req =>{
                if(req.data.flag == enums.stateCode.flag.success){//
                  this.$emit('backFlag',"ok");
                  this.$message({
                    message: '数据提交成功！',
                    type: 'success'
                  });
                }else{
                  this.$message({
                    message: '操作失败!'+JSON.stringify(req.data),
                    type: 'error'
                  });
                }
              });
            }else{
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

<style lang="scss">
  .m-t-b-0{
    margin-top: 0;
    margin-bottom: 0;
  }
  .add-guarantor .el-form-item__label{
    font-size: 13px !important;
  }
  .add-guarantor .special-input .el-input{
    width: calc(100% - 50px );
    float: left!important;
  }
  .add-guarantor .special-button{
    float:left!important;
    margin-left: 10px!important;
    padding: 7px 12px!important;
  }
</style>
