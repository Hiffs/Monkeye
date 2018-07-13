<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>热点首页-猴眼电影</title>
		<link rel="shortcut icon" href="img/logo.png"/>
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/header.css"/>
		<link rel="stylesheet" type="text/css" href="css/news_page.css"/>
		<link rel="stylesheet" type="text/css" href="css/footer.css"/>
		<script src="js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="js/search.js"></script>
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
                    <li><a href="cinema.do">影院</a></li>
                    <li><a class="active" href="news.jsp">热点</a></li>
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
	                            <a href="per_cen.do?id=${user.id}">基本信息</a>
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
    
    <div class="subnav">
    	<ul>
    		<li><a href="#" class="a_ctive">热点首页</a></li>
    		<li><a href="#">新闻资讯</a></li>
    		<li><a href="#">精彩图集</a></li>
    	</ul>
    </div>
    
    <div class="container">
    	<div class="con">
    		<div class="latest">
    			<a class="aa" href="" id="arrow1">全部<span></span></a>
    			<h4 class="red">最新资讯</h4>
    			<div class="news_box">
	    			<a href="http://maoyan.com/films/news/39869" target="_blank"><img src="img/news_img6.jpg"/></a>
	    			<p><a href="http://maoyan.com/films/news/39869" target="_blank" class="nba">安吉丽娜朱莉最高票房电影，经典童话暗黑改编，这部电影出续集了</a></p>
	    			<div class="re">
	    				<span class="sn">
	    					猫眼电影
	    				</span>
	    				<span class="sn last_c">4897</span>
	    			</div>
	    		</div>
	    		
	    		<div class="news_box">
	    			<a href="http://maoyan.com/films/news/39868" target="_blank"><img src="img/news_img5.jpg"/></a>
	    			<p><a href="http://maoyan.com/films/news/39868" target="_blank" class="nba">《蓝色金鱼》讲述爱情真谛，分手往往就在一念之间</a></p>
	    			<div class="re">
	    				<span class="sn">
	    					猫眼娱乐
	    				</span>
	    				<span class="sn last_c">489</span>
	    			</div>
	    		</div>
	    		
	    		<div class="news_box">
	    			<a href="http://maoyan.com/films/news/39867" target="_blank"><img src="img/news_img4.jpg"/></a>
	    			<p><a href="http://maoyan.com/films/news/39867" target="_blank" class="nba">《泡菜》后续再创新捷，沈志豪：要带给大家更多精彩作品</a></p>
	    			<div class="re">
	    				<span class="sn">
	    					猫眼电影
	    				</span>
	    				<span class="sn last_c">1658</span>
	    			</div>
	    		</div>
	    		
	    		<div class="news_box">
	    			<a href="http://maoyan.com/films/news/39866" target="_blank"><img src="img/news_img3.jpg"/></a>
	    			<p><a href="http://maoyan.com/films/news/39866" target="_blank" class="nba">被诬陷性侵郑爽，58岁导演承认恋上小30岁女星，双方父母都知晓</a></p>
	    			<div class="re">
	    				<span class="sn">
	    					猫眼电影
	    				</span>
	    				<span class="sn last_c">2365</span>
	    			</div>
	    		</div>
	    		
	    		<div class="news_box">
	    			<a href="http://maoyan.com/films/news/39865" target="_blank"><img src="img/news_img2.jpg"/></a>
	    			<p><a href="http://maoyan.com/films/news/39865" target="_blank" class="nba">网传陈乔恩受酒驾事件影响，剧方换角损失千万，新剧迟迟不能播</a></p>
	    			<div class="re">
	    				<span class="sn">
	    					猫眼娱乐
	    				</span>
	    				<span class="sn last_c">1243</span>
	    			</div>
	    		</div>
	    		
	    		<div class="news_box">
	    			<a href="http://maoyan.com/films/news/39864" target="_blank"><img src="img/news_img1.jpg"/></a>
	    			<p><a href="http://maoyan.com/films/news/39864" target="_blank" class="nba">《超人总动员2》角色海报曝光，超人大家庭新装登场酷炫升级</a></p>
	    			<div class="re">
	    				<span  class="sn">
	    					猫眼电影
	    				</span> 
	    				<span class="sn last_c">2654</span>
	    			</div>
	    		</div>
    		</div>
    		<div class="popula">
    		
    		</div>
    	</div>
    	
    	<div class="con con1 clearfix">
    		<div class="latest">
    			<a class="aa" href="" id="arrow3">全部<span></span></a>
    			<h4 class="yellow">最新资讯</h4>
    			<div class="img_box clearfix">
    				<div class="clearfix">
    					<a class="img_thumb th" href="http://maoyan.com/news/40137" target="_blank">
    						<img src="http://p1.meituan.net/movie/47a14ebde1973b9fd732bb631d4a1828581626.png@230w_172h_1e_1c"/>
    					</a>
    					<a class="img_thumb" href="http://maoyan.com/news/40137" target="_blank">
    						<img src="http://p1.meituan.net/movie/24674362c1207df0b4bebc259d5d2c17346497.png@120w_84h_1e_1c"/>
    					</a>
    					<a class="img_thumb" href="http://maoyan.com/news/40137" target="_blank">
    						<img src="http://p1.meituan.net/movie/41b859e89d824a3b415c6e2e1d61d57d518291.png@120w_84h_1e_1c"/>
    					</a>
    				</div>
    				
    				<div class="img_info">
    					<a href="http://maoyan.com/news/40137" target="_blank" class="img_ia">
             				     美少女队长关晓彤助梦少年球员,穿百褶裙漫画腿细长
                		</a>
                		<span class="sm">3545</span>
    				</div>
    			</div>
    			
    			
    			<div class="img_box clearfix">
    				<div class="clearfix">
    					<a class="img_thumb th" href="http://maoyan.com/news/39397" target="_blank">
    						<img src="http://p1.meituan.net/movie/494aec33c4037c2c231fb1d3aba4bfb3506133.png@230w_172h_1e_1c"/>
    					</a>
    					<a class="img_thumb" href="http://maoyan.com/news/39397" target="_blank">
    						<img src="http://p0.meituan.net/movie/4d965411420767d4d9c49f7e9b135f3e1097986.png@120w_84h_1e_1c"/>
    					</a>
    					<a class="img_thumb" href="http://maoyan.com/news/39397" target="_blank">
    						<img src="http://p1.meituan.net/movie/d0493cdff4a1a3ee02e1282f5d3bd8cc774535.png@120w_84h_1e_1c"/>
    					</a>
    				</div>
    				
    				<div class="img_info">
    					<a href="http://maoyan.com/news/39397" target="_blank" class="img_ia">
             				《东方华尔街》举办媒体看片会，强情节剧情烧脑
                		</a>
                		<span class="sm">1254</span>
    				</div>
    			</div>
    			
    			
    			
    			<div class="img_box clearfix">
    				<div class="clearfix">
    					<a class="img_thumb th" href="http://maoyan.com/news/38710" target="_blank">
    						<img src="http://p0.meituan.net/movie/2717576924e6a32055968f0703e0fbdc45707.jpg@230w_172h_1e_1c"/>
    					</a>
    					<a class="img_thumb" href="http://maoyan.com/news/38710" target="_blank">
    						<img src="http://p0.meituan.net/movie/05baf09fc512a852e3c4ad8682feead5122648.jpg@120w_84h_1e_1c"/>
    					</a>
    					<a class="img_thumb" href="http://maoyan.com/news/38710" target="_blank">
    						<img src="http://p1.meituan.net/movie/1b94d910484c5550384b927f981ee5f8164782.jpg@120w_84h_1e_1c"/>
    					</a>
    				</div>
    				
    				<div class="img_info">
    					<a href="http://maoyan.com/news/38710" target="_blank" class="img_ia">
             				马苏三现红毯气质逆转，气场全开化身“暗黑女王”
                		</a>
                		<span class="sm">4568</span>
    				</div>
    			</div>
    			
    			
    			<div class="img_box clearfix">
    				<div class="clearfix">
    					<a class="img_thumb th" href="http://maoyan.com/news/39278" target="_blank">
    						<img src="http://p1.meituan.net/movie/6e50f81a3396c23cdfdf234944c629db239882.jpg@230w_172h_1e_1c"/>
    					</a>
    					<a class="img_thumb" href="http://maoyan.com/news/39278" target="_blank">
    						<img src="http://p0.meituan.net/movie/51444064d92860e71cd6af29c1a2cde7238870.jpg@120w_84h_1e_1c"/>
    					</a>
    					<a class="img_thumb" href="http://maoyan.com/news/39278" target="_blank">
    						<img src="http://p1.meituan.net/movie/bed071fdbb0dda405026b13cb6fb7756335831.jpg@120w_84h_1e_1c"/>
    					</a>
    				</div>
    				
    				<div class="img_info">
    					<a href="http://maoyan.com/news/39278" target="_blank" class="img_ia">
             				新功能----首页右上角的日签功能，你喜欢吗？
                		</a>
                		<span class="sm">4568</span>
    				</div>
    			</div>
    			
    		</div>
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