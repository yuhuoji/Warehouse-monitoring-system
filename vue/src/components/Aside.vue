<!-- menu菜单 -->
<template>
    <div>
        <el-row class="tac">

            <el-col :span="12">

                <el-menu
                        class="el-menu-vertical-demo"
                        default-active="2"
                        @close="handleClose"
                        @open="handleOpen">
                    <el-sub-menu index="1">
                        <template #title>
                            <el-icon>
                                <location/>
                            </el-icon>
                            <span style="margin-left: -40px">Navigator One</span>
                        </template>
                        <el-menu-item-group title="Group One">
                            <el-menu-item index="1-1">item one</el-menu-item>
                            <el-menu-item index="1-2">item two</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="Group Two">
                            <el-menu-item index="1-3">item three</el-menu-item>
                        </el-menu-item-group>
                        <el-sub-menu index="1-4">
                            <template #title>item four</template>
                            <el-menu-item index="1-4-1">item one</el-menu-item>
                        </el-sub-menu>
                    </el-sub-menu>
                    <el-menu-item index="2">
                        <el-icon>
                            <icon-menu/>
                        </el-icon>
                        <span style="margin-left: -40px">CheckWarehouse</span>
                    </el-menu-item>
                    <el-menu-item index="3">
                        <el-icon>
                            <icon-menu/>
                        </el-icon>
                        <span style="margin-left: -40px">CheckWorker</span>
                    </el-menu-item>
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

</style>

