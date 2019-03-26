import Vue from 'vue'
import vuex from 'vuex'

Vue.use(vuex);

import app from './modules/app'
import iframe from './modules/iframe'
import user from './modules/user'
import menu from './modules/menu'
import dept from './modules/dept'

const store = new vuex.Store({
    modules: {
        app: app,
        iframe: iframe,
        user: user,
        menu: menu,
        dept: dept
    }
})

export default store