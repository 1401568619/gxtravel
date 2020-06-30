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

    <script type="text/javascript">

        function commit() {
            var score= $("#score").val();
            if(score == ""){
                return;
            }
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath }/submitScenicScore",
                data:$("#forms").serialize(),
                success:function(msg){
                    if(msg == "ok"){
                        alert("评分成功");
                    }
                }
            });

        }

    </script>
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
                    <span>景点门票</span>
                </div>
                <%--下面是固定的数据，需要从数据库查--%>
                <div class="js_wrap claerdix">
                    <p>&nbsp;</p>

                        <div class="js_wrap claerdix" style="background-color: whitesmoke;">
                            <div class="js_con clearfix">
                                <div class="js_l">
                                    <a href="#"><img src="${pageContext.request.contextPath}/${scenic.pic }"></a>
                                </div>
                                <div class="js_c">
                                    <p>
                                        <b>【${scenic.name}】</b>
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
                                        <span class="fn_o">￥</span><b>${scenic.cheapestPrice}</b>起
                                    </p>
                                    <a href="#" class="btn btn-default btn-info" data-toggle="modal" data-target="#shouldKnowDialog" >购买须知</a>
                                </div>
                            </div>
                            <div class="js_con clearfix">
                                <div class="js_c" style="width:120px">
                                    <p>
                                        <font style="color: #9d9d9d">门票</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </p>
                                </div>
                                <div class="js_c" style="width:260px">
                                    <p>
                                        <font style="color: #9d9d9d">说明</font>
                                    </p>
                                </div>
                                <div class="js_c">
                                    <p>
                                        <font style="color: #9d9d9d">门市价</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <font style="color: #9d9d9d">站内价</font>
                                    </p>
                                </div>
                                <div class="js_r" style="padding-right: 20px">
                                    <p>
                                        <font style="color: #9d9d9d">操作</font>
                                    </p>
                                </div>
                            </div>
                            <c:forEach items="${scenic.ticketList}" var="ticket">
                                <div class="js_con clearfix">
                                    <div class="js_c" style="width:120px">
                                        <p>
                                            <font style="color: #9d9d9d">${ticket.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </p>
                                    </div>
                                    <div class="js_c" style="width:260px">
                                        <p>
                                            <font style="color: #9d9d9d">${ticket.explain}</font>
                                        </p>
                                    </div>
                                    <div class="js_c">
                                        <p>
                                            <font style="color: #9d9d9d">${ticket.dprice}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <font style="color: #9d9d9d">${ticket.mprice}</font>
                                        </p>
                                    </div>
                                    <div class="js_r" style="padding-right: 11px; ">
                                        <p>
                                        <form action="${pageContext.request.contextPath }/getOrderInfo?id=${ticket.id}" method=post>
                                            <input  type="submit" value="购买" class="btn btn-default btn-info" style="padding: 3px 6px;font-size: 11px">
                                        </form>
                                        </p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <p>&nbsp;</p>
                </div>
            </div>
        </div>
        <c:if test="${!empty user }">
        <div class="col-md-4 column" style="width:260px;">
            <div class="clumn" style="width:260px;border:1px solid #E8E8E8">
                <div class="clumn_tit t01">
                    <span>您可以对该景点评分</span>
                </div>
                <div class="clumn _con">
                    <form id="forms" method="post">
                        <input type="text" id="score" value="${score}" name="score" placeholder="1-5分">
                        <input type="hidden" name="scenicid" value="${scenic.id}"/>
                        <button type="button" onclick="commit()">提交</button>
                    </form>
                </div>
<%--                <div class="clumn _con">--%>
<%--                    <form  action="${pageContext.request.contextPath }/changeScenicScore" method="post">--%>
<%--                    <ul class="clu_ul page_ul">--%>
<%--                        <li style="height: 3px"><a href="#" style="height: 3px">&nbsp;</a></li>--%>
<%--                        <li><input type="radio" id="score1" value="1" name="score">不满意</li>--%>
<%--                        <li><input type="radio" id="score2" value="2" name="score">不太不满意</li>--%>
<%--                        <li><input type="radio" id="score3" value="3" name="score">一般</li>--%>
<%--                        <li><input type="radio" id="score4" value="4" name="score">满意</li>--%>
<%--                        <li><input type="radio" id="score5" value="5" name="score">非常满意</li>--%>
<%--                        <input type="hidden" name="scenicid" value="${scenic.id}"/>--%>
<%--                        <button type="submit">提交</button>--%>
<%--                    </ul>--%>
<%--                    </form>--%>
<%--                </div>--%>
            </div>
        </div>
        </c:if>
        <div class="col-md-4 column" style="width:260px;">
            <div class="clumn" style="width:260px;border:1px solid #E8E8E8">
                <div class="clumn_tit t01">
                    <span>您可以查询相似景点</span>
                </div>
                <div class="clumn _con">
                    <form action="${pageContext.request.contextPath }/findSimilarItem?scenicid=${scenic.id}" method="post">
                        <input type="hidden" name="scenicid" value="${scenic.id}">
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

<!-- 购买须知 -->
<div class="modal fade" id="shouldKnowDialog" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" style="width: 1366px">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">购买须知</h4>
            </div>
            <form action="${pageContext.request.contextPath }/insertManager" class="form-horizontal" id="add_form" method="post" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="add_name" class="col-sm-2 control-label">使用方式：</label>
                        <div class="col-sm-10" >
                            <label for="add_name" class="col-sm-10 control-label" style="text-align: left">凭订单信息中的取票码取票后入园</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_name" class="col-sm-2 control-label">有效期限：</label>
                        <div class="col-sm-10">
                            <label for="add_name" class="col-sm-10 control-label" style="text-align: left">不指定日期，仅可使用一次</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_name" class="col-sm-2 control-label">退改说明：</label>
                        <div class="col-sm-10">
                            <label for="add_name" class="col-sm-10 control-label" style="text-align: left">预订后不可以退票</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_name" class="col-sm-2 control-label">优惠政策：</label>
                        <div class="col-sm-10">
                            <label for="add_name" class="col-sm-10 control-label" style="text-align: left">以景区优惠信息为准</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_name" class="col-sm-2 control-label">重要提示：</label>
                        <div class="col-sm-10">
                            <label for="add_name" class="col-sm-10 control-label" style="text-align: left">请仔细阅读门票说明，如有其他消费项目，请按规定另行付费</label>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">我知道了</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>