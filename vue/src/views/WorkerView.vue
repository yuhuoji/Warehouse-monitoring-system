<template>
    <div>

        <div style="margin: 10px">
            <el-button @click="add" style="margin: 10px">add</el-button>
            <el-input v-model="search" placeholder="Please input" style="width: 50%"/>
            <el-button style="margin-left: 10px">search</el-button>

        </div>
        <el-table :data="tableData" border stripe style="width: 100%">
            <el-table-column label="ID" prop="id" sortable>
            </el-table-column>
            <el-table-column label="Name" prop="name" style="width:50px">
            </el-table-column>
            <el-table-column label="Warehouse" prop="warehouse">
            </el-table-column>
            <el-table-column fixed="right" label="operation" width="100">
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
            <el-pagination :currentPage="currentPage4" :page-size="10" :page-sizes="[5, 10, 20]" :total="total"
                    layout="total, sizes, prev, pager, next, jumper"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"/>

            <el-dialog v-model="dialogVisible" title="tips" width="30%">
                <el-form :model="form" label-width="120px">
                    <el-form-item label="id">
                        <el-input v-model="form.id"/><!--zheligaishujukuming-->
                    </el-form-item>
                </el-form>

                <el-form :model="form" label-width="120px">
                    <el-form-item label="name">
                        <el-input v-model="form.name"/><!--zheligaishujukuming-->
                    </el-form-item>
                </el-form>

                <el-form :model="form" label-width="120px">
                    <el-form-item label="warehouse">
                        <el-input v-model="form.warehouse"/><!--zheligaishujukuming-->
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
                tableData: [
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
        methods: {
            load() {
                request.get("/api/user")
            },
            add() {
                this.dialogVisible = true
                this.form = {}

            },
            save() {
                request.post("/user", this.form).then(res => {

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
            currentPage4() {

            }
        }
    }

</script>