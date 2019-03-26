import axios from '../axios'
import {myGet,myPost} from "@/utils/request1"
/* 
 * 系统登录模块
 */

// 登录
export const login = data => {
    return myPost("yl/login/userLogin",data)
}

// 登出
export const logout = () => {
    return axios({
        url: 'logout',
        method: 'get'
    })
}
