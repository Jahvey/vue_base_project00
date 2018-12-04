<!--suppress ALL -->
<template>
  <div>
    <csc-form-page :pageDef="pageDef" :formData="form" @click="doCancel">
      <el-form-item slot="clientBaseInfoShow" label="客户基本信息" prop="clientBaseInfoShow"><!--这个label展示在下面-->
        <el-checkbox-group v-model="form.clientBaseInfoShow">
          <template v-for="(value,key) in srvObj"><!--遍历表单srvObj-->
            <el-col :span="8">
              <el-checkbox :key="value.roleId" :label="key" :name="key"><!--:key值需要更改，这里没有roleId-->
              </el-checkbox>
            </el-col>
          </template>
        </el-checkbox-group>
      </el-form-item>
    </csc-form-page>
  </div>
</template>

<script>
  // 业务结构之基本信息 /default/biz/biz/biz_info.jsp
  import CscFormPage from '@/components/CscFormPage/CscFormPage'
  // import { getContractList } from '@/api/contract' // 暂时没有使用


  export default {
    data() {
      return {
        srvObj: {},
        form: {
          clientBaseInfoShow: [],
          partyNum:'011004323050',
          partyName:'军育苗',
          certType:'居民身份证',
          certNum:'510721196601019530',
          csmCrdLevel:'无',
          productType:'快帮贷',
          bizHappenType:'存量新增',
          bizNum:'YW180906015696',
          rmbAmt:'20,000.00',
          termNum:'12月',
          guarantyType:'信用',
          isBankTeamLoan:'否',
          becomeEffectiveMark:'已生效',
          orgNum:'0700',
          userNum:'李谭荔',
          applyDate:'2018-09-06'
        },
        refVisible: { pkOrg: false },
        pageDef: {
          disabled: true, // 页面按钮隐藏，并且变为只读属性
          name: '用户信息',
          columnNum: 2,
          pageCols: [// 格式有问题
            { label: '客户编号:', inputType: 'input', modelName: 'partyNum' },
            { label: '客户名称:', inputType: 'input', modelName: 'partyName' },
            { label: '证件类型:', inputType: 'input', modelName: 'certType' },
            { label: '证件号码:', inputType: 'input', modelName: 'certNum' },
            { label: '信用等级:', inputType: 'input', modelName: 'csmCrdLevel' },
            { label: '业务品种:', inputType: 'input', modelName: 'productType' },
            { label: '业务类型:', inputType: 'input', modelName: 'bizHappenType' },
            { label: '业务编号:', inputType: 'input', modelName: 'bizNum' },
            { label: '申请额度（元）:', inputType: 'input', modelName: 'rmbAmt' },
            { label: '申请期限:', inputType: 'input', modelName: 'termNum' }, // 有一些问题
            { label: '担保方式:', inputType: 'select', modelName: 'guarantyType' }, // checkbox
            { label: '是否银团:', inputType: 'input', modelName: 'isBankTeamLoan' },
            { label: '业务状态:', inputType: 'input', modelName: 'becomeEffectiveMark' },
            // { label: '是否有按揭合作商:', inputType: 'date', modelName: 'busiPartner' },
            // { label: '是否个人购买保障性住房:', inputType: 'select', modelName: 'whetherBzxzfdk' },
            // { label: '低风险类型:', inputType: 'select', modelName: 'lowRiskBizType' },
            { label: '经办机构:', inputType: 'input', modelName: 'orgNum' },
            { label: '经办人:', inputType: 'input', modelName: 'userNum' },
            { label: '申请日期:', inputType: 'input', modelName: 'applyDate' }
          ]
        }
      }
    },

    components: { CscFormPage },


    methods: {
      doCancel() {
        this.$router.back()
      },
      contractList(listQuery) {
        const params = {
          listQuery: this.listQuery
        }

    },
    mounted() {				// 页面加载完毕之后进行的渲染
      this.contractList()
    }
  },
  }
</script>
