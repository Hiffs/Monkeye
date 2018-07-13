<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="img/logo.png"/>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/cinema.css">
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<title>影院-猴眼电影</title>
</head>
<body>
<div class="header">
        <div class="header-inner">
            <a class="logo" href="index.do" title="猴眼电影-让海量电影更贴近你">
                <img src="img/logo1.png" alt="logo"/>
            </a>
            <div class="city-container">
                广州
            </div>
            <div class="nav">
                <ul class="navbar">
                    <li><a href="index.do">首页</a></li>
                    <li><a href="film.do">电影</a></li>
                    <li><a class="active" href="#">影院</a></li>
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
                <input class="search" type="search" placeholder="找电影" maxlength="32" name="search"/>
                <input class="submit" type="submit" value=""/>
            </form>
        </div>
    </div>
    <div class="header-placeholder"></div>

    <div class="container">
        <div class="tags-panel">
            <ul class="tags-lines">
                <li class="tags-line">
                    <div class="tags-title">品牌：</div>
                    <ul class="tags">
                        <li <c:if test="${id==0}"> class="active" </c:if> ><a href="cinema.do?id=0">全部</a></li>
                        <c:forEach var="cinema" items="${requestScope.cinemas}">
                        	<li <c:if test="${cinema.id==id}"> class="active" </c:if>><a href="cinema.do?id=${cinema.id}">${cinema.name}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="tags-line tags-line-border">
                    <div class="tags-title">行政区：</div>
                    <ul class="tags">
                        <li <c:if test="${aarea=='zero'}"> class="active" </c:if>><a href="cinema.do?id=${id}&area=zero">全部</a></li>
                        <c:forEach var="area" items="${requestScope.areas}">
                        	<li <c:if test="${aarea==area}"> class="active" </c:if>><a href="cinema.do?id=${id}&area=${area}">${area}</a></li>
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
		                    <a href="#">选座购票</a>
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
                            	<a class="page_${i }" style="cursor:default" href="cinema.do?pageIndex=${i}">${i}</a>
                       		</li>
                        </c:if>
                       	<c:if test="${requestScope.pageBean.pageIndex != i}">
                       		<li>
		                    	<a class="page_${i}" href="cinema.do?pageIndex=${i}">${i}</a>
		                    </li>
                       	</c:if>
                    </c:forEach>
                    <c:if test="${requestScope.pageBean.pages > 5}">
                        <c:if test="${requestScope.pageBean.end != 6}">
                       		<li class="sep">...</li>
                       	</c:if>
                       	<li>
                           	<a class="page_${requestScope.pageBean.pages}" href="cinema.do?pageIndex=${requestScope.pageBean.pages}">${requestScope.pageBean.pages}</a>
                       	</li>
                    </c:if>
                    <c:if test="${requestScope.pageBean.end != 1}">
                    	<li>
                        	<a class="page_${requestScope.pageBean.pageIndex + 1}" href="cinema.do?pageIndex=${requestScope.pageBean.pageIndex + 1}">下一页</a>
                    	</li>
                    </c:if>
                </c:if>
                <!-- 中间，有上一页和下一页 -->
                <c:if test="${requestScope.pageBean.pageIndex > 1 && requestScope.pageBean.pageIndex < requestScope.pageBean.pages}">
                    <li>
                        <a class="page_${requestScope.pageBean.pageIndex - 1}" href="cinema.do?pageIndex=${requestScope.pageBean.pageIndex - 1}">上一页</a>
                    </li>
                    <c:if test="${requestScope.pageBean.pageIndex >= 4}">
                    	<li>
                        	<a class="page_1" href="cinema.do?pageIndex=1">1</a>
                       	</li>
                    </c:if>                        	
                    <c:if test="${requestScope.pageBean.start > 2}">
                    	<li class="sep">...</li>
                    </c:if>
                    <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
	                    <c:if test="${requestScope.pageBean.pageIndex == i}">
	                    	<li class="active">
	                        	<a class="page_${i }" href="cinema.do?pageIndex=${i}">${i}</a>
	                        </li>
	                    </c:if>
	                    <c:if test="${requestScope.pageBean.pageIndex != i}">
	                    	<li>
			                	<a class="page_${i}" href="cinema.do?pageIndex=${i}">${i}</a>
			                </li>
	                    </c:if>
                    </c:forEach>
                     	<c:if test="${(requestScope.pageBean.end + 1) < requestScope.pageBean.pages}">
                    		<li class="sep">...</li>
                    	</c:if>
                     	<c:if test="${requestScope.pageBean.pageIndex < requestScope.pageBean.pages - 2}">
                     		<li>
                        		<a class="page_${requestScope.pageBean.pages}" href="cinema.do?pageIndex=${requestScope.pageBean.pages}">${requestScope.pageBean.pages}</a>
                    		</li>
                     	</c:if>
                     	<li>
                         	<a class="page_${requestScope.pageBean.pageIndex + 1}" href="cinema.do?pageIndex=${requestScope.pageBean.pageIndex + 1}">下一页</a>
                     	</li>
                </c:if>
                <!-- 尾部，没有下一页 -->
                <c:if test="${requestScope.pageBean.pageIndex == requestScope.pageBean.pages && requestScope.pageBean.pages != 1}">
                	<li>
                    	<a class="page_${requestScope.pageBean.pageIndex - 1}" href="cinema.do?pageIndex=${requestScope.pageBean.pageIndex - 1}">上一页</a>
                    </li>
                    <c:if test="${requestScope.pageBean.start != 1}">
                    	<li>
                    		<a class="page_1" href="cinema.do?pageIndex=1">1</a>
                    	</li>
                    </c:if>
                   	<c:if test="${requestScope.pageBean.start > 2}">
                   		<li class="sep">...</li>
                   	</c:if>
                   	<c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    	<c:if test="${requestScope.pageBean.pageIndex == i}">
                      		<li class="active">
                          		<a class="page_${i }" href="cinema.do?pageIndex=${i}">${i}</a>
                      		</li>
                      	</c:if>
                     	<c:if test="${requestScope.pageBean.pageIndex != i}">
                     		<li>
                        		<a class="page_${i}" href="cinema.do?pageIndex=${i}">${i}</a>
                        	</li>
                   		</c:if>
               		</c:forEach>
            	</c:if>
        	</ul>
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