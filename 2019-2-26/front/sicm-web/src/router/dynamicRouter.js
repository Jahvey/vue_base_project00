const _import = require('./_import_' + process.env.NODE_ENV)

import Layout from '../views/layout/Layout'
import { queryFuncInfo } from '@/api/menu'
import store from '../store'

function genMenu(data, menu) {
  data.forEach((item, idx) => {
    var menuItem = genMenuItem(item)
    menu.push(menuItem)
  })
}

function genMenuItem(item) {
  var menu = getMenuItem(item)

  if (item.children) {
    menu.children = []
    item.children.forEach((child, idx) => {
      menu.children.push(getMenuItem(child))
    })
  }
  return menu
}

function getMenuItem(item) {
  var menu
  if (item.menuLevel == 1) {
    menu = {
      path: item.urlRequestPath,
      component: Layout,
      redirect: item.redirectPath,
      name: item.pageRoute,
      meta: { title: item.funcName, icon: item.icon },
      hidden: item.isMenu === '0'
    }
    return menu
  } else {
    menu = {
      path: item.urlRequestPath,
      component: _import(item.pagePath),
      redirect: item.redirectPath,
      name: item.pageRoute,
      meta: { title: item.funcName, icon: item.icon },
      hidden: item.isMenu === '0'
    }
    return menu
  }
}

export function getFuncInfo() {
  return new Promise((resolve, reject) => {
    var userId = window.sessionStorage.userId
    var reqParam = { userId: userId }
    queryFuncInfo(reqParam).then(response => {
      window.sessionStorage.menus = JSON.stringify(response)
      resolve()
    })
  })
}

export function addRoutes() {
  var menus = []
  var data = JSON.parse(window.sessionStorage.menus)
  genMenu(data, menus)
  return menus
}
