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
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/xseats.css">
<link rel="stylesheet" href="css/pay.css">
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	var minute = "13";
	var second = 59;
	setInterval(function() {
		second--;
		if(second == 00 && minute == 00) {
			minute = 14;
			second = 00;
		}; //当分钟和秒钟都为00时，重新给值
		if(second == 00) {
			second = 59;
			minute--;
			if(minute < 10) minute = "0" + minute;
		}; //当秒钟为00时，秒数重新给值
		if(second < 10) second = "0" + second;
		$(".minute").text(minute);
		$(".second").text(second);
	}, 1000);

	function check()
	{
		document.getElementById("payForm").submit();
	}

</script>
<title>确认支付-猴眼电影</title>
</head>
<body>
	<div class="header">
        <div class="header-inner">
            <a class="logo" href="index.do" title="猴眼电影-让海量电影更贴近你">                    <!-- 此处做了修改，当点击时，回到首页 -->
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
            <form class="search-form" action="" method="POST">
                <input class="search" type="text" placeholder="找电影" maxlength="32" name="search"/>
                <input class="submit" type="submit" value=""/>
            </form>
        </div>
    </div>
    <div class="header-placeholder"></div>
    
    <div class="container">
		<div class="order-progress-bar">
			<div class="step first done">
				<span class="step-num">1</span>
				<div class="bar"></div>
				<span class="step-text">选择影片场次</span>
			</div>
			<div class="step done">
				<span class="step-num">2</span>
				<div class="bar"></div>
				<span class="step-text">选择座位</span>
			</div>
			<div class="step done">
				<span class="step-num">3</span>
				<div class="bar"></div>
				<span class="step-text">14分钟内付款</span>
			</div>
			<div class="step last">
				<span class="step-num">4</span>
				<div class="bar"></div>
				<span class="step-text">电影院取票</span>
			</div>
		</div>
		
		<div class="count-down-wrapper">
			<div class="count-down">
				<p class="time-left">
					请在<span class="minute">14</span>分钟<span class="second">00</span> 秒内完成支付
				</p>
				<p class="tip">超时订单会自动取消，如遇支付问题，请致电猴眼客服：1010-5335</p>
			</div>
		</div>

		<p class="warning">
			请仔细核对场次信息，出票后将<span class="attention">无法退票和改签</span>
		</p>
		<table class="order-table">
			<thead>
				<tr>
					<th>影片</th>
					<th>时间</th>
					<th>影院</th>
					<th>座位</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="movie-name">《${filmName.name }》</td>
					<td class="showtime">${showtime[0] }月${showtime[1] }日 ${showtime[2] }:${showtime[3]}</td>
					<td class="cinema-name">${cinemaName.name }</td>
					<td>
						<span class="hall">${theater }号厅</span>
						<c:forEach begin="0" end="${fn:length(seatList) - 1}" step="1" var="i">
							<div class="seats">
								<div>
									<span>
										<i>${fn:substring(seatList[i],0,1) }</i>排<i>
										${fn:substring(seatList[i],2,-1) }</i>座
									</span>
								</div>
							</div>
						</c:forEach>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="right">
			<div class="price-wrapper">
				<span>实际支付：</span>
				<span class="price">${price }</span>
			</div>
			<div class="pay-btn" onclick="check()">确认支付</div>
		</div>
		<form id="payForm" name="payForm" action="configPay.do" method="post">
			<input type="hidden" name="userid" value="${user.id }">
			<input type="hidden" name="seatid" value="${seatList }">
			<input type="hidden" name="scheduleid" value="${sche.id }">
			<input type="hidden" name="filmid" value="${flimName.id }">
			<input type="hidden" name="hallid" value="${sche.theater_id }">
			<input type="hidden" name="cinemaid" value="${cinemaName.id }">
			<input type="hidden" name="booklist" value="${booklist }">
		</form>
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