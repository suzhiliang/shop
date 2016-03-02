<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    <title>天天购物</title>
    <link rel="shortcut ico" href="http://localhost:8080/Shop/images/title.ico" type="image/x-ico" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache"></meta>
    <script src="../js/jquery-1.8.0.js"></script>
	<script src="../js/login.js"></script>
  </head>
  
<body style=background:#f5f5f5;>
<center><h1><font color="#000">天天购物,天天开心</font></h1></center>
   <table width="100%" style="height:85%;background-repeat:no-repeat;background-position:center;">
	 <tr height="10">
	 	<td></td> 
	 </tr>
	 <tr height="10">
		<td></td> 
	 </tr>
 	 <tr height="100">
 	 <td width="250"></td><td></td>
 	 <td width="200"><img src="../images/index.jpg"/></td>
 		<td>
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
					<td><font size="3px" color="#000" ><strong>验证码:</strong></font></td>
					<td><input name="safecode" id="safecode" type="text" /></td>
					<td><img src="../safecode.do" id="image" /></td>
					<td><a href="" id="flush">看不清？点击刷新</a></td>
				</tr>
				<tr>
					<td><font size="1px" color="#000" >没有注册？<a href="../jsp/regedit.jsp">点击这里！</a></font></td>	
					<td><input type="button" value="一键登录" id="click"/></td>
				</tr>
				</form>
			</table>
			<div align="center"><span id="fail"></span></div>
		</td>
 </tr>
 </table>
</body>
</html>
