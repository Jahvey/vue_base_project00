const org={
	state: {
     orgInfo:{},
     method:""
  },

  mutations: {
    SET_ORGINFO: (state, orgInfo) => {
      state.orgInfo = orgInfo
    },
    SET_METHOD:(state, method)=>{
      state.method = method
    }
  },
  actions: {
  	Set_OrgInfo({ commit }, orgInfo){
		 commit('SET_ORGINFO', orgInfo)
	},
    Set_Method({ commit },method){
      commit('SET_METHOD', method)
    }

  }
}

export default org