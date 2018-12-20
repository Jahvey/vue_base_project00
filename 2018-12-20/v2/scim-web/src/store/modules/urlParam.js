const urlParam={
  state:{
    targetUrl:'',
    queryParam:{}
  },
  mutations:{
    getUrlParam(state,data){
      console.log("urlParam值1:"+state.targetUrl);
      if(!data.targetUrl){
        console.log("urlParam值2:"+JSON.stringify(data)+"state.queryParam2:"+JSON.stringify(state.queryParam));
        state.targetUrl=data.targetUrl;
        Object.assign(state.queryParam,data);
        console.log("urlParam值3:"+JSON.stringify(data)+"state.queryParam3:"+JSON.stringify(state.queryParam));
      }else{
        console.log("urlParam值4:"+JSON.stringify(data)+"state.queryParam4:"+JSON.stringify(state.queryParam));
        Object.assign(state.queryParam,data);
        console.log("urlParam值5:"+JSON.stringify(data)+"state.queryParam5:"+JSON.stringify(state.queryParam));
      }

    },
    getParam(state,data){

      console.log("getParam1:"+JSON.stringify(data)+"state.queryParam6:"+JSON.stringify(state.queryParam));
        Object.assign(state.queryParam,data);
      console.log("getParam2:"+JSON.stringify(data)+"state.queryParam7:"+JSON.stringify(state.queryParam));

    }
  },
  getters:{

  }
}

export  default urlParam
