<%@ page import="dao.Dao" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/8
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理系统</title>
</head>
<body>
<%
    String sceneryname="";
    String place="";
    String city="";
    String about="";
    String id=request.getParameter("id");
    Dao dao = new Dao();
    ServletContext context = request.getServletContext();
    context.setAttribute("id",id);
    ResultSet res = dao.select("select * from travelpath where id="+id);
    while(res.next()){
        sceneryname=res.getString("sceneryname");

        place=res.getString("place");
        city=res.getString("city");
        about = res.getString("about");
    }
%>
<form action="/tourist_project_war_exploded/Updatetravel">
    景点名称:<input type="text" name="sceneryname" value="<%=sceneryname%>"><br><br>

    景点地址:<input type="text" name="place" value="<%=place%>"><br><br>
    所在城市:<input type="text" name="city" value="<%=city%>"><br><br>
    景点信息:<textarea name="about" cols="30" rows="3"><%=about%></textarea><br><br>
    <input type="submit" value="更改">
</form>

</body>
</html>
