import Mock from 'mockjs';    //导入mock的包


const Contract = [];   //定义路由

for (let i = 0; i < 6; i++) {       //问题很大啊
    Contract.push(Mock.mock({
        'id|+1':3,
        contractNum: Mock.Random.guid(),       //合同编号     name是在哪里自定义的？？？
        bizTypeFlag: Mock.Random.text,             //业务性质，有问题
        partyName:Mock.Random.cname(),          //客户名称
        certType:Mock.Random.text,            //证件类型，有问题
        'certNum|0-9':1,                   //证件号码
        productType:Mock.Random.text,         //业务品种
        beginDate:Mock.Random.date(),       //合同开始日期
        endDate:Mock.Random.date(),         //合同结束日期
        currencyCd:Mock.Random.text,        //币种
        contractAmt:Mock.Random.integer(100,200),//合同金额
        conBalance:Mock.Random.integer(0,100)//合同可用金额
    // sex: Mock.Random.integer(0, 1)
  }));
}

console.log(Contract)
export { Contract};
