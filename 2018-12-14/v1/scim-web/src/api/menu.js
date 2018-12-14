
import request from '@/utils/request'

// 动态查询菜单
export function queryFuncInfo(param) {
  return request({
    url: 'csc-service/authority/queryFuncInfo',
    method: 'post',
    entity: param
  })
}
