<%@ page import="java.sql.Connection" %>
<%@ page import="mysqlconnect.JDBCconnect" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: huangzeng
  Date: 2019/12/9
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公交车</title>
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
<h3 >公交车</h3>

<%
    try {
        Connection conn = JDBCconnect.getConnect();
        String sql = "select * from bus";
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet res = pre.executeQuery();
        while (res.next()) {
            out.write("<tr>");
            out.write("<details align=\"center\">");
            out.write("<summary>"+"公交名称:"+res.getString("busname")+"</summary>");
            out.write("路线信息:"+res.getString("route")+"<br><br>");
            out.write("所在城市:"+res.getString("city")+"<br><br>");
            out.write("公交费用:"+res.getString("money")+"<br><br>");

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
