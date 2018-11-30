const nav={
  state: {
    leftMenuList: [
      {
        name: '导航一',
        index: 'first',
        children: [
          { path: '/table', name: '第一个' },
          { path: '/form', name: '第二个' },
          { path: '/user', name: '第三个' }
        ]
      },
      {
        name: '导航二',
        index: 'second',
        children: [
          { path: '/first', name: '第四个' },
          { path: '/second', name: '第五个' },
          { path: '/three',  name: '第六个' }
        ]
      }
    ]
  },
  mutations: {



  },
  actions: {

  },
  getters: {

  }
}

export default nav
