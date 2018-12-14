import Mock from 'mockjs';

const Orgs = [];

for (let i = 0; i < 86; i++) {
  Orgs.push(Mock.mock({
    id: Mock.Random.guid(),
    // corpName: Mock.Random.cname,
    corpName: Mock.Random.address,
    corpPropCd: Mock.Random.integer(0, 1, 2, 3, 4),
    // busiLicenseNo: Mock.mock('@county(true)'),
    // 'age|18-60': 1,
    // sex: Mock.Random.integer(0, 1)
    busiLicenseNo: Mock.Random.integer,
    officePhoneNo: Mock.Random.integer,
    email: Mock.Random.integer,
    adminPhoneNo: Mock.Random.integer
  }));
}

export {  Orgs };
