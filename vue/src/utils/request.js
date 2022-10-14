/*
* 封装axios， 数据访问的插件
* POST    /url    创建
* DELETE  /url/xxx  删除
* PUT     /url/xxx 	更新
* GET     /url/xxx  查看
* */
/* https://blog.csdn.net/xqnode/article/details/118325868?ops_request_misc=&request_id=&biz_id=102&utm_term=%E7%A8%8B%E5%BA%8F%E5%91%98%E9%9D%92%E6%88%88%20%20%20vue&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-1-118325868.nonecase&spm=1018.2226.3001.4187 */

import axios from 'axios'
import router from "@/router";

const request = axios.create({
    baseURL: '/api',  // 注意！！ 这里是全局统一加上了 '/api' 前缀，也就是说所有接口都会加上'/api'前缀在，页面里面写接口的时候就不要加 '/api'了，否则会出现2个'/api'，类似 '/api/api/user'这样的报错，切记！！！
    timeout: 5000
})

/* request 拦截器
 * 可以自请求发送前对请求做一些处理
 * 比如统一加token，对请求参数统一加密
 * */
request.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8';

    // config.headers['token'] = user.token;  // 设置请求头

    /* 拦截器，判断浏览器sessionStorage里是否存储了用户信息 */
    // let userJson = sessionStorage.getItem("user");
    // if (!userJson){
    //     router.push("/login")
    // }

    return config
}, error => {
    return Promise.reject(error)
});

// response 拦截器
// 可以在接口响应后统一处理结果
request.interceptors.response.use(
    response => {
        /* axios的返回结果有一个存放返回结果的data，获取response.data存入res */
        let res = response.data;
        /* 以下是把res都转换成对象 */
        // 如果是返回的文件
        if (response.config.responseType === 'blob') {
            return res
        }
        // 兼容服务端返回的字符串数据
        if (typeof res === 'string') {
            res = res ? JSON.parse(res) : res
        }
        return res;
    },
    error => {
        console.log('err' + error) // for debug
        return Promise.reject(error)
    }
)

export default request

