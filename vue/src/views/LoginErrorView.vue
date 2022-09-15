<template>
    <div>
        <div :style="error" class="bgBackground" style=" height: 100vh; width: 100%; overflow: hidden">
            <!--叠加背景#FFFFFF-->
<!--            <div v-if="false">-->
            <el-button style="height:20%; width:15%;margin-left:160px;
            margin-top:150px"
                       @click="returnPage()">
            登陆失败
            </el-button>
<!--            </div>-->

        </div>
    </div>
</template>

<script>
    export default {
        name: "LoginErrorView",
        data() {
            return {
                msg: this.$route.query.data,

                /* 背景图片设置 */
                error: {
                    // 背景图片地址
                    backgroundImage: 'url(' + require('../assets/error.jpg') + ')',
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
        methods: {
            returnPage() {
                this.$router.push("/login")
            }
        }
    }
</script>

<style scoped>

</style>