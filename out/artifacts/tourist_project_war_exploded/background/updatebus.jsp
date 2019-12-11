<%@ page import="dao.Dao" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/8
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理系统</title>
</head>
<body>
<%
    String busname="";
    String route="";
    String city="";
    String money="";
    String id=request.getParameter("id");
    Dao dao = new Dao();
    ServletContext context = request.getServletContext();
    context.setAttribute("id",id);
    ResultSet res = dao.select("select * from bus where id="+id);
    while(res.next()){
        busname=res.getString("busname");

        route=res.getString("route");
        city=res.getString("city");
        money = res.getString("money");
    }
%>
<form action="/tourist_project_war_exploded/Updatebus">
    公交车名:<input type="text" name="busname" value="<%=busname%>"><br><br>

    所在城市:<input type="text" name="city" value="<%=city%>"><br><br>
    公交费用:<input type="text" name="money" value="<%=money%>"><br><br>
    路线信息:<br><textarea name="route" cols="30" rows="6"><%=route%></textarea><br><br>
    <input type="submit" value="更改">
</form>

</body>
</html>

