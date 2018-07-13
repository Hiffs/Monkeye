<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>猴眼-欢迎登录</title>
		<link rel="shortcut icon" href="img/logo.png"/>
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" href="css/login_page.css" />
		<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="js/login_page.js"></script>
	</head>
	<body>
		<div class="header">
			<div id="h_box1" class="w">
				<a href="index.do" title="猴眼电影-让海量电影更贴近你"><img src="img/logo1.png"/></a>
				<h2>欢迎登录</h2>
			</div>
		</div>
		
		<div class="index w">
			<img src="img/re_banner.png"/>
			<div class="i_box1">
				<div class="ii1">
					<span class="icon_tips1"></span>
					<p>猴眼不会以任何理由要求您转账汇款，谨防诈骗。</p>
				</div>

				<div class="ii2 clearfix">
						<p>账户登录</p>
				</div>
				
				<div id="msg" <c:if test="${!empty ms}">class="msg"</c:if>>
         			${ms}
				</div>
				
				<div class="ii3">
					<form action="login.fo" method="post">
						<div class="username">
							<input type="text" name="username" id="username" value="${param.username}" placeholder="账户名/手机号" />
						</div>

						<div class="password">
							<input type="password" name="password" id="password" placeholder="密码" /><br />
						</div>
						<div class="fg_pwd">
							<a href="">忘记密码</a>
						</div>
						<div class="lo">
							<input class="bt" type="submit" value="登&nbsp&nbsp&nbsp&nbsp录"/>
						</div>
					</form>
				</div>
				<div class="ii4">
					<div>
						<a id="rgt" href="register.jsp">立即注册</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="footer w">
				<div class="copy">
					&copy;2014-2018 <a href="">猴眼网</a>
					<a href="http://www.miibeian.gov.cn" target="_blank">京ICP证070791号 </a>
					<span id="">
						京公网安备11010502025545号
					</span>
				</div>		
		</div>
	</body>
</html>
