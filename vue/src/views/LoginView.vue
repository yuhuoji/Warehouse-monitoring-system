<template><!--引用背景图片-->
    <div :style="background" class="bgBackground" style=" height: 100vh; width: 100%; overflow: hidden">
        <!--<div class="login" style="width: 100%; height: 100vh; background:url('../assets/background.jpg'); overflow: hidden" >-->
        <div style="text-align: center;margin:100px">
            <h1 style="color:white;margin: 100px 0; padding: 10px 0">WELCOME</h1>

            <!--输入框 form表单 margin-left:50px;margin-right:300px-->
            <div style="margin-left:50px; margin-right:350px">
                <el-form :model="form" label-width="30%" style="margin-left: 50px">
                    <el-form-item>
                        <!--更改label样式-->
                        <el-icon style="color: white" size="large">
                            <UserFilled/>
                        </el-icon>
                        <span slot="label">
                            <span style="color: white">USERNAME</span>
                        </span>
                        <el-input v-model="form.userName" clearable maxlength="20"
                                  placeholder="Please input your username"
                                  show-word-limit size="large" type="text"/>
                    </el-form-item>
                    <br>
                    <el-form-item>
                        <!--更改label样式-->
                        <el-icon style="color: white" size="large">
                            <Key/>
                        </el-icon>
                        <span slot="label">
                            <span style="color: white" >PASSWORD</span>
                        </span>
                        <el-input v-model="form.userPassword" clearable maxlength="20"
                                  placeholder="Please input your password"
                                  show-password show-word-limit size="large" type="text"/>
                    </el-form-item>

                    <div style="width: 200px; margin-left: 470px">
                        <el-form-itemh>
                            <!--禁止使用空密码或空账户-->
                            <p v-if="submitVisible" style="color:red; text-align: center" v-text="msg"></p><br>
                            <!--submit按钮 v-on-->
                            <el-button size="large" style="text-align: center; " type="success"
                                       @click="handleSubmit()">
                                <el-icon style="margin-right: 5px" size="large"><Finished /></el-icon>SUBMIT
                            </el-button>
                        </el-form-itemh>
                    </div>

                </el-form>
            </div>

        </div>
    </div>
</template>

<script>
    import request from "@/utils/request";

    export default {
        name: "LoginView",
        data() {
            return {
                /* form做请求参数,如果不写username的话，输入为空就是undefined，length长度就会报错 */
                form: {
                    userName: "",
                    userPassword: ""
                },
                submitVisible: false,
                msg: "Incorrect username or password.",

                /* 背景图片设置 */
                background: {
                    // 背景图片地址
                    backgroundImage: 'url(' + require('../assets/background.jpg') + ')',
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
        components: {},
        /*定义v-on绑定的方法*/
        methods: {
            handleSubmit() {
                if ((this.form.userName.length !== 0) && (this.form.userPassword.length !== 0)) {
                    /* post方法 , res是返回的结果  res 获取后端发来的User对象 */
                    request.post("/user/login", this.form).then(res => {
                        /*           console.log("res = " + res + ", res.code = " + res.code + ", res.msg = " + res.msg + ", res.data.userId = "
                                       + res.data.userId + ", res.data.userName = " + res.data.userName + ", res.data.userPassword = "+ res.data.userPassword)*/
                        if (res.code === "1") {
                            this.$message({type: "success", message: "Welcome !!!"})
                            /* 存储个人信息 */
                            this.$store.commit("saveUserUserId", res.data.userId)
                            this.$store.commit("saveUserUserName", res.data.userName)
                            this.$store.commit("saveUserUserPassword", res.data.userPassword)
                            console.log("store : userId = " + this.$store.state.user.userId + ", userName = " + this.$store.state.user.userName +
                                ", userPassword = " + this.$store.state.user.userPassword)
                            /* 存在浏览器会话存储里sessionStorage里 */
                            sessionStorage.setItem('user', JSON.stringify(res.data))
                            /* 登录成功成功后进行页面跳转 */
                            this.$router.push("/home")
                        } else {
                            this.$message({type: "error", message: res.msg})
                            /* 登录成功成功后进行页面跳转 */
                            this.$router.push("/error")
                        }
                    })
                } else {
                    console.log("禁止使用空密码或空账户")
                    this.submitVisible = true
                }
            },
        }
    }
</script>

<style scoped>

</style>