<template>
  <div v-show=isShowYWHT>
    <csc-single-table :pageDef="pageDef"
                      :entity="entity"
                      @create="create"
                      @pageQuery="doPageQuery"
                      @doDelete="doDelete"
                      :disableQueryForm="disableQueryForm"
                      :disableRowButtons="disableRowButtons">

    </csc-single-table>

  </div>

</template>

<script>
import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
import { createConInfo, getApproveAndSxxy } from '@/api/csm'

export default {
  name: 'conApplyYwht',

  components: {
    CscSingleTable
    // conTree
  },
  props: {

    paramsConApplyTz: { // 用于接受父组件传来的参数
      // con_apply_tz传递过来的参数放在这里
    }
  },

  data() {
    return {
      paramsInfo: {// 使用父子传参的方式传递参数，父组件向子组件传递多个参数

      },
      disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
      disableRowButtons: true, // 隐藏tab表单按钮
      listLoading: false,
      entity: {

      },
      isShowYWHT: false,
      initParams: {

      },

      pageDef: {
        // 查询条件定义
        queryDef: {
          columnNum: 2, // 一行几列
          queryCols: [
            { label: '业务编号', inputType: 'input', modelName: 'bizNum' }

          ]
        },
        tabDef: {
          isCheckRadio: true,
          isSelect: false, // 是否可以多选
          isIndex: true, // 是否有序号
          // 表格字段定义
          tabCols: [

            { label: '业务编号', prop: 'bizNum', isSort: true, isLink: true, url: '/csm/con_info/con_tree', param: ['creditMode', 'partyName'] },
            { label: '客户名称', prop: 'partyName', isSort: true },
            { label: '业务性质', prop: 'creditMode', isSort: true, isFormat: true, enumType: 'creditMode' },
            { label: '业务类型', prop: 'bizHappenType', isSort: true, isFormat: true, enumType: 'bizHappenType' },
            { label: '业务品种', prop: 'productType', isSort: true, isFormat: true, enumType: 'productType' },
            { label: '币种', prop: 'currencyCd', isSort: true, isFormat: true, enumType: 'currencyCd' },
            { label: '业务额度', prop: 'detailAmt', isSort: true },

            { label: '可用额度(元)', prop: 'boUse', isSort: true },
            { label: '起始日期', prop: 'validDate', isSort: true }

          ]
        },
        buttons: [
          { label: '合同创建', funcName: 'create' }
        ]
      }
    }
  },

  created() {
    const param = this.paramsConApplyTz

    this.isShowYWHT = this.paramsConApplyTz.isShowYWHT

    console.log('页面跳转成功：' + JSON.stringify(param))
    this.doPageQuery() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
  },

  methods: {

    doPageQuery(listQuery) {
      if (listQuery != undefined) {
        console.log('doPageQuery' + JSON.stringify(listQuery))
        this.initParams = Object.assign({}, listQuery, this.paramsConApplyTz)
        console.log('initParams ' + JSON.stringify(this.initParams))

        getApproveAndSxxy(this.initParams).then((response) => {
          this.entity = response.data
          console.log('[getApproveAndSxxy]get data' + JSON.stringify(this.entity))
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      }
    },
    // 行事件
    doEdit(row) {
      console.log('row ....')
    },

    create(row) {
      console.log('[con_apply_ywht] create合同...' + JSON.stringify(row))
      createConInfo(row).then(response1 => {
        const res = response1.data

        if (res.msg != '' && res.msg != null) {
          alert(res.msg)
          return false
        }

        console.log('合同创建成功！！[ConInfo] ' + JSON.stringify(res))
        console.log('con_tree visiable ' + JSON.stringify(this.paramsConApplyTz))
        this.paramsInfo = {
          conTreeVisiable: true,
          contractId: res.conInfo.contractId,
          contractType: '02',
          amountDetailId: row.amountDetailId,
          proFlag: '1',
          processInstId: res.processInstId
        }

        console.log('con_tree visiable2 ' + JSON.stringify(this.paramsInfo))
        console.log('创建合同完成，调用父页面中的回调函数openConTree....')
        this.$emit('openConTree', this.paramsInfo)
      }).catch((error) => {
        console.log(error)
      })
    },

    doDelete() {
      // deleteContract(row).then(response => {
      //   this.contractList(listQuery)
      //   this.$message({
      //     type: 'success',
      //     message: '删除成功!'
      //   })
      // })
      console.log('del ....')
    }
  },
  mounted() {

  }

}
</script>
