<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>猴眼电影-让海量电影更贴近你</title>
    <meta charset="utf-8"/>
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link rel="shortcut icon" href="img/logo.png"/>
	<link rel="stylesheet" href="css/reset.css"/>
	<link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" href="css/footer.css"/>
    <link rel="stylesheet" href="css/header.css"/>
    <link rel="stylesheet" href="css/picslider.css"/>
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/unslider.min.js"></script>
    <script type="text/javascript" src="js/search.js"></script>
    <script>
        $(document).ready(function (e) {
            var unslider04 = $("#b04").unslider({
                dots: true
            }),
            data04 = unslider04.data('unslider');

            $('.unslider-arrow04').click(function(){
                var fn = this.className.split(' ')[1];
                data04[fn]();
            });
        });
    </script>
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
        <div class="slider">
            <div class="slick-list" id="b04">
                <ul>
                    <li><a href="#"><img src="images/zhou1.jpg" alt="" width="100%" height="440" /></a></li>
                    <li><a href="http://maoyan.com/films/news/38723" target="_blank"><img src="images/dou.jpg" alt="" width="100%" height="440" /></a></li>
                    <li><a href="http://maoyan.com/films/news/39605" target="_blank"><img src="images/zhou2.jpg" alt="" width="100%" height="440" /></a></li>
                </ul>
                <a href="javascript:void(0);" class="unslider-arrow04 prev">
                    <img class="arrow" id="al" src="images/arrowl.png" alt="prev" width="20" height="35">
                </a>
                <a href="javascript:void(0);" class="unslider-arrow04 next">
                    <img class="arrow" id="ar" src="images/arrowr.png" alt="next" width="20" height="37">
                </a>
            </div>
        </div>
    </div>
    
    
    <div class="container">
    		<div class="content">
						  <div class="main">
						  	<div class="movie_grif">
						  		
						  		<div class="panel">
						  			<div class="panel_header">
						  				<span class="panel_more">
						  					<a href="" class="textcolor_red">全部<span class="sp sp1"></span></a>
						  				</span>
						  				<span class="panel_title">
						  					<span class="textcolor_red">正在热映(49部)</span>
						  				</span>
						  			</div>
										<div class="panel_content">
											<dl class="movie_list">
											  <c:forEach var="f" items="${films}">
												<dd>
												<div class="moive_item">
														<a href="film1.do?id=${f.id}" target="_blank">
															<div class="movie_poster">
																<img src="${iPath[f.id]}"/>
																<div class="movie_info">
																	<div class="movie_title" title="${f.name}">
																		${f.name}
																	</div>
																</div>
															</div>
														</a>
														<div class="movie_details">
															<a href="film1.do?id=1" target="_blank" class="a_buy">购票</a>
														</div>
													</div>
												</dd>
											  </c:forEach>
											  
											  <dd>
												<div class="moive_item">
														<a href="film1.do?id=1" target="_blank">
															<div class="movie_poster">
																<img src="http://p1.meituan.net/movie/899b0a8c57fc44e93e83b9f0dae649f1767221.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="厕所英雄">
																		厕所英雄
																	</div>
																</div>
															</div>
														</a>
														<div class="movie_details">
															<a href="film1.do?id=1" target="_blank" class="a_buy">购票</a>
														</div>
													</div>
												</dd>
											</dl>
										</div>
						  		</div>
						  		
						  		<div class="panel">
						  			<div class="panel_header">
						  				<span class="panel_more">
						  					<a href="" class="textcolor_blue">全部<span class="sp sp2"></span></a>
						  				</span>
						  				<span class="panel_title">
						  					<span class="textcolor_blue">即将上映(186部)</span>
						  				</span>
						  			</div>
										<div class="panel_content">
											<dl class="movie_list">
												<dd>
												<div class="moive_item">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p1.meituan.net/movie/173aa3cc5c729a6020b32014a60b82a75672295.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="暗夜良人">
																		暗夜良人
																	</div>
																</div>
															</div>
														</a>
														<div class="movie_details movie_wish">
															<span class=stonefont>
																865
															</span>人想看
															<a href="" class="yushou">预售</a>
														</div>
													</div>
													<div class="ondate">6月6日上映</div>
												</dd>
													
													<dd>
												<div class="moive_item">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p0.meituan.net/movie/200526fd0facc141caeef984314f7ef8328722.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="深海越狱">
																		深海越狱
																	</div>
																</div>
															</div>
														</a>
														<div class="movie_details movie_wish">
															<span class=stonefont>
																865
															</span>人想看
															<a href="" class="yushou">预售</a>
														</div>
													</div>
													<div class="ondate">6月6日上映</div>
												</dd>
													
													<dd>
												<div class="moive_item">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p1.meituan.net/movie/63aafb487fb6645e2a3521fce6922de5906570.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="幸福马上来">
																		幸福马上来
																	</div>
																</div>
															</div>
														</a>
														<div class="movie_details movie_wish">
															<span class=stonefont>
																865
															</span>人想看
															<a href="" class="yushou">预售</a>
														</div>
													</div>
													<div class="ondate">6月6日上映</div>
												</dd>
													
													<dd>
												<div class="moive_item">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p0.meituan.net/movie/88ed4e34107a963df120d562d201d43077447.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="一纸婚约">
																		一纸婚约
																	</div>
																</div>
															</div>
														</a>
														<div class="movie_details movie_wish">
															<span class=stonefont>
																865
															</span>人想看
															<a href="" class="yushou">预售</a>
														</div>
													</div>
													<div class="ondate">6月6日上映</div>
												</dd>
													
													<dd>
												<div class="moive_item">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p1.meituan.net/movie/899b0a8c57fc44e93e83b9f0dae649f1767221.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="厕所英雄">
																		厕所英雄
																	</div>
																</div>
															</div>
														</a>
														<div class="movie_details movie_wish">
															<span class=stonefont>
																865
															</span>人想看
															<a href="" class="yushou">预售</a>
														</div>
													</div>
													<div class="ondate">6月6日上映</div>
												</dd>
													
													<dd>
												<div class="moive_item">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p0.meituan.net/movie/6f2b1b83b512d8ec417efdf09d34faa3316513.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="恐怖浴室">
																		恐怖浴室
																	</div>
																</div>
															</div>
														</a>
														<div class="movie_details movie_wish">
															<span class=stonefont>
																865
															</span>人想看
															<a href="" class="yushou">预售</a>
														</div>
													</div>
													<div class="ondate">6月6日上映</div>
												</dd>
													
													<dd>
												<div class="moive_item">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p0.meituan.net/movie/7e1f6616b82f532e167a730452c90b9d653258.png@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="盯上小偷的贼">
																		盯上小偷的贼
																	</div>
																</div>s
															</div>
														</a>
														<div class="movie_details movie_wish">
															<span class=stonefont>
																865
															</span>人想看
															<a href="" class="yushou">预售</a>
														</div>
													</div>
													<div class="ondate">6月6日上映</div>
												</dd>
												
												<dd>
												<div class="moive_item">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p0.meituan.net/movie/bcd22e926b49c4cd99949e169f1bcdd0853574.png@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="一个人的江湖">
																		一个人的江湖
																	</div>
																</div>
															</div>
														</a>
														<div class="movie_details movie_wish">
															<span class=stonefont>
																865
															</span>人想看
															<a href="" class="yushou">预售</a>
														</div>
													</div>
													<div class="ondate">6月6日上映</div>
												</dd>
												
											</dl>
										</div>
						  		</div>
						  		
									
									<!--第三个panel---------------------------------------------------------------------------------->
									<div class="panel">
						  			<div class="panel_header">
						  				<span class="panel_more">
						  					<a href="" class="textcolor_red">全部<span class="sp sp1"></span></a>
						  				</span>
						  				<span class="panel_title">
						  					<span class="textcolor_red">热门电影</span>
						  				</span>
						  			</div>
										<div class="panel_content">
											<dl class="movie_list">
												<dd id="dd">
												<div class="qie">
														<a href="" target="_blank">
															<div class="qie_poster">
																<img src="http://p1.meituan.net/movie/__24219255__5321011.jpg@350w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="窃听风云3">
																		窃听风云3
																	</div>
																</div>
															</div>
														</a>
													</div>
												</dd>
													
													
													<dd>
												<div class="moive_item2">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p1.meituan.net/movie/3d17aa5ee07f5d66239d8393bcb8fe5196556.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="侏罗纪世界2">
																		侏罗纪世界2
																	</div>
																</div>
															</div>
														</a>
													</div>
												</dd>
													
													<dd>
												<div class="moive_item2">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p0.meituan.net/movie/__36827568__2509248.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="为奴十二载">
																		为奴十二载
																	</div>
																</div>
															</div>
														</a>
													</div>
												</dd>
													
													<dd>
												<div class="moive_item2">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p1.meituan.net/movie/__35965556__6833914.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="六颗子弹">
																		六颗子弹
																	</div>
																</div>
															</div>
														</a>
													</div>
												</dd>
													
													<dd>
												<div class="moive_item">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p0.meituan.net/movie/__11691262__6664179.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="致命黑兰">
																		致命黑兰
																	</div>
																</div>
															</div>
														</a>
													</div>
												</dd>
													
													<dd>
												<div class="moive_item2">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p0.meituan.net/movie/__6675383__5363330.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="金太狼的幸福生活">
																		金太狼的幸福生活
																	</div>
																</div>
															</div>
														</a>
													</div>
												</dd>
												
												<dd>
												<div class="moive_item2">
														<a href="" target="_blank">
															<div class="movie_poster">
																<img src="http://p1.meituan.net/movie/cb72d008657821226e4d44ff08f900bb299751.jpg@160w_220h_1e_1c"/>
																<div class="movie_info">
																	<div class="movie_title" title="魔镜">
																		魔镜
																	</div>
																</div>
															</div>
														</a>
													</div>
												</dd>
												
											</dl>
										</div>
						  		</div>


						  	</div>
						  </div>  			
    				</div>
   				</div>
    <!---content结束------------------------------------------------------------------------>
    
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

