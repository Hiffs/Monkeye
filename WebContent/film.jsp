<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="img/logo.png"/>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/film.css">
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript">
	function changeTab(d){
		var desc = document.getElementById("desc");
		var cele = document.getElementById("celebrity");
		var tabdesc = document.getElementById("tab-desc");
		var tabcele = document.getElementById("tab-celebrity");
		if(d == 1){
			desc.className = "tab-title active";
			cele.className = "tab-title";
			tabdesc.className = "tab-desc tab-content active";
			tabcele.classList = "tab-celebrity tab-content";
		}
		else if(d == 2){
			desc.className = "tab-title";
			cele.className = "tab-title active";
			tabdesc.className = "tab-desc tab-content";
			tabcele.classList = "tab-celebrity tab-content active";
		}
	}
	$(document).ready(function(){
		$(".comment-entry").click(function(){
			var content=prompt("请输入您的评论！");
			if(${user.id==null}){
				request.getRequestDispatcher("film.jsp").forward(request,response);
			}
			$.ajax({
				type:"GET",
				url:"film.jsp",
				data:content,
				success:function(msg){
					content;
				}
			});
		});
		
		/* click(function(){
			var request=new XMLHttpRequest();
			var method="GET";
			var url=this.href;
			request.open(method,url);
			request.send(null);
			request.onreadystatechange=function(){
				if(request.readyState==4){
					if(request.status==200||request.status==304){
						var content=prompt("请输入您的评论！");
						alert(content);
					}
				}	
			}
			return false;
		}); */
	});
	
</script>
<title>猴眼电影</title>
<style>
	.comment-entry{
		cursor: pointer;
	    position: absolute;
	    top: -10px;
	    right: 0;
	    display: block;
	    height: 30px;
	    padding: 0 10px;
	    border-radius: 15px;
	    border: 1px solid #ef4238;
	    text-align: center;
	    font-size: 14px;
	    line-height: 30px;
	    color: #ef4238;
	    background-color:white;
	}
	.comment-container{
		    margin-top: 20px;
	}
	.comment-container .main-header {
	    position: relative;
	    font-size: 16px;
	}
	.comment-container .comment-content {
	    margin-top: 20px;
	    padding-bottom: 30px;
	    border-bottom: 1px solid #e5e5e5;
	    color: #666;
	    line-height: 26px;
	    font-size: 14px;
	}
</style>
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
					<img class="avatar" alt="图" src="${requestScope.imgPath}">
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
				<div class="buyBtn">
					<a class="buy btn" target="_blank" href="selectCinema.do?id=${requestScope.id}">特惠购票</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="main-content-container">
			<div class="main-content">
				<div class="tab-container">
					<div class="tab-title-container clearfix">
						<div id="desc" class="tab-title active" onclick="changeTab(1)">介绍</div>
						<div id="celebrity" class="tab-title" onclick="changeTab(2)">演职人员</div>
					</div>
					<div class="tab-content-container">
						<div id="tab-desc" class="tab-desc tab-content active">
							<div class="module">
								<div class="mod-title">
									<h3>剧情简介</h3>
								</div>
								<div class="mod-content">
									<span class="dra">
										${requestScope.film.content}
									</span>
								</div>
							</div>
							<div class="module">
								<div class="mod-title">
									<h3>演职人员</h3>
								</div>
								<div class="mod-content">
									<div class="celebrity-container clearfix">
										<div class="celebrity-group">
											<div class="celebrity-type">导演</div>
											<ul class="celebrity-list clearfix">
												<c:forEach var="director" items="${requestScope.directors}">
													<li class="celebrity">
														<a class="portrait" target="_blank" href="#">
															<img alt="图" src="${director.path}">
														</a>
														<div class="info">
															<a class="name" target="_blank" href="#">${director.director}</a>
														</div>
													</li>
												</c:forEach>
											</ul>
										</div>
										<div class="celebrity-group">
											<div class="celebrity-type">演员</div>
											<ul class="celebrity-list clearfix">
												<c:forEach var="actor" items="${requestScope.actors}">
													<li class="celebrity actor">
														<a class="portrait" target="_blank" href="#"> 
															<img alt="" src="${actor.path}"/>
														</a>
														<div class="info">
															<a class="name" target="_blank" href="#">${actor.actor}</a>
	                                                        <br/>
														</div>
													</li>
												</c:forEach>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="module">
								<div class="mod-title">
									<h3>热门短评</h3>
								</div>
								<div class="mod-content">
									<div class="mod-list-container">
										<ul>
											<c:forEach var="comment" items="${requestScope.comments}">
												<li class="comment-container">
													<div class="main-header">
														${comment.getKey()}
													</div>
													<div class="comment-content">
														${comment.getValue()}
													</div>
												</li>
											</c:forEach>
										</ul>
									</div>
									<a class="comment-entry" href="">写短评</a>
								</div>
							</div>
						</div>
						<div id="tab-celebrity" class="tab-celebrity tab-content">
							<div class="celebrity-container">
								<div class="celebrity-group">
									<div class="celebrity-type">导演 </div>
									<ul class="celebrity-list clearfix">
										<c:forEach var="director" items="${requestScope.directors}">
											<li class="celebrity">
												<a class="portrait" target="_blank" href="#">
													<img alt="图" src="${director.path}">
												</a>
												<div class="info">
													<a class="name" target="_blank" href="#">${director.director}</a>
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>
								<div class="celebrity-group">
									<div class="celebrity-type">演员 </div>
									<ul class="celebrity-list clearfix">
										<c:forEach var="actor" items="${requestScope.actors}">
											<li class="celebrity actor">
												<a class="portrait" target="_blank" href="#">
													<img alt="图" src="${actor.path}"/>
												</a>
												<div class="info">
													<a class="name" target="_blank" href="#">${actor.actor}</a>
	                                                <br/>
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
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