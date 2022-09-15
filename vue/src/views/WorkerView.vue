<template>
    <div>
        <div>
            <!--head-->
            <Header />
            <!--body-->
            <div style="display:flex">
                <!--sidebar-->
                <Aside />
                <!--container-->
                <router-view style="flex:1"/>
            </div>
        </div>
        <div style="margin:10px">
            <el-button @click="add">add</el-button>
        </div>

        <div style="margin: 10px">
            <el-input v-model="search" placeholder="Please input" style="width: 50%" />
            <el-button style="margin-left: 10px">search</el-button>

        </div>
        <el-table
                :data="tableData"
                border
                stripe
                style="width: 100%">
            <el-table-column
                    prop="id"
                    label="ID"
                    sortable
            >
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="Name"
                    style="width:50px"
            >
            </el-table-column>
            <el-table-column
                    prop="warehouse"
                    label="Warehouse"
            >
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="operation"
                    width="100">
                <template #default="scope">
                    <el-button style="margin-left: 15px" size="small" @click="handleEdit(scope.$index, scope.row)"
                    >Edit</el-button
                    >
                    <el-button
                            size="small"
                            type="danger"
                            @click="handleDelete(scope.$index, scope.row)"
                    >Delete</el-button
                    >
                </template>
            </el-table-column>
        </el-table>

        <div style="margin: 10px">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :currentPage="currentPage4"
                    :page-sizes="[5, 10, 20]"
                    :page-size="10"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total"
            />
            <el-dialog title="tips" v-model="dialogVisible" width="30%">
                <el-form :model="form" label-width="120px">
                    <el-form-item label="id">
                        <el-input v-model="form.id" /><!--zheligaishujukuming-->
                    </el-form-item>
                </el-form>
                <el-form :model="form" label-width="120px">
                    <el-form-item label="name">
                        <el-input v-model="form.name" /><!--zheligaishujukuming-->
                    </el-form-item>
                </el-form>
                <el-form :model="form" label-width="120px">
                    <el-form-item label="warehouse">
                        <el-input v-model="form.warehouse" /><!--zheligaishujukuming-->
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
    import Header from "@/components/Header";
    import Aside from "@/components/Aside";

    export default {
        name: 'WorkerView',
        components: {
            Header,
            Aside
        },
        data(){
            return{
                form: {},
                dialogVisible: false,
                search:'',
                currentPage:1,
                total:10,
                tableData:[
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
        methods:{
            load(){
                request.get("/api/user")
            },
            add(){
                this.dialogVisible = true
                this.form = {}

            },
            save(){
                request.post("/user",this.form).then(res =>{

                    console.log(res)
                })

            },
            handleEdit(){

            },
            handleDelete(){

            },
            handleSizeChange(){

            },
            handleCurrentChange(){

            },
            currentPage4(){

            }
        }
    }

</script>