<%@ page import="mysqlconnect.JDBCconnect" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/5
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理系统</title>
</head>
<body>
<table border="1px" width="1000px" height="200px" cellpadding="0px" cellspacing="0px" align="center" bordercolor="blue">
    <caption><a href="addhotel.jsp" target="right">增加酒店</a></caption>
    <tr>
        <td width="18%" align="center">酒店姓名</td>
        <td width="18%" align="center">酒店星级</td>
        <td width="18%" align="center">酒店信息</td>
        <td width="18%" align="center">酒店地址</td>
        <td width="18%" align="center">所在城市</td>
        <td width="10%" align="center">操作</td>
    </tr>


    <%
        try {


            Connection conn = JDBCconnect.getConnect();
            String sql = "select * from hotel";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                out.write("<tr>");
                out.write("<td width=18% align=center>"+res.getString("hotelname")+"</td>");
                out.write("<td width=18% align=center>"+res.getString("star")+"</td>");
                out.write("<td width=18% align=center>"+res.getString("hotelmessage")+"</td>");
                out.write("<td width=18% align=center>"+res.getString("place")+"</td>");
                out.write("<td width=18% align=center>"+res.getString("city")+"</td>");

                out.write("<td width=10% align=center><a href=http://localhost:8080/tourist_project_war_exploded/Deletehotel?id="+res.getInt("id")+">删除</a>&nbsp<a href=http://localhost:8080/tourist_project_war_exploded/background/updatehotel.jsp?id="+res.getInt("id")+">更新</a></td>");
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
