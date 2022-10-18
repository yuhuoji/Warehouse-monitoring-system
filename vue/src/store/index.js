import { createStore } from 'vuex'

/* store存储一些变量，数，如存储输入信息，活页页面跳转之间的一些信息
* 打开浏览器 → getters → 组件调用actions中的方法 → mutations（设置state的值） → getters（更新数据）*/
export default createStore({
/* Vue 的状态管理工具 Vuex */
  // 告诉 vue “使用” vuex

// 全局变量
  state: {
    user:{
      userId:-1,
      userName:"admin",
      userPassword:"123",
    },
    warehouse:{
      warehouseId:"1",
      warehouseName:"Beijing",
    }

  },
  // 这里是get方法,并且每次打开浏览器优先执行该方法，获取所有的状态
  getters: {
  },
//mutations专门用于改变state属性中的数据, set方法
  mutations: {
    saveUserUserId(state, userId){
      state.user.userId = userId
    },
    saveUserUserName(state, userName){
      state.user.username = userName
    },
    saveUserPassword(state, password){
      state.user.password = password
    },
    saveWarehouseWarehouseId(state, warehouseId){
      state.warehouse.warehouseId = warehouseId
    },
    saveWarehouseWarehouseName(state, warehouseName){
      state.warehouse.warehouseName = warehouseName
    },
  },
  // 定义方法，要执行的操作 流程判断/异步请求等 Action 是专门用于处理异步任务的
  actions: {
  },
    // TODO 给全局变量分组???
  modules: {
  }

})
