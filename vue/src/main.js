import { createApp } from 'vue'
/* main.js是整个项目的入口，在开头就引入了vue源码和主页面App.vue。 */
/* 引入element plus*/
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import App from './App.vue'
import router from './router'
import store from './store'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

/*导入全局css样式*/
import '@/assets/css/global.css'

/* 国际化 use(ElementPlus,{locale}) */
// createApp(App).use(store).use(router).use(ElementPlus).mount('#app')

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.use(store);
app.use(router);
app.use(ElementPlus);
app.mount("#app");
