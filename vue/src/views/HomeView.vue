<!-- allow managers to create warehouses-->
<template>
    <!--背景图片-->
    <div :style="background1" class="bgBackground" style=" height: 100vh; width: 100%; overflow: hidden" >
        <div class="home">
            <div>
                <!-- 头部-->
<!--                <Header/>-->
                <!--  主体-->

            </div>
            <!-- 3 使用导入的组件实现布局 -->
            <div style="margin: 30px">
                <el-button type="success" @click="add()">新增仓库</el-button>
                <!--输入框和输入按钮-->
                <div style="margin: 10px 0">
                    <el-input v-model="searchText" placeholder="please input" style="width:40%" clearable></el-input>
                    <el-button style="margin-left:10px" type="success" @click="search()">SEARCH</el-button>
                </div>
            </div>

            <el-table :data="warehouseTableData" border stripe style="margin-left:30px; margin-right:20px; width: 95%">
                <!--prop属性？？？？-->
                <el-table-column label="WAREHOUSE ID" prop="warehouseId" sortable/>
                <el-table-column label="WAREHOUSE NAME" prop="warehouseName"/>
                <!--操作列-->
                <el-table-column fixed="right" label="OPERATION" width="150">

                    <!--TODO #default="scope"和@click="check(scope.row.id)-->
                    <template #default="scope">
                        <!--每一行一个check按钮,跳转到第三页，展示具体一个仓库的信息，包括工人和货物-->
                        <!--当表格某一行被点击时会触发该事件，参数：row, column, event-->
                        <el-button size="small" style="margin-left: 5px" type="success" @click="check(scope.row)">CHECK
                        </el-button>

                    </template>
                </el-table-column>
            </el-table>

            <div style="margin: 10px 0">

                <!--TODO Pagination 分页 当数据量过多时，使用分页分解数据。 见P3下 34:00 -->
                <div class="example-pagination-block" style="margin:10px">
                    <div class="example-demonstration"></div>
                    <!--total设置变量从后台获取-->
                    <!--                    <el-pagination
                                                :currentPage="currentPage4"
                                                :page-size="10"
                                                :page-sizes="[5, 10, 20]"
                                                :total="totalPage"
                                                layout="total, sizes, prev, pager, next, jumper"
                                                background
                                                style="margin-left: 30px"
                                                @size-change="handleSizeChange"
                                                @current-change="handleCurrentChange"/>-->
                    <el-pagination :total="10" background layout="prev, pager, next" style="margin-left:20px"/>

                    <!--弹窗-->
                    <el-dialog v-model="dialogVisible" title="新增仓库" width="50%">

                        <el-form :model="form" label-width="120px">
                            <!--新增 创建仓库-->
                            <el-form-item label="仓库id">
                                <el-input v-model="form.warehouseId"/>
                            </el-form-item>
                            <el-form-item label="仓库名称">
                                <el-input v-model="form.warehouseName"/>
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
    </div>
</template>

<script>
    // @ is an alias to /src
    /* 1 import导入组件 */

    import request from "@/utils/request";

    export default {
        name: 'HomeView',

        /*定义数据*/
        data() {
            return {
                /* 弹窗默认关闭 */
                dialogVisible: false,
                /* 搜索框*/
                searchText: "",

                /* 当前页码 */
                currentPage: 1,
                /* 总页码 */
                totalPage: "",
                /* 新增仓库信息 */
                form: {},
                /* 展示的warehouseTableData */
                warehouseTableData: [],

                /* 背景图片设置 */
                background1: {
                    // 背景图片地址
                    backgroundImage: 'url(' + require('../assets/background1.jpg') + ')',
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

        /*注册用到的组件*/
        components: {

            /* 2 在component定义一个组件 */
        },

        /* 页面加载方法,vue中created(),mounted()与activated()区别及应用，加载load */
        created() {
            this.load()
        },
        /*定义v-on绑定的方法*/
        methods: {
            /* 新增仓库 */
            add() {
                console.log("add")
                this.dialogVisible = true
                this.form = {}
            },
            /* 保存新增仓库 */
            save() {
                console.log("save " + this.form.warehouseId)
                request.post("/warehouse/insert", this.form).then(res => {
                    console.log("res" + res + ". res.code = " + res.code + "res.msg" + res.msg)
                    if (res.code === "1") {
                        this.$message({type: "success", message: "插入成功"})
                        /* 插入成功 */
                        this.load()
                    } else {
                        this.$message({type: "error", message: res.msg})
                        /* 插入失败 */
                    }
                })
                this.dialogVisible = false
            },
            handleSizeChange() {

            },
            handleCurrentChange() {

            },
            currentPage4() {

            },

            /* load重新加载页面 /detail */
            load() {
                request.get("/warehouse/detail").then(res => {
                    console.log("res = " + res)
                    this.warehouseTableData = res
                    this.totalPage = res.length
                    console.log("warehouseTableData = " + this.warehouseTableData)
                })
            },

            /* TODO search查询 */
            search() {
                this.load()
                alert("我还没做呢")
            },

            /* TODO 查看仓库， 第三页。 获取当前行的warehouse_id,跳转并传参，到worker和goods里查询返回数据并在/warehouse页面渲染
            *   同级传参的两种方式 1.query穿参，或者params传参 */
            check(row) {
                /* row-click 当前行*/
                console.log("check")
                console.log("row = " + row.warehouseId + " warehouseName =" + row.warehouseName)
                let warehouseIdTemp = row.warehouseId
                let warehouseNameTemp = row.warehouseName
                console.log("warehouseIdTemp = " + warehouseIdTemp)
                console.log("warehouseNameTemp = " + warehouseNameTemp)
                /* 保存 */
                this.$store.commit("saveWarehouseWarehouseId", row.warehouseId)
                this.$store.commit("saveWarehouseWarehouseName", row.warehouseName)
                console.log("save over")

                /* 进行页面跳转,再根据warehouseId进行页面渲染 */
                this.$router.push("/warehouse")

            },

        }
    }
</script>

<style scoped>

</style>
