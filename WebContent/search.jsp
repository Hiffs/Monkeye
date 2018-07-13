<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>搜索结果-${param.search}-猴眼电影</title>
	<link rel="shortcut icon" href="img/logo.png"/>
	<link rel="stylesheet" href="css/reset.css"/>
	<link rel="stylesheet" href="css/search_page.css"/>
    <link rel="stylesheet" href="css/footer.css"/>
    <link rel="stylesheet" href="css/header.css"/>
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
                    <li><a class="active" href="index.do">首页</a></li>
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
                <input class="search" type="text" value="${param.search}" placeholder="找电影" maxlength="32" name="search"/>
                <input class="submit" type="submit" value=""/>
            </form>
        </div>
    </div>
    <div class="header-placeholder"></div>
    
    <div class="container clearfix">
    	<div class="result_box clearfix">
    		<dl class="movie_list clearfix">
    		
    			<c:forEach var="f" items="${fm}">
    			<dd>
    				<div class="movie_item">
    					<a href="film1.do?id=${f.id}"><img src="${iPath[f.id]}"/></a>
    				</div>
    				<div class="movie_name">
    					<a href="film1.do?id=${f.id}" class="title_a" title="${f.name}">${f.name}</a>
    				</div>
    				<div class="movie_info">
    					<div class="movie_mark">${f.score}<c:if test="${empty f.score}">暂无评分</c:if></div>
    					<div class="movie_type">${aft[f.id]}</div>
    					<div class="movie_ontime on">${f.filmtime_place}</div>
    				</div>
    			</dd>
    			</c:forEach>
    			
    			<c:if test="${!empty sd}">
    				<div class="sd clearfix">
    				<div class="so1">
    					很抱歉，没找到相关的影视剧
    				</div>
    				<div class="so2">
    					小猴建议您：
    				</div>
    				<div class="so3">
    					1. 请检查输入的关键词是否有误
    				</div>
    				<div class="so3">
    					2. 请缩短关键词
    				</div>
    			</div>
    			</c:if>
    		</dl>
    	</div>
    </div>
    
    
    
    <div class="footer">
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
