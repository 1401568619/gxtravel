<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" uri="http://commonutils.cn/tld/"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>相似用户</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/image/logo1.png" type="../image/x-icon" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <link href="css/styles.css" rel="stylesheet" type="text/css" />
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <script>

        function selectScenicByUser(userid) {


            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/selectScenicByUser",
                data:{"userid":userid},
                success:function (result) {
                    $("#list-table").find("tr[name='addtr']").remove();
                    $(result).each(function (index,item) {
                        var tr = "<tr name='addtr' align='center' bgcolor='#FFFFFF'>"
                            +"<td><img align='center' height='50px' src='${pageContext.request.contextPath}/"+item.pic+"'></td>"
                            +"<td align='left'>"+item.name+"</td>"
                            +"<td align='left'>"+item.theme+"</td>"
                            +"<td align='left'><a href='${pageContext.request.contextPath}/getScenicAndTicket?id="+item.id+"'>查看详情</a></td>"
                            +"</tr>";
                        //添加子元素
                        $("#focus-tr").before(tr);
                    });
                }
            });
        }

    </script>
</head>
<body>
<div class="container-fluid">
    <!-- 引入header.jsp -->
    <jsp:include page="header.jsp"></jsp:include>

    <!-- 热门推荐 -->
    <div class="clumn" style="width:1280px;border:1px solid #E8E8E8;margin-top: 15px;margin-left: 20px">
        <div class="clumn_tit t01">
            <span>以下是与你兴趣相似的用户</span>
        </div>
        <div class="container-fluid" style="padding-top: 15px">
            <%--下面是固定的数据，需要从数据库查--%>
            <div class="col-md-12" >
                <c:forEach items="${similarUserList}" var="user">
                    <div class="col-md-4 column" >
                        <div class="row">
                            <div class="col-md-12">
                                <div class="thumbnail">
                                    <div class="caption">
                                        <p>
                                            <b>【${user.username}】</b>
                                        </p>
                                        <p>&nbsp;&nbsp;<font style="color: #9d9d9d">联系邮箱：</font>
                                                ${user.email}</p>
                                        <p>&nbsp;&nbsp;<font style="color: #9d9d9d">联系电话：</font>
                                                ${user.telephone}</p>
                                        <p>&nbsp;&nbsp;<button onclick="selectScenicByUser(${user.userid})">查看ta喜欢的景点</button></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <table id="list-table" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
    <tr bgcolor="#FAFAF1" id="focus-tr">

    </tr>
    </table>
    <!-- 引入footer.jsp -->
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>