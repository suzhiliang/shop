<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天天购物</title>
<script src="../js/jquery-1.8.0.js"></script>
<script src="../js/index.js"></script>
</head>
<body>
	<div style="background:#f0f0f0; width:100%">
		<table width="100%" boder="0">
			<tr width="100%">
				<td width="72%">
					<p>欢迎光临天天购物 ,<strong><span id="msg"><%=session.getAttribute(request.getParameter("serial")) %></span></strong></p>
					<p><a href="javascript:redirectWithParam(5)">查看购物车</a></p>
				</td>
				<td  width="28%" align="right">
					<a href="../leave.do?serial="+${param.serial} >【点击退出】</a>
				</td>
			</tr>
		</table>
	</div>
    
    <div style=background:#ff5555>
    	<table border="0" width="100%">
        	<tr>
           	  	<td width="23%" align="center" bgcolor="#d00000"><font color="#FFFFFF">热门分类：</font></td>
                <td width="20%" align="center" id="first"><font color="#FFFFFF"><strong><a href="#" onClick="redirectWithParam()">衣服</a></strong></font></td>
                <td width="20%" align="center" id="second"><font color="#FFFFFF"><strong><a href="#" onClick="redirectWithParam()">户外运动</a></strong></font></td>
                <td width="20%" align="center" id="third"><font color="#FFFFFF"><strong><a href="#" onClick="redirectWithParam()">婴幼儿</a></strong></font></td>
                <td width="20%" align="center" id="forth"><font color="#FFFFFF"><strong><a href="#" onClick="redirectWithParam()">图书</a></strong></font></td>
            </tr>
        </table>
    </div>
	<div style="border:1px solid #000;padding:1px; height:400; width:105%;" >
   		<table broder="0">
            <tr bgcolor="#AAAFE0">
            	<td width="240" align="center">
                	 <div style="border:1px solid #000;padding:3px; height:300; width:80%" >
                          <table border="0" width="176">
                                    <tr>
                                        <td width="4" height="300"></td>
                                        <td width="162" height="300" bgcolor="#f0f0f0">
                                        <table >
                                                <tr>
                                                    <td id="one" width="225" height="26" align="center"><a href="javascript:redirectWithParam(0)">家具/电器</a></td>
                                                </tr>
                                                <tr>
                                                    <td id="two" width="225" height="26" align="center"><a href="javascript:redirectWithParam(1)">时尚/衣服</a></td>
                                                </tr>
                                                <tr>
                                                    <td id="three" width="225" height="26" align="center"><a href="javascript:redirectWithParam(2)">食品/零食/小吃</a></td>
                                                </tr>
                                                <tr>
                                                    <td id="four" width="225" height="26" align="center"><a href="javascript:redirectWithParam(3)">教育/图书</a></td>
                                                </tr>
                   
                                                 <tr>
                                                    <td id="six" width="225" height="26" align="center"><a href="javascript:redirectWithParam(4)">电子/手机/电脑</a></td>
                                                </tr>
                                          </table>
                                        </td>
                                    </tr>
                        </table>   
         			 </div>
                </td>
                <td width="835" align="right">
                	<img src="../images/up.jpg" width="800"/>
                    <img src="../images/down.jpg" width="800"/>
                </td>
                <td width="220" align="left">
                	<img src="../images/up_right.jpg" width="250" height="180" />
                    <img src="../images/up_left.jpg" width="250" height="200"/>
                </td>
            </tr> 
    	</table> 
    </div>

</body>
</html>