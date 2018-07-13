<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="img/logo.png"/>
<link rel="stylesheet" href="css/jq22.css">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/xseats.css">
<link rel="stylesheet" type="text/css" href="css/register_page.css"/>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jquery.seat-charts.min.js"></script>
<script type="text/javascript">
	var price = ${requestScope.sche.price}; //数据库获取
	$(document).ready(function() {
        var $cart = $('#seats_chose'), //座位区
                $tickets_num = $('#tickets_num'), //票数
                $total_price = $('#total_price'); //票价总额
        var sc = $('#seat_area').seatCharts({
            map: [//座位结构图 a 代表座位; 下划线 "_" 代表过道
                'cccccccccc',
                'cccccccccc',
                '__________',
                'cccccccccc',
                'cccccccccc',
                'cccccccccc',
                'cccccccccc',
                'cccccccccc',
                '__________',
                'cccccccccc',
                'cccccccccc',
                'cccccccccc'
            ],
            naming: {//设置行列等信息
                top: false, //不显示顶部横坐标（行） 
                getLabel: function(character, row, column) { //返回座位信息 
                    return column;
                }
            },
            legend: {//定义图例
                node: $('#legend'),
                items: [
                    ['c', 'available', '可选座'],
                    ['c', 'unavailable', '已售出']
                ]
            },
            click: function() {
                if (this.status() == 'available') { //若为可选座状态，添加座位
                	if(sc.find('selected').length >= 6){
                		alert("每人限购6张");
                		return 'available';
                	} else {
	                    $('<li>' + (this.settings.row + 1) + '排' + this.settings.label + '座</li>')
	                            .attr('id', 'cart-item-' + this.settings.id)
	                            .data('seatId', this.settings.id)
	                            .appendTo($cart);
	                    $tickets_num.text(sc.find('selected').length + 1); //统计选票数量
	                    $total_price.text(getTotalPrice(sc) + price);//计算票价总金额
	                    $("#tot_price").val(getTotalPrice(sc) + price);
                        var sid = this.settings.row*10 + this.settings.label;
                        var v = $("#seatlist").val();
                        $("#seatlist").val(v+','+sid);
	                    return 'selected';
                	}
                } else if (this.status() == 'selected') { //若为选中状态
                    $tickets_num.text(sc.find('selected').length - 1);//更新票数量
                    $total_price.text(getTotalPrice(sc) - price);//更新票价总金额
                    $("#tot_price").val(getTotalPrice(sc) + price);
                    $('#cart-item-' + this.settings.id).remove();//删除已预订座位
                    return 'available';
                } else if (this.status() == 'unavailable') { //若为已售出状态
                    return 'unavailable';
                } else {
                    return this.style();
                }
            }
        });
        //设置已售出的座位
        var sold = document.getElementById("sold").value;
        var s = new Array();
        s = sold.split(',');
        sc.get(s).status('unavailable');
    });
    function getTotalPrice(sc) { //计算票价总额
        var total = 0;
        sc.find('selected').each(function() {
            total += price;
        });
        return total;
    }
    function dopost(){
    	var d = new Date();
    	var b = document.getElementById("booktime");
        var day = d.getDate();
        if(day < 10)
        	day = "0"+day;
        var month = d.getMonth();
        if(month < 10)
        	month = "0"+month;
        var year = d.getFullYear();
    	var date2 = "" + year + "-" + month + "-" + day;
    	b.value = date2+' '+d.toTimeString().substring(0,8);
    	document.getElementById("paypost").submit();
    }
    
</script>
<title>选座-猴眼电影</title>
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
            <div class="step">
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
    	<div class="main clearfix">
    		<div class="seat_area" id="seat_area">
    			<div class="front">屏幕</div>
    		</div>
    		<input id="sold" name="sold" style="display: none;" value="${requestScope.soldSeat }"/>
    		<div class="booking_area">
    			<p>电影:<span>${requestScope.filmName.name } </span></p>
    			<p>时间:<span>${requestScope.sche.showtime }</span></p>
    			<p>座位:</p>
    			<ul id="seats_chose" class="seats_chose"></ul>
    			<p>票数:<span id="tickets_num">0</span></p>
    			<p>总价:<b>￥<span id="total_price">0</span></b></p>
    			<form id="paypost" name="paypost" action="pay.do" method="post">
    				<input id="seatlist" name="seatlist" type="hidden" value="0"/>
    				<input id="userid" name="userid" type="hidden" value="${user.id}"/>
    				<input id="scheid" name="scheid" type="hidden" value="${requestScope.sche.id}"/>
    				<input id="tot_price" name="tot_price" type="hidden" value=""/>
    				<input id="booktime" name="booktime" type="hidden" value="0"/>
    				<input id="time1" name="time1" type="hidden" value="${time1 }"/>
    			</form>
    			<input type="button" class="btn" value="确认购买" onclick="dopost()">
    			<div id="legend"></div>
    		</div>
    	</div>
    </div>
    
    <div class="mask1">
        <div class="model_con" <c:if test="${empty user.id}">style="display: block;"</c:if> style="display: none;">
            <div class="model">
                <span class="icon"></span>
                <p class="ti">请先登录</p>
                <a href="login.jsp" class="ok_btn">确定</a>
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