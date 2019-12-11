<%@ page import="dao.Dao" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/8
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理系统</title>
    <%
        String hotelname="";
        String star="";
        String hotelmessage="";
        String place="";
        String city="";
        String id=request.getParameter("id");
        Dao dao = new Dao();
        ServletContext context = request.getServletContext();
        context.setAttribute("id",id);
        ResultSet res = dao.select("select * from hotel where id="+id);
        while(res.next()){
            hotelname = res.getString("hotelname");
            star= res.getString("hotelname");
            hotelmessage=res.getString("hotelmessage");
            place=res.getString("place");
            city=res.getString("city");
        }
    %>
    <form action="/tourist_project_war_exploded/Updatehotel">
        酒店姓名:<input type="text" name="hotelname" value="<%=hotelname%>"><br><br>
        酒店星级:
        <select name="star">
            <option>一星</option>
            <option>二星</option>
            <option>三星</option>
            <option>四星</option>
            <option>五星</option>
        </select><br><br>
        酒店信息:<input type="text" name="hotelmessage" value="<%=hotelmessage%>"><br><br>
        酒店地址:<input type="text" name="place" value="<%=place%>"><br><br>
        所在城市:<input type="text" name="city" value="<%=city%>"><br><br>
        <input type="submit" value="更改">
    </form>
</head>
<body>

</body>
</html>
