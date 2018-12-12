<template>

  <section class="chart-container">

    <el-row>

      <el-col :span="12">
        <div id="chart1" style="width:100%; height:400px;"></div>
      </el-col>



    </el-row>
    <el-col :span="24">
      <a href="http://echarts.baidu.com/examples.html" target="_blank" style="float: right;">more>></a>
    </el-col>
  </section>

</template>

<script>
  import echarts from 'echarts'
    export default {
        name: "loan-count",
      data()  {
            return {
              char1: null
            }
      },
      methods: {
          drawChar1() {
            this.char1=echarts.init(document.getElementById('chart1'));
            this.char1.setOption({
              title: {
              text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
              data:['销量']
            },
            xAxis: {
              data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis: {},
            series: [{
              name: '销量',
              type: 'bar',
              data: [5, 20, 36, 10, 10, 20]
            }]
            });
          },
        drawChart(){
          this.drawChar1()
        }
      },
      mounted: function() {
          this.drawChart()
      },
      updated: function () {
        this.drawChart()
      }
    }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .chart-container {
    width: 100%;
    float: left;
  }
  /*.chart div {
      height: 400px;
      float: left;
  }*/

  .el-col {
    padding: 30px 20px;
  }
</style>
