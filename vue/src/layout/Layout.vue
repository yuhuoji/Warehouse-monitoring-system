<template>
    <div>
        <!--header头部-->
        <Header/>
        主体布局页面
        <!--主体-->
        <div style="display: flex">主体

            <!--内容区域-->

            <!--router路由 -->
            <router-view style="flex: 1"/>

        </div>
    </div>
</template>

<script>
    import Header from "@/components/Header";
    import HomeView from "@/views/HomeView";
    import AboutView from "@/views/WarehouseView";

    export default {
        name: "Layout",
        components: {
            Header,
            HomeView
            // AboutView
        }
    }
</script>

<style scoped>

</style>

<!--倪亦非
<div style="height: 50px; line-height: 50px; border-bottom: 1px solid rgb(136, 136, 136); display: flex; background-color: rgb(170, 170, 170);">
    <div style="width: 200px; padding-left: 30px; font-weight: bold; color: dodgerblue;">管理员后台页面</div>
    <div style="flex: 1 1 0%;"></div>
    <div style="width: 100px;">&lt;!&ndash;下拉框，引用element的额dropdown&ndash;&gt;
        <div class="el-dropdown" style="padding-top: 0px;"><span
                id="el-id-7720-0" aria-controls="el-id-7720-1" aria-expanded="false"
                aria-haspopup="menu" class="el-dropdown-link el-tooltip__trigger el-tooltip__trigger" role="button" tabindex="0"> <i
                class="el-icon-arrow-down el-icon&#45;&#45;right"></i></span>&lt;!&ndash;teleport start&ndash;&gt;&lt;!&ndash;v-if&ndash;&gt;</div>
        &lt;!&ndash;teleport start&ndash;&gt;
        <div class="el-overlay" style="z-index: 2002; display: none;">
            <div aria-describedby="el-id-7720-4" aria-label="管理员个人信息" aria-modal="true" class="el-overlay-dialog"
                 role="dialog"></div>
        </div>&lt;!&ndash;teleport end&ndash;&gt;</div>
</div>
-->
