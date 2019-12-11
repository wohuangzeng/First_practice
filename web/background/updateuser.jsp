<%@ page import="dao.Dao" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/8
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理系统</title>
    <%
        String name="";
        String password="";
        String email="";
        String sex="";
        String phone="";
        String id=request.getParameter("id");
        Dao dao = new Dao();
        ServletContext context = request.getServletContext();
        context.setAttribute("id",id);
        ResultSet res = dao.select("select * from user where id="+id);
        while(res.next()){
            name = res.getString("name");
            password= res.getString("password");
            email=res.getString("email");
            sex=res.getString("sex");
            phone=res.getString("phone");
        }
    %>
    <form action="/tourist_project_war_exploded/Updatetravel">
        姓名:<input type="text" name="username" value="<%=name%>"><br><br>
        密码:<input type="text" name="password" value="<%=password%>"><br><br>
        邮箱:<input type="email" name="email" value="<%=email%>"><br><br>
        性别:<input type="text" name="sex" value="<%=sex%>"><br><br>
        手机号码:<input type="text" name="phone" value="<%=phone%>"><br><br>
        <input type="submit" value="更改">
    </form>
</head>
<body>

</body>
</html>
