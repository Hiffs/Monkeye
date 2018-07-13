$(function(){
				var isFlag;
				
				$(".form_tips1").focusin(function(){
					$(this).css("border-color","#666");
				});
				$(".form_tips1").focusout(function(){
					$(this).css("border-color","#aaa");
				});
				
				var ipt=$("input");
				for(var i=0;i<ipt.length-1;i++)
				{
					ipt[i].num=i;
					var message1;
					$(ipt[i]).focus(function(){
						var vl=$(this).val();
						var index=this.num;
						if(index==0)
						{
							message1="支持中文、英文和数字的组合，3-20个字符";
						}
						else if(index==1){
							message1="建议使用两种字母、数字和符号两种及以上的组合，6-20个字符";
						}
						else if(index==2){
							message1="请再次输入密码";
						}
						else if(index==3){
							message1="请输入手机号，可用于登录";
						}
						if(vl=="")
						{
							$(".msg"+index).html(message1);
							$(".msg"+index).css({"color":"#bbb","visibility":"visible","background":"url(img/infor.ico) no-repeat left center"});
						}
					})
					
					$(ipt[i]).blur(function(){
						var index=this.num;
						$(".msg"+index).css("visibility","hidden");
						$(".gou"+index).css("visibility","hidden");
						var vl=$(this).val();
						if(vl!="")
						{
							if(index==0)
							{
								var reg=/^[\u4e00-\u9fa5\w_]{3,15}$/;
								if(!reg.test(vl))
								{
									isFlag=true;
									$(".msg"+index).html("只支持汉字、中文、英文及下划线，3-20个字符");
									$(".msg"+index).css({"color":"#f91","visibility":"visible","background":"url(img/gantan.ico) no-repeat left center"});
								}
								else
								{
									isFlag=false;
									$(".gou"+index).css("visibility","visible");
								}
							}
							else if(index==1)
							{
								if(vl.length<6 || vl.length>20)
								{
									isFlag=true;
									$(".msg"+index).html("长度只能在6-20个字符之间");
									$(".msg"+index).css({"color":"#f91","visibility":"visible","background":"url(img/gantan.ico) no-repeat left center"});
								}
								else
								{
									isFlag=false;
									$(".gou"+index).css("visibility","visible");
								}
							}
							else if(index==2)
							{
								var pwd1=$(ipt[1]).val();
								if(vl!=pwd1)
								{
									isFlag=true;
									$(".msg"+index).html("两次输入密码不一致");
									$(".msg"+index).css({"color":"#f91","visibility":"visible","background":"url(img/gantan.ico) no-repeat left center"});
								}
								else
								{
									isFlag=false;
									$(".gou"+index).css("visibility","visible");
								}
							}
							else if(index==3)
							{
								var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;  
          						if (!myreg.test(vl)) 
          						{
          							isFlag=true;
            					  	$(".msg"+index).html("手机号码格式不正确");
									$(".msg"+index).css({"color":"#f91","visibility":"visible","background":"url(img/gantan.ico) no-repeat left center"});
         						} 
         						else {
									isFlag=false;
             						$(".gou"+index).css("visibility","visible");
         						}  
							}
						}
					})
				}
				
				$(".rgt_btn").click(function(){
				for(var i=0;i<ipt.length-1;i++)
					{
						var vle=$(ipt[i]).val();
						if(vle=="")
						{
							isFlag=true;
						}
					}
					if(isFlag)
					return false;
				});
			});