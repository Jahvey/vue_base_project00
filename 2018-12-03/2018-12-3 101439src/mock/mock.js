import axios from 'axios'
import MockAdapter from 'axios-mock-adapter'

import { Contract } from './data/contract' // 这是在contract.js里面定义的生成假数据的文件

const _Contract = Contract

export default {
  /**
   * mock bootstrap
   */
  bootstrap() {
    const mock = new MockAdapter(axios)

    // mock success request
    mock.onGet('/success').reply(200, {
      msg: 'success'
    })

    // mock error request
    mock.onGet('/error').reply(500, {
      msg: 'failure'
    })

    // 进行数据测试  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //  mock.onPost('/csc-service/contract/paginQueryContractByOrgid').reply(config => {
    mock.onGet('/contract/list').reply(config => { // 试一试把POST请求改为Get请求
      const { name } = config.params // const改let
      const mockContract = _Contract.filter(contract => {
        if (name && contract.partyName.indexOf(name) == -1) {
          return false
        }
        return true
      })
      console.log('mockContract.....' + mockContract)
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            contract: mockContract // 这个contract是定义的哪里的？？？demo里面是自定义的数据，这个是再次封装
          }]) // pageDef.tabDef.tabCols
        }, 1000)
      })
    })
  }

}
