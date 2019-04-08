
import store from '@/store/index'
import api from '@/http/api'
export function  getAllOrgTree(_this,callBack){
    let that = _this
    if(store.getters.orgTree.length == 1){
        return store.state.dept.orgTree
    }else{
        api.dept.findDeptTree().then((res) => {
            if(res && res.data && res.data.code == '200'){
                store.commit('setOrgTree', [res.data.data])
                if(callBack){
                    callBack();
                }
               return store.state.dept.orgTree
            }else{
                console.error('获取机构树数据失败')
                that.$message({message: '初始化机构树失败, 错误信息：' + res.msg, type: 'error'})
                if(callBack){
                    callBack();
                }
                return store.state.dept.orgTree
            }
            
        }).catch((res) => {
            that.$message({message: '初始化机构树失败, 错误信息：' + res, type: 'error'})
        }).then(() =>{
            if(callBack){
                callBack();
            }
        })
    }
     
}