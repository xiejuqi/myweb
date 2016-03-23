<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>  
<%@ page language="java" import="java.text.*" %>         
<%@ taglib uri="http://www.opensymphony.com/oscache" prefix="cache" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Index页面
	</h1>
	<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); %>  
    <div>  
        <cache:cache key="cacheDate" scope="session" time="15">   
            <h2>使用缓存，让时间在15秒内不进行更新</h2>  
            <div><%  
                String cacheTime = sdf.format(new Date());  
                out.println(cacheTime);               
                %>  
            </div>  
        </cache:cache>  
    </div>  
    <hr>  
    <div>  
        <h2>不使用缓存</h2>  
        <div><%  
            String commonTime = sdf.format(new Date());  
            out.println(commonTime);  
         %></div>  
    </div>
   <%--  <hr>  
    <div>  
        <h2>不使用缓存</h2>  
        <div><%
        	  Page<User> userList = request.getAttribute("newsList");
           	  if(null != userList.getRecords() && userList.getRecords().size() > 0){
           		  for(User u : userList){
           			out.println("ID:"u.getUserId()+"Name:"+u.getUserName());  
           		  }
           	  }else{
           		out.println("userList为空！");
           	  }
         	  %>
         </div>  
    </div> --%>
</body>
</html>