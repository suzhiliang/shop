<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>sLogin.html</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script src="../js/jquery-1.8.0.js"></script>
	<script src="../js/reg.js"></script>
  </head>
  
<body background="../images/logobg.jpg">
<center><h1><font color="#fff">购物车</font></h1></center>
   <table width="100%" style="height:100%;background-repeat:no-repeat;background-position:center;">
	 <tr height="20">
	 	<td></td> 
	 </tr>
	 <tr height="20">
		<td></td> 
	 </tr>
 	 <tr height="200">
 		<td><div align="center">
<table align="center">
				<form method="post" action="" >
				<tr>
					<td><font size="3px" color="#000"><strong>用户名:</strong></font></td>
					<td><input name="username" id="username"/></td>
					<td><span id="msg"></span></td>
				</tr>
				<tr>
					<td><font size="3px" color="#000"><strong>密码:</strong></font></td>
					<td><input name="password" id="password" type="password" /></td>
					<td></td>
				</tr>
				<tr>
					<td><font size="3px" color="#000"><strong>确认密码:</strong></font></td>
					<td><input name="password" id="repassword" type="password" /></td>
					<td></td>
				</tr>
				<tr>
					<td><font size="3px" color="#000"><strong>邮箱:</strong></font></td>
					<td><input name="password" id="email" type="text" /></td>
					<td></td>
				</tr>
				<tr>
					<td><font size="3px" color="#000" ><strong>验证码:</strong></font></td>
					<td><input name="safecode" id="safecode" type="text" /></td>
					<td><img src="../safecode.do" id="image" /></td>
					<td><a href="" id="flush">看不清？点击刷新</a></td>
				</tr>
				<tr>	
					<td><input type="button" value="一键注册" id="click"/></td>
				</tr>
				</form>
			</table>
			</div>
			<div align="center"><span id="msg"></span></div>
		</td>
 </tr>
 </table>
</body>
</html>
