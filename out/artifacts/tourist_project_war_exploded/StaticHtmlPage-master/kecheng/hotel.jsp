<%@ page import="java.sql.Connection" %>
<%@ page import="mysqlconnect.JDBCconnect" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/9
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>酒店</title>
    <style>
        details {
            border: 1px solid #aaa;
            border-radius: 4px;
            padding: .5em .5em 0;
        }

        summary {
            font-weight: bold;
            margin: -.5em -.5em 0;
            padding: .5em;
        }

        details[open] {
            padding: .5em;
        }

        details[open] summary {
            border-bottom: 1px solid #aaa;
            margin-bottom: .5em;
        }

    </style>
</head>
<body>
<h3 >酒店列表</h3>
    <%
        try {


            Connection conn = JDBCconnect.getConnect();
            String sql = "select * from hotel";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            while (res.next()) {

                out.write("<details align=\"center\">");
                out.write("<summary>"+res.getString("hotelname")+"</summary>");
                out.write("星级:"+res.getString("star")+"<br><br>");
                out.write("酒店详细信息:"+res.getString("hotelmessage")+"<br><br>");
                out.write("酒店地址:"+res.getString("place")+"<br><br>");
                out.write("所在城市:"+res.getString("city")+"<br><br>");
                out.write("</details>");

            }
            res.close();
            pre.close();
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    %>
</body>
</html>
