webpackJsonp([6],{"6ESP":function(e,t,r){"use strict";var s=function(){var e=this,t=e.$createElement;return(e._self._c||t)("csc-single-table",{attrs:{pageDef:e.pageDef,entity:e.entity},on:{pageQuery:e.doPageQuery,create:e.create,doEdit:e.doEdit,doDelete:e.doDelete,rowDbclick:e.rowDbclick}})},n=[],u={render:s,staticRenderFns:n};t.a=u},ANSR:function(e,t,r){"use strict";var s=r("XHbZ"),n=r("vMJZ");t.a={data:function(){return{entity:{},pageDef:{queryDef:{columnNum:3,queryCols:[{label:"用户名",inputType:"input",modelName:"username"},{label:"姓名",inputType:"input",modelName:"personName"},{label:"手机号",inputType:"input",modelName:"mobile"}]},tabDef:{isSelect:!1,isIndex:!0,tabCols:[{label:"用户名",prop:"username",isSort:!0},{label:"姓名",prop:"personName",isSort:!0},{label:"手机号",prop:"mobile",isSort:!0},{label:"邮箱",prop:"email",isSort:!0},{label:"机构",prop:"org",isSort:!0}]},buttons:[{label:"新增",funcName:"create"},{label:"重置密码",funcName:"resetPassword"}]}}},components:{CscSingleTable:s.a},methods:{doPageQuery:function(e){this.userList(e)},userList:function(e){var t=this;Object(n.b)(e).then(function(e){t.entity=e}).catch(function(e){console.log(e)})},rowDbclick:function(e){this.$router.push({path:"/user/add/card/"+e.userId})},create:function(){this.$router.push({path:"/user/add"})},doEdit:function(e){this.$router.push({path:"/user/add/edit/"+e.userId})},doDelete:function(e,t){var r=this;Object(n.a)(e).then(function(e){r.userList(t),r.$message({type:"success",message:"删除成功!"})})}}}},iNcC:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=r("ANSR"),n=r("6ESP"),u=r("VU/8"),o=u(s.a,n.a,!1,null,null,null);t.default=o.exports},vMJZ:function(e,t,r){"use strict";function s(e){return Object(i.a)({url:"csc-service/user/queryUserByOrgid",method:"post",entity:e})}function n(e){return Object(i.a)({url:"csc-service/user/saveUser",method:"post",entity:e})}function u(e){return Object(i.a)({url:"csc-service/user/saveUser",method:"post",entity:e})}function o(e){return Object(i.a)({url:"csc-service/user/queryUser",method:"post",entity:e})}function c(e){return Object(i.a)({url:"csc-service/user/queryUserRole",method:"post",entity:e})}t.b=s,t.e=n,t.a=u,t.c=o,t.d=c;var i=r("vLgD")}});
//# sourceMappingURL=6.58f13f82fc56ea2cb085.js.map