import Vue from 'vue'
import Vuex from 'vuex'
import app from './modules/app'
import user from './modules/user'
import org from './modules/org'
import loading from './modules/loading'
import getters from './getters'
import nav from './modules/nav'
import menu from './modules/menu'
import urlParam from './modules/urlParam'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    app,
    user,
    org,
    loading,
    nav,

    menu,
    urlParam
  },
  getters


})

export default store
