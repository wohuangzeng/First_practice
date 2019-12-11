<%@ page import="dao.Dao" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/8
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理系统</title>
</head>
<body>
<%
    String question="";
    String answer="";
    String id=request.getParameter("id");
    Dao dao = new Dao();
    ServletContext context = request.getServletContext();
    context.setAttribute("id",id);
    ResultSet res = dao.select("select * from question where id="+id);
    while(res.next()){
        question=res.getString("question");

        answer=res.getString("answer");
    }
%>
<form action="/tourist_project_war_exploded/Updatequestion">

    问题:<br><textarea name="question" cols="30" rows="6"><%=question%></textarea><br><br>
    答案:<br><textarea name="answer" cols="30" rows="6"><%=answer%></textarea><br><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
