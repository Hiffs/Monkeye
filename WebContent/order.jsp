<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>猴眼电影-让海量电影更贴近你</title>
		<link rel="shortcut icon" href="img/logo.png"/>
		<link rel="stylesheet" href="css/reset.css"/>
		<link rel="stylesheet" href="css/index.css"/>
   		<link rel="stylesheet" href="css/footer.css"/>
   		<link rel="stylesheet" href="css/header.css"/>
		<link rel="stylesheet" href="css/percen_page.css" />
		<link rel="stylesheet" type="text/css" href="css/order_page.css"/>
		<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="js/search.js"></script>
	</head>
	<body>
		<div class="header">
        <div class="header-inner">
            <a class="logo" href="index.do" title="猴眼电影-让海量电影更贴近你"> 
                <img src="img/logo1.png" alt="logo"/>
            </a>
            <div class="city-container"> 广州</div>
            <div class="nav">
                <ul class="navbar">
                    <li><a href="index.do">首页</a></li>
                    <li><a href="film.do">电影</a></li>
                    <li><a href="cinema.do">影院</a></li>
                    <li><a href="news.jsp">热点</a></li>
                </ul>
            </div>
            <div class="user-info">
				<div class="user-avatar">
					<a href=""><img <c:if test="${!empty aPath}">src="${aPath}"</c:if> 
					src="http://p0.meituan.net/movie/7dd82a16316ab32c8359debdb04396ef2897.png" alt="头像"/></a>
					
					<ul class="user-menu">
						<c:if test="${empty aPath}">
	                        <li>
	                            <a href="login.jsp">登陆</a>
	                        </li>
                        </c:if>
                        
                        <c:if test="${!empty aPath}">
	                        <li>
	                            <a href="order.do?id=${user.id}">我的订单</a>
	                        </li>
	                        <li>
	                            <a href="per_cen.jsp">基本信息</a>
	                        </li>
	                        <li>
	                            <a href="exit.fo">退出登陆</a>
	                        </li>
                    	</c:if>
               	  </ul>
                </div>
            </div>
            <form class="search-form" action="search.do" method="POST" target="_blank">
                <input class="search" type="text" placeholder="找电影" maxlength="32" name="search"/>
                <input class="submit" type="submit" value=""/>
            </form>
        </div>
    </div>
    <div class="header-placeholder"></div>
    
    <div class="container">
    	<div class="content">
    		<div class="con_left">
    			<h2>个人中心</h2>
    			<a href="http://localhost:8080/Ticket/order.jsp" class="active">我的订单</a>
    			<a href="http://localhost:8080/Ticket/per_cen.jsp">基本信息</a>
    		</div>
    		<div class="con_right">
    			<div class="right_h">
    				我的订单
    			</div>
    			<div class="order_box">
    				<div class="order_header">
    					<span class="order_date">2018-06-04</span>
    					<span class="order_id">猫眼订单号:3173643914</span>
    					<span class="del_order"></span>
    				</div>
    				<div class="order_body">
    					<div class="order_poster">
    						<img src="http://p0.meituan.net/movie/f193e43ca706aa6bc6a26d6f53f0115a5315542.jpg@66w_91h_1e_1c"/>
    					</div>
    					<div class="order_content">
    						<div class="movie-name">《超时空同居》</div>
    						<div class="ciname-name">万达国际影城(增城店)</div>
    						<div class="hall-ticket">
    							<span>2号厅-6FL高亮厅</span>
    							<span>1排8座</span>
    							<span>9排13座</span>
    						</div>
    						<div class="show-time">今天 6月4日 21:00</div>
    					</div>
    					<div class="order_price">￥77</div>
    					<div class="order_status">待支付</div>
    					<div class="order_action">
    						<div class="action_n">
    							<a href="" class="pay-btn">付款</a>
    							<a href="" class="order-details">查看详情</a>
    						</div>
    					</div>
    				</div>
    			</div>
    			
    		</div>
    	</div>
    	
    	<div class="mask1">
    		<div class="model_con" style="display:none;">
    			<div class="model">
    				<span class="icon"></span>
    				<p class="ti">您确定要删除该订单嘛？删除后，不可恢复～</p>
    				<div class="short btn ok_btn">确定</div>
    				<div class="short btn cl_btn">取消</div>
    				
    			</div>
    		</div>
    	</div>
    </div>
    <div class="footer" style="visibility: visible">
		<p class="friendly-links">
			友情链接 :
			<a target="_blank" href="#">团美网</a>
			<span></span>
			<a target="_blank" href="#">团美下载</a>
		</p>
		<p>
			2016 猴眼电影 houyan.com
			<a target="_blank" href="#">京ICP证160733号</a>
			<a target="_blank" href="#">京ICP备16022489号-1</a>
			京公网安备 11010502030881号
			<a target="_blank" href="#">网络文化经营许可证</a>
			<a target="_blank" href="http://www.meituan.com/about/rules">电子公告服务规则</a>
		</p>
		<p>广州猴眼文化传媒有限公司</p>
	</div>
	</body>
</html>

