<!--
数据可视化 所有商品 颜色
red blue yellow green
 -->
<template>
    <div>
        <div class="title">
            <h1>Goods Statistics By Color</h1>
        </div>

        <div id="myChart" ref="myChart" :style="{width: '100%', height:'100vh',display:'flex'}"> </div>

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
            console.log("DisplayGoodsByColor created")
            this.load()
            // this.initPage()
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
                    /* FIXME 传数据 */

                    /* let jsonObj = JSON.parse(JSON.stringify(res.data))
                     this.goodsColorData = jsonObj*/

                    // this.goodsColorData.splice(0,1,res.data.red) //splice增删改
                    for (let key in res.data) {
                        // console.log(key + "---")
                        this.goodsColorData.push({'name': key.toUpperCase(), 'value': res.data[key]})
                    }

                    this.initPage()

                    if (res.code == "1") {
                        console.log("goodsDisplayByColor")
                    } else {
                        console.log(res.msg)
                    }

                })
            },

            /* Page initialization */
            initPage() {
                this.myChart = echarts.init(document.getElementById('myChart')); //初始化
                /* TODO 加载goods数据 */
                // this.load()

                let option = {
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
                                            '#FF0000',
                                            '#7FFF00',
                                            '#0000FF',
                                            '#FFFF00',

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
                this.myChart.setOption(option)
            },

            /* 监听图表容器的大小并改变图表大小 */
            resizeCharts(){
                this.myChart.resize();
            }
        },

    }

</script>

<style scoped>
.title{
     margin: 10px auto;
}
</style>