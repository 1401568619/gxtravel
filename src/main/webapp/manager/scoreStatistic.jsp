<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="p" uri="http://commonutils.cn/tld/"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>广西旅行咨询网</title>
    <link rel="shortcut icon" href="../image/logo1.png" type="image/x-icon" />
    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath%>css/boot-crm.css" rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery -->
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=basePath%>js/metisMenu.min.js"></script>
    <!-- DataTables JavaScript -->
    <script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
    <script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<%=basePath%>js/sb-admin-2.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>

    <script type="text/javascript">

        $(function () {
            // 基于准备好的dom，初始化echarts实例
            var myChart1 = echarts.init(document.getElementById('one'));
            var myChart2 = echarts.init(document.getElementById('second'));
            var myChart3 = echarts.init(document.getElementById('three'));
            var myChart4 = echarts.init(document.getElementById('four'));

            var namesc = [];
            var countc= [];
            var namesx = [];
            var countx= [];
            var namesq = [];
            var countq= [];
            var namesd = [];
            var countd= [];
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/scoreStatistic",
                success:function (msg) {
                    $(msg.cList).each(function(inedx,item){
                        namesc.push(item.theme);
                        countc.push(item.num)
                    })
                    $(msg.xList).each(function(inedx,item){
                        namesx.push(item.theme);
                        countx.push(item.num)
                    })
                    $(msg.qList).each(function(inedx,item){
                        namesq.push(item.theme);
                        countq.push(item.num)
                    })
                    $(msg.dList).each(function(inedx,item){
                        namesd.push(item.theme);
                        countd.push(item.num)
                    })

                    //图表要展示的数据
                    // 指定图表的配置项和数据
                    // 指定图表的配置项和数据
                    var option1 = {
                        title: {
                            text: '春季好评'},
                        legend: {
                            data:['好评量']
                        },
                        xAxis: {
                            data: namesc
                        },
                        yAxis: {},
                        series: [{
                            name: '好评量',
                            type: 'bar',
                            data:  countc
                        }]
                    };
                    var option2 = {
                        title: {
                            text: '夏季好评'},
                        legend: {
                            data:['好评量']
                        },
                        xAxis: {
                            data: namesx
                        },
                        yAxis: {},
                        series: [{
                            name: '好评量',
                            type: 'bar',
                            data:  countx
                        }]
                    };
                    var option3 = {
                        title: {
                            text: '秋季好评'},
                        legend: {
                            data:['好评量']
                        },
                        xAxis: {
                            data: namesq
                        },
                        yAxis: {},
                        series: [{
                            name: '好评量',
                            type: 'bar',
                            data:  countq
                        }]
                    };
                    var option4 = {
                        title: {
                            text: '冬季好评'},
                        legend: {
                            data:['好评量']
                        },
                        xAxis: {
                            data: namesd
                        },
                        yAxis: {},
                        series: [{
                            name: '好评量',
                            type: 'bar',
                            data:  countd
                        }]
                    };
                    myChart1.setOption(option1);
                    myChart2.setOption(option2);
                    myChart3.setOption(option3);
                    myChart4.setOption(option4);
                }
            });
        });

    </script>
</head>
<body>
<div id="wrapper">
    <!-- 引入navigation.jsp -->
    <jsp:include page="navigation.jsp"></jsp:include>
    <!-- 操作面板 -->
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12" style="height:15px">
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
        <div id="one" style="width: 600px;height:400px;"></div>
        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
        <div id="second" style="width: 600px;height:400px;"></div>
        <div id="three" style="width: 600px;height:400px;"></div>
        <div id="four" style="width: 600px;height:400px;"></div>
    </div>
</div>
</body>

<script type="text/javascript">

</script>
</html>
