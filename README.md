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

## 目录结构描述  
```
.
|— README.md  
|— package-lock.json  
|— package.json  
|  
|— springboot  
|   |— HELP.md  
|   |— pom.xml  
|   └── src  
|       |— main  
|       |   |— java  
|       |   |   └── com  
|       |   |       └── bupt    
|       |   |           └── springboot  
|       |   |               |— SpringbootApplication.java  
|       |   |               |— common  
|       |   |               |   |— MybatisPlusConfig.java  
|       |   |               |   └── Result.java  
|       |   |               |— controller  
|       |   |               |   |— UserController.java   
|       |   |               |   |— WarehouseController.java    
|       |   |               |   └── WorkerController.java    
|       |   |               |— entity     
|       |   |               |   |— Goods.java  
|       |   |               |   |— User.java   
|       |   |               |   |— Warehouse.java  
|       |   |               |   └── Worker.java  
|       |   |               |— mapper  
|       |   |               |   |— UserMapper.java  
|       |   |               |   |— WarehouseMapper.java  
|       |   |               |   └── WorkerMapper.java  
|       |   |               └── service  
|       |   |                   |— UserService.java    
|       |   |                   |— WarehouseService.java  
|       |   |                   |— WorkerService.java  
|       |   |                   └── impl  
|       |   |                       |— UserServiceImpl.java  
|       |   |                       |— WarehouseServiceImpl.java  
|       |   |                       └── WorkerServiceImpl.java  
|       |   └── resources  
|       |       |— application.yml  
|       |       |— static  
|       |       └── templates  
|       └── test  
|           └── java  
|               └── com  
|                   └── bupt  
|                       └── springboot  
|                           └── SpringbootApplicationTests.java  
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
        |   |   └── global.css  
        |   |— background.jpg  
        |   |— background1.jpg  
        |   |— background2.jpg  
        |   |— error.jpg  
        |   └── logo.png  
        |— components  
        |   |— Aside.vue  
        |   └── Header.vue  
        |— layout  
        |   └── Layout.vue  
        |— router   
        |   └── index.js  
        |— store  
        |   └── index.js  
        |— utils  
        |   └── request.js  
        └── views  
            |— DisplayGoodsByColor.vue  
            |— DisplayGoodsByTime.vue  
            |— DisplayGoodsByType.vue  
            |— GoodsView.vue  
            |— HomeView.vue  
            |— LoginErrorView.vue  
            |— LoginView.vue  
            |— WarehouseView.vue  
            └── WorkerView.vue   
 
### Customize configuration  
See [Configuration Reference](https://cli.vuejs.org/config/).  
