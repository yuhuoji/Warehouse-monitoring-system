<!--
data visualization
time-stacked line
 -->
<template>
    <div>
        <el-button type="success" @click="setLight()">
            <el-icon size="large" style="margin-right: 10px">
                <Sunny/>
            </el-icon>
            SetLight
        </el-button>

        <el-button type="success" @click="setDark()">
            <el-icon size="large" style="margin-right: 10px">
                <Moon/>
            </el-icon>
            SetDark
        </el-button>
        <div id="myChart" ref="myChart" :style="{width: '98%', height:'90vh',display:'flex'}"></div>

    </div>
</template>

<script>
    import * as echarts from "echarts"
    import request from "@/utils/request";

    export default {
        name: "DisplayGoodsByTime",
        data() {
            return {
                myChart: {},
                option: {},
                goodsTimeData: [],
            }
        },
        created() {
            console.log("DisplayGoodsByColor created")
        },
        activated() {
            console.log("activated")
        },
        mounted() {
            console.log("DisplayGoodsByColor created")
            this.load()
            this.myChart = this.$refs.myChart
            window.addEventListener('resize', this.resizeCharts)
        },
        beforeDestroy() { // 清理工作 避免内存泄漏
            // 销毁监听事件
            window.removeEventListener('resize', this.resizeCharts)
            // 销毁 Echarts 实例
            this.myChart.dispose()
        },
        methods: {
            /* 数据加载方法 */
            load() {
                request.get("/goods/goodsStatisticsByType").then(res => {
                    console.log("/goods/goodsStatisticsByColor res.data = " + res.data + ", res.code = " + res.code + ", res.msg = " + res.msg)
                    for (let key in res.data) {
                        this.goodsTimeData.push({'name': key.toUpperCase(), 'value': res.data[key]})
                    }

                    this.initPage()

                    if (res.code === "1") {
                        console.log("goodsDisplayByTime")
                    } else {
                        console.log(res.msg)
                    }

                })
            },

            /* Page initialization */
            initPage() {
                this.myChart = echarts.init(document.getElementById('myChart'), "light"); //初始化

                this.option = {
                    title: {
                        text: 'Time-stacked Line'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['Red', 'Yellow', 'Blue', 'Green']
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [

                        /*    {
                                name: 'Total',
                                type: 'line',
                                stack: 'Total',
                                data: [12, 13, 10, 13, 9, 23, 21]
                            },*/
                        {
                            name: 'Red',
                            type: 'line',
                            stack: 'Total',
                            data: [32, 33, 40, 43, 59, 63, 65]
                        },
                        {
                            name: 'Yellow',
                            type: 'line',
                            stack: 'Total',
                            data: [32, 33, 30, 33, 33, 32, 39]
                        },
                        {
                            name: 'Blue',
                            type: 'line',
                            stack: 'Total',
                            data: [22, 18, 19, 23, 29, 33, 31]
                        },
                        {
                            name: 'Green',
                            type: 'line',
                            stack: 'Total',
                            data: [15, 23, 20, 15, 19, 33, 41]
                        },
                    ],
                    label: {show: true,},
                    color: ['#ee6666', '#fac858', '#5470c6', '#3ba272'],
                };

                this.myChart.setOption(this.option)
            },

            /* 监听图表容器的大小并改变图表大小 */
            resizeCharts() {
                this.myChart.resize();
            },
            setLight() {
                this.myChart.dispose();
                this.myChart = echarts.init(document.getElementById('myChart'), 'light');
                this.myChart.setOption(this.option);
            },
            setDark() {
                this.myChart.dispose();
                this.myChart = echarts.init(document.getElementById('myChart'), 'dark');
                this.myChart.setOption(this.option);
            },
        },

    }

</script>

<style scoped>
    .title {
        margin: 10px;
    }
</style>