$(function(){
	$(".submit").click(function(){
		var sear=$(".search").val();
		if(sear=="")
		{
			alert("请输入相关影视作品名称信息！");
			return false;
		}
	})
})
