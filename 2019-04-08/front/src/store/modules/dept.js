export default {
    state: {
        orgTree: [],  // 导航菜单树
    },
    getters: {
        orgTree(state){// 对应着上面state
            return state.orgTree
        }
    },
    mutations: {
        setOrgTree(state, orgTree){  // 设置导航菜单树
            state.orgTree = orgTree;
        }
    },
    actions: {
    }
}