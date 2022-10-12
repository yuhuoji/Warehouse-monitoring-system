import {createRouter, createWebHistory} from 'vue-router'
import LoginView from "@/views/LoginView";
import Layout from "../layout/Layout.vue";

/* 定义routes一组路由 */
const routes = [
    { /*将path和组件映射，输入地址就能访问到页面,配置登录成功页面，默认显示登录页,使用时需要使用 path 路径来实现跳转*/
        path: '/',
        redirect: "/login",
    },

    { /* LOGIN 页面 */
        path: '/login',
        name: 'LoginView',
        component: LoginView,
        meta: {
            title: "LOGIN"
        }
    },

    {/*  error页面 */
        path: '/error',
        name: 'LoginErrorView',
        component: () => import('@/views/LoginErrorView'), /*, hidden: true*/
        meta: {
            title: "ERROR"
        }
    },

    { /* layout */
        path: '/home',
        component: () => import('@/layout/Layout'),
        children: [
            {
                path: '/home',
                name: 'HomeView',
                component: () => import('@/views/HomeView'),
                meta: {
                    title: "WAREHOUSE MANAGEMENT"
                }
            }
        ]
    },

    /*    { /!* home页面 *!/
            path: '/home',
            name: 'HomeView',
            component: () => import('@/views/HomeView'),
            meta: {
                title: "WAREHOUSE MANAGEMENT"
            }
        },*/

    {/* TODO 管理工人页面 Worker页面 */
        path: '/worker',
        name: 'WorkerView',
        component: () => import('@/views/WorkerView'),
        meta: {
            title: "WORKER MANAGEMENT"
        }
    },

    { /* 仓库管理页面 */
        path: '/warehouse',
        name: 'WarehouseView',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/WarehouseView.vue'),
        meta: {
            title: "WAREHOUSE INFORMATION"
        }
    }
]

/* router路由管理 */
const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    /*指定路由列表*/
    routes
})

router.afterEach((to, from) => {
    document.title = to.meta.title //在全局后置守卫中获取路由元信息设置title

})

export default router
