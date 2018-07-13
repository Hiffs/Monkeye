<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="img/logo.png"/>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/film.css">
<link rel="stylesheet" href="css/cinema.css">
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<title>影院选择-猴眼电影</title>
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
	<div class="banner">
		<div class="wrapper clearfix">
			<div class="celeInfo-left">
				<div class="avatar-shadow">
					<img class="avatar" alt="图" src="${requestScope.imgPath}"/>
				</div>
			</div>
			<div class="celeInfo-right">
				<div class="movie-brief-container">
					<h3 class="name">${requestScope.film.name}</h3>
					<br/>
					<ul>
						<li class="ellipsis">类型:<c:forEach var="type" items="${requestScope.types}">${type}&nbsp;</c:forEach></li>
						<li class="ellipsis">${requestScope.film.area}/${requestScope.film.time}</li>
						<li class="ellipsis">${requestScope.film.filmtime_place}</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="header-placeholder"></div>
    <div class="container">
        <div class="tags-panel">
            <ul class="tags-lines">
                <li class="tags-line">
                    <div class="tags-title">品牌：</div>
                    <ul class="tags">
                        <li <c:if test="${id2==0}"> class="active" </c:if> ><a href="selectCinema.do?id2=0&id=${id}">全部</a></li>
                        <c:forEach var="cinema" items="${requestScope.cinemas}">
                        	<li <c:if test="${cinema.id==id2}"> class="active" </c:if>><a href="selectCinema.do?id2=${cinema.id}&id=${id}">${cinema.name}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="tags-line tags-line-border">
                    <div class="tags-title">行政区：</div>
                    <ul class="tags">
                        <li <c:if test="${aarea=='zero'}"> class="active" </c:if>><a href="selectCinema.do?id2=${id2}&area=zero&id=${id}">全部</a></li>
                        <c:forEach var="area" items="${requestScope.areas}">
                        	<li <c:if test="${aarea==area}"> class="active" </c:if>><a href="selectCinema.do?id2=${id2}&area=${area}&id=${id}">${area}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="cinemas-list">
            <h2 class="cinemas-list-header">影院列表</h2>
            <c:forEach var="newCinemas" items="${requestScope.newCinemas}" varStatus="status">
	            <div class="cinema-cell">
		                <div class="cinema-info">
		                    <a class="cinema-name" href="#">${newCinemas.name}</a>
		                    <p class="cinema-address">地址：${newCinemas.location}</p>
		                </div>
		                <div class="buy-btn">
		                    <a  href="cinema1.do?cinemaid=${newCinemas.id}" >选座购票</a>
		                </div>
		                <div class="price">
		                    <span class="rmb red">￥</span>
		                    <span class="price-num red">23</span>
		                    <span>起</span>
		                </div>
	            </div>
            </c:forEach>
        </div>
        <div class="cinemas-pager">
        	<ul class="list-pager">
            	<!-- 首页，没有上一页 -->
                <c:if test="${requestScope.pageBean.pageIndex == 1}">
                	<c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    	<c:if test="${requestScope.pageBean.pageIndex == i}">
                       		<li class="active">
                            	<a class="page_${i }" style="cursor:default" href="selectCinema.do?pageIndex=${i}&id=${id}">${i}</a>
                       		</li>
                        </c:if>
                       	<c:if test="${requestScope.pageBean.pageIndex != i}">
                       		<li>
		                    	<a class="page_${i}" href="selectCinema.do?pageIndex=${i}&id=${id}">${i}</a>
		                    </li>
                       	</c:if>
                    </c:forEach>
                    <c:if test="${requestScope.pageBean.pages > 5}">
                        <c:if test="${requestScope.pageBean.end != 6}">
                       		<li class="sep">...</li>
                       	</c:if>
                       	<li>
                           	<a class="page_${requestScope.pageBean.pages}" href="selectCinema.do?pageIndex=${requestScope.pageBean.pages}&id=${id}">${requestScope.pageBean.pages}</a>
                       	</li>
                    </c:if>
                    <c:if test="${requestScope.pageBean.end != 1}">
                    	<li>
                        	<a class="page_${requestScope.pageBean.pageIndex + 1}" href="selectCinema.do?pageIndex=${requestScope.pageBean.pageIndex + 1}&id=${id}">下一页</a>
                    	</li>
                    </c:if>
                </c:if>
                <!-- 中间，有上一页和下一页 -->
                <c:if test="${requestScope.pageBean.pageIndex > 1 && requestScope.pageBean.pageIndex < requestScope.pageBean.pages}">
                    <li>
                        <a class="page_${requestScope.pageBean.pageIndex - 1}" href="selectCinema.do?pageIndex=${requestScope.pageBean.pageIndex - 1}&id=${id}">上一页</a>
                    </li>
                    <c:if test="${requestScope.pageBean.pageIndex >= 4}">
                    	<li>
                        	<a class="page_1" href="selectCinema.do?pageIndex=1&id=${id}">1</a>
                       	</li>
                    </c:if>                        	
                    <c:if test="${requestScope.pageBean.start > 2}">
                    	<li class="sep">...</li>
                    </c:if>
                    <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
	                    <c:if test="${requestScope.pageBean.pageIndex == i}">
	                    	<li class="active">
	                        	<a class="page_${i }" href="selectCinema.do?pageIndex=${i}&id=${id}">${i}</a>
	                        </li>
	                    </c:if>
	                    <c:if test="${requestScope.pageBean.pageIndex != i}">
	                    	<li>
			                	<a class="page_${i}" href="selectCinema.do?pageIndex=${i}&id=${id}">${i}</a>
			                </li>
	                    </c:if>
                    </c:forEach>
                     	<c:if test="${(requestScope.pageBean.end + 1) < requestScope.pageBean.pages}">
                    		<li class="sep">...</li>
                    	</c:if>
                     	<c:if test="${requestScope.pageBean.pageIndex < requestScope.pageBean.pages - 2}">
                     		<li>
                        		<a class="page_${requestScope.pageBean.pages}" href="selectCinema.do?pageIndex=${requestScope.pageBean.pages}&id=${id}">${requestScope.pageBean.pages}</a>
                    		</li>
                     	</c:if>
                     	<li>
                         	<a class="page_${requestScope.pageBean.pageIndex + 1}" href="selectCinema.do?pageIndex=${requestScope.pageBean.pageIndex + 1}&id=${id}">下一页</a>
                     	</li>
                </c:if>
                <!-- 尾部，没有下一页 -->
                <c:if test="${requestScope.pageBean.pageIndex == requestScope.pageBean.pages && requestScope.pageBean.pages != 1}">
                	<li>
                    	<a class="page_${requestScope.pageBean.pageIndex - 1}" href="selectCinema.do?pageIndex=${requestScope.pageBean.pageIndex - 1}&id=${id}">上一页</a>
                    </li>
                    <c:if test="${requestScope.pageBean.start != 1}">
                    	<li>
                    		<a class="page_1" href="selectCinema.do?pageIndex=1&id=${id}">1</a>
                    	</li>
                    </c:if>
                   	<c:if test="${requestScope.pageBean.start > 2}">
                   		<li class="sep">...</li>
                   	</c:if>
                   	<c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    	<c:if test="${requestScope.pageBean.pageIndex == i}">
                      		<li class="active">
                          		<a class="page_${i }" href="selectCinema.do?pageIndex=${i}&id=${id}">${i}</a>
                      		</li>
                      	</c:if>
                     	<c:if test="${requestScope.pageBean.pageIndex != i}">
                     		<li>
                        		<a class="page_${i}" href="selectCinema.do?pageIndex=${i}&id=${id}">${i}</a>
                        	</li>
                   		</c:if>
               		</c:forEach>
            	</c:if>
        	</ul>
        </div>
    </div>
	
</body>
</html>