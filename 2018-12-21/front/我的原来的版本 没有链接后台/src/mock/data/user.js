import Mock from 'mockjs';
const LoginUsers = [
  {
    id: 1,
    username: 'admin',
    password: '123456',
    avatar: 'https://raw.githubusercontent.com/taylorchen709/markdown-images/master/vueadmin/user.png',
    name: '帅逼'
  }
];

const Users = [];   //定义路由

for (let i = 0; i < 36; i++) {    //let：ES6的新写法，区别于var，这个专门指代局部变量
  Users.push(Mock.mock({    //给user后面追加
    id: Mock.Random.guid(),
    name: Mock.Random.cname(),
    addr: Mock.mock('@county(true)'),
    'age|18-60': 1,
    birth: Mock.Random.date(),
    sex: Mock.Random.integer(0, 1)
  }));
}




export { LoginUsers, Users };
