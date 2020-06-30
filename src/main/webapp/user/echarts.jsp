<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script type="text/javascript">

         $(function () {
             // 基于准备好的dom，初始化echarts实例
             var myChart = echarts.init(document.getElementById('main'));
             var myChart1 = echarts.init(document.getElementById('second'));

             var names = [];
             var count= [];
             $.ajax({
                 type:"GET",
                 url:"${pageContext.request.contextPath}/phone",
                 success:function (msg) {
                     for(key in msg){
                         names.push(key);
                         count.push(msg[key])
                     }

                     //图表要展示的数据
                     // 指定图表的配置项和数据
                     // 指定图表的配置项和数据
                     var option = {
                         title: {
                             text: 'ECharts 入门示例'},
                         legend: {
                             data:['销量']
                         },
                         xAxis: {
                             data: names
                         },
                         yAxis: {},
                         series: [{
                             name: '销量',
                             type: 'bar',
                             data:  count
                         }]
                     };
                     myChart.setOption(option);

                     myChart1.setOption(option);
                 }
             });
         });

    </script>
</head>
<body>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 400px;height:300px;"></div>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="second" style="width: 400px;height:300px;"></div>


</body>
</html>
