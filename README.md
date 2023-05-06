# Warehouse-monitoring-system 

------

## Table of Contents

- [Warehouse-monitoring-system](#warehouse-monitoring-system)
  - [Table of Contents](#table-of-contents)
  - [Project introduction](#project-introduction)
  - [Languages and Tools](#languages-and-tools)
  - [Project setup](#project-setup)
  - [Compiles and hot-reloads for development](#compiles-and-hot-reloads-for-development)
  - [Compiles and minifies for production](#compiles-and-minifies-for-production)
  - [Use Element Plus icon](#use-element-plus-icon)
    - [Use the package manager to install](#use-the-package-manager-to-install)
    - [Register all icons](#register-all-icons)
  - [Directory structure description](#directory-structure-description)
  - [Interface display](#interface-display)
  - [License](#license)


------

## Project introduction

This is a Springboot + Vue front-end separation project, by using Springboot, Vue, mybatis-plus, axios, MySQL, git, etc. 

The main functions include login and logout, user information display, warehouse information display, add a warehouse, view a warehouse of workers and commodity information, add workers and delete workers, sort according to a certain attribute and a certain fault tolerance mechanism.

------

## Languages and Tools

<p align="left"> 
    <a href="https://www.w3schools.com/css/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="40" height="40"/> </a> 
    <a href="https://www.w3.org/html/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="40" height="40"/> </a> 
    <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a>
    <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="40" height="40"/> </a>
    <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> 
    <a href="https://nodejs.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/nodejs/nodejs-original-wordmark.svg" alt="nodejs" width="40" height="40"/> </a> 
    <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> 
    <a href="https://vuejs.org/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/vuejs/vuejs-original-wordmark.svg" alt="vuejs" width="40" height="40"/> </a> 
    <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a>
</p>


------

## Project setup

```
npm install
```

------

## Compiles and hot-reloads for development
```
npm run serve
```

------

## Compiles and minifies for production
```
npm run build
```

------

## Use Element Plus icon
### Use the package manager to install
```
# NPM
$ npm install @element-plus/icons-vue
```

### Register all icons
```
const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
```

------

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

------

## Interface display

[English running screenshot](./SCREENSHOT-en.md)

[中文运行截图](./SCREENSHOT-cn.md)

------

## License

[MIT](https://github.com/RichardLitt/standard-readme/blob/main/LICENSE)
