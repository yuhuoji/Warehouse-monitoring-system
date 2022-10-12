<!-- 公共布局组件文件，如项目页面顶部栏区域、侧边导航栏(大部分页面公共的布局) -->
<template>
    <div class="common-layout">
        <el-container>
            <el-header>
                <!--header头部-->
                <Header/>
            </el-header>

            <!--主体-->
            <el-container>
                <el-aside class="aside_box" width="300px">
                    <!-- 侧边栏-->
                    <Aside/>
                </el-aside>

                <el-main>
                    <!--内容区域-->

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
