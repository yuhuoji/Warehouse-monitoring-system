<template>
    <div>
        <el-row class="tac">
            <el-col :span="30">
                <el-menu
                        default-active="2"
                        class="el-menu-vertical-demo"
                        @open="handleOpen"
                        @close="handleClose"
                >
                    <el-menu-item index="HomeView">
                        <el-icon><location /></el-icon>
                        <span @click="checkWarehouse()">Warehouse</span>
                    </el-menu-item>
                    <el-menu-item index="worker">
                        <el-icon ><icon-menu /></el-icon>
                        <span @click="checkWorker()">Worker</span>
                    </el-menu-item>
                </el-menu>
            </el-col>
        </el-row>

    </div>

</template>

<script>
    import {
        Location,
    } from '@element-plus/icons-vue'
    export default {
        name: "Aside",
        data:{

        },
        methods:{
            checkWarehouse(){

            },
            checkWorker(){

            }
        }
    }

</script>

<style scoped>

</style>


<!--
<template>
    <div>
        <el-row class="tac">
            <el-col :span="10">
                <el-menu
                        default-active="HomeView"
                        router
                        class="el-menu-vertical-demo"


                    style="width:200px;min-height:100vh">
                    <el-menu-item index="HomeView">
                        <template >
                            仓库
                        </template>
                    </el-menu-item>
                    <el-menu-item index="Warehouse">
                        仓库详情
                    </el-menu-item>
                </el-menu>
            </el-col>
        </el-row>

    </div>

</template>

<script>
    export default {
        name: "Aside"
    }
</script>

<style scoped>

</style>-->
