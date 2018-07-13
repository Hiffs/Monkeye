<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="img/logo.png"/>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/cinema1.css">
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<script>
    var movieMax = ${movies};
    function changeMovie(a){
        for(var i = 0; i < movieMax; i++){
            if(i == a){
                document.getElementById("m"+i).className = "movie active";
                document.getElementById("s"+i).className = "show-list active";
            }
            else {
                document.getElementById("m"+i).className = "movie";
                document.getElementById("s"+i).className = "show-list";
            }
        }
    }
    function changeDate(a,b){
        //a=show-list-id
        //b=show-date-name
        for(var i = 0; i < movieMax; i++){
            if(i == b){
                document.getElementById("s"+a+"d"+i).className = "date-item active";
                document.getElementById("s"+a+"plist"+i).className = "plist-container active";
            }
            else {
                document.getElementById("s"+a+"d"+i).className = "date-item";
                document.getElementById("s"+a+"plist"+i).className = "plist-container";
            }
        }
    }
</script>
<title>猴眼电影</title>
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

    <div class="banner cinema-banner">
        <div class="wrapper">
            <div class="cinema-left">
                <div class="avatar-shadow">
                    <img class="avatar" src="images/07.jpg" alt="">
                </div>
            </div>
            <div class="cinema-main clearfix">
                <div class="cinema-brief-container">
                    <h3 class="name text-ellipsis">${requestScope.cinema.name }</h3>
                    <div class="address text-ellipsis">地址：${requestScope.cinema.location }</div>
                    <div class="telphone">电话：${requestScope.cinema.tel }</div>
                </div> 
            </div>
        </div>
    </div>

    <div class="container">
        <div class="movie-list-container">
	        <div class="movie-list">
            	<c:forEach var="im" items="${requestScope.filmImg}" varStatus="st">
            		<div id="m${st.index }" <c:if test="${st.first}">class="movie active"</c:if> 
            			<c:if test="${!st.first}">class="movie"</c:if> onclick="changeMovie(${st.index })">
                    	<img src="${im }" alt="">
                	</div>
            	</c:forEach>
	        </div>
        </div>
        <c:forEach var="film" items="${requestScope.filmSet }" varStatus="status">
        <div id="s${status.index }" <c:if test="${status.index == 0}">class="show-list active"</c:if> 
        							<c:if test="${status.index != 0}">class="show-list"</c:if> >
            <div class="movie-info">
                <div>
                    <h3 class="movie-name">${film.name }</h3>
                </div>
                <div class="movie-desc">
                    <div>
                        <span class="key">时长：</span>
                        <span>${film.time }</span>
                    </div>
                    <div>
                        <span class="key">类型：</span>
                        <span>${filmType[status.index] }</span>
                    </div>
                    <div>
                        <span class="key">主演：</span>
                        <span>${filmActor[status.index] }</span>
                    </div>
                </div>
                <div class="show-date">
                    <span>观影时间：</span>
                    <span id="s${status.index }d0" class="date-item active" onclick="changeDate(${status.index },0)">
                    ${fn:substring(requestScope.scheduleList[0].showtime,5,6)}月
                    ${fn:substring(requestScope.scheduleList[0].showtime,7,9)}日
                    </span>
                </div>
                
                <div id="s${status.index }plist0" class="plist-container active">
                    <table class="plist">
                        <thead>
                            <tr>
                                <th>放映时间</th>
                                <th>语言版本</th>
                                <th>放映厅</th>
                                <th>售价（元）</th>
                                <th>选座购票</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="sche" items="${requestScope.scheduleList }" varStatus="s">
                			<c:if test="${sche.film_id == film.id }">
                				<tr <c:if test="${s.index % 2 == 1 }">class="even"</c:if> >
	                                <td>
	                                    <span class="begin-time">${fn:substring(sche.showtime, 10, 15) }</span>
	                                    <br>
	                                    <span class="end-time">  </span>
	                                </td>
	                                <td>
	                                    <span class="lang">${filmLan[status.index] }</span>
	                                </td>
	                                <td>
	                                    <span class="hall">${theater[s.index] }号厅</span>
	                                </td>
	                                <td>
	                                    <span class="sell-price">
	                                        <span>${sche.price }</span>
	                                    </span>
	                                </td>
	                                <td>
	                                    <a target="_blank" href="xseats.do?schedule=${sche.id }&time=${s.count}" class="buy-btn normal">选座购票</a>
	                                </td>
                            	</tr>
                			</c:if>
                			</c:forEach>
                			
                        </tbody>
                    </table>
                </div>
                
            </div>
        </div>
        </c:forEach>
        <!--  
        <div id="s0" class="show-list">
            <div class="movie-info">
                <div>
                    <h3 class="movie-name">电影名字</h3>
                </div>
                <div class="movie-desc">
                    <div>
                        <span class="key">时长：</span>
                        <span>100分钟</span>
                    </div>
                    <div>
                        <span class="key">类型：</span>
                        <span>动作（单个）</span>
                    </div>
                    <div>
                        <span class="key">主演：</span>
                        <span>1,2,3</span>
                    </div>
                </div>
                <div class="show-date">
                    <span>观影时间：</span>
                    <span id="s0d0" class="date-item active" onclick="changeDate(0,0)">今天x月x日</span>
                    <span id="s0d1" class="date-item" onclick="changeDate(0,1)">明天x月x日</span>
                </div>
                <div id="s0plist0" class="plist-container active">
                    <table class="plist">
                        <thead>
                            <tr>
                                <th>放映时间</th>
                                <th>语言版本</th>
                                <th>放映厅</th>
                                <th>售价（元）</th>
                                <th>选座购票</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <span class="begin-time">xx:xx</span>
                                    <br>
                                    <span class="end-time">xx:xx散场</span>
                                </td>
                                <td>
                                    <span class="lang">国语</span>
                                </td>
                                <td>
                                    <span class="hall">2号厅</span>
                                </td>
                                <td>
                                    <span class="sell-price">
                                        <span>23</span>
                                    </span>
                                </td>
                                <td>
                                    <a href="#" class="buy-btn normal">选座购票</a>
                                </td>
                            </tr>
                            <tr class="evne">
                                <td>
                                    <span class="begin-time">xx:xx</span>
                                    <br>
                                    <span class="end-time">xx:xx散场</span>
                                </td>
                                <td>
                                    <span class="lang">国语</span>
                                </td>
                                <td>
                                    <span class="hall">2号厅</span>
                                </td>
                                <td>
                                    <span class="sell-price">
                                        <span>23</span>
                                    </span>
                                </td>
                                <td>
                                    <a href="#" class="buy-btn normal">选座购票</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div id="s0plist1" class="plist-container">
                    <table class="plist">
                        <thead>
                            <tr>
                                <th>放映时间</th>
                                <th>语言版本</th>
                                <th>放映厅</th>
                                <th>售价（元）</th>
                                <th>选座购票</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <span class="begin-time">xx:xx</span>
                                    <br>
                                    <span class="end-time">xx:xx散场</span>
                                </td>
                                <td>
                                    <span class="lang">国语</span>
                                </td>
                                <td>
                                    <span class="hall">2号厅</span>
                                </td>
                                <td>
                                    <span class="sell-price">
                                        <span>23</span>
                                    </span>
                                </td>
                                <td>
                                    <a href="#" class="buy-btn normal">选座购票</a>
                                </td>
                            </tr>
                            <tr class="evne">
                                <td>
                                    <span class="begin-time">xx:xx</span>
                                    <br>
                                    <span class="end-time">xx:xx散场</span>
                                </td>
                                <td>
                                    <span class="lang">国语</span>
                                </td>
                                <td>
                                    <span class="hall">2号厅</span>
                                </td>
                                <td>
                                    <span class="sell-price">
                                        <span>23</span>
                                    </span>
                                </td>
                                <td>
                                    <a href="#" class="buy-btn normal">选座购票</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="s1" class="show-list active">
            <div class="movie-info">
                <div>
                    <h3 class="movie-name">电影名字2</h3>
                </div>
                <div class="movie-desc">
                    <div>
                        <span class="key">时长：</span>
                        <span>100分钟</span>
                    </div>
                    <div>
                        <span class="key">类型：</span>
                        <span>动作（单个）</span>
                    </div>
                    <div>
                        <span class="key">主演：</span>
                        <span>1,2,3</span>
                    </div>
                </div>
                <div class="show-date">
                    <span>观影时间：</span>
                    <span id="s1d0" class="date-item active" onclick="changeDate(1,0)">今天x月x日</span>
                    <span id="s1d1" class="date-item" onclick="changeDate(1,1)">明天x月x日</span>
                </div>
                <div id="s1plist0" class="plist-container active">
                    <table class="plist">
                        <thead>
                            <tr>
                                <th>放映时间1</th>
                                <th>语言版本</th>
                                <th>放映厅</th>
                                <th>售价（元）</th>
                                <th>选座购票</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <span class="begin-time">xx:xx</span>
                                    <br>
                                    <span class="end-time">xx:xx散场</span>
                                </td>
                                <td>
                                    <span class="lang">国语</span>
                                </td>
                                <td>
                                    <span class="hall">2号厅</span>
                                </td>
                                <td>
                                    <span class="sell-price">
                                        <span>23</span>
                                    </span>
                                </td>
                                <td>
                                    <a href="#" class="buy-btn normal">选座购票</a>
                                </td>
                            </tr>
                            <tr class="evne">
                                <td>
                                    <span class="begin-time">xx:xx</span>
                                    <br>
                                    <span class="end-time">xx:xx散场</span>
                                </td>
                                <td>
                                    <span class="lang">国语</span>
                                </td>
                                <td>
                                    <span class="hall">2号厅</span>
                                </td>
                                <td>
                                    <span class="sell-price">
                                        <span>23</span>
                                    </span>
                                </td>
                                <td>
                                    <a href="#" class="buy-btn normal">选座购票</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div id="s1plist1" class="plist-container">
                    <table class="plist">
                        <thead>
                            <tr>
                                <th>放映时间2</th>
                                <th>语言版本</th>
                                <th>放映厅</th>
                                <th>售价（元）</th>
                                <th>选座购票</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <span class="begin-time">xx:xx</span>
                                    <br>
                                    <span class="end-time">xx:xx散场</span>
                                </td>
                                <td>
                                    <span class="lang">国语</span>
                                </td>
                                <td>
                                    <span class="hall">2号厅</span>
                                </td>
                                <td>
                                    <span class="sell-price">
                                        <span>23</span>
                                    </span>
                                </td>
                                <td>
                                    <a href="#" class="buy-btn normal">选座购票</a>
                                </td>
                            </tr>
                            <tr class="evne">
                                <td>
                                    <span class="begin-time">xx:xx</span>
                                    <br>
                                    <span class="end-time">xx:xx散场</span>
                                </td>
                                <td>
                                    <span class="lang">国语</span>
                                </td>
                                <td>
                                    <span class="hall">2号厅</span>
                                </td>
                                <td>
                                    <span class="sell-price">
                                        <span>23</span>
                                    </span>
                                </td>
                                <td>
                                    <a href="#" class="buy-btn normal">选座购票</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    	-->
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