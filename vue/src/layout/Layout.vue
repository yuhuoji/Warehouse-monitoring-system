<!-- 公共布局组件文件，如项目页面顶部栏区域、侧边导航栏(大部分页面公共的布局) -->
<template>
    <div class="common-layout">
        <el-container>

            <!--header头部-->
            <el-header class="header_box">
                <Header/>
            </el-header>

            <!--主体-->
            <el-container >

                <!-- 侧边栏-->
                <el-aside class="aside_box" width="200px">
                    <Aside/>
                </el-aside>

                <!--内容区域-->
                <el-main class="main_box">
                    <!--router路由 -->
                    <router-view/>
                </el-main>

            </el-container>
        </el-container>
    </div>
</template>

<script>
    import Header from "@/components/Header";
    import Aside from "@/components/Aside";

    export default {
        name: "Layout",
        components: {
            Header,
            Aside,

        }
    }
</script>

<style scoped>

</style>
