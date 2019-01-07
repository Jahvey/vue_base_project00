<!--suppress ALL -->
<!--用信申请 对应jsp -->
<template>
  <div>



    <csc-form-page :pageDef="pageDef" :formData="form" @click="doCancel">

    </csc-form-page>

  </div>
</template>

<script>
  // 业务信息之业务基本信息
  import CscFormPage from '@/components/CscFormPage/CscFormPage'
  import { getBizInfo } from '@/api/csm' 


  export default {
    data() {
      return {
        srvObj: {},
        form: {
         // biz_info: [],

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
            { label: '申请期限:', inputType: 'input', modelName: 'termNum' },
            { label: '申请期限:', inputType: 'input', modelName: 'termUnit' },
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

    created() {
      
      //let param=this.$store.state.urlParam.queryParam
      //let param=this.$route.query
      let param=this.$route.params
      this.getBizInfo(param)
    },


    methods: {
      doCancel() {
        this.$router.back()
      },

    async getBizInfo(param) {


        console.log('approveId:.............'+param.approveId)
        // 打印一下这里拿到参数没有
        getBizInfo(param).then(response => {  

          this.form = response.data
          console.log(this.form)
        }).catch((error) => {
          console.log(error)
        })
      },


    },
    // mounted() {				// 页面加载完毕之后进行的渲染
    //   this.contractList()
    // }
  }


</script>
