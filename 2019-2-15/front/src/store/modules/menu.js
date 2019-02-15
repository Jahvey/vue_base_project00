const menu={
  state: {
    menuList: [],
    showTab:{}
  },
  mutations: {
    setAddMenuList(state, data){
      let isAdd = true;
      for(let i=0;i<state.menuList.length;i++){
        if(state.menuList[i].name === data.name){
          isAdd = false;
          state.showTab = data;
        }
      }
      if(isAdd){
        state.menuList.push(data);
        state.showTab = data;
      }

    },
    setDeleteMenuList(state, data){
      let newArr=[];
      let index;
      for(let i=0;i<state.menuList.length;i++){
        if(state.menuList[i].name === data.name){
          index = i;
        }else {
          newArr.push(state.menuList[i])
        }
      }
      state.menuList = newArr;
      console.log("menuIndex: ",index);
      if(index === 0){
        state.showTab = state.menuList[index];
      }else {
        state.showTab = state.menuList[index-1];
      }

    }
  },
  actions: {

  },
  getters: {

  }
}

export default menu

// this.$store.commit('setAddMenuList', data1)
// this.$store.commit('setDeleteMenuList', data1)
