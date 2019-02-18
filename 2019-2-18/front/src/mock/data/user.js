import Mock from 'mockjs';

const Users = [];

for (let i = 0; i < 86; i++) {
  Users.push(Mock.mock({
    id: Mock.Random.guid(),
    // username: Mock.Random.cname,
    // personName: Mock.Random.cname,
    username: Mock.Random.address,
    personName: Mock.Random.address,
    // busiLicenseNo: Mock.mock('@county(true)'),
    // 'age|18-60': 1,
    // sex: Mock.Random.integer(0, 1)
    mobile: Mock.Random.integer,
    email: Mock.Random.integer,
    org: Mock.Random.integer
  }));
}

export {  Users };
