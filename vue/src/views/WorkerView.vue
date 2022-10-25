<template>
    <div style="margin: 10px">
        <div style="margin: 10px">
            <el-button style="margin: 10px" type="success" @click="add">
                <el-icon style="margin-right: 5px">
                    <Plus/>
                </el-icon>
                Add
            </el-button>
            <el-input v-model="search" placeholder="Please input..." style="width: 50%"/>
            <el-button style="margin-left: 10px" type="primary">
                <el-icon style="margin-right: 5px">
                    <Search/>
                </el-icon>
                Search
            </el-button>
        </div>

        <el-table :data="workerTableData" border stripe style="width: 100%">
            <el-table-column label="Worker ID" prop="workerId" sortable>
            </el-table-column>
            <el-table-column label="Worker Name" prop="workerName">
            </el-table-column>
            <el-table-column label="Warehouse" prop="warehouseId">
            </el-table-column>
            <el-table-column key="slot" fixed="right" label="Operation" width="100">
                <!--<template #default="scope">-->
                <template v-slot="scope">
                    <el-button size="small" style="margin-left:10px" type="success"
                               @click="handleEdit(scope.row)">
                        <el-icon style="margin-right: 5px">
                            <EditPen/>
                        </el-icon>
                        Edit
                    </el-button>
                    <el-button size="small" style="margin: 5px" type="danger"
                               @click="handleDelete(scope.row)">
                        <!--@click="handleDelete(scope.$index, scope.row)"-->
                        <el-icon style="margin-right: 5px">
                            <Delete/>
                        </el-icon>
                        Delete
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <div style="margin: 10px">
            <el-pagination :currentPage="currentPage" :page-size="10" :page-sizes="[5, 10, 20]" :total="total"
                           layout="total, sizes, prev, pager, next, jumper"
                           @size-change="handleSizeChange"
                           @current-change="handleCurrentChange"/>

            <el-dialog v-model="dialogVisible" title="Add a Worker" width="30%">
                <el-form :model="addForm" label-width="120px">
                    <el-form-item label="Worker Id">
                        <el-input v-model="addForm.workerId" maxlength=10 show-word-limit/>
                    </el-form-item>
                    <el-form-item label="Worker Name">
                        <el-input v-model="addForm.workerName" maxlength=10 show-word-limit/>
                    </el-form-item>
                    <el-form-item label="Warehouse">
                        <el-input v-model="addForm.warehouseId" maxlength=10 show-word-limit/>
                    </el-form-item>
                </el-form>

                <template #footer>
                    <span class="dialog-footer">
                       <el-button type="warning" @click="dialogVisible = false">Cancel</el-button>
                       <el-button type="success" @click="save()">Confirm</el-button>
                    </span>
                </template>
            </el-dialog>

        </div>
    </div>
</template>

<script>

    import request from "@/utils/request";

    export default {
        name: 'WorkerView',
        components: {},
        data() {
            return {
                addForm: {},
                dialogVisible: false,
                search: '',
                currentPage: 1,
                total: 10,
                workerTableData: [
                    /*            {
                                    id: '1',
                                    name: 'Tom',
                                    warehouse: '1',
                                },
                                {
                                    id: '2',
                                    name: 'Amy',
                                    warehouse: '1',
                                },
                                {
                                    id: '3',
                                    name: 'Cindy',
                                    warehouse: '2',
                                },
                                {
                                    id: '4',
                                    name: 'Bob',
                                    warehouse: '2',
                                },*/
                ]
            }
        },
        created() {
            console.log("WorkerView created")
            this.load()
        },
        methods: {
            load() {
                request.get("/worker/detail").then(res => {
                    console.log("WorkerView get res = " + res)
                    this.workerTableData = res.data
                })
            },
            add() {
                console.log("add worker")
                this.dialogVisible = true
                this.addForm = {}

            },
            save() {
                this.addForm.workerPassword = 123456;
                console.log("save" + this.addForm)
                request.post("/worker/insert", this.addForm).then(res => {
                    console.log("/worker/insert res = " + res + "res.code = " + res.code)
                    if (res.code === "1") {
                        this.$message({type: "success", message: "Insertion success"})
                        /* FIXME 刷新效果 */
                        this.load()
                    } else {
                        this.$message({type: "error", message: res.data.msg})
                    }
                })
                this.dialogVisible = false
            },
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