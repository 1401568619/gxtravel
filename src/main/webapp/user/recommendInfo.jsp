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
                    <span>推荐景点</span>
                </div>
                <%--下面是固定的数据，需要从数据库查--%>
                <div class="js_wrap claerdix">
                    <p>&nbsp;</p>
                    <c:forEach items="${recommendScenic}" var="scenic">
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
                                <div class="js_r">
                                    <p>&nbsp;</p>
                                    <p>
                                        <span class="fn_o"></span><b>${scenic.prediction}</b>分
                                    </p>
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
        <div class="col-md-4 column" style="width:260px;">
            <div class="clumn" style="width:260px;border:1px solid #E8E8E8">
                <div class="clumn_tit t01">
                    <span>系统为您推荐相似用户</span>
                </div>
                <div class="clumn _con">
                    <form action="${pageContext.request.contextPath }/findSimilarUser" method="post">
                        <br>
                        <input type="submit" value="点击查询">
                    </form>
                </div>
            </div>
        </div>

        </div>

    </div>








    <!-- 引入footer.jsp -->
    <jsp:include page="footer.jsp"></jsp:include>
</div>


</body>
</html>