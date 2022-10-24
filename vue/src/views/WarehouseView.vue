<!--第三个页面
add/delete workers from the system;
display the good status (e.g. positions of goods) and information (e.g. the kind of goods) for each of the warehouses;-->
<template>
    <div :style="background2" class="bgBackground" style=" height: 100vh; width: 100%; overflow: hidden">
        <div class="warehouse">
            <!-- 3 使用导入的组件实现布局 -->
            <h1 style="margin: 10px;text-align:center; color: white">The current
                warehouse：{{ warehouseForm.warehouseName }}</h1>

            <div><!--按钮-->
                <!--
                                <el-button style="margin-left:10px" type="success" @click="returnPage()">Back</el-button>
                -->
                <el-button style="margin-left:10px;margin-right:10px" type="success" @click="add()">
                    <el-icon style="margin-right: 5px">
                        <Plus/>
                    </el-icon>
                    Add
                </el-button>
                <!--输入框和输入按钮-->
                <el-input v-model="searchText" placeholder="Please input..." style="width:30%"></el-input>
                <el-button style="margin-left:10px" type="primary" @click="search()">
                    <el-icon style="margin-right: 5px">
                        <Search/>
                    </el-icon>
                    Search
                </el-button>
            </div>

            <!--展示worker-->
            <!--el-table表格,prop属性，label列名, 在el-table设置height="250"即可固定表头 ！！！！！-->
            <div style=" margin-bottom:10px;margin-top:10px;text-align: center">
                <h3 style="color: white">Worker Information</h3>
            </div>
            <el-scrollbar height="220px">
                <el-table :data="workersTableData" border stripe
                          style="margin-left: 20px;margin-right: 50px;width: 95%">
                    <el-table-column label="Worker Id" prop="workerId" sortable/>
                    <el-table-column label="Worker Name" prop="workerName"/>

                    <!--操作列-->
                    <el-table-column key="slot" fixed="right" label="Operations" style="width:500px" width="120">
                        <!-- TODO <template v-slot="scope"> key="slot"-->
                        <template v-slot="scope">
                            <!--delete按钮-->
                            <el-button style="margin-left:20px" type="success" @click="handleEdit(scope.row)">
                                <el-icon style="margin-right: 5px">
                                    <EditPen/>
                                </el-icon>
                                Edit
                            </el-button>

                            <!--edit按钮-->
                            <el-button style="margin-top:5px" type="danger" @click="handleDelete(scope.row)">
                                <el-icon style="margin-right: 5px">
                                    <Delete/>
                                </el-icon>
                                Delete
                            </el-button>
                        </template>
                    </el-table-column>


                </el-table>
            </el-scrollbar>

            <!-- 展示货物不需要操作列 -->
            <div style="margin-bottom:20px;margin-top:10px;text-align: center">
                <h3 style="color: white">Goods Information</h3>
            </div>
            <el-scrollbar height="350px">
                <el-table :data="goodsTableData" border stripe style="margin-left: 20px;
            margin-right: 50px;width: 95%">
                    <el-table-column label="Goods Id" prop="goodsId" sortable/>
                    <el-table-column label="Date" prop="date" sortable/>
                    <el-table-column label="Goods Type" prop="goodsType"/>
                    <el-table-column label="Warehouse Id" prop="warehouseId"/>
                </el-table>
            </el-scrollbar>

            <div><!--新增worker弹窗-->
                <el-dialog v-model="dialogVisible" title="Add a worker" width="50%">
                    <el-form :model="addForm" label-width="120px">
                        <!--新增工人-->
                        <el-form-item label="Worker Id">
                            <el-input v-model="addForm.workerId"/>
                        </el-form-item>
                        <el-form-item label="Worker Name">
                            <el-input v-model="addForm.workerName"/>
                        </el-form-item>
                        <el-form-item label="Warehouse">
                            <el-input v-model="addForm.warehouseId" disabled/>
                        </el-form-item>
                    </el-form>
                    <template #footer>
                        <span class="dialog-footer">
                            <el-button type="warning" @click="dialogVisible = false">Cancel</el-button>
                            <el-button type="success" @click="save">Confirm</el-button>
                        </span>
                    </template>
                </el-dialog>
            </div>

        </div>
    </div>
