<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><meta charset="UTF-8">
		<title>猴眼电影-个人中心</title>
		<link rel="shortcut icon" href="img/logo.png"/>
		<link rel="stylesheet" href="css/reset.css">
		<link rel="stylesheet" href="css/percen_page.css" />
		<link rel="stylesheet" href="css/header.css" />
		<link rel="stylesheet" type="text/css" href="css/footer.css"/>
		<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="js/search.js"></script>
		<script type="text/javascript">
			$(function(){
				$(".submit").click(function(){
					var tt=$("#form2 :text");
					var name_v=$(tt[0]).val();
					var sign_v=$(tt[1]).val();
					var reg1=/[^\u4e00-\u9fa5\w_]/;
					var reg2=/^[\u4e00-\u9fa5\w_]{3,15}$/;
					if(name_v=="")
					{
						alert("昵称不能为空");
						return false;
					}
					else if(reg1.test(name_v))
					{
						alert("昵称仅可填写中英文、数字或下划线");
						return false;
					}
					else if(!reg2.test(name_v))
					{
						alert("昵称最少2个字，最多15个字");
						return false;
					}
					if(sign_v.length>20)
					{
						alert("个性签名最多20个字符");
						return false;
					}
				});
			});
			
			if("${upsu}"!="")
			{
				alert("${upsu}");
			}
			
			var day=[["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"],
				  ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"],
				  ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"]
				 ];
		function changeDay(num)
		{
			var se3=document.getElementById("se3");
			se3.length=1;
			var g0=/^[0]$/;
			var g1=/^[13578]$|^10$|^12$/;
			var g2=/^[469]$|^11$/;
			var g3=/^[2]$/;
			if(g0.test(num))
			{
				se3.options[0].selected=true;
			}
			else if(g1.test(num))
			{
				for(var i=0;i<day[0].length;i++)
				{
					se3.options[i+1]=new Option(day[0][i],day[0][i]);
				}
			}
			else if(g2.test(num))
			{
				for(var i=0;i<day[1].length;i++)
				{
					se3.options[i+1]=new Option(day[1][i],day[1][i]);
				}
			}
			else if(g3.test(num))
			{
				for(var i=0;i<day[2].length;i++)
				{
					se3.options[i+1]=new Option(day[2][i],day[2][i]);
				}
			}
		}
		
		var pro=[["互联网","IT","通信","电子","游戏"],
			  ["投资","股票基金","保险","银行"],
			  ["资讯","贸易","美容保健","家政服务","旅游","餐饮酒店","汽车","娱乐休闲"],
			  ["学生"]
				 ];
		function changePro(num)
		{
			var se5=document.getElementById("se5");
			se5.length=1;
			if(num!=0)
			{
				for(var i=0;i<pro[num-1].length;i++)
				{
					se5.options[i+1]=new Option(pro[num-1][i],pro[num-1][i]);
				}
			}
			else
			{
				se5.options[0].selected=true;
			}
		}
		</script>
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
    
    <div class="container">
    	<div class="content">
    		<div class="con_left">
    			<h2>个人中心</h2>
    			<a href="http://localhost:8080/Ticket/order.jsp">我的订单</a>
    			<a href="http://localhost:8080/Ticket/per_cen.jsp" class="active">基本信息</a>
    		</div>
    		<div class="con_right">
    			<div class="right_h">
    				基本信息
    			</div>
    			<div class="avatar_content">
    				<img <c:if test="${!empty aPath}">src="${aPath}"</c:if> src="img/captain.jpg" width="258" height="258"/>
    				<div class="avatar_change">
    					<input type="button" id="ac" value="更换头像" />
    					<input type="file" id="fileupload"/>
    				</div>
    				<div class="tips">
    					支持JPG,JPEG,PNG格式,且文件需小于1M
    				</div>
    			</div>
    			
    			<div class="info_content">
    				<form action="percen.do?id=${user.id}" method="post" id="form2">
    					<div class="info">
    						<p>昵称：</p>
    						<input type="text" name="name" id="uname" value="${user.name}" placeholder="3-15个数字，支持中英文、数字"/>
    					</div>
    						
    					<div class="info">
    						<p>性别：</p>
    						<input type="radio" name="gender" id="gender_m" value="男" <c:if test="${user.sex=='男'}">checked="checked"</c:if>/><label for="gender_m">男</label>
    						<input type="radio" name="gender" id="gender_f" value="女" <c:if test="${user.sex=='女'}">checked="checked"</c:if>/><label for="gender_f">女</label>
    					</div>
    					
    					<div class="info">
    						<p>生日：</p>
    						<select id="se1" name="se1">
    							<option value="--">--</option>
    							<option value="1985">1985</option>
    							<option value="1986">1986</option>
    							<option value="1987">1987</option>
    							<option value="1988">1988</option>
    							<option value="1989">1989</option>
    							<option value="1990">1990</option>
    							<option value="1991">1991</option>
    							<option value="1992">1992</option>
    							<option value="1993">1993</option>
    							<option value="1994">1994</option>
    							<option value="1995">1995</option>
    							<option value="1996">1996</option>
    							<option value="1997">1997</option>
    							<option value="1998">1998</option>
    							<option value="1999">1999</option>
    							<option value="2000">2000</option>
    							<option value="2001">2001</option>
    							<option value="2002">2002</option>
    							<option value="2003">2003</option>
    							<option value="2004">2004</option>
    							<option value="2005">2005</option>
    						</select>
    						<span>
    							年
    						</span>
    						<select id="se2" name="se2" onchange="changeDay(this.options.selectedIndex)">
    							<option value="--">--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
    							<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
    							<option value="9">9</option>
    							<option value="10">10</option>
    							<option value="11">11</option>
    							<option value="12">12</option>
    						</select>
    						<span>
    							月
    						</span>
    						<select id="se3" name="se3">
    							<option value="--">--</option>
    						</select>
    						<span>
    							日
    						</span>
    					</div>
    					
						<div class="info">
    						<p>生活状态：</p>
							<input type="radio" name="ls" id="ls1" value="单身" <c:if test="${user.marriage=='单身'}">checked="checked"</c:if>/><label for="">单身</label>
							<input type="radio" name="ls" id="ls2" value="热恋中" <c:if test="${user.marriage=='热恋中'}">checked="checked"</c:if>/><label for="">热恋中</label>
							<input type="radio" name="ls" id="ls3" value="已婚" <c:if test="${user.marriage=='已婚'}">checked="checked"</c:if>/><label for="">已婚</label>
							<input type="radio" name="ls" id="ls4" value="为人父母" <c:if test="${user.marriage=='为人父母'}">checked="checked"</c:if>/><label for="">为人父母</label>
						</div>
						
						<div class="info">
    						<p>从事行业：</p>
							<select id="se4" name="se4" onchange="changePro(this.options.selectedIndex)">
								<option value="--">--</option>
								<option value="信息技术">信息技术</option>
								<option value="金融保险">金融保险</option>
								<option value="商业服务">商业服务</option>
								<option value="学生">学生</option>
							</select>
							<select id="se5" name="se5">
								<option value="">--</option>
							</select>
						</div>
						
						<div>
    						<p>兴趣：</p>
							<input type="checkbox" name="xq" id="itt1" value="美食" /><label for="itt1">美食</label>
							<input type="checkbox" name="xq" id="itt2" value="动漫" /><label for="itt2">动漫</label>
							<input type="checkbox" name="xq" id="itt3" value="摄影" /><label for="itt3">摄影</label>
							<input type="checkbox" name="xq" id="itt4" value="电影" /><label for="itt4">电影</label>
							<input type="checkbox" name="xq" id="itt5" value="体育" /><label for="itt5">体育</label>
						</div>
						<div class="inf">
							<input type="checkbox" name="xq" id="itt6" value="宠物" /><label for="itt6">宠物</label>
							<input type="checkbox" name="xq" id="itt7" value="文学" /><label for="itt7">文学</label>
							<input type="checkbox" name="xq" id="itt8" value="公益" /><label for="itt8">公益</label>
							<input type="checkbox" name="xq" id="itt9" value="汽车" /><label for="itt9">汽车</label>
							<input type="checkbox" name="xq" id="itt10" value="时尚" /><label for="itt10">时尚</label>
						</div>
						<div class="inf">
							<input type="checkbox" name="xq" id="itt11" value="财经" /><label for="itt11">财经</label>
							<input type="checkbox" name="xq" id="itt12" value="音乐" /><label for="itt12">音乐</label>
							<input type="checkbox" name="xq" id="itt13" value="游戏" /><label for="itt13">游戏</label>
							<input type="checkbox" name="xq" id="itt14" value="科技" /><label for="itt14">科技</label>
							<input type="checkbox" name="xq" id="itt15" value="旅游" /><label for="itt15">旅游</label>
						</div>
						<div class="info">
    						<p>个性签名：</p>
							<input type="text" name="introduce" id="signature" value="${user.introduce}" placeholder="20个字符以内"/>
						</div>
    					<input type="submit" value="保存" class="submit"/>
    				</form>
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
