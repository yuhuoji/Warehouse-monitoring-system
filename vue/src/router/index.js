import {createRouter, createWebHistory} from 'vue-router'
import LoginView from "@/views/LoginView";
import Layout from "@/layout/Layout";

/* 定义routes一组路由 */
const routes = [
    { /*将path和组件映射，输入地址就能访问到页面,配置登录成功页面，使用时需要使用 path 路径来实现跳转*/
        path: '/',
        name: 'Layout', /* Layout是主体框架 */
        component: Layout.vue,
        redirect: "/login"
/*        /!* 重定向 *!/
        redirect: "/home",
        children: [{
            path: 'home', /!* 用/home访问页面 *!/
            name: 'Home',
            component: () => import('@/views/HomeView.vue')
        }]*/
    },

    {/* home页面*/
        path: '/home',
        name: 'HomeView',
        component: () => import('@/views/HomeView.vue')
    },

    {/* Worker页面*/
        path: '/worker',
        name: 'WorkerView',
        component: () => import('@/views/WorkerView.vue')
    },

    { /*将path和组件映射，输入地址就能访问到页面,配置默认的路径，默认显示登录页*/
        path: '/login',
        name: 'LoginView',
        component: LoginView
    },

    {/* error页面*/
        path: '/error',
        name: 'LoginErrorView',
        component: () => import('@/views/LoginErrorView.vue')/*, hidden: true*/
    },

    { /*输入path就能那个访问AboutView.vue了*/
        path: '/warehouse',
        name: 'WarehouseView',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/WarehouseView.vue')
    }
]

/* router路由管理 */
const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    /*指定路由列表*/
    routes
})

export default router
