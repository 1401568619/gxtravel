<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" uri="http://commonutils.cn/tld/"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的评分</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/image/logo1.png" type="../image/x-icon" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }
        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }
    </style>
</head>
<body>
<!-- 引入header.jsp -->
<jsp:include page="./header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div style="margin: 0 auto; margin-top: 10px; width: 900px;">
            <h2>我的评分</h2>
            <table class="table table-bordered">
                <tr class="warning">
                    <th>景点编号</th>
                    <th>景点名称</th>
                    <th>景点主题</th>
                    <th>景点评分</th>
                </tr>
                <c:forEach items="${myScenicScore}" var="scenic">
                    <tbody>
                    <tr class="active">
                        <td width="15%">
                            <span class="subtotal">${scenic.id}</span>
                        </td>
                        <td width="15%">
                            <span class="subtotal"><a href="${pageContext.request.contextPath }/getScenicAndTicket?id=${scenic.id}">${scenic.name}</a></span>
                        </td>
                        <td width="15%">
                            <span class="subtotal">${scenic.theme}</span>
                        </td>
                        <td width="15%">
                            <span class="subtotal">${scenic.prediction}</span>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>

            </table>
        </div>
    </div>
</div>

<!-- 引入footer.jsp -->
<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>