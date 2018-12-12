const loading = {
  state: {
    listLoading : false,
    childLoading : false
  },

  mutations: {
    SET_LISTLOADING : (state, listLoading) => {
      state.listLoading = listLoading
    },
    SET_CHILDLOADING : (state, childLoading) => {
      state.childLoading = childLoading
    }
  },

  actions: {
    // 主表loading标记
    setListLoading({ commit }, listLoading) {
      commit('SET_LISTLOADING', listLoading)
    },

    // 子表loading标记
    setChildLoading({ commit }, childLoading) {
      commit('SET_CHILDLOADING', childLoading)
    }
  }
}

export default loading