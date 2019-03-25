/*
 * 接口统一集成模块
 */
import * as login from './moudules/login'
import * as user from './moudules/user'
import * as dept from './moudules/dept'
import * as role from './moudules/role'
import * as menu from './moudules/menu'
import * as position from './moudules/position'
import * as dict from './moudules/dict'
import * as log from './moudules/log'
import * as cusManage_naturalCus from './moudules/cusManage/naturalCus'
import * as irm_irm from './moudules/irm/irm'

// 默认全部导出
export default {
    login,
    user,
    dept,
    role,
    menu,
    position,
    dict,
    log,
    cusManage_naturalCus,
    irm_irm
}
