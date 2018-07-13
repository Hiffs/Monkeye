$(function(){
	$(".bt").click(function(){
		var username=$("#username").val();
		var password=$("#password").val();
		if(username=="" && password!="")
		{
			$("#msg").attr("class","msg");
			$("#msg").html("请输入账户名");
			return false;
		}
		else if(username!="" && password=="")
		{
			$("#msg").attr("class","msg");
			$("#msg").html("请输入密码");
			return false;
		}
		else if(username=="" && password=="")
		{
			$("#msg").attr("class","msg");
			$("#msg").html("请输入账户名和密码");
			return false;
		}
		else
		{
			return true;
		}
	});
	
	$(".username").focusin(function(){
		$(".username").css("background","url(img/named_label.ico)");
	});
	$(".username").focusout(function(){
		$(".username").css("background","url(img/name_label.ico)");
	});
	$(".password").focusin(function(){
		$(".password").css("background","url(img/pwdd_label.ico)");
	});
	$(".password").focusout(function(){
		$(".password").css("background","url(img/pwd_label.ico)");
	});
});