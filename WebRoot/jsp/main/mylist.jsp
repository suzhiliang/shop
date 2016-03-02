<%@ page language="java" import="java.util.*,org.example.shop.pojo.Goods" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>天天————教育/图书类</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<script src="../../js/jquery-1.8.0.js"></script>
	<script src="../../js/booklist.js" ></script>
	<c:set var="iterator" value="${param.serial}+'check'" scope="session"/>
  </head>
  
  <body>
   		<div style="background:#f0f0f0; width:100%">
            <table width="100%" boder="0">
                <tr width="100%">
	            
                    <td width="40%">
						<img src="../../images/logo.gif"/>
						当前用户,<strong><span id="msg"><%=session.getAttribute(request.getParameter("serial")) %></span></strong>
                    </td>
                    <td  width="28%" height="10%" align="left">
						<h2>已购买的商品明细</h2>
					</td>
					<td  width="28%" height="10%" align="right">
						
						<a href="../../leave.do?serial="+${param.serial} >【点击退出】</a>
					</td>
                </tr>
            </table>
		</div>
        <div style=background:#ff5555>
            <table border="0" width="100%">
                <tr>
                    <td width="23%" align="center" bgcolor="#d00000"><font color="#FFFFFF">热门分类：</font></td>
                    <td width="20%" align="center" id="first"><font color="#FFFFFF"><strong><a href="">衣服</a></strong></font></td>
                    <td width="20%" align="center" id="second"><font color="#FFFFFF"><strong><a href="">户外运动</a></strong></font></td>
                    <td width="20%" align="center" id="third"><font color="#FFFFFF"><strong><a href="">婴幼儿</a></strong></font></td>
                    <td width="20%" align="center" id="forth"><font color="#FFFFFF"><strong><a href="">图书</a></strong></font></td>
                </tr>
            </table>
   	    </div>
        
        <table border="0" width="80%">
        	<c:forEach items='<%=session.getAttribute(request.getParameter("serial")+"check") %>' var="item"> 
        	<tr >
            	<td width="34%"><img src=${item.picture} width="288" height="301"/></td>
                <td width="66%">
                	<table width="300" height="303" border="0">
                   		<tr>
                            <td width="142" height="38">
                                <div style=" padding:0"><font color="#0000FF">${item.name}</font></div>
                            </td>
               	      	</tr>
                	 	<tr>
               		  		<td height="29">
                            	<font size="+1" color="#FF9900"><strong>￥${item.price}</strong></font>
                        	</td>
                     	</tr>
                        <tr>
                            <td height="115"><font size="-1">产品介绍：</font><font size="+1">${item.introduce }</font></td>
                        </tr>
                        <tr>
                            <td height="111">
                                    <font size="-1">厂家：</font><font size="+1">${item.maker}</font>
                            </td>
                        </tr>
                        <tr>
                            <td>
                              	  <form action="../../delete.do" method="post">
                               			<input type="hidden" name="goodsserial" value= '${item.serial}'/>
                               			<input type="hidden" name="userserial" value='${param.serial }'/>
                                  		<input type="submit" value="取消购买" class="delete"/>
                                  </form>
                            </td>
                        </tr>
                    </table>
              	</td>
            </tr>
            </c:forEach>
        </table>
  </body>
</html>
