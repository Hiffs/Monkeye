<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>猴眼-个人注册</title>
		<link rel="shortcut icon" href="img/logo.png"/>
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/register_page.css"/>
		<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="js/register_page.js"></script>
	</head>
	<body>
		<div class="header w">
			<div class="h_box2 clearfix">已有账号？<a href="login.jsp">请登录＞</a></div>
			<div id="h_box1" class="w">
				<a href="index.do" title="猴眼电影-让海量电影更贴近你"><img src="img/logo1.png"/></a>
				<h2>欢迎注册</h2>
			</div>
			
		</div>
		
		<div class="index w">
			<form action="register.fo" method="post" autocomplete="off">
				<div class="form_tips1">
					<div class="gou gou0"></div>
					<label for="form_feild1">用　户　名</label>
					<input type="text" name="form_feild1" id="form_feild1" class="field" value="${param.form_feild1}" placeholder="您的账户名和登录名"/>
				</div>
				<div class="msg msg0" <c:if test="${!empty rep1}">id="ms"</c:if>>
					<c:if test="${!empty rep1}">${rep1}</c:if>
				</div>
				
				<div class="form_tips1">
					<div class="gou gou1"></div>
					<label for="form_feild2">设 置 密 码</label>
					<input type="password" name="form_feild2" id="form_feild2" class="field" placeholder="建议使用两种或以上的字符组合" />

				</div>
				<div class="msg msg1"></div>
				
				<div class="form_tips1">
					<div class="gou gou2"></div>
					<label for="form_feild3">确 认 密 码</label>
					<input type="password" name="form_feild3" id="form_feild3" class="field" placeholder="请再次输入密码"/>
				</div>
				<div class="msg msg2"></div>
				
				<div class="form_tips1">
					<div class="gou gou3"></div>
					<label for="form_feild4">手 机 号 码</label>
					<input type="text" name="form_feild4" id="form_feild4" class="field" value="${param.form_feild4}" placeholder="请输入手机号"/>
				</div>
				<div class="msg msg3" <c:if test="${!empty rep2}">id="ms"</c:if>>
					<c:if test="${!empty rep2}">${rep2}</c:if>
				</div>
				
				<input type="submit" value="立即注册" class="rgt_btn"/>
			</form>
		</div>
		
		<div class="mask1">
    		<div class="model_con" <c:if test="${!empty losu}">style="display:block;"</c:if> style="display:none;">
    			<div class="model">
    				<span class="icon"></span>
    				<p class="ti"><c:if test="${!empty losu}">${losu}</c:if></p>
    				<a href="login.jsp" class="ok_btn">确定</a>
    				<a href="index.do" class="cl_btn">去主页</a>
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
