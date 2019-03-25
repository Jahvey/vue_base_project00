<template>
  <el-dropdown class="role-selector" @command="handleCommand">
    <span class="el-dropdown-link">
      <span id="role">{{roles[0].rolename}}</span><i class="el-icon-arrow-down el-icon--right"></i>
    </span>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item v-for="role in roles" v-bind:key="role.roleid" :command="role">{{role.rolename}}</el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</template>

<script>
import store from '@/store'
import router from '@/router'
import Intro from '@/views/Intro/Intro'
import { getIFramePath, getIFrameUrl } from '@/utils/iframe'
  export default {
    data(){
      return{
        roles:[]
      }
    },
    methods: {
      // 语言切换
      handleCommand(command) {
        document.getElementById("role").innerHTML = command.rolename
        sessionStorage.setItem("currRole",command.roleid)
        this.loadMenuTree(command.roleid)
        this.$router.push({ path: '/' })
      },
      //获取角色
      getRoles(){
        this.roles = JSON.parse(sessionStorage.getItem("roles"))
        if(this.roles.length > 0){
          sessionStorage.setItem("currRole",this.roles[0].roleid)
        }
      },
      loadMenuTree(roleid){
          this.$api.menu.queryMenuTreeByRole({roleid:roleid}).then(res => {
              // 添加动态路由
              let dynamicRoutes = this.addDynamicRoutes(res.data.data)
              let fP = [{path: '',name: '系统介绍', component: Intro}]
              //router.options.routes[0].children = router.options.routes[0].children.concat(dynamicRoutes)
              router.options.routes[0].children = fP.concat(dynamicRoutes)
              router.addRoutes(router.options.routes)
              // 保存加载状态
              //store.commit('menuRouteLoaded', true)
              // 保存菜单树
              store.commit('setNavTree', res.data.data)
          })
    
      },
      addDynamicRoutes (menuList = [], routes = []) {
        


        var temp = []
        for (var i = 0; i < menuList.length; i++) {
          if (menuList[i].children && menuList[i].children.length >= 1) {
            temp = temp.concat(menuList[i].children)
          } else if (menuList[i].menuaction && /\S/.test(menuList[i].menuaction)) {
            menuList[i].menuaction = menuList[i].menuaction.replace(/^\//, '')
            // 创建路由配置
            var route = {
              path: menuList[i].menuaction,
              component: null,
              name: menuList[i].menuname,
              meta: {
                keepAlive: true
              }
            }
            if(/natural/.test(menuList[i].menuaction)){
              //route.children = natureCusRouters
            }
            let path = getIFramePath(menuList[i].menuaction)
            if (path) {
              // 如果是嵌套页面, 通过iframe展示
              route['path'] = path
              route['component'] = resolve => require([`@/views/IFrame/IFrame`], resolve)
              // 存储嵌套页面路由路径和访问URL
              let url = getIFrameUrl(menuList[i].menuaction)
              let iFrameUrl = {'path':path, 'url':url}
              store.commit('addIFrameUrl', iFrameUrl)
            } else {
              try {
                // 根据菜单URL动态加载vue组件，这里要求vue组件须按照url路径存储
                // 如url="sys/user"，则组件路径应是"@/views/sys/user.vue",否则组件加载不到
                let array = menuList[i].menuaction.split('/')
                let url = ''
                for(let i=0; i<array.length; i++) {
                  url += array[i].substring(0,1).toUpperCase() + array[i].substring(1) + '/'
                }
                url = url.substring(0, url.length - 1)
                route['component'] = resolve => require([`@/views/${url}`], resolve)
              } catch (e) {}
            }
            routes.push(route)
          }
        }
        if (temp.length >= 1) {
          this.addDynamicRoutes(temp, routes)
        } else {
          console.log('动态路由加载...')
          console.log(routes)
          console.log('动态路由加载完成.')
        }

        console.info("roleC_routes==========:"+JSON.stringify(routes))

        return routes
      }
    },
    mounted() {
      this.getRoles()
	  }
  }
</script>