export default {
    state: {
        appName: "I like Kitty",  // 应用名称
        themeColor: "#545c64",//主题颜色
        oldThemeColor: "#545c64",//上一次主题颜色
        collapse:false,  // 导航栏收缩状态
        menuRouteLoaded:false    // 菜单和路由是否已经加载
    },
    getters: {
        collapse(state){// 对应着上面state
            return collapse;
        }
    },
    mutations: {
        collapse(state){  // 改变收缩状态
            state.collapse = !state.collapse;
        },
        themeColor(state,themeColor){  // 主题颜色
            state.themeColor = themeColor;
        },
        oldThemeColor(state,oldThemeColor){  // 上一次主题颜色
            state.oldThemeColor = oldThemeColor;
        },
        menuRouteLoaded(state, menuRouteLoaded){  // 改变菜单和路由的加载状态
            state.menuRouteLoaded = menuRouteLoaded;
        }
    },
    actions: {
        onThemeChange ({ commit, stata}, data) {
            commit('themeColor', data.themeColor)
            commit('oldThemeColor', data.oldThemeColor)
        }
    }
}