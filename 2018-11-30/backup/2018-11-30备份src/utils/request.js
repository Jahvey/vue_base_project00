import axios from 'axios'
import { Message, MessageBox } from 'element-ui'
import store from '../store'
import { getToken } from '@/utils/auth'
import qs from 'qs'

// 创建axios实例
const service = axios.create({
  // baseURL: process.env.BASE_API, // api的base_url
  baseURL: "/", // api的base_url
  // baseURL: "/api/remote", //p2s转发api
  timeout: 15000                  // 请求超时时间
})

// request拦截器
service.interceptors.request.use(config => {
  if (store.getters.token) {
    config.headers['X-Token'] = getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
  }

  if(typeof(config.data) == "undefined"){
    config.data={}
  }
  //不连P2S
  if(typeof(config.entity) != "undefined"){
    config.data.msgEntity=config.entity
  }
  config.data.msgHead={}
  //request请求common域
  config.data.msgCommon={"username":store.getters.name,'stff_id': store.getters.userId}
   // 不连P2S
  //拼装P2S报文

   //origin reqBody
   // var msgData={};
   // if(typeof(config.entity) != "undefined"){
   // msgData.msgEntity=config.entity
   // }
   // msgData.msgCommon = {"username":store.getters.name,'stff_id':"USER2017121300000001"}
   // msgData.msgHead = {}
   //
   //
   // //交易转发requestBody
   // var data = {};
   // data.serviceId='restService'
   // data.serviceParam=JSON.stringify({"url":config.url})
   // data.jsonData=JSON.stringify(msgData)
   // // data.serviceParam={"url":config.url}
   // // data.jsonData=msgData
   //
   // //url置空
   // config.url=''
   // config.data = qs.stringify(data)
  //拼装P2S报文


  return config
}, error => {
  // Do something with request error
  console.log(error) // for debug
  Promise.reject(error)
})

// respone拦截器
service.interceptors.response.use(
  response => {
    //请求完成 loading改为false
    if (store.getters.listLoading) {
      store.dispatch('setListLoading', false)
    }
    if (store.getters.childLoading) {
      store.dispatch('setChildLoading', false)
    }
    /**
     * code为非00是抛错
     */
    const res = response.data
    var msgHead=res.msgHead;
    if(msgHead != undefined && msgHead.sys_tx_status != '00'){
      Message({
        message: "["+msgHead.sys_resp_code+"]"+msgHead.sys_resp_desc,
        type: 'error',
        duration: 5 * 1000
      })
      return Promise.reject('error')
    }else{
      return response.data.msgEntity
    }
    // if(res.code != '00'){
    //   Message({
    //     message: res.errorMsg,
    //     type: 'error',
    //     duration: 5 * 1000
    //   })
    //   return Promise.reject('error')
    // }
    // if (res.code !== 20000) {
    //   Message({
    //     // message: res.data,
    //     message: res.error,
    //     type: 'error',
    //     duration: 5 * 1000
    //   })
    //
    //   // 50008:非法的token; 50012:其他客户端登录了;  50014:Token 过期了;
    //   if (res.code === 50008 || res.code === 50012 || res.code === 50014) {
    //     MessageBox.confirm('你已被登出，可以取消继续留在该页面，或者重新登录', '确定登出', {
    //       confirmButtonText: '重新登录',
    //       cancelButtonText: '取消',
    //       type: 'warning'
    //     }).then(() => {
    //       store.dispatch('FedLogOut').then(() => {
    //         location.reload()// 为了重新实例化vue-router对象 避免bug
    //       })
    //     })
    //   }
    //   return Promise.reject('error')
    // } else {
    //   return response.data
    // }
    // return response.data
  },
  error => {
    console.log('err' + error)// for debug
    Message({
      message: "请求错误",
      type: 'error',
      duration: 5 * 1000
    })
    //请求完成 loading改为false
    if (store.getters.listLoading) {
      store.dispatch('setListLoading', false)
    }
    if (store.getters.childLoading) {
      store.dispatch('setChildLoading', false)
    }
    return Promise.reject(error)
  }
)

export default service
