<template>
<el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu default-active="1">
            <el-menu-item v-for="item in items" index="item.index" @click="show_active(item.index)">
                <template slot="title">
                <i class="el-icon-location"></i>
                <span>{{item.name}}</span>
                </template>
            </el-menu-item>
        </el-menu>
    </el-aside>
    <el-container>
    <div v-show="show_1">
    <el-form :model="show_1_data" label-width="260px" size="small">
			<el-row>
				<el-col :span="11">
					<el-form-item label="客户编号：">
						<el-input v-model="show_1_data.party.partyNum" disabled="false"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="客户名称：">
						<el-input v-model="show_1_data.party.partyName" disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="客户类型：">
						<el-input v-model="show_1_data.party.partyTypeCd" disabled="true"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="所属机构：">
						<el-input v-model="show_1_data.orgNum" disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
                <el-col :span="11" v-if="show_1_data.corporation">
					<el-form-item label="客户行业：">
						<el-input v-model="show_1_data.corporation.industrialTypeCd" disabled="true"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11" v-if="show_1_data.corporation">
					<el-form-item label="银行认定企业规模：">
						<el-input v-model="show_1_data.corporation.bankScaleIdentify" disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="评级模型：">
						<el-input v-model="show_1_data.irmApply.rating_MODEL_CD" disabled="true"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="评级日期">
						<el-input v-model="show_1_data.irmApply.applyDate" disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="上次评级结果：">
						<el-input v-model="show_1_data.irmApply.last_CREDIT_RATING_CD" disabled="true"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="上次评级起始日期：">
						<el-input v-model="show_1_data.irmApply.last_EFFECTIVE_START_DT" disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="上次评级到期日：">
						<el-input v-model="show_1_data.irmApply.last_EFFECTIVE_END_DT" disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>
    </div>
    <div v-show="show_2">
    </div>
    <div v-show="show_3" style="overflow:scroll">
    <el-table
      :data="nonFinanceInfo"
      :span-method="objectSpanMethod"
      border
      style="width: 100%; margin-top: 20px">
      <el-table-column prop="propertyTypeCd" label="指标类别" width="120">
      </el-table-column>
      <el-table-column prop="indexName" label="指标" width="120">
      </el-table-column>
      <el-table-column label="指标说明" width="120">
        <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
            <p>{{ scope.row.indexDesc }}</p>
            <div slot="reference" class="name-wrapper">
                <el-tag size="medium">指这查看</el-tag>
            </div>
            </el-popover>
        </template>
      </el-table-column>
      <el-table-column prop="index_value" label="指标选项" width="300" show-overflow-tooltip="true">
        <template slot-scope="scope">
            
            <p v-for="indexScore in scope.row.tbIrmIndexScores">
                <el-radio v-model="scope.row.indexValue"  
                :label="indexScore.indexNum">{{indexScore.indexNum+"："+indexScore.indexDesc}}</el-radio>
            </p>
        </template>
      </el-table-column>
      <el-table-column prop="remarks" label="如有特殊事项，请各位填入备注" width="300">
          <template slot-scope="scope">
          <el-input
            type="textarea"
            :rows="scope.row.tbIrmIndexScores.length"
            placeholder="请输入内容"
            v-model="scope.row.remarks">
            </el-input>
             </template>
      </el-table-column>
    </el-table>
    <span slot="footer" class="dialog-footer">
        <el-button :v-if="show3_save_flag" size="small"  type="primary" @click="submit_show_3()">{{$t('action.comfirm')}}</el-button>
      </span>
    </div>
    <div v-show="show_4">
        <el-form :model="show_4_data" label-width="260px" size="small">
			<el-row>
				<el-col :span="11">
                    <el-form-item label="系统评级结果（R0）：">
                        <el-select v-model="show_4_data.ratingApply.government_ADJUST_RATING_CD" disabled="true">
                        <el-option v-for="scale in show_4_data.scales" :label="scale.value" :value="scale.key">
                        </el-option>
                        </el-select>
                    </el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="是否手工调整：">
						<el-select v-model="show_4_data.adjustOptions.isAdjust" :disabled="temp4.disabled" @change="isAdjustChange()">
                            <el-option label="是" value="1"></el-option>
                            <el-option label="否" value="0"></el-option>
                        </el-select>
					</el-form-item>
				</el-col>
			</el-row>
            <el-row>
				<el-col :span="11">
                    <el-form-item label="客户经理评级结果(R1)：">
                        <el-select v-model="show_4_data.ratingApply.gp_MODEL_VER" :disabled="show_4_data.adjustOptions.isAdjust == '0'">
                        <el-option v-for="scale in show_4_data.scales" :label="scale.value" :value="scale.key">
                        </el-option>
                        </el-select>
                    </el-form-item>
				</el-col>
                <!-- <el-col :span="11">
                    <el-form-item label="评级结果(R2)：">
                        <el-select v-model="show_4_data.ratingApply.generalAdjustRatingCd" :disabled="temp4.disabled">
                        <el-option v-for="scale in show_4_data.scales" :label="scale.value" :value="scale.key">
                        </el-option>
                        </el-select>
                    </el-form-item>
				</el-col> -->
			</el-row>
            <el-row>
				<el-col :span="22">
					<el-form-item label="手工调整说明：">
                        <el-input
                            type="textarea"
                            v-model="show_4_data.adjustOptions.adjustDescribe" :disabled="show_4_data.adjustOptions.isAdjust == '0'">
                        </el-input>
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>
        <span slot="footer" class="dialog-footer">
        <h5 :v-if="temp4.disabled" style="color:red">修改评级后请保存</h5><el-button :v-if="temp4.disabled" size="small"  type="primary" @click="submit_show_4()">{{$t('action.comfirm')}}</el-button>
      </span>
    </div>
    <div v-show="show_5" style="overflow:scroll">
        <fieldset>
            <legend>
                <span>评级信息</span>
            </legend>
        </fieldset>
        <el-form :model="show_5_data" label-width="260px" size="small">
			<el-row>
				<el-col :span="11">
					<el-form-item label="客户编号：">
						<el-input v-model="show_5_data.party.partyNum" disabled="false"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="客户名称：">
						<el-input v-model="show_5_data.party.partyName" disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="客户类型：">
						<el-input v-model="show_5_data.party.partyTypeCd" disabled="true"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="组织机构代码：">
						<el-input v-model="show_5_data.corporation.orgRegisterCd" disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="银行认定企业规模：">
						<el-input v-model="show_5_data.corporation.bankScaleIdentify" disabled="true"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="客户行业：">
						<el-input v-model="show_5_data.corporation.industrialTypeCd" disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="评级模型：">
						<el-input v-model="show_5_data.irmApply.rating_MODEL_CD" disabled="true"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="评级发起日期：">
						<el-input v-model="show_5_data.systime" disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="认定结果(R2)：">
						<el-input v-model="show_5_data.initialRatingCd" disabled="true"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item v-show="!temp5.isProject" label="违约概率（PD1）：">
						<el-input v-model="show_5_data.avgPd" disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>
        <fieldset>
            <legend>
                <span>推翻历史</span>
            </legend>
        </fieldset>
        <csc-single-table
            :pageDef= "temp5.pageDef_OverRecord"
            :entity= "entity_OverRecord"
            :disableQueryForm="false"
            @pageQuery= "queryOverRecordInfo"
            :autoQuery="false"
            :disableRowButtons="true"
            :disableQueryButtons="true"
        >
        </csc-single-table>
        <div v-show="temp5.proFlag == '1'">
            <div>
                <fieldset>
                    <legend>
                        <span>评级推翻 注：若认为前手评级结果尚不能准确体现客户，请进行评级推翻，并录入真实且详细的推翻原因。</span>
                    </legend>
                </fieldset>
            </div>
            <div>
                <el-form :model="show_5_data" label-width="260px" size="small">
                    <el-row>
                        <el-col :span="11">
                            <el-form-item label="前手建议评级：">
                                <el-input v-model="show_5_data.tf.overReason" disabled="true"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="11">
                            <el-form-item label="经办人：">
                                <el-input v-model="show_5_data.tf.userName" disabled="true"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="11">
                            <el-form-item label="经办机构：">
                                <el-input v-model="show_5_data.tf.userOrgName" disabled="true"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="11">
                            <el-form-item label="是否进行推翻：">
                                <el-radio-group v-model="show_5_data.tf.YN">
                                    <el-radio-button label="1">是</el-radio-button>
                                    <el-radio-button label="0" checked="true">否</el-radio-button>
                                </el-radio-group>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="11">
                            <el-form-item label="推翻后评级结果：">
                                <el-select v-model="show_5_data.tf.rateResult" :disabled="show_5_data.tf.YN == '0'">
                                <el-option v-for="scale in show_4_data.scales" :label="scale.value" :value="scale.key">
                                </el-option>
                                </el-select>
                            </el-form-item>
                        </el-col>
                        <el-col :span="11">
                            <el-form-item v-show="!temp5.isProject" label="违约概率（PD2）：">
                                <el-input v-model="show_5_data.tf.avagPd2" disabled="true"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="22">
                            <el-form-item label="推翻原因：">
                                <el-input
                                    type="textarea"
                                    v-model="show_5_data.tf.overThrowReason" :disabled="show_5_data.tf.YN == '0'">
                                </el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button :v-if="show_5_data.tf.YN == '0'" size="small"  type="primary" @click="submit_show_5()">{{$t('action.comfirm')}}</el-button>
                </span>
            </div>
        </div>
    </div>
    <div v-show="show_6">
    </div>
  </el-container>
