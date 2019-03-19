const indexStore= {
  state:{
    authorName:'许建明',
    age:'32',
    dept:'员工'
  },
  mutations:{
    newDept(state,data){
      console.log("传进来的值："+data)
        state.dept=data;//员工改变
    }
  },
  getters:{

  }
}

export default indexStore
