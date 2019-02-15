import User from '../components/nav1/User.vue'
import Form from '../components/nav1/Form.vue'
import Table from '../components/nav1/Table.vue'
import First from '../components/nav2/First.vue'
import Second from '../components/nav2/Second.vue'
import Three from '../components/nav2/Three.vue'
import HomePage from '../components/home/HomePage.vue'
import TableBasicInfo from '../components/nav1/TableBasicInfo.vue'
import TableSubjectInfo from '../components/nav1/TableSubjectInfo.vue'


export const mainRouter = [
  {
    path: '/',
    name: '导航一',
    iconCls: 'el-icon-message',
    component: HomePage,
    children: [
      {
        path: 'table',
        component: Table,
        name: '第一个',
        children: [
          {
            path: 'basicInfo',
            component: TableBasicInfo
          },
          {
            path: 'subjectInfo',
            component: TableSubjectInfo
          }
        ]
      },
      {
        path: 'form',
        component: Form,
        name: '第二个'
      },
      {
        path: 'user',
        component: User,
        name: '第三个'
      }
    ]
  },
  {
    path: '/',
    name: '导航二',
    iconCls: 'fa fa-id-card-o',
    component: HomePage,
    children: [
      { path: '/first', component: First, name: '第一个' },
      { path: '/second', component: Second, name: '第二个' },
      { path: '/three', component: Three, name: '第三个' }
    ]
  }
]
