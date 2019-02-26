<template>
  <div>
    <csc-el-transfer :pageDef="pageDef" @getLeftData="getLeftData" @getRightData="getRightData"
                     @grantAuth="grantAuth" @cancelAuth="cancelAuth" @handleChange="handleChange" @doQuery="doQuery">

    </csc-el-transfer>
  </div>

</template>

<script>
    import CscElTransfer from "../../components/CscElTransfer/CscElTransfer";
    import {queryPartyRole,orgRoleAllowAdd} from '@/api/user'

    export default {
      components: {CscElTransfer},
      name: "user-transfer",
      data() {
        return {

          pageDef:{
            isManyButton: true,//2019-1-17 后期修改transfer 下的main.vue 可以支持多个按钮
            showButton: false,//是否展示按钮
            buttonTexts:["授权","取消授权"],
            titles: ['已授予角色', '未授予角色'],
            // name: {key: 'value',label: 'desc'},//设置别名
            name: {key: 'ROLEID',label: 'ROLENAME'},//设置别名
            totalData: [],//两边总共的数据  应该是组件自己去区分加载
            rightData: [],//右侧选择框值 调用服务查询  未有角色
            leftData: [] //左侧选择框值   已有角色
          }
        }
      },
      props:{

      },
      methods:{
        doQuery() {//一次查询能否把左右两侧数据都查询出来
          queryPartyRole({partytype:"org",partyid:"4000",leg_org:"4099"}).then(response => {
            // alert("具体值2:"+response);
            // alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
            if (response !== undefined) {
              var obj = {}
              console.log("queryPartyRole:"+JSON.stringify(response.data.rightData));
              this.pageDef.rightData = response.data.rightData;
              this.pageDef.totalData = response.data.totalData;
            }
          })
        },
        getLeftData() {
          console.log("getLeftData");
          queryPartyRole({partytype:"org",partyid:"4000",legorg:"4099"}).then(response => {
            // alert("具体值2:"+response);
            // alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
            if (response !== undefined) {
              var obj = {}
              this.pageDef.leftData = response.data;
            }
          })
        },
        getRightData() {
          console.log("getRightData");
          orgRoleAllowAdd({partytype:"org",partyid:"4000",legorg:"4099"}).then(response => {
            // alert("具体值2:"+response);
            // alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
            if (response !== undefined) {
              var obj = {}
              this.pageDef.rightData = response.data;
            }
          })
        },
        grantAuth(value,movedKeys) {

          //调用后台方法完成角色增加
          console.log("grantAuth");
        },
        cancelAuth(value,movedKeys) {

          //调用后台方法完成角色取消
          console.log("cancelAuth");
        },
        handleChange(value,direction,movedKeys){
          console.log("userTransfer:"+value+"--"+direction+"--"+movedKeys);
          if(direction && direction=='left'){
            this.grantAuth(value,movedKeys);
          }else if(direction && direction=='right'){
            this.cancelAuth(value,movedKeys);
          }
        }
      }
    }
</script>

<style scoped>

</style>
