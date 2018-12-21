import request from '@/utils/request'
import {myGet,myPost} from '@/utils/request1'

export function getTbCsmNaturalPersonInfoById(queryParams) {
  // return request({
  //   // url: 'mybatis-service/mynatureal/queryNaturalForDesk',
  //   url: 'mybatis-service/mynatureal/getTbCsmNaturalPersonInfoById',
  //   method: 'get',
  //   entity: queryParams
  // })
  console.log("传入参数1:"+JSON.parse(JSON.stringify(queryParams)));
  return request.get('mybatis-service/mynatureal/getTbCsmNaturalPersonInfoById',queryParams);

}

export function getTbCsmPartyInfoById(queryParams) {

  // return request({
  //   // url: 'mybatis-service/mynatureal/queryNaturalForDesk',
  //   url: 'mybatis-service/mynatureal/getTbCsmPartyInfoById',
  //   method: 'get',
  //   entity: queryParams
  // })
  //   console.log("传入参数1:"+this.$.parseJSON(JSON.stringify(queryParams)));
  console.log("传入参数1:"+JSON.parse(JSON.stringify(queryParams)));
  // return request.get('mybatis-service/mynatureal/getTbCsmPartyInfoById',queryParams);

  return myGet('mybatis-service/mynatureal/getTbCsmPartyInfoById',queryParams);


}
