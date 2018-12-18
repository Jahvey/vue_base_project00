const enums = {
  sex: {
    "M": "男性",
    "F": "女性"
  },
  corpPropCd: {
    '0': '民办',
    '1': '公办'
  },
  genderCd: {
    '0': '女',
    '1': '男'
  },
  idTypeCd: {
    '0': '身份证',
    '1': '护照',
    '2': '军官证',
    '3': '士兵证',
    '4': '港澳居民来往内地通行证',
    '5': '户口本',
    '6': '外国护照',
    '7': '其他',
    '8': '文职证',
    '9': '警官证',
    'A': '台胞证',
    'B': '外国人永久居留证'
  },
  raceCd: {
    '0': '汉',
    '1': '满',
    '2': '蒙',
    '3': '回',
    '4': '其他'
  },
  marriageCd: {
    '0': '未婚',
    '1': '已婚',
    '2': '离异'
  },
  unitCd: {
    '0': '元/小时',
    '1': '元/次',
    '2': '元/件',
    '3': '元/人',
    '4': '元/套',
    '5': '元/双',
    '6': '元/天'
  },
  state:{
    '0' : '停用',
    '1' : '启用',
    '9999' : '已删除'
  },
  publishStatus: {
    '0': '未发布',
    '1': '已发布'
  },
  auditStatus: {
    '0': '未审核',
    '1': '已审核',
    '2': '审核不通过'
  },
  remindStatus: {
    '01': '待执行',
    '02': '已发送',
    '03': '发送失败',
    '04': '发送中'
  },
  relCd: {
    '0': '父女',
    '1': '母女',
    '2': '父子',
    '3': '母子'
  },
  isGuard: {
    '0': '是',
    '1': '否'
  },
  docTypeCd: {
    '0': '养生',
    '1': '旅游',
    '2': '新闻',
    '2': '新闻'
  },
  docPriCd: {
    '0': '高',
    '1': '中',
    '2': '低'
  },
  billstatus: {
    '0': '未复核',
    '1': '已复核',
    '2': '已审核',
    '3': '已作废'
  },
  mnpltTpcd: {
    '01': '新增',
    '02': '修改',
    '03': '删除',
    '04': '审核通过',
    '05': '审核不通过',
    '06': '反审核',
    '07': '复核通过',
    '08': '复核不通过',
    '09': '废止',
    '10': '导入'
  },
  srvTypeCd: {
    '0': '政务',
    '1': '平台',
    '2': '客服'
  },
  ifvalid:{
    '0' : '否',
    '1' : '是'
  },
  bookStatus: {
    '1': '可预订',
    '2': '已预订',
    '3': '已入住',
    '4': '待评价',
    '5': '已评价',
  },
  dateRepeatTypeCd:{
    '0' : '每天',
    '1' : '每周重复',
    '2' : '间隔天数重复'
  },
  timeRepeatTypeCd:{
    '0' : '固定时间',
    '1' : '间隔分钟'
  },
  intervalRemindMinute:{
    '0' : '每隔30分钟',
    '1' : '每隔60分钟',
    '2' : '每隔90分钟',
    '3' : '每隔120分钟',
    '4' : '每隔180分钟',
    '5' : '每隔240分钟',
    '6' : '每隔300分钟',
    '7' : '每隔360分钟'
  },
  dosageUnit:{
    '0' : 'ml',
    '1' : 'mg',
    '2' : '片',
    '3' : '粒'
  },
  ifUsed:{
    '0' : '否',
    '1' : '是'},
  payStatus:{
    '0':"未支付",
    '1':'订金已支付',
    '2':'总额已支付'
  },
  orderStatus:{
    '0' : '待付款',
    '1' : '待实施',
    '2' : '实施中',
    '3' : '待付尾款',
    '4' : '待评价',
    '5' : '已完结',
    '6' : '已取消',
    '7' : '已关闭',
    '8' : '申请退款',
    '9' : '退款完成',
    '10' : '申请更换',
    '11' : '更换完成'
  },payCd:{
    "0":"在线支付-全额",
    "1":"在线支付-订金"
  },
  ready:{
    '0':'已设计',
    '1':'默认'
  },
  status:{
    '0':'正常',
    '1':'已作废'
  },
  tplStEcd:{
    '01':'待生效',
    '02':'已生效'
  },
  searchTypeCd: {
    '01': '全文',
    '02': '标题',
    '03': '关键字',
    '04': '摘要',
    '05': '正文',
    '06': '作者名',
    '07': '知识编号'
  },
  knwldgCheckStatus: {
    '03': '创建待审核',
    '04': '修改待审核',
    '05': '删除待审核'
  },
  knwldgInactiveStatus: {
    '06': '创建退回待处理',
    '07': '修改退回待处理',
    '08': '删除退回待处理'
  },

}


export default enums

