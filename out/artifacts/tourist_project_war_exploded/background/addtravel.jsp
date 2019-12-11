<%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/8
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理系统</title>
</head>
<body>
<form action="/tourist_project_war_exploded/Addtravel">
    景点名称:<input type="text" name="sceneryname" ><br><br>

    景点地址:<input type="text" name="place"><br><br>
    所在城市:<input type="text" name="city"><br><br>
    景点信息:<textarea name="about" cols="30" rows="3"></textarea><br><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
