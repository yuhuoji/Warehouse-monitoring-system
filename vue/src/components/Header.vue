<!-- 组件库文件，单独封装的公共组件 -->
<template>
    <!-- header布局，下划线，flex布局 -->
    <div style="height: 50px; line-height: 50px; border-bottom: 1px solid #ffffff; display: flex;background-color:#486eea">
        <div style="width: 200px;padding-left:30px;font-weight:bold;color:#ffffff">管理员后台页面</div>
        <div style="flex: 1"></div>
        <div style="width: 100px;padding-top:20px">

            <!--下拉框，引用element的额dropdown-->
            <el-dropdown style="padding-top:0">
                <span class="el-dropdown-link" style="color: white">
                  {{ form.username }}
                  <i class="el-icon-arrow-down el-icon--right"></i>
                </span>

                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item @click="personalInfo()">个人信息</el-dropdown-item>
                        <el-dropdown-item @click="logOut()">退出系统</el-dropdown-item>
                    </el-dropdown-menu>
                </template>

                <!--弹窗-->
            </el-dropdown>
            <el-dialog v-model="dialogVisible" title="管理员个人信息" width="50%">
                <!--TODO 展示并修改个人信息-->
                <el-form ref="userData" :model="userData">
                    <el-form-item label="USERID">
                        <el-input v-model="userData.userId" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="用户名">
                        <el-input v-model="userData.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码">
                        <el-input v-model="userData.password"></el-input>
                    </el-form-item>
                </el-form>
                <!--                <el-table :data="userData" border style="width: 100%">
                                    <el-table-column label="USERID" prop="userId"/>
                                    <el-table-column label="用户名" prop="username"/>
                                    <el-table-column label="密码" prop="password"/>
                                </el-table>-->

                <template #footer>
                        <span class="dialog-footer">
                            <el-button @click="saveInfo">SaveInfo</el-button>
                            <el-button @click="dialogVisible = false">Leave</el-button>
                        </span>
                </template>
            </el-dialog>

        </div>
    </div>
</template>

<script>
    export default {
        name: "Header",
        data() {
            return {
                /* FIXME form用于展示后台传过来的个人信息 */
                form: {
                    userId: this.$store.state.user.userId,
                    username: "admin",
                    password: this.$store.state.user.password,
                },
                dialogVisible: false,
                /* TODO 展示并修改个人信息 */
                userData: [{
                    // userId: "我还没做呢",
                    userId: '111',
                    username: this.$store.state.user.username,
                    password: this.$store.state.user.password,
                }]
            }
        },
        components: {},
        /* 刷新页面方法 */
        activated() {
            this.userData.userId = this.$store.state.user.userId
            this.userData.username = this.$store.state.user.username
            this.userData.password = this.$store.state.user.password
        },
        methods: {
            personalInfo() {
                this.dialogVisible = true
            },

            /* 退出登录，回到登录界面 /login  TODO清除信息 */
            logOut() { /* clear cache */
                this.$store.commit("saveUserUserId", "")
                this.$store.commit("saveUserUserName", "")
                this.$store.commit("saveUserPassword", "")
                this.$router.push("/login")
            },

            saveInfo() {
                console.log("modifyInfo")
                alert("我还没做呢")
            }

        }
    }
</script>

<style scoped>

</style>