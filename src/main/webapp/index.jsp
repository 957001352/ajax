<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#f1").blur(function(){
		var va = this;
		$.ajax({
			url:"User_exits",
			data:{name:va.value},
			success:function(data){
				alert(data);
				if(data == "已存在"){
					$("#ss").html("该用户名不可用");
					$("#btn").prop("disabled",true);
				}else{
					$("#ss").html("该用户名可用");
					$("#btn").prop("disabled",false);
					}
				}
			});

		});
});

</script>
</head>
<body>
	<span id="ss"></span>
	<s:form action="User_save">
		<s:textfield name="name" id="f1" label="姓名" />
		<s:textfield name="birthday" label="生日" />
		<s:textfield name="money" label="存款" />
		<s:submit id="btn" value="注册" />
	</s:form>	
</body>
</html>