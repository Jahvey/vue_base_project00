import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: 'csc-plat/user/login',
    method: 'post',
    entity: {
      'username':username,
      'password':password
    }
  })
}

export function getInfo(userLogin) {
  return request({
    url: 'csc-plat/user/userInfo',
    method: 'post',
    entity: userLogin
  })
}

export function logout() {
  return request({
    url: 'csc-plat/user/logout',
    method: 'post'
  })
}
