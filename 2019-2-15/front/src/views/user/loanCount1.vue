<template>

  <section class="chart-container">

    <el-row>

      <el-col :span="12">
        <div id="chart1" style="width:100%;height:400px;">

        </div>
      </el-col>

      <el-col :span="12">
        <div id="chart2" style="width:100%;height:400px;">

        </div>
      </el-col>

      <el-col :span="12">
        <div id="chart3" style="width:100%;height:400px;"></div>
      </el-col>

      <el-col :span="12">
        <div id="chart4" style="width:100%;height:400px;">

        </div>
      </el-col>

    </el-row>

  </section>

</template>

<script>
    export default {
        name: "loan-count",
      data()  {
            return {
              char1:null,
              char2:null,
              char3:null,
              char4:null
            }
      },
      methods:{
          drawChar1() {
            this.char1=echarts.init(document.getElementById('chart1'));
            this.char1.setOption({title: {
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
            }]});
          },
          drawChar2() {
            this.char2=echarts.init(document.getElementById('chart2'));
            this.char2.setOption();
          },
        drawChar3() {
           this.char3=echarts.init(document.getElementById('chart3'));
           this.char3.setOption();
        },
        drawChar4() {
            this.char4=echarts.init(document.getElementById('chart4'));
            this.char4.setOption();
        },
        drawChart(){
          this.drawChar1()
          this.drawChar2()
          this.drawChar2()
          this.drawChar2()
        }
      },
      mounted:function() {
          this.drawChart()

      },
      updated: function () {
        this.drawChart()
      }
    }
</script>

<style scoped>
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