</template>

<script>
    // @ is an alias to /src
    /* 1 import导入组件 */
    import Header from "@/components/Header";
    import Aside from "@/components/Aside";
    import request from "@/utils/request";

    export default {
        name: 'WarehouseView',
        /*定义数据*/
        data() {
            return {
                /* TODO 当前页面的仓库信息---页面传值 */
                warehouseForm: {
                    warehouseId: this.$store.state.warehouse.warehouseId,
                    warehouseName: this.$store.state.warehouse.warehouseName,
                },

                /* 新增工人用 */
                addForm: {
                    workerId: " ",
                    workerName: " ",
                    warehouseId: " ",
                },
                /* 新增工人弹窗 */
                dialogVisible: false,
                /* 搜索框 */
                searchText: "",
                /* workersTableData和goodsTableData用来存需要展示的数据，workersTableData需要增加或删除工人 */
                workersTableData: [],
                goodsTableData: [],

                /* 背景图片设置 */
                background2: {
                    // 背景图片地址
                    backgroundImage: 'url(' + require('../assets/background2.jpg') + ')',
                    // 背景图片是否重复
                    backgroundRepeat: 'no-repeat',
                    // 背景图片大小
                    backgroundSize: 'cover',
                    // 背景颜色
                    backgroundColor: '#000',
                    // 背景图片位置
                    backgroundPosition: 'center',
                }

            }
        },

        /*定义用到的组件*/
        components: {
            /* 2 在component定义一个组件 */

        },

        //created  钩子函数  Vue 初始化时执行
        created() {
            /* 加载页面 */
            console.log("created页面加载ing = " + this.warehouseForm.warehouseName)
            this.load();
        },

        /*定义v-on绑定的方法*/
        methods: {
            /* 返回上一级 */
            returnPage() {
                this.$router.push("/home")
            },

            /* 新增工人 */
            add() {
                console.log("add warehouse")
                this.dialogVisible = true
                this.addForm = {}
            },

            /* TODO 保存新增工人 只需要传入workerId和workerName，warehouseWarehouseId是当前的数据库的id， 插入到worker表里 */
            save() {
                console.log("新增工人save" + this.addForm.workerId)
                // console.log("save工人 " + this.addForm.warehouseId)
                request.post("/worker/insert", this.addForm).then(res => {
                    console.log("res" + res + ". res.code = " + res.code + "res.msg" + res.msg)
                    if (res.code === "1") {
                        /* 插入成功 */
                        this.$message({type: "success", message: "插入成功"})
                    } else {
                        /* 插入失败 */
                        this.$message({type: "error", message: res.msg})
                    }
                })
                this.load()
                this.dialogVisible = false
            },

            /* load重新加载页面 /detail */
            load() {
                /* 根据this.presentWarehouseId查找当前仓库的所有内容 */
                console.log("WarehouseView loading 当前仓库 warehouseId = " + this.warehouseForm.warehouseId + ", warehouseName = " + this.warehouseForm.warehouseName)
                this.addForm.warehouseId = this.warehouseForm.warehouseId
                console.log("this.addForm = " + this.addForm.warehouseId + ", " + this.addForm.workerId + ", " + this.addForm.workerName)
                request.post("/warehouse/check", this.warehouseForm).then(res => {
                    // console.log("Warehouse页面res = " + res[0][0].goodsId)
                    this.workersTableData = res[1]
                    this.goodsTableData = res[0]
                })
            },

            /* TODO search查询，还没写完 */
            search() {
                this.load()
                console.log("search")
            },

            /* TODO handleEdit，还没写完 */
            handleEdit(row) {
                console.log("handleEdit= ")
            },

            handleDelete(row) {
                console.log("handleDelete= row.workerId = " + row.workerId)
                request.delete("/worker/" + row.workerId).then(res => {
                    console.log("handleDelete /worker/ res = " + res.code)
                    if (res.code === "1") {
                        console.log("删除成功")
                        this.$message({type: "success", message: "Delete success"})
                        /* 删除成功 */
                        this.load()
                    } else {
                        console.log("删除失败")
                        /* 删除失败 */
                        this.$message({type: "error", message: res.data.msg})
                    }
                    this.load()
                })

            }
        }
    }
</script>

<style scoped>

</style>