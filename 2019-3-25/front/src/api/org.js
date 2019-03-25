import request from '@/utils/request'

export function getOrgList(queryParams) {


  // return request({
  //   url: 'csc-plat/org/pageQueryOrg',
  //   method: 'post',
  //   entity: queryParams
  //   // entity:queryParams
  // })


}

export function getAllServices() {
  return request({
    url: 'csc-plat/servicetype/queryAllValidServiceType',
    method: 'post'
  })
}

export function saveOrg(orgInfo) {
  return request({
    url: 'csc-plat/org/saveOrg',
    method: 'post',
    entity: orgInfo
  })
}

export function deleteOrg(orgInfo) {
  return request({
    url: 'csc-plat/org/deleteOrg',
    method: 'post',
    entity: orgInfo
  })
}

export function queryOrg(orgInfo){
  return request({
    url: 'csc-plat/org/queryOrg',
    method: 'post',
    entity: orgInfo
  })
}






