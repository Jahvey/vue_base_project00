import request from '@/utils/request'
import {myGet,myPost} from '@/utils/request1'

export function queryWorkingList(queryParams) {
  return myGet('mybatis-service/mywork/queryWorkingList',queryParams)
}

export function queryWorkedList(queryParams) {
  return myGet('mybatis-service/mywork/queryWorkedList',queryParams)
}



