<template>
    <div>
        <div style="margin: 10px">
            <el-button style="margin: 10px" @click="add">Add</el-button>
            <el-input v-model="search" placeholder="Please input" style="width: 50%"/>
            <el-button style="margin-left: 10px">Search</el-button>
        </div>

        <el-table :data="workerTableData" border stripe style="width: 100%">
            <el-table-column label="Worker ID" prop="workerId" sortable>
            </el-table-column>
            <el-table-column label="Worker Name" prop="workerName" style="width:50px">
            </el-table-column>
            <el-table-column label="Warehouse" prop="warehouseId">
            </el-table-column>
            <el-table-column fixed="right" label="Operation" width="100">
                <template #default="scope">
                    <el-button size="small" style="margin-left: 15px" @click="handleEdit(scope.$index, scope.row)">
                        Edit
                    </el-button>
                    <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">
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
                <el-form :model="form" label-width="120px">
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
                </el-form>

                <template #footer>
                    <span class="dialog-footer">
                       <el-button @click="dialogVisible = false">Cancel</el-button>
                       <el-button type="primary" @click="dialogVisible = save">Confirm</el-button>
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
                form: {},
                dialogVisible: false,
                search: '',
                currentPage: 1,
                total: 10,
                workerTableData: [
                    {
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
                    },
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
                this.dialogVisible = true
                this.form = {}

            },
            save() {
                request.post("/worker/insert", this.form).then(res => {

                    console.log(res)
                })

            },
            handleEdit() {

            },
            handleDelete() {

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