</el-container>
</template>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>

<script>
  export default {
    props:{
        irmBaseInfo_irmTree: {
            type: Object,
            required: true
        }
    },
    data() {       
      return {
          irmTree_temp: {},
          show3_save_flag:true,
          temp1: {},
          temp2: {},
          temp3: {},
          temp4: {disabled: false},
          temp5: {pageDef_OverRecord:{}},
          temp6: {},
          flag: true,
          proFlag: '1', //编辑标示 //不等于1 隐藏保存按钮  等于一 ：提示信息：请谨慎选择非财务信息!
          show_1: false,show_2: false,show_3: false,show_4: false,show_5: false,show_6: false,
          items:[],
          nonFinanceInfo: [],//非财务信息
          entity_OverRecord:{},//推翻历史信息
          show_1_data: {party:{partyNum:'',partyName:'',partyTypeCd:''},
                        corporation:{industrialTypeCd:'',bankScaleIdentify:'',updateOrgNum:''},
                        irmApply:{rating_MODEL_CD:'',rating_MODEL_CD:'',last_CREDIT_RATING_CD:'',last_EFFECTIVE_START_DT:'',last_EFFECTIVE_END_DT:''},
                        userNum:'',orgNum:''},
          show_2_data: {},
          show_3_data: {},
          show_4_data: {ratingApply:{general_ADJUST_RATING_CD:'',government_ADJUST_RATING_CD:'',gpModelVer:''},adjustOptions:{isAdjust:'0',adjustDescribe:''}},
          show_5_data: {party:{partyNum:'',partyName:'',partyTypeCd:''},
                        corporation:{orgRegisterCd:'',bankScaleIdentify:'',industrialTypeCd:''},
                        irmApply:{rating_MODEL_CD:''},
                        initialRatingCd:'',avgPd:'',systime:'',
                        tf:{overReason:'',YN:'0',rateResult:'',avagPd2:'',overThrowReason:'',userName:'',userOrgName:''}},
          show_6_data: {},
      }
    },
    methods: {
        init(){
            console.info("IrmTree传入初始化参数：")
            console.info(JSON.stringify(this.irmBaseInfo_irmTree))
            this.irmTree_temp.proFlag = this.irmBaseInfo_irmTree.proFlag////1：可修改。0：不可修改
            this.irmTree_temp.partyId = this.irmBaseInfo_irmTree.partyId
            this.irmTree_temp.applyId = this.irmBaseInfo_irmTree.iraApplyId//协议申请ID
            this.irmTree_temp.oldApplyId = this.irmBaseInfo_irmTree.iraApplyId//协议申请ID
            this.irmTree_temp.pjlx = this.irmBaseInfo_irmTree.pjlx//评级类型
            this.irmTree_temp.processInstId = this.irmBaseInfo_irmTree.processInstId
            //获取评级申请信息
            let that = this
            this.queryCustInfoJj(this.irmTree_temp.partyId,this.irmTree_temp.applyId,function(party,irmApply,corporation,natural,userNum,orgNum){
               that.irmTree_temp.irmApply = irmApply//缓存评级申请信息
                that.irmTree_temp.reAud = '0'
                that.irmTree_temp.flowType = '01'
                if('-1' != that.irmBaseInfo_irmTree.proFlag){
                    if(corporation && corporation.thirdCustTypeCd == '1'){//担保公司
                        //基本信息1  评级信息2   通用调整选项4 评级结论5 意见6
                        that.items = [{index:'1',name:'基本信息'},{index:'2',name:'评级信息'},{index:'4',name:'通用调整选项'},
                        {index:'5',name:'评级结论'},{index:'6',name:'意见'}]
                        
                    }else{//非担保公司
                        //基本信息1 非财务信息3  通用调整选项4 评级结论5 意见6
                        that.items = [{index:'1',name:'基本信息'},{index:'3',name:'非财务信息'},{index:'4',name:'通用调整选项'},
                        {index:'5',name:'评级结论'},{index:'6',name:'意见'}]
                    }
                }else{
                    //基本信息1 非财务信息3  通用调整选项4 评级结论5
                    that.items = [{index:'1',name:'基本信息'},{index:'3',name:'非财务信息'},{index:'4',name:'通用调整选项'},
                        {index:'5',name:'评级结论'}]
                }
                that.show_1_data.irmApply = irmApply
                that.show_1_data.corporation = corporation
                that.show_1_data.party = party
                that.show_1_data.userNum = userNum
                that.show_1_data.orgNum = orgNum

                //评级结果集
                that.getModeScaleToCombobx(that.irmTree_temp.irmApply.rating_MODEL_CD)
            })
        },
        handlerSelect(index) {
            this.show_active(index)
        },
        init_show_1(partyId,applyId,reAud,oldApplyId,flowType,pjlx){
           this.show_1 = true
        },
        init_show_2(partyId,applyId,reAud,oldApplyId,proFlag,pjlx){

        },
        init_show_3(partyId,applyId,reAud,oldApplyId,proFlag,pjlx){
            let flag = true
            if(this.reAud != "0"){
                applyId = oldApplyId
            }
            this.temp3.applyId = applyId
            if(reAud == '1'){
                this.show3_save_flag = false//隐藏保存按钮
            }
            if(proFlag != "1"){
                flag = false
                this.show3_save_flag = false//隐藏保存按钮
            }else{
                this.$message({message: '请谨慎选择非财务信息!',type: 'info'})
            }
            this.querynonFinanceInfo(applyId)
            this.show_3 = true
            if(this.irmTree_temp.irmApply.rating_STATE == '01' || this.irmTree_temp.irmApply.rating_STATE == '02'){//01待审核 02 待认定
                this.show3_save_flag = false//隐藏保存按钮
            }
            
        },
        init_show_4(partyId,applyId,reAud,oldApplyId,proFlag){
            let ratingCd = [{ id: 'AAA', text: 'AAA'}, { id: 'AA', text: 'AA'}, { id: 'A', text: 'A'},
						{ id: 'BBB', text: 'BBB'}, { id: 'BB', text: 'BB'}, { id: 'B', text: 'B'},
						{ id: 'CCC', text: 'CCC'}, { id: 'CC', text: 'CC'}, { id: 'C', text: 'C'}]
            if(proFlag != 1){
                this.temp4.disabled = true
            }
            this.getIrmApplyCd(this.irmTree_temp.applyId)
            this.show_4 = true
            this.isAdjustChange()
        },
        init_show_5(partyId,applyId,reAud,oldApplyId,proFlag,flowType){
            this.temp5.proFlag="1"
            let that = this
            this.queryCustInfoJj(partyId,applyId,function(party,irmApply,corporation,natural,userNum,orgNum){
                that.show_5_data.irmApply = irmApply//缓存评级申请信息
                that.show_5_data.party = party
                that.show_5_data.corporation = corporation
                that.show_5_data.natural = natural
                if(that.show_5_data.irmApply.project_ID){//专业贷款
                    that.show_5_data.isProject = true
                }else{//非专业贷款
                    that.show_5_data.isProject = false
                }
                if(that.show_5_data.isProject){
                    that.temp5.pageDef_OverRecord={
                        queryDef: {},
                        tabDef: {isSelect:false,isIndex:true,
                            tabCols: [
                                {label: "是否推翻", prop: "isOverthrow"},//XD_0002
                                {label: "经办人", prop: "userNum"},
                                {label: "经办机构", prop: "orgNum"},
                                {label: "推翻后评级结果", prop: "afterGrade"},//afterGrade没有 只有creditRatingDisplay
                                {label: "推翻日期", prop: "overthrowDT"},
                                {label: "推翻原因", prop: "overthrowReason"},
                                {label: "违约概率（PD2）", prop: "avagPD"}
                            ]
                        }
                    }
                }else{
                    that.temp5.pageDef_OverRecord={
                        queryDef: {},
                        tabDef: {isSelect:false,isIndex:true,
                            tabCols: [
                                {label: "是否推翻", prop: "isOverthrow"},//XD_0002
                                {label: "经办人", prop: "userNum"},
                                {label: "经办机构", prop: "orgNum"},
                                {label: "推翻后评级结果", prop: "afterGrade"},//afterGrade没有 只有creditRatingDisplay
                                {label: "推翻日期", prop: "overthrowDt"},
                                {label: "推翻原因", prop: "overthrowReason"}
                            ]
                        }
                    }
                }
            })
            this.queryInitialRatingCd(applyId,oldApplyId)
            this.getBeforeRatingResult(applyId,'P1046',flowType)
            this.show_4_data.scales
        },
        init_show_6(applyId,proFlag,isSrc){},
        submit_show_3(){
            console.log("保存非财务信息")
            if(this.irmTree_temp.irmApply.allow_TIMES < -2){
                this.$message({
                    message: '获取评级结果次数过多，不能进行保存！',
                    type: 'error'
                });
                return
            }
            this.nonFinanceInfo.forEach(item => {
                if (item.indexValue == null) {
                    this.$alert('有未勾选的指标选项《'+item.indexName+'》', '操作错误', {
                        confirmButtonText: '确定'
                    });
                    return
                }
            })
            if(this.irmBaseInfo_irmTree.pjlx == '4'){//担保公司，查看是否有财报信息
                let data= {partyId : this.irmBaseInfo_irmTree.party.partyId}
                this.$api.irm_irm.queryHasFinanceInfo(data).then((res) => {
                    if(res && res.data && res.data.code == 200){//返回数据成功
                        if(res.data.hasFlag == '0'){
                            this.$message({
                                message: '请导入担保公司的财务报表再进行后续操作！',
                                type: 'info'
                            })
                            return
                        }
                    } else{
                        this.$message({
                        message: '查询担保公司财报信息失败！',
                        type: 'error'
                        });
                    }
                }).catch((res) => {
                    this.$message({message: '查询担保公司财报信息失败！, 错误信息：' + res, type: 'error'})
                    console.error('查询担保公司财报信息失败！, 错误信息：' + res)
                })
            } 
            let addFinancialInfo_param = {'item':{'reportId': '','applyId': this.irmTree_temp.applyId},'isImport': '0','modelTypeCd': ''}
            this.addFinancialInfo(addFinancialInfo_param)
            let addNonFinancialInfo_param = {'inRows': this.nonFinanceInfo,'applyId': this.irmTree_temp.applyId}
            this.addNonFinancialInfo(addNonFinancialInfo_param)
        },
        submit_show_4(){
            console.info("保存通用调整项信息")
            console.log(JSON.stringify(this.show_4_data))
            if("1" == this.show_4_data.adjustOptions.isAdjust && ("" ==this.show_4_data.ratingApply.gp_MODEL_VER || ""==this.show_4_data.adjustOptions.adjustDescribe)){
                alert("请输入调整信息")
				return
            }
            if(this.show_4_data.ratingApply.government_ADJUST_RATING_CD==this.show_4_data.ratingApply.gp_MODEL_VER && this.show_4_data.adjustOptions.isAdjust==1){
				alert("调整后等级不能和调整前相同！");
				return;
			}
			if(!this.show_4_data.ratingApply.government_ADJUST_RATING_CD || ""==this.show_4_data.ratingApply.government_ADJUST_RATING_CD){
				alert("请先获取系统评级结果！");
				return;
			}
			if(!this.show_4_data.ratingApply.gp_MODEL_VER || ""==this.show_4_data.ratingApply.gp_MODEL_VER){
				alert("请先获取客户经理评级结果！");
				return;
            }
            this.$api.irm_irm.saveIrmApplyCd(this.show_4_data).then((res) => {

                if(res && res.data && res.data.code == 200){//返回数据成功
                    this.$message({
                    message: '保存调整项信息成功！',
                    type: 'info'
                    });
                    alert('保存调整项信息成功！后续步骤：调用setRatingCd修改流程中RatingCd,AAA=3，AA+ or AA=2 其他=1')
                } else{
                    this.$message({
                    message: '保存调整项信息失败！',
                    type: 'error'
                    });
                }
            }).catch((res) => {
                this.$message({message: '保存调整项信息失败, 错误信息：' + res, type: 'error'})
                console.error('保存调整项信息失败, 错误信息：' + res)
            })
        },
        submit_show_5(){
            if(this.show_5_data.tf.YN == "1"){//推翻
                this.$api.irm_irm.addOrUpdateTFRecord(this.show_5_data).then((res) => {

                if(res && res.data && res.data.code == 200){//返回数据成功
                    this.queryOverRecordInfo()
                } else{
                    this.$message({
                    message: '保存推翻信息失败！' + res.data.msg,
                    type: 'error'
                    });
                }
            }).catch((res) => {
                this.$message({message: '保存推翻信息失败, 错误信息：' + res, type: 'error'})
                console.error('保存推翻信息失败, 错误信息：' + res)
            }) 
            }
        },
        //获取评级申请信息
        queryCustInfoJj(partyId,applyId,fn){
            this.$api.irm_irm.queryCustInfoJj({partyId: partyId,applyId: applyId}).then((res) => {

                if(res && res.data && res.data.code == 200){//返回数据成功
                    fn(res.data.party,res.data.irmApply,res.data.corporation,res.data.natural,res.data.userNum,res.data.orgNum)
                } else{
                    this.$message({
                    message: '查询评级基本信息失败！' + res.data.msg,
                    type: 'error'
                    });
                }
            }).catch((res) => {
                this.$message({message: '查询评级基本信息失败, 错误信息：' + res, type: 'error'})
                console.error('查询评级基本信息失败, 错误信息：' + res)
            }) 
        },
        querynonFinanceInfo(appyId){
            let data= {applyId: appyId}
            this.$api.irm_irm.queryNonFinanceInfo(data).then((res) => {

                if(res && res.data && res.data.code == 200){//返回数据成功
                    this.nonFinanceInfo = res.data.data
                } else{
                    this.$message({
                    message: '查询非财务信息失败！',
                    type: 'error'
                    });
                }
            }).catch((res) => {
                this.$message({message: '查询非财务信息失败, 错误信息：' + res, type: 'error'})
                console.error('查询非财务信息失败, 错误信息：' + res)
            })
        },
        getIrmRatingApplyInfo(applyId){
            let data= {applyId: applyId}
            this.$api.irm_irm.getIrmRatingApplyInfo(data).then((res) => {

                if(res && res.data && res.data.code == 200){//返回数据成功
                    this.temp3.irmApply = res.data.irmApply
                    return res.data.irmApply
                } else{
                    this.$message({
                    message: '查询评级申请信息失败！',
                    type: 'error'
                    });
                }
            }).catch((res) => {
                this.$message({message: '查询评级申请信息失败, 错误信息：' + res, type: 'error'})
                console.error('查询评级申请信息失败, 错误信息：' + res)
            })
        },
        getModeScaleToCombobx(modelTypeCd){
            let data={modelTypeCd:modelTypeCd}
            this.$api.irm_irm.getModeScaleToCombobx(data).then((res) => {
                if(res && res.data && res.data.code == 200){//返回数据成功
                    this.show_4_data.scales = res.data.scals
                } 
            })
        },
        getIrmApplyCd(applyId){
            let data={applyId:applyId}
            this.$api.irm_irm.getIrmApplyCd(data).then((res) => {
                if(res && res.data && res.data.code == 200){//返回数据成功
                    this.show_4_data.ratingApply = res.data.ratingApply
                    if(res.data.adjustOptions){
                        this.show_4_data.adjustOptions = res.data.adjustOptions
                    }
                    
                } 
            })
        },
        addFinancialInfo(data){
            this.$api.irm_irm.addFinancialInfo(data).then((res) => {
                if(res && res.data && res.data.code == 200){//返回数据成功
                } else{
                    this.$message({
                    message: res.data.msg,
                    type: 'error'
                    });
                }
            }).catch((res) => {
                this.$message({message: '添加财务信息失败, 错误信息：' + res, type: 'error'})
                console.error('添加财务信息失败, 错误信息：' + res)
            })
        },
        addNonFinancialInfo(data){
            this.$api.irm_irm.addNonFinancialInfo(data).then((res) => {
                if(res && res.data && res.data.code == 200){//返回数据成功
                    this.$message({
                    message: '添加或更新非财务信息成功',
                    type: 'info'
                    });
                } else{
                    this.$message({
                    message: res.data.msg,
                    type: 'error'
                    });
                }
            }).catch((res) => {
                this.$message({message: '添加非财务信息失败, 错误信息：' + res, type: 'error'})
                console.error('添加财务非信息失败, 错误信息：' + res)
            })
        },
        //控制内容展示
        show_active(index){
            this.show_1= false
            this.show_2= false
            this.show_3= false
            this.show_4= false
            this.show_5= false
            this.show_6= false
            switch(index)
            {
            case '1':
                this.init_show_1(this.irmTree_temp.partyId,this.irmTree_temp.applyId,this.irmTree_temp.reAud,this.irmTree_temp.oldApplyId,this.irmTree_temp.flowType,this.irmTree_temp.pjlx)
            break;
            case '2':
                this.init_show_2(this.irmTree_temp.partyId,this.irmTree_temp.applyId,this.irmTree_temp.reAud,this.irmTree_temp.oldApplyId,this.irmTree_temp.proFlag,this.irmTree_temp.pjlx)
                this.show_2 = true
            break;
            case '3':
                this.init_show_3(this.irmTree_temp.partyId,this.irmTree_temp.applyId,this.irmTree_temp.reAud,this.irmTree_temp.oldApplyId,this.irmTree_temp.proFlag,this.irmTree_temp.pjlx)
                
            break;
            case '4':
                this.init_show_4(this.irmTree_temp.partyId,this.irmTree_temp.applyId,this.irmTree_temp.reAud,this.irmTree_temp.oldApplyId,this.irmTree_temp.proFlag)
            break;
            case '5':
                this.init_show_5(this.irmTree_temp.partyId,this.irmTree_temp.applyId,this.irmTree_temp.reAud,this.irmTree_temp.oldApplyId,this.irmTree_temp.processInstId,this.irmTree_temp.flowType)
                this.show_5 = true
            break;
            case '6':
                this.init_show_6(this.irmTree_temp.applyId,this.irmTree_temp.processInstId,2)
                this.show_6 = true
            break;
            default:
                this.show_1 = true
            }
        },
        objectSpanMethod({ row, column, rowIndex, columnIndex }) {
            if (columnIndex === 0) {
                if (rowIndex % 2 === 0) {
                    return {
                    rowspan: 2,
                    colspan: 1
                    };
                } else {
                    return {
                    rowspan: 0,
                    colspan: 0
                    };
                }
            }
        },
        isAdjustChange(){
            if("0" == this.show_4_data.adjustOptions.isAdjust){
                this.show_4_data.ratingApply.general_ADJUST_RATING_CD = this.show_4_data.ratingApply.government_ADJUST_RATING_CD
                this.show_4_data.ratingApply.gp_MODEL_VER = this.show_4_data.ratingApply.government_ADJUST_RATING_CD
            }
        },
        queryOverRecordInfo(){
            let query =  {applyId: this.irmTree_temp.applyId,oldApplyId: this.irmTree_temp.oldApplyId}
            this.$api.irm_irm.queryOverRecordInfo(query).then((res) => {
            if(res && res.data && res.data.code == 200){//返回数据成功
                let myEntity = {};
                myEntity.total = res.data.data.total;
                myEntity.data = res.data.data.list;
                this.entity_OverRecord = myEntity;
            } else{
                this.$message({
                message: '查询推翻历史信息失败！',
                type: 'error'
                });
            }
            }).catch((res) => {
            this.$message({message: '初始查询推翻历史信息失败, 错误信息：' + res, type: 'error'})
            console.error('初始查询推翻历史信息失败, 错误信息：' + res)
            })
        },
        queryInitialRatingCd(applyId,oldApplyId){
            this.$api.irm_irm.queryInitialRatingCd({applyId:applyId,oldApplyId:oldApplyId}).then((res) => {
            if(res && res.data && res.data.code == 200){//返回数据成功
                this.show_5_data.initialRatingCd = res.data.initialRatingCd
                this.show_5_data.systime = res.data.time
                this.show_5_data.avgPd = res.data.avgPd
                this.show_5_data.rateResFi = res.data.orderNo
            } else{
                this.$message({
                message: res.data.msg,
                type: 'error'
                });
            }
            }).catch((res) => {
            this.$message({message: '根据评级申请Id和参与人Id获取最新的评级引擎计算信息失败, 错误信息：' + res, type: 'error'})
            console.error('根据评级申请Id和参与人Id获取最新的评级引擎计算信息失败, 错误信息：' + res)
            })
        },
        //通过评级ID获取前手的评级结果
        getBeforeRatingResult(applyId,posicode,flowType){
            this.$api.irm_irm.queryOverRecordFirst({applyId:applyId,posicode:posicode,flowType:flowType}).then((res) => {
            if(res && res.data && res.data.code == 200){//返回数据成功
                this.show_5_data.tf.overReason = res.data.overReason
                this.show_5_data.tf.rateResSe = res.data.orderNo
            } else{
                this.$message({
                message: res.data.msg,
                type: 'error'
                });
            }
            }).catch((res) => {
            this.$message({message: '通过评级ID获取前手的评级结果失败, 错误信息：' + res, type: 'error'})
            console.error('通过评级ID获取前手的评级结果失败, 错误信息：' + res)
            })
        }
    },
    mounted:function() {
        this.init()
        this.handlerSelect(1)
    }
  };
</script>