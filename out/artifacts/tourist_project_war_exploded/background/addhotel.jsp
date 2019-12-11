<%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/8
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addhotel</title>
</head>
<body>
<form action="/tourist_project_war_exploded/Addhotel">
    酒店姓名:<input type="text" name="hotelname" ><br><br>
    酒店星级:
    <select name="star">
        <option>一星</option>
        <option>二星</option>
        <option>三星</option>
        <option>四星</option>
        <option>五星</option>
    </select><br><br>
    酒店信息:<input type="text" name="hotelmessage"><br><br>
    酒店地址:<input type="text" name="place"><br><br>
    所在城市:<input type="text" name="city"><br><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
