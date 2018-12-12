<!--suppress ALL -->
<!--用信申请 对应jsp -->
<template>
  <div>
    <csc-form-page :pageDef="pageDef" :formData="form" @click="doCancel">
      <el-form-item slot="biz_info" label="业务结构基本信息" prop="biz_info"><!--这个label展示在下面-->
        <el-checkbox-group v-model="form.biz_info">
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
  // 业务信息之业务基本信息
  import CscFormPage from '@/components/CscFormPage/CscFormPage'
  // import { getContractList } from '@/api/contract' // 暂时没有使用


  export default {
    data() {
      return {
        srvObj: {},
        form: {
          biz_info: [],


        },
        refVisible: { pkOrg: false },
        pageDef: {
          disabled: true, // 页面按钮隐藏，并且变为只读属性
          name: '用户信息',
          columnNum: 2,
          pageCols: [// 这里需要改为只读属性，格式有问题
            { label: '客户编号:', inputType: 'input', modelName: 'partyNum' },
            { label: '客户名称:', inputType: 'input', modelName: 'partyName' },
            { label: '证件类型:', inputType: 'select', modelName: 'certType' },

            { label: '证件号码:', inputType: 'input', modelName: 'certNum' },


            { label: '信用等级:', inputType: 'input', modelName: 'csmCrdLevel' },
            { label: '业务品种:', inputType: 'input', modelName: 'productType' },
            { label: '业务类型:', inputType: 'input', modelName: 'bizHappenType' },
            { label: '用信编号:', inputType: 'input', modelName: 'bizNum' },

            { label: '申请额度(元):', inputType: 'input', modelName: 'rmbAmt' },
            { label: '申请期限:', inputType: 'input', modelName: 'sqqx' },
            { label: '申请期限:', inputType: 'input', modelName: 'sqqx' },
            { label: '担保方式:', inputType: 'input', modelName: 'guarantyType' },
            { label: '是否银团:', inputType: 'input', modelName: 'isBankTeamLoan' },
            { label: '业务状态:', inputType: 'input', modelName: 'becomeEffectiveMark' },
            { label: '是否有按揭合作商:', inputType: 'input', modelName: 'busiPartner' },
            { label: '是否个人购买保障性住房:', inputType: 'input', modelName: 'whetherBzxzfdk' },
            { label: '低风险类型:', inputType: 'textarea', modelName: 'lowRiskBizType' },
            { label: '经办机构:', inputType: 'input', modelName: 'orgNum' },
            { label: '经办人：', inputType: 'input', modelName: 'userNum' },
            { label: '申请日期：', inputType: 'input', modelName: 'applyDate' },
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
