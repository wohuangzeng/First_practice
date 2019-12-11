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
<form action="/tourist_project_war_exploded/Addbus">
    公交车名:<input type="text" name="busname" ><br><br>

    所在城市:<input type="text" name="city"><br><br>
    公交费用:<input type="text" name="money"><br><br>
    路线信息:<br><textarea name="route" cols="30" rows="6"></textarea><br><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
