<!--
data visualization
red blue yellow green
 -->
<template>
    <div>
        <el-button type="success" @click="setPie()">
            <el-icon size="large" style="margin-right: 10px">
                <PieChart/>
            </el-icon>
            SetPie
        </el-button>
        <el-button type="success" @click="setValue()">
            <el-icon size="large" style="margin-right: 10px">
                <Histogram/>
            </el-icon>
            SetValue
        </el-button>

        <div class="title" style="margin: 10px 0 0 0 ;text-align:center;">
            <h1>Goods Color Pie Chart</h1>
            <div id="myChart" ref="myChart" :style="{width: '90%', height:'90vh',display:'flex'}"></div>
        </div>

    </div>
</template>

<script>

    import * as echarts from "echarts"
    import request from "@/utils/request";

    export default {
        name: "DisplayGoodsByColor",
        data() {
            return {
                goodsColorData: [
                    // {value: 666, name: 'RED'},
                    // {value: 735, name: 'BLUE'},
                    // {value: 580, name: 'YELLOW'},
                    // {value: 484, name: 'GREEN'},
                ],
                pieOption: {},
                valueOption: {},
                chartOption: {}, //default
            }
        },
        created() {
            console.log("DisplayGoodsByColor created")
        },
        activated() {
            console.log("activated")
        },
        /* TODO ??? */
        mounted() {
            console.log("DisplayGoodsByColor mounted")
            /* FIXME vue各组件生命周期 */
            this.chartOption = this.pieOption
            // console.log("this.chartOption = "  + this.chartOption + ", this.pieOption = " + this.pieOption)
            this.load()
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
                    /* let jsonObj = JSON.parse(JSON.stringify(res.data))
                     this.goodsColorData = jsonObj*/

                    // this.goodsColorData.splice(0,1,res.data.red) //splice增删改
                    for (let key in res.data) {
                        // console.log(key + "---")
                        this.goodsColorData.push({'name': key.toUpperCase(), 'value': res.data[key]})
                    }

                    this.initPage()

                    if (res.code === "1") {
                        console.log("goodsDisplayByColor")
                    } else {
                        console.log(res.msg)
                    }

                })
                this.myChart = this.$refs.myChart
                window.addEventListener('resize', this.resizeCharts)
            },

            /* Page initialization */
            initPage() {
                this.myChart = echarts.init(document.getElementById('myChart')); //初始化

                this.pieOption = {
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        top: '5%',
                        left: 'center'
                    },
                    series: [
                        {
                            name: 'Display Goods By Color',
                            type: 'pie', //饼图
                            radius: ['40%', '70%'],
                            avoidLabelOverlap: false,
                            itemStyle: {
                                borderRadius: 10,
                                borderColor: '#fff',
                                borderWidth: 2,
                                normal: {
                                    color: function (colors) {
                                        const colorList = [
                                            '#ee6666',
                                            '#3ba272',
                                            '#5470c6',
                                            '#fac858',

                                            /*        '#5470c6',
                                                    '#91cc75',
                                                    '#fac858',
                                                    '#ee6666',
                                                    '#73c0de',
                                                    '#3ba272',
                                                    '#fc8452',
                                                    '#9a60b4',
                                                    '#ea7ccc',*/

                                        ];
                                        return colorList[colors.dataIndex];
                                    }
                                },
                            },
                            label: {
                                show: false,
                                position: 'center'
                            },
                            emphasis: {
                                label: {
                                    show: true,
                                    fontSize: '40',
                                    fontWeight: 'bold'
                                }
                            },
                            labelLine: {
                                show: false
                            },
                            data: this.goodsColorData //通过this指针调用全局变量
                        }
                    ]
                }
                /*        this.valueOption = {
                            xAxis: {
                                type: 'type',
                                data: ['Red', 'Yellow', 'Blue', 'Green']
                            },
                            yAxis: {
                                type: 'number'
                            },
                            series: [
                                {
                                    data: [120, 200, 150, 80],
                                    type: 'bar',
                                    showBackground: true,
                                    backgroundStyle: {
                                        color: 'rgba(180, 180, 180, 0.2)'
                                    }
                                }
                            ]
                        }*/

                this.chartOption = this.pieOption
                this.myChart.setOption(this.chartOption)
            },

            /* 监听图表容器的大小并改变图表大小 */
            resizeCharts() {
                this.myChart.resize();
            },

            setPie() {
                console.log("setPie")
                this.chartOption = this.pieOption
                this.goodsColorData = []
                this.load()
            },

            setValue() {
                console.log("setValue")
                this.chartOption = this.valueOption
                this.goodsColorData = []
                this.load()
            },
        },

    }

</script>

<style scoped>
    .title {

    }
</style>