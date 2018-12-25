import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import { Orgs } from './data/org';
import { Users} from './data/user'
import {UsersTest} from './data/userTest'
let _Users = Users;//定义取出的mock数据
let _Orgs = Orgs;
let _UsersTest = UsersTest;

export default {
  /**
   * mock bootstrap
   */
  bootstrap() {
    let mock = new MockAdapter(axios);
    //模拟GET请求 获取用户列表  //返回一个数组[status, data, headers]
    mock.onGet('/user/tabTest').reply(config => {
      let {name} = config.params;
      let mockUsers = _UsersTest.filter(user => {
        if (name && user.name.indexOf(name) == -1) return false;
        return true;
      });
      console.log("用户大小:"+mockUsers.length);

      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            users: mockUsers
          }]);
        }, 1000);
      });

      // var promise=new Promise((resolve, reject) => {
      //   resolve();
      // })
      // promise.then(setTimeout(() => {
      //   resolve([200, {
      //     users: mockUsers
      //   }]);
      // }, 1000))
      //   .catch(console.log("就是错误"));

      // return new Promise((resolve, reject) => {
      //   setTimeout(() => {
      //     resolve([200, {
      //       users: mockUsers
      //     }]);
      //   }, 1000);
      // });

    });
   //没有具体路径的时候 返回500
   //  mock.onPost().reply(500);

    //config是axios config,返回一个数组[status,data,headers]

  }
};
