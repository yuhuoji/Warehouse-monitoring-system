<!--第三个页面
add/delete workers from the system;
display the good status (e.g. positions of goods) and information (e.g. the kind of goods) for each of the warehouses;-->
<template>
    <div :style="background2" class="bgBackground" style=" height: 100vh; width: 100%; overflow: hidden">
        <div class="warehouse">
            <Header/>
            <!-- 3 使用导入的组件实现布局 -->
            <h1 style="margin: 20px;color: white">当前仓库：{{warehouseForm.warehouseName}}</h1>
            <div>
                <el-button style="margin-left:10px" type="success" @click="returnPage()">返回</el-button>
            </div>
            <br>
            <div><!--按钮-->
                <el-button style="margin-left:10px;margin-right:10px" type="success" @click="add()">新增</el-button>
                <!--输入框和输入按钮-->
                <el-input v-model="searchText" placeholder="please input" style="width:30%"></el-input>
                <el-button style="margin-left:10px" type="primary" @click="search()">搜索按钮</el-button>
            </div>
            <br>

            <!--展示worker-->
            <!--el-table表格,prop属性，label列名, 在el-table设置height="250"即可固定表头 ！！！！！-->
            <div style=" margin-bottom:10px;margin-top:5px;text-align: center">
                <h3 style="color: white">工人信息</h3>
            </div>
            <el-table :data="workersTableData" border stripe style="margin-left: 20px;
        margin-right: 50px;
        width: 95%">
                <el-table-column label="工人id" prop="workerId" sortable/>
                <el-table-column label="工人名字" prop="workerName"/>
                <!--操作列-->
                <el-table-column style="width:500px" fixed="right" label="Operations" width="120">
                    <template #default="scope">
                        <!--delete按钮-->
                        <el-button style="margin-left:20px" type="success" @click="handleEdit">Edit</el-button>
                        <!--edit按钮-->
                        <el-button style="margin-top:5px" type="danger" @click="handleDelete(scope.row)">Delete</el-button>
                    </template>
                </el-table-column>
            </el-table>

            <!--展示货物不需要操作列-->
            <div style="margin-bottom:5px;margin-top:10px;text-align: center">
                <h3 style="color: white">货物信息</h3>
            </div>
            <el-table :data="goodsTableData" border stripe style="margin-top: 20px;margin-left: 20px;
        margin-right: 50px;width: 95%">
                <el-table-column label="goodsId" prop="goodsId" sortable/>
                <el-table-column label="date" prop="date" sortable/>
                <el-table-column label="goodsName" prop="goodsName"/>
                <el-table-column label="goodsColor" prop="goodsColor"/>
                <el-table-column label="goodsType" prop="goodsType"/>
                <el-table-column label="warehouseWarehouseId" prop="warehouseWarehouseId"/>
            </el-table>

            <div><!--新增worker弹窗-->
                <el-dialog v-model="dialogVisible" title="新增工人" width="50%">
                    <el-form :model="form" label-width="120px">
                        <!--新增工人-->
                        <el-form-item label="工人id">
                            <el-input v-model="form.workerId"/>
                        </el-form-item>
                        <el-form-item label="工人名称">
                            <el-input v-model="form.workerName"/>
                        </el-form-item>
                        <el-form-item label="工人所属仓库">
                            <el-input v-model="form.warehouseWarehouseId"/>
                        </el-form-item>
                    </el-form>
                    <template #footer>
                        <span class="dialog-footer">
                            <el-button @click="dialogVisible = false">Cancel</el-button>
                            <el-button type="primary" @click="save">Confirm</el-button>
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
                form: {
                    workerId: " ",
                    workerName: " ",
                    warehouseWarehouseId: " ",
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
            Header
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
                console.log("add工人")
                this.dialogVisible = true
                this.form = {}
            },

            /* TODO 保存新增工人 只需要传入workerId和workerName，warehouseWarehouseId是当前的数据库的id， 插入到worker表里 */
            save() {
                console.log("新增工人save" + this.form.workerId)
                // console.log("save工人 " + this.form.warehouseId)
                request.post("/worker/insert", this.form).then(res => {
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
                console.log("Warehouse页面loading 当前仓库信息 = " + this.warehouseForm.warehouseId + ", " + this.warehouseForm.warehouseName)
                request.post("/warehouse/check", this.warehouseForm).then(res => {
                    // console.log("Warehouse页面res = " + res[0][0].goodsId)
                    this.workersTableData = res[1]
                    this.goodsTableData = res[0]
                    console.log("workersTableData = " + this.workersTableData + ", goodsTableData = " + this.goodsTableData)
                })
            },

            /* TODO search查询，还没写完 */
            search() {
                this.load()

            },

            /* TODO handleEdit，还没写完 */
            handleEdit() {

            },

            /* TODO handleDelete，还没写完 */
            handleDelete(row) {
                console.log("handleDelete= " + row.workerId)

                request.get("/worker/delete?id=" + row.workerId).then(res => {
                    console.log("/worker/delete res = " + res)
                    if (res.code === "1") {
                        this.$message({type: "success", message: "工人删除成功"})
                        /* 删除成功 */
                        this.load()
                    } else {
                        this.$message({type: "error", message: res.msg})
                        /* 删除失败 */
                    }

                })

            }
        }
    }
</script>