import axios from 'axios';

let base = '';


// axios.all([getUserAccount(), getUserPermissions()])
//   .then(axios.spread(function (acct, perms) {
// //两个请求现已完成
//   }));
export const getUserList = params => {
  return axios.get('${base}/user/tabTest', { params: params });
};

