<template>
  <div class="container" style="width:99%;margin-top:-25px;">
    <!--工具栏-->
   <div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
      <el-form ref="formCustom" :inline="true" :model="filters" :size="size" >
        <el-form-item label="客户编号：" prop="partyNum">
          <el-input v-model="filters.partyNum" placeholder="客户编号"></el-input>
        </el-form-item>
        <el-form-item label="客户名称：" prop="partyName">
          <el-input v-model="filters.partyName" placeholder="客户名称"></el-input>
        </el-form-item>
        <el-form-item label="证件类型：" prop="certType">
          <el-select v-model="filters.certType" placeholder="请选择证件类型">
            <el-option label="居民身份证" value="10"></el-option>
            <el-option label="户口簿" value="11"></el-option>
            <el-option label="中国护照-中华人民共和国因公护照" value="122"></el-option>
            <el-option label="中国护照-中华人民共和国因私护照" value="121"></el-option>
            <el-option label="军官证" value="13"></el-option>
            <el-option label="军人士兵证" value="14"></el-option>
            <el-option label="香港居民来往内地通行证" value="15"></el-option>
            <el-option label="台湾居民来往大陆通行证" value="16"></el-option>
            <el-option label="临时身份证" value="17"></el-option>
            <el-option label="外国人永久居留证" value="18"></el-option>
            <el-option label="警官证" value="19"></el-option>
            <el-option label="其他证件" value="1X"></el-option>
            <el-option label="武警士兵证" value="1a"></el-option>
            <el-option label="军人文职干部证" value="1b"></el-option>
            <el-option label="武警文职干部证" value="1c"></el-option>
            <el-option label="驾驶证" value="1d"></el-option>
            <el-option label="军人身份证" value="1e"></el-option>
            <el-option label="武装警察身份证" value="1f"></el-option>
            <el-option label="外国公民护照" value="1g"></el-option>
            <el-option label="澳门居民来往内地通行证" value="1h"></el-option>
            <el-option label="军事学员证" value="1i"></el-option>
            <el-option label="军官退休证" value="1j"></el-option>
            <el-option label="文职干部退休证" value="1k"></el-option>
            <el-option label="离休干部荣誉证" value="1l"></el-option>
            <el-option label="边民出入境通行证" value="1m"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="证件号码：" prop="certNum">
          <el-input v-model="filters.certNum" placeholder="证件号码"></el-input>
        </el-form-item>
        <el-form-item label="是否农户：" prop="isFarmer">
          <el-select v-model="filters.isFarmer" placeholder="请选择是否农户">
            <el-option label="否" value="0"></el-option>
            <el-option label="是" value="1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否信贷客户：" prop="isPotentialCust">
          <el-select v-model="filters.isPotentialCust" placeholder="请选择是否信贷客户">
            <el-option label="否" value="0"></el-option>
            <el-option label="是" value="1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="手机号码：" prop="phoneNumber">
          <el-input v-model="filters.phoneNumber" placeholder="手机号码"></el-input>
        </el-form-item>
        <el-form-item label="单位地址：" prop="unitAdress">
          <el-input v-model="filters.unitAdress" placeholder="单位地址"></el-input>
        </el-form-item>
        <el-form-item>
          <kt-button :label="$t('action.search')" type="primary" @click="findPage(null),changePageNum()"/>
        </el-form-item>
        <el-form-item>
          <kt-button :label="$t('action.reset')" type="primary" @click="resetForm" />
        </el-form-item>
        <el-form-item>
          <kt-button :label="$t('action.add')" type="primary" @click="handleAdd" />
        </el-form-item>
      </el-form>
    </div>
  <!--表格内容栏-->
    <kt-table
              :data="pageResult" :columns="columns" :loading="loading" :showDelete="showDelete"
              :showBatchDelete="showBatchDelete" :showView="showView"
              @findPage="findPage" @handleEdit="handleEdit" @handleView="handleView"
              :operaButtons = "[]" >
    </kt-table>
  <!-- 新增界面-->
    <el-dialog title="新增自然人客户" width="50%":visible.sync="dialogVisible"
               :close-on-click-modal="false" @close='closeAdd'>
      <el-row :gutter="20">
        <el-form :model="dataForm" label-width="120px" :rules="dataFormRules" ref="dataForm" :size="size"
                 label-position="right">
          <el-col :span="12">
          <el-form-item label="证件类型：" prop="certType">
            <el-select v-model="dataForm.certType" placeholder="请选择证件类型">
              <el-option label="居民身份证" value="10"></el-option>
              <el-option label="户口簿" value="11"></el-option>
              <el-option label="中国护照-中华人民共和国因公护照" value="122"></el-option>
              <el-option label="中国护照-中华人民共和国因私护照" value="121"></el-option>
              <el-option label="军官证" value="13"></el-option>
              <el-option label="军人士兵证" value="14"></el-option>
              <el-option label="香港居民来往内地通行证" value="15"></el-option>
              <el-option label="台湾居民来往大陆通行证" value="16"></el-option>
              <el-option label="临时身份证" value="17"></el-option>
              <el-option label="外国人永久居留证" value="18"></el-option>
              <el-option label="警官证" value="19"></el-option>
              <el-option label="其他证件" value="1X"></el-option>
              <el-option label="武警士兵证" value="1a"></el-option>
              <el-option label="军人文职干部证" value="1b"></el-option>
              <el-option label="武警文职干部证" value="1c"></el-option>
              <el-option label="驾驶证" value="1d"></el-option>
              <el-option label="军人身份证" value="1e"></el-option>
              <el-option label="武装警察身份证" value="1f"></el-option>
              <el-option label="外国公民护照" value="1g"></el-option>
              <el-option label="澳门居民来往内地通行证" value="1h"></el-option>
              <el-option label="军事学员证" value="1i"></el-option>
              <el-option label="军官退休证" value="1j"></el-option>
              <el-option label="文职干部退休证" value="1k"></el-option>
              <el-option label="离休干部荣誉证" value="1l"></el-option>
              <el-option label="边民出入境通行证" value="1m"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
          <el-col :span="12">
            <el-form-item label="证件号码：" prop="certNum">
              <el-input v-model="dataForm.certNum" placeholder="证件号码"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="客户名称：" prop="partyName">
              <el-input v-model="dataForm.partyName" placeholder="客户名称"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="国籍：" prop="countrySign">
              <el-select v-model="dataForm.countrySign" placeholder="请选择国籍">
                <el-option label="中国" value="10"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="中征码：" prop="middleCode">
              <el-input v-model="dataForm.middleCode" placeholder="中征码"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否授信客户：" prop="isPotentialCust">
              <el-select v-model="dataForm.isPotentialCust" placeholder="请选择是否授信客户">
                <el-option label="否" value="0"></el-option>
                <el-option label="是" value="1"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否第三方客户：" prop="isThirdCust">
              <el-select v-model="dataForm.isThirdCust" @change="isThird" placeholder="请选择是否第三方客户">
                <el-option label="否" value="0"></el-option>
                <el-option label="是" value="1"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="第三方客户类型：" prop="thirdCustTypeCd">
              <el-select v-model="dataForm.thirdCustTypeCd" v-bind:disabled="third" placeholder="请选择第三方客户类型">
                <el-option label="委托方" value="0"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发证日期：" prop="certCreateDate">
              <el-date-picker
                v-model="dataForm.certCreateDate"
                type="date"
                align= "left"
                placeholder="选择发证日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="到期日期：" prop="certEndDate">
              <el-date-picker
                v-bind:disabled="isLong"
                v-model="dataForm.certEndDate"
                type="date"
                align= "left"
                placeholder="选择到期日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="长期：">
              <el-checkbox v-model="isCheck" @change="isEndLong"></el-checkbox>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button :size="size" type="primary" @click.native="submitForm" :loading="editLoading">{{$t('action.submit')}}</el-button>
        <el-button :size="size" @click.native="dialogVisible = false">{{$t('action.cancel')}}</el-button>
      </div>
    </el-dialog>
    <el-dialog title="自然人客户信息" width="99%" v-if="viewVisible" :visible.sync="viewVisible" :close-on-click-modal="false" :fullscreen="true"
               @close='closeDialog'>
      <div>
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
          <el-menu-item index="natural_info">客户概况信息<span style="color: red">*</span></el-menu-item>
          <el-menu-item index="csm_entrust_account_list">委托方账户信息</el-menu-item>
          <el-submenu index="1">
            <template slot="title">关系人信息</template>
            <el-menu-item index="natural_relative">对私客户关系个人信息</el-menu-item>
            <el-menu-item index="natural_relative_corp">对私客户关系企业信息</el-menu-item>
          </el-submenu>
          <el-menu-item index="natural_business">经营信息</el-menu-item>
          <el-menu-item index="natural_school">高校信息</el-menu-item>
          <el-menu-item index="natural_credit_list">信用信息<span style="color: red">*</span></el-menu-item>
          <el-menu-item index="csm_external_eval_result_list">评级信息</el-menu-item>
          <el-menu-item index="csm_impornant_event_list">重大事件</el-menu-item>
          <el-menu-item index="ews_warn_main">预警信息</el-menu-item>
          <el-menu-item index="natural_additive_list">附加信息</el-menu-item>
          <el-submenu index="2">
            <template slot="title">本行业务信息</template>
            <el-submenu index="2-1">
              <template slot="title">本行融资情况</template>
              <el-menu-item index="financing_list">批复信息</el-menu-item>
              <el-menu-item index="financing_list_yewu">业务信息</el-menu-item>
            </el-submenu>
            <el-submenu index="2-2">
              <template slot="title">为我行客户担保情况</template>
              <el-menu-item index="guarantee_list">本行保证情况</el-menu-item>
              <el-menu-item index="guarantee_list_diya">本行抵质押情况</el-menu-item>
            </el-submenu>
            <el-menu-item index="csm_illegal_list">违约记录</el-menu-item>
            <el-menu-item index="refuse_list">拒贷信息</el-menu-item>
          </el-submenu>
          <el-menu-item index="csm_manage_team_list">我行管理团队</el-menu-item>
          <el-menu-item index="pro_biz_upload">相关文档</el-menu-item>
          <el-menu-item index="">影像资料</el-menu-item>
        </el-menu>
        <keep-alive>
          <router-view></router-view>
        </keep-alive>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import PopupTreeInput from "@/components/PopupTreeInput";
  import KtTable from "@/views/Core/KtTable";
  import KtButton from "@/views/Core/KtButton";
  import { format } from "@/utils/datetime";
  import commonUtil from "@/utils/commonUtil";
  import TableTreeColumn from '@/views/Core/TableTreeColumn';
  import {getAllOrgTree} from '@/utils/commonSysManageUtil';
  import enums from '@/utils/enums';
  export default {
    components:{
      PopupTreeInput,
      KtTable,
      KtButton
    },
    data() {
      return {
        handleType: '',
        activeIndex: 'natural_info', //详细选项选中项
        loading: false, //列表加载动画
        showOperation: false,
        showBatchDelete: false,
        showDelete: false,
        showView: true,
        isCheck: false, //是否选择长期
        isLong: false, //是否长期
        third: true, //是否第三方客户
        isRouterAlive: true,
        size: 'small',
        filters: {
          partyNum: '',
          partyName: '',
          certType: '',
          certNum: '',
          isFarmer: '',
          isPotentialCust: '',
          phoneNumber: '',
          unitAdress: ''
        },
        columns: [
          {prop:"partyNum", label:"客户编号", minWidth:50},
          {prop:"partyName", label:"客户名称", minWidth:50
          },
          {prop:"certType", label:"证件类型", minWidth:50,formatter:function(row, column, cellValue, index){
              return row.certType == '10' ? '居民身份证' : '其他'}},
          {prop:"certNum", label:"证件号码", minWidth:50},
          {prop:"isFarmer", label:"是否农户", minWidth:50,formatter:function(row, column, cellValue, index){
              return row.isFarmer == '0' ? '否' : '是'}
          },
          {prop:"isPotentialCust", label:"是否信贷客户", minWidth:50,formatter:function(row, column, cellValue, index){
              return row.isPotentialCust == '0' ? '否' : '是'}},
          {prop:"isThirdCust", label:"是否第三方客户", minWidth:50,formatter:function(row, column, cellValue, index){
              return row.isThirdCust == '0' ? '否' : '是'}},
          {prop:"thirdCustTypeCd", label:"第三方客户类型", minWidth:50},
          {prop:"phoneNumber", label:"手机号码", minWidth:50}
        ],
        pageRequest: { pageNum: 1, pageSize: 10 },
        pageResult: {},

        dialogVisible: false, // 新增编辑界面是否显示
        viewVisible : false, //详情页面是否显示
        editLoading: false,
        dataFormRules: {
          name: [
            { required: true, message: '请输入用户名', trigger: 'blur' }
          ]
        },
        // 新增界面数据
        dataForm: {
          certType: '',certNum: '',partyName: '',countrySign: '',
          middleCode: '',isPotentialCust: '',isThirdCust: '',thirdCustTypeCd: '',
          certCreateDate: '',certEndDate: ''
        },
        selectData: [],
        genders: enums.genderCd,yesOrNo: enums.yesOrNo
      }
    },
    methods: {

        //重置
        resetForm: function(){
          this.$refs.formCustom.resetFields();
        },

        changePageNum: function(){
          this.pageRequest.pageNum = 1
        },
        //是否第三方客户判断
        isThird: function(){
          if(this.dataForm.isThirdCust==1){
            this.third = false
          }else{
            this.third = true
          }
        },
        //是否长期判断
        isEndLong: function(){
          if(this.isCheck==true){
            this.isLong = true
            this.dataForm.certEndDate = "9999-12-31"
          }else{
            this.isLong = false
            this.dataForm.certEndDate = ""
          }
        },

        // 获取分页数据
        findPage: function (data) {
          this.loading = true
          if(data !== null) {
            this.pageRequest = data.pageRequest
          }
          commonUtil.extend(this.pageRequest,this.filters)
          this.$api.cusManage_naturalCus.findPage(this.pageRequest).then((res) => {
            console.log('userRes:'+JSON.stringify(res.data))
            this.pageResult = res.data.data
            this.loading = false
          }).catch((res) => {
            this.$message({message: '初始查询用户信息失败, 错误信息：' + res, type: 'error'})
            console.error('初始查询用户信息失败, 错误信息：' + res)
          }).then(data!=null?data.callback:'')
        },
        // 表单提交
        submitForm () {
          this.$refs['dataForm'].validate((valid) => {
            if (valid) {
              this.$confirm('确认提交吗？', '提示', {}).then(() => {
                this.editLoading = true;
                let params = Object.assign({}, this.dataForm);
                this.$api.cusManage_naturalCus.save(params).then((res) => {
                  this.editLoading = false;
                  if(res && res.data && res.data.code == 200) {
                    this.$message({ message: '添加成功', type: 'success' });
                    this.dialogVisible = false;
                    this.viewVisible = true;
                    this.handleType = 'add';
                    this.$router.push({ path : '/cusManage/natureCus/natural/natural_info',
                      query : { vueType:'add', partyId:res.data.partyId
                      }
                    });
                    this.selectData = Object.assign({},res.data, this.dataForm);
                    this.isCheck = false;
                    this.$refs['dataForm'].resetFields();
                  } else {
                    this.$message({message: '添加失败, ' + res.data.msg, type: 'error'})
                  }
                }).catch((res) =>{
                  console.error(JSON.stringify(res))
                })

              })
            }
          })
        },
        // 编辑
        handleEdit: function (row) {
          console.log(row);
          this.viewVisible = true;
          this.handleType = 'edit';
          this.selectData = Object.assign({},row.row);
          this.$router.push({ path : '/cusManage/natureCus/natural/natural_info',
            query : { vueType:'edit',partyId: row.row.partyId
            }
          })
        },
        // 查看
        handleView: function (row) {
          this.viewVisible = true;
          this.handleType = 'view';
          this.selectData = Object.assign({},row.row);
          this.$router.push({ path : '/cusManage/natureCus/natural/natural_info',
            query : { vueType:'view',partyId: row.row.partyId
            }
          })
        },
        // 批量删除
        handleDelete: function (data) {
          console.info("删除用户",JSON.stringify(data))
          this.$api.user.batchDelete(data.params).then(data!=null?data.callback:'')
        },
        // 显示新增界面
        handleAdd: function () {
          this.dialogVisible = true
          this.dataForm = {
          }
        },
        // 时间格式化
        dateFormat: function (row, column, cellValue, index){
        return format(row[column.property])
        },
        handleSelect(key, keyPath) {
          if(this.handleType == 'add'){
            this.$router.push({ path:'/cusManage/natureCus/natural/'+ key,
              query : { vueType:'add',rowData:this.selectData
              }
            })
          }else if(this.handleType == 'edit'){
            this.$router.push({ path:'/cusManage/natureCus/natural/'+ key,
              query : { vueType:'edit',rowData:this.selectData
              }
            })
          }else{
            this.$router.push({ path:'/cusManage/natureCus/natural/'+ key,
              query : { vueType:'view',rowData:this.selectData
              }
            })
          }
        },
        closeDialog(){
           console.log("进入关闭回调");
           this.findPage(null);
        },
        closeAdd(){
           this.isCheck = false;
        },
    }
  }
</script>

<style scoped>

</style>
