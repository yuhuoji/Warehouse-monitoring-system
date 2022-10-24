<!-- 展示所有商品的页面 可以编辑 可视化 -->
<template>
    <div style="margin: 10px">
        <div style="margin: 10px">
            <!--            <el-button style="margin: 10px" @click="add">Add</el-button>-->
            <el-input v-model="searchText" placeholder="Please input..." style="width: 50%"/>
            <el-button style="margin-left: 10px" type="primary" @click="search()">
                <el-icon style="margin-right: 5px">
                    <Search/>
                </el-icon>
                Search
            </el-button>
        </div>

        <el-scrollbar height="700px">
            <el-table :data="goodsTableData" border stripe style="width: 100%">
                <el-table-column label="Goods ID" prop="goodsId" sortable>
                </el-table-column>
                <el-table-column label="Date" prop="date" sortable>
                </el-table-column>
                <el-table-column label="Goods Type" prop="goodsType" sortable>
                </el-table-column>
                <el-table-column label="Warehouse Id" prop="warehouseId" sortable>
                </el-table-column>
                <el-table-column label="Goods Position" prop="goodsPosition" sortable></el-table-column>
                <el-table-column fixed="right" label="Operation" width="150">
                    <template #default="scope">
                        <el-button size="small" type="primary" @click="checkPosition(scope.row)">
                            Check Position
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-scrollbar>

        <div style="margin: 10px">
            <!-- 分页查询 -->
            <el-pagination
                    v-model:currentPage="currentPage"
                    v-model:page-size="pageSize"
                    :background=true
                    :disabled="disabled"
                    :page-sizes="[10, 20, 50, 100]"
                    :small="small"
                    :total="total"
                    layout="total, sizes, prev, pager, next, jumper"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
            />

            <el-dialog v-model="dialogVisible" title="Check Position" width="30%">
                <!--                <el-form :model="form" label-width="120px">
                                    <el-form-item label="id">
                                        <el-input v-model="form.id"/>
                                    </el-form-item>
                                </el-form>

                                <el-form :model="form" label-width="120px">
                                    <el-form-item label="name">
                                        <el-input v-model="form.name"/>
                                    </el-form-item>
                                </el-form>

                                <el-form :model="form" label-width="120px">
                                    <el-form-item label="warehouse">
                                        <el-input v-model="form.warehouse"/>
                                    </el-form-item>
                                </el-form>-->
                <!--                <div :style="'background-image:url('+require('../assets/visualization.png')+')'"></div>-->
                <div class="box">
                    <div class="railImgUrl_box">
                        <img :src="railImgUrl" alt="railImgUrl" class="rail_img">
                    </div>
                    <div class="goodsImgUrl_box">
                        <img :src="goodsImgUrl" alt="goodsImgUrl" class="goods_img">
                    </div>
                </div>

                <template #footer>
                    <span class="dialog-footer">
                       <el-button @click="dialogVisible = false">Cancel</el-button>
                    </span>
                </template>
            </el-dialog>

        </div>
        <el-backtop :bottom="100" :right="100"/>
    </div>
</template>

<script>
    import request from "@/utils/request";

    export default {
        name: "GoodsView",
        data() {
            return {
                searchText: "",
                pageSize: 1,
                currentPage: 1,
                total: 45,
                goodsTableData: [],
                dialogVisible: false,
                railImgUrl: require('../assets/visualization.png'),
                goodsImgUrl: {},
            }
        },
        created() {
            console.log("GoodsView created")
            this.load()
        },
        methods: {
            load() {
                console.log("GoodsView load")
                request.get("/goods/selectAllGoods").then(res => {
                    console.log("/goods/selectAllGoods res = " + res)
                    this.goodsTableData = res.data
                })
            },
            search() {
                request.get("").then(res => {
                    console.log("res = " + res)
                })
            },
            checkPosition(row) {
                // alert(JSON.stringify(row))
                console.log("goods position, warehouseId = " + row.warehouseId + ", goodsPosition" + row.goodsPosition)
                /* switch (row.goodsPosition){
                     case 1:
                         console.log("position 1")
                 }*/
                let redGoodsImgUrl = require('../assets/red.png')
                this.goodsImgUrl = redGoodsImgUrl

                this.dialogVisible = true
            },
            handleSizeChange() {

            },
            handleCurrentChange() {

            },
            currentPage() {

            }
        }
    }
</script>

<style scoped>
    .box {
        position: relative;
        display: flex;
        justify-content: center;
        align-items: center;
        /*background-image: url("../assets/visualization.png");*/
    }

    .railImgUrl_box {
        /*position: absolute;*/
    }
    .rail_img{
        width: auto;
        height: auto;
        max-width: 100%;
        max-height: 100%;
    }

    .goodsImgUrl_box {
        position: relative;
        top: 40px;
        left: -50px;
    }
/*
top: 40px;
        left: -50px;
        
*/
    .goods_img{
        width: 50px;
        height: 50px;
    }


</style>