<%@ page import="java.sql.Connection" %>
<%@ page import="mysqlconnect.JDBCconnect" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/8
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理系统</title>
</head>
<body>
<table border="1px" width="1000px" height="200px" cellpadding="0px" cellspacing="0px" align="center" bordercolor="blue">
    <caption><a href="addbus.jsp" target="right">增加公交</a></caption>
    <tr>
        <td width="22%" align="center">公交名称</td>
        <td width="22%" align="center">路线信息</td>
        <td width="22%" align="center">所在城市</td>
        <td width="22%" align="center">公交费用</td>
        <td width="12%" align="center">操作</td>
    </tr>


    <%
        try {
            Connection conn = JDBCconnect.getConnect();
            String sql = "select * from bus";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                out.write("<tr>");
                out.write("<td width=22% align=center>"+res.getString("busname")+"</td>");
                out.write("<td width=22% align=center>"+res.getString("route")+"</td>");
                out.write("<td width=22% align=center>"+res.getString("city")+"</td>");
                out.write("<td width=22% align=center>"+res.getString("money")+"</td>");

                out.write("<td width=12% align=center><a href=http://localhost:8080/tourist_project_war_exploded/Deletebus?id="+res.getInt("id")+">删除</a>&nbsp<a href=http://localhost:8080/tourist_project_war_exploded/background/updatebus.jsp?id="+res.getInt("id")+">更新</a></td>");
                out.write("</tr>");

            }
            res.close();
            pre.close();
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    %>
</table>
</body>
</html>
