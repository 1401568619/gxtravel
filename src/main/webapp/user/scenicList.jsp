<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" uri="http://commonutils.cn/tld/"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>景点资讯</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/image/logo1.png" type="../image/x-icon" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <link href="css/styles.css" rel="stylesheet" type="text/css" />
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container-fluid">
    <!-- 引入header.jsp -->
    <jsp:include page="header.jsp"></jsp:include>

    <!-- 景点门票 -->
    <div class="container-fluid" style="padding-left: 0px">
        <div class="col-md-12" style="height:20px;">
        </div>
        <%--景点前三名列表--%>
        <div class="col-md-8" style="width:1030px; padding-left: 0px">
            <div class="mf_box">
                <div class="mf_tit clearfix">
                    <span>景点信息</span>
                </div>
                <%--下面是固定的数据，需要从数据库查--%>
                <div class="js_wrap claerdix">
                    <p>&nbsp;</p>
                    <c:forEach items="${page.rows}" var="scenic">
                        <div class="js_wrap claerdix" style="background-color: whitesmoke;">
                            <div class="js_con clearfix">
                                <div class="js_l">
                                    <a href="#"><img src="${pageContext.request.contextPath}/${scenic.pic }"></a>
                                </div>
                                <div class="js_c">
                                    <p>
                                        <b>【<a href="${pageContext.request.contextPath }/getScenicAndTicket?id=${scenic.id}">${scenic.name}</a>】</b>
                                    </p>
                                    <p>&nbsp;&nbsp;<font style="color: #9d9d9d">景点主题：</font>
                                            ${scenic.theme}</p>
                                    <p>&nbsp;&nbsp;<font style="color: #9d9d9d">景点地址：</font>
                                            ${scenic.addr}</p>
                                    <p>&nbsp;&nbsp;<font style="color: #9d9d9d">景点特色：</font>
                                            ${scenic.feature}</p>
                                </div>
                            </div>
                        </div>
                        <p>&nbsp;</p>
                    </c:forEach>
                    <c:if test="${page.rows.size()==0}">
                        <img src="${pageContext.request.contextPath}/image/kong.png" style="width:100%;height:115%;">
                        <div class="carousel-caption" style="padding-bottom: 150px">
                            <!-- 图上的文字 -->
                            <h2>很抱歉！没有找到关于该地址的景区信息！建议您查询其他区县的景区！</h2>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
        <%--地址选择+服务保障--%>
        <div class="col-md-4 column" style="width:260px;">
            <div class="clumn" style="width:260px;border:1px solid #E8E8E8">
                <div class="clumn_tit t01">
                    <span>广西当地游</span>
                </div>
                <div class="clumn _con">
                    <ul class="clu_ul page_ul">
                        <li style="height: 3px"><a href="#" style="height: 3px">&nbsp;</a></li>
                        <li><a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=南宁">南宁</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=桂林">桂林</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=梧州">梧州</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=北海">北海</a></li>
                        <li><a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=崇左">崇左</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=钦州">钦州</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=贵港">贵港</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=玉林">玉林</a></li>
                        <li><a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=百色">百色</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=贺州">贺州</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=河池">河池</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=来宾">来宾</a></li>
                        <li><a href="${pageContext.request.contextPath }/getScenicPageForUser?addr=防城港">防城港</a></li>&nbsp;&nbsp;&nbsp;
                    </ul>
                </div>
            </div>
            <div class="clumn" style="width:260px;border:1px solid #E8E8E8">
                <div class="clumn_tit t01">
                    <span>景点类型</span>
                </div>
                <div class="clumn _con">
                    <ul class="clu_ul page_ul">
                        <li style="height: 3px"><a href="#" style="height: 3px">&nbsp;</a></li>
                        <li><a href="${pageContext.request.contextPath }/getScenicPageForUser?theme=自然山水">自然山水</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?theme=田园风光">田园风光</a></li>
                        <li><a href="${pageContext.request.contextPath }/getScenicPageForUser?theme=沙滩海岸">沙滩海岸</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath }/getScenicPageForUser?theme=主题乐园">主题乐园</a></li>
                        <li><a href="${pageContext.request.contextPath }/getScenicPageForUser?theme=名胜古迹">名胜古迹</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <%--分页--%>

            <div class="col-md-12 text-right" style="text-align:center">
                <p:page url="${pageContext.request.contextPath }/getScenicPageForUser" />
            </div>
    </div>

    <!-- 引入footer.jsp -->
    <jsp:include page="footer.jsp"></jsp:include>
</div>


</body>
</html>