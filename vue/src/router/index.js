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

    { /*  error页面 */
        path: '/error',
        name: 'LoginErrorView',
        component: () => import('@/views/LoginErrorView'), /*, hidden: true*/
        meta: {
            title: "ERROR"
        }
    },

    { /* 主界面home，layout + warehouse management  */
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

    { /* TODO Goods Display 数据可视化 所有的goods */
        path: '/display/goods',
        component: () => import('@/layout/Layout'),
        children: [
            {
                path: 'color',
                name: 'DisplayGoodsByColor',
                component: () => import('@/views/DisplayGoodsByColor'),
                meta: {
                    title: "DISPLAY GOODS BY COLOR",
                    keepAlive: true
                }
            },
            {
                path: 'time',
                name: 'DisplayGoodsByTime',
                component: () => import('@/views/DisplayGoodsByTime'),
                meta: {
                    title: "DISPLAY GOODS BY TIME"
                }
            },
            {
                path: 'type',
                name: 'DisplayGoodsByType',
                component: () => import('@/views/DisplayGoodsByType'),
                meta: {
                    title: "DISPLAY GOODS BY TYPE"
                }
            },
        ]
    },

    { /* TODO Goods 编辑页面 */
        path: '/goods',
        component: () => import('@/layout/Layout'),
        children: [
            {
                path: '/goods',
                name: 'GoodsView',
                component: () => import('@/views/GoodsView'),
                meta: {
                    title: "GOODS MANAGEMENT"
                }
            }
        ]
    },

    {/* TODO 管理工人页面 Worker页面 */
        path: '/worker',
        component: () => import('@/layout/Layout'),
        children: [
            {
                path: "/worker",
                name: 'WorkerView',
                component: () => import('@/views/WorkerView'),
                meta: {
                    title: "WORKER MANAGEMENT"
                }
            }
        ]
    },

    { /* 仓库管理页面 */
        path: '/warehouse',
        component: () => import('@/layout/Layout'),
        children: [
            {
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
