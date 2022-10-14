<!-- menu菜单 -->
<template>
    <div>
        <el-row class="tac" style="">

            <el-col :span="12">
                <!-- el-menu添加router后，根据index进行路由跳转 -->
                <el-menu class="el-menu-vertical-demo" default-active="2"
                         router
                         style="width: 150px"
                         @close="handleClose" @open="handleOpen">
                    <el-menu-item index="/home">
                        <el-icon>
                            <icon-menu/>
                        </el-icon>
                        <span>Home</span>
                    </el-menu-item>

                    <el-menu-item index="/warehouse">
                        <el-icon>
                            <icon-menu/>
                        </el-icon>
                        <span>CheckWarehouse</span>
                    </el-menu-item>

                    <el-menu-item index="/worker">
                        <el-icon>
                            <icon-menu/>
                        </el-icon>
                        <span>CheckWorker</span>
                    </el-menu-item>

                    <el-menu-item index="/goods">
                        <el-icon>
                            <icon-menu/>
                        </el-icon>
                        <span>CheckGoods</span>
                    </el-menu-item>

                    <el-sub-menu index="1">
                        <template #title>
                            <el-icon>
                                <location/>
                            </el-icon>
                            <span>Goods Display</span>
                        </template>
                        <el-menu-item-group title="AllGoods">
                            <el-menu-item index="/display/goods/color">ByColor</el-menu-item>
                            <el-menu-item index="/display/goods/type">ByType</el-menu-item>
                            <el-menu-item index="/display/goods/time">ByTime</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="Classification">
                            <el-sub-menu index="1-2">
                                <template #title>Color</template>
                                <el-menu-item index="/display/goods/color/red">Red</el-menu-item>
                                <el-menu-item index="">Blue</el-menu-item>
                                <el-menu-item index="">Yellow</el-menu-item>
                                <el-menu-item index="">Green</el-menu-item>
                            </el-sub-menu>
                        </el-menu-item-group>
                    </el-sub-menu>

                </el-menu>
            </el-col>

        </el-row>
    </div>

</template>

<script>

    export default {
        name: "Aside",
        data() {
            return {}
        },
        methods: {
            handleOpen() {
                console.log("handleOpen")
            },
            handleClose() {
                console.log("handleClose")
            },
            checkWarehouse() {
                console.log("checkWarehouse")
            },
            checkWorker() {
                console.log("checkWorker")
            }
        }
    }

</script>

<style scoped>

    span {
        margin-left: -40px
    }

</style>

