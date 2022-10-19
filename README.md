# Warehouse-monitoring-system  仓库监控系统

## 项目介绍

This is a warehouse monitoring system, by using springboot, vue, mybatis-plus, etc.

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Use Element Plus icon
#### Use the package manager to install
```
# NPM
$ npm install @element-plus/icons-vue
```
#### Register all icons
```
const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
```
## Directory structure description  
```
.
|— README.md  
|— package-lock.json  
|— package.json  
|  
|— springboot  
|   |— pom.xml  Major project build files for the project, and associated configuration files
|   └── src  
|       |— main  
|       |   |— java  
|       |   |   └── com  
|       |   |       └── bupt    
|       |   |           └── springboot  
|       |   |               |— SpringbootApplication.java  
|       |   |               |— common  
|       |   |               |   |— MybatisPlusConfig.java  
|       |   |               |   └── Result.java  Spring Boot's generic return class
|       |   |               |— controller  
|       |   |               |   |— GoodsController.java
|       |   |               |   |— UserController.java   
|       |   |               |   |— WarehouseController.java    
|       |   |               |   └── WorkerController.java    
|       |   |               |— entity     
|       |   |               |   |— Goods.java  
|       |   |               |   |— User.java   
|       |   |               |   |— Warehouse.java  
|       |   |               |   └── Worker.java  
|       |   |               |— mapper  
|       |   |               |   |— GoodsMapper.java
|       |   |               |   |— UserMapper.java  
|       |   |               |   |— WarehouseMapper.java  
|       |   |               |   └── WorkerMapper.java  
|       |   |               └── service 
|       |   |                   |— GoodsService.java 
|       |   |                   |— UserService.java    
|       |   |                   |— WarehouseService.java  
|       |   |                   |— WorkerService.java  
|       |   |                   └── impl  
|       |   |                       |— GoodsServiceImpl.java
|       |   |                       |— UserServiceImpl.java  
|       |   |                       |— WarehouseServiceImpl.java  
|       |   |                       └── WorkerServiceImpl.java  
|       |   └── resources  
|       |       |— application.yml  Properties Configuration file
|       |       |— static  
|       |       └── templates  
|       └── test  
|           └── java  
|               └── com  
|                   └── bupt  
|                       |— springboot  
|                       |   └── SpringbootApplicationTests.java
|                       └── service
|                           └── impl
|                               └── GoodsServiceImplTest.java
└── vue  
    |— babel.config.js  
    |— jsconfig.json  
    |— package-lock.json  
    |— package.json  
    |— vue.config.js  
    |— public  
    |   |— favicon.ico  
    |   └── index.html  
    └── src  
        |— App.vue  
        |— assets  
        |— main.js  
        |   |— css  
        |   |   └── global.css  Global style file
        |   |— background.jpg  
        |   |— background1.jpg  
        |   |— background2.jpg  
        |   |— error.jpg  
        |   └── logo.png  
        |— components  
        |   |— Aside.vue  The sidebar
        |   └── Header.vue  The top bar
        |— layout  
        |   └── Layout.vue  The page layout
        |— router   
        |   └── index.js  Route definition and configuration
        |— store  
        |   └── index.js  Manage global variables to facilitate value transfer between components
        |— utils  
        |   └── request.js  Tool file
        └── views  
            |— DisplayGoodsByTime.vue  Data visualization - by product date
            |— DisplayGoodsByType.vue  Data visualization - by product color
            |— GoodsView.vue  Goods Information Page
            |— HomeView.vue  The main page
            |— LoginErrorView.vue  Login failure page
            |— LoginView.vue  Login page
            |— WarehouseView.vue  Warehouse Information Page
            └── WorkerView.vue   Worker Information Page
``` 

## Customize configuration  
See [Configuration Reference](https://cli.vuejs.org/config/).  
