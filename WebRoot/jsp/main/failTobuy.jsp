<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="../../js/jquery-1.8.0.js"></script>
	<script type="text/javascript">
		function getParam(){
			var url = location.href;  
			var paraString = url.substring(url.indexOf("?")+1,url.length);  
			var param = paraString.substring(paraString.indexOf("=")+1, url.length)
			return param
		}
		$(function(){
			alert("请不要购买重复的商品。")
			window.location.href = "booklist.jsp?serial="+getParam()
		})
	</script>
</head>
<body>
	
</body>
</html>